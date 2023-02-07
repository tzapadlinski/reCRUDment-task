package com.tzapadlinski.recruitmentcrud.keyword.util;

import org.springframework.stereotype.Component;

@Component
public class KeywordUnifier {
    public String unify(String keyword){
        return keyword.trim().toLowerCase();
    }
}
