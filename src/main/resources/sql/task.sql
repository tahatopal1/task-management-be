USE `task_management_app`;

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT,
    `title`         varchar(128) DEFAULT NULL,
    `user_id`       varchar(50) DEFAULT NULL,

    PRIMARY KEY (`id`),
    KEY `FK_TASK_idx` (`user_id`),

    CONSTRAINT `FK_TASK`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)
    ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;