package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

     MemoryMemberRepository repository = new MemoryMemberRepository();

//     테스트 끝나고 clear -> 순서가 상관이 없다 / 의존 관계 없이 Test가 실행된다.
     @AfterEach
     public void afterEach() {
          repository.clearStore();

     }

     @Test
     public void save() {
          Member member = new Member();
          member.setName("spring");

          repository.save(member);

          Member result = repository.findById(member.getId()).get();

          //검증하기
//          System.out.println("result = " + (result == member));
//          Assertions.assertEquals(member, result);
          assertThat(member).isEqualTo(result);

     }

     @Test
     public void findByName() {
          Member member1 = new Member();
          member1.setName("spring1");
          repository.save(member1);

          Member member2 = new Member();
          member2.setName("spring2");
          repository.save(member2);


          Member result = repository.findByName("spring1").get();

          assertThat(result).isEqualTo(member1);


     }

     @Test
     public void findAll(){
          Member member1 = new Member();
          member1.setName("spring1");
          repository.save(member1);

          Member member2 = new Member();
          member2.setName("spring2");
          repository.save(member2);

          List<Member> result = repository.findAll();

          assertThat(result.size()).isEqualTo(2);


     }


}
