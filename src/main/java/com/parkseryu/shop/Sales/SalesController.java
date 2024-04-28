package com.parkseryu.shop.Sales;

import com.parkseryu.shop.member.CustomUser;
import com.parkseryu.shop.member.Member;
import com.parkseryu.shop.member.MemberRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class SalesController {
    private final SalesRepository salesRepository;
    private final MemberRepository memberRepository; // MemberRepository 주입

    @PostMapping("/order")
    String order(String title, Integer price, Integer count, Long memberId, Authentication auth) {
        Sales sales = new Sales();
        sales.setItemName(title);
        sales.setPrice(price);
        sales.setCount(count);
        CustomUser user = (CustomUser) auth.getPrincipal();
        Member member = memberRepository.findById(user.id).orElseThrow(IllegalArgumentException::new); // Member 조회
        sales.setMember(member); // Member 설정
        salesRepository.save(sales);
        return "redirect:/detail/" + memberId;
    }

    @GetMapping("/order/all")
    String getOrderAll() {
        List<Sales> result = salesRepository.customFindAll();
        System.out.println(result);
        var result2 = memberRepository.findById(1L);
        System.out.println(result2);

        var salesDto = new SalesDto();
        return "list.html";
    }
}

class SalesDto {

    public String itemName;
    public Integer price;
    public String username;
}