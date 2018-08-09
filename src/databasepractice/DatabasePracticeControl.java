/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasepractice;

/**
 *
 * @author Dallen
 */
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DatabasePracticeControl {

     String url;
     String username;
     String password;
     Connection conn;
     Statement stmt;

   
    public DatabasePracticeControl() throws SQLException, InstantiationException, IllegalAccessException{
        this.url = "jdbc:mysql://localhost/tas";
        this.username = "tasuser";
        this.password = "teamone";
        openConnection();
    }

    private void openConnection() throws SQLException, InstantiationException, IllegalAccessException{
         try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             conn = DriverManager.getConnection(url, username,password);
             stmt = conn.createStatement();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DatabasePractice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    protected void close() throws SQLException, InstantiationException, IllegalAccessException{
        conn.close();
        stmt.close();
    }
    
    protected ResultSet findPersonUsingID(String id) throws SQLException{
        this.stmt = conn.createStatement();
        ResultSet person;
        String inputID = id;
        person = stmt.executeQuery("select description from Badge where id="+ "'" + inputID + "'");
        return person;
    }
    
    protected ResultSet getEmployeeType(String id) throws SQLException{
        this.stmt = conn.createStatement();
        ResultSet empInfo = stmt.executeQuery("SELECT employee.lastname, employee.firstname, employeetype.description\n" +
        "FROM employee\n" +
        "INNER JOIN employeetype ON employee.employeetypeid = employeetype.id where employee.badgeid=" + "'" + id + "';");
        return empInfo;
    }
    
    protected ResultSet getDepartment(String firstName,String lastName) throws SQLException{
        this.stmt = conn.createStatement();
        ResultSet dept = stmt.executeQuery("select employee.firstname,employee.lastname, department.description\n"+ 
        "from employee inner join department on employee.departmentid = department.id where employee.firstname=" +"'" + firstName + "'"
        + " and employee.lastname=" + "'" + lastName + "'");
        return dept;
    }
    
    protected void printResultSet(ResultSet rs) throws SQLException{
        ResultSetMetaData rsmd = rs.getMetaData();
        int numColumns = rsmd.getColumnCount();
        while(rs.next()){
            for(int i=1 ; i <= numColumns; ++i){
                if(i > 1)System.out.print(", ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " ");
            }
            System.out.println("");
        }
        
    }    
}
