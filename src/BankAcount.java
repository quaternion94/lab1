/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arezius
 */
 
public class BankAcount {
    public int id;
    public int UserId;
    public float amount;
    
    @Override
    public String toString()
    {
        return ""+amount;
    }
    public BankAcount(int id, int userId, float amount) {
        this.UserId = userId;
        this.amount = amount;
    }
    public BankAcount(int userId, float amount) {
        this.UserId = userId;
        this.amount = amount;
    }
    public BankAcount( float amount) {
        this.amount = amount;
    }    
}
