package com.timulys.board_back.service;

import com.timulys.board_back.dto.request.user.PatchNicknameRequestDto;
import com.timulys.board_back.dto.request.user.PatchProfileImageRequestDto;
import com.timulys.board_back.dto.response.user.GetSignInUserResponseDto;
import com.timulys.board_back.dto.response.user.GetUserResponseDto;
import com.timulys.board_back.dto.response.user.PatchNicknameResponseDto;
import com.timulys.board_back.dto.response.user.PatchProfileImageResponseDto;
import org.springframework.http.ResponseEntity;

/**
 * packageName :   com.timulys.board_back.service
 * fileName    :   UserService
 * author      :   user
 * date        :   2024-10-04
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-04             user                 최초 생성
 */
public interface UserService {
    // ? super : 부모도 포함해서 반환받을 수 있게
    ResponseEntity<? super GetUserResponseDto> getUser(String email);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email);
    ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email);
}
