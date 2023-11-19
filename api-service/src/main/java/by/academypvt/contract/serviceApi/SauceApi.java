package by.academypvt.contract.serviceApi;

import by.academypvt.dto.sauce.SauceRequest;
import by.academypvt.dto.sauce.SauceResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SauceApi {
    List<SauceResponse> allSauces();
    SauceResponse addSauce(SauceRequest sauceRequest);
    void deleteSauce(Long id);
}
