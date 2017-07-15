package org.launchcode.finalproject.controller;

import org.launchcode.finalproject.model.Inventory;
import org.launchcode.finalproject.model.InventoryData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title","Seed Inventory Manager" );
        model.addAttribute("inventory" , InventoryData.getAll());
        model.addAttribute("distinctcrop" , InventoryData.getDistinctCropNames());
        model.addAttribute("distinctpedigree" , InventoryData.getDistinctPedigreeNames());
        model.addAttribute("distinctseason" , InventoryData.getDistinctSeasonNames());

        return "index";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String addInventoryForm(Model model){
        model.addAttribute("title", "Add New Inventory");
        return "add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String processInventoryForm(@RequestParam String invName,@RequestParam String invPedigree,@RequestParam String invSeason,
                                       @RequestParam int invUsed,@RequestParam int invReceived){
        Inventory newInventory= new Inventory(invName, invPedigree,invSeason,invReceived,invUsed);
        InventoryData.add(newInventory);

        return "redirect:";
    }
    @RequestMapping(value="remove", method= RequestMethod.GET)
    public String processInventoryRemoveForm(Model model){

        model.addAttribute("title", "Remove Inventory");
        model.addAttribute("inventory" , InventoryData.getAll());
        return "remove";}

    @RequestMapping(value="remove", method= RequestMethod.POST)
    public String processInventoryRemoveForm(@RequestParam int[] invIds){

        for (int remInvId : invIds) {
            InventoryData.remove(remInvId);
        }

        return "redirect:";
    }
    @RequestMapping(value="search", method= RequestMethod.POST)
    public String searchInventory(@RequestParam String distinctcrop){

        System.out.print("cropName - "+cropoptionid);

        return cropoptionid;

    }

}
