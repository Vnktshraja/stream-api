package com.coding.stream.api.ExceptionDemo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecondTest {

    public void secondFunction() throws RuntimeException{ // bcz it throw same type of exception.
        try {
            log.info("Entered into Second method");
            int d = 2/0;
            System.out.println(d); // though above line had exception this line will not be executed.
        }catch (Exception e){
            log.debug("Exception in second()"); // this will be executed. log as debug
            throw new RuntimeException();
        }
        log.info("After 2()"); // though we have throw in above catch control will not reach this line.
    }
}
