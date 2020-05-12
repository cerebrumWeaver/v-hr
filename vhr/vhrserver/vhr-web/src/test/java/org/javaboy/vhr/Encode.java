package org.javaboy.vhr;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encode {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassowrd = encoder.encode("ytfytm");
        System.out.println(encodePassowrd);
    }
}
