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
-- ----------------------------
DROP TABLE IF EXISTS `tbl_college_info`;
CREATE TABLE `tbl_college_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '学校id',
  `name` varchar(255) NOT NULL COMMENT '学校名称',
  `address` varchar(255) NOT NULL COMMENT '学校地址',
  `province` varchar(64) DEFAULT NULL COMMENT '学校省份',
  `city` varchar(128) DEFAULT NULL COMMENT '学校所在城市',
  `school_type` varchar(10) DEFAULT NULL COMMENT '院校类别 综合 工科 医药 财经 语言 师范 语言 农业 体育 政法 林业 艺术 民族 军事',
  `batch_type` varchar(10) DEFAULT NULL COMMENT '批次类别 本科 专科',
  `nature_type` varchar(10) DEFAULT NULL COMMENT '办学性质 公办 民办 中外合作 港澳合作 独立院校',
  `institution` varchar(20) DEFAULT NULL COMMENT '所属机构 (教育部 信息化部等等)',
  `doctoral_program` int DEFAULT NULL COMMENT '博士点',
  `master_program` int DEFAULT NULL COMMENT '硕士点',
  `description` text COMMENT '学校介绍',
  `enrollment` text COMMENT '招生简章',
  `ioc` binary(255) DEFAULT NULL COMMENT '学校校徽',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_college_nature_type`;
CREATE TABLE `tbl_college_nature_type` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `college_id` int NOT NULL COMMENT '学校ID',
  `type_id` int NOT NULL COMMENT '学校类型id   一对多 985  211',
  `beiyong` varchar(40) DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_college_profession`;
CREATE TABLE `tbl_college_profession` (
  `id` int NOT NULL AUTO_INCREMENT,
  `college_id` int DEFAULT NULL COMMENT '学校id',
  `profession_id` int DEFAULT NULL COMMENT '专业id',
  `paiming` int DEFAULT NULL COMMENT '学校专业排名',
  `jibie` varchar(10) DEFAULT NULL COMMENT '学校专业级别',
  `tese` varchar(255) DEFAULT NULL COMMENT '学校专业特色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_nature_type`;
CREATE TABLE `tbl_nature_type` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '学校类型ID',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '建设名称',
  `ioc` binary(255) DEFAULT NULL COMMENT '类型图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_notice_info`;
CREATE TABLE `tbl_notice_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` int DEFAULT NULL COMMENT '公告类型',
  `content` text COMMENT '公告内容',
  `rank` int DEFAULT NULL COMMENT '公告级别',
  `noticetime` datetime DEFAULT NULL COMMENT '公告时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_profession`;
CREATE TABLE `tbl_profession` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `leixing` int DEFAULT NULL COMMENT '专业类型 1 本科 2 专科',
  `jibie` int DEFAULT NULL COMMENT '专业级别 1 大类 2 小类 3 具体学科',
  `big_type` varchar(64) DEFAULT NULL COMMENT '专业大类(哲学\\经济学\\法学等)',
  `small_type` varchar(255) DEFAULT NULL COMMENT '专业小类(法学类、政治学类、社会学类)',
  `name` varchar(255) DEFAULT NULL COMMENT '专业名称',
  `description` varchar(255) DEFAULT NULL COMMENT '专业描述',
  `jiuyelv` varchar(40) DEFAULT NULL COMMENT '就业率',
  `guimo` varchar(40) DEFAULT NULL COMMENT '毕业生规模',
  `pid` int DEFAULT NULL COMMENT '所属专业父专业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_province_college_score`;
CREATE TABLE `tbl_province_college_score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `year` int DEFAULT NULL COMMENT '年份',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `type` varchar(64) DEFAULT NULL COMMENT '类型(理科\\文科\\艺术\\体育)',
  `college_id` int DEFAULT NULL COMMENT '学校id',
  `batch` int DEFAULT NULL COMMENT '批次 1 提前批 2 本科一批 3 本科二批 4 专科批 5 国家专项计划 6 地方专项计划',
  `diaodangfen` int DEFAULT NULL COMMENT '调档分',
  `diaodang_weici` bigint DEFAULT NULL COMMENT '调档分位次',
  `pingjunfen` int DEFAULT NULL COMMENT '平均分',
  `pingjun_weici` bigint DEFAULT NULL COMMENT '平均分位次',
  `plan_count` int DEFAULT NULL COMMENT '计划招生人数',
  `actual_count` int DEFAULT NULL COMMENT '实际招生人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_province_profession_score`;
CREATE TABLE `tbl_province_profession_score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `year` int DEFAULT NULL COMMENT '年份',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `type` varchar(64) DEFAULT NULL COMMENT '类型(理科\\文科\\艺术\\体育)',
  `college_id` int DEFAULT NULL COMMENT '学校id',
  `batch` int DEFAULT NULL COMMENT '批次 1 提前批 2 本科一批 3 本科二批 4 专科批 5 国家专项计划 6 地方专项计划',
  `profession_id` bigint DEFAULT NULL COMMENT '专业id',
  `shilufen` int DEFAULT NULL COMMENT '专业实录分',
  `shilu_weici` bigint DEFAULT NULL COMMENT '专业实录分位次',
  `pingjunfen` int DEFAULT NULL COMMENT '专业平均分',
  `pingjun_weici` bigint DEFAULT NULL COMMENT '专业平均分位次',
  `plan_count` int DEFAULT NULL COMMENT '专业计划招生人数',
  `actual_count` int DEFAULT NULL COMMENT '专业实际招生人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_province_score`;
CREATE TABLE `tbl_province_score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `year` int DEFAULT NULL COMMENT '年份',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `batch` varchar(64) DEFAULT NULL COMMENT '批次(提前批/第一批/第二批/高职等)',
  `type` varchar(64) DEFAULT NULL COMMENT '类型(理科\\文科\\艺术\\体育)',
  `score` int DEFAULT NULL COMMENT '分数线',
  `ishistory` bit(1) DEFAULT NULL COMMENT '是否历史',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_info`;
CREATE TABLE `tbl_user_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '用户名字',
  `phone` bigint NOT NULL COMMENT '手机号 (登录用)',
  `userpwd` varchar(255) NOT NULL COMMENT '用户密码',
  `role` int DEFAULT '0' COMMENT '用户类型(会员/艺术/体育/非会员/管理员)',
  `startime` datetime DEFAULT NULL COMMENT '会员开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '到期时间',
  `email` varchar(64) DEFAULT NULL COMMENT '用户邮箱',
  `provice` varchar(64) DEFAULT NULL,
  `score` int DEFAULT NULL COMMENT '分数',
  `type` varchar(255) DEFAULT NULL COMMENT '考生类型(理科/文科/艺术/体育)',
  PRIMARY KEY (`id`,`phone`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_version_info`;
CREATE TABLE `tbl_version_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `version` varchar(32) DEFAULT NULL COMMENT '版本号',
  `description` varchar(255) DEFAULT NULL COMMENT '版本说明',
  `link` varchar(255) DEFAULT NULL COMMENT '版本地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- ----------------------------
DROP TABLE IF EXISTS `tbl_video_info`;
CREATE TABLE `tbl_video_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` int DEFAULT NULL COMMENT '视频类型',
  `link` varchar(255) DEFAULT NULL COMMENT '视频地址链接',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8




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
