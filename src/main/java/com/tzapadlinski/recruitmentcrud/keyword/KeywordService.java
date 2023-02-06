package com.tzapadlinski.recruitmentcrud.keyword;

import com.tzapadlinski.recruitmentcrud.town.Town;

import java.util.List;

public interface KeywordService {
    public Keyword addKeyword(Keyword newKeyword);

    public List<Keyword> getAllKeywords();

    public void deleteKeyword(Long keywordId);
}
