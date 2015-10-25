
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arezius
 */

public class ControllerSql{
    private Connection con=null;
    private Statement stmt=null;
    public IRepository<Person> people;
    public IRepository<BankAcount> acounts;
    
    public  ControllerSql(Connection con) throws SQLException {
        people = new PersonRepository(con);
        acounts = new BankRepository(con);
        this.con = con;
    }
    public BankAcount findAccountByUserName(String name)
    {
        for(BankAcount acount : acounts.All()){
            if (acount.UserId == people.find("name", name).get(0).id){
                return acount;
            }
        }
        return null;
    }
    public void linkPersonToAccount(Person p, BankAcount acount)
    {
        acount.UserId = p.id;
        if(!acounts.Update(acount))
            acounts.Create(acount);
    }
}
