package com.timulys.board_back.dto.request.board;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * packageName :   com.timulys.board_back.dto.request.board
 * fileName    :   PostBoardRequestDto
 * author      :   user
 * date        :   2024-10-06
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-06             user                 최초 생성
 */
@Data
@NoArgsConstructor
public class PostBoardRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private List<String> boardImageList;

}
