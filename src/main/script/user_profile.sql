CREATE TABLE `test`.`user_profile` (
  `user_id` INT NOT NULL,
  `birthday` TIMESTAMP NULL,
  `country` VARCHAR(20) NULL,
  `nation` VARCHAR(20) NULL,
  `gender` TINYINT(2) NULL,
  `marriage` TINYINT(3) NULL,
  `company_phone` VARCHAR(20) NULL,
  `company_email` VARCHAR(45) NULL,
  `private_email` VARCHAR(45) NULL,
  `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `test`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

drop trigger if exists user_profile_last_updated_trigger;
CREATE TRIGGER `user_profile_last_updated_trigger` BEFORE UPDATE ON `test`.`user_profile`
 FOR EACH ROW SET NEW.`last_updated` = NOW();
 
drop trigger if exists user_profile_last_updated_init_trigger;
CREATE TRIGGER `user_profile_last_updated_init_trigger` BEFORE INSERT ON `test`.`user_profile`
FOR EACH ROW SET NEW.last_updated = NOW();
