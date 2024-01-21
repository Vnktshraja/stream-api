package com.coding.stream.api;
import com.coding.stream.api.ExceptionDemo.Bank;
import com.coding.stream.api.ExceptionDemo.FirstTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
public class Demo {

    public static void main(String[] args) throws JsonProcessingException {
//        {   "userId":"101",
//                "name":"venkat",
//            "columns": [
//            {
//                "col1":"name",
//                    "with":1
//            },
//            {
//                "col1":"name2",
//                    "with":2
//            },
//            {
//                "col1":"name3",
//                    "with":3
//            }
//  ]
//        }

//        String input = "";
//        if (!Objects.requireNonNullElse(input, "").isBlank()) {
//            System.out.println("String is not empty, not blank, and not null." + input);
//        } else {
//            System.out.println("String is empty, blank, or null."+input);
//        }
//
//        if (StringUtils.isNotBlank(input)) {
//            System.out.println("The string is not empty, not blank, and not null.");
//        } else {
//            System.out.println("The string is either empty, blank, or null.");
//        }
//        findDuplicateCharInMyName();
//        compareTwoArrays();
//        storeUniqueDataInMap();
//        convertListOfObjectIntMap();
//        swapTwoNumberWithOutNewVariable();
//        printKeysIfValuesAreSameInJson();
//        palindromValues();
//        numberPattern();
//        mapObjectConversion();
//        removeAnyFieldOnMapContainsMultipleMap();
        switchTest();

//        log.info("-------------------------------");
//
//        try {
//            FirstTest firstTest = new FirstTest();
//            firstTest.testFunction();
//            log.info("Before Exception in main()"); // this will get execute bcz testFunction() not throwing exception in catch block.
//        }catch (Exception e){
//            log.error("Excption found in main():{} ",e.getMessage()); // even catch will not execute.
//        }
//        log.info("After main()"); // this will execute normally bcz no throw in above catch.
//
//        log.info("-----------------------------");

//        Bank b = new Bank();
//        b.toGiveThreeChance();
//        b.toGive10Chance();
//        b.toGiveUntilCorrectInfo();
//        b.toGive10ChanceUsingDoWhile();

//        MutableBoolean access = new MutableBoolean(true);
//        newMethod(access);
//        log.info("Print boolean : "+ access);

//        List<String> listOf = new ArrayList<>();
//        if(listOf==null){
//            log.info("its null");
//        }else if (listOf.isEmpty()){
//            log.info("it is empty"+listOf);
//        }

    }

    private static void switchTest() {
        String value = "yes";
        switch (value){
            case "yes":
                method1();
                log.info("3");
                break;
            case "no":
                log.info("6");
                break;
            default:
                log.info("default");

        }
    }

    private static void method1() {
        log.info("5");
        return;
    }

    private static void removeAnyFieldOnMapContainsMultipleMap() {
        List<Map<String, Object>> omgList = new ArrayList<>();
        Map<String, Object> omg = new HashMap<>();
        omg.put("orderMatchingGroupId", 101);
        omg.put("createdDate", "2023-02-04");
        omg.put("modifiedBy", null);
        omgList.add(omg);
        List<Map<String, Object>> omgTrancheList = new ArrayList<>();
        Map<String, Object> omgTranche = new HashMap<>();
        omgTranche.put("trancheName", "5Y");
        omgTranche.put("createdDate", "2023-02-04");
        omgTranche.put("modifiedBy", null);
        omgTrancheList.add(omgTranche);
        omg.put("orderMatchingGroupTranche", omgTrancheList);
        List<Map<String, Object>> trancheOrderList = new ArrayList<>();
        Map<String, Object> trancheOrder = new HashMap<>();
        trancheOrder.put("orderSize", 1000);
        trancheOrder.put("createdDate", "2023-02-04");
        trancheOrder.put("modifiedBy", null);
        omgTranche.put("trancheOrders", trancheOrderList);
        trancheOrderList.add(trancheOrder);
        Map<String, Object> orderUpdate = new HashMap<>();
        orderUpdate.put("modifiedBy", "U101");
        orderUpdate.put("orderMatchingGroup", omgList);
//        removeCreatedDate(orderUpdate);
        updateModifiedBy(orderUpdate, "U101");
        log.info("removed all the created date from map {}", orderUpdate);
    }

    private static void updateModifiedBy(Map<String, Object> map, String newModifiedByValue) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if ("modifiedBy".equals(entry.getKey())) {
                map.put(entry.getKey(), newModifiedByValue);
            } else if (entry.getValue() instanceof Map) {
                updateModifiedBy((Map<String, Object>) entry.getValue(), newModifiedByValue);
            } else if (entry.getValue() instanceof List) {
                for (Object element : (List<Object>) entry.getValue()) {
                    if (element instanceof Map) {
                        updateModifiedBy((Map<String, Object>) element, newModifiedByValue);
                    }
                }
            }
        }
    }

    private static void removeCreatedDate(Map<String, Object> map) {
        map.keySet().removeIf(key -> key.equals("createdDate"));
        map.values().forEach(value -> {
            if (value instanceof Map) {
                removeCreatedDate((Map<String, Object>) value);
            } else if (value instanceof List) {
                ((List<Object>) value).forEach(element -> {
                    if (element instanceof Map) {
                        removeCreatedDate((Map<String, Object>) element);
                    }
                });
            }
        });
    }

    private static void newMethod(MutableBoolean a) {
        a.setFalse();
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

