package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//FixDiscountPolicy 대신 다른 할인 정책을 적용하고 싶다! 해서 만든 RateDiscountPercent
//할인 금액 계산기
//할인 퍼센트 고정 = 10;
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
