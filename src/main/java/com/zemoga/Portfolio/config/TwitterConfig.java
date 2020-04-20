package com.zemoga.Portfolio.config;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

@Component
@Scope("singleton")
@Getter
public class TwitterConfig {

    public Twitter twitter;

    private TwitterConfig() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }
}
