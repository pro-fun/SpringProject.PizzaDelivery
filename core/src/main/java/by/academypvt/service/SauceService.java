package by.academypvt.service;

import by.academypvt.domain.entity.Sauce;

import java.util.List;

public interface SauceService {
    Sauce findSauceById(Long id);
    void addSauce(Sauce sauce);
    void deleteSauceById(Long id);
    List<Sauce> updateSauces();
}
