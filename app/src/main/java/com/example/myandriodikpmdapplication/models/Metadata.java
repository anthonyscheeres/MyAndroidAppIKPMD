package com.example.myandriodikpmdapplication.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
        private String identifier;
        ArrayList < Object > collection = new ArrayList < Object > ();
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

        public String getDescription() {
            return description;
        }

        public String getLanguage() {
            return language;
        }

        public String getMediatype() {
            return mediatype;
        }

        public String getScanner() {
            return scanner;
        }

        public String getTitle() {
            return title;
        }

        public String getPublicdate() {
            return publicdate;
        }

        public String getUploader() {
            return uploader;
        }

        public String getAddeddate() {
            return addeddate;
        }

        public String getIdentifier_access() {
            return identifier_access;
        }

        public String getIdentifier_ark() {
            return identifier_ark;
        }

        public String getOcr() {
            return ocr;
        }

        public String getCoverleaf() {
            return coverleaf;
        }

        public String getBackup_location() {
            return backup_location;
        }

        // Setter Methods

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public void setMediatype(String mediatype) {
            this.mediatype = mediatype;
        }

        public void setScanner(String scanner) {
            this.scanner = scanner;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPublicdate(String publicdate) {
            this.publicdate = publicdate;
        }

        public void setUploader(String uploader) {
            this.uploader = uploader;
        }

        public void setAddeddate(String addeddate) {
            this.addeddate = addeddate;
        }

    @JsonProperty("identifier - ark")
        public void setIdentifier_access(String identifier_access) {
            this.identifier_access = identifier_access;
        }

        @JsonProperty("identifier - ark")
        public void setIdentifier_ark(String identifier_ark) {
            this.identifier_ark = identifier_ark;
        }

        public void setOcr(String ocr) {
            this.ocr = ocr;
        }

        public void setCoverleaf(String coverleaf) {
            this.coverleaf = coverleaf;
        }

        public void setBackup_location(String backup_location) {
            this.backup_location = backup_location;
        }


}
