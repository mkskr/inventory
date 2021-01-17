package com.mks.net.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.mks.net.exeption.ResourceNotFoundException;
import com.mks.net.model.Item;
import com.mks.net.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
     @Autowired
	 private ItemService itemService;
    
     @GetMapping
     public ResponseEntity<List<Item>> getAllItems() {
         List<Item> list = itemService.getAllItems();
         return new ResponseEntity<List<Item>>(list, new HttpHeaders(), HttpStatus.OK);
     }
  
     @GetMapping("/{id}")
     public ResponseEntity<Item> getItemById(@PathVariable("id") Long id) throws ResourceNotFoundException {
         Item item = itemService.getItemById(id);
         return new ResponseEntity<Item>(item, new HttpHeaders(), HttpStatus.OK);
     }
  
   
     
     @PostMapping
     public ResponseEntity<Item> createItem(@RequestParam("image") MultipartFile multipartFile, Item item) throws ResourceNotFoundException,IOException {
         Item created = itemService.createItem(item,multipartFile);
         return new ResponseEntity<Item>(created, new HttpHeaders(), HttpStatus.OK);
     } 
     
     @PutMapping("/{id}")
     public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long id, @RequestParam("image") MultipartFile multipartFile, Item item) throws ResourceNotFoundException,IOException {
         Item updated = itemService.updateItem(id,item,multipartFile);
         return new ResponseEntity<Item>(updated, new HttpHeaders(), HttpStatus.OK);
     }
   
     @DeleteMapping("/{id}")
     public HttpStatus deleteItemById(@PathVariable("id") Long id) throws ResourceNotFoundException {
         itemService.deleteItemById(id);
         return HttpStatus.FORBIDDEN;
     }
     
   
     
   /*
      
        @PostMapping
     public ResponseEntity<Item> createItem(@RequestBody Item item) throws ResourceNotFoundException {
         Item created = itemService.createItem(item);
         return new ResponseEntity<Item>(created, new HttpHeaders(), HttpStatus.OK);
     }
      
      
      @PostMapping
     public ResponseEntity<Item> createOrUpdateItem(Item item) throws ResourceNotFoundException {
         Item updated = itemService.createOrUpdateItem(item);
         return new ResponseEntity<Item>(updated, new HttpHeaders(), HttpStatus.OK);
     }*/
  
 }
	
	


