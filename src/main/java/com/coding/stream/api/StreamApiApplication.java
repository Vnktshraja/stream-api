package com.coding.stream.api;
import com.coding.stream.api.Entity.Anonim;
import com.coding.stream.api.Entity.Employee;
import com.coding.stream.api.Entity.Person;
import com.coding.stream.api.Entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class StreamApiApplication {

    private static List<Employee> employee = new ArrayList<>();
    private static List<Person> persons = new ArrayList<>();

    static {
        employee.add(new Employee("Sachin", "Tendulkar", 10000.0, List.of("Project 1", "Project 2")));
        employee.add(new Employee("Mahi", "Dhoni", 12000.0, List.of("Project 3", "Project 4")));
        employee.add(new Employee("Viru", "Shewag", 14000.0, List.of("Project 2", "Project 4")));
        employee.add(new Employee("Virat", "Kholi", 15000.0, List.of("Project 1", "Project 3")));
    }
    static {
        persons.add(new Person("venkat",27,"v@gmail.com", Person.Sex.MALE));
        persons.add(new Person("venkat",28,"ven@gmail.com", Person.Sex.MALE));
        persons.add(new Person("venkat",29,"venkatesh@gmail.com", Person.Sex.MALE));
        persons.add(new Person("raja",50,"ra@gmail.com", Person.Sex.MALE));
        persons.add(new Person("raja",52,"raja@gmail.com", Person.Sex.MALE));

    }

    public static void main(String[] args) {

        //flatMap is to get @onetomany mapping object (it means list of list object)
        log.info("------------------flatMap------------------");
        String projects = employee.stream().filter(employee1 -> employee1.getFirstName().startsWith("V"))
                .flatMap(employee -> employee.getProjects().stream())
                .collect(Collectors.joining(","));
        log.info(projects);

//		SpringApplication.run(StreamApiApplication.class, args);

        //Any Operation which is returning the stream itself is called intermediate operation.
        log.info("-------------------forEach-----------------");
        // forEach loop
        employee.stream().forEach(employee -> System.out.println(employee));

        System.out.println("-----------------map-------------------");

        //map (one obj to another obj)  * return => stream again
        List<Employee> increaseSalary = employee.stream().map(employee -> new Employee(employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() + 500,
                        employee.getProjects()))
                .collect(Collectors.toList());

        log.info("copy value from one object to another object: "+increaseSalary);

        log.info("------------------filter------------------");
        //filter
        List<Employee> decreasedSalary = employee.stream().filter(employee -> employee.getSalary() < 12000.0).map(employee -> new Employee(employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() - 1000,
                        employee.getProjects()))
                .collect(Collectors.toList());
        log.info("decreased salary who has above 12000 : "+decreasedSalary);

        log.info("------------------findFirst------------------");
        //findFirst return the Optional<> so it required orElseThrow(null or exception)
        Employee firstEmployee = employee.stream().filter(employee -> employee.getSalary() > 12000.0).map(employee -> new Employee(employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary() + 700,
                employee.getProjects())).findFirst().orElseThrow(null);

        log.info(""+firstEmployee);

        //flatMap
        log.info("------------------flatMap------------------");
        String projectss = employee.stream()
                .map(employee -> employee.getProjects())
                .flatMap(String -> String.stream())
                .collect(Collectors.joining(","));
        System.out.println(projects);

        //Short Circuit operations
        log.info("------------------Skip and limit------------------");
        List<Employee> cirtuit = employee
                .stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(cirtuit);

        //Finite Data
        log.info("------------------finite data------------------");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));

        //sorting
        log.info("------------------Sorting with comparator------------------");
        List<Employee> sorting = employee.stream().
                sorted((o1, o2) -> {
                    if (o1.getSalary() < o2.getSalary())
                        return 1;
                    else
                        return -1;
                }).collect(Collectors.toList());

        System.out.println(sorting);

        ///min or max
        log.info("------------------Min or Max------------------");
        Employee maximum = employee.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(maximum);

        //reduce
        log.info("------------------reduce------------------");
        Double sumOfSalary = employee.stream().map(employee -> employee.getSalary())
                .reduce(0.0, (a, b) -> a + b);

        System.out.println(sumOfSalary);

        //IntegerStream
        log.info("------------------IntStream inbuild example------------------");
        IntStream.range(1, 6).forEach(System.out::println);

        //IntegerStream & Skip() & value by reference
        log.info("------------------IntStream and Skip and reference value------------------");
        IntStream.range(1, 10).skip(4).forEach(x -> System.out.println(x));

        //sum()
        log.info("------------------IntStream inbuild example------------------");
        int s = IntStream.range(1, 6).sum();
        System.out.println(s);

        log.info("----------------filter and Map-----------------");
        String[] name = {"dog", "ball", "bello", "bigboss", "cat", "apple", "elephant", "fish"};

        List<String> list = Arrays.stream(name)
                .filter(x -> x.startsWith("b")).map(x -> {
                    if (x.length() <= 4) return x.toUpperCase();
                    else return x.toLowerCase();
                })
                .collect(Collectors.toList());
        System.out.println(list);


        List<Person> person = Person.getDefaultPerson();

        log.info(""+person);

        log.info("------------AnomEx:-----------");

        Anonim eg = () -> System.out.println("example for anonimus inner class");
        eg.demo();

        log.info("------------Decending: using reversed -----------");

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
        log.info(""+decreasedSalary);

        log.info(""+s3);

        log.info("----------------Comparator---------------------");

        List<Person> ar = Person.getDefaultPerson();

        Collections.sort(ar, (o1, o2) -> o2.getAge()-o1.getAge()); // decending in age  && o1-o2 for ascending
        System.out.println(ar);

        log.info("-----------------filter , Map , reduce----------------");

        List<Integer> lst = Arrays.asList(2,6,4,23,21,15,65,11);

        int il = lst.stream().filter(i->i%2==0).map(e->e/2).reduce(0,(c,e)->c+e);

