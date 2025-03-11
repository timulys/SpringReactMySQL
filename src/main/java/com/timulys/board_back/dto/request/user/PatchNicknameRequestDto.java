package com.timulys.board_back.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName :   com.timulys.board_back.dto.request.user
 * fileName    :   PatchNicknameRequestDto
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
public class PatchNicknameRequestDto {
    @NotBlank
    private String nickname;
}
