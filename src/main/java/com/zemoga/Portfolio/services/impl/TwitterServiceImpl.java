package com.zemoga.Portfolio.services.impl;

import com.zemoga.Portfolio.dto.StatusDTO;
import com.zemoga.Portfolio.dto.UserDTO;
import com.zemoga.Portfolio.services.TwitterService;
import com.zemoga.Portfolio.config.TwitterConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterServiceImpl implements TwitterService {

    private static final int NUMBER_OF_TWEETS = 5;
    final static Logger logger = Logger.getLogger(TwitterServiceImpl.class);
    @Autowired
    TwitterConfig twitterConfig;

    @Override
    public List<Status> getTweets(String user, Integer numberOfTweets) {
        Paging paging = new Paging();
        paging.count(numberOfTweets != null? numberOfTweets : NUMBER_OF_TWEETS);
        List<Status> statuses = null;
        try {
            statuses = twitterConfig.twitter.getUserTimeline(user, paging);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return statuses;
    }

    @Override
    public List<StatusDTO> getTwitterStatusesByUsername(String userName, Integer numberOfTweets){
        List<Status> statuses = getTweets(userName, numberOfTweets);
        List<StatusDTO> statusDTOS = new ArrayList<>();
        if (statuses != null && statuses.size() > 0) {
            for (Status status : statuses) {
                statusDTOS.add(getStatusDTO(status));
            }
        }
        return statusDTOS;
    }

    private StatusDTO getStatusDTO(Status status){
        ModelMapper modelMapper = new ModelMapper();
        StatusDTO statusDTO = modelMapper.map(status, StatusDTO.class);
        statusDTO.setUser(getUserDTO(status.getUser()));
        if (status.getMediaEntities().length > 0) {
            statusDTO.setMediaURL(status.getMediaEntities()[0].getMediaURL());
        }
        return statusDTO;
    }

    private UserDTO getUserDTO(User user){
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(user, UserDTO.class);
    }
}
