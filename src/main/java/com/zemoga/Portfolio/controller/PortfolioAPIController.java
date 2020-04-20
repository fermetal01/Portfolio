package com.zemoga.Portfolio.controller;

import com.zemoga.Portfolio.dto.PortfolioDTO;
import com.zemoga.Portfolio.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PortfolioAPIController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping("/portfolio/{id}")
    public ResponseEntity<?> getPortfolio( @PathVariable long id){
        try {
            return new ResponseEntity<> (portfolioService.getPortfolioById(id), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/portfolio/update/{id}")
    public ResponseEntity<?> updatePortfolio(@Valid @RequestBody PortfolioDTO portfolioDTO, @PathVariable long id) {
        try{
            portfolioService.updatePortfolio(id, portfolioDTO);
            return new ResponseEntity<> (portfolioDTO, HttpStatus.OK);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<> (portfolioDTO, HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<> (portfolioDTO, HttpStatus.NOT_MODIFIED);
        }
    }
}
