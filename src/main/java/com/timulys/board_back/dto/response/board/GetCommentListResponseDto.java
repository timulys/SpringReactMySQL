package com.timulys.board_back.dto.response.board;

import com.timulys.board_back.common.ResponseCode;
import com.timulys.board_back.common.ResponseMessage;
import com.timulys.board_back.dto.object.CommentListItem;
import com.timulys.board_back.dto.response.ResponseDto;
import com.timulys.board_back.repository.resultSet.GetCommentListResultSet;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * packageName :   com.timulys.board_back.dto.response.board
 * fileName    :   GetCommentListResponseDto
 * author      :   user
 * date        :   2024-10-15
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-15             user                 최초 생성
 */
@Getter
public class GetCommentListResponseDto extends ResponseDto {
    private List<CommentListItem> commentListItem;

    private GetCommentListResponseDto(List<GetCommentListResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.commentListItem = CommentListItem.copyList(resultSets);
    }

    public static ResponseEntity<GetCommentListResponseDto> success(List<GetCommentListResultSet> resultSets) {
        GetCommentListResponseDto result = new GetCommentListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
