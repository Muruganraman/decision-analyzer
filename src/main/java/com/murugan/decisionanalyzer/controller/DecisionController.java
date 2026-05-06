package com.murugan.decisionanalyzer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.murugan.decisionanalyzer.entity.Decision;
import com.murugan.decisionanalyzer.service.DecisionService;

@RestController
@RequestMapping("/decisions")
public class DecisionController {

    @Autowired
    private DecisionService service;

    @PostMapping
    public Decision addDecision(@RequestBody Decision decision) {
        return service.addDecision(decision);
    }

    @GetMapping
    public List<Decision> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Decision updateStatus(@PathVariable int id,
                                 @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/analysis")
    public String getAnalysis() {
        return service.getAnalysis();
    }
    @DeleteMapping("/{id}")
    public String deleteDecision(@PathVariable int id) {
        return service.deleteDecision(id);
    }
}