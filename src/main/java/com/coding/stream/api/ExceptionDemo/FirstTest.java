package com.coding.stream.api.ExceptionDemo;

import lombok.extern.slf4j.Slf4j;

import java.util.zip.DataFormatException;

@Slf4j
public class FirstTest {

    public void testFunction() throws DataFormatException {
//        try {
            SecondTest secondTest = new SecondTest();
            secondTest.secondFunction();
            log.info("Before exception in testDemo()"); // this will not execute bcz throw present in secondFunction(). so it will go for catch without exe below lines.
//        }catch (Exception e){
//            log.error("Exception in testDemo() {}",e.getMessage()); // catch will execute bcz calling method throws exception. so catch caught the exception.
//        }
//        log.info("After testDemo()"); // this will execute bcz no (redirect) throw is mentioned in above catch. if we have throw we should mention this in finally block.
    }

}
