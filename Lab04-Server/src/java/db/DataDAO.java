/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Diana-Stefania
 */
public class DataDAO {
    
    public void insertData(DataModel dataModel) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("Lab04").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(dataModel);
        entityManager.getTransaction().commit();
    }
}
