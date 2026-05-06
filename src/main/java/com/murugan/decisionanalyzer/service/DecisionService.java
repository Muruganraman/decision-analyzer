package com.murugan.decisionanalyzer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murugan.decisionanalyzer.entity.Decision;
import com.murugan.decisionanalyzer.repository.DecisionRepository;

@Service
public class DecisionService {

    @Autowired
    private DecisionRepository repo;

    // Add decision
    public Decision addDecision(Decision decision) {
        decision.setStatus("PENDING");
        return repo.save(decision);
    }

    // Get all
    public List<Decision> getAll() {
        return repo.findAll();
    }

    // Update status
    public Decision updateStatus(int id, String status) {
        Decision d = repo.findById(id).orElse(null);
        if (d != null) {
            d.setStatus(status);
            return repo.save(d);
        }
        return null;
    }

    // Delete decision ✅
    public String deleteDecision(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted Successfully";
        } else {
            return "Decision Not Found";
        }
    }

    // Analysis
    public String getAnalysis() {
        List<Decision> list = repo.findAll();

        int total = list.size();
        int success = 0;
        int failure = 0;

        for (Decision d : list) {
            if ("SUCCESS".equalsIgnoreCase(d.getStatus())) {
                success++;
            } else if ("FAILURE".equalsIgnoreCase(d.getStatus())) {
                failure++;
            }
        }

        return "Total: " + total +
               ", Success: " + success +
               ", Failure: " + failure;
    }
}