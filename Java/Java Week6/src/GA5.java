// You are given a list of employees where each employee has a name and a salary. Your task is to sort the employees in such a way that:

// Employees are sorted by their salary in ascending order.
// If two or more employees have the same salary, they should be sorted by their name in lexicographical order.
// You need to implement this using a TreeSet in Java. The Employee class should implement the Comparable interface and override the compareTo() method to provide custom sorting.

// In the compareTo() method:

// If the salaries are equal, employees are compared by their names.
// If the salaries are not equal, employees are compared by their salaries.

import java.util.*;

class GA5_Employee implements Comparable {
     private String name;
     private double salary;

     public GA5_Employee(String name, double salary) {
          this.name = name;
          this.salary = salary;
     }

     public String toString() {
          return "[" + name + " : " + salary + "]";
     }

     public int compareTo(Object e) {
          GA5_Employee d = (GA5_Employee) e;
          if (salary == d.salary)
               return name.compareTo(d.name);
          else {
               if (d.salary > salary)
                    return 1;
               else if (d.salary < salary)
                    return -1;
               else
                    return 0;
          }
     }
}

public class GA5 {
     public static void main(String[] args) {
          // LinkedHashSet<Employee> empList = new LinkedHashSet<Employee>(); //retains
          // the inserted order
          TreeSet<GA5_Employee> empList = new TreeSet<GA5_Employee>();
          empList.add(new GA5_Employee("raj", 30000.00));
          empList.add(new GA5_Employee("akash", 60000.00));
          empList.add(new GA5_Employee("biraj", 60000.00));
          empList.add(new GA5_Employee("vinay", 40000.00));
          for (GA5_Employee e : empList)
               System.out.println(e);
     }
}