package com.example.myandriodikpmdapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
    ArrayList<Object> collection = new ArrayList<Object>();
    private String identifier;
    private String description;
    private String language;
    private String mediatype;
    private String scanner;
    private String title;
    private String publicdate;
    private String uploader;
    private String addeddate;

    @JsonProperty("identifier - ark")
    private String identifier_access;


    private String identifier_ark;
    private String ocr;
    private String coverleaf;
    private String backup_location;

    public Metadata() {
    }

// Getter Methods

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicdate() {
        return publicdate;
    }

    public void setPublicdate(String publicdate) {
        this.publicdate = publicdate;
    }

    // Setter Methods

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(String addeddate) {
        this.addeddate = addeddate;
    }

    public String getIdentifier_access() {
        return identifier_access;
    }

    @JsonProperty("identifier - ark")
    public void setIdentifier_access(String identifier_access) {
        this.identifier_access = identifier_access;
    }

    public String getIdentifier_ark() {
        return identifier_ark;
    }

    @JsonProperty("identifier - ark")
    public void setIdentifier_ark(String identifier_ark) {
        this.identifier_ark = identifier_ark;
    }

    public String getOcr() {
        return ocr;
    }

    public void setOcr(String ocr) {
        this.ocr = ocr;
    }

    public String getCoverleaf() {
        return coverleaf;
    }

    public void setCoverleaf(String coverleaf) {
        this.coverleaf = coverleaf;
    }

    public String getBackup_location() {
        return backup_location;
    }

    public void setBackup_location(String backup_location) {
        this.backup_location = backup_location;
    }


}
