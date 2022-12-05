package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();

		app.launch();
	}

	private void launch() {

		Scanner sc = new Scanner(System.in);

		startUserInterface(sc);

		sc.close();
	}

	private void startUserInterface(Scanner sc) {

		boolean keepMenuOn = true;

		while (keepMenuOn) {
			System.out.println("1. Look up film by id");

			System.out.println("2. Look up film by keyword");

			System.out.println("3. Exit");
			int userInput = sc.nextInt();

			switch (userInput) {

			case 1:
				displaybyId(sc);
				break;

			case 2:

				displayByKeywords(sc);

				break;

			case 3:
				System.out.println("Good Bye!");
				keepMenuOn = false;
				break;

			}

		}

	}

	private void displayByKeywords(Scanner sc) {

		System.out.println("Enter Keywords");

		List<Film> films = db.findFilmsByKeyword(sc.next());
		sc.nextLine();

		if (films.isEmpty()) {
			System.out.println(" Sorry no hits on this search!");
		}

		else {
			for (Film film : films) {
				System.out.println(film.getTitle() + "  Year: " + film.getReleaseYear() + " Rating: " + film.getRating()
						+ " Language: " + film.getLanguage() + "\n" + "Description: " + film.getDescription() + "\n"
						+ "Cast:\t " + db.findActorsByFilmId(film.getId()));
			}
		}

	}

	public void displaybyId(Scanner sc) {
		System.out.println("Enter ID");

		Film film = db.findFilmsById(sc.nextInt());

		sc.nextLine();

		if (film == null) {
			System.out.println(" Sorry no hits on this search!");
		}

		else {

			System.out.println(film.getTitle() + "\tYear: " + film.getReleaseYear() + " Rating: " + film.getRating()
					+ " Language: " + film.getLanguage() + "\n" + "Description: " + film.getDescription() + "\1" + "n"
					+ "Cast: " + db.findActorsByFilmId(film.getId()));
		}
	}
}
