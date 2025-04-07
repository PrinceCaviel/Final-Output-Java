import java.util.ArrayList;
import java.util.Scanner;

class Student 
{
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }
    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getCourse() 
    {
        return course;
    }

    @Override
    public String toString() 
    {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

public class App 
{
    private ArrayList<Student> students;
    private Scanner scanner;

    public App() 
    {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() 
    {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    public void viewStudents() 
    {
        if (students.isEmpty()) 
        {
            System.out.println("No students in the list.");
            return;
        }
        System.out.println("List of Students:");
        for (Student student : students) 
        {
                System.out.println(student);
        }
  }

    public void searchStudentById() 
    {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        boolean found = false;
        
        for (Student student : students) 
        {
            if (student.getId() == id) 
            {
                System.out.println("Student found: " + student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudentById() 
    {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        boolean deleted = false;

        for (int i = 0; i < students.size(); i++) 
        {
            if (students.get(i).getId() == id) 
            {
                students.remove(i);
                System.out.println("Student with ID " + id + " deleted successfully.");
                deleted = true;
                break;
            }
        }

        if (!deleted) 
        {
            System.out.println("Student not found.");
        }
    }

    public void menu() 
    {
        while (true) 
        {
            System.out.println("\n=====Student Management System======");
            System.out.println("1. Add a Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    deleteStudentById();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) 
    {
        App sms = new App();
        sms.menu();
    }
}
