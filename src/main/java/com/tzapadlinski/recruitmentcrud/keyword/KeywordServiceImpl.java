package com.tzapadlinski.recruitmentcrud.keyword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService{
    private final KeywordRepository keywordRepository;

    @Autowired
    public KeywordServiceImpl(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Override
    public Keyword addKeyword(Keyword newKeyword) {
        return keywordRepository.save(newKeyword);
    }

    @Override
    public List<Keyword> getAllKeywords() {
        return keywordRepository.findAll();
    }

    @Override
    public void deleteKeyword(Long keywordId) {
        if (keywordRepository.existsById(keywordId))
            throw new IllegalStateException("There's no keyword with that id.");
        keywordRepository.deleteById(keywordId);
    }
}
