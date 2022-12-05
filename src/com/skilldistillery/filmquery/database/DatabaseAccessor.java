package com.skilldistillery.filmquery.database;


import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;



public interface DatabaseAccessor {

	String user = "student";
	String pw = "student";

  public Actor findActorById(int actorId);

  public List<Actor> findActorsByFilmId(int filmId);

  public List<Film>	findFilmsByKeyword(String keywords);

public Film findFilmsById (int id);
  
 

  




}
