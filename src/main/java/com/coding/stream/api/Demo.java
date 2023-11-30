package com.coding.stream.api;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Slf4j
public class Demo {

    public static void main(String[] args) {
        findDuplicateCharInMyName();
        compareTwoArrays();
    }

    private static void compareTwoArrays() {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {7,8,9,2,1,0};
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i<arr1.length ; i++){
            for (int j = i ; j<arr2.length;j++){
                if (arr1[i] == arr2[j]) {
                    log.info("same vales are " + arr1[i] );
                    list.add(arr1[i]);
                }
            }
        }
        log.info("duplicate values : " + list);
    }

    private static void findDuplicateCharInMyName() {
        String myName = "Venkatesh";
        Set<Character> chars = new HashSet<>();
        for(char name : myName.toCharArray()){
            chars.add(name);
        }
        log.info("set size => "+chars.size());
        log.info("String size => "+myName.toCharArray().length);
        if (chars.size()==myName.toCharArray().length){
            log.info("No Duplicate character in you name");
        }else {
            log.info("Duplicate found");
        }
    }
}

