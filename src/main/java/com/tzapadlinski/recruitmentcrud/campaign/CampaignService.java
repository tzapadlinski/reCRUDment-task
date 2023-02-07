package com.tzapadlinski.recruitmentcrud.campaign;

import java.util.List;

public interface CampaignService {
    Campaign addCampaign(Campaign newCampaign);

    List<Campaign> getAllCampaigns();

    Campaign getCampaignById(Long campaignId);

    void deleteCampaign(Long campaignId);

    Campaign updateCampaign(Campaign newCampaign);
}
