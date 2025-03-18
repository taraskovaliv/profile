package dev.kovaliv;

import dev.kovaliv.data.entity.Result;
import dev.kovaliv.services.SitemapService;
import dev.kovaliv.view.Base;
import dev.kovaliv.view.HelpersPage;
import dev.kovaliv.view.Pages;
import dev.kovaliv.view.def.AbstractBasicGetNav;
import dev.kovaliv.view.def.GetNav;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import static dev.kovaliv.data.Repos.resultRepo;

public class Main {
    public static void main(String[] args) {
        AppStarter.startWithoutContext(new App(), 1904, new SitemapService());
    }

    public static class App extends AbstractApp {

        @Override
        public void addEndpoints(Javalin javalin) {
            javalin
                    .get("/", App::home)
                    .get("/treads", App::treads)
                    .get("/davinchi-1-11-2024", ctx -> helpers(ctx, "davinchi-1.11.2024"));
        }

        private static void treads(@NotNull Context context) {
            resultRepo().save(new Result(context));
            context.result("Success");
        }

        @Override
        protected GetNav nav() {
            return new AbstractBasicGetNav() {

                @Override
                protected Logo getLogo(String s) {
                    return new Logo("/img/logo.png", "Kovaliv DEV logo");
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

        private static void helpers(Context ctx, String jsonFilename) {
            ctx.html(Base.getHtml(HelpersPage.getHelpers(ctx, jsonFilename)));
        }
    }
}