package com.timulys.board_back.service;

import com.timulys.board_back.dto.response.search.GetPopularListResponseDto;
import com.timulys.board_back.dto.response.search.GetRelationListResponseDto;
import org.springframework.http.ResponseEntity;

/**
 * packageName :   com.timulys.board_back.service
 * fileName    :   SearchService
 * author      :   user
 * date        :   2025-01-26
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2025-01-26             user                 최초 생성
 */
public interface SearchService {
    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
    ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord);
}
