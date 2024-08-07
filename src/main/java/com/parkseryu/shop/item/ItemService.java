package com.parkseryu.shop.item;

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
        int x = 2;
        int y = 5;
        char c = 'A'; // 'A'의 아스키 코드는 65

        System.out.println(1 + x << 33);
        System.out.println(y >= 5 || x < 0 && x > 2);
        System.out.println(y += 10 - x++);
        System.out.println(x += 2);
        System.out.println(!('A' <= c && c <= 'Z'));
        System.out.println('C' - c);
        System.out.println('5' - '0');
        System.out.println(c + 1);
        System.out.println(++c);
        System.out.println(c++);
        System.out.println(c);
        
        return itemRepository.findAll();
    }

    public void saveItem(String title, Integer price, String whoName) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        item.setWho(whoName);
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

    public Item delete(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(IllegalAccessError::new);
        itemRepository.deleteById(id);
        return item;
    }


}
