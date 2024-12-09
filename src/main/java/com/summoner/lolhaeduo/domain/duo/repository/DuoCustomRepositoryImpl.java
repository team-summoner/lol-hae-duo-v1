package com.summoner.lolhaeduo.domain.duo.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.summoner.lolhaeduo.domain.duo.entity.Duo;
import com.summoner.lolhaeduo.domain.duo.entity.QDuo;
import com.summoner.lolhaeduo.domain.duo.enums.Lane;
import com.summoner.lolhaeduo.domain.duo.enums.QueueType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

@RequiredArgsConstructor
public class DuoCustomRepositoryImpl implements DuoCustomRepository {
  private final JPAQueryFactory queryFactory;

  @Override
  public Page<Duo> findDuosByCondition(QueueType queueType, Lane lane, String tier, Pageable pageable) {
    QDuo duo = QDuo.duo;

    // 1. 필터 조건 만들기
    BooleanExpression queueTypeCondition = eqQueueType(queueType);
    BooleanExpression laneCondition = eqLane(lane);
    BooleanExpression tierCondition = eqTier(tier);

    // 2. 필터 조건으로 데이터 가져오기
    List<Duo> content = queryFactory.selectFrom(duo)
        .where(queueTypeCondition, laneCondition, tierCondition)
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetch();

    // 3. 필터 조건에 맞는 전체 데이터 개수
    long total = queryFactory.selectFrom(duo)
        .where(queueTypeCondition, laneCondition, tierCondition)
        .fetchCount();

    return PageableExecutionUtils.getPage(content, pageable, () -> total);
  }

  // QueueType 필터 처리
  private BooleanExpression eqQueueType(QueueType queueType) {
    return queueType != null ? QDuo.duo.queueType.eq(queueType) : null;
  }

  // Lane 필터 처리
  private BooleanExpression eqLane(Lane lane) {
    return lane != null ? QDuo.duo.primaryRole.eq(lane) : null;
  }

  // Tier 필터 처리
  private BooleanExpression eqTier(String tier) {
    return tier != null ? QDuo.duo.tier.eq(tier) : null;
  }
}
