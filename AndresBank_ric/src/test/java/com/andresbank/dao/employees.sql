CREATE SCHEMA `employees` ;

USE mysql;

CREATE USER 'employee_user'@'localhost' IDENTIFIED BY 'eu123';
GRANT ALL PRIVILEGES ON employees.* TO 'employee_user'@'localhost';
FLUSH PRIVILEGES;

USE employees;

CREATE TABLE `employees`.`employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));