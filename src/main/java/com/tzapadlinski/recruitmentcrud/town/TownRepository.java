package com.tzapadlinski.recruitmentcrud.town;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    public Optional<Town> findTownByTownName(String townName);
}
