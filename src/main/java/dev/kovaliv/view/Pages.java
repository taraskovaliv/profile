package dev.kovaliv.view;

import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.HrTag;
import j2html.tags.specialized.HtmlTag;
import j2html.tags.specialized.MainTag;

import static dev.kovaliv.view.BaseOld.*;
import static j2html.TagCreator.*;

public class Pages {

    public static final Base.Head HEAD_HOME_UK = new Base.Head("Профіль Ковалів Тарас", "Особистий профіль Ковалів Тарас");
    public static final Base.Head HEAD_HOME_EN = new Base.Head("Kovaliv Taras Profile", "Personal profile of Kovaliv Taras");

    public static HtmlTag getIndexOld(String lang) {
        if ("en".equals(lang)) {
            return BaseOld.getPage("Kovaliv Taras Profile", "en", getHomeContentEnOld());
        }
        return BaseOld.getPage("Профіль Ковалів Тарас", getHomeContentOld());
    }

    public static HtmlTag getIndex(String lang) {
        if ("en".equals(lang)) {
            return Base.getPage(HEAD_HOME_EN, lang, getHomeContent(lang));
        }
        if (lang == null) {
            lang = "uk";
        }
        return Base.getPage(HEAD_HOME_UK, getHomeContent(lang));
    }

