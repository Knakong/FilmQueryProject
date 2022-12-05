# FilmQueryProject




# Description

This project was created during week 7 of Skill Distillery Full Stack Software Developments with Java.

During this week of SD36 we were taught functions of MySql using a mock database we installed on our Localhost using MAMP.
We learned to use keywords to get Result Sets using the keywords SELECT, FROM, WHERE, and LIKE in conjunction with the operators ON, OR, and AND.

The weekend project the goal was to create a program that accessed a MySql database through a CommandLine applications that mocks that of a Video Store Rental company.

The user could enter an ID or keywords to search a film database. Matches would show the title, description, year, rating, language, and the cast of the film.
If the query return no results, it prints "sorry no hits on this search".

This project consist of an entities, a database, and an app package.

The entities package contain purely Java Classes that represent Films and Actors with no access to the the database. Using constructors and setters and getters methods, from the classes that access the database creates a separation of concern.

The database package consist of an interface and class that accesses the database.

The app package has one class that has a menu prompting the user to search by film ID, keywords, or exit.
It consist of 2 methods that call methods using an instance of the DataBaseAccessorObject class to retrieve from our MySql Result Set, storing the information in the appropriate fields and allowing use the information how we want, using formatting a sysout for my project requirements.

This project used Maven and a Project Object Model file (POM.xml) to set up dependencies.



# Technologies
Java, MySql, MAMP, MAVEN, Eclipse IDE, Atom.io


# Lessons Learned

Setting up a project like this isn't dependent on things outside of your IDE, since we now working things outside of Java, we need to make sure that MAMP is running the mySQL server(s) and we also need to make sure that the Result Sets we retrieve from our queries return the correct information. Also before going into the Java, to make sure that mySQL inputs have written and tested. Using column labels with ResultSet.executeQuery() method keep the name identical to represent the tables and fields of the database help to keep things clear.  
