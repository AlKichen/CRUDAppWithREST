package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    @Autowired
    public UserService(UserRepository userDao, RoleRepository roleRepository) {
        this.userRepository = userDao;
        this.roleRepository = roleRepository;
    }


    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Transactional
    public void createNewUser(User user) {
        Set<Role> roleSetOld = user.getRoles();
        Set<Role> roleSetNew = new HashSet<>();
        List<String> nameOfRoles = roleSetOld.stream().map(Role::getName).collect(Collectors.toList());
        for (String role : nameOfRoles) {
            if (role.equals("ROLE_ADMIN")) {
                roleSetNew.add(roleRepository.findById(1L).orElse(null));
            } else if (role.equals("ROLE_USER")) {
                roleSetNew.add(roleRepository.findById(2L).orElse(null));
            }
        }
        user.setRoles(roleSetNew);
        userRepository.save(user);
    }

    @Transactional
    public User getUser(Long id) {
        return userRepository.findById(id).get();  // было: userRepository.getById(id);
    }


    @Transactional
    public void updateUser(User updatedUser) {
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
        if (user == null) {
            throw new UsernameNotFoundException("Polzovatel' ne naid'en");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}

