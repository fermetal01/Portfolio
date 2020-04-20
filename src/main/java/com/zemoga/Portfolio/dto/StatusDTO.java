package com.zemoga.Portfolio.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class StatusDTO {
    private Date createdAt;
    private long id;
    private String text;
    private String source;
    private UserDTO user;
    private String mediaURL;
    private String type;
}
