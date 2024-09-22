package dev.kovaliv.services;

import dev.kovaliv.services.sitemap.AbstractSitemapService;

import java.util.Map;

import static cz.jiripinkas.jsitemapgenerator.ChangeFreq.WEEKLY;

public class SitemapService extends AbstractSitemapService {

    @Override
    protected Map<String, SMValue> getUrls() {
        return Map.of(
                "/", new SMValue(1.0, WEEKLY),
                "/?lang=en", new SMValue(0.9, WEEKLY),
                "/?lang=uk", new SMValue(0.9, WEEKLY)
        );
    }
}
