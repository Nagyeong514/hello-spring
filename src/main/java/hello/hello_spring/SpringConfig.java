package hello.hello_spring;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.JpaMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//1. jdbcTemplate
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    //2. JPA에 넣어줄거야 (EntityManager 개발자)
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    //3. Spring Data JPA
    //인젝션만 받으면 됨
    @Autowired
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //MemberServie가 Spring bean에 등록이 된다.
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    //AOP 쓰자
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

    //Spring Data JPA 에서는 이거도 사용할 필요가 없다.
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();

        //h2에 연결하자 저 위에 dataSource
//        return new JdbcMemberRepository(dataSource);

        //1. jdbcTemplate 연결하지
//        return new JdbcMemberRepository(dataSource);

        //2. JPA 쓰자
//        return new JpaMemberRepository(em);

}


