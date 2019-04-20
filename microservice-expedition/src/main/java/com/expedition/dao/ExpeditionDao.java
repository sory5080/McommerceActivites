package com.expedition.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expedition.model.Expedition;

public interface ExpeditionDao extends JpaRepository<Expedition, Long> {

}
