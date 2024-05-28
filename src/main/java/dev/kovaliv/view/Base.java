package dev.kovaliv.view;

import j2html.tags.DomContent;
import j2html.tags.Tag;
import j2html.tags.specialized.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static j2html.TagCreator.*;

public class Base {

    public static HeadTag getHead(Head head) {
        return head(
                title(head.title),
                meta().withCharset("UTF-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                meta().withName("description").withContent(head.description),
                link().withRel("shortcut icon").withHref("/img/favicon.ico"),
                link().withRel("stylesheet").withHref("/css/bootstrap.min.css"),
                link().withRel("stylesheet").withHref("/css/style.css"),
                link().withRel("stylesheet").withHref("/css/style-responsive.css"),
                link().withRel("stylesheet").withHref("/css/vertical-rhythm.min.css"),
                link().withRel("stylesheet").withHref("/css/magnific-popup.css"),
                link().withRel("stylesheet").withHref("/css/owl.carousel.css"),
                link().withRel("stylesheet").withHref("/css/animate.min.css"),
                link().withRel("stylesheet").withHref("/css/splitting.css")
        );
    }

    public record Head(String title, String description) {
    }

    public static FooterTag getFooter() {
        return footer(
                div(
                        div(
                                div(
                                        a("© Kovaliv 2024").withHref("/")
                                ).withClass("footer-copy")
                        ).withClass("footer-text")
                ).withClass("container"),
                div(
                        a(
                                i().withClass("link-to-top-icon"),
                                span("Scroll to top").withClass("sr-only")
                        )
                                .withHref("#top")
                                .withClass("link-to-top")
                ).withClass("local-scroll")
        ).withClasses("page-section", "bg-dark-lighter", "light-content", "footer", "pb-100", "pb-sm-50");
    }

    public static List<ScriptTag> getScripts() {
        return List.of(
                script().withSrc("/js/jquery.min.js"),
                script().withSrc("/js/jquery.easing.1.3.js"),
                script().withSrc("/js/bootstrap.bundle.min.js"),
                script().withSrc("/js/SmoothScroll.js"),
                script().withSrc("/js/jquery.scrollTo.min.js"),
                script().withSrc("/js/jquery.localScroll.min.js"),
                script().withSrc("/js/jquery.viewport.mini.js"),
                script().withSrc("/js/jquery.parallax-1.1.3.js"),
                script().withSrc("/js/jquery.fitvids.js"),
                script().withSrc("/js/owl.carousel.min.js"),
                script().withSrc("/js/isotope.pkgd.min.js"),
                script().withSrc("/js/imagesloaded.pkgd.min.js"),
                script().withSrc("/js/jquery.magnific-popup.min.js"),
                script().withSrc("/js/masonry.pkgd.min.js"),
                script().withSrc("/js/jquery.lazyload.min.js"),
                script().withSrc("/js/wow.min.js"),
                script().withSrc("/js/morphext.js"),
                script().withSrc("/js/typed.min.js"),
                script().withSrc("/js/all.js"),
                script().withSrc("/js/jquery.ajaxchimp.min.js"),
                script().withSrc("/js/objectFitPolyfill.min.js"),
                script().withSrc("/js/splitting.min.js"),
                script().withSrc("/js/gsap.min.js")
        );
    }

    private static DivTag getLoader(String lang) {
        String loadingText = "Завантаження...";
        if ("en".equals(lang)) {
            loadingText = "Loading...";
        }
        return div(
                div(loadingText).withClass("loader")
        ).withClasses("page-loader", "dark");
    }

    private static NavTag getNav(String lang) {
        return nav(
                div(
                        div(
                                a(
                                        img()
                                                .withSrc("/img/logo.png")
                                                .withAlt("Kovaliv DEV logo")
                                                .withWidth("376")
                                                .withHeight("74")
                                ).withHref("/").withClass("logo")
                        ).withClasses("nav-logo-wrap", "local-scroll"),
                        div(
                                i().withClasses("fa", "fa-bars"),
                                span("en".equals(lang) ? "Menu" : "Меню").withClass("sr-only")
                        ).withClass("mobile-nav").attr("role", "button").withTabindex(0),
                        div(
                                ul(
                                        li(
                                                a(
                                                        span("en".equals(lang) ? "Eng " : "Укр "),
                                                        i().withClass("mn-has-sub-icon")
                                                )
                                                        .withHref("#")
                                                        .withClass("mn-has-sub"),
                                                ul(
                                                        li(a("Українська").withHref("?lang=uk")),
                                                        li(a("English").withHref("?lang=en"))
                                                ).withClass("mn-sub")
                                        )
                                ).withClass("clearlist")
                        ).withClasses("inner-nav", "desktop-nav")
                ).withClasses("full-wrapper", "relative", "clearfix")
        ).withClasses("main-nav", "dark", "transparent", "stick-fixed", "wow-menubar");
    }

    public static HtmlTag getPage(Head head, DomContent... contents) {
        return getPage(head, "uk", contents);
    }

    public static HtmlTag getPage(Head head, String lang, DomContent... contents) {
        if (lang == null) {
            lang = "uk";
        }
        List<DomContent> contentList = new ArrayList<>();
        List<DomContent> content = new ArrayList<>();
        content.add(getNav(lang));
        content.addAll(Arrays.asList(contents));
        content.add(getFooter());
        contentList.add(getLoader(lang));
        contentList.add(a("Skip to Content").withClasses("btn", "skip-to-content").withHref("#main"));
        contentList.add(div(
                content.toArray(DomContent[]::new)
        ).withId("top").withClasses("page", "bg-dark", "light-content"));
        contentList.addAll(getScripts());
        return html(
                getHead(head),
                body(
                        contentList.toArray(DomContent[]::new)
                ).withClass("appear-animate")
        ).withLang(lang);
    }
}
