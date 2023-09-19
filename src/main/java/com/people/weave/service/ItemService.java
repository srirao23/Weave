package com.people.weave.service;

import com.people.weave.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    // Save operation
    Item saveItem(Item item);

    // Read operation
    List<Item> fetchItemList();

    // Update operation
    Item updateItem(Item item, Long itemId);

    // Delete operation
    void deleteItemById(Long itemId);
}
