package com.ebay.normalization.javatest.configuration;

import com.ebay.normalization.javatest.sevice.MappingItemService;
import com.ebay.normalization.javatest.sevice.SiteIdService;
import com.ebay.normalization.javatest.sevice.WriteService;
import handler.HttpHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")

public class MappingConfiguration {

    @Bean
    public MappingItemService getMappingService() {
        return new MappingItemService();
    }

    @Bean
    public SiteIdService getReadService(){
        return new SiteIdService();
    }

    @Bean
    public WriteService getWriteService(){
        return new WriteService();
    }

    @Bean
    public HttpHandler getHttpHandler(){
        return new HttpHandler();
    }
}
