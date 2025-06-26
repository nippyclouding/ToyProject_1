package com.example.demo.domain.controller;

import com.example.demo.domain.Member;
import com.example.demo.domain.repository.MemberRepository;
import com.example.demo.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/sign")
public class SignController {

    @GetMapping
    public String signForm(Model model){
        model.addAttribute("member", new Member());
        return "sign";
    }

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        log.info("회원가입 요청");
        model.addAttribute("member", new Member());
        return "signUp";
    }

    @GetMapping("/signIn")
    public String signInForm(Model model) {
        log.info("로그인 폼 요청");
        model.addAttribute("member", new Member());
        return "signIn";
    }

    @GetMapping("/signOut")
    public String SignOutForm(Model model) {
        log.info("로그 아웃 요청");
        return "signOut";
    }

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    @PostMapping("/signUpRedirect")
    public String SignUpRedirect(@Validated @ModelAttribute Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        //검증 로직 : @Validated
        if (bindingResult.hasErrors()) {
            log.info("회원가입 폼 검증 오류 발생: errors={}", bindingResult);
            // 오류가 있다면 다시 회원가입 폼으로 돌아갑니다.
            return "signUp"; // ✨ 회원가입 폼 뷰 이름
        }
        Member newMember = member;
        memberService.join(member);
        return "redirect:/";
    }





    @PostMapping
    public String login(@Validated @ModelAttribute Member member,
                        BindingResult bindingResult) {
        log.info("로그인 요청: id={}, password={}", member.getId(), member.getPassword());

        if (bindingResult.hasErrors()) {
            log.info("로그인 폼 검증 오류 발생: errors={}", bindingResult);
            return "signIn";
        }

        // 실제 로그인 로직 (예시)
        Member foundMember = null;
        // if (member.getId().equals("test") && member.getPassword().equals("1234")) {
        //     foundMember = new Member(); foundMember.setId(member.getId());
        // }

        if (foundMember == null) {
            log.info("로그인 실패: 아이디 또는 비밀번호 불일치");
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "signIn";
        }

        log.info("로그인 성공: id={}", foundMember.getId());
        return "redirect:/main";
    }

}
