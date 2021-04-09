/*
Navicat MySQL Data Transfer

Source Server         : dbuser
Source Server Version : 50733
Source Host           : localhost:3306
Source Database       : ceev

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2021-04-05 17:41:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_college_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_college_info`;
CREATE TABLE `tbl_college_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学校id',
  `name` varchar(255) NOT NULL COMMENT '学校名称',
  `address` varchar(255) NOT NULL COMMENT '学校地址',
  `province` varchar(64) DEFAULT NULL COMMENT '学校省份',
  `city` varchar(128) DEFAULT NULL COMMENT '学校所在城市',
  `type` varchar(128) DEFAULT NULL COMMENT '学校类型集合 tbl_type',
  `description` text COMMENT '学校介绍',
  `ioc` binary(255) DEFAULT NULL COMMENT '学校校徽',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_college_info
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_college_profession
-- ----------------------------
DROP TABLE IF EXISTS `tbl_college_profession`;
CREATE TABLE `tbl_college_profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `college_id` int(11) DEFAULT NULL COMMENT '学校id',
  `profession_id` int(11) DEFAULT NULL COMMENT '专业id',
  `feature` varchar(255) DEFAULT NULL COMMENT '学校专业特色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_college_profession
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_college_type_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_college_type_info`;
CREATE TABLE `tbl_college_type_info` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `college_id` int(11) NOT NULL COMMENT '学校ID',
  `type_id` int(11) NOT NULL COMMENT '学校类型id   一对多',
  `showtext` varchar(255) DEFAULT NULL COMMENT '显示内容 如果为空显示 type name',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_college_type_info
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_notice_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_notice_info`;
CREATE TABLE `tbl_notice_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '公告类型',
  `content` text COMMENT '公告内容',
  `rank` int(11) DEFAULT NULL COMMENT '公告级别',
  `noticetime` datetime DEFAULT NULL COMMENT '公告时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_notice_info
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_profession
-- ----------------------------
DROP TABLE IF EXISTS `tbl_profession`;
CREATE TABLE `tbl_profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `type` varchar(64) DEFAULT NULL COMMENT '专业类型(本科\\专科\\哲学\\经济学\\法学等)',
  `name` varchar(255) DEFAULT NULL COMMENT '专业名称',
  `description` varchar(255) DEFAULT NULL COMMENT '专业描述',
  `pid` int(11) DEFAULT NULL COMMENT '所属专业父专业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_profession
-- ----------------------------
INSERT INTO `tbl_profession` VALUES ('1', null, '本科专业', null, '0');
INSERT INTO `tbl_profession` VALUES ('2', null, '专科专业', null, '0');

-- ----------------------------
-- Table structure for tbl_province_college_score
-- ----------------------------
DROP TABLE IF EXISTS `tbl_province_college_score`;
CREATE TABLE `tbl_province_college_score` (
  `id` int(11)  NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL COMMENT '年份',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `batch` varchar(64) DEFAULT NULL COMMENT '批次(提前批/第一批/第二批/高职等)',
  `type` varchar(64) DEFAULT NULL COMMENT '类型(理科\\文科\\艺术\\体育)',
  `college_id` int(11) DEFAULT NULL COMMENT '学校id',
  `rank` int(11) DEFAULT NULL COMMENT '排名',
  `college_score` int(11) DEFAULT NULL COMMENT '学校录取分数',
  `profession_score` int(11) DEFAULT NULL COMMENT '学校专业录取分数',
  `plan_count` int(11) DEFAULT NULL COMMENT '学校计划招生人数',
  `actual_count` int(11) DEFAULT NULL COMMENT '实际招生人数',
  `ishistory` bit(1) DEFAULT NULL COMMENT '是否历史',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_province_college_score
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_province_score
-- ----------------------------
DROP TABLE IF EXISTS `tbl_province_score`;
CREATE TABLE `tbl_province_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL COMMENT '年份',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `batch` varchar(64) DEFAULT NULL COMMENT '批次(提前批/第一批/第二批/高职等)',
  `type` varchar(64) DEFAULT NULL COMMENT '类型(理科\\文科\\艺术\\体育)',
  `score` int(11) DEFAULT NULL COMMENT '分数线',
  `ishistory` bit(1) DEFAULT NULL COMMENT '是否历史',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_province_score
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_type`;
CREATE TABLE `tbl_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学校类型ID',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '学校类型名称',
  `ioc` binary(255) DEFAULT NULL COMMENT '类型图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_type
-- ----------------------------
INSERT INTO `tbl_type` VALUES ('1', '985', null);
INSERT INTO `tbl_type` VALUES ('2', '211', null);
INSERT INTO `tbl_type` VALUES ('3', '本科', null);
INSERT INTO `tbl_type` VALUES ('4', '公办', null);
INSERT INTO `tbl_type` VALUES ('5', '理工类', null);
INSERT INTO `tbl_type` VALUES ('6', '双一流', null);
INSERT INTO `tbl_type` VALUES ('7', '博士点', null);
INSERT INTO `tbl_type` VALUES ('8', '硕士点', null);

-- ----------------------------
-- Table structure for tbl_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_info`;
CREATE TABLE `tbl_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL unique COMMENT '用户名字',
  `phone` bigint(11) NOT NULL unique COMMENT '手机号 (登录用)',
  `userpwd` varchar(255) NOT NULL COMMENT '用户密码',
  `role` int(11) DEFAULT '0' COMMENT '用户类型(会员/艺术/体育/非会员/管理员)',
  `startime` datetime DEFAULT NULL COMMENT '会员开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '到期时间',
  `email` varchar(64) DEFAULT NULL COMMENT '用户邮箱',
  `provice` varchar(64) DEFAULT NULL,
  `score` int(11) DEFAULT NULL COMMENT '分数',
  `type` varchar(255) DEFAULT NULL COMMENT '考生类型(理科/文科/艺术/体育)',
  PRIMARY KEY (`id`,`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_version_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_version_info`;
CREATE TABLE `tbl_version_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(32) DEFAULT NULL COMMENT '版本号',
  `description` varchar(255) DEFAULT NULL COMMENT '版本说明',
  `link` varchar(255) DEFAULT NULL COMMENT '版本地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_version_info
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_video_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_video_info`;
CREATE TABLE `tbl_video_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '视频类型',
  `link` varchar(255) DEFAULT NULL COMMENT '视频地址链接',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_video_info
-- ----------------------------


-- 测试表
DROP TABLE IF EXISTS `dsp_system_config`;
CREATE TABLE `dsp_system_config` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键id配置编号',
  `dsp_cfg_code` varchar(100) DEFAULT NULL COMMENT '配置编码',
  `dsp_cfg_name` varchar(100) DEFAULT NULL COMMENT '配置名称',
  `dsp_cfg_desc` varchar(100) DEFAULT NULL COMMENT '配置描述',
  `dsp_cfg_value_type` varchar(50) DEFAULT NULL COMMENT '配置值类型，比如integer（整数）、html（HTML）等bool（是否），不同的值类型可以通过不同的表单来显示和编辑',
  `dsp_cfg_value` varchar(100) DEFAULT NULL COMMENT '配置值',
  `dsp_cfg_state` int(4) DEFAULT NULL COMMENT '配置状态（-1：已删除；0：禁用；1：启用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统配置';
-- 测试数据
insert into `dsp_system_config` (`id`, `dsp_cfg_code`, `dsp_cfg_name`, `dsp_cfg_desc`, `dsp_cfg_value_type`, `dsp_cfg_value`, `dsp_cfg_state`) values('1','iam_ip','iam系统IP','iam系统ip','字符串','192.168.12.253','1');
insert into `dsp_system_config` (`id`, `dsp_cfg_code`, `dsp_cfg_name`, `dsp_cfg_desc`, `dsp_cfg_value_type`, `dsp_cfg_value`, `dsp_cfg_state`) values('2','iam_port','iam系统端口','iam系统后端端口','字符串','8091','1');
insert into `dsp_system_config` (`id`, `dsp_cfg_code`, `dsp_cfg_name`, `dsp_cfg_desc`, `dsp_cfg_value_type`, `dsp_cfg_value`, `dsp_cfg_state`) values('3','iam_context','iam上下文','iam访问上下文','字符串','cas','1');
