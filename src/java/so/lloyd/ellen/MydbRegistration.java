/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.lloyd.ellen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lloyd
 */
public class MydbRegistration {
    
    Connection con;
    
    public Connection getCon(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root","sonwabo@");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MydbRegistration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MydbRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return con;
    }
    
}
