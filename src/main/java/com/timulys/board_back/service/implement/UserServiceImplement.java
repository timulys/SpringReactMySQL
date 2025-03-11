package com.timulys.board_back.service.implement;

import com.timulys.board_back.dto.request.user.PatchNicknameRequestDto;
import com.timulys.board_back.dto.request.user.PatchProfileImageRequestDto;
import com.timulys.board_back.dto.response.ResponseDto;
import com.timulys.board_back.dto.response.user.GetSignInUserResponseDto;
import com.timulys.board_back.dto.response.user.GetUserResponseDto;
import com.timulys.board_back.dto.response.user.PatchNicknameResponseDto;
import com.timulys.board_back.dto.response.user.PatchProfileImageResponseDto;
import com.timulys.board_back.entity.UserEntity;
import com.timulys.board_back.repository.UserRepository;
import com.timulys.board_back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * packageName :   com.timulys.board_back.service.implement
 * fileName    :   UserServiceImplement
 * author      :   user
 * date        :   2024-10-04
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-04             user                 최초 생성
 */
@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {
        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null)
                return GetUserResponseDto.noExistUser();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {
        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null)
                return GetSignInUserResponseDto.notExistUser();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email) {
        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return PatchNicknameResponseDto.noExistUser();

            boolean existedNickname = userRepository.existsByNickname(dto.getNickname());
            if (existedNickname) return PatchNicknameResponseDto.duplicateNickname();

            userEntity.updateNickname(dto.getNickname());
            userRepository.save(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchNicknameResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email) {
        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return PatchProfileImageResponseDto.noExistUser();

            userEntity.updateProfileImage(dto.getProfileImage());
            userRepository.save(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchProfileImageResponseDto.success();
    }
}
