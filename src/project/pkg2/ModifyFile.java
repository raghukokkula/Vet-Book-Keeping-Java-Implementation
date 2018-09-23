/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg2;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author admin-vk0018
 */
public class ModifyFile {
    
    public static LinkedList<String> old_animal_linkedList = new LinkedList<String>();
    public static boolean found;

    public void currentDetails(){



        ReadFile rf = new ReadFile();
        rf.openFile();


        old_animal_linkedList = rf.getObject();

        System.out.println(old_animal_linkedList);
    }


    public void checkDetails() {


        //Ask for Animal Name.
        System.out.println("Please input animal name: ");
        Scanner reader_an = new Scanner(System.in);
        String animal_name = reader_an.next();

        //Ask for Animal's Owner.
        System.out.println("Please input animal's owner Name: \n");
        System.out.println("First Name: ");
        Scanner reader_aofn = new Scanner(System.in);
        String animal_ofn = reader_aofn.next();

        System.out.println("Last Name: ");
        Scanner reader_aoln = new Scanner(System.in);
        String animal_oln = reader_aoln.next();

        String animal_on = animal_oln + ",$" + animal_ofn;
        String animal_ownername = animal_on.replace("$"," ");

        String a = animal_ownername;
        int i = 0;
        int j = 0;
        for (String s : old_animal_linkedList) {
            if (s.contains(a)) {

//                System.out.println(s);
                j = i;
//                System.out.println("yes");

            }

            i++;

        }

        if (j == 0) {
            System.out.println(animal_name + " with owner " + animal_ownername + " was not found in our record");
        } else {

            String selected_string = old_animal_linkedList.get(j);

//            String word = "cat";
//            String text = "The cat is on the table";
//            Boolean found;
//
//            found = text.contains(word);

            String word = animal_name;
            found = selected_string.contains(word);

            if (found) {

                old_animal_linkedList.remove(j);

                //Modifying species.
                System.out.println("Please input animal species: ");
                Scanner reader_s = new Scanner(System.in);
                String animal_s = reader_s.next();

                //Modifying Date of Birth.
                System.out.println("Please input animal Date of Birth: ");
                Scanner reader_dob = new Scanner(System.in);
                String animal_dob = reader_dob.next();

                //Modifying Treatments
                ArrayList<String> animal_treatments = new ArrayList<String>();
                System.out.println("Please input treatments: ");
                Scanner reader_treatments = new Scanner(System.in);

                for (int k = 0; k < 10; k++) {

                    String s = reader_treatments.nextLine();

                    if (s.equals("q") || s.equals("Q")) {

                        break;
                    }
                    animal_treatments.add(s);

                }
                String formattedString = animal_treatments.toString().replace("[", "").replace("]", "");


                LinkedList<String> object = new LinkedList<String>();
                object.add(animal_name);
                object.add(animal_on);
                object.add(animal_s);
                object.add(animal_dob);
                object.add(formattedString);

                String modifiedAnimalDetails = object.toString().replace("[", "").replace("]", "").replaceAll(",\\s", "     ").replace(",$",", ");

                old_animal_linkedList.add(j, modifiedAnimalDetails);

                System.out.println(old_animal_linkedList);


            } else {
                System.out.println(animal_name + " with owner " + animal_ownername + " was not found in our record");
            }

        }
    }


        public void modifyFile(){

        if(found) {


            try {

                //create a temp file
                File temp = File.createTempFile("tempfile", ".dat");
                temp.deleteOnExit();
                //write it
                BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
                int size = old_animal_linkedList.size();
                for (int l = 0; l < size; l++) {

                    bw.write(old_animal_linkedList.get(l) + "\n");

                }
                bw.close();

                System.out.println("Done");
                // Original file
                File orig = new File("animals.dat");
                // Copy the contents from temp to original file
                FileChannel src = new FileInputStream(temp).getChannel();
                FileChannel dest = new FileOutputStream(orig).getChannel();
                dest.transferFrom(src, 0, src.size());

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

    }
    
}
