package com.parkseryu.shop;

import com.parkseryu.homework.test;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
    String list(Model model) {
        var result = itemService.getItem();
        model.addAttribute("items", result);
        return "list";
    }

    @GetMapping("/write")
    String write() {
        return "write";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price) {

        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    @PostMapping("/edit")
    String patchItem(String title, Integer price, Long id) throws Exception {
        itemService.edit(title, price, id);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Item> result = itemService.getItemById(id);
        if (result.isPresent()) {
            model.addAttribute("result", result.get());
            return "detail";
        } else {
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        Optional<Item> result = itemService.getItemById(id);
        if (result.isPresent()) {
            model.addAttribute("result", result.get());
            return "edit";
        } else {
            return "redirect:/list";
        }
    }
}
