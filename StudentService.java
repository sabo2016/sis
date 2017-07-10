package sis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boruto on 7/10/17.
 */
public class StudentService {

    private Connection con;

    public StudentService(){
        con = DbConnection.getConnection();
    }

    public boolean addStudent(Student student){
        int status= 0;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO student_tbl(studentName,rollNumber,departmentName) VALUES (?,?,?)");
            preparedStatement.setString(1,student.getStudentName());
            preparedStatement.setInt(2,student.getRollNumber());
            preparedStatement.setString(3,student.getDepartmentName());
            status=preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(status==0){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean deleteStudent(int studentId){
        int status=0;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM student_tbl WHERE ID = ?");
            preparedStatement.setInt(1,studentId);
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(status==0){
            return false;
        }else{
            return true;
        }

    }

    public boolean update(int id, String nameToUpdate){

        int status = 0;

        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE student_tbl SET studentName = ? WHERE id = ?");
            preparedStatement.setString(1,nameToUpdate);
            preparedStatement.setInt(2,id);
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(status==0){
            return false;

        }
        else{
            return true;
        }
    }

    public List<Student> searchStudent(String studentName){

        List<Student> std = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT *FROM student_tbl WHERE studentName = ?");
            preparedStatement.setString(1,studentName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setStudentName(resultSet.getString(2));
                student.setRollNumber(resultSet.getInt(3));
                student.setDepartmentName(resultSet.getString(4));
                std.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return std;
    }

}
