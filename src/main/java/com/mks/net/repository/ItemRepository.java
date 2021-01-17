package com.mks.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mks.net.model.Item;
public interface ItemRepository extends JpaRepository<Item,Long>{}

