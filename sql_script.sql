CREATE SCHEMA `fantasy_lineups` ;

use fantasy_lineups;

CREATE TABLE `fantasy_lineups`.`users` (
  `id` VARCHAR(36) NOT NULL,
  `username` VARCHAR(128) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));

CREATE TABLE `fantasy_lineups`.`salesman` (
  `id` VARCHAR(36) NOT NULL,
  `user_id` VARCHAR(36) NOT NULL,
  `active` TINYINT(1) NOT NULL DEFAULT 0,
  `display_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_salesman_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_salesman_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `fantasy_lineups`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `fantasy_lineups`.`subscription` (
  `id` VARCHAR(36) NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `salesman_id` VARCHAR(45) NOT NULL,
  `active` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_subscription_user_idx` (`user_id` ASC),
  INDEX `fk_subscription_salesman_idx` (`salesman_id` ASC),
  CONSTRAINT `fk_subscription_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `fantasy_lineups`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_subscription_salesman`
    FOREIGN KEY (`salesman_id`)
    REFERENCES `fantasy_lineups`.`salesman` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO users (id, username, password, enabled) VALUES 
	('1', 'peter@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true),
	('2', 'john@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true),
	('3', 'katie@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true);