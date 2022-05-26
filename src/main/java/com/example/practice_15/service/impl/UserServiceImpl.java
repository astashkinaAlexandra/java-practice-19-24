package com.example.practice_15.service.impl;


import com.example.practice_15.dto.UserRegistrationDto;
import com.example.practice_15.model.Role;
import com.example.practice_15.model.User;
import com.example.practice_15.repository.UserRepository;
import com.example.practice_15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user;

        if (Objects.equals(registrationDto.getEmail(), "astashkina_alexandra@mail.ru")) {
            user = new User(registrationDto.getFirstName(),
                    registrationDto.getLastName(), registrationDto.getEmail(),
                    passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_ADMIN")));
        } else {
            user = new User(registrationDto.getFirstName(),
                    registrationDto.getLastName(), registrationDto.getEmail(),
                    passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        }
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}