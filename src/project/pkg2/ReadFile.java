/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg2;

import sun.awt.image.ImageWatched;

import java.util.*;
import java.io.*;

/**
 *
 * @author admin-vk0018
 */
public class ReadFile {
    
    public static LinkedList<String> object = new LinkedList<String>();



    public void openFile(){
        try{
            File x = new File("animals.dat");
            readFilebyLine(x);
        }
        catch (Exception e){
            System.out.println("could not find the file");
        }

    }
    public static void readFilebyLine(File f) throws IOException{

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;


        while((line = br.readLine()) != null){
            System.out.println(line);
            object.add(line);

        }

//        String a = "Allman, Beth";
//        int i = 0;
//        int j =0;
//        for(String s : object){
//            if(s.contains(a)){
//
//                System.out.println(s);
//                j = i;
//                System.out.println("yes");
//
//            }
//            i++;
//
//        }
//
//        System.out.println(object.get(j));




        br.close();
        fr.close();

    }

    public LinkedList<String> getObject(){
        return object;
    }
    
}
