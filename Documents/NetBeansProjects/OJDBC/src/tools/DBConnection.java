/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author dimas attala
 */
public class DBConnection {
    private Connection connection;
    public Connection getConnection(){
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setDriverType("thin");
            ods.setServerName("localhost");
            ods.setPortNumber(1521);
            ods.setUser("system");
            ods.setServiceName("XE");
            ods.setPassword("MCCMetrodata");
            this.connection = ods.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        } 
        return connection;
    }
}
