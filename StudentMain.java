package sis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by boruto on 7/10/17.
 */
public class StudentMain {
    public static void main(String[] args) {
        Student student = new Student();
        StudentService studentService = new StudentService();

        boolean status;
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\nOperations\n1. Add Student\n2. Delete Student\n3. Update Student\n4.Search Student\n5. Exit");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Add Student");
                    System.out.println("-----------");
                    System.out.println("Enter Student's Name: ");
                    student.setStudentName(scanner.next());
                    System.out.println("Enter Student's Rollnumber: ");
                    student.setRollNumber(scanner.nextInt());
                    System.out.println("Enter Student's Department Name: ");
                    student.setDepartmentName(scanner.next());
                    status = studentService.addStudent(student);
                    if (status) {
                        System.out.println("Student added successfully");
                    } else {
                        System.out.println("Sorry! Student couldnot be added");
                    }
                    break;

                case 2:
                    System.out.println("Delete Student");
                    System.out.println("--------------");
                    System.out.println("Enter Student's Id: ");
                    student.setId(scanner.nextInt());
                    status = studentService.deleteStudent(student.getId());
                    if (status) {
                        System.out.println("Students deleted successfully");
                    } else {
                        System.out.println("Sorry! Students couldnot be deleted.");
                    }
                    break;

                case 3:
                    System.out.println("Update Student");
                    System.out.println("---------------");
                    System.out.println("Enter Student's Name: ");
                    student.setStudentName(scanner.next());
                    System.out.println("Enter Student's Id: ");
                    student.setId(scanner.nextInt());
                    status = studentService.update(student.getId(), student.getStudentName());
                    if (status) {
                        System.out.println("Students updated successfully");
                    } else {
                        System.out.println("Sorry! Students couldnot be updated.");
                    }
                    break;
                case 4:
                    System.out.println("Search Student");
                    System.out.println("---------------");
                    System.out.println("Enter Student's Name:");
                    student.setStudentName(scanner.next());

                    List<Student> s = new ArrayList<>();
                    s = studentService.searchStudent(student.getStudentName());

                    for (Student a : s) {
                        System.out.println("name = " + a.getStudentName());
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program....");
                    flag = false;
                    break;
                default:
                    System.out.println("Sorry! Invalid Choice\nPlease try again");

            }
        }
    }
}
