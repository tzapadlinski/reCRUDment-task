package com.tzapadlinski.recruitmentcrud.campaign;

import com.tzapadlinski.recruitmentcrud.campaign.util.CampaignWrapper;
import com.tzapadlinski.recruitmentcrud.keyword.Keyword;
import com.tzapadlinski.recruitmentcrud.keyword.KeywordService;
import com.tzapadlinski.recruitmentcrud.keyword.util.KeywordUnifier;
import com.tzapadlinski.recruitmentcrud.town.Town;
import com.tzapadlinski.recruitmentcrud.town.TownService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/campaign")
public class CampaignController {
    private final CampaignService campaignService;

    private final KeywordService keywordService;

    private final TownService townService;

    private final KeywordUnifier unifier;

    @Autowired
    public CampaignController(CampaignService campaignService,
                              KeywordService keywordService,
                              TownService townService,
                              KeywordUnifier unifier) {
        this.campaignService = campaignService;
        this.keywordService = keywordService;
        this.townService = townService;
        this.unifier = unifier;
    }

    @GetMapping("/add")
    public String addCampaignForm(Model model){
        CampaignWrapper wrapper = new CampaignWrapper();
        wrapper.setCampaign(new Campaign());
        model.addAttribute("campaignWrapper", wrapper);
        model.addAttribute("towns", townService.getAllTowns());
        return "Add";
    }

    @PostMapping("/add")
    public String addCampaign(@ModelAttribute @Valid CampaignWrapper wrapper,
                              BindingResult result){
        if (result.hasErrors())
            return "redirect:/campaign/add";
        Campaign newCampaign = wrapper.getCampaign();
        //I know it will negatively cause performance, but couldn't find any way around it
        Town town = townService.getTownByName(wrapper.getTownName());
        newCampaign.setTown(town);
        Set<Keyword> keywords;
        try {
            keywords = getKeywordsFromString(wrapper.getKeywords());
        } catch (IllegalStateException e){
            e.printStackTrace();
            return "redirect:/campaign/add";
        }
        newCampaign.setKeywords(keywords);
        campaignService.addCampaign(newCampaign);
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
    public String updateCampaignForm(@RequestParam(name = "id") Long campaignId,
                                     Model model){
        Campaign campaignToUpdate = campaignService.getCampaignById(campaignId);
        model.addAttribute("campaign", campaignToUpdate);
        return "Update";
    }

    @PutMapping("/update")
    public String updateCampaign(@RequestBody @Valid Campaign updatedCampaign,
                                 BindingResult result){
        if (result.hasErrors())
            return "redirect:/campaign/update?id=" + updatedCampaign.getCampaignId();
        //TODO finish
        return "redirect:/campaign/all";
    }

    private Set<Keyword> getKeywordsFromString(String keywordsString){
        Set<Keyword> keywords = new LinkedHashSet<>();
        String [] keywordTexts = keywordsString.split(" ");
        for (String text : keywordTexts) {
            Keyword extractedKeyword = keywordService.getKeywordByText(unifier.unify(text));
            keywords.add(extractedKeyword);
        }
        return keywords;
    }
}
