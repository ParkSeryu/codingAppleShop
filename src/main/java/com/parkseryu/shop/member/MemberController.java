package com.parkseryu.shop.member;

import java.security.Principal;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/register")
    String register(Authentication auth) {
        System.out.println(auth);
        if (auth.isAuthenticated()) {
            System.out.println("???");
            return "redirect:/list";
        }

        return "register";
    }

    @PostMapping("/new")
    String newMember(String username, String password, String displayName) {
        memberService.saveMember(username, password, displayName);
        return "redirect:/list";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/my-page")
    public String mypage(Authentication auth) {
        var a = (CustomUser) auth.getPrincipal();
        System.out.println(a.displayName);
        System.out.println(auth);
        System.out.println(auth.getName());
        System.out.println(auth.isAuthenticated());
        System.out.println(auth.getAuthorities().contains(
                new SimpleGrantedAuthority("일반유저")
        )); // 권한 확인

        //if

        return "mypage";
    }

}
