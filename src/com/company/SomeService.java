package com.company;

import com.company.dao.DaoException;
import com.company.daologic.ActorDao;
import com.company.daologic.CategoryDao;
import com.company.daologic.EntityTransaction;

import java.util.List;

public class SomeService {
    public void doService(){
        ActorDao actorDao = new ActorDao();
        CategoryDao categoryDao = new CategoryDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.begin(actorDao,categoryDao);

        try {
            List<Actor> actors = actorDao.findAll();
            for (Actor c:actors) {
                System.out.println(c.toString());
            }
            List<Category> categories = categoryDao.findAll();

            for (Category c:categories) {
                System.out.println(c.toString());
            }
            transaction.commit();
        } catch (DaoException e) {
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            transaction.end();
        }
    }
}
