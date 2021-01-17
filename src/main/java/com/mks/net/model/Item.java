package com.mks.net.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private String itemName;
	private String itemBrand;
	@CreationTimestamp
	private LocalDateTime itemCreated;
	@UpdateTimestamp
	private LocalDateTime itemUpdated;
	private String itemImageUrl;
	public Item() {}
	public Item(String itemName, String itemBrand,String itemImageUrl) {
		super();
	    this.itemName = itemName;
		this.itemBrand = itemBrand;
	    this.itemImageUrl = itemImageUrl;
	}
	public long geItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemBrand() {
		return itemBrand;
	}
	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
	public LocalDateTime getItemCreated() {
		return itemCreated;
	}
	public void setItemCreated(LocalDateTime itemCreated) {
		this.itemCreated = itemCreated;
	}
	public LocalDateTime getItemUpdated() {
		return itemUpdated;
	}
	public void setItemUpdated(LocalDateTime itemUpdated) {
		this.itemUpdated = itemUpdated;
	}
	public String getItemImageUrl() {
		return itemImageUrl;
	}
	public void setItemImageUrl(String itemImageUrl) {
		this.itemImageUrl = itemImageUrl;
	}
	
	
	
	

}
