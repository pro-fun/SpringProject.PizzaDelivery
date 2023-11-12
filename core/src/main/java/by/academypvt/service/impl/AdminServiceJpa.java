//package by.academypvt.service.impl;
//
//import by.academypvt.dto.user.UserResponse;
//import by.academypvt.mapper.UserMapper;
//import by.academypvt.repository.UserRepository;
//import by.academypvt.service.AdminService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//@Service
//@AllArgsConstructor
//public class AdminServiceJpa implements AdminService {
//    private final UserRepository userRepository;
//    private final UserMapper userMapper;
//    @Override
//    public void deleteUserById(Long id) {
//        userRepository.deleteUserById(id);
//    }
//
//    @Override
//    public List<UserResponse> updateUsers() {
//        return userRepository.updateUsers().stream().map(userMapper::toResponse).collect(Collectors.toList());
//    }
//
//    @Override
//    public UserResponse findUserById(Long id) {
//        return userMapper.toResponse(userRepository.findUserById(id));
//    }
//}
