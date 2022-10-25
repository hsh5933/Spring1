package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")  //하는일없이 createMemberForm페이지 띄워줌
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //createMemberForm formAction으로이쪽으로
    public String create(MemberForm form){ //멤버폼 이름에 input입력값이 들어오게됨
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member); //회원가입 메서드
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        //멤버리스트에 모든멤버리스트 가져오기
        List<Member> members = memberService.findMembers();

        model.addAttribute("members", members);

        return "members/memberList";
    }
}
