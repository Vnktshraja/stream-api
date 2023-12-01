package com.coding.stream.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Demo {

    public static void main(String[] args) {
        findDuplicateCharInMyName();
        compareTwoArrays();
        storeUniqueDataInMap();
        convertListOfObjectIntMap();
    }

    private static void convertListOfObjectIntMap() {
        Store s1 = new Store(1,"a","chennai");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> storeMap = objectMapper.convertValue(s1, Map.class);
        log.info("List of Object converted into Map" + storeMap);
    }


    private static void storeUniqueDataInMap() {
        Store s1 = new Store(1,"a","chennai");
        Store s2 = new Store(2,"b","Bangalore");
        Store s3 = new Store(1,"c","Kolkata");
        Store s4 = new Store(4,"d","Mumbai");
        Store s5 = new Store(1,"e","Delhi");
        LinkedHashMap<Integer,Object> stores = new LinkedHashMap<>();
        stores.put(s1.id,s1);
        stores.put(s2.id,s2);
        stores.put(s3.id,s3);
        stores.put(s4.id,s4);
        stores.put(s5.id,s5); // in map if we have duplicate key in map it is printing the last object
        log.info("Storing"+'\n'+ stores);
    }

    private static void compareTwoArrays() {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {7,8,9,2,1,0};
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i<arr1.length ; i++){
            for (int j = i ; j<arr2.length;j++){
                if (arr1[i] == arr2[j]) {
                    log.info("same vales are " + arr1[i] );
                    list.add(arr1[i]);
                    count++;
                }
            }
        }
        log.info("duplicate values : " + list);
        log.info("No of char repeated : " + count);
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

    public static class Store{
        int id;
        String name;
        String location;

        public Store() {
        }

        public Store(int id, String name, String location) {
            this.id = id;
            this.name = name;
            this.location = location;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Store{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
    }
}

