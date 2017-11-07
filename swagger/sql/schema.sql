CREATE DATABASE IF NOT EXISTS open_source;

USE `open_source`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL DEFAULT '',
  `age` int(4) NOT NULL,
  `address` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`id`, `user_id`, `name`, `age`, `address`, `password`)
VALUES
	(1, 1, 'bob', 10, 'Shanghai. China', 'whatever'),
	(2, 2, 'lily', 15, 'Beijing. China', 'whatever');
