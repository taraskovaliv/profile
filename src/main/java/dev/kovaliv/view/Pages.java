package dev.kovaliv.view;

import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.HtmlTag;

import static dev.kovaliv.view.Base.*;
import static j2html.TagCreator.*;

public class Pages {

    public static HtmlTag getIndex(String lang) {
        if (lang != null && lang.equals("en")) {
            return getPage("Kovaliv Taras Profile", "en", getHomeContentEn());
        }
        return getPage("Профіль Ковалів Тарас", getHomeContent());
    }

    private static DivTag getHomeContentEn() {
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

    private static DivTag getHomeContent() {
        return div(
                div(
                        div(
                                h2("Мої проекти"),
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
