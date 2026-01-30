package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    //clear 하려면 MemberRopository를 가져와야한대
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);

    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();

    }

    //Test 들은 회원가입 같이 한국어로 해도 된대
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

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