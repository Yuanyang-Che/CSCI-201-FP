DROP DATABASE IF EXISTS FP;
CREATE Database FP;

USE FP;

CREATE TABLE user_info ( 
	id_token INT(11) primary key not null auto_increment,
    user_name varchar(45) not null,
	pw varchar(45) not null,
	email varchar(45) not null
);

CREATE TABLE diet_restriction (
	id_token INT(45) not null,
    diet VARCHAR(45),
    exIngred VARCHAR(45),
    intolerence VARCHAR(45),
    Foreign key fk1(id_token) references user_info(id_token)
);

CREATE TABLE last_recipe (
	id_token INT(45) not null,
    last_querey VARCHAR(45),
    Foreign key fk1(id_token) references user_info(id_token)
);

INSERT INTO user_info (user_name, pw, email)
	VALUE ('usr1', '123a', 'test@usc.edu');


INSERT INTO diet_restriction (id_token, diet, exIngred, intolerence)
	VALUE (1, 'diet1', 'dont eat1', 'intolerence1');
;