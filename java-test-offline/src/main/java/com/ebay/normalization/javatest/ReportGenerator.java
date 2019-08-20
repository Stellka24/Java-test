package com.ebay.normalization.javatest;

import com.ebay.normalization.javatest.entity.MappingItem;
import com.ebay.normalization.javatest.entity.SiteItem;
import com.ebay.normalization.javatest.sevice.MappingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ReportGenerator {

    @Autowired
    private MappingItemService mappingItemService;



    @EventListener(ApplicationReadyEvent.class)
    public void generateReport()  {

        StringBuilder stringBuilder = new StringBuilder();
        mappingItemService.getMappingCatalogsForSiteIds();

        ArrayList<SiteItem> successfulSiteItems = mappingItemService.getSuccessfulSiteItems();

        for (SiteItem siteItem : successfulSiteItems) {

            ArrayList<MappingItem> mappingList = siteItem.getMappingList();

            for (MappingItem mappingItem : mappingList) {
                stringBuilder.append("Site id").append(mappingItem.getSiteID()).
                        append("Catalog id").append(mappingItem.getCatalogId()).
                        append("Is mapped to category").append(mappingItem.getCategoryName()).
                        append("(").append(mappingItem.getCategoryId()).append(")");


            }
        }


        System.out.println("test");
    }
}





/*        List<Integer> siteIds = Arrays.asList(0, 2, 3, 77);
        for (Integer siteId : siteIds) {
            for (int i = 1; i < 201; i++) {
                String url = "http://localhost:8080/catalogmapping/getcatalogmapping/json/" + i + "/" + siteId;
                HttpResponse<String> httpResponse = Unirest.get(url).asString();
                JSONObject jsonObject = new JSONObject(httpResponse.getBody());
                JSONArray mappingList = jsonObject.getJSONArray("mappingList");
                for (int j = 0; j < mappingList.length(); j++) {
                    JSONObject categoryMapping = mappingList.getJSONObject(j);
                    System.out.println("SiteId " + siteId + " - Catalog " + i + " is mapped to category " + "\"" + categoryMapping.getString("categoryName") + "\" (" + categoryMapping.getInt("categoryId") + ")");
                }
            }
        }
        System.out.println("===========");
        System.out.println("Report Done");
        System.out.println("===========");*/
