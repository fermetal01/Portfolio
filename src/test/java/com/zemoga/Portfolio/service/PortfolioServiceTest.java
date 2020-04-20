package com.zemoga.Portfolio.service;

import com.zemoga.Portfolio.dto.PortfolioDTO;
import com.zemoga.Portfolio.dto.StatusDTO;
import com.zemoga.Portfolio.dto.UserDTO;
import com.zemoga.Portfolio.model.Portfolio;
import com.zemoga.Portfolio.repositories.PortfolioRepository;
import com.zemoga.Portfolio.services.PortfolioService;
import com.zemoga.Portfolio.services.TwitterService;
import com.zemoga.Portfolio.services.impl.PortfolioServiceImpl;
import com.zemoga.Portfolio.services.impl.TwitterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.SimpleFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PortfolioServiceTest {

    Portfolio mockedPortfolio = new Portfolio();
    List<StatusDTO> mockedStatusDTOS = new ArrayList<>();
    StatusDTO mockedStatusDTO = new StatusDTO();
    UserDTO mockedUserDTO = new UserDTO();
    List<Portfolio> mockedListPortfolio = new ArrayList<>();


    @Mock
    private PortfolioRepository portfolioRepository;

    @Mock
    private TwitterService twitterService = new TwitterServiceImpl();

    @InjectMocks
    private PortfolioService portfolioService = new PortfolioServiceImpl();

    @BeforeEach
    void setMockOutput() {
        mockedPortfolio.setId(1L);
        mockedPortfolio.setDescription("Lord Commander of the Night's Watch and King of the Free Folk");
        mockedPortfolio.setImageURL("https://pbs.twimg.com/profile_images/901947348699545601/hqRMHITj_400x400.jpg");
        mockedPortfolio.setTitle("Juan Nieve!");
        mockedPortfolio.setTwitterUserName("LordSnow");
        when(portfolioRepository.findById(1L)).thenReturn(Optional.of(mockedPortfolio));

        mockedListPortfolio.add(mockedPortfolio);
        when(portfolioRepository.findAll()).thenReturn(mockedListPortfolio);

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
        when(twitterService.getTwitterStatusesByUsername("LordSnow", null)).thenReturn(mockedStatusDTOS);;
    }

    private PortfolioDTO getPortfolioDTO() {
        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setId(1L);
        portfolioDTO.setDescription("Lord Commander of the Night's Watch and King of the Free Folk");
        portfolioDTO.setImageURL("https://pbs.twimg.com/profile_images/901947348699545601/hqRMHITj_400x400.jpg");
        portfolioDTO.setTitle("Juan Nieve!");
        portfolioDTO.setTwitterUserName("LordSnow");
        portfolioDTO.setStatuses(new ArrayList<>());
        return portfolioDTO;
    }

    @DisplayName("Test Mock PortfolioService - Get Portfolio By Id")
    @Test
    void testGetPortfolioById() {
        PortfolioDTO portfolioDTO = getPortfolioDTO();
        assertEquals(portfolioDTO, portfolioService.getPortfolioById(1L));
    }

    @DisplayName("Test Mock PortfolioService - Get Portfolios")
    @Test
    void testGetPortfolios() {
        PortfolioDTO portfolioDTO = getPortfolioDTO();
        List <PortfolioDTO> portfolioDTOS = new ArrayList<>();
        portfolioDTOS.add(portfolioDTO);
        assertEquals(portfolioDTOS, portfolioService.getPortfolios());
    }
}
