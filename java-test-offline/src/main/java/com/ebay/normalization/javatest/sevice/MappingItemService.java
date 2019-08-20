package com.ebay.normalization.javatest.sevice;

import com.ebay.normalization.javatest.entity.MappingItem;
import com.ebay.normalization.javatest.entity.SiteItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MappingItemService {

    @Value("${Nummber.of.catalogs}")
    private int numberOfCatalogs;

    @Autowired
    private SiteIdService siteIdService;

    private static Logger logger = LoggerFactory.getLogger(SiteIdService.class);

    private Map<String, Integer> failedSiteItems = new HashMap<>();
    private ArrayList<SiteItem> successfulSiteItems = new ArrayList<SiteItem>();
    private StringBuilder successfulSiteItemsSB = new StringBuilder();
    private StringBuilder failedSiteItemsSb = new StringBuilder();

    public void getMappingCatalogsForSiteIds() {

        List<String> siteIdList = siteIdService.getSiteIdListFromInputFile();

        for (String siteId : siteIdList) {
            {
                for (int catalogId = 1; catalogId < numberOfCatalogs; catalogId++) {

                    ArrayList<MappingItem> failedCatalogIds = new ArrayList<>();

                    logger.info("Get site item for siteId: " + siteId + " and catalogId: " + catalogId);
                    SiteItem siteItem = siteIdService.getSiteItem(siteId, catalogId);

                    if (siteItem == null) {
                        logger.info("Failed to retrieve site item form siteId: "+siteId+ " and catalogId: " + catalogId);
                        failedSiteItems.put(siteId, catalogId);
                        failedSiteItemsSb.append("Failed site id").
                                append(siteId).append("Category Id").
                                append(catalogId).append(System.lineSeparator());

                    } else {
                        ArrayList<MappingItem> mappingList = siteItem.getMappingList();
                        Collections.sort(mappingList);
                        logger.info("Mapping list for " + siteId + " was sorted by category Id");

                        for (MappingItem mappingItem : mappingList) {
                            successfulSiteItemsSB.append("Site id").append(mappingItem.getSiteID()).
                                    append("Catalog id").append(mappingItem.getCatalogId()).
                                    append("Is mapped to category").append(mappingItem.getCategoryName()).
                                    append("(").append(mappingItem.getCategoryId()).append(")").append(System.lineSeparator());
                        successfulSiteItems.add(siteItem);

                    }
                }
            }
        }
    }

    public Map<String, Integer> getFailedSiteItems(){
        return failedSiteItems;
    }

    public ArrayList<SiteItem> getSuccessfulSiteItems(){
        return successfulSiteItems;
    }
}