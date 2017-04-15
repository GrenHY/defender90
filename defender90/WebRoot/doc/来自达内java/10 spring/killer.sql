/*
MySQL Data Transfer
Source Host: localhost
Source Database: killer
Target Host: localhost
Target Database: killer
Date: 2014/12/5 16:42:12
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for killer
-- ----------------------------
DROP TABLE IF EXISTS `killer`;
CREATE TABLE `killer` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `mail` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `nickname` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `reply` int(10) unsigned zerofill NOT NULL default '0000000000',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for remsg
-- ----------------------------
DROP TABLE IF EXISTS `remsg`;
CREATE TABLE `remsg` (
  `id` int(11) NOT NULL auto_increment,
  `msgId` int(11) NOT NULL,
  `reMsg` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `good` int(10) unsigned zerofill NOT NULL default '0000000000',
  PRIMARY KEY  (`id`),
  KEY `msgid` (`msgId`),
  KEY `nick` (`nickname`),
  CONSTRAINT `msgid` FOREIGN KEY (`msgId`) REFERENCES `message` (`id`),
  CONSTRAINT `nick` FOREIGN KEY (`nickname`) REFERENCES `killer` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
