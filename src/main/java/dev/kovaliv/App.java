package dev.kovaliv;

import dev.kovaliv.view.Pages;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.staticfiles.Location;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.atomic.AtomicReference;

import static dev.kovaliv.view.Base.getDocType;

@Log4j2
public class App {
    public static Javalin app() {
        return Javalin.create(conf -> conf.staticFiles.add("/static", Location.CLASSPATH))
                .get("/", App::home)
                .get("/old", App::homeOld);
    }

    private static void home(Context context) {
        context.html(getDocType() + Pages.getIndex(getLang(context)).render());
    }

    private static void homeOld(Context context) {
        context.html(getDocType() + Pages.getIndexOld(getLang(context)).render());
    }

    private static String getLang(Context context) {
        String lang = context.queryParam("lang");
        if (lang == null) {
            lang = context.sessionAttribute("lang");
        } else {
            context.sessionAttribute("lang", lang);
        }
        if (lang == null) {
            AtomicReference<String> acceptLanguage = new AtomicReference<>();
            context.headerMap().forEach((key, value) -> {
                if (key.equalsIgnoreCase("accept-language")) {
                    acceptLanguage.set(value);
                }
            });
            if (acceptLanguage.get() != null) {
                lang = acceptLanguage.get().substring(0, 2);
            }
        }
        if (lang == null) {
            lang = "uk";
        }
        return lang;
    }
}
