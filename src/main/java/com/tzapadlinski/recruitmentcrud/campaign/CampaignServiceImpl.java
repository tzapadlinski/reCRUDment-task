package com.tzapadlinski.recruitmentcrud.campaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignServiceImpl implements CampaignService{
    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign addCampaign(Campaign newCampaign) {
        return campaignRepository.save(newCampaign);
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    @Override
    public Campaign getCampaignById(Long campaignId) {
        Optional<Campaign> queriedCampaign = campaignRepository.findById(campaignId);
        if (queriedCampaign.isEmpty())
            throw new IllegalStateException("There's no campaign with that id.");
        return queriedCampaign.get();
    }

    @Override
    public void deleteCampaign(Long campaignId) {
        if (!campaignRepository.existsById(campaignId))
            throw new IllegalStateException("There's no campaign with that id.");
        campaignRepository.deleteById(campaignId);
    }

    @Override
    public Campaign updateCampaign(Campaign newCampaign) {
        if (!campaignRepository.existsById(newCampaign.getCampaignId()))
            throw new IllegalStateException("Campaign you are trying" +
                    " to update does not exist.");
        return campaignRepository.save(newCampaign);
    }
}
