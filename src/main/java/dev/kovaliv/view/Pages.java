package dev.kovaliv.view;

import io.javalin.http.Context;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.HtmlTag;
import j2html.tags.specialized.MainTag;

import static dev.kovaliv.view.Base.*;
import static j2html.TagCreator.*;

public class Pages {

    public static HtmlTag getIndex(Context ctx) {
        String lang = Base.getLang(ctx);
        if ("en".equals(lang)) {
            Base.Page EN_PAGE = new Base.Page("Kovaliv Taras profile", "Personal profile Kovaliv Taras", true, ctx);
            return Base.getPage(EN_PAGE, ctx, getHomeContent(lang));
        }
        Base.Page UK_PAGE = new Base.Page("Профіль Ковалів Тарас", "Особистий профіль Ковалів Тарас", true, ctx);
        return Base.getPage(UK_PAGE, ctx, getHomeContent(lang));
    }

    private static MainTag getHomeContent(String lang) {
        String spikeUrl = "https://link.kovaliv.dev/spike";
        String stopRuMusicUrl = "https://link.kovaliv.dev/stoprumusic";
        String electricityUrl = "https://electricity.kovaliv.dev";
        String madeInUkraine = "https://made-in-ukraine.kovaliv.dev";
        return main(
                section(
                        div(
                                div().withClasses("split-background", "d-none", "d-lg-block", "d-xl-block"),
                                div(
                                        div(
                                                div(div(
                                                        h1(
                                                                "en".equals(lang) ? "Kovaliv Taras" : "Ковалів Тарас"
                                                        ).withClasses("hs-line-10", "uppercase", "mb-30", "mb-xs-10", "wow", "fadeInUpShort")
                                                                .attr("data-wow-delay", ".1s"),
                                                        h2(
                                                                span("en".equals(lang) ? "Developing " : "Розробляю "),
                                                                span(
                                                                        span().withClass("wrap")
                                                                ).withClass("typewrite")
                                                                        .attr("data-period", "2800")
                                                                        .attr("data-type",
                                                                                "en".equals(lang) ? "[\"web-apps\", \"mobile apps\", \"services\"]" : "[\"веб-додатки\", \"мобільні застосунки\", \"сервіси\"]")
                                                                        .attr("aria-hidden", "true")
                                                        ).withClasses("hs-line-7", "mb-60", "mb-xs-40", "wow", "fadeInUpShort")
                                                                .attr("data-wow-delay", ".2s"),
                                                        div(
                                                                a(
                                                                        "en".equals(lang) ? "More" : "Детальніше"
                                                                ).withHref("#about")
                                                                        .withClasses("btn", "btn-mod", "btn-w", "btn-medium", "btn-round", "mx-md-1")
                                                        ).withClasses("local-scroll", "wow", "fadeInUpShort")
                                                                .attr("data-wow-delay", ".3s"))
                                                ).withClasses("col-lg-5", "d-flex", "align-items-center", "mb-md-60"),
                                                div(
                                                        img().withSrc("/img/profile.jpg")
                                                                .withClasses("wow", "fadeScaleIn")
                                                                .withAlt("en".equals(lang) ? "Kovaliv Taras" : "Ковалів Тарас")
                                                ).withClasses("split-image", "col-lg-6", "offset-lg-1", "d-flex", "align-items-center", "parallax")
                                                        .attr("data-offset", "20")
                                        ).withClass("row")
                                ).withClasses("home-content", "text-start"),
                                div(
                                        a(
                                                i().withClass("scroll-down-icon")
                                        ).withHref("#about").withClass("scroll-down")
                                ).withClasses("local-scroll", "scroll-down-wrap", "wow", "fadeInUpShort")
                                        .attr("data-wow-offset", "0")
                        ).withClasses("container", "min-height-100vh", "d-flex", "align-items-center", "pb-100")
                ).withId("home").withClasses("home-section", "bg-dark", "light-content"),
                pageSection(
                        div(
                                div(
                                        div(
                                                div(
                                                        div(
                                                                "en".equals(lang) ? "Java developer from Lviv" : "Java розробник зі Львова"
                                                        ).withClasses("lead-alt", "wow", "linesAnimIn").attr("data-splitting", "lines")
                                                ).withClasses("col-md-12", "col-lg-4", "mb-md-50", "mb-xs-30"),
                                                div(
                                                        "en".equals(lang) ? "Have experience in developing web sites, mobile applications and services. I learn easily and am ready to learn new technologies."
                                                                : "Маю досвід розробки веб-сайтів, мобільних додатків та сервісів. Легко навчаюсь та готовий вивчати нові технології."
                                                ).withClasses("col-md-6", "col-lg-4", "mb-sm-50", "mb-xs-30", "wow", "linesAnimIn").attr("data-splitting", "lines"),
                                                div(
                                                        "en".equals(lang) ? "Have experience in commercial development for more than 3 years. Worked in automotive and fintech sectors." :
                                                                "Досвід комерційної розробки вже більше 3 років. Працював в автомотів та фінтех сферах."
                                                ).withClasses("col-md-6", "col-lg-4", "mb-sm-50", "mb-xs-30", "wow", "linesAnimIn").attr("data-splitting", "lines")
                                        ).withClasses("row", "section-text")
                                ).withClasses("mb-140", "mb-sm-70"),
                                div(
                                        a(
                                                i().withClasses("fab", "fa-linkedin-in"),
                                                span("Linkedin profile").withClass("sr-only")
                                        ).withHref("https://link.kovaliv.dev/linkedin")
                                                .withTarget("_blank")
                                                .withStyle("text-decoration:none"),
                                        a(
                                                i().withClasses("fab", "fa-twitter"),
                                                span("Twitter profile").withClass("sr-only")
                                        ).withHref("https://link.kovaliv.dev/twitter")
                                                .withTarget("_blank")
                                                .withStyle("text-decoration:none"),
                                        a(
                                                i().withClasses("fab", "fa-github"),
                                                span("GitHub profile").withClass("sr-only")
                                        ).withHref("https://link.kovaliv.dev/github")
                                                .withTarget("_blank")
                                                .withStyle("text-decoration:none")
                                ).withClasses("footer-social-links", "mb-90", "mb-xs-40")
                        ).withClasses("container", "relative")
                ).withId("about"),
                divider(),
                pageSection(
                        div(
                                div(
                                        div(
                                                div(
                                                        h2("en".equals(lang) ? "My projects" : "Мої проєкти").withClass("section-title"),
                                                        p(
                                                                "en".equals(lang) ? "The projects I am working on" : "Проєкти над якими я працюю"
                                                        ).withClass("section-title-descr")
                                                ).withClasses("col-sm-6", "offset-sm-3")
                                        ).withClass("row")
                                ).withClasses("text-center", "mb-80", "mb-sm-50"),
                                div(
                                        div(
                                                getProjectImage("stop_ru_music.png", stopRuMusicUrl),
                                                h3(
                                                        a("STOPruMUSIC").withHref(stopRuMusicUrl)
                                                ).withClass("post-prev-title"),
                                                div(p(
                                                        "en".equals(lang) ? "Service to fight Russian music in Spotify." :
                                                                "Сервіс для боротьби з російською музикою в Spotify."
                                                )).withClass("post-prev-text"),
                                                getShowMoreButton(lang, stopRuMusicUrl)
                                        ).withClasses("col-sm-6", "col-md-4", "col-lg-4", "mb-md-50"),
                                        div(
                                                getProjectImage("spike.png", spikeUrl),
                                                h3(
                                                        a("Spike assistant").withHref(spikeUrl)
                                                ).withClass("post-prev-title"),
                                                div(p(
                                                        "en".equals(lang) ? "Mobile application for saving task lists with the ability to recognize parameters from text." :
                                                                "Мобільний застосунок для збереження списків справ з можливістю розпізнавання параметрів з тексту."
                                                )).withClass("post-prev-text"),
                                                getShowMoreButton(lang, spikeUrl)
                                        ).withClasses("col-sm-6", "col-md-4", "col-lg-4", "mb-md-50"),
                                        div(
                                                getProjectImage("electricity.png", electricityUrl),
                                                h3(
                                                        a("en".equals(lang) ? "Imort/export of electricity" : "Імпорт/експорт електроенергії").withHref(electricityUrl)
                                                ).withClass("post-prev-title"),
                                                div(p(
                                                        "en".equals(lang) ? "Web app to show statistic of import/export of electricity in Ukraine." :
                                                                "Веб-додаток для відображення статистики імпорту/експорту електроенергії в Україні."
                                                )).withClass("post-prev-text"),
                                                getShowMoreButton(lang, electricityUrl)
                                        ).withClasses("col-sm-6", "col-md-4", "col-lg-4", "mb-md-50"),
                                        div(
                                                getProjectImage("made-in-ukraine.png", madeInUkraine),
                                                h3(
                                                        a("en".equals(lang) ? "National cahback item" : "Товари програми 'Національний кешбек'").withHref(madeInUkraine)
                                                ).withClass("post-prev-title"),
                                                div(p(
                                                        "en".equals(lang) ? "Site to show items made in Ukraine and applied to National cashback." :
                                                                "Сайт для відображення товарів виготовлених в Україні та доданих до програми Національного кешбеку."
                                                )).withClass("post-prev-text"),
                                                getShowMoreButton(lang, madeInUkraine)
                                        ).withClasses("col-sm-6", "col-md-4", "col-lg-4", "mb-md-50")
                                ).withClass("row")
                        ).withClasses("container", "relative")
                ).withId("projects"),
                divider(),
                smallSection(
                        div(
                                div(
                                        div(
                                                h3("en".equals(lang) ? "Want to discuss possible cooperation ?" : "Хочете обговорити можливу співпрацю ?")
                                                        .withClass("call-action-1-heading"),
                                                div(
                                                        span("en".equals(lang) ? "Write to the email " : "Напишіть на електронну пошту "),
                                                        getEmail(),
                                                        span("en".equals(lang) ? " to discuss possible cooperation." : ", щоб обговорити можливу співпрацю.")
                                                ).withClasses("call-action-1-decription", "mb-60", "mb-sm-30")
                                        ).withClasses("col-md-8", "offset-md-2", "text-center")
                                ).withClasses("row", "wow", "fadeInUpShort")
                        ).withClasses("container", "relative")
                )
        ).withId("main");
    }

    private static DivTag getProjectImage(String image, String url) {
        return div(
                a(
                        img()
                                .withSrc("/img/" + image)
                                .withClasses("wow", "scaleOutIn")
                                .attr("data-wow-duration", "1.2s")
                ).withTabindex(-1).withHref(url)
        ).withClass("post-prev-img");
    }

    private static DivTag getShowMoreButton(String lang, String url) {
        return div(
                a("en".equals(lang) ? "View" : "Переглянути")
                        .withHref(url)
                        .withClasses("text-link")
                        .withTabindex(-1)
        ).withClasses("post-prev-more");
    }
}
