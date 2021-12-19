SET
FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `entry`;

CREATE TABLE `entry`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `comment` blob DEFAULT NULL,
    `task_id` int(11) DEFAULT NULL,

    PRIMARY KEY (`id`),

    KEY       `FK_TASK_ID_idx` (`task_id`),

    CONSTRAINT `FK_TASK_01`
        FOREIGN KEY (`task_id`)
            REFERENCES `task` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET
FOREIGN_KEY_CHECKS = 1;
