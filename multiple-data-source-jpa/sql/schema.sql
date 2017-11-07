CREATE DATABASE IF NOT EXISTS `market`;
CREATE DATABASE IF NOT EXISTS `order`;
CREATE DATABASE IF NOT EXISTS `user`;

USE `order`;

CREATE TABLE IF NOT EXISTS `order_info` (
  `id`          INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id`    VARCHAR(11)               DEFAULT NULL,
  `price`       DECIMAL(10, 0)            DEFAULT NULL,
  `create_time` TIMESTAMP        NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO `order_info` (`id`, `order_id`, `price`, `create_time`)
VALUES
  (NULL, '123456', 123, '2017-05-03 09:52:25');

USE `user`;

CREATE TABLE IF NOT EXISTS `user_info` (
  `id`       INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30)               DEFAULT NULL,
  `password` VARCHAR(30)               DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO `user_info` (`id`, `username`, `password`)
VALUES
  (NULL, 'test-usename', 'test-password');

USE `market`;

CREATE TABLE IF NOT EXISTS `market_info` (
  `id`             INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `market_name`    VARCHAR(30)               DEFAULT NULL,
  `market_address` VARCHAR(50)               DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO `market_info` (`id`, `market_name`, `market_address`)
VALUES
  (NULL, 'test-market', 'test-address');