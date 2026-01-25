package hello.hello_spring;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot 3.5 with Java 21!";
    }
}
