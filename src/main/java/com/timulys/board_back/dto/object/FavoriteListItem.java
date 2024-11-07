package com.timulys.board_back.dto.object;

import com.timulys.board_back.repository.resultSet.GetFavoriteListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteListItem {
    private String email;
    private String nickName;
    private String profileImage;

    public FavoriteListItem(GetFavoriteListResultSet resultSet) {
        this.email = resultSet.getEmail();
        this.nickName = resultSet.getNickname();
        this.profileImage = resultSet.getProfileImage();
    }

    public static List<FavoriteListItem> copyList(List<GetFavoriteListResultSet> resultSets) {
        return resultSets.stream().map(resultSet -> new FavoriteListItem(resultSet)).collect(Collectors.toList());
    }
}
