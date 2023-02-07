package com.tzapadlinski.recruitmentcrud.keyword;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "keywords")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "keyword_id", nullable = false)
    private Long keywordId;

    @Column(name = "keyword_text", nullable = false, unique = true)
    private String keywordText;
}
