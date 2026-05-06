package com.murugan.decisionanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.murugan.decisionanalyzer.entity.Decision;

public interface DecisionRepository extends JpaRepository<Decision, Integer> {

}