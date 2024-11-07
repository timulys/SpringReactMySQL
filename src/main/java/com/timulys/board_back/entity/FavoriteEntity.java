package com.timulys.board_back.entity;

import com.timulys.board_back.entity.primaryKey.FavoritePk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "favorite")
@Table(name = "favorite")
@IdClass(FavoritePk.class) // 복합키 처리를 위한 방법
public class FavoriteEntity {
    @Id
    private String userEmail;
    @Id
    private int boardNumber;
}
