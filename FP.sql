DROP DATABASE IF EXISTS FP;
CREATE Database FP;

USE FP;

CREATE TABLE user_info ( 
	-- id_token INT(11) NOT NULL UNIQUE AUTO_INCREMENT,
	email VARCHAR(45) PRIMARY KEY NOT NULL UNIQUE,
    user_name VARCHAR(45) NOT NULL,
	pw VARCHAR(45) NOT NULL
);

CREATE TABLE diet_restriction (
	-- id_token INT(45) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE,
    diet VARCHAR(100),
    exIngred VARCHAR(100),
    intolerance VARCHAR(100),
    -- Foreign key fk1(id_token) references user_info(id_token),
    FOREIGN KEY fk2(email) REFERENCES user_info(email)
);

CREATE TABLE last_recipe (
	-- id_token INT(45) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE,
    last_query VARCHAR(45),
    -- Foreign key fk1(id_token) references user_info(id_token),
    FOREIGN KEY fk2(email) REFERENCES user_info(email)
);

INSERT INTO user_info (email, user_name, pw)
	VALUE ('test@usc.edu', 'usr1', '123a');


INSERT INTO diet_restriction (email, diet, exIngred, intolerance)
	VALUE ('test@usc.edu', 'diet1', 'dont eat1', 'intolerance1');


-- INSERT INTO last_recipe (email, last_query)