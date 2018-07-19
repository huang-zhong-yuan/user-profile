CREATE TABLE `test`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_id` INT NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NULL,
  `first_name` VARCHAR(20) NULL,
  `english_name` VARCHAR(20) NULL,
  `mobile` VARCHAR(12) NULL,
  `id_num` VARCHAR(18) NULL,
  `status` TINYINT(3) NOT NULL,
  `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
   CONSTRAINT `user_company_id`
    FOREIGN KEY (`company_id`)
    REFERENCES `test`.`company` (`id`),
  UNIQUE INDEX `user_name_UNIQUE` (`company_id`, `user_name` ASC));


drop trigger if exists user_last_updated_trigger;
CREATE TRIGGER `user_last_updated_trigger` BEFORE UPDATE ON `test`.`user`
 FOR EACH ROW SET NEW.`last_updated` = NOW();
 
drop trigger if exists user_last_updated_init_trigger;
CREATE TRIGGER `user_last_updated_init_trigger` BEFORE INSERT ON `test`.`user`
FOR EACH ROW SET NEW.last_updated = NOW();
