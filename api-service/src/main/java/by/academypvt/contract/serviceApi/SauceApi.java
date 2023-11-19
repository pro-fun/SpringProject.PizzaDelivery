package by.academypvt.contract.serviceApi;

import by.academypvt.dto.sauce.SauceRequest;
import by.academypvt.dto.sauce.SauceResponse;

import java.util.List;

public interface SauceApi {
    List<SauceResponse> allSauces();
    SauceResponse addSauce(SauceRequest sauceRequest);
}
