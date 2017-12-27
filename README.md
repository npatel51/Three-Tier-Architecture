# Three-Tier Architecture
A simple three-layer Java application using SQLite database management system. 

# Description

The project is written in Java using JavaFX framework for GUI and SQLite for data management. It consists three-layers: Presentation( the user interface manages the user interaction ), business ( control management for the entire application ), and the data layer ( access/store data). The Database layer (third tier) could use any database management system as long as the business ( or logic layer )  layer can query and manipulate them.

# Features
 - [x] Add file (person's info) to database
 - [x] Search file in the database
 - [x] View the SQLite file in table format
 - [x] Delete specific entry in the database
 - [x] Validates form entries
 - [x] Datepicker
 - [x] Scrollable country list 
 - [ ] Create a new database file
 - [ ] Display search in a table format
 - [ ] Implement (edit,copy,etc) to allow modification

# Usage

Import the project into eclipse and install JavaFX, or just download and run the ![executable](https://github.com/npatel51/Three-Tier-Architecture/raw/master/Executable/Application.jar) file included in the executable folder. The `Database` file will be created in the working directory and all application data will be stored in this file. The `username` is 'user' and `password` is 'pass' for simplicity.


# Demo
Primary Scene (Login):

![](https://github.com/npatel51/Three-Tier-Architecture/raw/master/Images/Primary_stage.JPG)

Main Scene (Add new info, search, delete, view database, etc):

![](https://github.com/npatel51/Three-Tier-Architecture/raw/master/Images/main_scene.JPG)

Database:

![](https://github.com/npatel51/Three-Tier-Architecture/raw/master/Images/database.JPG)

![](https://github.com/npatel51/Three-Tier-Architecture/blob/master/Images/database_with_entry.JPG)



