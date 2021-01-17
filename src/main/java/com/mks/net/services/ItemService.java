package com.mks.net.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mks.net.exeption.ResourceNotFoundException;
import com.mks.net.model.Item;
import com.mks.net.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	private static final String FILE_LOCATION = "user-photos/";

	
	 public List<Item> getAllItems() {
         return (List<Item>) itemRepository.findAll();
     }
	 
	 public Item getItemById(Long itemId) throws ResourceNotFoundException {
		 Optional<Item> item = itemRepository.findById(itemId);
         if(item.isPresent()) {
	            return item.get();
	        } else {
	            throw new ResourceNotFoundException("Item not found for this id :: " + itemId);
	        }
	 }
	
	 
	 public Item createItem(Item itemDetail, MultipartFile file) throws ResourceNotFoundException, IOException{
		   
		   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		   String filePath = ServletUriComponentsBuilder.fromCurrentContextPath().path(FILE_LOCATION).path(fileName).toUriString();
		   itemDetail.setItemImageUrl(filePath);
		   FileUploadUtil.saveFile(FILE_LOCATION, fileName, file);
		   return itemRepository.save(itemDetail);
     } 
	 

	 public Item updateItem(Long id, Item itemDetail, MultipartFile file) throws ResourceNotFoundException,IOException{
    	
    	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    itemDetail.setItemImageUrl(fileName);
		    FileUploadUtil.saveFile(FILE_LOCATION, fileName, file);
            Item item = this.getItemById(id);
            item.setItemName(itemDetail.getItemName());
            item.setItemBrand(itemDetail.getItemBrand());
            item.setItemImageUrl(fileName);
            return itemRepository.save(item);
       } 
    
    
	
	 public void deleteItemById(Long id) throws ResourceNotFoundException 
	    {
	        Optional<Item> item = itemRepository.findById(id);
	        if(item.isPresent()) 
	        {
	        	itemRepository.deleteById(id);
	        } else {
	            throw new ResourceNotFoundException("No item record exist for given id");
	        }
	    } 
	
}
