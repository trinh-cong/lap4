package jp2;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementProgram {
    private ArrayList<Student> students = new ArrayList<>();
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add student records");
            System.out.println("2. Display student records");
            System.out.println("3. Save");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    saveStudents();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }
    private void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student address: ");
        String address = scanner.nextLine();
        System.out.print("Enter student phone number: ");
        String phone = scanner.nextLine();

        Student student = new Student(studentID, name, address, phone);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    private void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student ID, Name, Address, Phone");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private void saveStudents() {
        try {
            FileWriter writer = new FileWriter("students.txt");
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
            writer.close();
            System.out.println("Student records saved to students.txt");
        } catch (IOException e) {
            System.out.println("Error saving student records.");
            e.printStackTrace();
        }
    }
}
