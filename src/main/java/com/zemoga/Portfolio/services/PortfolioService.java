package com.zemoga.Portfolio.services;

import com.zemoga.Portfolio.dto.PortfolioDTO;

import java.util.List;

public interface PortfolioService {
    public PortfolioDTO getPortfolioById(Long id);
    public List<PortfolioDTO> getPortfolios();
    public void updatePortfolio(Long id, PortfolioDTO portfolioDTO);
}
