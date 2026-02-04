package hello.core.member;

//MemberService의 구현체
public class MemberServiceImpl implements MemberService {


    // [제한자] [수정불가] [인터페이스(역할)] [변수명] = [실제객체(구현)];     //ex) 타이어 t = new 한국타이어(); -> 금호타이어()로 변경가능
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //관심사 분리가 안되어있다 -> 로미오가 줄리엣의 배우를 정하는중
    private final MemberRepository memberRepository;

    //생성자를 만들어
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // 택배로 온 부품을 받아서 내 선반에 올림!
    }
    //이제 구체적인거는 MemberServiceImpl에서 몰라 그 저장하는 기능인 MemoryMemberRepository 여기 없음
    //그거는 이제 AppConfig에서 생성을 해서 여기로 넣어준대






    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
