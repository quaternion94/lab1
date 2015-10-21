
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
public class PersonRepository implements IRepository<Person> {
    private Connection con=null;
    private Statement stmt=null;
    public PersonRepository(Connection con) throws SQLException {
        this.con = con;
        this.stmt=con.createStatement();
    } 

    @Override
    public boolean Create(Person person) {
        String query="INSERT INTO \"People\" (id,\"name\") "
                + "VALUES (null,\""+ person.name+"\") ";
        try {
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return false;
        }
    }

    @Override
    public Person GetByID(int id) {
        boolean first = true;
        String query="SELECT * FROM \"People\" where id="+id;
        
        try {
            ResultSet q =this.stmt.executeQuery(query);
            List<Person> toes = new LinkedList(); 
            String rezString = new String();
            while(q.next())
            {
                Person tmp =new Person(q.getInt(1),q.getString(2));
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
    public List<Person> All() {
        String query="SELECT * FROM \"People\"";
        try {
            ResultSet q =this.stmt.executeQuery(query);
            List<Person> people = new LinkedList(); 
            String rezString = new String();
            while(q.next())
            {
                Person tmp =new Person(q.getInt(1),q.getString(2));
                people.add(tmp);
                rezString+=tmp.toString();
            }
            System.out.println(rezString);
            return people;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }

    @Override
    public boolean Update(Person person) {
        try {
            person = GetByID(person.id);
            String query = "UPDATE \"People\" "
                    + "SET "
                    + "   \"name\" = \""+ person.name+"\""
                    + "WHERE  \"id\"= "+person.id ;
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean Delete(int id) {
        String query="DELETE FROM \"People\" where id = \""+id+"\"";
        try {
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return false;
        }
    }
    @Override
    public List<Person> find(String key, String value)
    {
        String query="SELECT * FROM \"People\" WHERE "+key+"=\""+value+"\"";
        try {
            ResultSet q =this.stmt.executeQuery(query);
            List<Person> people = new LinkedList(); 
            String rezString = new String();
            while(q.next())
            {
                Person tmp =new Person(q.getInt(1),q.getString(2));
                people.add(tmp);
                rezString+=tmp.toString();
            }
            System.out.println(rezString);
            return people;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }
}
