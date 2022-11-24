package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.model.User;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userDao) {
        this.userRepository = userDao;
    }


    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Transactional
    public void createNewUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_USER"));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Transactional
    public User getUser(Long id) {
        return userRepository.findById(id).get();  // было: userRepository.getById(id);
    }


    @Transactional
    public void updateUser(User updatedUser) {
        System.out.println("Роли которые пришли в модель:" + updatedUser.getRoles());
        userRepository.save(updatedUser);
    }


    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(userRepository.findById(id).get());
    }


    @Transactional
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Polzovatel' ne naid'en");
        }
        return  new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}

