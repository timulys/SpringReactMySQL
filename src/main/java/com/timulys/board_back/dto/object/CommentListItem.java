package com.timulys.board_back.dto.object;

import com.timulys.board_back.repository.resultSet.GetCommentListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentListItem {
    private String nickname;
    private String profileImage;
    private String writerDateTime;
    private String content;

    public CommentListItem(GetCommentListResultSet resultSet) {
        this.nickname = resultSet.getNickname();
        this.profileImage = resultSet.getProfileImage();
        this.writerDateTime = resultSet.getWriteDatetime();
        this.content = resultSet.getContent();
    }

    public static List<CommentListItem> copyList(List<GetCommentListResultSet> resultSets) {
        return resultSets.stream().map(resultSet -> new CommentListItem(resultSet)).collect(Collectors.toList());
    }
}
