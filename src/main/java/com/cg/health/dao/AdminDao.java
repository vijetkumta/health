package com.cg.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.health.entities.Admin;

@Repository
public  interface AdminDao extends JpaRepository<Admin, Integer>{

}
