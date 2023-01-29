/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Job;

/**
 *
 * @author dimas attala
 */
public class JobDAO implements IJobDAO{
    private Connection connection;
    
    public JobDAO (Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Job> getAll() {
        List<Job> listJobs = new ArrayList<Job>();
        String query = "SELECT * FROM HR.JOBS ORDER BY job_id";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Job j = new Job(resultSet.getString(1), 
                                resultSet.getString(2),
                                resultSet.getInt(3),
                                resultSet.getInt(4));
                listJobs.add(j);
            }
        } catch (Exception e){
            e.getStackTrace();
        }
        return listJobs;
    }

    @Override
    public Job getById(String id) {
       Job j = new Job();
       String query = "SELECT * FROM HR.JOBS WHERE job_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                j = new Job(resultSet.getString(1), 
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return j;
    }

    @Override
    public List<Job> search(String key) {
        List<Job> listJob = new ArrayList<Job>();
        String query = "SELECT * FROM HR.JOBS WHERE job_title LIKE ? or job_id LIKE ? or max_salary LIKE ? or min_salary LIKE ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            preparedStatement.setString(3, "%" + key + "%");
            preparedStatement.setString(4, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Job j = new Job(resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getInt(3),
                                resultSet.getInt(4));
                listJob.add(j);
            }
        } catch (Exception e) {
            e.getStackTrace();
        } return listJob;
    }

    @Override
    public Job insert(Job j) {
        String query = "INSERT INTO HR.JOBS(job_id, job_title, max_salary, min_salary) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getId());
            preparedStatement.setString(2, j.getTitle());
            preparedStatement.setInt(3, j.getMax_salary());
            preparedStatement.setInt(4, j.getMin_salary());
            preparedStatement.executeQuery();
        } catch (Exception e){
            e.printStackTrace();
        } return null;
    }

    @Override
    public Job update(Job j) {
        String query = "UPDATE HR.JOBS SET job_title = ?, max_salary = ?, min_salary = ? WHERE job_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getTitle());
            preparedStatement.setInt(2, j.getMax_salary());
            preparedStatement.setInt(3, j.getMin_salary());
            preparedStatement.setString(4, j.getId());
            preparedStatement.executeQuery();
        } catch (Exception e){
            e.printStackTrace();
        } return null;
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM HR.JOBS WHERE job_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeQuery();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
