package com.coding.stream.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiApplication {

    private static List<Employee> employee = new ArrayList<>();

    static {
        employee.add(new Employee("Sachin", "Tendulkar", 10000.0, List.of("Project 1", "Project 2")));
        employee.add(new Employee("Mahi", "Dhoni", 12000.0, List.of("Project 3", "Project 4")));
        employee.add(new Employee("Viru", "Shewag", 14000.0, List.of("Project 2", "Project 4")));
        employee.add(new Employee("Virat", "Kholi", 15000.0, List.of("Project 1", "Project 3")));
    }

    public static void main(String[] args) {

        //flatMap is to get @onetomany mapping object (it means list of list object)
        System.out.println("------------------flatMap------------------");
        String projects = employee.stream().filter(employee1 -> employee1.getFirstName().startsWith("V"))
                .flatMap(employee -> employee.getProjects().stream())
                .collect(Collectors.joining(","));
        System.out.println(projects);

//		SpringApplication.run(StreamApiApplication.class, args);

        //Any Operation which is returning the stream itself is called intermediate operation.
        System.out.println("-------------------forEach-----------------");
        // forEach loop
        employee.stream().forEach(employee -> System.out.println(employee));

        System.out.println("-----------------map-------------------");

        //map (one obj to another obj)  * return => stream again
        List<Employee> increaseSalary = employee.stream().map(employee -> new Employee(employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() + 500,
                        employee.getProjects()))
                .collect(Collectors.toList());

        System.out.println(increaseSalary);

        System.out.println("------------------filter------------------");
        //filter
        List<Employee> decreasedSalary = employee.stream().filter(employee -> employee.getSalary() < 12000.0).map(employee -> new Employee(employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() - 1000,
                        employee.getProjects()))
                .collect(Collectors.toList());
        System.out.println(decreasedSalary);

        System.out.println("------------------findFirst------------------");
        //findFirst return the Optional<> so it required orElseThrow(null or exception)
        Employee firstEmployee = employee.stream().filter(employee -> employee.getSalary() > 12000.0).map(employee -> new Employee(employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary() + 700,
                employee.getProjects())).findFirst().orElseThrow(null);

        System.out.println(firstEmployee);

        //flatMap
        System.out.println("------------------flatMap------------------");
        String projectss = employee.stream()
                .map(employee -> employee.getProjects())
                .flatMap(String -> String.stream())
                .collect(Collectors.joining(","));
        System.out.println(projects);

        //Short Circuit operations
        System.out.println("------------------Skip and limit------------------");
        List<Employee> cirtuit = employee
                .stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(cirtuit);

        //Finite Data
        System.out.println("------------------finite data------------------");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));

        //sorting
        System.out.println("------------------Sorting with comparator------------------");
        List<Employee> sorting = employee.stream().
                sorted((o1, o2) -> {
                    if (o1.getSalary() < o2.getSalary())
                        return 1;
                    else
                        return -1;
                }).collect(Collectors.toList());

        System.out.println(sorting);

        ///min or max
        System.out.println("------------------Min or Max------------------");
        Employee maximum = employee.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(maximum);

        //reduce
        System.out.println("------------------reduce------------------");
        Double sumOfSalary = employee.stream().map(employee -> employee.getSalary())
                .reduce(0.0, (a, b) -> a + b);

        System.out.println(sumOfSalary);

        //IntegerStream
        System.out.println("------------------IntStream inbuild example------------------");
        IntStream.range(1, 6).forEach(System.out::println);

        System.out.println();

        //IntegerStream & Skip() & value by reference
        System.out.println("------------------IntStream and Skip and reference value------------------");
        IntStream.range(1, 10).skip(4).forEach(x -> System.out.println(x));

        //sum()
        System.out.println("------------------IntStream inbuild example------------------");
        int s = IntStream.range(1, 6).sum();
        System.out.println(s);

        System.out.println("----------------filter and Map-----------------");
        String[] name = {"dog", "ball", "bello", "bigboss", "cat", "apple", "elephant", "fish"};

        List<String> list = Arrays.stream(name)
                .filter(x -> x.startsWith("b")).map(x -> {
                    if (x.length() <= 4) return x.toUpperCase();
                    else return x.toLowerCase();
                })
                .collect(Collectors.toList());
        System.out.println(list);


        List<Person> person = Person.getDefaultPerson();

        System.out.println(person);

        System.out.println("------------AnomEx:-----------");

        Anonim eg = () -> System.out.println("example for anonimus inner class");
        eg.demo();

        System.out.println("------------Decending: using reversed -----------");

        List<Employee> ess = employee.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());


        System.out.println("------------------------------------------");
//            Beta beta = new Beta();
//            beta.launch();

        Student s3 = new Student();


        employee.stream().filter(employee -> employee.getSalary() < 12000.0).
                forEach(e->{
                        String change = e.getLastName();
                        s3.setName("Venkat");
                        e.setFirstName(change);
                        System.out.println("compled");
                });
        System.out.println(decreasedSalary);

        System.out.println(s3);

        System.out.println("----------------Comparator---------------------");

        List<Person> ar = Person.getDefaultPerson();

        Collections.sort(ar, (o1, o2) -> o2.getAge()-o1.getAge()); // decending in age  && o1-o2 for ascending
        System.out.println(ar);

        System.out.println("-----------------filter , Map , reduce----------------");

        List<Integer> lst = Arrays.asList(2,6,4,23,21,15,65,11);

        int il = lst.stream().filter(i->i%2==0).map(e->e/2).reduce(0,(c,e)->c+e);

//        List n = lst.stream().sorted().collect(Collectors.toList()); // just sort ascending

        System.out.println(il);
        System.out.println("-------");
        System.out.println("-------new line added---------");


        System.out.println("----------------------------");


        List<Integer> findDuplication = List.of(5, 3, 9, 7, 0);

        Integer duplicated = findDuplication.stream()
                .distinct()
                .limit(0) // Limit to at most 2 elements (if all elements are the same, only 1 distinct value)
                .findFirst()
                .orElse(null);

        System.out.println("duplicated value: " + duplicated);

        System.out.println("----------------------------");

        List<Integer> integerList = List.of(5, 5, 9, 5, 5); // Replace with your list of integers

        Integer firstValue = integerList.get(0);
        boolean allEqual = integerList.stream().allMatch(value -> value.equals(firstValue));

        Integer distinctValue = allEqual ? firstValue : null;

        System.out.println("Distinct value: " + distinctValue);


        System.out.println("----------------------------******______------------");

        List<Employee> listOfEmp = employee.stream().filter(employee1 -> !employee1.getFirstName().equals("Viru")).toList();

        System.out.println("list of employee-->"+listOfEmp);


        System.out.println("----------------------------###########--------------------");

        Map<String, List<Employee>> mapTest = new HashMap<>();
        mapTest.put("test",employee);
        List<List<Employee>> newEmployee = new ArrayList<>();
        mapTest.forEach((key,values)->{
            List<Employee> lists = values.stream().filter(employee1 -> !employee1.getFirstName().startsWith("S")).toList();
            newEmployee.add(values);
        });
        System.out.println(newEmployee);



        boolean isTrue =  true;

        if(isTrue){
            int io = 5;
            if(true){
                System.out.println("--->"+io);
            }
        }
        System.out.println("----------------------------??????******?????--------------------");
        int[] orders = {4,6,8,10,12,14,16,18,20,12};
        System.out.println(orders);

        System.out.println("**********normal*********");

        Date d = new Date();
        d.setDate(8);

        Student s1 = new Student(1,"venkat",d ,"9087783778","34,star street");



    }


}
