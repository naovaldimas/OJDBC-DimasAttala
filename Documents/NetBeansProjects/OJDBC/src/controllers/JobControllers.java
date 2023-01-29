/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import icontrollers.IJobControllers;
import java.util.List;
import models.Job;
import idaos.IJobDAO;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author dimas attala
 */
public class JobControllers implements IJobControllers {
    private IJobDAO ijdao;

    public JobControllers(Connection connection) {
        ijdao = new JobDAO(connection);
    }
    
    @Override
    public List<Job> getAll() {
        return ijdao.getAll();
    }

    @Override
    public Job getById(String id) {
        Job j = new Job("0", "0", 0, 0);
        try{
            if(id.isEmpty()){
                System.out.println("Gagal getById, Tidak ada Input");
            } else if (!id.toUpperCase().equals(ijdao.getById(id.toUpperCase()).getId())){
                System.out.println("Gagal getById, ID tidak ada");
            } else {
                 j = ijdao.getById(id.toUpperCase());
                 System.out.println("id: " + j.getId() + "," +
                                    " title: " + j.getTitle() + "," + 
                                    " min salary: " + j.getMin_salary() + "," +
                                    " max_salary: " + j.getMax_salary());
            }
        } catch (NumberFormatException nfe){
            System.out.println("Gagal getById, masukkan data dengan benar");
        } return j;
    }

    @Override
    public List<Job> search(String key) {
        List<Job> keyword = new ArrayList<>();
        if(key.isEmpty()){
            System.out.println("Gagal cari, tidak ada input");
        } else if(key.length() > 30){
            System.out.println("Gagal cari, data lebih dari 30 karakter");
        } else {
            keyword = ijdao.search(key);
        }
        return keyword;
    }

    @Override
    public Job insert(String id, String title, String max_salary, String min_salary) {
        String result = "";
        Job j = new Job(id.toUpperCase(), title.substring(0, 1).toUpperCase() + title.substring(1), Integer.parseInt(max_salary), Integer.parseInt(min_salary));
        try{
            if(id.toUpperCase().length() > 10){
                System.out.println("Gagal Insert, data lebih dari 10 karakter");
            } else if ((title.substring(0, 1).toUpperCase() + title.substring(1)).length() > 35){
                System.out.println("Gagal Insert, data lebih dari 35 karakter");                
            } else if (id.toUpperCase().equals(ijdao.getById(id.toUpperCase()).getId())){
                System.out.println("Gagal Insert, data ID sudah ada");
            } else {
                ijdao.insert(j);
                System.out.println("Insert Sukses");
            }            
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Gagal Insert, masukkan data dengan benar");
        } return j;
    }

    @Override
    public Job update(String id, String title, String max_salary, String min_salary) {
        String result = "";
        Job j = new Job(id.toUpperCase(), title.substring(0, 1).toUpperCase() + title.substring(1), Integer.parseInt(max_salary), Integer.parseInt(min_salary));
        try{
            if(id.toUpperCase().length() > 10){
                System.out.println("Gagal Update, data ID lebih dari 10 karakter");
            } else if ((title.substring(0, 1).toUpperCase() + title.substring(1)).length() > 35){
                System.out.println("Gagal Update, data TITLE lebih dari 35 karakter");                
            } else if (!id.toUpperCase().equals(ijdao.getById(id.toUpperCase()).getId())){
                System.out.println("Gagal Update, data ID tidak ada");
            } else {
                ijdao.update(j);
                System.out.println("Update Sukses");
            }            
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Gagal Update, masukkan data dengan benar");
        } return j;
    }

    @Override
    public void delete(String id) {
        String result = "";
        try{
            if(id.toUpperCase().isEmpty()){
                System.out.println("Gagal Delete, data kosong");
            } else if (id.toUpperCase().length() > 10){
                System.out.println("Gagal Delete, data kurang dari 10 karakter");
            } else if (!id.toUpperCase().equals(ijdao.getById(id.toUpperCase()).getId())){
                System.out.println("Gagal Delete, data ID tidak ada");
            } else {
                ijdao.delete(id.toUpperCase());
                System.out.println("Delete Sukses");
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Gagal Delete, masukkan data dengan benar");
        }
    }
}
