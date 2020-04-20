package com.zemoga.Portfolio.controller;

import com.zemoga.Portfolio.dto.PortfolioDTO;
import com.zemoga.Portfolio.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;

    @GetMapping("/")
    public String getPortfolios(Model model){
        model.addAttribute("portfolios",portfolioService.getPortfolios());
        return "portfolios";
    }

    @GetMapping("/{id}")
    public String getPortfolio(@PathVariable("id") long id, Model model){
        model.addAttribute("portfolio", portfolioService.getPortfolioById(id));
        return "profile";
    }
}
