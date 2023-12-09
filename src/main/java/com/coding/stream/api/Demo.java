package com.coding.stream.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
public class Demo {

    public static void main(String[] args) throws JsonProcessingException {
        findDuplicateCharInMyName();
        compareTwoArrays();
        storeUniqueDataInMap();
        convertListOfObjectIntMap();
        swapTwoNumberWithOutNewVariable();
        printKeysIfValuesAreSameInJson();
        palindromValues();
        numberPattern();
        mapObjectConversion();


    }

    private static void mapObjectConversion() {
        Map<String,Object> map = new HashMap<>();
        map.put("sit",14);
        BigDecimal dv = BigDecimal.valueOf(Double.parseDouble(String.valueOf(map.get("sit"))));
        double doubleValue = Double.parseDouble(String.valueOf(map.get("sit")));
        log.info("BigDecimal value is printed : "+dv);
        log.info("Double value is printed : "+doubleValue);
    }

    private static void numberPattern(){
        for(int i=5; i>=1; i--){
            for(int j=1; j<=i;j++){
                System.out.print(i+" ");
//                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    private static void palindromValues(){
        String values = "DAD";
        StringBuffer builders = new StringBuffer(values);
        StringBuffer sb = new StringBuffer();
        for(char c : values.toCharArray()){
            sb.append(c);
        }
        log.info("sb "+ sb);
        if(builders.equals(sb))
            log.info("palindrom");
        else
            log.info("Not palindrom");
    }

    private static void printKeysIfValuesAreSameInJson() throws JsonProcessingException {
        String json1 = "{\n" +
                "    \"data1\":\"apple\",\n" +
                "    \"data2\":\"banana\",\n" +
                "    \"data3\":\"cat\"\n" +
                "}";
        String json2 = "{\n" +
                "    \"data1\":\"apple\",\n" +
                "    \"data2\":\"dog\",\n" +
                "    \"data3\":\"cat\",\n" +
                "    \"data4\":\"elephant\",\n" +
                "    \"data5\":\"mobile\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        Map<String,Object> jsonMap1 = objectMapper.readValue(json1,Map.class);
        Map<String,Object> jsonMap2 = objectMapper.readValue(json2,Map.class);
        List<String> keys = new ArrayList<>();
        jsonMap1.entrySet().forEach(value1->{
            jsonMap2.entrySet().forEach(value2->{
                if(value1.getValue().equals(value2.getValue())){
                    keys.add(value1.getKey());
                }
            });
        });
        log.info("keys are printed"+keys);
    }

    private static void swapTwoNumberWithOutNewVariable() {
        int a = 3 ;
        int b = 5 ;
        a = a+b;
        b = a-b;
        a = a-b;
        log.info("a : " + a + " " + "b : " + b );
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

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Store{
        int id;
        String name;
        String location;
    }
}

