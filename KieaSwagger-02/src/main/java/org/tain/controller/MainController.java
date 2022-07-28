package org.tain.controller;

//import com.story.example.lib.Response;
//import com.story.example.main.dto.RegisterRequest;
//import com.story.example.main.dto.RegisterResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		return ResponseEntity.ok(12345);
	}
}