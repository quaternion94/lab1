
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
            BankAcount USD = new BankAcount(1000);
            BankAcount UAH = new BankAcount(40); 
            
            controller.people.Create(new Person("Vlad Petrenko"));
            controller.linkPersonToAccount(controller.people.find("name", "Vlad Petrenko").get(0), UAH);
            controller.linkPersonToAccount(controller.people.find("name", "Vlad Petrenko").get(0), USD);            
            
        } catch (SQLException ex) {
            Logger.getLogger(GFLab1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
