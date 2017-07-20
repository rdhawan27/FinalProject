package org.launchcode.finalproject.model.data;

import org.launchcode.finalproject.model.Inventory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * Created by anu on 7/17/2017.
 */
@Repository
@Transactional
public interface InventoryDao extends CrudRepository<Inventory, Integer> {

//    @Query("SELECT DISTINCT crop FROM inventory")
    public ArrayList<Inventory> findDistinctInventory();
}