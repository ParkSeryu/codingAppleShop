package com.parkseryu.shop.member;

import java.security.Principal;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @GetMapping("/register")
    String register(Authentication auth) {
        System.out.println(auth);
        if (auth != null && auth.isAuthenticated()) {
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

    @PostMapping("/login/jwt")
    @ResponseBody
    public String loginJWT(@RequestBody Map<String, String> data) {

        var authToken = new UsernamePasswordAuthenticationToken(
                data.get("username"), data.get("password")
        );
        var auth = authenticationManagerBuilder.getObject().authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return "";
    }

}

class MemberDto {
    public String username;
    public String displayName;

    public MemberDto(String username, String displayName) {
        this.username = username;
        this.displayName = displayName;
    }
}
