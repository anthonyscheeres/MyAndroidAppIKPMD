package com.example.myandriodikpmdapplication.models;

import java.util.ArrayList;

public class ArchiveMetadata {

        private float created;
        private String d1;
        private String d2;
        private String dir;
        ArrayList< Object > files = new ArrayList < Object > ();
        private float files_count;
        private float item_last_updated;
        private float item_size;
        Metadata MetadataObject;
        private String server;
        private float uniq;
        ArrayList < Object > workable_servers = new ArrayList < Object > ();

    public ArchiveMetadata() {
    }

// Getter Methods

        public float getCreated() {
            return created;
        }

        public String getD1() {
            return d1;
        }

        public String getD2() {
            return d2;
        }

        public String getDir() {
            return dir;
        }

        public float getFiles_count() {
            return files_count;
        }

        public float getItem_last_updated() {
            return item_last_updated;
        }

        public float getItem_size() {
            return item_size;
        }

        public Metadata getMetadata() {
            return MetadataObject;
        }

        public String getServer() {
            return server;
        }

        public float getUniq() {
            return uniq;
        }

        // Setter Methods

        public void setCreated(float created) {
            this.created = created;
        }

        public void setD1(String d1) {
            this.d1 = d1;
        }

        public void setD2(String d2) {
            this.d2 = d2;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public void setFiles_count(float files_count) {
            this.files_count = files_count;
        }

        public void setItem_last_updated(float item_last_updated) {
            this.item_last_updated = item_last_updated;
        }

        public void setItem_size(float item_size) {
            this.item_size = item_size;
        }

        public void setMetadata(Metadata metadataObject) {
            this.MetadataObject = metadataObject;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public void setUniq(float uniq) {
            this.uniq = uniq;
        }
    }
