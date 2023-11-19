package by.academypvt.service.impl;

import by.academypvt.contract.serviceApi.SauceApi;
import by.academypvt.domain.entity.Sauce;
import by.academypvt.dto.sauce.SauceRequest;
import by.academypvt.dto.sauce.SauceResponse;
import by.academypvt.errors.FoodEntityException;
import by.academypvt.mapper.SauceMapper;
import by.academypvt.repository.spring.SauceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SauceServiceImpl implements SauceApi {
    private final SauceRepository sauceRepository;
    private final SauceMapper sauceMapper;

    @Override
    public List<SauceResponse> allSauces() {
        return sauceRepository.findAll().stream().map(sauceMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public SauceResponse addSauce(SauceRequest sauceRequest) {
        if (sauceRepository.findByName(sauceRequest.getName()) != null) {
            throw new FoodEntityException("Данный соус уже есть в базе данных");
        }
        Sauce sauce = sauceMapper.toEntity(sauceRequest);
        return sauceMapper.toResponse(sauceRepository.save(sauce));
    }
}

