package com.pakbachelors.crona.model;

import java.io.Serializable;

public class Checker implements Serializable {
    private String disease;
    private String discription;
    private boolean available;
    private boolean checked;
    private int percentage;


    public Checker(String disease, String discription, boolean available, boolean checked, int percentage) {
        this.disease = disease;
        this.discription = discription;
        this.available = available;
        this.checked = checked;
        this.percentage = percentage;
    }


    public Checker() {
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

}
