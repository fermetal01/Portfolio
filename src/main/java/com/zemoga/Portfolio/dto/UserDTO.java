package com.zemoga.Portfolio.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String screenName;
    private String description;
    private String profileImageURL;
}
