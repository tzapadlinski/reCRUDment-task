package com.tzapadlinski.recruitmentcrud.town;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "towns")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "town_id", nullable = false)
    private Long townId;

    @Column(name = "town_name", nullable = false, unique = true)
    private String townName;
}
