/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arezius
 */

public class Person {
    public int id;
    public String name;
    
    @Override
    public String toString()
    {
        return id+" " +name;
    }
    public Person( String name) {
        this.name = name;
    }
    public Person( int id, String name) {
        this.id = id;
        this.name = name;
    }    
}