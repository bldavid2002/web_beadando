package org.example.service.impl;

import org.example.config.CustumUserDetails;
import org.example.dto.UserRegistrationDto;
import org.example.model.AuthorModel;
import org.example.model.Role;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }
    @Override
    public UserRegistrationDto save(UserRegistrationDto registrationDto) {
        User entity = userMapper.userRegistrationDtoToUser(registrationDto);

        entity = userRepository.save(entity);

        return  userMapper.userToUserRegistrationDto(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User Not FOUND");
        }

        return  new CustumUserDetails(user);
    }
}