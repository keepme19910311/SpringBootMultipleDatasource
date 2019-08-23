/*
Navicat MySQL Data Transfer

Source Server         : 244
Source Server Version : 50641
Source Host           : 192.168.128.244:3306
Source Database       : online_oa

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-08-23 10:54:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_login_table
-- ----------------------------
DROP TABLE IF EXISTS `user_login_table`;
CREATE TABLE `user_login_table` (
  `login_uid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '登陆账户主键',
  `login_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '登陆名',
  `login_password` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '登陆密码',
  `remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `status` int(1) DEFAULT NULL COMMENT '状态1可用0禁用',
  `update_date` datetime DEFAULT NULL COMMENT '上次更新时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`login_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_login_table
-- ----------------------------
INSERT INTO `user_login_table` VALUES ('1', '一改', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('10', '十', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('11', '十一', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('2', '二', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('3', '三', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('4', '四', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('5', '五', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('6', '六', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('7', '七', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('8', '八', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
INSERT INTO `user_login_table` VALUES ('9', '⑨', '123', null, '1', '2019-08-21 16:46:11', '2019-08-21 16:46:11');
