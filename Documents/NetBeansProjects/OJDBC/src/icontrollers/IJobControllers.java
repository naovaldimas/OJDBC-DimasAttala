/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author dimas attala
 */
public interface IJobControllers {
    public List <Job> getAll();
    public Job getById(String id);
    public List <Job> search(String key);
    public Job insert (String id, String name, String max_salary, String min_salary);
    public Job update (String id, String name, String max_salary, String min_salary);
    public void delete (String id);
}
