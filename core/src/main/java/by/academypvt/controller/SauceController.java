package by.academypvt.controller;

import by.academypvt.contract.restApi.SauceRestApi;
import by.academypvt.contract.serviceApi.SauceApi;
import by.academypvt.dto.sauce.SauceRequest;
import by.academypvt.dto.sauce.SauceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SauceController implements SauceRestApi {
    private final SauceApi sauceService;

    @Override
    public List<SauceResponse> allSauces() {
        return sauceService.allSauces();
    }

    @Override
    public SauceResponse addSauce(SauceRequest sauceRequest) {
        return sauceService.addSauce(sauceRequest);
    }
}
