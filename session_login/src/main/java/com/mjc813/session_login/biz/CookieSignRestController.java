package com.mjc813.session_login.biz;

import com.mjc813.session_login.common.ComResponseDto;
import com.mjc813.session_login.common.LoginException;
import com.mjc813.session_login.common.ResponseCode;
import com.mjc813.session_login.models.auth.SignInDto;
import com.mjc813.session_login.models.auth.SignUpDto;
import com.mjc813.session_login.models.auth.ValidEmailDto;
import com.mjc813.session_login.models.member.IMember;
import com.mjc813.session_login.models.member.MemberDto;
import com.mjc813.session_login.models.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class CookieSignRestController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<ComResponseDto<IMember>> signUp(@RequestBody SignUpDto signUpDto) {
		MemberDto memberDto = (MemberDto)new MemberDto().clone(signUpDto, true);
		MemberDto inserted = this.memberService.insert(memberDto, false);
//		try {
//			this.mailService.sendHtmlEmail(inserted);
//		} catch (MessagingException e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(500).body(
//					ComResponseDto.make(ResponseCode.SERVER_ERROR, inserted)
//			);
//		}
		return ResponseEntity.status(201).body(
				ComResponseDto.make(ResponseCode.SUCCESS, signUpDto)
		);
	}

	@PostMapping("/signin")
	public ResponseEntity<ComResponseDto<Boolean>> signin(@RequestBody SignInDto signInDto
		, HttpServletResponse response) throws LoginException {
		Boolean isSign = this.authService.signMember(signInDto);
		if ( isSign ) {
			// 정상적으로 로그인(사인인) 되면 쿠키를 클라이언트로 응답한다.
			// 이 클라이언트 해당 쿠키를 가지고 다음에 계속 요청한다.
			Cookie signCookie = new Cookie("MJC_LOGIN", signInDto.getSignId());
			signCookie.setPath("/");
			signCookie.setHttpOnly(true);
			signCookie.setMaxAge(3600); // 쿠키의 유효시간 3600 = 1시간
			response.addCookie(signCookie);
			return ResponseEntity.status(200).body(
					ComResponseDto.make(ResponseCode.SUCCESS, isSign)
			);
		} else {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHENTICATION_ERROR, isSign)
			);
		}
	}

	@GetMapping("/signout")
	public ResponseEntity<ComResponseDto<Boolean>> signout(HttpServletResponse response) {
		Cookie ck = new Cookie("MJC_LOGIN", ""); // sign out하면 value값은 없어진다.
		ck.setPath("/");
		ck.setHttpOnly(true);
		ck.setMaxAge(0); // 쿠키의 남아있는 시간을 0으로 설정
		response.addCookie(ck);
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, true)
		);
	}
}
