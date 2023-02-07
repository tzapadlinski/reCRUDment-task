package com.tzapadlinski.recruitmentcrud.campaign;

import com.tzapadlinski.recruitmentcrud.util.KeywordUnifier;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/campaign")
public class CampaignController {
    private final CampaignService campaignService;

    private final KeywordUnifier unifier;

    @Autowired
    public CampaignController(CampaignService campaignService, KeywordUnifier unifier) {
        this.campaignService = campaignService;
        this.unifier = unifier;
    }

    @GetMapping("/add")
    public String addCampaignForm(Model model){
        model.addAttribute("campaign", new Campaign());
        return "Add";
    }

    @PostMapping("/add")
    public String addCampaign(@RequestBody @Valid  Campaign newCampaign, BindingResult result){
        if (result.hasErrors())
            return "redirect:/campaign/add";
        //TODO finish
        return "redirect:/campaign/all";
    }

    @GetMapping("/all")
    public String getAllCampaigns(Model model){
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        model.addAttribute("campaigns", campaigns);
        return "List";
    }

    @PostMapping("/delete") //doesn't work as @DeleteMapping
    public String deleteCampaign(@RequestParam(name = "id") Long campaignId){
        campaignService.deleteCampaign(campaignId);
        return "redirect:/campaign/all";
    }

    @GetMapping("/update")
    public String updateCampaignForm(@RequestParam(name = "id") Long campaignId, Model model){
        Campaign campaignToUpdate = campaignService.getCampaignById(campaignId);
        model.addAttribute("campaign", campaignToUpdate);
        return "Update";
    }

    @PutMapping("/update")
    public String updateCampaign(@RequestBody @Valid Campaign updatedCampaign, BindingResult result){
        if (result.hasErrors())
            return "redirect:/campaign/update?id=" + updatedCampaign.getCampaignId();
        //TODO finish
        return "redirect:/campaign/all";
    }
}
