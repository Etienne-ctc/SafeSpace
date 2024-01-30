DROP TABLE rdv;
DROP TABLE exercice;
DROP TABLE stat;
DROP TABLE acti;
DROP TABLE comm;
DROP TABLE user;
CREATE TABLE user (id INT PRIMARY KEY NOT NULL auto_increment, nom varchar(100), prenom varchar(100), mail VARCHAR(255), mdp varchar(100), typ INT, pro_id INT,FOREIGN KEY (pro_id) REFERENCES user(id));
CREATE TABLE comm (id INT PRIMARY KEY NOT NULL auto_increment, user_id INT, comm varchar(255), FOREIGN KEY (user_id) REFERENCES user(id));
CREATE TABLE acti (id INT PRIMARY KEY NOT NULL auto_increment, user_id INT, nom varchar(100), etat boolean, FOREIGN KEY (user_id) REFERENCES user(id));
CREATE TABLE stat (id INT PRIMARY KEY NOT NULL auto_increment, user_id INT, typ varchar(100), valeur INT,date datetime, FOREIGN KEY (user_id) REFERENCES user(id));
CREATE TABLE exercice (id INT PRIMARY KEY NOT NULL auto_increment, patient_id INT, pro_id INT,nom varchar(100),etat boolean, FOREIGN KEY (patient_id) REFERENCES user(id), FOREIGN KEY (pro_id) REFERENCES user(id));
CREATE TABLE rdv (id INT PRIMARY KEY NOT NULL auto_increment, pro_id INT, patient_id INT, daterdv datetime, FOREIGN KEY (pro_id) REFERENCES user(id), FOREIGN KEY (patient_id) REFERENCES user(id));


