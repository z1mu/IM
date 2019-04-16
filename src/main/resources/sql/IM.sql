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

 Date: 16/04/2019 20:57:52
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
-- Records of zimu_level
-- ----------------------------
BEGIN;
INSERT INTO `zimu_level` VALUES (1, '123456');
INSERT INTO `zimu_level` VALUES (2, '654321');
INSERT INTO `zimu_level` VALUES (3, '111111');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zimu_link
-- ----------------------------
BEGIN;
INSERT INTO `zimu_link` VALUES (1, 'http://missmymiss.cn/zimu', '个人简介', 0);
INSERT INTO `zimu_link` VALUES (2, 'http://missmymiss.cn/webTools', '在线工具', 2);
INSERT INTO `zimu_link` VALUES (3, 'https://yaokui.ltd/', '薄荷你玩', 0);
INSERT INTO `zimu_link` VALUES (4, 'http://missmymiss.cn/blog', '我的博客', 0);
COMMIT;

-- ----------------------------
-- Table structure for zimu_log
-- ----------------------------
DROP TABLE IF EXISTS `zimu_log`;
CREATE TABLE `zimu_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_ip` varchar(255) DEFAULT NULL COMMENT '请求IP',
  `req_ua` varchar(255) DEFAULT NULL COMMENT '请求UA',
  `req_access_token` varchar(255) DEFAULT NULL COMMENT '请求接入指令',
  `req_link` varchar(255) DEFAULT NULL COMMENT '请求链接',
  `req_ip_adress` varchar(255) DEFAULT NULL COMMENT '请求IP的地址',
  `req_time` datetime DEFAULT NULL COMMENT '请求的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zimu_log
-- ----------------------------
BEGIN;
INSERT INTO `zimu_log` VALUES (1, '192.168.0.107', 'Mozilla/5.0 (Linux; U; Android 8.1.0; zh-Hans-CN; INE-AL00 Build/HUAWEIINE-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 Quark/3.1.1.105 Mobile Safari/537.36', '', '/', '[\"本地局域网\",\"\",\"\",\"\",\"\",\"\"]', '2019-04-16 20:52:14');
INSERT INTO `zimu_log` VALUES (2, '127.0.0.1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36', '654321', '/', '[\"保留地址\",\"\",\"\",\"\",\"\",\"\"]', '2019-04-16 20:53:07');
COMMIT;

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

-- ----------------------------
-- Records of zimu_setting
-- ----------------------------
BEGIN;
INSERT INTO `zimu_setting` VALUES ('zimu', '一个专注安全与WEB的引导页', 'WEB, 安全', 'zimu.info', '不懂安全的人是幸福的，而我们的责任是守护他们的幸福。', NULL, 'zimu', 'http://missmymiss.cn/zimu', 'zimu');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
