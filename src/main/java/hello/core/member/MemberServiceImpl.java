package hello.core.member;

//MemberService의 구현체
public class MemberServiceImpl implements MemberService {


    // [제한자] [수정불가] [인터페이스(역할)] [변수명] = [실제객체(구현)];     //ex) 타이어 t = new 한국타이어(); -> 금호타이어()로 변경가능
    private final MemberRepository memberRepository = new MemoryMemberRepository();




    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
