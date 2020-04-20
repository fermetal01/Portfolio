package com.zemoga.Portfolio.services.impl;

import com.zemoga.Portfolio.dto.PortfolioDTO;
import com.zemoga.Portfolio.dto.StatusDTO;
import com.zemoga.Portfolio.model.Portfolio;
import com.zemoga.Portfolio.repositories.PortfolioRepository;
import com.zemoga.Portfolio.services.PortfolioService;
import com.zemoga.Portfolio.services.TwitterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Status;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    TwitterService twitterService;

    @Override
    public PortfolioDTO getPortfolioById(Long id) {
        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(id);
        PortfolioDTO portfolioDTO = null;
        if (portfolioOptional.isPresent()){
            Portfolio portfolio = portfolioOptional.get();
            portfolioDTO = getPortfolioDTO(portfolio);
            List<StatusDTO> statusDTOS = twitterService.getTwitterStatusesByUsername(portfolio.getTwitterUserName(), null);
            portfolioDTO.setStatuses(statusDTOS);
        }
        return portfolioDTO;
    }

    @Override
    public List<PortfolioDTO> getPortfolios() {
        List<Portfolio> portfolios = portfolioRepository.findAll();
        List<PortfolioDTO> portfolioDTOS = new ArrayList<>();
        for (Portfolio portfolio : portfolios) {
            portfolioDTOS.add(getPortfolioDTO(portfolio));
        }
        return portfolioDTOS;
    }

    @Override
    @Transactional
    public void updatePortfolio(Long id, PortfolioDTO portfolioDTO) {
        Portfolio portfolio = getPortfolioModel(portfolioDTO);
        portfolioRepository.save(portfolio);
    }

    private PortfolioDTO getPortfolioDTO(Portfolio portfolio){
        ModelMapper modelMapper = new ModelMapper();
        PortfolioDTO portfolioDTO = modelMapper.map(portfolio, PortfolioDTO.class);
        if(portfolioDTO.getStatuses() == null){
            portfolioDTO.setStatuses(new ArrayList<>());
        }
        return portfolioDTO;
    }

    private Portfolio getPortfolioModel(PortfolioDTO portfolioDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(portfolioDTO, Portfolio.class);
    }
}