    private static MainTag getHomeContent(String lang) {
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
                        ).withClasses("container", "min-height-100vh", "d-flex", "align-items-center", "pt-100", "pb-100")
                ).withId("home").withClasses("home-section", "bg-dark", "light-content"),
                section(
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
                ).withId("about").withClasses("page-section", "bg-dark", "light-content"),
                divider(),
                section(
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
                                                div(
                                                        a(
                                                                img()
                                                                        .withSrc("/img/stop_ru_music.png")
                                                                        .withClasses("wow", "scaleOutIn")
                                                                        .attr("data-wow-duration", "1.2s")
                                                        ).withTabindex(-1)
                                                                .withHref("https://link.kovaliv.dev/stoprumusic")
                                                ).withClass("post-prev-img"),
                                                h3(
                                                        a("STOPruMUSIC")
                                                                .withHref("https://link.kovaliv.dev/stoprumusic")
                                                ).withClass("post-prev-title"),
                                                div(
                                                        p(
                                                                "en".equals(lang) ? "Service to fight Russian music in Spotify." :
                                                                "Сервіс для боротьби з російською музикою в Spotify."
                                                        )
                                                ).withClass("post-prev-text"),
                                                div(
                                                        a("en".equals(lang) ? "View" : "Переглянути")
                                                                .withHref("https://link.kovaliv.dev/stoprumusic")
                                                                .withClasses("text-link")
                                                                .withTabindex(-1)
                                                ).withClasses("post-prev-more")
                                        ).withClasses("col-sm-6", "col-md-4", "col-lg-4", "mb-md-50"),
                                        div(
                                                div(
                                                        a(
                                                                img()
                                                                        .withSrc("/img/spike.png")
                                                                        .withClasses("wow", "scaleOutIn")
                                                                        .attr("data-wow-duration", "1.2s")
                                                        ).withTabindex(-1)
                                                                .withHref("https://link.kovaliv.dev/spike")
                                                ).withClass("post-prev-img"),
                                                h3(
                                                        a("Spike assistant")
                                                                .withHref("https://link.kovaliv.dev/spike")
                                                ).withClass("post-prev-title"),
                                                div(
                                                        p(
                                                                "en".equals(lang) ? "Mobile application for saving task lists with the ability to recognize parameters from text." :
                                                                "Мобільний застосунок для збереження списків справ з можливістю розпізнавання параметрів з тексту."
                                                        )
                                                ).withClass("post-prev-text"),
                                                div(
                                                        a("en".equals(lang) ? "View" : "Переглянути")
                                                                .withHref("https://link.kovaliv.dev/spike")
                                                                .withClasses("text-link")
                                                                .withTabindex(-1)
                                                ).withClasses("post-prev-more")
                                        ).withClasses("col-sm-6", "col-md-4", "col-lg-4", "mb-md-50")
                                ).withClass("row")
                        ).withClasses("container", "relative")
                ).withId("projects")
                        .withClasses("page-section", "bg-dark", "light-content"),
                divider(),
                section(
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
                ).withClasses("small-section", "bg-dark", "light-content")
        ).withId("main");
    }

    private static HrTag divider() {
        return hr().withClasses("mt-0", "mb-0", "white");
    }

    private static DivTag getHomeContentEnOld() {
        return div(
                div(
                        div(
                                h2("My projects"),
                                ul(
                                        li(div(
                                                h3("STOPruMUSIC"),
                                                p("Service to fight Russian music in Spotify."),
                                                a("View")
                                                        .withClasses("btn", "btn-primary")
                                                        .withHref("https://link.kovaliv.dev/stoprumusic")
                                        )),
                                        li(div(
                                                h3("Spike assistant"),
                                                p("Mobile application for saving task lists with the ability to recognize parameters from text."),
                                                a("View")
                                                        .withClasses("btn", "btn-primary")
                                                        .withHref("https://link.kovaliv.dev/spike")
                                        ))
                                ).withClass("projects")
                        ).withClass("block"),
                        div(
                                h2("Contacts"),
                                p("If you have any questions or suggestions, please write to the email:"),
                                getEmail()
                        )
                                .withClass("block"),
                        div(
                                h2("Social networks"),
                                div(
                                        ul(
                                                li(a().withHref("https://link.kovaliv.dev/twitter").with(i().withClasses("fa", "fa-twitter").attr("aria-hidden", "true"))),
                                                li(a().withHref("https://link.kovaliv.dev/linkedin").with(i().withClasses("fa", "fa-linkedin").attr("aria-hidden", "true"))),
                                                li(a().withHref("https://link.kovaliv.dev/github").with(i().withClasses("fa", "fa-github").attr("aria-hidden", "true")))
                                        ).withClass("social")
                                ).withId("social-div")
                        )
                                .withClass("block")
                ).withClass("content"),
                hr(),
                div(
                        div(
                                h3("And don't forget to donate for Ukraine's victory"),
                                getSaveLive()
                        ).withClass("block")
                ).withClass("content")
        );
    }

    private static DivTag getHomeContentOld() {
        return div(
                div(
                        div(
                                h2("Мої проєкти"),
                                ul(
                                        li(div(
                                                h3("STOPruMUSIC"),
                                                p("Сервіс для боротьби з російською музикою в Spotify."),
                                                a("Переглянути")
                                                        .withClasses("btn", "btn-primary")
                                                        .withHref("https://link.kovaliv.dev/stoprumusic")
                                        )),
                                        li(div(
                                                h3("Spike assistant"),
                                                p("Мобільний застосунок для збереження списків справ з можливістю розпізнавання параметрів з тексту."),
                                                a("Переглянути")
                                                        .withClasses("btn", "btn-primary")
                                                        .withHref("https://link.kovaliv.dev/spike")
                                        ))
                                ).withClass("projects")
                        ).withClass("block"),
                        div(
                                h2("Контакти"),
                                p("Маєте питання або пропозиції пишіть на емейл:"),
                                getEmail()
                        )
                                .withClass("block"),
                        div(
                                h2("Соціальні мережі"),
                                div(
                                        ul(
                                                li(a().withHref("https://link.kovaliv.dev/twitter").with(i().withClasses("fa", "fa-twitter").attr("aria-hidden", "true"))),
                                                li(a().withHref("https://link.kovaliv.dev/linkedin").with(i().withClasses("fa", "fa-linkedin").attr("aria-hidden", "true"))),
                                                li(a().withHref("https://link.kovaliv.dev/github").with(i().withClasses("fa", "fa-github").attr("aria-hidden", "true")))
                                        ).withClass("social")
                                ).withId("social-div")
                        )
                                .withClass("block")
                ).withClass("content"),
                hr(),
                div(
                        div(
                                h3("І не забуваємо донатити задля перемоги України"),
                                getSaveLive()
                        ).withClass("block")
                ).withClass("content")
        );
    }
}
