package com.bidding.platform.services;

import com.bidding.platform.models.Roles;
import com.bidding.platform.models.User;
import com.bidding.platform.objects.UserObject;
import com.bidding.platform.repositories.RolesRepository;
import com.bidding.platform.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;
    @Override
    public HashMap saveUser(UserObject userObject) {
        HashMap<String, Object> response = new HashMap<>();
        try {
            User existingUser = userRepository.findByEmail(userObject.getEmail());
            Roles role = rolesRepository.findById(userObject.getRole()).orElseThrow(()-> new IllegalArgumentException("Role does not exist"));
            if(existingUser!=null){
                response.put("message", "User already exist...");
                response.put("status", false);
            }
            else {
                String encodedPassword = passwordEncoder.encode(userObject.getPassword());
                User newUser = User.builder()
                        .email(userObject.getEmail())
                        .phoneNumber(userObject.getPhoneNumber())
                        .firstName(userObject.getFirstName())
                        .lastName(userObject.getLastName())
                        .password(encodedPassword)
                        .role(role)
                        .build();
                userRepository.save(newUser);
                response.put("message", "User saved successfully.");

                log.info("User has been saved successfully...");
            }
        }
        catch (Exception e){
            log.info(e.getMessage());
            e.printStackTrace();
            response.put("message", "Oops!Something went wrong!");
        }

        return response;
    }

    @Override
    public HashMap loginUser(UserObject userObject) {
        HashMap<String, String> response = new HashMap<>();
        try {
            User existingUser = userRepository.findByEmail(userObject.getEmail());
            if (existingUser==null){
                response.put("message", "User does not exist");
            }
            assert existingUser != null;
            if (passwordEncoder.matches(userObject.getPassword(), existingUser.getPassword())){
                response.put("message", "User login successful");
            }
            else {
                response.put("message", "invalid credentials");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(long id) {
        try {
            Optional<User> existingUser = userRepository.findById(id);
            if(existingUser.isPresent()){
                return existingUser.get();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
