use `niftymealsdb`;

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
`id` BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`user_email` VARCHAR(45) DEFAULT NULL,
`amount` DECIMAL (10,2) DEFAULT NULL,
`fk_checkout_id` BIGINT(20) DEFAULT NULL,
foreign key (fk_checkout_id) references checkout(id)
	on delete CASCADE
);

select * from `payment`;