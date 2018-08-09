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
import java.util.Arrays;
import java.util.Scanner;


public class DatabasePractice {

     public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException{
         
         DatabasePracticeView v = new DatabasePracticeView ();
         v.mainMenu();
         
    }
     
     
    
}
