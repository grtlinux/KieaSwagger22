package org.tain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses({
	@ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad Request"),
	@ApiResponse(code = 500, message = "Internal Server Error")
})
@RestController
@RequestMapping("/v1")
public class MainController {

	@ApiOperation(value = "회원 정보", notes = "회원에 대한 정보 출력")
	@GetMapping("/member/{idx}")
	public ResponseEntity<?> getMember(@PathVariable String idx) {
		return ResponseEntity.ok(12345);
	}
	
	@ApiOperation(value = "회원 등록", notes = "신규 회원 등록")
	@PostMapping("/member")
	public ResponseEntity<?> registerMember() {
		return ResponseEntity.ok("register OK!!");
	}
}
