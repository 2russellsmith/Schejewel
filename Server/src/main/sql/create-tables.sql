DROP TABLE user_privileges;
DROP TABLE tour;
DROP TABLE tour_type_resource;
DROP TABLE resource;
DROP TABLE tour_group;
DROP TABLE tour_type;
DROP TABLE portage;
DROP TABLE cruise_ship;
DROP TABLE cruise_line;
DROP TABLE privilege;
DROP TABLE user;
DROP TABLE company;

CREATE TABLE company(
  id INT(11) NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user(
  id INT(11) AUTO_INCREMENT NOT NULL,
  name VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255) NOT NULL,
  company_id INT(11),
  PRIMARY KEY (id),
  FOREIGN KEY (company_id) REFERENCES company(id),
  CONSTRAINT unique_user UNIQUE (email)
);

CREATE TABLE tour_type(
  id INT(11) NOT NULL,
  name VARCHAR(255) NOT NULL,
  owner_id INT(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (owner_id) REFERENCES company(id)
);

CREATE TABLE tour(
  id INT(11) NOT NULL,
  owner_id INT(11) NOT NULL,
  start_time TIMESTAMP,
  end_time TIMESTAMP,
  tour_type_id INT(11),
  PRIMARY KEY (id),
  FOREIGN KEY (tour_type_id) REFERENCES tour_type(id),
  FOREIGN KEY (owner_id) REFERENCES company(id)
);

CREATE TABLE resource(
  id INT(11) NOT NULL,
  name VARCHAR(255) NOT NULL, 
  capacity INT(11),
  owner_id INT(11),
  PRIMARY KEY (id),
  FOREIGN KEY (owner_id) REFERENCES company(id)
);

CREATE TABLE tour_type_resource(
  tour_type_id INT(11) NOT NULL,
  resource_id INT(11) NOT NULL,
  order_number INT(11) NOT NULL,
  duration INT(11) NOT NULL,
  FOREIGN KEY (tour_type_id) REFERENCES tour_type(id),
  FOREIGN KEY (resource_id) REFERENCES resource(id)
);

CREATE TABLE cruise_line(
  id INT(11) NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE cruise_ship(
  id INT(11) NOT NULL,
  cruise_line_id INT(11) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (cruise_line_id) REFERENCES cruise_line(id)
);

CREATE TABLE portage(
  id INT(11) NOT NULL,
  cruise_ship_id INT(11) NOT NULL,
  arrival TIMESTAMP NOT NULL,
  departure TIMESTAMP NOT NULL,
  name VARCHAR(255) NOT NULL,
  passengers INT(11),
  AA TIMESTAMP,
  dock INT(11),
  voyage VARCHAR(255),
  PRIMARY KEY (id),
  FOREIGN KEY (cruise_ship_id) REFERENCES cruise_ship(id)
);

CREATE TABLE tour_group(
  id INT(11) NOT NULL,
  portage_id INT(11) NOT NULL,
  group_size INT(11) NOT NULL,
  settled TINYINT(1),
  PRIMARY KEY(id),
  FOREIGN KEY (portage_id) REFERENCES portage(id)
);

CREATE TABLE privilege(
  id INT(11) NOT NULL,
  description VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_privileges(
  user_id INT(11) NOT NULL,
  privilege_id INT(11) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (privilege_id) REFERENCES privilege(id)
);