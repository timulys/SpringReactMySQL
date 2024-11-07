package com.timulys.board_back.dto.request.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName :   com.timulys.board_back.dto.request.board
 * fileName    :   PostCommentRequestDto
 * author      :   user
 * date        :   2024-10-13
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-13             user                 최초 생성
 */
@Data
@NoArgsConstructor
public class PostCommentRequestDto {
    @NotBlank
    private String comment;
}
