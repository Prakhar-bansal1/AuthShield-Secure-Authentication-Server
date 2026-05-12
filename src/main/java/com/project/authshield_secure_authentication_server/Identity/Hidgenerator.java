package com.project.authshield_secure_authentication_server.Identity;

import java.util.UUID;

public class Hidgenerator {
    private Hidgenerator(){

    }
     public static String generateHid(){
        return "Hid-" + UUID.randomUUID()
        .toString()
        .substring(0, 10)
        .replace("-", "")
        .toUpperCase();
     }
}
