package com.timulys.board_back.dto.response.board;

import com.timulys.board_back.common.ResponseCode;
import com.timulys.board_back.common.ResponseMessage;
import com.timulys.board_back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * packageName :   com.timulys.board_back.dto.response.board
 * fileName    :   DeleteBoardResponseDto
 * author      :   user
 * date        :   2025-01-11
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2025-01-11             user                 최초 생성
 */
@Getter
public class DeleteBoardResponseDto extends ResponseDto {
    private DeleteBoardResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<DeleteBoardResponseDto> success() {
        return ResponseEntity.status(HttpStatus.OK).body(new DeleteBoardResponseDto());
    }

    public static ResponseEntity<ResponseDto> noExistBoard() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD));
    }

    public static ResponseEntity<ResponseDto> noExistUser() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER));
    }

    public static ResponseEntity<ResponseDto> noPermission() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION));
    }
}
