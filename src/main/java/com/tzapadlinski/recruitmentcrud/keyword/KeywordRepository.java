package com.tzapadlinski.recruitmentcrud.keyword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    public Optional<Keyword> findKeywordByKeywordText(String keywordText);
}
