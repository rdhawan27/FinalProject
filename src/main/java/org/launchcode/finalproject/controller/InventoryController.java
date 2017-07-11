package org.launchcode.finalproject.controller;

import org.launchcode.finalproject.model.Inventory;
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
    static ArrayList<Inventory>inventory = new ArrayList<>();

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title","Seed Inventory Manager" );
        model.addAttribute("inventory" , inventory);
        return "index";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String addInventoryForm(Model model){
        model.addAttribute("title", "Add New Inventory");
        return "add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String processInventoryForm(@RequestParam String invName,@RequestParam String invPedigree,@RequestParam String invSeason,
                                       @RequestParam String invUsed,@RequestParam String invReceived ){
        Inventory newInventory= new Inventory(invName, invPedigree,invSeason,invReceived,invUsed);
        inventory.add(newInventory);

        return "redirect:";
    }

}
