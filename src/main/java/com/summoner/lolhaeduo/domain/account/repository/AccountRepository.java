package com.summoner.lolhaeduo.domain.account.repository;

import com.summoner.lolhaeduo.domain.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountQuerydslRepository{
}
