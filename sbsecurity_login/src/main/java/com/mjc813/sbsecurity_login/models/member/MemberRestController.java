package com.mjc813.sbsecurity_login.models.member;

import com.mjc813.sbsecurity_login.common.ComResponseDto;
import com.mjc813.sbsecurity_login.common.LoginException;
import com.mjc813.sbsecurity_login.common.Mjc813Exception;
import com.mjc813.sbsecurity_login.common.ResponseCode;
import com.mjc813.sbsecurity_login.models.role.Role;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/member")
public class MemberRestController {
	@Autowired
	private MemberService memberService;

	@PostMapping("")
	@PreAuthorize("hasAnyAuthority('ADMIN')") // insert는 ADMIN만 가능 나머지 role은 403에러
	public ResponseEntity<ComResponseDto<MemberDto>> insert(@RequestBody MemberDto memberDto) throws LoginException {
		MemberDto result = this.memberService.insert(memberDto, true);
		return ResponseEntity.status(201).body(
			ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	//	member update 는 ADMIN 은 아무나 update 가능, GUEST, USER 는 자기데이터만 update 가능
	@PatchMapping("")
	@PreAuthorize("hasAnyAuthority('ADMIN') or @memberService.isCreateId(#updateDto.id, authentication.name)")
	public ResponseEntity<ComResponseDto<MemberDto>> update (@RequestBody MemberDto updateDto) throws Mjc813Exception {
		MemberDto result = this.memberService.update(updateDto);
		return ResponseEntity.status(HttpStatus.OK).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@GetMapping("")
	public ResponseEntity<ComResponseDto<List<MemberDto>>> findAll(Model model) {
		Object obj = model.getAttribute("signedMember");
		if (obj instanceof IMember signedMember && !Role.ADMIN.toString().equals(signedMember.getRole()) ) {
			return ResponseEntity.status(403).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}
		List<MemberDto> result = this.memberService.findAll();
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}
}
