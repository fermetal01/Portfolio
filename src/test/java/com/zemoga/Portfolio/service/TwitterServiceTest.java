package com.zemoga.Portfolio.service;

import com.zemoga.Portfolio.dto.PortfolioDTO;
import com.zemoga.Portfolio.dto.StatusDTO;
import com.zemoga.Portfolio.dto.UserDTO;
import com.zemoga.Portfolio.services.TwitterService;
import com.zemoga.Portfolio.config.TwitterConfig;
import com.zemoga.Portfolio.services.impl.TwitterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import twitter4j.Paging;
import twitter4j.Status;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwitterServiceTest {

    List<StatusDTO> mockedStatusDTOS = new ArrayList<>();
    StatusDTO mockedStatusDTO = new StatusDTO();
    UserDTO mockedUserDTO = new UserDTO();
    Paging paging = new Paging();
    List<Status> statuses = new ArrayList<>();

    @Mock
    TwitterConfig twitterConfig;

    @InjectMocks
    private TwitterService twitterService = new TwitterServiceImpl();

    @BeforeEach
    void setMockOutput() throws Exception {
        mockedUserDTO.setDescription("Lord Commander of the Night's Watch and King of the Free Folk. Not affiliated with HBO. (Parody Account) #GameOfThrones");
        mockedUserDTO.setName("Jon Snow");
        mockedUserDTO.setProfileImageURL("http://pbs.twimg.com/profile_images/901947348699545601/hqRMHITj_normal.jpg");
        mockedUserDTO.setScreenName("LordSnow");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        mockedStatusDTO.setId(1L);
        mockedStatusDTO.setCreatedAt(dateFormat.parse("20200419", new ParsePosition(0)));
        mockedStatusDTO.setSource("<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android</a>");
        mockedStatusDTO.setText("https://t.co/ZEB9QKk1BZ");
        mockedStatusDTO.setMediaURL("http://pbs.twimg.com/media/EV9ZZV8XgAAQCSI.jpg");
        mockedStatusDTO.setType("<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android</a>");
        mockedStatusDTO.setUser(mockedUserDTO);
        paging.count(5);

        //when(twitterConfig.twitter.getUserTimeline("LordSnow", paging)).thenReturn(statuses1);
    }

    @DisplayName("Test Mock TwitterService - Get Statuses by Username")
    @Test
    void testTwitterStatusesByUsername() {
        assertEquals(new ArrayList<PortfolioDTO>(), twitterService.getTwitterStatusesByUsername("LordSnow", 1));
    }
}
