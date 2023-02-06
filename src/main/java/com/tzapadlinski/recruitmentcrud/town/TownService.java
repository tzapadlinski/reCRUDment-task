package com.tzapadlinski.recruitmentcrud.town;

import java.util.List;

public interface TownService {
    public Town addTown(Town newTown);

    public List<Town> getAllTowns();

    public void deleteTown(Long townId);
}
