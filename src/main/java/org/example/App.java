package org.example;        // March 2022
import java.util.*;

// Solutions to CA3 Lab Practical Examination - OOP March 2022

public class App 
{
    public static void main( String[] args )
    {
        //Question 1
        List<Student> students = new ArrayList<>();
        questionOnePartA(students);
        questionOnePartB(students);
        questionOnePartC(students);
        questionOnePartD();

        //Question 2

        // a) use list for lookup [get() - O(1) time complexity]
        List<Employee> employees = new ArrayList<>();
        questionTwoPartA(employees);
        Employee luckyWinner = pickLuckyWinner(employees);
        System.out.println("\nLucky winner: " + luckyWinner);

        // b) use HashSet to add only unique values [add() - O(1) time complexity]
        Set<String> firstName = new HashSet<>();
        questionTwoPartB(firstName);
        printUniqueNames(firstName);

        // c) use HashMap to hash first name (key) with the count of first name (value)
        Map<String, Integer> firstNameMap = new HashMap<>();
        questionTwoPartC(employees, firstNameMap);
        printNameAndCount(firstNameMap);

        // d) use ArrayDeque to get first element [poll() - O(log n) time complexity / peek() - O(1) time complexity]
        Queue<Employee> waitingList = new ArrayDeque<>();
        questionTwoPartD(waitingList);
        System.out.println("\nEmployee season tickets waiting list:");
        getNextOnWaitingList(waitingList);
        getNextOnWaitingList(waitingList);
        getNextOnWaitingList(waitingList);
        getNextOnWaitingList(waitingList);
        getNextOnWaitingList(waitingList);
        getNextOnWaitingList(waitingList);

        //Question 3
        List<String> oneHundredStrings = new ArrayList<>();
        System.out.println();
        populateOneHundredStrings(oneHundredStrings);
        System.out.println(oneHundredStrings);
        questionThreePartA(oneHundredStrings);
        questionThreePartB();
//
//        //Question 4
        compareTwoStudents();
        questionFourPartA();
        questionFourPartB();
        questionFourPartC();
    }

    //The method below relates to Question 4
    private static void compareTwoStudents()
    {
        Student alex1 = new Student(1, "Alex", 22);
        Student alex2 = new Student(1, "Alex", 22);
        System.out.println("\nalex1 hashcode = " + alex1.hashCode());
        System.out.println("alex2 hashcode = " + alex2.hashCode());
        System.out.println("Checking equality between alex1 and alex2 = " + alex1.equals(alex2));
    }

    // Question 1a
    private static void questionOnePartA(List<Student> students)
    {
        Student s1 = new Student(1, "Joe Bloggs", 20);
        Student s2 = new Student(2, "Bob Brown", 33);
        Student s3 = new Student(3, "Sophia Murphy", 19);
        Student s4 = new Student(4, "Susan Bloggs", 25);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

     }

     // Question 1b
    private static void  questionOnePartB(List<Student> students)
    {
        students.sort(new StudentNameComparator());
        System.out.println("\nStudents sorted by name");
        for(Student s : students)
            System.out.println(s);
    }

    // Question 1c
    private static void  questionOnePartC(List<Student> students)
    {
        students.sort(new StudentAgeComparator());
        System.out.println("\nStudents sorted by age");
        for(Student s : students)
            System.out.println(s);
    }

    // Question 1d
    private static void  questionOnePartD()
    {
        System.out.println("\nTime complexity of adding Student to List: O(1)");
        System.out.println("Space complexity of adding Student to List: O(n)");
        System.out.println("Time complexity of sorting (merge sort): O(n log n)");
        System.out.println("Space complexity of sorting (merge sort): O(n)");
    }

    // Question 2a
    private static void questionTwoPartA(List<Employee> employees)
    {
        Employee e1 = new Employee("Casper", "Kerchov");
        Employee e2 = new Employee("Joe", "Bloggs");
        Employee e3 = new Employee("Susan", "Murphy");
        Employee e4 = new Employee("Bob", "Brown");
        Employee e5 = new Employee("Susan", "Bloggs");

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
    }

    private static Employee pickLuckyWinner(List<Employee> employees)
    {
        Random rand = new Random();
        int randomIndex = rand.nextInt(employees.size());
        return employees.get(randomIndex);
    }

    // Question 2b
    private static void questionTwoPartB(Set<String> firstName)
    {
        Employee e1 = new Employee("Luana", "Kimley");
        Employee e2 = new Employee("Joe", "Bloggs");
        Employee e3 = new Employee("Susan", "Murphy");
        Employee e4 = new Employee("Bob", "Brown");
        Employee e5 = new Employee("Susan", "Bloggs");

        firstName.add(e1.getFirstName());
        firstName.add(e2.getFirstName());
        firstName.add(e3.getFirstName());
        firstName.add(e4.getFirstName());
        firstName.add(e5.getFirstName());
    }

