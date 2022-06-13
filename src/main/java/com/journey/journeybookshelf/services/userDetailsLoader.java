package com.journey.journeybookshelf.services;

import com.journey.journeybookshelf.models.User;
import com.journey.journeybookshelf.models.UserwithRoles;
import com.journey.journeybookshelf.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class userDetailsLoader implements UserDetailsService {
    private final UserRepository users;


    public userDetailsLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserwithRoles(user);
    }
}