//        List n = lst.stream().sorted().collect(Collectors.toList()); // just sort ascending

        log.info(""+il);
        log.info("-------");
        log.info("-------new line added---------");


        log.info("----------------------------");


        List<Integer> findDuplication = List.of(5, 3, 9, 7, 0);

        Integer duplicated = findDuplication.stream()
                .distinct()
                .limit(0) // Limit to at most 2 elements (if all elements are the same, only 1 distinct value)
                .findFirst()
                .orElse(null);

        log.info("duplicated value: " + duplicated);

        log.info("----------------------------");

        List<Integer> integerList = List.of(5, 5, 9, 5, 5); // Replace with your list of integers

        Integer firstValue = integerList.get(0);
        boolean allEqual = integerList.stream().allMatch(value -> value.equals(firstValue));

        Integer distinctValue = allEqual ? firstValue : null;

        log.info("Distinct value: " + distinctValue);


        log.info("----------------------------******______------------");

        List<Employee> listOfEmp = employee.stream().filter(employee1 -> !employee1.getFirstName().equals("Viru")).toList();

        log.info("list of employee-->"+listOfEmp);


        log.info("----------------------------###########--------------------");

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
        log.info("----------------------------??????******?????--------------------");
        List<Integer> orders = Arrays.asList(4,6,8,10,12,14,16,18,20,12);
        Collections.sort(orders);
        Collections.reverse(orders);
        System.out.println(orders);

        log.info("**********normal*********");

        Date d = new Date();
        d.setDate(8);
        Student s1 = new Student(1,"venkat",d ,"9087783778","34,star street");
        System.out.println(s1);

        log.info("************* Grouping same name in map *********************");

        Map<String,List<Person>> collective = persons.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println(collective);

        log.info("************* Grouping same name in map *********************");


        List<Integer> integers = Arrays.asList(1,26,27,3,8,33);

        List<Integer> getOut = integers.stream().filter(i->i%3==0).sorted((o1, o2) -> {
            if (o1< o2)
                return 1;
            else
                return -1;
        }).collect(Collectors.toList());

       log.info(""+getOut);

        log.info("///////////////////");

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        Set<Integer> set = new LinkedHashSet<>();

        for (int v : nums){
            set.add(v);
        }
        log.info("values are : {}",set);
        log.info("its size : "+set.size());

        int rd = 0;
        for(int i = 1 ; i<nums.length; i++){
            if(nums[rd] != nums[i]){
                rd++;
                nums[rd] = nums[i];
            }
        }
//        return rd+1;

        log.info("------------- primitive int reverse ---------------");

        int e = 2345678;
        int si = 0;
        while(e!=0){
            si=si*10+e%10;
            e=e/10;
        }
        log.info("--> : "+si);


    }




}
