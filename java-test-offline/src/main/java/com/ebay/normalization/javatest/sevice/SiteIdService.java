package com.ebay.normalization.javatest.sevice;

import com.ebay.normalization.javatest.entity.SiteItem;
import handler.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Service
public class SiteIdService {

    @Value("${Input.file.path}")
    private String fileName;

    @Autowired
    private HttpHandler httpHandler;

    private static Logger logger = LoggerFactory.getLogger(SiteIdService.class);


    public SiteItem getSiteItem(String siteId, int catalogId) {
        return httpHandler.getSiteItem(siteId, catalogId);
    }

    public List<String> getSiteIdListFromInputFile()  {
        logger.info("Get SiteId list from input file: "+ fileName);

        String fileContent = readSiteIdsFromInput();
        return Arrays.asList(fileContent.split(","));
    }





    private String readSiteIdsFromInput() {

        Resource resource = new ClassPathResource(fileName);
        try {
            InputStream inputStream = resource.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            return new String(bytes, StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
