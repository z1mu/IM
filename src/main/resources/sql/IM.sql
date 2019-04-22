/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : IM

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 22/04/2019 22:26:24
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zimu_admin
-- ----------------------------
BEGIN;
INSERT INTO `zimu_admin` VALUES (1, 'zimu', 'a86089bdfdffebc72a7b404025fd0bfe', 'fasjkg');
COMMIT;

-- ----------------------------
-- Table structure for zimu_level
-- ----------------------------
DROP TABLE IF EXISTS `zimu_level`;
CREATE TABLE `zimu_level` (
  `levelId` int(11) NOT NULL COMMENT '等级ID',
  `levelAccessToken` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '等级接入token'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zimu_level
-- ----------------------------
BEGIN;
INSERT INTO `zimu_level` VALUES (2, 'oxnvxy8dab');
INSERT INTO `zimu_level` VALUES (2, '5iy08lquxkp');
COMMIT;

-- ----------------------------
-- Table structure for zimu_link
-- ----------------------------
DROP TABLE IF EXISTS `zimu_link`;
CREATE TABLE `zimu_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) NOT NULL COMMENT '链接',
  `linkName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '链接名称',
  `levelId` int(11) NOT NULL DEFAULT '0' COMMENT '等级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zimu_link
-- ----------------------------
BEGIN;
INSERT INTO `zimu_link` VALUES (2, 'http://missmymiss.cn/webTools', '1', 0);
INSERT INTO `zimu_link` VALUES (3, 'https://yaokui.ltd/', '薄荷你玩', 0);
INSERT INTO `zimu_link` VALUES (4, 'http://missmymiss.cn/blog', '我的博客', 0);
INSERT INTO `zimu_link` VALUES (5, 'baidu.com', 'test', 1);
INSERT INTO `zimu_link` VALUES (9, 'tewerw', 'fsafdsda', 0);
INSERT INTO `zimu_link` VALUES (26, '523', '52345234', 0);
INSERT INTO `zimu_link` VALUES (27, '4123432', '41234', 0);
INSERT INTO `zimu_link` VALUES (28, '2314532', 'ewrqwer', 0);
INSERT INTO `zimu_link` VALUES (29, '5453426', '2345342', 0);
COMMIT;

-- ----------------------------
-- Table structure for zimu_log
-- ----------------------------
DROP TABLE IF EXISTS `zimu_log`;
CREATE TABLE `zimu_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reqIp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求IP',
  `reqUa` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求UA',
  `reqAccessToken` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求接入指令',
  `reqLink` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求链接',
  `reqIpAdress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求IP的地址',
  `reqTime` datetime DEFAULT NULL COMMENT '请求的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1585 DEFAULT CHARSET=utf8;

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
  `footerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'footer名称',
  `footerLink` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'footer链接',
  `footerLinkName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'footer链接名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zimu_setting
-- ----------------------------
BEGIN;
INSERT INTO `zimu_setting` VALUES ('zimu', '一个专注安全与WEB的引导页', 'WEB, 安全', 'zimu.info', '不懂安全的人是幸福的，而我们的责任是守护他们的幸福。', NULL, 'zimu', 'http://missmymiss.cn/zimu', 'zimu');
INSERT INTO `zimu_setting` VALUES ('zimu', '一个专注安全与WEB的引导页', 'WEB, 安全', 'zimu.info', '不懂安全的人是幸福的，而我们的责任是守护他们的幸福。', NULL, 'zimu', 'http://missmymiss.cn/zimu', 'zimu');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
