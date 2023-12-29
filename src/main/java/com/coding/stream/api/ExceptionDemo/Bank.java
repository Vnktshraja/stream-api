package com.coding.stream.api.ExceptionDemo;
import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;


@Component
@Slf4j
public class Bank {

    public void toGiveThreeChance() {
        ATM atm = new ATM();
        try {
            atm.login();
            atm.verify();
        }catch (Exception e){
            log.info("Enter correct info try 2nd time" );
            try {
                atm.login();
                atm.verify();
            } catch (Exception ex) {
                log.info("Enter correct info try 3rd time" );
                try {
                    atm.login();
                    atm.verify();
                } catch (Exception exc) {
                    log.info("Your Account is Blocked..!" );
                }
            }
        }
    }

    public void toGive10Chance() {
        ATM atm = new ATM();
        int maxAttempts = 10;
        int attemptCount = 0;

        while (attemptCount <= maxAttempts) {
            try {
                atm.login();
                atm.verify();
                break; // Break out of the loop if successful
            } catch (Exception e) {
                log.info("Enter correct info, try " + attemptCount + " time(s)");
                attemptCount++;
            }
        }

        if (attemptCount > maxAttempts) {
            log.info("Your Account is Blocked..!");
        }
    }

    public void toGiveUntilCorrectInfo() {
        ATM atm = new ATM();
        int attemptCount = 0;
        while (true) {
            try {
                atm.login();
                atm.verify();
                log.info("Login successful on attempt " + attemptCount);
                break; // Break out of the loop if successful
            } catch (Exception e) {
                log.info("Enter correct info, attempt " + attemptCount);
                attemptCount++;
            }
        }
        log.info("Attempted Count" + attemptCount);
    }

    public void toGive10ChanceUsingDoWhile() {
        ATM atm = new ATM();
        int maxAttempts = 10;
        int attemptCount = 0;

        do {
            try {
                atm.login();
                atm.verify();
                break; // Break out of the loop if successful
            } catch (Exception e) {
                log.info("Enter correct info, try " + attemptCount + " time(s)");
                attemptCount++;
            }
        } while (attemptCount <= maxAttempts);

        if (attemptCount > maxAttempts) {
            log.info("Your Account is Blocked..!");
        }
    }




}
@Slf4j
class ATM {
    private int accountNumber = 1234;
    private int  password = 1111;
    private int accn;
    private int pswd;

    public void login(){
        Scanner scanner = new Scanner(System.in);
        log.info("Enter your AccountNumber : ");
        accn = scanner.nextInt();
       log.info("Enter your Password : ");
        pswd = scanner.nextInt();
    }

    public void verify() throws Exception {
        if(accountNumber == accn && password == pswd){
            log.info("Collect you cash ");
        }else {
            log.info("Invalid credentials");
            throw new Exception("Invalid Credentials");
        }
    }


//    @RedisHash(value="UserProfile", timeToLive = 7200L)
//    public class UserProfile {
//        @Id
//        private String accessToken;
//
//        private List<String> roles;
//    }
//
//    @Repository
//    public interface PingUserRepository extends CrudRepository<UserProfile,String>{
//
//    }
}