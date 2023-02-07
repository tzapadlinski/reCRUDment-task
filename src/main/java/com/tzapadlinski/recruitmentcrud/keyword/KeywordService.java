package com.tzapadlinski.recruitmentcrud.keyword;

import java.util.List;

public interface KeywordService {
    public Keyword addKeyword(Keyword newKeyword);

    public List<Keyword> getAllKeywords();

    public Keyword getKeywordByText(String keywordText);

    public void deleteKeyword(Long keywordId);
}
