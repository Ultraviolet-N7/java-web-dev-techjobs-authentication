package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}


    // Use encoder to create a hash from the given password
    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    // Determine if a given password is a match for the hash stored by the object
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getUsername() {
        return username;
    }

}
