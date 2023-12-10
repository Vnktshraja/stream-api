package com.coding.stream.api.Entity;

public class Beta {

    public void launch(){
            Division div = new Division();
            try {
                div.except();
            }catch(ArithmeticException e){
                System.out.println("in Beta");
            }
    }

    public void demo2() throws InterruptedException {

        System.out.println("First line");
        Thread.sleep(5000);
        System.out.println("last line");
    }
}
