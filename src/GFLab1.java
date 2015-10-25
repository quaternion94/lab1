
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arezius
 */

public class GFLab1 {

    /**
     * @param args the command line arguments
     */
    private static ControllerSql controller=null;
    public static void main(String[] args) {
        
        DbConnection con = new DbConnection("org.sqlite.JDBC", "jdbc:sqlite:Lab1.sqlite");
        try {
            controller = new ControllerSql(con.getCon());
            
            controller.people.Create(new Person("Vlad Petrenko")); 
            
            BankAcount USD = controller.acounts.Create(new BankAcount(1, controller.people.find("NAME", "\"Vlad Petrenko\"").get(0).id, 1000));
            BankAcount UAH = controller.acounts.Create(new BankAcount(2, controller.people.find("NAME", "\"Vlad Petrenko\"").get(0).id, 40)); 

        } catch (SQLException ex) {
            Logger.getLogger(GFLab1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
