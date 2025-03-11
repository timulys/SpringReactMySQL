package com.timulys.board_back.service.implement;

import com.timulys.board_back.dto.response.ResponseDto;
import com.timulys.board_back.dto.response.search.GetPopularListResponseDto;
import com.timulys.board_back.dto.response.search.GetRelationListResponseDto;
import com.timulys.board_back.repository.SearchLogRepository;
import com.timulys.board_back.repository.resultSet.GetPopularListResultSet;
import com.timulys.board_back.repository.resultSet.GetRelationListResultSet;
import com.timulys.board_back.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName :   com.timulys.board_back.service.implement
 * fileName    :   SearchServiceImplment
 * author      :   user
 * date        :   2025-01-26
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2025-01-26             user                 최초 생성
 */
@Service
@RequiredArgsConstructor
public class SearchServiceImplment implements SearchService {
    private final SearchLogRepository searchLogRepository;

    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {
        List<GetPopularListResultSet> resultSets = new ArrayList<>();
        try {
            resultSets = searchLogRepository.getPopularList();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetPopularListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord) {
        List<GetRelationListResultSet> resultSets = new ArrayList<>();
        try {
            resultSets = searchLogRepository.getRelationList(searchWord);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetRelationListResponseDto.success(resultSets);
    }
}
