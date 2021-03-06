package org.launchcode.finalproject.controller;

import org.launchcode.finalproject.model.Inventory;
import org.launchcode.finalproject.model.InventoryData;
import org.launchcode.finalproject.model.data.InventoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by anu on 7/10/2017.
 */
@Controller
@RequestMapping(value="inventory")
public class InventoryController {

    @Autowired
    private InventoryDao inventoryDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title","Seed Inventory Manager" );
        model.addAttribute("inventory" , inventoryDao.findAll());
       // model.addAttribute("distinctCrop" , inventoryDao.getDistinctCropNames());
        //model.addAttribute("distinctpedigree" , InventoryData.getDistinctPedigreeNames());
        //model.addAttribute("distinctseason" , InventoryData.getDistinctSeasonNames());

        return "index";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String addInventoryForm(Model model){
        model.addAttribute("title", "Add New Inventory");
        model.addAttribute(new Inventory());
        return "add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String processInventoryForm(@ModelAttribute Inventory newInventory, Model model,@RequestParam String invName,
                                       @RequestParam String invPedigree,@RequestParam String invSeason,
                                       @RequestParam int invUsed,@RequestParam int invReceived){

        newInventory.setCrop(invName);
        newInventory.setPedigree(invPedigree);
        newInventory.setSeason(invSeason);
        newInventory.setUsed(invUsed);
        newInventory.setReceived(invReceived);
        newInventory.setqLeft(invReceived-invUsed);

        inventoryDao.save(newInventory);
        return "redirect:";}


    @RequestMapping(value="remove", method= RequestMethod.GET)
    public String processInventoryRemoveForm(Model model){

        model.addAttribute("title", "Remove Inventory");
        model.addAttribute("inventory" , inventoryDao.findAll());
        return "remove";}

    @RequestMapping(value="remove", method= RequestMethod.POST)
    public String processInventoryRemoveForm(@RequestParam int[] invIds){

        for (int remInvId : invIds) {

            //Inventory inv = inventoryDao.findOne(remInvId);

            inventoryDao.delete(remInvId);
        }

        return "redirect:";
    }
    @RequestMapping(value="search", method= RequestMethod.POST)
    public String searchInventory(@RequestParam String cropOptionName, Model model){

        System.out.print("cropName - "+cropOptionName);
        model.addAttribute("selectedCrop" , cropOptionName);

        return "index";

    }

}
