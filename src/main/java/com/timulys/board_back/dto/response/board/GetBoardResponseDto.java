package com.timulys.board_back.dto.response.board;

import com.timulys.board_back.common.ResponseCode;
import com.timulys.board_back.common.ResponseMessage;
import com.timulys.board_back.dto.response.ResponseDto;
import com.timulys.board_back.entity.ImageEntity;
import com.timulys.board_back.repository.resultSet.GetBoardResultSet;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName :   com.timulys.board_back.dto.response.board
 * fileName    :   GetBoardResponseDto
 * author      :   user
 * date        :   2024-10-12
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-12             user                 최초 생성
 */
@Getter
public class GetBoardResponseDto extends ResponseDto {
    private int boardNumber;
    private String title;
    private String content;
    private List<String> boardImageList;
    private String writeDateTime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;

    private GetBoardResponseDto(GetBoardResultSet resultSet, List<ImageEntity> imageEntityList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
        this.boardImageList = imageEntityList.stream()
                .map(image -> image.getImage()).collect(Collectors.toList());
        this.writeDateTime = resultSet.getWriteDatetime();
        this.writerEmail = resultSet.getWriterEmail();
        this.writerNickname = resultSet.getWriterNickName();
        this.writerProfileImage = resultSet.getWriterProfileImage();
    }

    public static ResponseEntity<GetBoardResponseDto> success(GetBoardResultSet resultSet, List<ImageEntity> imageEntityList) {
        GetBoardResponseDto result = new GetBoardResponseDto(resultSet, imageEntityList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
