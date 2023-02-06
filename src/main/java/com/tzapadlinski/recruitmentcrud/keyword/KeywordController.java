package com.tzapadlinski.recruitmentcrud.keyword;

import com.tzapadlinski.recruitmentcrud.town.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Keywords should be pre-populated, so I added small API
to add new via Postman or CommandlineRunner.
 */
@RestController
@RequestMapping("/keyword")
public class KeywordController {
    private final KeywordService keywordService;

    @Autowired
    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    @PostMapping("/add")
    public Keyword addKeyword(@RequestBody Keyword newKeyword){
        return keywordService.addKeyword(newKeyword);
    }

    @GetMapping("/all")
    public List<Keyword> getAllKeywords(){
        return keywordService.getAllKeywords();
    }

    @DeleteMapping("/delete")
    public void deleteKeyword(@PathVariable Long keywordId){
        keywordService.deleteKeyword(keywordId);
    }
}
