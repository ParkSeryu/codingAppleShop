package com.parkseryu.shop.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/register")
    String register() {
        return "register";
    }

    @PostMapping("/new")
    String newMember(String username, String password, String displayName) {
        memberService.saveMember(username, password, displayName);
        return "redirect:/list";
    }

}
