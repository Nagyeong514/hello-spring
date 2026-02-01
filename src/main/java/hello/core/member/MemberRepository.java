package hello.core.member;

//구현체는 MemoryMemberRepository


public interface MemberRepository {

    //Member 저장하고
    void save (Member member);

    // Member Id 찾고
    Member findById(Long memberId);
}
