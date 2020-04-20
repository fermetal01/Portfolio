package com.zemoga.Portfolio.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDTO {
    private Long id;
    private String title;
    private String imageURL;
    private String description;
    private String twitterUserName;
    private List<StatusDTO> statuses;
}


