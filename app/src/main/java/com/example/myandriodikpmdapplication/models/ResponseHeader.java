package com.example.myandriodikpmdapplication.models;

public class ResponseHeader {
        private float status;
        private float QTime;
        Params ParamsObject;


        // Getter Methods

        public float getStatus() {
            return status;
        }

        public float getQTime() {
            return QTime;
        }

        public Params getParams() {
            return ParamsObject;
        }

        // Setter Methods

        public void setStatus(float status) {
            this.status = status;
        }

        public void setQTime(float QTime) {
            this.QTime = QTime;
        }

        public void setParams(Params paramsObject) {
            this.ParamsObject = paramsObject;
        }
    }
