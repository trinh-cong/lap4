package lap5.exercise2;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private double mark;

    public Student() {}

    public Student(String name, int age, double mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    // Getters and setters...

    // Override toString() for display purposes...
    @Override
    public String toString() {
        return name + "\t" + age + "\t" + mark;
    }

    public void setName(String inputString) {
    }

    public void setAge(int inputInt) {
    }

    public void setMark(double inputDouble) {
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMark() {
        return mark;
    }
}

public class Main {
    private static final String STUDENTS_FILE = "students.dat";

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\nMenu\n-------------------------------------------------");
            System.out.println("1. Add a list of Students and save to File");
            System.out.println("2. Loading list of Students from a File");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            choice = inputInt();

            switch (choice) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    loadStudents();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 3.");
            }
        } while (choice != 3);
    }

    private static void addStudents() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(STUDENTS_FILE, true))) {
            int numStudents = inputInt("Enter number of students: ");
            for (int i = 0; i < numStudents; i++) {
                Student student = new Student();
                student.setName(inputString("Enter name of student #" + (i + 1) + ": "));
                student.setAge(inputInt("Enter age of student #" + (i + 1) + ": "));
                student.setMark(inputDouble("Enter mark of student #" + (i + 1) + ": "));
                objectOutputStream.writeObject(student);
            }
            System.out.println("Students added successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void loadStudents() {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(STUDENTS_FILE))) {
            while (true) {
                Student student = (Student) objectInputStream.readObject();
                students.add(student);
            }
        } catch (EOFException e) {
            // End of file reached; do nothing.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.printf("%-20s%-10s%-10s\n", "Name", "Age", "Mark");
        for (Student student : students) {
            System.out.printf("%-20s%-10d%-10.2f\n", student.getName(), student.getAge(), student.getMark());
        }
    }

    private static int inputInt(String prompt) {
        System.out.print(prompt);
        return inputInt();
    }

    private static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double inputDouble(String prompt) {
        System.out.print(prompt);
        return inputDouble();
    }

    private static double inputDouble() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input! Please enter a number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static String inputString(String prompt) {
        System.out.print(prompt);
        return inputString();
    }

    private static String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
