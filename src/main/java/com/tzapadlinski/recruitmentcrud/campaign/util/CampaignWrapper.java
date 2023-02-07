package com.tzapadlinski.recruitmentcrud.campaign.util;

import com.tzapadlinski.recruitmentcrud.campaign.Campaign;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CampaignWrapper {
    @Valid
    private Campaign campaign;

    private String keywords;

    private String townName;
}
