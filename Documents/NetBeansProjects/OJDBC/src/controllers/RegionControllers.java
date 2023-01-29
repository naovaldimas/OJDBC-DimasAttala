/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import icontrollers.IRegionControllers;
import idaos.IRegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author dimas attala
 */
public class RegionControllers implements IRegionControllers{
    private IRegionDAO irdao;
    public RegionControllers(Connection connection){
        irdao = new RegionDAO(connection);
    }

    @Override
    public List<Region> getAll() {
        return irdao.getAll();
    }

    @Override
    public Region getById(String id) {
        Region r = new Region(0, "0");
        try{
            if(id.isEmpty()){
                System.out.println("Gagal getById, Tidak ada Input");
            } else if (Integer.parseInt(id)<0){
                System.out.println("Gagal getById, ID kurang dari 0 atau negatif");
            } else {
                r = irdao.getById(Integer.parseInt(id));
                System.out.println("id: " + r.getId() + "," +
                                   "name: " + r.getName());
            } 
        } catch (NumberFormatException nfe){
            System.out.println("Gagal getById, masukkan data dengan benar");
        } return r;
    }

    @Override
    public List<Region> search(String key) {
        List<Region> keyword = new ArrayList<>();
        if(key.isEmpty()){
            System.out.println("Gagal cari, tidak ada input");
        } else if(key.length() > 15){
            System.out.println("Gagal cari, data lebih dari 15 karakter");
        } else {
            keyword = irdao.search(key);
        }
        return keyword;
    }

    @Override
    public Region insert(String id, String name) {
        String result = "";
        Region r = new Region(Integer.parseInt(id), name.substring(0, 1).toUpperCase() + name.substring(1));
        try{
            if(Integer.parseInt(id) < 0){
                System.out.println("Gagal Insert, data negatif");
            } else if (name.length() > 15){
                System.out.println("Gagal Insert, data harus kurang dari 15 huruf");
            } else if (irdao.getById(r.getId()).getId() == r.getId()){
                System.out.println("Gagal Insert, data sudah ada");
            } else {
                irdao.insert(r);
                System.out.println("Insert Sukses");
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Gagal Insert, masukkan data dengan benar");
        } return r;
    } 

    @Override
    public Region update(String id, String name) {
        String result = "";
        Region r = new Region(Integer.parseInt(id), name.substring(0, 1).toUpperCase() + name.substring(1));
        try{
            if(Integer.parseInt(id) < 0){
                System.out.println("Gagal Update, data negatif");
            } else if (name.length() > 15){
                System.out.println("Gagal Update, data harus kurang dari 15 huruf");
            } else if (irdao.getById(r.getId()).getId() != r.getId()){
                System.out.println("Gagal Insert, data tidak ada");
            } else {
                irdao.update(r);
                System.out.println("Update Sukses");
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Gagal Update, masukkan data dengan benar");
        } return r;
    }

    @Override
    public void delete(String id) {
        String result = "";
        try{
            if(id.isEmpty()){
                System.out.println("Gagal Delete, data kosong");
            } else if(Integer.parseInt(id)<0){
                System.out.println("Gagal Delete, data negatif");
            } else if(Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()){
                System.out.println("Gagal Delete, data tidak ditemukan");
            } else {
                irdao.delete(Integer.parseInt(id));
                System.out.println("Delete Sukses");
            } 
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Gagal Delete, masukkan data dengan benar");
        }
    }
}
