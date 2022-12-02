package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	@Override
	public Film findFilmById(int id) {
		Film film= null;
		
		try {
		Connection conn = DriverManager.getConnection(URL, user, pw);
		String sql = "select * from film where id= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		System.out.println(stmt);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int filmId = rs.getInt("id");
			String title = rs.getString("title");
			String desc = rs.getString("description");
			short releaseYear = rs.getShort("release_year");
			int langId = rs.getInt("language_id");
			int rentDur = rs.getInt("rental_duration");
			double rate = rs.getDouble("rental_rate");
			int length = rs.getInt("length");
			double repCost = rs.getDouble("replacement_cost");
			String rating = rs.getString("rating");
			String features = rs.getString("special_features");
			film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
					features);
			
			
		}}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
			

		
		
		
		
		return film;
	}

	@Override
	public Actor findActorById(int actorId){
		Actor actor = null;
		try{ 
			Connection conn = DriverManager.getConnection(URL, user, pw);
		
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);

		System.out.println(stmt);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(rs.getInt("id"));
			actor.setFirstName(rs.getString("first_name"));
			actor.setLastName(rs.getString("last_name"));
			actor.setFilms(findFilmsByActorId(actorId));
		}
		if(actor== null) {
			System.out.println("No actor found with this id");
		}
		
		rs.close();
		stmt.close();
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return actor;
	}

	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		films = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pw);
			String sql = "select * FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> findActorsByFilmId(ResultSet rs) {
		List<Actor> actorsInFilmId = null;
		// TODO Auto-generated method stub
		return actorsInFilmId;
	}

	


	
}
