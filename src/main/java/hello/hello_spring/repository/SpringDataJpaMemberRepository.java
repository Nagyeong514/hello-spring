package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JPA 사용하기: 스프링 데이터 JPA를 쓰면, JpaRepository를 상속받는 것만으로 CRUD(저장, 조회, 삭제) 기능을 스프링이 자동으로 다 만들어줍니다.
//인터페이스가 '알아서' 쿼리를 짠다
//Member의 id가 Long 타입임
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);

}
