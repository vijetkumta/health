package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.health.entities.PolicyUser;

@Repository
public interface PolicyUserDao extends JpaRepository<PolicyUser, Integer> {

}
