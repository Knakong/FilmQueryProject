package com.skilldistillery.filmquery.database;

import java.sql.*;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;



public interface DatabaseAccessor {

String user="student";
String pw="student";
	
  public Film findFilmById(int filmId);

  public Actor findActorById(int actorId);

  public List<Actor> findActorsByFilmId(ResultSet result);
  
 

  
  //public List<Actor> findActorsByFilmId(int filmId);



}
