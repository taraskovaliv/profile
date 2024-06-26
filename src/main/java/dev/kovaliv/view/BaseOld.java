package dev.kovaliv.view;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;
import j2html.tags.specialized.ATag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HtmlTag;

import java.util.Arrays;

import static j2html.TagCreator.*;
import static java.lang.System.getenv;

public class BaseOld {

    public static HeadTag getHead(String title) {
        return head(
                meta().withCharset("UTF-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                link().withRel("stylesheet").withHref("/css/main.css?1.9"),
                link().withRel("stylesheet").withHref("/css/profile.css?1.0"),
                link().withRel("stylesheet").withHref("/css/icons.min.css"),
                link().withRel("preconnect").withHref("https://fonts.macpaw.com").attr("crossorigin"),
                link().withRel("stylesheet").withHref("https://fonts.macpaw.com/css?family=FixelDisplay:300"),
                link().withRel("stylesheet").withHref("https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"),
                link().withRel("icon").withType("image/x-icon").withHref("/img/favicon.ico"),
                script().withSrc("https://plausible.kovaliv.dev/js/script.js")
                        .attr("defer")
                        .attr("defer")
                        .attr("data-domain", "kovaliv.dev"),
                title(title)
        );
    }

    public static DivTag getNavBar() {
        return div(
                div(
                        a("Taras Kovaliv").withHref("/")
                ).withClass("logo"),
                div(
                        a("UA")
                                .withHref("?lang=uk")
                                .withClass("btn-link")
                                .withStyle("display:block; padding: 5px; font-size: 1em"),
                        a("EN")
                                .withHref("?lang=en")
                                .withClass("btn-link")
                                .withStyle("display:block; padding: 5px; font-size: 1em")
                ).withClass("lang")
        ).withClasses("header");
    }

    public static DivTag getFooter() {
        return div(
                hr(),
                div("©2024 kovaliv.dev")
        ).withClass("text-center");
    }

    public static HtmlTag getPage(String title, DomContent... contents) {
        return getPage(title, "uk", contents);
    }

    public static HtmlTag getPage(String title, String lang, DomContent... contents) {
        return html(
                getHead(title),
                body(
                        getNavBar(),
                        hr(),
                        each(Arrays.asList(contents), c -> c),
                        getFooter()
                )
        ).withLang(lang);
    }

    public static ATag getEmail() {
        return a(getenv("EMAIL"))
                .withClass("btn-link")
                .withHref("mailto:" + getenv("EMAIL"));
    }

    public static DivTag getSaveLive() {
        return div(
                getSaveLiveLogo(),
                getSaveLiveButton()
        ).withClass("cba");
    }

    public static ATag getSaveLiveLogo() {
        return a(
                img().withSrc("https://savelife.in.ua/wp-content/themes/savelife/assets/images/new-logo-black-ua.svg")
                        .withAlt("SaveLife")
        ).withHref("https://link.kovaliv.dev/savelife").withClass("cba-logo");
    }

    public static ATag getSaveLiveButton() {
        return a(
                span(
                        new SvgTag().withStyle("transform: scale(0.95)")
                                .attr("width", "19")
                                .attr("height", "20")
                                .attr("viewBox", "0 0 19 20")
                                .attr("fill", "none")
                                .attr("xmlns", "http://www.w3.org/2000/svg")
                                .with(new PathTag()
                                        .attr("d", "M16.6159 7.98068L9.25075 17.7431L1.8856 7.98068L1.88557 7.98064C0.522531 6.17413 0.756095 3.66224 2.42693 2.135L2.42702 2.13492C3.33721 1.30274 4.56887 0.898143 5.79348 1.02191L5.79514 1.02207C6.84144 1.12605 7.806 1.60704 8.52511 2.36538L9.25074 3.13058L9.97636 2.36538C10.6946 1.60793 11.667 1.12601 12.7069 1.02201L12.7075 1.02196C13.94 0.898051 15.164 1.30246 16.0745 2.13492L16.076 2.13631C17.7532 3.66341 17.9862 6.17312 16.6173 7.97881L16.6159 7.98068Z")
                                        .attr("stroke", "white")
                                        .attr("stroke-width", "2"))
                ).withClass("icon"),
                span("ПІДТРИМАТИ").withClass("text")
        )
                .withClass("btn-heart")
                .withHref("https://link.kovaliv.dev/savelife_donate");
    }

    static class PathTag extends ContainerTag<PathTag> {
        protected PathTag() {
            super("path");
        }
    }

    static class SvgTag extends ContainerTag<SvgTag> {
        protected SvgTag() {
            super("svg");
        }
    }
}
