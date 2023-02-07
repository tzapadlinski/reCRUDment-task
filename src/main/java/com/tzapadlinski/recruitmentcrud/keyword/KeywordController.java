package com.tzapadlinski.recruitmentcrud.keyword;

import com.tzapadlinski.recruitmentcrud.keyword.util.KeywordUnifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Keywords should be pre-populated with typehead, so I added small API
to add new via Postman or CommandlineRunner.
 */
@RestController
@RequestMapping("/keyword")
public class KeywordController {
    private final KeywordService keywordService;

    private final KeywordUnifier unifier;

    @Autowired
    public KeywordController(KeywordService keywordService, KeywordUnifier unifier) {
        this.keywordService = keywordService;
        this.unifier = unifier;
    }

    @PostMapping("/add")
    public Keyword addKeyword(@RequestBody Keyword newKeyword){
        unify(newKeyword);
        return keywordService.addKeyword(newKeyword);
    }

    @GetMapping("/all")
    public List<Keyword> getAllKeywords(){
        return keywordService.getAllKeywords();
    }

    @DeleteMapping("/delete")
    public void deleteKeyword(@RequestParam Long keywordId){
        keywordService.deleteKeyword(keywordId);
    }

    private void unify(Keyword keyword){
        String unifiedKeywordText = unifier.unify(keyword.getKeywordText());
        keyword.setKeywordText(unifiedKeywordText);
    }
}
