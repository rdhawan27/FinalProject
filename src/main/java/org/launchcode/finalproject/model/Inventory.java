package org.launchcode.finalproject.model;

/**
 * Created by anu on 7/10/2017.
 */
public class Inventory {

    private int id;

    private String crop;

    private String pedigree;

    private String season;

    private String received;

    private String used;

    public Inventory(String crop, String pedigree, String season, String received, String used) {
        this.crop = crop;
        this.pedigree = pedigree;
        this.season = season;
        this.received = received;
        this.used = used;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

