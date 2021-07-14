package com.company.dao;

import com.company.Actor;

import java.util.List;

public interface ActorDao extends BaseDao <Long, Actor>{
    List<Actor> findActorByLastname(String patternName) throws DaoException;

}
