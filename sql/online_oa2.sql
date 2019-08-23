/*
Navicat MySQL Data Transfer

Source Server         : 61
Source Server Version : 50719
Source Host           : 192.168.128.61:3306
Source Database       : online_oa2

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-08-23 10:53:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '主键',
  `news_type` int(11) DEFAULT NULL COMMENT '类型字典',
  `news_title` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `news_introduction` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '简介',
  `news_cover` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '封面图片',
  `news_content` varchar(8000) COLLATE utf8_bin DEFAULT NULL COMMENT '内容',
  `news_date` datetime DEFAULT NULL COMMENT '展示发布时间',
  `news_read_times` int(11) DEFAULT NULL COMMENT '阅读次数',
  `news_create` datetime DEFAULT NULL COMMENT '创建时间',
  `news_update` datetime DEFAULT NULL COMMENT '更新时间',
  `news_show_status` int(11) DEFAULT NULL COMMENT '展示状态 0未展示 1展示中',
  `news_status` int(11) DEFAULT NULL COMMENT '状态 0已删除 1 正常 2未保存',
  `news_spare_varchar` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '备用varchar',
  `news_spare_date` date DEFAULT NULL COMMENT '备用date',
  `news_spare_int` int(11) DEFAULT NULL COMMENT '备用int',
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资讯表';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', null, '新闻1', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('10', null, '新闻10', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('11', null, '新闻11', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('12', null, '新闻12', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('13', null, '新闻13', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('14', null, '新闻14', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('15', null, '新闻15', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('2', null, '新闻2', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('3', null, '新闻3', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('4', null, '新闻4', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('5', null, '新闻5', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('6', null, '新闻6', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('7', null, '新闻7', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('8', null, '新闻8', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `news` VALUES ('9', null, '新闻9', null, null, null, null, null, null, null, null, null, null, null, null);
