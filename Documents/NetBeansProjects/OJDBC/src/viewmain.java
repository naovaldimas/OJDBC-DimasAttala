/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dimas attala
 */
import views.JobView;
import views.RegionView;

import java.util.Scanner;

public class viewmain {
    static Scanner scn = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String pilihan = "";
        while (true){
            menu();
            System.out.print("Input pilihan: ");
            pilihan = scn.nextLine().toUpperCase();
            switch(pilihan){
                case "1" : regionview();
                case "2" : jobview();
                case "K" : System.exit(0);
                default : System.out.println("Invalid data input");
            }
        }
    }
    
    public static void menu(){
        System.out.println("+--HR--CRUD--+");
        System.out.println("| 1. Regions | ");
        System.out.println("| 2. Jobs    |");
        System.out.println("+------------+");
        System.out.println("| Keluar (K) | ");
        System.out.println("+------------+ ");
    }
    
    public static void regionview(){
        RegionView rv = new RegionView();
        rv.main();
    }
    
    public static void jobview(){
        JobView jv = new JobView();
        jv.main();
    }
    
}
