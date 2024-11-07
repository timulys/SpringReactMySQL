package com.timulys.board_back.repository.resultSet;

/**
 * packageName :   com.timulys.board_back.repository.resultSet
 * fileName    :   GetBoardResultSet
 * author      :   user
 * date        :   2024-10-12
 * description :   Get Board Result Set Mapping Interface
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-12             user                 최초 생성
 */
public interface GetBoardResultSet {
    Integer getBoardNumber();
    String getTitle();
    String getContent();
    String getWriteDatetime();
    String getWriterEmail();
    String getWriterNickName();
    String getWriterProfileImage();
}
