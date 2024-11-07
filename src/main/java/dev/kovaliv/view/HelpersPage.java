package dev.kovaliv.view;

import dev.kovaliv.utils.GsonUtils;
import io.javalin.http.Context;
import j2html.tags.DomContent;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.HtmlTag;
import j2html.tags.specialized.SectionTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;
import static java.lang.Thread.currentThread;
import static java.util.Objects.requireNonNull;

@Log4j2
public class HelpersPage {

    public static HtmlTag getHelpers(Context ctx, String jsonFilename) {
        HelperPage helperPage = parseHelperPage(jsonFilename);
        helperPage.getHelpers().sort((a, b) -> b.wage.compareTo(a.wage));

        return Base.getPage(
                new Base.Page(helperPage.title, "Лінк на збір: " + helperPage.url, false, true, ctx),
                new Base.BasicHeader("Дякую всім, хто допомагав зі збором",
                        "Проекти/сайти/сторінки тих людей, що допомогли зібрати кошти на збір:\n'%s'\n\nЛінк на збір: %s".formatted(helperPage.title, helperPage.url),
                        null),
                ctx, getHelpers(helperPage.helpers));
    }

    public static SectionTag getHelpers(List<Helper> helpers) {
        return section(div(
                div(each(helpers, HelpersPage::getHelperBlock))
                        .withClasses("row", "masonry")
        ).withClasses("container", "relative").withStyle("padding-top: 60px;"));
    }

    private static DivTag getHelperBlock(Helper helper) {
        assert helper != null;
        assert helper.getTitle() != null;
        assert helper.getUrl() != null;

        List<DomContent> content = new ArrayList<>();

        content.add(h3(a(helper.getTitle())
                .withHref(helper.getUrl()))
                .withClasses("post-prev-title"));
        if (helper.name != null && !helper.name.isBlank()
                && helper.social != null && !helper.social.isBlank()) {
            content.add(div(a(helper.getName())
                    .withHref(helper.getSocial()))
                    .withClasses("post-prev-info"));
        }
        if (helper.description != null && !helper.description.isBlank()) {
            content.add(div(helper.getDescription())
                    .withClasses("post-prev-text"));
        }
        content.add(div(a("Дізнатись більше")
                .withHref(helper.getUrl())
                .withClass("text-link")
                .withTabindex(-1))
                .withClasses("post-prev-more"));

        return div(
                content.toArray(DomContent[]::new)
        ).withClasses("col-sm-6", "col-md-4", "mb-10", "mb-xs-30")
                .withStyle("border: 1px dashed #e0e0e0; padding: 15px; border-radius: 5px");
    }

    private static HelperPage parseHelperPage(String jsonFilename) {
        try (InputStream json = currentThread()
                .getContextClassLoader()
                .getResourceAsStream("helpers/" + jsonFilename + ".json")) {

            return GsonUtils.gson().fromJson(new InputStreamReader(requireNonNull(json)), HelperPage.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HelperPage {
        private String title;
        private String url;
        private List<Helper> helpers;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Helper {
        private String title;
        private String description;
        private String url;
        private String name;
        private String social;
        private Integer wage;
    }
}
