package com.tzapadlinski.recruitmentcrud.util;

import org.springframework.stereotype.Component;

@Component
public class KeywordUnifier {
    public String unify(String keyword){
        String unifiedString = keyword.trim().toLowerCase();
        return unifiedString;
    }
}
