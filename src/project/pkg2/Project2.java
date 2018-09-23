/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg2;

import java.util.Scanner;

/**
 *
 * @author admin-vk0018
 */
public class Project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("\tMAIN MENU:\n" +
                "\t\t1) Add new member record\n" +
                "\t\t2) Modify existing member record\n" +
                "\t\t3) Delete member record\n" +
                "\t\t4) Display all member records\n" +
                "\t\t5) Search for a particular member record\n" +
                "\t\t6) Exit");


        int a = 0;
        Scanner reader = new Scanner(System.in);
        while(a!=6) {



            a = reader.nextInt();
            System.out.println("You entered integer " + a);

            if(a==1){
                AddNewMember anm = new AddNewMember();
                anm.openFile();
                anm.addRecords();
                anm.checkName();
                anm.addNewData();
                anm.closeFile();
                break;


            }

            if(a==2){
                System.out.println("You selected the option to modify the File");

                ModifyFile mf = new ModifyFile();
                mf.currentDetails();
                mf.checkDetails();
                mf.modifyFile();
                break;

            }
            if(a==3){
                System.out.println("You selected the option to delete a particular record");

                DeleteRecord dr = new DeleteRecord();
                dr.currentDetails();
                dr.checkDetails();
                dr.modifyFile();
                break;

            }
            if(a==4){
                System.out.println("You selected the options to display all records");
                DisplayAllRecords dar = new DisplayAllRecords();
                dar.currentDetails();
                break;

            }
            if(a==5){
                System.out.println("You selected the option to printout a desired member");

                SearchMember sm = new SearchMember();
                sm.currentDetails();
                sm.checkDetails();
                break;
            }

            if(a==6){

                System.out.println("Good Bye");
                break;


            }
        }


    }
}
    

