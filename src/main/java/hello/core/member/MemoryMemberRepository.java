package hello.core.member;

import java.util.HashMap;
import java.util.Map;

//Member 데이터를 넣고 꺼내는 장소
public class MemoryMemberRepository implements MemberRepository{


    //데이터를 메모리에 임시로 저장하기 위한 저장소(Store)         //Long : 키 값, Member : 밸류 값
    private static Map<Long, Member> store = new HashMap<>();   //HashMap: 데이터 빨라 찾음 + ConcurrentHashMap: 동시성!!


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
