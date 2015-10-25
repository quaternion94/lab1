
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arezius
 */

interface IRepository<T> {
    T Create(T entity);
    T GetByID(int id);
    List<T> All();
    boolean Update(T entity);
    List<T> find(String key, String value);
    boolean Delete(int id);
}
