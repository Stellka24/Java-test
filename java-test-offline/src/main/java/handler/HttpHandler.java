package handler;


import com.ebay.normalization.javatest.entity.SiteItem;
import com.ebay.normalization.javatest.sevice.SiteIdService;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


public class HttpHandler {

    @Value("${Catalog.mapping.url}")
    private String mappingItemBaseUrl;

    private static final String DELIMITER = "/";
    private static Logger LOGGER = LoggerFactory.getLogger(SiteIdService.class);


    public SiteItem getSiteItem(String siteId, int catalogId) {

        String mappingItemFullUrl = mappingItemBaseUrl + DELIMITER + catalogId + DELIMITER + siteId;

        HttpResponse<String> httpResponse = null;
        try {
            LOGGER.info("Sending GET request: " + mappingItemFullUrl);
            httpResponse = Unirest.get(mappingItemFullUrl).asString();
        } catch (UnirestException e) {
            LOGGER.error("Exception occurred! "+ e.getMessage(), e);
        }

        if (httpResponse.getStatus() != 200)
            return null;

        return new Gson().fromJson(httpResponse.getBody(), SiteItem.class);
    }
}
