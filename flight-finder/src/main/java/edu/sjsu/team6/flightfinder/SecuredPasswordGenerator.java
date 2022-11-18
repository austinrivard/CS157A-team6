package edu.sjsu.team6.flightfinder;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Run this file after replacing rawPassword with your password
 */
public class SecuredPasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "mikewu";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println();
        System.out.println(encodedPassword);
        System.out.println();
    }

}