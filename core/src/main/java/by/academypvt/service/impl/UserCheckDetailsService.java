package by.academypvt.service.impl;

import by.academypvt.contract.serviceApi.UserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserCheckDetailsService implements UserDetailsService {
    private final UserApi userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userService.loadUserByUsername(username);
        return userDetails;
    }
}
