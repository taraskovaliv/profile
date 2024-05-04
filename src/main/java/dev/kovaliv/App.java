package dev.kovaliv;

import dev.kovaliv.view.Pages;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.staticfiles.Location;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {

    public static Javalin app() {
        return Javalin.create(conf -> conf.staticFiles.add("/static", Location.CLASSPATH))
                .get("/", App::home);
    }

    private static void home(Context context) {
        context.html(Pages.getIndex(context.queryParam("lang")).render());
    }
}
