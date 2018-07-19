CREATE TABLE `test`.`company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(45) NOT NULL,
  `registered_address` VARCHAR(100) NULL,
  `operation_address` VARCHAR(100) NULL,
  `phone` VARCHAR(20) NULL,
  `credit_num` VARCHAR(18) NULL,
  `register_num` VARCHAR(15) NULL,
  `email` VARCHAR(45) NULL,
  `status` TINYINT(3) NOT NULL DEFAULT 0,
  `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`));


drop trigger if exists company_last_updated_trigger;
CREATE TRIGGER `company_last_updated_trigger` BEFORE UPDATE ON `test`.`company`
 FOR EACH ROW SET NEW.`last_updated` = NOW();
 
drop trigger if exists company_last_updated_init_trigger;
CREATE TRIGGER `company_last_updated_init_trigger` BEFORE INSERT ON `test`.`company`
FOR EACH ROW SET NEW.last_updated = NOW();