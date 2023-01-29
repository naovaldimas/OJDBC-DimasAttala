/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
/**
 *
 * @author dimas attala
 */
import controllers.RegionControllers;
import icontrollers.IRegionControllers;
import java.util.Scanner;
import models.Region;
import tools.DBConnection;

public class RegionView {
    DBConnection connection = new DBConnection();
    IRegionControllers irc = new RegionControllers(connection.getConnection());
    Scanner scn = new Scanner(System.in);
    boolean tes = true;
    
    public void main() {
        String pilihan = " ";
        do {
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
        } while(tes);
    }
    
    public void menu(){
        System.out.println("");
        System.out.println("-----------HR CRUD-----------");
        System.out.println("1. Regions GetAll()  Data");
        System.out.println("2. Regions GetById() Data");
        System.out.println("3. Regions Search()  Data");
        System.out.println("4. Regions Insert()  Data");
        System.out.println("5. Regions Update()  Data");
        System.out.println("6. Regions Delete()  Data");
        System.out.println("");
        System.out.println("K. System exit");
        System.out.println("-----------------------------");
    }
    
    public void GetAll(){
        for(Region r: irc.getAll()){
            System.out.println("id: " + r.getId() + "," +
                               " name: " + r.getName());
        } 
    }
    
    public void GetById(){
        System.out.print("Masukkan nomor id: ");
        Region r = irc.getById(scn.nextLine());
        System.out.println("id: " + r.getId());
        System.out.println("name : " + r.getName());
    }
    
    public void Search(){
        System.out.print("Masukkan keyword: ");
        for(Region r: irc.search(scn.nextLine())){
            System.out.println("id: " + r.getId() + "," +
                               " name: " + r.getName());
        } 
    }
    
    public void Insert(){
        System.out.print("Masukkan id: ");
        String id = scn.nextLine();
        System.out.print("Masukkan name: ");
        String name = scn.nextLine();
        System.out.println(irc.insert(id, name));
    }
    
    public void Update(){
        System.out.print("Masukkan id: ");
        String id = scn.nextLine();
        System.out.print("Masukkan name: ");
        String name = scn.nextLine();
        System.out.println(irc.update(id, name));
    }
    
    public void Delete(){
        System.out.print("Masukkan id yang mau dihapus: ");
        String id = scn.nextLine();
        irc.delete(id);
    }
}
