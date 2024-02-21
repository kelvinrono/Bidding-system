//package com.bidding.platform.services;
//
//import com.bidding.platform.models.Roles;
//import com.bidding.platform.models.User;
//import com.bidding.platform.repositories.UserRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public MyUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (Roles role : user.getRoles()) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//
//        return new User(user.getUsername(), user.getPassword(), authorities);
//    }
//}
//
