package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demo.enums.ApplicationUserRoles.*;

@Repository("fake")
public class ApplicationFakeUserDAOImpl implements ApplicationUserDAO {

    private final PasswordEncoder passwordEncoder;

    public ApplicationFakeUserDAOImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String name) {
        return getApplicationUsers().stream()
                .filter(applicationUser -> applicationUser.getUsername().equals(name))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        STUDENT.getGrantedAuthorities(),
                        "annasmith",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        "linda",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN_TRAINEE.getGrantedAuthorities(),
                        "tom",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}
