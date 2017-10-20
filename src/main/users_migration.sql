USE adlister_db;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL ,
  email VARCHAR(200) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);