package org.launchcode.finalproject.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by anu on 7/12/2017.
 */
public class InventoryData {
    static ArrayList<Inventory>inventory = new ArrayList<>();

    static Set<String> distinctCropNames = new HashSet<String>();
    static Set<String> distinctPedigreeNames = new HashSet<String>();
    static Set<String> distinctSeasonNames = new HashSet<String>();

    public static Set<String> getDistinctCropNames() {
        for (Inventory candidateInventory : inventory) {
            distinctCropNames.add(candidateInventory.getCrop());
        }
        return distinctCropNames;
    }

    public static Set<String> getDistinctPedigreeNames() {
        for (Inventory candidateInventory : inventory) {
            distinctPedigreeNames.add(candidateInventory.getPedigree());
        }

        return distinctPedigreeNames;
    }

    public static Set<String> getDistinctSeasonNames() {
        for (Inventory candidateInventory : inventory) {
            distinctSeasonNames.add(candidateInventory.getSeason());
        }

        return distinctSeasonNames;
    }

    // getAll
    public static ArrayList<Inventory> getAll() {
        return inventory;
    }

    // add
    public static void add(Inventory newInventory) {
        inventory.add(newInventory);
    }

    // getById
    public static Inventory getById(int id) {

        Inventory theInventory = null;

        for (Inventory candidateInventory : inventory) {
            if (candidateInventory.getInvId() == id) {
                theInventory = candidateInventory;
            }
        }



        return theInventory;
    }
    // remove
    public static void remove(int id) {
        Inventory inventoryToRemove = getById(id);
        inventory.remove(inventoryToRemove);
    }
}
