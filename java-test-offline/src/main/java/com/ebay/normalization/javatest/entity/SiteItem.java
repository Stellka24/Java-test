package com.ebay.normalization.javatest.entity;

import java.util.ArrayList;
import java.util.List;

public class SiteItem {

    private int invocationId;
    private String responseStatus;
    private List<String> errors;
    private ArrayList<MappingItem> mappingList;

    public SiteItem(int invocationId, String responseStatus, List<String> errors, ArrayList<MappingItem> mappingList) {
        this.invocationId = invocationId;
        this.responseStatus = responseStatus;
        this.errors = errors;
        this.mappingList = mappingList;
    }

    public int getInvocationId() {
        return invocationId;
    }

    public void setInvocationId(int invocationId) {
        this.invocationId = invocationId;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public ArrayList<MappingItem> getMappingList() {
        return mappingList;
    }

    public void setMappingList(ArrayList<MappingItem> mappingList) {
        this.mappingList = mappingList;
    }
}
