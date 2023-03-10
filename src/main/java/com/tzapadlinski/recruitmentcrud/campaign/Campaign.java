package com.tzapadlinski.recruitmentcrud.campaign;

import com.tzapadlinski.recruitmentcrud.keyword.Keyword;
import com.tzapadlinski.recruitmentcrud.town.Town;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @NotEmpty
    private String campaignName;

    @ManyToMany
    @JoinTable(name = "campaigns_keywords",
            joinColumns = @JoinColumn(name = "campaign_campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "keywords_keyword_id"))
    private Set<Keyword> keywords = new LinkedHashSet<>();

    @Column(name = "bid_amount", nullable = false, precision = 12, scale = 2)
    @DecimalMin(value = "1000.00", message = "Minimal bid amount is 1000.0.")
    @Digits(integer = 10, fraction = 2, message = "Integer part shouldn't be greater" +
            " than 10 digits and fraction part shouldn't be greater than 2 digits.")
    @NotNull
    private BigDecimal bidAmount;

    //Didn't really know what is Emerald, so I left it just like bidAmount (without min)
    @Column(name = "campaign_fund", nullable = false, precision = 12, scale = 2)
    @Digits(integer = 10, fraction = 2, message = "Integer part shouldn't be greater" +
            " than 10 digits and fraction part shouldn't be greater than 2 digits.")
    @NotNull
    private BigDecimal campaignFund;

    @Column(name = "status", nullable = false)
    @NotNull
    private Boolean status;

    //Assumed, that campaign has only one town
    @ManyToOne(optional = false)
    @JoinColumn(name = "town_id", nullable = false)
    private Town town;

    @Column(name = "radius", nullable = false)
    @NotNull
    private Integer radius;
}
