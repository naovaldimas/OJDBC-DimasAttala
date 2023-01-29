/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.JobControllers;
import controllers.RegionControllers;
import daos.JobDAO;
import daos.RegionDAO;
import idaos.IJobDAO;
import idaos.IRegionDAO;
import java.util.List;
import models.Job;
import models.Region;

/**
 *
 * @author dimas attala
 */
public class OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnection connection = new DBConnection();
        RegionDAO rdao = new RegionDAO(connection.getConnection());
        RegionControllers rcon = new RegionControllers(connection.getConnection());
        JobDAO jdao = new JobDAO(connection.getConnection());
        JobControllers jcon = new JobControllers(connection.getConnection());
//        System.out.println(connection);
        
//        Region region = new Region();
//        region.setId(0);
//        region.setName("region");
//        System.out.println(region.getId() + " " + region.getName());
//        
//        Region r = new Region(1, "Region New");
//        System.out.println(r.getId() + " " + r.getName());

//    =========RegionDAO=============================
        //ManualTest insert()
//        Region reg = new Region(6, "Australia");
//        System.out.println(rdao.insert(reg));
          
        //ManualTest update()
//        Region r1 = new Region(6, "Indonesia");
//        System.out.println(rdao.update(r1)); 
        
        //ManualTest getAll()
//        for (Region region : rdao.getAll()){
//            System.out.println("id: " + region.getId() + "," + " region: " +  region.getName());
//        }

        //ManualTest getById()
//        RegionDAO r2 = new RegionDAO(connection.getConnection());
//        Region r3 = r2.getById(1);
//        System.out.println(r3);

        //ManualTest search()
//        for (Region region : rdao.search("A")){
//            System.out.println("ID   : " + region.getId());
//            System.out.println("Name : " + region.getName());
//        }

        //ManualTest delete()
//        IRegionDAO hapus = new RegionDAO(connection.getConnection());
//        hapus.delete(5);

//    =========JobsDAO===============================
        //ManualTest getAll()
//        for (Job jobs : jdao.getAll()){
//            System.out.println("id: " + jobs.getId() + "," + 
//                               " title: " + jobs.getTitle() + "," + 
//                               " max_salary: " + jobs.getMax_salary() + "," +
//                               " min_salary: " + jobs.getMin_salary()); 
//        }
        //ManualTest getById()
//        Job jb = jdao.getById("MCC_74");
//        System.out.println("id: " + jb.getId() + "," + 
//                           " title: " + jb.getTitle() + "," + 
//                           " max_salary: " + jb.getMin_salary() + "," +
//                           " min_salary: " + jb.getMax_salary());

        //ManualTest search()
//        for (Job job : jdao.search("MCC_74")){
//            System.out.println("id: " + job.getId() + "," + 
//                               " title: " + job.getTitle() + "," + 
//                               " max_salary: " + job.getMax_salary() + "," +
//                               " min_salary: " + job.getMin_salary());
//        }

        //ManualTest insert()
//        Job jo = new Job("MCC_74", "Application DevJr", 10000, 2000);
//        System.out.println(jdao.insert(jo));

        //ManualTest update()
//        Job jbs = new Job("MCC_74", "Application Dev", 2000, 10000);
//        System.out.println(jdao.update(jbs));

        //ManualTest delete()
//        JobDAO hapus = new JobDAO(connection.getConnection());
//        hapus.delete("MCC_74");

// =======RegionControllers=================================

        //ManualTest controller getAll()
//        for(Region r: rcon.getAll()){
//            System.out.println("id: " + r.getId() + "," +
//                               " name: " + r.getName());
//        }

        //ManualTest controller getById()
//        rcon.getById("");
    
        //ManualTest controller search()
//        for(Region r: rcon.search("Papua")){
//            System.out.println("id: " + r.getId() + "," +
//                               " name: " + r.getName());
//        }

        //ManualTest controller insert()
//        System.out.println(rcon.insert("7", "Kuala Lumpur"));

        //ManualTest controller update()
//        System.out.println(rcon.update("7", "Papua Nugini"));

        //ManualTest controller delete()
//        rcon.delete("7");

// =======JobControllers=====================================

        //ManualTest controller getAll()
//        for(Job j: jcon.getAll()){
//            System.out.println("id: " + j.getId() + "," +
//                               " title: " + j.getTitle() + "," +
//                               " min salary: " + j.getMin_salary() + "," +
//                               " max salary: " + j.getMax_salary());
//        }
        
        //ManualTest controller getById()
//        jcon.getById("MCC_72");

        //ManualTest controller search()
//        for(Job j: jcon.search("MCC_74")){
//            System.out.println("id: " + j.getId() + "," +
//                               " title: " + j.getTitle() + "," +
//                               " min salary: " + j.getMin_salary() + "," +
//                               " max salary: " + j.getMax_salary());
//        }

        //ManualTest controller insert()
//        System.out.println(jcon.insert("MCC_72", "Application DevJr", "5000", "10000"));

        //ManualTest controller update()
//        System.out.println(jcon.update("MCC_72", "App Dev Jr", "5000", "15000"));       
    
        //ManualTest controller delete()
//        jcon.delete("MCC_72");        
    }
    
}
