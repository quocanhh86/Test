package com.example.DemoCRUD.repository;

import com.example.DemoCRUD.model.Users;
import com.example.DemoCRUD.utils.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class UsersRepository {
    Session s;
    public UsersRepository(){
        s = HibernateConfig.getFACTORY().openSession();
    }

    public List<Users> getAll(){
        return s.createQuery("From Users").list();
    }

    public Users getOne(String id){
        return s.find(Users.class, id);
    }
    public void add(Users u){
        try {
            s.getTransaction().begin();
            s.save(u);
            s.getTransaction().commit(); // hoàn thành phiên làm việc
        }catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public void update(Users u){
        try {
            s.getTransaction().begin();
            s.merge(u);
            s.getTransaction().commit(); // hoàn thành phiên làm việc
        }catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public void delete(Users u){
        try {
            s.getTransaction().begin();
            s.delete(u);
            s.getTransaction().commit(); // hoàn thành phiên làm việc
        }catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
}
