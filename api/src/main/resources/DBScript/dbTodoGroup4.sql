-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema todogroup4
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `todogroup4` ;

-- -----------------------------------------------------
-- Schema todogroup4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `todogroup4` DEFAULT CHARACTER SET utf8mb4;
USE `todogroup4` ;

-- -----------------------------------------------------
-- Table `todogroup4`.`user`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `todogroup4`.`user` (
  `user_ID` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(50) NOT NULL,
  `user_password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;

CREATE UNIQUE INDEX `user_ID_UNIQUE` ON `todogroup4`.`user` (`user_ID` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `todogroup4`.`project`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `todogroup4`.`project` (
  `project_id` INT NOT NULL AUTO_INCREMENT,
  `project_name` CHAR(50) NOT NULL,
  `user_ID` INT NOT NULL,
  PRIMARY KEY (`project_id`),
  CONSTRAINT `project_ibfk_1`
    FOREIGN KEY (`user_ID`)
    REFERENCES `todogroup4`.`user` (`user_ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;

CREATE UNIQUE INDEX `project_id_UNIQUE` ON `todogroup4`.`project` (`project_id` ASC) VISIBLE;

CREATE INDEX `user_ID` ON `todogroup4`.`project` (`user_ID` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `todogroup4`.`column_todo`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `todogroup4`.`column_todo` (
  `column_id` VARCHAR(50) NOT NULL,
  `column_name` VARCHAR(50) NOT NULL,
  `project_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`column_id`),
  CONSTRAINT `project_id_fg`
    FOREIGN KEY (`project_id`)
    REFERENCES `todogroup4`.`project` (`project_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE UNIQUE INDEX `column_id_UNIQUE` ON `todogroup4`.`column_todo` (`column_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `project_id_fg_idx` ON `todogroup4`.`column_todo` (`project_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `todogroup4`.`task`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `todogroup4`.`task` (
  `task_id` VARCHAR(50) NOT NULL,
  `task_name` VARCHAR(50) NOT NULL,
  `column_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`task_id`),
  CONSTRAINT `column_id_fg`
    FOREIGN KEY (`column_id`)
    REFERENCES `todogroup4`.`column_todo` (`column_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE UNIQUE INDEX `idtask_UNIQUE` ON `todogroup4`.`task` (`task_id` ASC) VISIBLE;

CREATE INDEX `column_id_idx` ON `todogroup4`.`task` (`column_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
