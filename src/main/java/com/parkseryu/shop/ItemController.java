package com.parkseryu.shop;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/list")
    String list(Model model) {
        var result = itemRepository.findAll();
        System.out.println(result.get(0).price);

        model.addAttribute("name", "비싼 바지");
        return "list.html";
    }
}
