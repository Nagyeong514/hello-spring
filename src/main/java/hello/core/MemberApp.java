package hello.core;

import hello.core.member.*;

public class MemberApp {

    public static void main(String[] args) {


//        MemberService memberService = new MemberServiceImpl();
        //관심사 분리로 여기도 수정
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = "+findMember.getName());

    }
}
