use `niftymealsdb`;

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
`id` BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`user_email` VARCHAR(45) DEFAULT NULL,
`amount` DECIMAL (10,2) DEFAULT NULL,
`checkout_id` BIGINT(20) DEFAULT NULL
);

select * from `payment`;
