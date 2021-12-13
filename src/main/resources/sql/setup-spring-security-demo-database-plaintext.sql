DROP
DATABASE  IF EXISTS `task_management_app`;

CREATE
DATABASE  IF NOT EXISTS `task_management_app`;
USE `task_management_app`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `username`   varchar(50) NOT NULL,
    `password`   char(80)    NOT NULL,
    `first_name` varchar(50) NOT NULL,
    `last_name`  varchar(50) NOT NULL,
    `email`      varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `user` (username, password, first_name, last_name, email)
VALUES ('john', 'test123', 'John', 'Doe', 'john@luv2code.com'),
       ('mary', 'test123', 'Mary', 'Public', 'mary@luv2code.com'),
       ('susan', 'test123', 'Susan', 'Adams', 'susan@luv2code.com');


DROP TABLE IF EXISTS `role`;

CREATE TABLE `role`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `role` (name)
VALUES ('ROLE_EMPLOYEE'),
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN');

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles`
(
    `user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,

    PRIMARY KEY (`user_id`, `role_id`),

    KEY       `FK_ROLE_idx` (`role_id`),

    CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`)
        REFERENCES `role` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET
FOREIGN_KEY_CHECKS = 1;

INSERT INTO `users_roles` (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 1),
       (3, 3)