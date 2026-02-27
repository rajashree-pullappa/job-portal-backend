package com.jobportal.temp;
import org.mindrot.jbcrypt.BCrypt;
public class PasswordGenerator {
    public static void main(String[]args){
        String adminPassword = "admin123";
        String userPassword = "1234";
        String adminHashed = BCrypt.hashpw(adminPassword,BCrypt.gensalt());
        String userHashed = BCrypt.hashpw(userPassword,BCrypt.gensalt());
        System.out.println("Admin password: "+ adminHashed);
        System.out.println("User password: "+ userHashed);
    }
}