    private static void printUniqueNames(Set<String> firstName)
    {
        System.out.println("\nPrint unique names");
        for(String s : firstName)
        {
            System.out.println(s);
        }
    }

    // Question 2c
    private static void questionTwoPartC(List<Employee> employees, Map<String, Integer> firstNameMap)
    {
        Employee e1 = new Employee("Lana", "Delaney");
        Employee e2 = new Employee("Joe", "Bloggs");
        Employee e3 = new Employee("Susan", "Murphy");
        Employee e4 = new Employee("Bob", "Brown");
        Employee e5 = new Employee("Susan", "Bloggs");

        for(Employee e : employees)
        {
            String firstName = e.getFirstName();
            Integer count = firstNameMap.get(firstName);
            if(count != null)
            {
                firstNameMap.put(firstName, count+1);
            }
            else
            {
                firstNameMap.put(firstName, 1);
            }
        }
    }

    private static void printNameAndCount(Map<String, Integer> firstNameMap)
    {
        System.out.println("\nPrint first name and count");
        for(Map.Entry<String,Integer> entry : firstNameMap.entrySet()) {
            System.out.println("Count of '" + entry.getKey() + "' first name: " + entry.getValue());
        }
    }

    // Question 2d
    private static void questionTwoPartD(Queue<Employee> waitingList)
    {
        Employee e1 = new Employee("Lucy", "Kimble");
        Employee e2 = new Employee("Joe", "Bloggs");
        Employee e3 = new Employee("Susan", "Murphy");
        Employee e4 = new Employee("Bob", "Brown");
        Employee e5 = new Employee("Susan", "Bloggs");

        waitingList.add(e1);
        waitingList.add(e2);
        waitingList.add(e3);
        waitingList.add(e4);
        waitingList.add(e5);
    }

    private static Employee getNextOnWaitingList(Queue<Employee> waitingList)
    {
        if(waitingList.peek() != null) // check that queue is not empty
            System.out.println("Next employee on waiting list: " + waitingList.peek());
        else
            System.out.println("No employee on waiting list");

        return waitingList.poll();  // retrieve and remove element , and return it
    }

    // Question 3a
    private static void questionThreePartA(List<String> list)
    {
        // LinkedHashSet - set part will remove duplicates, but order is maintained via LinkedList
        List<String> removeDuplicates = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("Remove duplicates while maintaining order");
        System.out.println(removeDuplicates);

    }

    private static void questionThreePartB()
    {
        System.out.println("\nRemoving duplicates from list while maintaining its order can be done by using a LinkedHashSet");
        System.out.println("It extends the Set interface, so it will only keep unique values, but it also maintains the order, unlike HashSet");
        System.out.println("Time complexity: O(n), n being the size of the List since it iterates through the List to add all the items from the List");
        System.out.println("Space complexity: O(n)");
    }

    // Question 4a
    private static void questionFourPartA()
    {
        System.out.println("\nThe method returns false because the two students are not equal");
        System.out.println("Currently there is no method overriding the equals and hashcode method in the Student class");
        System.out.println("The default Java equals method will only return true if the two compared objects are the same object, which in this case they are not");
    }

    // Question 4b
    private static void questionFourPartB()
    {
        System.out.println("\nThe hashCodes for the two methods are different since they are not equal");
        System.out.println("If the two methods have the same hashCode then they are equal");
    }

    // Question 4c
    private static void questionFourPartC()
    {
        System.out.println("\nAppropriate changes has been made so that the two students with the same name have the same hashcode and are equal");
        System.out.println("Changes made -> override the equals and hashCode method in Student class by comparing the Student by its name field");
    }


    //This is just a helper method to populate the list of strings for question 3. You do not need to read it to answer any of the questions in the CA
    private static void populateOneHundredStrings(List<String> oneHundredStrings)
    {
        for(int i=0; i < 100; i++)
        {
            if(i / 10 == 0)
            {
                oneHundredStrings.add("Java");
            }
            else if(i / 10 == 1)
            {
                oneHundredStrings.add("Python");
            }
            else if(i / 10 == 2)
            {
                oneHundredStrings.add("C++");
            }
            else if(i / 10 == 3)
            {
                oneHundredStrings.add("Javascript");
            }
            else if(i / 10 == 4)
            {
                oneHundredStrings.add("Ruby");
            }
            else if(i / 10 == 5)
            {
                oneHundredStrings.add("Golang");
            }
            else if(i / 10 == 6)
            {
                oneHundredStrings.add("C#");
            }
            else if(i / 10 == 7)
            {
                oneHundredStrings.add("C");
            }
            else if(i / 10 == 8)
            {
                oneHundredStrings.add("R");
            }
            else if(i / 10 == 9)
            {
                oneHundredStrings.add("Swift");
            }
        }
    }
}
