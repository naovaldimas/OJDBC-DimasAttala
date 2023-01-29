/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author dimas attala
 */
public class RegionDAO implements IRegionDAO {
    
    private Connection connection;
    
    public RegionDAO (Connection connection){
        this.connection = connection;
    }
    
    @Override
    public List<Region> getAll() {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS ORDER BY region_id";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e){
            e.getStackTrace();
        }
        return listRegion;
    }

    @Override
    public Region getById(int id) {
        Region r = new Region();
        String query = "SELECT * FROM HR.REGIONS WHERE region_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                r = new Region(resultSet.getInt(1),
                               resultSet.getString(2));
            }
        } catch (Exception e){
            e.getStackTrace();
        } 
        return r;        
    }

    @Override
    public List<Region> search(String key) {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS WHERE region_name LIKE ? ";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e){
            e.getStackTrace();
        } return listRegion;
    }

    @Override
    public Region insert(Region r) {
        String query = "INSERT INTO HR.REGIONS(region_id, region_name) VALUES (?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getId());
            preparedStatement.setString(2, r.getName());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } return null;
    }

    @Override
    public Region update(Region r) {
        String query = "UPDATE HR.REGIONS SET region_name = ? WHERE region_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(2, r.getId());
            preparedStatement.setString(1, r.getName());
            preparedStatement.executeQuery();
        } catch (Exception e){
            e.printStackTrace();
        } return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM HR.REGIONS WHERE region_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
