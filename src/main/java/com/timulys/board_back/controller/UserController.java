package com.timulys.board_back.controller;

import com.timulys.board_back.dto.response.user.GetSignInUserResponseDto;
import com.timulys.board_back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // @AuthenticationPrincipal 어노테이션을 이용하면 jwt filter에서 SecurityContext에 넣어두었던
    // User 정보를 email로 가져올 수 있다.
    @GetMapping
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(@AuthenticationPrincipal String email) {
        ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
        return response;
    }
}
