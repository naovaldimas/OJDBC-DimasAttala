/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.JobControllers;
import icontrollers.IJobControllers;
import java.util.Scanner;
import models.Job;
import tools.DBConnection;

/**
 *
 * @author dimas attala
 */
public class JobView {
    DBConnection connection = new DBConnection();
    IJobControllers ijc = new JobControllers(connection.getConnection());
    Scanner scn = new Scanner(System.in);
    boolean tes = true;
    
    public void main(){
        String pilihan = " ";
        do{
            menu();
            System.out.print("Masukkan pilihan: ");
            pilihan = scn.nextLine().toUpperCase();
            switch(pilihan){
                case "1" : GetAll(); break;
                case "2" : GetById(); break;
                case "3" : Search(); break;
                case "4" : Insert(); break;
                case "5" : Update(); break;
                case "6" : Delete(); break;
                case "K" : System.exit(0); break;
                default  : System.out.println("input invalid"); break;
            }
        } while (tes);
    }
    
    public void menu(){
        System.out.println("+-----------HR CRUD-------+");
        System.out.println("|  1. Job GetAll()  Data  |");
        System.out.println("|  2. Job GetById() Data  |");
        System.out.println("|  3. Job Search()  Data  |");
        System.out.println("|  4. Job Insert()  Data  |");
        System.out.println("|  5. Job Update()  Data  |");
        System.out.println("|  6. Job Delete()  Data  |");
        System.out.println("+-------------------------+");
        System.out.println("|      K. System exit     |");
        System.out.println("+-------------------------+");
    }
    
    public void GetAll(){
        for(Job j: ijc.getAll()){
            System.out.println("id: " + j.getId() + "," +
                               " title: " + j.getTitle() + "," +
                               " min_salary: " + j.getMin_salary() + "," +
                               " max_salary: " + j.getMax_salary());
        }
    }
        
    public void GetById(){
        System.out.print("Masukkan id: ");
        Job j = ijc.getById(scn.nextLine());
        System.out.println("id: " + j.getId() + "," +
                           " title: " + j.getTitle() + "," +
                           " min_salary: " + j.getMin_salary() + "," +
                           " max_salary: " + j.getMax_salary());
    }
    
    public void Search(){
        System.out.print("Masukkan keyword: ");
        for(Job j: ijc.search(scn.nextLine())){
            System.out.println("id: " + j.getId() + "," +
                               " title: " + j.getTitle() + "," +
                               " min_salary: " + j.getMin_salary() + "," +
                               " max_salary: " + j.getMax_salary());
        } 
    }
    
    public void Insert(){
        System.out.print("Masukkan id: ");
        String id = scn.nextLine();
        System.out.println("Masukkan title: ");
        String title = scn.nextLine();
        System.out.println("Masukkan min salary: ");
        String min_salary = scn.nextLine();
        System.out.println("Masukkan max salary: ");
        String max_salary = scn.nextLine();
        System.out.println(ijc.insert(id, title, max_salary, min_salary));
    }
    
    public void Update(){
        System.out.print("Masukkan id: ");
        String id = scn.nextLine();
        System.out.print("Masukkan title: ");
        String title = scn.nextLine();
        System.out.println("Masukkan min salary: ");
        String min_salary = scn.nextLine();
        System.out.println("Masukkan max salary: ");
        String max_salary = scn.nextLine();
        System.out.println(ijc.update(id, title, max_salary, min_salary));
    }
    
    public void Delete(){
        System.out.print("Masukkan id yang mau dihapus: ");
        String id = scn.nextLine();
        ijc.delete(id);
    }
}
