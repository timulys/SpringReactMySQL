package com.timulys.board_back.dto.response.user;

import com.timulys.board_back.common.ResponseCode;
import com.timulys.board_back.common.ResponseMessage;
import com.timulys.board_back.dto.response.ResponseDto;
import com.timulys.board_back.entity.UserEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * packageName :   com.timulys.board_back.dto.response.user
 * fileName    :   GetUserResponseDto
 * author      :   user
 * date        :   2025-02-20
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2025-02-20             user                 최초 생성
 */
@Getter
public class GetUserResponseDto extends ResponseDto {
    private String email;
    private String nickname;
    private String profileImage;

    private GetUserResponseDto(UserEntity userEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.profileImage = userEntity.getProfileImage();
    }

    public static ResponseEntity<GetUserResponseDto> success(UserEntity userEntity) {
        GetUserResponseDto result = new GetUserResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
