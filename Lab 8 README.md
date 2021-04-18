CREATE DATABASE gces;
SHOW DATABASES;
USE gces;
CREATE TABLE student (
    Id INT NOT NULL ,
    Name VARCHAR(30) NOT NULL,
    Address VARCHAR(50) NOT NULL,
    Phone_Number BIGINT NOT NULL,
    Bio VARCHAR(200)
);




CREATE TABLE users (
    Id INT NOT NULL ,
    Username VARCHAR(15) NOT NULL UNIQUE,
    Password VARCHAR(100) NOT NULL ,
    Email VARCHAR(40) NOT NULL UNIQUE
 );


 CREATE TABLE addresses (
    Id INT NOT NULL , 
    User_Id INT NOT NULL ,
    Country VARCHAR(15) NOT NULL,
    State VARCHAR(15),
    District VARCHAR(20) NOT NULL,
    Address1 VARCHAR(50),
    Address2 VARCHAR(50)
 );


 SHOW TABLES;
 DESCRIBE addresses;
 DESCRIBE users;
 DESCRIBE student;


ALTER TABLE student
RENAME TO students;


 INSERT INTO students ( Id, Name, Address, Phone_Number, Bio )
 VALUES ( 1, 'ABC', 'XYZ', 123, 'PQR' );

 INSERT INTO students ( Id, Name, Address, Phone_Number, Bio )
 VALUES ( 2, 'ABC', 'XYZ', 123, 'PQR' );

 INSERT INTO students ( Id, Name, Address, Phone_Number, Bio )
 VALUES ( 3, 'ABC', 'XYZ', 123, 'PQR' );

 INSERT INTO students ( Id, Name, Address, Phone_Number, Bio )
 VALUES ( 4,  'ABC', 'XYZ', 123, 'PQR' );

 INSERT INTO students ( Id, Name, Address, Phone_Number, Bio )
 VALUES ( 5,  'ABC', 'XYZ', 123, 'PQR' );


 INSERT INTO users ( Id, Username, Password, Email )
 VALUES ( 1, 'ABC', 'XYZ', 'PQR' );

 INSERT INTO users ( Id, Username, Password, Email )
 VALUES ( 2, 'ABC', 'XYZ', 'PQR' );

 INSERT INTO users ( Id, Username, Password, Email )
 VALUES ( 3, 'ABC', 'XYZ', 'PQR' );

 INSERT INTO users ( Id, Username, Password, Email )
 VALUES ( 4,  'ABC', 'XYZ', 'PQR' );

 INSERT INTO users ( Id, Username, Password, Email )
 VALUES ( 5,  'ABC', 'XYZ', 'PQR' );


 INSERT INTO addresses ( Id, User_Id, Country, State, District, Address1, Address2 )
 VALUES ( 1, 1, 'Nepal', '4', 'Kaski', 'Bagar', 'Lamachaur' );

 INSERT INTO addresses ( Id, User_Id, Country, State, District, Address1, Address2 )
 VALUES ( 2, 2, 'Nepal', '4', 'Kaski', 'Nadipur', 'Mahendrapool' );

 INSERT INTO addresses ( Id, User_Id, Country, State, District, Address1, Address2 )
 VALUES ( 3, 3, 'Nepal', '4', 'Kaski', 'Bhaktipath', 'Lamachaur' );

 INSERT INTO addresses ( Id, User_Id, Country, State, District, Address1, Address2 )
 VALUES ( 4, 4, 'Nepal', '4', 'Kaski', 'Puranchaur', 'Malepatan' );

 INSERT INTO addresses ( Id, User_Id, Country, State, District, Address1, Address2 )
 VALUES ( 5, 5, 'Nepal', '4', 'Kaski', 'Harpak', 'Gairikhor' );



 SELECT Name FROM students WHERE Name LIKE 'A%';


 UPDATE students 
 SET Address = 'Lamachaur'
 WHERE ID = 1;


 DELETE FROM students WHERE Id = 1 ;

 DELETE FROM students WHERE Id = 2 ;
