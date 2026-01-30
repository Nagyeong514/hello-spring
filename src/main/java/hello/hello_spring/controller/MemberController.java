package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//templates/members/...

@Controller
public class MemberController {
    private final MemberService memberService;

    //Autowired: 멤버 컨트롤러가 생성이 될 때 스프링 빈에 등록되어 있는 멤버 서비스 객체를 가져다가 딱 넣어줍니다. -> DI
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        //members에 createMemberForm.html에 들어가서 html 뿌린다
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";


    }

    @GetMapping("/members")
    public String list(Model model) {
        //멤버 리스트 자체를 모델에 담아서 화면으로 넘길거다.
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return  "members/memberList";
    }


}
