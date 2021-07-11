package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OderServiceImpl;
import hello.core.order.OrderService;

//애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악가능
//역할을 세우고 구현이 그 안에 들어가도록. 중복제거.
public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
