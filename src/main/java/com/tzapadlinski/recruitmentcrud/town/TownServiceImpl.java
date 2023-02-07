package com.tzapadlinski.recruitmentcrud.town;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService{
    private final TownRepository townRepository;


    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public Town addTown(Town newTown) {
        return townRepository.save(newTown);
    }

    @Override
    public List<Town> getAllTowns() {
        return townRepository.findAll();
    }

    @Override
    public Town getTownByName(String townName) {
        Optional<Town> queriedTown =
                townRepository.findTownByTownName(townName);
        if (queriedTown.isEmpty())
            throw new IllegalStateException("There's no town as "
                    + townName + ".");
        return queriedTown.get();
    }

    @Override
    public void deleteTown(Long townId) {
        if (!townRepository.existsById(townId))
            throw new IllegalStateException(
                    "There's no town with that id.");
        townRepository.deleteById(townId);
    }
}
