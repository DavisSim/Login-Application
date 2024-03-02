# Login-Application
For the login application I used reactJS for my frontend to create a very simple interface for the login page as well as the homepage upon login to show the relevant details
I sadly could not support a second language for this application

//===============================================

For this application to work we have to run both the backend and frontend

To run the front end we first navigate to the login-app folder
Assuming you are at the login-application folder directory , use the following command: cd  login-app
Then, install all dependencies using npm by running this:
npm install
followed by:
npm start

This will open a browser to show the webpage locally

We also need to run the backend  server. To do that, navigate back to the login-application folder with cd ..
after that navigate to the target folder using:
cd backend/loginapp/target
then execute the jar file with 

java -jar loginapp-1.0-SNAPSHOT.jar

For the database that stores all the data I used mySQL and set up a very simplate database with a table which contains (id, username, password, name, role)
I populated it with two users: admin and user for my login to authenthicate
To test the application you need to have a database running with the same columns and just replace the DB_URL, DB_USER and DB_PASSWORD 

    private static final String DB_URL = "jdbc:mysql://localhost:3306/accounts";
    private static final String DB_USER = "developer";
    private static final String DB_PASSWORD = "Sql123456";

with your own credentials so that the backend can access the database and check for the relevant account on login
