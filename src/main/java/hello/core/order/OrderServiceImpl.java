package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{



    //    //회원 찾아야하고
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    //할인방법
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//
//    --> 인터페이스에만 의존하는중! DIP 충족
    private final MemberRepository memberRepository;        //뒤 다 빼고
    private final DiscountPolicy discountPolicy;

    //생성자 만들고
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //주문생성 요청이 오면 회원정보를 먼저 조회를 하고 그 다음에 할인정책에다가 회원을 넘긴다

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }





 /*  섹션4. 18번 강의 //디스카운트
//    1. private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //ㄴ-> 디스카운트 방식을 RateDiscountPolicy로 바꾸자
//    2. private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //ㄴ-> DIP OCP 위반
//    3. private DiscountPolicy discountPolicy;
    //=> 구체화에 의존하지 않고 추상화인 인터페이스에만 의존합니다.
    //결과 => NullPointerException //DIP 지켰음 but 구체 클래스 없음
    //해결방법: OrderServiceImpl(현재 클래스)에 DiscountPolicy의 구현객체를 대신 생성하고 주입을 해줘야한다.
*/

}
