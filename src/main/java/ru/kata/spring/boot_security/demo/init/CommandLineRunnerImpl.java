package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public CommandLineRunnerImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*Role roleUser = new Role(2L, "ROLE_USER");
        Role roleAdmin = new Role(1L, "ROLE_ADMIN");
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleRepository.findById(1L).orElse(null));
        adminRoles.add(roleRepository.findById(2L).orElse(null));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleRepository.findById(2L).orElse(null));

        User userAdmin = new User();
        userAdmin.setName("ИванAdmin");
        userAdmin.setSurname("ИвановAdmin");
        userAdmin.setAge((byte) 26);
        userAdmin.setUsername("admin@ya.ru");
        userAdmin.setPassword("$2y$10$ysBa0yfzl2ghWf2r6k1xeOyVg7cQ7c9tjumXeNrDDguIh/FRTxhzW"); //admin
        userAdmin.setRoles(adminRoles);
        System.out.println(userAdmin);
        userRepository.save(userAdmin);

        User userUser = new User();
        userUser.setName("ИванUser");
        userUser.setSurname("ИвановUser");
        userUser.setAge((byte) 22);
        userUser.setUsername("user@ya.ru");
        userUser.setPassword("$2y$10$8Svqjb65XcTIaXNCOkzFdOdT6qO4DsFT63ra5wpDdur8s9GL67WHK"); //user
        userUser.setRoles(userRoles);
        userRepository.save(userUser);*/
    }
}
