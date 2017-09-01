CREATE SCHEMA `cs532_finalpj` ;
USE cs532_finalpj;

CREATE TABLE `cs532_finalpj`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `productname` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `cs532_finalpj`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`));
  
  INSERT INTO `cs532_finalpj`.`customers` VALUES(1,'guest','guest');
  INSERT INTO `cs532_finalpj`.`products` VALUES(1,'Table', 56.65);
  INSERT INTO `cs532_finalpj`.`products` VALUES(2,'Chair', 30.0);
  INSERT INTO `cs532_finalpj`.`products` VALUES(3,'Lamp', 15.5);