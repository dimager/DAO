package com.company;

import com.company.dao.DaoException;
import com.company.dao.impl.ActorDaoImpl;

public class Main {

    public static void main(String[] args) throws DaoException {
	// write your code here
        ActorDaoImpl a = new ActorDaoImpl();

        Actor [] actors = a.findActorByLastname("Mager").toArray(new Actor[0]);

        for (Actor c:actors) {
            System.out.println(c.toString());
        }

        SomeService someService = new SomeService();
        someService.doService();
    }


}
