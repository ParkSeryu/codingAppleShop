package com.parkseryu.shop;

import com.parkseryu.homework.test;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/write")
    String write() {
        return "write";

    }

    @PostMapping("/add")
    String addPost(@ModelAttribute Item item) {
        itemRepository.save(item);

        return "redirect:/list";
    }


}
