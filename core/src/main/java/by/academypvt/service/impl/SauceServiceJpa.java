package by.academypvt.service.impl;

import by.academypvt.domain.entity.Sauce;
import by.academypvt.repository.SauceRepository;
import by.academypvt.service.SauceService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SauceServiceJpa implements SauceService {
    private final SauceRepository sauceRepository;

    @Override
    public Sauce findSauceById(Long id) {
        return sauceRepository.findSauceById(id);
    }

    @Override
    public void addSauce(Sauce sauce) {
        sauceRepository.addSauce(sauce);
    }

    @Override
    public void deleteSauceById(Long id) {
        sauceRepository.deleteSauceById(id);
    }

    @Override
    public List<Sauce> updateSauces() {
        return sauceRepository.updateSauces();
    }
}
