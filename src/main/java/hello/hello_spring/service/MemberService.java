package hello.hello_spring.service;

//설계도
import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
//실제 기계
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    //외부에서 멤머 리포지토리를 넣어준다. = dependency injection (DI)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    *회원가입
    * */
    //새로 가입하고 싶은 사람의 정보(member)를 받으며 시작
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
       /* Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        // 1. 입구로 들어온 '새 사람'의 이름을 꺼내서
        String newName = member.getName();

        // 2. 저장소(repository)에 가서 이 이름이랑 똑같은 애가 있는지 '뒤져봅니다'
        Optional<Member> result = memberRepository.findByName(newName);

        */

        validateDuplicateMember(member);    //중복 회원 검증
        memberRepository.save(member);
        return member.getId();

        /*시간 찍는 로직들 -> AOP 대체
        long start = System.currentTimeMillis();

        try {
            validateDuplicateMember(member);    //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");

        }*/


    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /*
    전체회원 조회
    */
    public List<Member> findMembers() {
        return memberRepository.findAll();

     /* 시간찍는 로직들 -> AOP 대체
     long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers = "+ timeMs + "ms");
        }*/

    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);

    }

}
