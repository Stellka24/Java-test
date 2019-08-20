package com.ebay.normalization.javatest.entity;

public class MappingItem implements Comparable<MappingItem> {

    private String siteID;
    private int categoryId;
    private int catalogId;
    private String categoryName;
    private String  catalogName;
    private boolean isCatalogEnabled;
    private int vcsId;

    public MappingItem(String siteID, int catalogId) {
        this.siteID = siteID;
        this.catalogId = catalogId;
    }

    public MappingItem(String siteID, int categoryId, int catalogId, String categoryName, String catalogName, boolean isCatalogEnabled, int vcsId) {
        this.siteID = siteID;
        this.categoryId = categoryId;
        this.catalogId = catalogId;
        this.categoryName = categoryName;
        this.catalogName = catalogName;
        this.isCatalogEnabled = isCatalogEnabled;
        this.vcsId = vcsId;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isCatalogEnabled() {
        return isCatalogEnabled;
    }

    public void setCatalogEnabled(boolean catalogEnabled) {
        isCatalogEnabled = catalogEnabled;
    }

    public int getVcsId() {
        return vcsId;
    }

    public void setVcsId(int vcsId) {
        this.vcsId = vcsId;
    }

    @Override
    public int compareTo(MappingItem o) {
        return this.getCategoryId() - o.getCategoryId();
    }
}
