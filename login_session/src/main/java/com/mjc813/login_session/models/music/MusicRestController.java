package com.mjc813.login_session.models.music;

import com.mjc813.login_session.common.ComResponseDto;
import com.mjc813.login_session.common.Mjc813Exception;
import com.mjc813.login_session.common.ResponseCode;
import com.mjc813.login_session.models.member.IMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mjc813.login_session.common.LoginException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/music")
public class MusicRestController {
	@Autowired
	private MusicService musicService;

	@PostMapping("")
	public ResponseEntity<ComResponseDto<MusicDto>> insert(Model model, @RequestBody MusicDto insertDto) throws LoginException {
		IMember signedMember = this.IsUserOrAdmin(model);
		if ( signedMember == null ) {
			// 존재하지 않으면 인가 에러를 출력한다.
			return ResponseEntity.status(500).body(
				ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}
		MusicDto result = this.musicService.insert(signedMember, insertDto);
		return ResponseEntity.status(201).body(
			ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@PatchMapping("")
	public ResponseEntity<ComResponseDto<MusicDto>> update(@RequestBody MusicDto insertDto) throws LoginException {
		IMember signedMember = this.IsUserOrAdmin(model);
		if ( signedMember == null ) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}
	}

	// role 이 USER 인지 체크해서 아니면 null 을 리턴
	private IMember IsUser(Model model) {
		IMember signedMember = (IMember)model.getAttribute("signedMember");
		if ( signedMember != null && !signedMember.getRole().equals("USER") ) {
			return null;
		}
		return signedMember;
	}

	// role 이 USER 또는 ADMIN 인지 체크해서 아니면 null 을 리턴
	private IMember IsUserOrAdmin(Model model) {
		IMember signedMember = (IMember)model.getAttribute("signedMember");
		if ( signedMember != null && signedMember.getRole().equals("GUEST") ) {
			return null;
		}
		return signedMember;

	}

	// role 이 ADMIN 인지 체크해서 아니면 null 을 리턴
	private IMember IsAdmin(Model model) {
		IMember signedMember = (IMember)model.getAttribute("signedMember");
		if ( signedMember != null && !signedMember.getRole().equals("ADMIN") ) {
			return null;
		}
		return signedMember;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComResponseDto<MusicDto>> findById(@PathVariable Long id) throws Mjc813Exception {
		MusicDto result = this.musicService.findById(id);
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@GetMapping("/all")
	public ResponseEntity<ComResponseDto<List<MusicDto>>> findAll(
//			HttpServletRequest request
			@SessionAttribute(name = "MJC_LOGIN", required = false) String signId
	) {
		try {
			if (signId != null) {
				// 로그인 되어 있음
				List<MusicDto> result = this.musicService.findAll();
				return ResponseEntity.status(200).body(
						ComResponseDto.make(ResponseCode.SUCCESS, result)
				);
			} else {
				// 로그인 안되어 있음
				return ResponseEntity.status(500).body(
						ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
				);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}
	}
}
