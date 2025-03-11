package com.timulys.board_back.controller;

import com.timulys.board_back.dto.request.user.PatchNicknameRequestDto;
import com.timulys.board_back.dto.request.user.PatchProfileImageRequestDto;
import com.timulys.board_back.dto.response.user.GetSignInUserResponseDto;
import com.timulys.board_back.dto.response.user.GetUserResponseDto;
import com.timulys.board_back.dto.response.user.PatchNicknameResponseDto;
import com.timulys.board_back.dto.response.user.PatchProfileImageResponseDto;
import com.timulys.board_back.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * packageName :   com.timulys.board_back.controller
 * fileName    :   UserController
 * author      :   user
 * date        :   2024-10-04
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-04             user                 최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<? super GetUserResponseDto> getUser(@PathVariable("email") String email) {
        ResponseEntity<? super GetUserResponseDto> response = userService.getUser(email);
        return response;
    }

    // @AuthenticationPrincipal 어노테이션을 이용하면 jwt filter에서 SecurityContext에 넣어두었던
    // User 정보를 email로 가져올 수 있다.
    @GetMapping
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(@AuthenticationPrincipal String email) {
        ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
        return response;
    }

    @PatchMapping("/nickname")
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(
            @RequestBody @Valid PatchNicknameRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PatchNicknameResponseDto> response = userService.patchNickname(requestBody, email);
        return response;
    }

    @PatchMapping("/profile-image")
    public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(
            @RequestBody @Valid PatchProfileImageRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PatchProfileImageResponseDto> response = userService.patchProfileImage(requestBody, email);
        return response;
    }
}
