package com.example.myandriodikpmdapplication.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHeader {
    Params ParamsObject;
    private float status;
    private float QTime;

    public ResponseHeader() {
    }


    // Getter Methods

    public float getStatus() {
        return status;
    }

    public void setStatus(float status) {
        this.status = status;
    }

    public float getQTime() {
        return QTime;
    }

    // Setter Methods

    public void setQTime(float QTime) {
        this.QTime = QTime;
    }

    public Params getParams() {
        return ParamsObject;
    }

    public void setParams(Params paramsObject) {
        this.ParamsObject = paramsObject;
    }
}
