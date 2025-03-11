package com.timulys.board_back.dto.response.board;

import com.timulys.board_back.common.ResponseCode;
import com.timulys.board_back.common.ResponseMessage;
import com.timulys.board_back.dto.object.BoardListItem;
import com.timulys.board_back.dto.response.ResponseDto;
import com.timulys.board_back.entity.BoardListViewEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * packageName :   com.timulys.board_back.dto.response.board
 * fileName    :   GetLatestBoardListResponseDto
 * author      :   user
 * date        :   2025-01-25
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2025-01-25             user                 최초 생성
 */
@Getter
public class GetLatestBoardListResponseDto extends ResponseDto {
    private List<BoardListItem> latestList;

    public GetLatestBoardListResponseDto(List<BoardListViewEntity> boardEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.latestList = BoardListItem.getList(boardEntities);
    }

    public static ResponseEntity<? super GetLatestBoardListResponseDto> success(List<BoardListViewEntity> boardListViewEntities) {
        GetLatestBoardListResponseDto result = new GetLatestBoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
