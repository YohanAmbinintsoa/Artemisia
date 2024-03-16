package itu.hiu.Artemisia.Security;

import itu.hiu.Artemisia.DAO.DAO;
import itu.hiu.Artemisia.Models.User;

public class MyContext {
    private static final ThreadLocal<User> user=new ThreadLocal<>();
    private static final DAO requester=new DAO("postgres", "root", "localhost","artemisia", "postgresql");
    
    public static User getUser(){
        return user.get();
    }

    public static DAO getRequester(){
        return requester;
    }

    public static void setUser(User person){
        user.set(person);
    }
}
