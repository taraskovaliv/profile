package dev.kovaliv;

import dev.kovaliv.services.sitemap.AbstractSitemapService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static cz.jiripinkas.jsitemapgenerator.ChangeFreq.DAILY;
import static cz.jiripinkas.jsitemapgenerator.ChangeFreq.WEEKLY;

@Service
public class SitemapService extends AbstractSitemapService {
    @Override
    protected Map<String, SMValue> getUrls() {
        return Map.of(
                "/", new SMValue(1.0, WEEKLY),
                "/?lang=en", new SMValue(0.9, WEEKLY),
                "/?lang=uk", new SMValue(0.9, WEEKLY),
                "/davinchi-1-11-2024", new SMValue(0.7, DAILY)
        );
    }
}
