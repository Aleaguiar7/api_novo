package com.ufpr.apiweb.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufpr.apiweb.model.Item;

@CrossOrigin
@RestController
public class ItemREST {
    public static List<Item> itemList = new ArrayList<>();

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemList;
    }

    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        itemList.add(item);
        return item;
    }
}
