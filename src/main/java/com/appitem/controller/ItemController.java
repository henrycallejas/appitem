package com.appitem.controller;

import com.appitem.model.Item;
import com.appitem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
public class ItemController {

    @Autowired
    ItemService service;

    @PostMapping("/item")
    public ResponseEntity<Item> insert(@RequestBody Item item){
        if(item.getItemId() != 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(service.save(item), HttpStatus.CREATED);
        }
    }

    @PutMapping("/item/{itemId}")
    public ResponseEntity<Item> update(@RequestBody Item item, @PathVariable("itemId") int itemId){
        if(service.get(itemId) != null){
            item.setItemId(itemId);
            return new ResponseEntity<>(service.update(item), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/item/{itemId}")
    public ResponseEntity<Item> deleteItem(@PathVariable("itemId") int itemId){
        if(service.get(itemId) != null){
            service.delete(itemId);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/item")
    public ResponseEntity<Item> deleteAll(){
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity getById(@PathVariable("itemId") int itemId){
        Item item = service.get(itemId);
        if(item != null){
            return new ResponseEntity<>(item, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}