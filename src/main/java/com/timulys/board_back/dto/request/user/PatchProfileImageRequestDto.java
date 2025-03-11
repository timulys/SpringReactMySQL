package com.timulys.board_back.dto.request.user;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName :   com.timulys.board_back.dto.request.user
 * fileName    :   PatchProfileImageRequestDto
 * author      :   user
 * date        :   2025-02-21
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2025-02-21             user                 최초 생성
 */
@Data
@NoArgsConstructor
public class PatchProfileImageRequestDto {
    private String profileImage;
}
