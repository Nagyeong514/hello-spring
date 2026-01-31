## 📝Spring Framework 학습 기록
> 김영한의 스프링 입문 강의를 수강하며 학습 내용을 기록하는 공간입니다.

Spring의 핵심 원리부터 데이터 접근 기술, 그리고 안정적인 테스트 코드 작성까지 단계별로 학습한 내용을 정리했습니다.

### 1. Spring 핵심 원리와 AOP
* **AOP (Aspect Oriented Programming)**
  * 공통 관심 사항(예: 시간 측정)과 핵심 비즈니스 로직을 분리하여 관리하는 관점 지향 프로그래밍 학습
* **DI (Dependency Injection) & 빈 관리**
  * 생성자 주입을 통한 객체 간 의존 관계 형성 및 `@Autowired` 활용
  * `@Controller`, `@Service`, `@Repository` 어노테이션을 이용한 컴포넌트 스캔과 스프링 빈 등록 원리 이해

### 2. MVC 패턴과 웹 개발 흐름
* **MVC (Model-View-Controller) 패턴**
  * 컨트롤러, 모델, 뷰의 상호작용을 통한 사용자 데이터 전달 구조 이해
* **HTTP 요청 처리**
  * `@GetMapping`, `@PostMapping` 등을 활용한 GET/POST 요청 처리 및 웹 통신 흐름 파악

### 3. 데이터 접근 기술과 설계 패턴
* **Repository 패턴**
  * 인터페이스 기반의 `MemberRepository`를 설계하여 구현체 교체가 용이한 유연한 구조 학습
* **단계별 DB 연동 기술**
  * **JDBC & JdbcTemplate**: DB 연결 기초 및 반복 코드 제거
  * **JPA (Java Persistence API)**: 객체와 테이블 매핑을 통한 객체 중심 개발 전환
  * **Spring Data JPA**: 인터페이스만으로 CRUD 기능을 자동화하는 실무 핵심 기술 습득

### 4. 테스트 코드 작성 및 검증
* **단위 및 통합 테스트**
  * 각 기능의 독립적 검증 및 `@SpringBootTest`를 활용한 전체 로직 확인
* **테스트 환경 최적화**
  * `@Transactional`을 활용하여 테스트 실행 후 데이터를 자동 롤백함으로써 항상 일관된 테스트 환경 유지

### 5. Spring Boot 실무 활용
* **어노테이션 기반 개발**: 다양한 핵심 어노테이션의 용도를 익히고 적재적소에 적용
* **Starter 프로젝트**: 프로젝트 의존성 관리 및 내장 서버를 활용한 빠른 실행 환경 구축
* **공식 문서 활용**: [Spring Boot 3.5 Manual](https://docs.spring.io/spring-boot/3.5/index.html)에서 필요한 기능(예: `welcome page`)을 검색하여 적용하는 방법 습득
* **H2 데이터베이스 연결**:
  * 실행: `./h2.bat` (Windows 기준)
  * JDBC URL: `jdbc:h2:tcp://localhost/~/test` 설정을 통한 네트워크 모드 접속
* **로컬 서버 확인**: `localhost:8080`을 통한 실시간 개발 서버 구동 및 결과 검증

* ## 📊 Quick Links
- **강의 정보**: [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://inf.run/2t7Gr)
- **학습 환경**: IntelliJ IDEA / Java 21
