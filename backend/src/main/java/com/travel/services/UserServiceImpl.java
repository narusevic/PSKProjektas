package com.travel.services;

import com.travel.models.Role;
import com.travel.models.User;
import com.travel.repositories.RoleRepository;
import com.travel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        HashSet<Role> participantRoles = new HashSet<>(roleRepository.findByName("PARTICIPANT"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(participantRoles);
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Set<User> findByRole(String roleName) {
        List<Role> roles = roleRepository.findByName(roleName);

        if (roles.size() == 0) {
            return new HashSet<User>();
        }

        return roles.get(0).getUsers();
    }

    @Override
    public User findById(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Boolean hasRole(User user, String roleName) {
        Set<Role> roles = user.getRoles();
        Boolean hasRole = false;

        for (Role role: roles) {
            System.out.println(role.getName());
            if (role.getName().equals(roleName)) {
                hasRole = true;
            }
        }

        return hasRole;
    }

    @Override
    public void addRole(User user, String roleName) {
        Set<Role> roles = user.getRoles();
        Role role = roleRepository.findByName("ORGANIZER").get(0);
        roles.add(role);
        userRepository.save(user);
    }

    @Override
    public void removeRole(User user, String roleName) {
        Set<Role> roles = user.getRoles();
        Role role = roleRepository.findByName("ORGANIZER").get(0);
        roles.remove(role);
        userRepository.save(user);
    }
}