package com.parkseryu.shop;

import com.parkseryu.homework.test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    private final ItemRepository itemRepository;
    private final HomeWorkRepository homeWorkRepository;

    public ItemController(ItemRepository itemRepository, HomeWorkRepository homeWorkRepository) {
        this.itemRepository = itemRepository;
        this.homeWorkRepository = homeWorkRepository;
    }

    @GetMapping("/list")
    String list(Model model) {
        var result = itemRepository.findAll();

        model.addAttribute("items", result);

        var result2 = homeWorkRepository.findAll();
        model.addAttribute("homeWorks", result2);

        var homework = new test();
        homework.addAge();
        homework.changeAge(12);
        homework.changeAge(-10);

        return "list";
    }
}
