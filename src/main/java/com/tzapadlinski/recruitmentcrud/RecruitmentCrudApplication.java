package com.tzapadlinski.recruitmentcrud;

import com.tzapadlinski.recruitmentcrud.campaign.Campaign;
import com.tzapadlinski.recruitmentcrud.campaign.CampaignService;
import com.tzapadlinski.recruitmentcrud.keyword.Keyword;
import com.tzapadlinski.recruitmentcrud.keyword.KeywordService;
import com.tzapadlinski.recruitmentcrud.town.Town;
import com.tzapadlinski.recruitmentcrud.town.TownService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashSet;

@SpringBootApplication
public class RecruitmentCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentCrudApplication.class, args);
    }

    @Bean
    CommandLineRunner run(TownService townService,
                          KeywordService keywordService,
                          CampaignService campaignService) {
        return args -> {
            townService.addTown(new Town(null, "Cracow"));
            Town exampleTown = townService.addTown(new Town(null, "Wieliczka"));
            townService.addTown(new Town(null, "Warsaw"));
            townService.addTown(new Town(null, "Wroclaw"));
            townService.addTown(new Town(null, "Gdansk"));

            Keyword examleKeyword = keywordService.addKeyword(new Keyword(null, "Food", null));
            keywordService.addKeyword(new Keyword(null, "Beverage", null));
            keywordService.addKeyword(new Keyword(null, "Electronics", null));
            keywordService.addKeyword(new Keyword(null, "Smartphone", null));
            keywordService.addKeyword(new Keyword(null, "Headphones", null));
            keywordService.addKeyword(new Keyword(null, "Books", null));
            keywordService.addKeyword(new Keyword(null, "Sci-fi", null));

            campaignService.addCampaign(
                    new Campaign(
                            null,
                            "Campaign1",
                            new LinkedHashSet<>(Arrays.asList(examleKeyword)),
                            new BigDecimal("2000.00"),
                            new BigDecimal("2000.00"),
                            true,
                            exampleTown,
                            25
                    ));
        };
    }

}
