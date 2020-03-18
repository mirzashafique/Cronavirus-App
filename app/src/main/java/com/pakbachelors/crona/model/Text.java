package com.pakbachelors.crona.model;

import java.io.Serializable;

public class Text implements Serializable {
    int type;
    private String mainHeading;
    private String subHeading;
    private String simpleHeading;

    public Text(int type, String mainHeading, String subHeading, String simpleHeading) {
        this.type = type;
        this.mainHeading = mainHeading;
        this.subHeading = subHeading;
        this.simpleHeading = simpleHeading;
    }

    public String getMainHeading() {
        return mainHeading;
    }

    public void setMainHeading(String mainHeading) {
        this.mainHeading = mainHeading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public String getSimpleHeading() {
        return simpleHeading;
    }

    public void setSimpleHeading(String simpleHeading) {
        this.simpleHeading = simpleHeading;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
