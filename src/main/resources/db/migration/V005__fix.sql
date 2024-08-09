ALTER TABLE `prayer`
	CHANGE COLUMN `date` `date` DATE NOT NULL AFTER `description`;

ALTER TABLE `activity`
	ADD COLUMN `goal_id` INT(10) NULL AFTER `user_id`,
	ADD INDEX `goal_id` (`goal_id`),
	ADD CONSTRAINT `FK_activity_goal` FOREIGN KEY (`goal_id`) REFERENCES `goal` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION;
