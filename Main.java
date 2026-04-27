import java.util.Scanner;

class Student {
    // Private instance variables
    private String name;
    private int id;
    private int age;
    private String grade;

    // Constructor
    public Student(String name, int id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------");
    }
}

class StudentManagement {
    // Static variables
    private static Student[] students = new Student[100];
    private static int totalStudents = 0;

    // Add student
    public static void addStudent(String name, int id, int age, String grade) {
        if (totalStudents < students.length) {
            students[totalStudents] = new Student(name, id, age, grade);
            totalStudents++;
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student list is full.");
        }
    }

    // Update student
    public static void updateStudent(int id, String name, int age, String grade) {
        for (int i = 0; i < totalStudents; i++) {
            if (students[i].getId() == id) {
                students[i].setName(name);
                students[i].setAge(age);
                students[i].setGrade(grade);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Error: Student ID not found.");
    }

    // View student
    public static void viewStudent(int id) {
        for (int i = 0; i < totalStudents; i++) {
            if (students[i].getId() == id) {
                students[i].displayStudent();
                return;
            }
        }
        System.out.println("Error: Student ID not found.");
    }

    // View all students
    public static void viewAllStudents() {
        if (totalStudents == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < totalStudents; i++) {
            students[i].displayStudent();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. View Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.next();

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();

                    System.out.print("Enter Grade: ");
                    String grade = scanner.next();

                    StudentManagement.addStudent(name, id, age, grade);
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.next();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();

                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.next();

                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;

                case 3:
                    System.out.print("Enter ID to view: ");
                    int viewId = scanner.nextInt();
                    StudentManagement.viewStudent(viewId);
                    break;

                case 4:
                    StudentManagement.viewAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
