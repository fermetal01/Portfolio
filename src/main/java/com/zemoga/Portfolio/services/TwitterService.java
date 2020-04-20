package com.zemoga.Portfolio.services;

import com.zemoga.Portfolio.dto.StatusDTO;
import twitter4j.Status;

import java.util.List;

public interface TwitterService {
    public List<Status> getTweets(String user, Integer numberOfTweets);
    public List<StatusDTO> getTwitterStatusesByUsername(String userName, Integer numberOfTweets);
}
