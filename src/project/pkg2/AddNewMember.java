/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg2;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.nio.channels.FileChannel;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Scanner;


/**
 *
 * @author admin-vk0018
 */
public class AddNewMember {
    
    private FileWriter x;
    private Formatter form;
    private String animal_ownerName;
    private String newAnimalDetails;
    public static LinkedList<String> animal_linkedList = new LinkedList<String>();
    private String line;


    public void openFile(){

        try{
            x = new FileWriter("animals.dat", true);
            form = new Formatter(x);
        }

        catch (Exception e){
            System.out.println("You have an error");
        }

    }

    public void addRecords(){

        //Adding Animal Name.
        System.out.println("Please input animal name: ");
        Scanner reader_an = new Scanner(System.in);
        String animal_name = reader_an.next();

        //Adding Animal's Owner.
        System.out.println("Please input animal's owner Name: \n");
        System.out.println("First Name: ");
        Scanner reader_aofn = new Scanner(System.in);
        String animal_ofn = reader_aofn.next();

        System.out.println("Last Name: ");
        Scanner reader_aoln = new Scanner(System.in);
        String animal_oln = reader_aoln.next();

        //Adding species.
        System.out.println("Please input animal species: ");
        Scanner reader_s = new Scanner(System.in);
        String animal_s = reader_s.next();

        //Adding Date of Birth.
        System.out.println("Please input animal Date of Birth: ");
        Scanner reader_dob = new Scanner(System.in);
        String animal_dob = reader_dob.next();

        //Adding Treatments
        ArrayList<String> animal_treatments = new ArrayList<String>();
        System.out.println("Please input treatments: ");
        Scanner reader_treatments = new Scanner(System.in);

        for(int i=0; i<10;i++) {

            String s = reader_treatments.nextLine();

            if (s.equals("q")|| s.equals("Q")) {

                break;
            }
            animal_treatments.add(s);

        }
//        System.out.println(animal_treatments);


        String formattedString = animal_treatments.toString().replace("[","");
        String formattedString1 = formattedString.replace("]","");
//        System.out.println(formattedString1);

        // Creating object of class linked list
        LinkedList<String> object = new LinkedList<String>();
        object.add(animal_name);

        String animal_on =  animal_oln + ",$" + animal_ofn;
        animal_ownerName = animal_on.replace("$"," ");

        object.add(animal_on);
        object.add(animal_s);
        object.add(animal_dob);
        object.add(formattedString1);

//        System.out.println(object);

        newAnimalDetails = object.toString().replace("[","").replace("]","").replaceAll(",\\s","     ").replace(",$",", ");

//        System.out.println(newAnimalDetails);

    }

    public void checkName(){

        ReadFile rf = new ReadFile();
        rf.openFile();
        animal_linkedList = rf.getObject();

        String a = animal_ownerName;
        int i = 0;
        int j = 0;
        for(String s : animal_linkedList){
            if(s.contains(a)){

//                System.out.println(s);
                j = i;
//                System.out.println("yes");

            }

            i++;

        }
//        System.out.println(animal_linkedList.get(j));
//        System.out.println(animal_linkedList);
        if(j==0){

            animal_linkedList.add(animal_linkedList.size(),newAnimalDetails);

        }
        else {
            animal_linkedList.add(j+1,newAnimalDetails);
        }


//        System.out.println(animal_linkedList);

    }

    public void addNewData(){

        try{

            //create a temp file
            File temp = File.createTempFile("tempfile", ".dat");
            temp.deleteOnExit();

            //write it
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            int size = animal_linkedList.size();
            for(int i = 0; i<size;i++){

                bw.write(animal_linkedList.get(i)+"\n");

            }
            bw.close();

            System.out.println("Done");
            // Original file
            File orig = new File("animals.dat");
            // Copy the contents from temp to original file
            FileChannel src = new FileInputStream(temp).getChannel();
            FileChannel dest = new FileOutputStream(orig).getChannel();
            dest.transferFrom(src, 0, src.size());

        }catch(IOException e){

            e.printStackTrace();

        }




    }


    public void closeFile(){
        form.close();
    }
    
    
    
}
