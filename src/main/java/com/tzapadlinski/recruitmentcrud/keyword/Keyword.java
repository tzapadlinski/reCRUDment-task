package com.tzapadlinski.recruitmentcrud.keyword;

import com.tzapadlinski.recruitmentcrud.campaign.Campaign;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "keywords")
    private Set<Campaign> campaigns = new LinkedHashSet<>();
}
