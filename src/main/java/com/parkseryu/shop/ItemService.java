package com.parkseryu.shop;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItem() {
        return itemRepository.findAll();
    }

    public void saveItem(String title, Integer price) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }

    public void edit(String title, Integer price, Long id) throws Exception {
        if (title.length() > 100 || price < 0) {
            throw new Exception();
        }
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            item.get().setTitle(title);
            item.get().setPrice(price);
            itemRepository.save(item.get());
        }
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }


}
