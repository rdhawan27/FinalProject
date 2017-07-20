package org.launchcode.finalproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by anu on 7/10/2017.
 */
@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private int invId;

    private String crop;

    private String pedigree;

    private String season;

    private int received;

    private int used;

    private int qLeft;


    public Inventory(String crop, String pedigree, String season, int received, int used, int qLeft) {
        this.crop = crop;
        this.pedigree = pedigree;
        this.season = season;
        this.received = received;
        this.used = used;
        this.qLeft=qLeft;
    }

    public Inventory(){
    }

    public void setqLeft(int qLeft) {
        this.qLeft = qLeft;
    }

    public int getqLeft() {
        return qLeft;
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