/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : tc

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-05-29 22:18:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_capsule
-- ----------------------------
DROP TABLE IF EXISTS `tb_capsule`;
CREATE TABLE `tb_capsule` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `ckey` varchar(255) NOT NULL,
  `csafeStrategy` int(255) unsigned zerofill DEFAULT NULL,
  `cwxopenid` varchar(255) NOT NULL COMMENT '胶囊创建用户',
  `cputTime` varchar(255) DEFAULT NULL COMMENT '胶囊埋下时间',
  `cpreOpenTime` varchar(255) DEFAULT NULL COMMENT '胶囊预计开启时间',
  `cactOpenTime` varchar(255) DEFAULT NULL COMMENT '胶囊实际开启时间',
  `csubject` varchar(255) DEFAULT NULL,
  `cpreShowText` text COMMENT '未到期开启显示内容',
  `ccid` int(11) DEFAULT NULL COMMENT '胶囊内容',
  `cisSnap` int(255) unsigned zerofill DEFAULT NULL COMMENT '是否阅后即焚',
  `cQrImgUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_cap_content
-- ----------------------------
DROP TABLE IF EXISTS `tb_cap_content`;
CREATE TABLE `tb_cap_content` (
  `ccid` int(11) NOT NULL AUTO_INCREMENT,
  `cccontent` longtext,
  PRIMARY KEY (`ccid`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `uid` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `uname` varchar(255) DEFAULT NULL COMMENT '用户名',
  `ugender` int(255) DEFAULT NULL,
  `upassword` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `ushowmsg` text COMMENT '个性签名',
  `utel` varchar(255) DEFAULT NULL COMMENT '预留手机号',
  `uwxopenid` varchar(255) DEFAULT NULL COMMENT '微信openid',
  `uemail` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `uwxname` varchar(255) DEFAULT NULL COMMENT '微信用户名',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
