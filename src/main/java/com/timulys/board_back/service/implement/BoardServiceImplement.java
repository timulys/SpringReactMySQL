package com.timulys.board_back.service.implement;

import com.timulys.board_back.dto.request.board.PostBoardRequestDto;
import com.timulys.board_back.dto.request.board.PostCommentRequestDto;
import com.timulys.board_back.dto.response.ResponseDto;
import com.timulys.board_back.dto.response.board.*;
import com.timulys.board_back.entity.BoardEntity;
import com.timulys.board_back.entity.CommentEntity;
import com.timulys.board_back.entity.FavoriteEntity;
import com.timulys.board_back.entity.ImageEntity;
import com.timulys.board_back.repository.*;
import com.timulys.board_back.repository.resultSet.GetBoardResultSet;
import com.timulys.board_back.repository.resultSet.GetCommentListResultSet;
import com.timulys.board_back.repository.resultSet.GetFavoriteListResultSet;
import com.timulys.board_back.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName :   com.timulys.board_back.service.implement
 * fileName    :   BoardServiceImplement
 * author      :   user
 * date        :   2024-10-06
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-06             user                 최초 생성
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {
    // repositories
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;
    private final CommentRepository commentRepository;
    private final FavoriteRepository favoriteRepository;

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {
        GetBoardResultSet resultSet = null;
        List<ImageEntity> imageEntityList = new ArrayList<>();

        try {
            resultSet = boardRepository.getBoard(boardNumber);
            if (resultSet == null) return GetBoardResponseDto.noExistBoard();
            imageEntityList = imageRepository.findByBoardNumber(boardNumber);

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            boardEntity.increaseViewCount(); // view count를 올리기 위한 메소드 호출
            boardRepository.save(boardEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetBoardResponseDto.success(resultSet, imageEntityList);
    }

    @Override
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber) {
        List<GetFavoriteListResultSet> resultSets = new ArrayList<>();
        try {
            boolean existedBoard = boardRepository.existsByBoardNumber(boardNumber);
            if (!existedBoard) return GetFavoriteListResponseDto.noExistBoard();
            resultSets = favoriteRepository.getFavoriteList(boardNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFavoriteListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber) {
        List<GetCommentListResultSet> resultSets = new ArrayList<>();
        try {
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return GetCommentListResponseDto.noExistBoard();
            resultSets = commentRepository.getCommentList(boardNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetCommentListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email) {
        try {
            boolean existedEmail = userRepository.existsByEmail(email);
            if (!existedEmail) return PostBoardResponseDto.notExistUser();

            BoardEntity boardEntity = new BoardEntity(dto, email);
            int boardNumber = boardRepository.save(boardEntity).getBoardNumber();

            List<ImageEntity> imageEntities = dto.getBoardImageList()
                    .stream().map(image -> new ImageEntity(boardNumber, image))
                    .collect(Collectors.toList());
            imageRepository.saveAll(imageEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email) {
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return PostCommentResponseDto.noExistUser();

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return PostCommentResponseDto.noExistBoard();

            CommentEntity commentEntity = new CommentEntity(dto, boardNumber, email);
            commentRepository.save(commentEntity);

            boardEntity.increaseCommentCount();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email) {
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return PutFavoriteResponseDto.noExistUser();

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return PutFavoriteResponseDto.noExistBoard();

            FavoriteEntity favoriteEntity = favoriteRepository.findByBoardNumberAndUserEmail(boardNumber, email);
            if (favoriteEntity == null) {
                favoriteEntity = new FavoriteEntity(email, boardNumber);
                favoriteRepository.save(favoriteEntity);
                boardEntity.increaseFavoriteCount();
            } else {
                favoriteRepository.delete(favoriteEntity);
                boardEntity.decreaseFavoriteCount();
            }
            boardRepository.save(boardEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PutFavoriteResponseDto.success();
    }
}
