package org.example.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Util1 {
    public static EntityManager createEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test3");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
