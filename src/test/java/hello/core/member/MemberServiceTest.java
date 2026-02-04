package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//관심사 분리로 여기도 수정

    MemberService memberService;

    //테스트돌기전에 appConfig를 만들고 memberService를 여기 할당해준다.
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        // assertj
        Assertions.assertThat(member).isEqualTo(findMember);

    }

}
