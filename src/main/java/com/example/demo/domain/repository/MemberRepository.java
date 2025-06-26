package com.example.demo.domain.repository;

import com.example.demo.domain.Member;
import com.zaxxer.hikari.pool.HikariProxyConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
