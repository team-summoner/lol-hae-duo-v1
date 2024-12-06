package com.summoner.lolhaeduo.domain.duo.dto;

import com.summoner.lolhaeduo.domain.duo.entity.Duo;
import com.summoner.lolhaeduo.domain.duo.enums.Lane;
import com.summoner.lolhaeduo.domain.duo.enums.QueueType;
import lombok.Getter;

@Getter
public class DuoCreateResponse {

    private Long id;
    private QueueType queueType;
    private Lane primaryRole;
    private String primaryChamp;
    private Lane secondaryRole;
    private String secondaryChamp;
    private Lane targetRole;
    private String memo;
    private Boolean mic;
    private Long memberId;
    private Long accountId;

    public DuoCreateResponse(Duo duo) {
        this.id = duo.getId();
        this.queueType = duo.getQueueType();
        this.primaryRole = duo.getPrimaryRole();
        this.primaryChamp = duo.getPrimaryChamp();
        this.secondaryRole = duo.getSecondaryRole();
        this.secondaryChamp = duo.getSecondaryChamp();
        this.targetRole = duo.getTargetRole();
        this.memo = duo.getMemo();
        this.mic = duo.getMic();
        this.memberId = duo.getMemberId();
        this.accountId = duo.getAccountId();
    }
}