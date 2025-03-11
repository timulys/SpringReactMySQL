package com.timulys.board_back.controller;

import com.timulys.board_back.dto.request.board.PatchBoardRequestDto;
import com.timulys.board_back.dto.request.board.PostBoardRequestDto;
import com.timulys.board_back.dto.request.board.PostCommentRequestDto;
import com.timulys.board_back.dto.response.board.*;
import com.timulys.board_back.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * packageName :   com.timulys.board_back.controller
 * fileName    :   BoardController
 * author      :   user
 * date        :   2024-10-06
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-06             user                 최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
            @PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/favorite-list")
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(
            @PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super GetFavoriteListResponseDto> response = boardService.getFavoriteList(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(
            @PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super GetCommentListResponseDto> response = boardService.getCommentList(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/increase-view-count")
    public ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(@PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super IncreaseViewCountResponseDto> response = boardService.increaseViewCount(boardNumber);
        return response;
    }

    @GetMapping("/latest-list")
    public ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList() {
        ResponseEntity<? super GetLatestBoardListResponseDto> response = boardService.getLatestBoardList();
        return response;
    }

    @GetMapping("/top3")
    public ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList() {
        ResponseEntity<? super GetTop3BoardListResponseDto> response = boardService.getTop3BoardList();
        return response;
    }

    @GetMapping(value = {"/search-list/{searchWord}", "/search-list/{searchWord}/{preSearchWord}"})
    public ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(
            @PathVariable("searchWord") String searchWord,
            @PathVariable(value = "preSearchWord", required = false) String preSearchWord) {
        ResponseEntity<? super GetSearchBoardListResponseDto> response = boardService.getSearchBoardList(searchWord, preSearchWord);
        return response;
    }

    @GetMapping(value = "/user-board-list/{email}")
    public ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(@PathVariable("email") String email) {
        ResponseEntity<? super GetUserBoardListResponseDto> response = boardService.getUserBoardList(email);
        return response;
    }

    @PostMapping
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
            @RequestBody @Valid PostBoardRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody, email);
        return response;
    }

    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostCommentResponseDto> postComment(
            @RequestBody @Valid PostCommentRequestDto requestBody,
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PostCommentResponseDto> response = boardService.postComment(requestBody, boardNumber, email);
        return response;
    }

    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PutFavoriteResponseDto> response = boardService.putFavorite(boardNumber, email);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
            @RequestBody @Valid PatchBoardRequestDto requestBody,
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(requestBody, boardNumber, email);
        return response;
    }

    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardNumber, email);
        return response;
    }
}
