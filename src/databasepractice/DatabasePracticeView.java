/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasepractice;


import java.sql.SQLException;
import java.util.Scanner;
public class DatabasePracticeView {
    
    protected void mainMenu() throws SQLException, IllegalAccessException, InstantiationException{
        boolean userExit = false;
        DatabasePracticeControl c = new DatabasePracticeControl();
        int choice = 0;
        if(choice == 4) userExit = true;
        System.out.println("Employee Search Engine V1.0 jda_10");
        while(!userExit){
            System.out.println("1) Find employee name");
            System.out.println("2) Find employee type");
            System.out.println("3) Find employee department");
            System.out.println("4) Exit");
            Scanner in = new Scanner(System.in);
            choice = Integer.parseInt(in.next());
            String userInput;
            switch(choice){
                case 1:
                    System.out.println("Enter the id of the person you are looking for: ");
                    Scanner inTwo = new Scanner(System.in);
                    userInput = inTwo.next();
                    c.printResultSet(c.findPersonUsingID(userInput));
                    
                    break;
                case 2:
                    System.out.println("Enter the id of the person you are looking for: ");
                    Scanner inThree = new Scanner(System.in);
                    userInput = inThree.next();
                    c.printResultSet(c.getEmployeeType(userInput));
                    break;
                case 3:
                    System.out.println("Enter the id of the person you are looking for: ");
                    Scanner inFour = new Scanner(System.in);
                    String[] userInputArray = inFour.nextLine().split("\\s+");
                    String first = userInputArray[0];
                    String last = userInputArray[1];
                    c.printResultSet(c.getDepartment(first, last));
                    break;
                case 4:
                    userExit = true;
                    c.close();
                    break;
                    
                default:
                    System.out.println("Error");
                    break;
            }
            
        }
    }
    
    

    
}
