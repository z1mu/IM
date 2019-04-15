/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : zimu-M

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 15/04/2019 20:07:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zimu_admin
-- ----------------------------
DROP TABLE IF EXISTS `zimu_admin`;
CREATE TABLE `zimu_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zimu_level
-- ----------------------------
DROP TABLE IF EXISTS `zimu_level`;
CREATE TABLE `zimu_level` (
  `level_id` int(11) NOT NULL COMMENT '等级ID',
  `level_access_token` varchar(255) NOT NULL COMMENT '等级接入token',
  PRIMARY KEY (`level_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zimu_link
-- ----------------------------
DROP TABLE IF EXISTS `zimu_link`;
CREATE TABLE `zimu_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) NOT NULL COMMENT '链接',
  `link_name` varchar(255) NOT NULL COMMENT '链接名称',
  `level_id` int(11) NOT NULL DEFAULT '0' COMMENT '等级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zimu_setting
-- ----------------------------
DROP TABLE IF EXISTS `zimu_setting`;
CREATE TABLE `zimu_setting` (
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `keywords` varchar(255) DEFAULT NULL COMMENT '关键字',
  `domain` varchar(255) DEFAULT NULL COMMENT '域名',
  `sign` varchar(255) DEFAULT NULL COMMENT '签名',
  `head` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `footer_name` varchar(255) DEFAULT NULL COMMENT 'footer名称',
  `footer_link` varchar(255) DEFAULT NULL COMMENT 'footer链接',
  `footer_link_name` varchar(255) DEFAULT NULL COMMENT 'footer链接名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
