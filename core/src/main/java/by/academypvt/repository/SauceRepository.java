package by.academypvt.repository;

import by.academypvt.domain.entity.Sauce;


import java.util.List;

public interface SauceRepository {
    Sauce findSauceById(Long id);
    void addSauce(Sauce sauce);
    void deleteSauceById(Long id);
    List<Sauce> updateSauces();
}
