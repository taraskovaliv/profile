package dev.kovaliv.data;

import dev.kovaliv.data.repo.ResultRepo;

import static dev.kovaliv.config.ContextConfig.context;

public class Repos {
    public static ResultRepo resultRepo() {
        return context().getBean(ResultRepo.class);
    }
}
