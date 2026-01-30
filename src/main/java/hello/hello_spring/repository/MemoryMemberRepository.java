package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    //store: 공부 목적으로 메모리(RAM)에 데이터를 저장하기 위해 Map을 사용했습니다.
    //Map은 Key-Value 쌍으로 데이터를 저장하는 자료구조
    //회원의 번호(Long)를 열쇠(Key)로, 회원 객체(Member)를 값(Value)으로 저장
    private static Map<Long, Member> store = new HashMap<>();
    //sequence: 회원 ID(1, 2, 3...)를 자동으로 생성해 주는 번호표 역할
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        // 1. 번호표(sequence)를 1 올리고, 그 번호를 member의 Id로 저장한다.
        member.setId(++sequence);
        // 2. Map(store)에 [ID 번호 : member 주머니]를 짝지어서 집어넣는다.
        store.put(member.getId(), member);
        // 3. 저장이 끝난 member 주머니를 다시 돌려준다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //널값이 반환될 수도 있으니 ofNullable
        // 1. store(저장소)에서 id 번호에 해당하는 주머니를 꺼낸다.
        // 2. 만약 없으면 null이 나올 텐데, 그걸 대비해서 Optional 상자에 담는다.
        return Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {
        //Map에서 루프를 돌면서 같은 이름? 찾으면 반환
        //"저장소 회원들을 쭈욱 나열해서(stream), 이름이 내가 찾는 이름이랑 똑같은지 검사하고(filter), 찾으면 꺼내와(findAny)."
        //"(재료로) member가 들어오면 -> (그걸로) 이런 일을 해라!"
        return store.values().stream()      // 1. 저장소에 있는 회원들을 한 줄로 세운다.
                .filter(member -> member.getName().equals(name))        // 2. 이름이 'name'과 같은 사람만 남긴다.
                .findAny();     // 3. 그중 아무나 한 명 찾으면 바로 반환한다.
    }

    @Override
    public List<Member> findAll() {
        //values가 Member들이래
        // 1. store.values() : 저장소에 있는 모든 회원 주머니들을 다 모은다.
        // 2. new ArrayList<>(...) : 그 주머니들을 새로운 리스트(목록)에 담는다.
        return new ArrayList<>(store.values());
    }


    public void clearStore(){
        store.clear();
    }

}
