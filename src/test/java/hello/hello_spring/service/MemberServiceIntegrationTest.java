package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest //스프링 컨테이너와 테스트를 함계 실행한다.
@Transactional  //테스트 시작 전에 트랜잭션을 시작하고, 완료후 테스트 롤백을 해준다: DB에 있는 넣었던 데이터가 다 깔끔하게 반영이 안되고 지워진다.
class MemberServiceIntegrationTest {


    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;




    //Test 들은 회원가입 같이 한국어로 해도 된대
    @Test
//    @Commit //커밋할거다
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring100");

        //when 멤버 서비스의 조인을 검증
        Long saveId = memberService.join(member);

        //then 리포지토리에 있는게 맞아?
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());   //멤버이름이 findMember의 이름과 같니?
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join((member2)));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // Test가 실패 : NullPointerException

       /* try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");
        }*/



        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}