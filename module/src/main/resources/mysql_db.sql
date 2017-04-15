DROP SCHEMA IF EXISTS `audioweb`;

CREATE SCHEMA IF NOT EXISTS `audioweb`
  CHARACTER SET `utf8`;

USE `audioweb`;

CREATE TABLE `users` (
  `id`	INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL
);

CREATE TABLE `playlist` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `playlist_name` TEXT NOT NULL,
  `user_id` INTEGER NOT NULL,

  CONSTRAINT `fk_playlist_to_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE `track` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `track_name` TEXT    NOT NULL,
  `track_author` TEXT    NOT NULL,
  `playlist_id` INTEGER NOT NULL,

  CONSTRAINT `fk_track_to_playlist` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);

CREATE TABLE `group` (
  `id`	INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `group_name`	VARCHAR(255) NOT NULL
);

CREATE TABLE `group_to_users` (
  `fk_group_id` INTEGER NOT NULL,
  `fk_user_id` INTEGER NOT NULL,

  PRIMARY KEY (`fk_group_id`, `fk_user_id`),

  CONSTRAINT `fk_to_group` FOREIGN KEY (`fk_group_id`) REFERENCES `group` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT `fk_to_user` FOREIGN KEY (fk_user_id) REFERENCES `users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

INSERT INTO `users` (`name`, `email`,`password`) VALUES ('Иван', 'examples@gmail.com','password');
INSERT INTO `users` (`name`, `email`,`password`) VALUES ('Петя', 'examples@gmail.com','password');
INSERT INTO `users` (`name`, `email`,`password`) VALUES ('Вова', 'examples@gmail.com','password');

INSERT INTO `playlist` (`playlist_name`,`user_id`) VALUES ('Класика', 1 );
INSERT INTO `playlist` (`playlist_name`,`user_id`) VALUES ('Рэп', 2 );
INSERT INTO `playlist` (`playlist_name`,`user_id`) VALUES ('Рок', 3 );

INSERT INTO `track` (`track_name`, `track_author`, `playlist_id`) VALUES ('Имя трэка', 'Автор трэка',1);
INSERT INTO `track` (`track_name`, `track_author`, `playlist_id`) VALUES ('Имя трэка', 'Автор трэка',2);
INSERT INTO `track` (`track_name`, `track_author`, `playlist_id`) VALUES ('Имя трэка', 'Автор трэка',3);

INSERT INTO `group` ( `group_name`) VALUES ('Крутая');
INSERT INTO `group` ( `group_name`) VALUES ('Смелая');
INSERT INTO `group` ( `group_name`) VALUES ('Веселая');

INSERT INTO `group_to_users` ( `fk_group_id`, `fk_user_id`) VALUES (1,1);
INSERT INTO `group_to_users` ( `fk_group_id`, `fk_user_id`) VALUES (2,2);
INSERT INTO `group_to_users` ( `fk_group_id`, `fk_user_id`) VALUES (3,3);