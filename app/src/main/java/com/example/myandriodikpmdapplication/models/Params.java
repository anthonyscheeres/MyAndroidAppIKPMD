package com.example.myandriodikpmdapplication.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Params {
    private String query;
    private String qin;
    private String fields;
    private String wt;
    private String sort;
    private String rows;
    private float start;

    public Params() {
    }

    // Getter Methods

    public String getQuery() {
        return query;
    }

    public String getQin() {
        return qin;
    }

    public String getFields() {
        return fields;
    }

    public String getWt() {
        return wt;
    }

    public String getSort() {
        return sort;
    }

    public String getRows() {
        return rows;
    }

    public float getStart() {
        return start;
    }

    // Setter Methods

    public void setQuery(String query) {
        this.query = query;
    }

    public void setQin(String qin) {
        this.qin = qin;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public void setWt(String wt) {
        this.wt = wt;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public void setStart(float start) {
        this.start = start;
    }
}