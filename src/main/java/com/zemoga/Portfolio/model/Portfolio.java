package com.zemoga.Portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idportfolio")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "image_url")
    private String imageURL;
    @Column(name = "twitter_user_name")
    private String twitterUserName;
    @Column(name = "title")
    private String title;
}
