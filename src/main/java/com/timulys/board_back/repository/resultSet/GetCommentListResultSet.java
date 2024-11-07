package com.timulys.board_back.repository.resultSet;

/**
 * packageName :   com.timulys.board_back.repository.resultSet
 * fileName    :   GetCommentListResultSet
 * author      :   user
 * date        :   2024-10-15
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-15             user                 최초 생성
 */
public interface GetCommentListResultSet {
    String getNickname();
    String getProfileImage();
    String getWriteDatetime();
    String getContent();
}
