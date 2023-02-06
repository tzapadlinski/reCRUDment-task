package com.tzapadlinski.recruitmentcrud.campaign;

import com.tzapadlinski.recruitmentcrud.keyword.Keyword;
import com.tzapadlinski.recruitmentcrud.town.Town;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "campaigns")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "campaign_id", nullable = false)
    private Long campaignId;

    @Column(name = "campaign_name", nullable = false)
    private String campaignName;

    @ManyToMany
    @JoinTable(name = "campaigns_keywords",
            joinColumns = @JoinColumn(name = "campaign_campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "keywords_keyword_id"))
    private Set<Keyword> keywords = new LinkedHashSet<>();

    @Column(name = "bid_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal bidAmount;

    //Didn't really know what is Emerald, so I left it just like bidAmount
    @Column(name = "campaign_fund", nullable = false, precision = 12, scale = 2)
    private BigDecimal campaignFund;

    @Column(name = "status", nullable = false)
    private Boolean status;

    //Assumed, that campaign has only one town
    @ManyToOne(optional = false)
    @JoinColumn(name = "town_id", nullable = false)
    private Town town;

    @Column(name = "radius", nullable = false)
    private Integer radius;
}
