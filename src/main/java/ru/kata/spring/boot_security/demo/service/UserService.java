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




import java.util.List;


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
        user.setRoles(new Role("USER"));
        userRepository.save(user);
    }

    @Transactional
    public User getUser(Long id) {
        return userRepository.getById(id);
    }


    @Transactional
    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }


    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(userRepository.getById(id));
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
        return user;
    }
}

