package com.people.weave.service;

import com.people.weave.entity.Item;
import com.people.weave.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository ItemRepository;

    // Save operation
    @Override
    public Item saveItem(Item item)
    {
        return ItemRepository.save(item);
    }

    // Read operation
    @Override public List<Item> fetchItemList()
    {
        return (List<Item>)
                ItemRepository.findAll();
    }

    // Update operation
    @Override
    public Item
    updateItem(Item item,
               Long itemId)
    {
        Item itemDB
                = ItemRepository.findById(itemId)
                .get();

        if (Objects.nonNull(item.getItemName())
                && !"".equalsIgnoreCase(
                item.getItemName())) {
            itemDB.setItemName(
                    item.getItemName());
        }

        if (Objects.nonNull(
                item.getItemDesc())
                && !"".equalsIgnoreCase(
                item.getItemDesc())) {
            itemDB.setItemDesc(
                    item.getItemDesc());
        }

        if (item.getItemCount()>0) {
            itemDB.setItemCount(
                    item.getItemCount());
        }

        return ItemRepository.save(itemDB);
    }

    // Delete operation
    @Override
    public void deleteItemById(Long ItemId)
    {
        ItemRepository.deleteById(ItemId);
    }
}
