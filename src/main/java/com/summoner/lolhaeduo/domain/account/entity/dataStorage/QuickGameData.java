package com.summoner.lolhaeduo.domain.account.entity.dataStorage;

import com.summoner.lolhaeduo.domain.duo.entity.Kda;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class QuickGameData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int wins;

    private int totalGames;

    private Kda kda;
}
