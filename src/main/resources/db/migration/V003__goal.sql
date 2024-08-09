CREATE TABLE `goal` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`user_id` INT(10) NOT NULL,
	`description` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`quantity` INT(10) NOT NULL,
	`start` DATE NOT NULL,
	`end` DATE NOT NULL,
	`status` TINYINT(1) NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `user_id` (`user_id`) USING BTREE,
	CONSTRAINT `FK__user_goal` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
