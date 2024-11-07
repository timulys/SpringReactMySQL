package com.timulys.board_back.dto.response.board;

import com.timulys.board_back.common.ResponseCode;
import com.timulys.board_back.common.ResponseMessage;
import com.timulys.board_back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * packageName :   com.timulys.board_back.dto.response.board
 * fileName    :   PostBoardResponseDto
 * author      :   user
 * date        :   2024-10-06
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-06             user                 최초 생성
 */
@Getter
public class PostBoardResponseDto extends ResponseDto {
    private PostBoardResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PostBoardResponseDto> success() {
        PostBoardResponseDto result = new PostBoardResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
