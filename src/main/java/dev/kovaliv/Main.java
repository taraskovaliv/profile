package dev.kovaliv;

import dev.kovaliv.view.Base;
import dev.kovaliv.view.Pages;
import dev.kovaliv.view.def.AbstractBasicGetNav;
import dev.kovaliv.view.def.GetNav;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class Main {
    public static void main(String[] args) {
        AppStarter.startWithoutContext(new App(), 1904);
    }

    public static class App extends AbstractApp {

        @Override
        public void addEndpoints(Javalin javalin) {
            javalin.get("/", App::home);
        }

        @Override
        protected GetNav nav() {
            return new AbstractBasicGetNav() {

                @Override
                protected Logo getLogo(String s) {
                    return new Logo(
                            "/img/logo.png", "Kovaliv DEV logo", "376", "74"
                    );
                }

                @Override
                protected boolean hasLangs() {
                    return true;
                }
            };
        }

        private static void home(Context ctx) {
            ctx.html(Base.getHtml(Pages.getIndex(ctx)));
        }
    }
}