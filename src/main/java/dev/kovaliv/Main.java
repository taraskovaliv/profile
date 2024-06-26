package dev.kovaliv;

import lombok.extern.log4j.Log4j2;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Log4j2
public class Main {
    public static void main(String[] args) {
        LocalDateTime start = now();
        App.app().start(1904);
        log.info("App started in {} seconds", Duration.between(start, now()).getSeconds());
    }
}