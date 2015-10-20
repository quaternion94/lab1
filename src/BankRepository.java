
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author quate_000
 */

public class BankRepository implements IRepository<BankAcount> {
    private Connection con=null;
    private Statement stmt=null;
    
    public BankRepository( Connection con) throws SQLException
    {
        this.con = con;
        this.stmt=con.createStatement();
    }

    @Override
    public boolean Create(BankAcount person) {
        String query="INSERT INTO \"Accounts\" (\"userid\", \"amount\") "
                + "VALUES (\""+ person.UserId+"\" , \""+person.amount+"\") ";

        try {
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return false;
        }
    }

    @Override
    public BankAcount GetByID(int id) {
        boolean first = true;
        String query="SELECT * FROM \"Accounts\" where id="+id;
        
        try {
            ResultSet q =this.stmt.executeQuery(query);
            List<BankAcount> toes = new LinkedList(); 
            String rezString = new String();
            while(q.next())
            {
                BankAcount tmp =new BankAcount(q.getInt(1),q.getInt(1), q.getFloat(3));
                toes.add(tmp);
                rezString+=tmp.toString();
            }
            System.out.println(rezString);
            return toes.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }

    @Override
    public List<BankAcount> All() {
        String query="SELECT * FROM \"Accounts\"";
        try {
            ResultSet q =this.stmt.executeQuery(query);
            List<BankAcount> accounts = new LinkedList(); 
            String rezString = new String();
            while(q.next())
            {
                BankAcount tmp =new BankAcount(q.getInt(1),q.getInt(1), q.getFloat(3));
                accounts.add(tmp);
                rezString+=tmp.toString();
            }
            System.out.println(rezString);
            return accounts;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }

    @Override
    public boolean Update(BankAcount account) {
        try {
            account = GetByID(account.id);
            String query = "UPDATE \"Accounts\" "
                    + "SET "
                    + "   \"amount\" = \""+ account.amount+"\", "
                    + "   \"userid\" = \""+ account.UserId+"\""
                    + "WHERE  \"id\"= "+account.id ;
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean Delete(int id) {
        String query="DELETE FROM \"Accounts\" where id = \""+id+"\"";
        try {
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return false;
        }
    }
    @Override
    public List<BankAcount> find(String key, String value)
    {
        String query="SELECT * FROM \"Accounts\" WHERE "+key+"\"="+value+"\"";
        try {
            ResultSet q =this.stmt.executeQuery(query);
            List<BankAcount> acc = new LinkedList(); 
            String rezString = new String();
            while(q.next())
            {
                BankAcount tmp =new BankAcount(q.getInt(1),q.getInt(1), q.getFloat(3));
                acc.add(tmp);
                rezString+=tmp.toString();
            }
            System.out.println(rezString);
            return acc;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }
    
}
