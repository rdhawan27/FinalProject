package org.launchcode.finalproject.model;

/**
 * Created by anu on 7/10/2017.
 */
public class Inventory {

    private int invId;

    private String crop;

    private String pedigree;

    private String season;

    private int received;

    private int used;

    private static int nextId=1;



    public Inventory(String crop, String pedigree, String season, int received, int used ) {
        invId=nextId;
        nextId+=1;
        this.crop = crop;
        this.pedigree = pedigree;
        this.season = season;
        this.received = received;
        this.used = used;
    }

    public Inventory(int invId){
        invId=nextId;
        nextId+=1;
    }
    public int getRemainingQuantity(){
        return this.getReceived()- this.getUsed();
    }
    public int getInvId() {
        return invId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
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

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }
}