package com.zemoga.Portfolio.controller;

import com.zemoga.Portfolio.dto.PortfolioDTO;
import com.zemoga.Portfolio.services.PortfolioService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Api(value = "Portfolio Management System", description = "Operations enabled to handle Portfolio data")
@RestController
@RequestMapping("/api")
public class PortfolioAPIController {

    @Autowired
    PortfolioService portfolioService;

    @ApiOperation(value = "Get portfolio data by Id", httpMethod = "GET", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved portfolio"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/portfolio/{id}")
    public ResponseEntity<?> getPortfolio(@ApiParam(value = "Portfolio Identifier", required = true) @PathVariable long id){
        try {
            return new ResponseEntity<> (portfolioService.getPortfolioById(id), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Update portfolio data by PortfolioDTO", httpMethod = "PUT", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated portfolio"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping("/portfolio/update/{id}")
    public ResponseEntity<?> updatePortfolio(@ApiParam(value = "Portfolio object to update in database table", required = true)
                                                 @Valid @RequestBody PortfolioDTO portfolioDTO,
                                             @ApiParam(value = "Portfolio Identifier", required = true)
                                             @PathVariable long id) {
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
