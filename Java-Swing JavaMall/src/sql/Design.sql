-- -----------------------------------------------------
-- Schema JDBC
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `JDBC` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `JDBC` ;

-- -----------------------------------------------------
-- Table `JDBC`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JDBC`.`Admin` (
  `admin_no` INT NOT NULL AUTO_INCREMENT,
  `admin_id` VARCHAR(30) NOT NULL UNIQUE,
  `admin_pwd` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`admin_no`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `JDBC`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JDBC`.`User` (
  `user_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(30) NOT NULL UNIQUE,
  `user_pwd` VARCHAR(30) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  `gender` VARCHAR(10) NULL DEFAULT NULL,
  `phone` VARCHAR(30) NOT NULL,
  `birth` VARCHAR(30) NULL DEFAULT NULL,
  `Admin_user_no` INT NOT NULL,
  PRIMARY KEY (`user_no`),
  INDEX `fk_User_Admin_idx` (`Admin_user_no` ASC) VISIBLE,
  CONSTRAINT `fk_User_Admin`
    FOREIGN KEY (`Admin_user_no`)
    REFERENCES `JDBC`.`Admin` (`admin_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `JDBC`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JDBC`.`Order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `price` INT NOT NULL,
  `state` VARCHAR(45) NULL,
  `quantity` INT NULL,
  `User_user_no` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_Order_User1_idx` (`User_user_no` ASC) VISIBLE,
  CONSTRAINT `fk_Order_User1`
    FOREIGN KEY (`User_user_no`)
    REFERENCES `JDBC`.`User` (`user_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JDBC`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JDBC`.`Category` (
  `category_no` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_no`)
) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JDBC`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JDBC`.`Product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NOT NULL UNIQUE,
  `product_img` VARCHAR(45) NULL,
  `product_state` VARCHAR(45) NOT NULL,
  `Order_order_id` INT NOT NULL,
  `Category_category_no` INT NOT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `fk_Product_Order1_idx` (`Order_order_id` ASC) VISIBLE,
  INDEX `fk_Product_Category1_idx` (`Category_category_no` ASC) VISIBLE,
  CONSTRAINT `fk_Product_Order1`
    FOREIGN KEY (`Order_order_id`)
    REFERENCES `JDBC`.`Order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_Category1`
    FOREIGN KEY (`Category_category_no`)
    REFERENCES `JDBC`.`Category` (`category_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;
