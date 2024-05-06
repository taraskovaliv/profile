package dev.kovaliv.view;

import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.HtmlTag;

import static dev.kovaliv.view.Base.*;
import static j2html.TagCreator.*;

public class Pages {

    public static HtmlTag getIndex(String lang) {
        if (lang != null && lang.equals("en")) {
            return getPage("Kovaliv Taras Profile", getHomeContentEn());
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
                                                a("View").withHref("https://stoprumusic.kovaliv.dev")
                                        )),
                                        li(div(
                                                h3("Spike assistant"),
                                                p("Mobile application for saving task lists with the ability to recognize parameters from text."),
                                                a("View").withHref("https://spike-ua.com")
                                        ))
                                ).withClass("projects")
                        ).withClass("home-text"),
                        div(
                                h2("Contacts"),
                                p("If you have any questions or suggestions, please write to the email:"),
                                getEmail()
                        )
                                .withClass("home-text"),
                        div(
                                h2("Social networks"),
                                div(
                                        ul(
                                                li(a().withHref("https://twitter.com/taras_kovaliv").with(i().withClasses("fa", "fa-twitter").attr("aria-hidden", "true"))),
                                                li(a().withHref("https://www.linkedin.com/in/kovalivtaras").with(i().withClasses("fa", "fa-linkedin").attr("aria-hidden", "true"))),
                                                li(a().withHref("https://github.com/taraskovaliv").with(i().withClasses("fa", "fa-github").attr("aria-hidden", "true")))
                                        ).withClass("social")
                                ).withId("social-div")
                        )
                                .withClass("home-text")
                ).withClass("content"),
                hr(),
                div(
                        div(
                                h3("And don't forget to donate for Ukraine's victory"),
                                getSaveLive()
                        ).withClass("home-text")
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
                                                a("Переглянути").withHref("https://stoprumusic.kovaliv.dev")
                                        )),
                                        li(div(
                                                h3("Spike assistant"),
                                                p("Мобільний застосунок для збереження списків справ з можливістю розпізнавання параметрів з тексту."),
                                                a("Переглянути").withHref("https://spike-ua.com")
                                        ))
                                ).withClass("projects")
                        ).withClass("home-text"),
                        div(
                                h2("Контакти"),
                                p("Маєте питання або пропозиції пишіть на емейл:"),
                                getEmail()
                        )
                                .withClass("home-text"),
                        div(
                                h2("Соціальні мережі"),
                                div(
                                        ul(
                                                li(a().withHref("https://twitter.com/taras_kovaliv").with(i().withClasses("fa", "fa-twitter").attr("aria-hidden", "true"))),
                                                li(a().withHref("https://www.linkedin.com/in/kovalivtaras").with(i().withClasses("fa", "fa-linkedin").attr("aria-hidden", "true"))),
                                                li(a().withHref("https://github.com/taraskovaliv").with(i().withClasses("fa", "fa-github").attr("aria-hidden", "true")))
                                        ).withClass("social")
                                ).withId("social-div")
                        )
                                .withClass("home-text")
                ).withClass("content"),
                hr(),
                div(
                        div(
                                h3("І не забуваємо донатити задля перемоги України"),
                                getSaveLive()
                        ).withClass("home-text")
                ).withClass("content")
        );
    }
}
