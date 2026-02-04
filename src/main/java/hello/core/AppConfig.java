package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//관심사의 분리 : 객체를 생성하고 연결하는 역할과 살행하는 역할이 명확히 분리
//애플리케이션 전반에 대한 운영(설정하고 구성한다)을 책임지는 거
public class AppConfig {

    public MemberService memberService() {
        //여기서 생성해서 넣어준다 "부품을 밖에서 끼워준다 = 생성자 주입"
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService  orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
