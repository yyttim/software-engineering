/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720 (5.7.20)
 Source Host           : localhost:3306
 Source Schema         : DB_Hospital

 Target Server Type    : MySQL
 Target Server Version : 50720 (5.7.20)
 File Encoding         : 65001

 Date: 13/05/2024 14:54:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `a_id` int(11) NOT NULL COMMENT '主键，管理员id（账号）',
  `a_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `a_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `a_gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `a_card` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `a_phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `a_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
BEGIN;
INSERT INTO `admin_user` (`a_id`, `a_password`, `a_name`, `a_gender`, `a_card`, `a_phone`, `a_email`) VALUES (202401, '123456', 'admin', '男', '34000000000000', '13541111111', '123@qq.com');
COMMIT;

-- ----------------------------
-- Table structure for arrange
-- ----------------------------
DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange` (
  `ar_id` varchar(255) NOT NULL COMMENT '排班id',
  `ar_time` varchar(255) DEFAULT NULL COMMENT '排班时间',
  `d_id` int(11) DEFAULT NULL COMMENT '医生id',
  PRIMARY KEY (`ar_id`) USING BTREE,
  KEY `arTOd` (`d_id`) USING BTREE,
  CONSTRAINT `arTOd` FOREIGN KEY (`d_id`) REFERENCES `doctor_user` (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of arrange
-- ----------------------------
BEGIN;
INSERT INTO `arrange` (`ar_id`, `ar_time`, `d_id`) VALUES ('10002024-05-10', '2024-05-01', 1000);
INSERT INTO `arrange` (`ar_id`, `ar_time`, `d_id`) VALUES ('10002024-05-11', '2024-05-11', 1000);
INSERT INTO `arrange` (`ar_id`, `ar_time`, `d_id`) VALUES ('10002024-05-12', '2024-05-02', 1000);
INSERT INTO `arrange` (`ar_id`, `ar_time`, `d_id`) VALUES ('10012024-05-10', '2024-05-10', 1001);
INSERT INTO `arrange` (`ar_id`, `ar_time`, `d_id`) VALUES ('10012024-05-11', '2024-05-11', 1001);
INSERT INTO `arrange` (`ar_id`, `ar_time`, `d_id`) VALUES ('10012024-05-12', '2024-05-12', 1001);
INSERT INTO `arrange` (`ar_id`, `ar_time`, `d_id`) VALUES ('10022024-05-10', '2024-05-10', 1002);
INSERT INTO `arrange` (`ar_id`, `ar_time`, `d_id`) VALUES ('10022024-05-11', '2024-05-03', 1002);
INSERT INTO `arrange` (`ar_id`, `ar_time`, `d_id`) VALUES ('10022024-05-12', '2024-05-12', 1002);
COMMIT;

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed` (
  `b_id` int(11) NOT NULL COMMENT '病床id',
  `p_id` int(11) DEFAULT NULL COMMENT '病人id',
  `b_state` int(11) DEFAULT NULL COMMENT '病床状态',
  `b_start` varchar(255) DEFAULT NULL COMMENT '入住开始时间',
  `d_id` int(11) DEFAULT NULL COMMENT '医生id',
  `b_reason` varchar(255) DEFAULT NULL COMMENT '申请理由',
  `version` int(11) DEFAULT NULL COMMENT '申请理由',
  PRIMARY KEY (`b_id`) USING BTREE,
  KEY `bTOp` (`p_id`) USING BTREE,
  KEY `bTOd` (`d_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bed
-- ----------------------------
BEGIN;
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (1, 2000, 1, '2024-05-01', 1000, '病人状况比较糟糕，需要住院3天。照顾下。', NULL);
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (2, -1, 0, NULL, -1, NULL, NULL);
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (3, -1, 0, NULL, -1, NULL, NULL);
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (4, -1, 0, NULL, -1, NULL, NULL);
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (5, -1, 0, NULL, -1, NULL, NULL);
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (6, -1, 0, NULL, -1, NULL, NULL);
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (7, -1, 0, NULL, -1, NULL, NULL);
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (8, -1, 0, NULL, -1, NULL, NULL);
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (9, -1, 0, NULL, -1, NULL, NULL);
INSERT INTO `bed` (`b_id`, `p_id`, `b_state`, `b_start`, `d_id`, `b_reason`, `version`) VALUES (10, -1, 0, NULL, -1, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for checks
-- ----------------------------
DROP TABLE IF EXISTS `checks`;
CREATE TABLE `checks` (
  `ch_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '检查项目id',
  `ch_name` varchar(255) DEFAULT NULL COMMENT '检查项目名称',
  `ch_price` decimal(10,2) DEFAULT NULL COMMENT '检查项目价格',
  PRIMARY KEY (`ch_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of checks
-- ----------------------------
BEGIN;
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (1, 'B超', 201.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (2, 'CT', 435.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (3, '核磁共振', 653.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (4, 'MRI', 534.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (5, '心电图', 634.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (6, '彩超', 213.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (7, '血常规', 434.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (8, '肝功能', 543.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (9, '血糖', 434.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (10, '甲状腺', 434.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (12, '听力', 10.00);
INSERT INTO `checks` (`ch_id`, `ch_name`, `ch_price`) VALUES (13, 'asdasd', 123.00);
COMMIT;

-- ----------------------------
-- Table structure for diseases
-- ----------------------------
DROP TABLE IF EXISTS `diseases`;
CREATE TABLE `diseases` (
  `de_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '疾病id',
  `de_name` varchar(255) DEFAULT NULL COMMENT '疾病名称',
  `de_symptom` text COMMENT '疾病症状',
  PRIMARY KEY (`de_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of diseases
-- ----------------------------
BEGIN;
INSERT INTO `diseases` (`de_id`, `de_name`, `de_symptom`) VALUES (1, '心脏病', '不同类型的心脏病可有不同的早期症状，包括心慌、心悸、胸闷、呼吸急促、头昏甚至昏厥等。当出现心律失常时心跳异常，如跳动太快，太慢或不规则；表现为心慌、心悸、胸闷、呼吸急促、头昏甚至昏厥。');
INSERT INTO `diseases` (`de_id`, `de_name`, `de_symptom`) VALUES (2, '糖尿病', '1、早期症状：糖尿病通常是血清里面的葡萄糖水平升高，代谢异常引起的。早期时可能没有明显症状表现，会通过血糖检测发现病情。  \n2、一型糖尿病症状：糖尿病逐渐加重，发展为一型糖尿病时，可能会有多饮、多尿、多食和体重下降的症状。  \n3、二型糖尿病症状：二型糖尿病可能会出现身体肥胖、皮肤感染、心慌、恶心、出冷汗等症状。  \n4、并发症：如果病情发展比较严重，可能会让相应的器官受损，可能会有视力模糊、伤口溃疡不易恢复、动脉粥样硬化、局部刺痛、灼热感等。');
INSERT INTO `diseases` (`de_id`, `de_name`, `de_symptom`) VALUES (3, '肥胖症', '典型症状 \n   体内脂肪过度蓄积和体重超重，超重的基础上，可能会有气急、关节痛、肌肉酸痛、体力活动减少以及焦虑等症状。严重的单纯性肥胖和继发性肥胖常与血脂异常、脂肪肝、高血压、冠心病、糖耐量异常或糖尿病等疾病同时发生。 \n伴随症状 \n   伴随或并发高血压、糖尿病、痛风、骨关节病、静脉血栓、生育功能受损、以及某些肿瘤发病率增高等，出现相关的症状。肥胖症患者麻醉或手术并发症会增多。严重的肥胖症患者还会出现自卑、抑郁、社会适应能力差等精神问题。');
COMMIT;

-- ----------------------------
-- Table structure for doctor_user
-- ----------------------------
DROP TABLE IF EXISTS `doctor_user`;
CREATE TABLE `doctor_user` (
  `d_id` int(11) NOT NULL COMMENT '医生id（账号）',
  `d_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `d_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `d_gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `d_phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `d_card` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  `d_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `d_post` varchar(255) DEFAULT NULL COMMENT '职位',
  `d_introduction` varchar(255) DEFAULT NULL COMMENT '简介',
  `d_section` varchar(255) DEFAULT NULL COMMENT '科室',
  `d_state` int(11) NOT NULL COMMENT '在职状态',
  `d_price` decimal(10,2) DEFAULT NULL COMMENT '挂号价格',
  `d_people` int(11) DEFAULT NULL COMMENT '评价人数',
  `d_star` decimal(10,2) DEFAULT NULL COMMENT '评价总分',
  `d_avg_star` decimal(10,2) DEFAULT NULL COMMENT '评价平均分',
  PRIMARY KEY (`d_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of doctor_user
-- ----------------------------
BEGIN;
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1000, 'e10adc3949ba59abbe56e057f20f883e', '张医生', '女', '18762543671', '352225177380837645', 'zhang@qq.com', '主任医师', '神经内科主任医师', '神经内科', 1, 10.00, 2, 9.00, 4.50);
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1001, 'e10adc3949ba59abbe56e057f20f883e', '王医生', '男', '19872635542', '348882988376153789', 'wang@qq.com', '副主任医师', '神经内科-副主任医师', '神经内科', 0, 5.00, 0, 0.00, NULL);
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1002, 'e10adc3949ba59abbe56e057f20f883e', '李医生', '男', '18627362563', '352224827736281', 'li@gmail.com', '主治医生', '神经内科-主治医生', '神经内科', 1, 20.00, 0, 0.00, NULL);
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1003, 'e10adc3949ba59abbe56e057f20f883e', '赵医生', '男', '18792374621', '348882733628236', 'zhao@163.com', '主任医师', '内分泌科-主任医师', '内分泌科', 1, 10.00, 0, 0.00, NULL);
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1004, 'e10adc3949ba59abbe56e057f20f883e', '马医生', '男', '18562382321', '342223947192347', 'ma@qq.com', '主治医生', '呼吸科-主治医生', '呼吸与危重症医学科', 1, 50.00, 0, 0.00, NULL);
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1005, 'e10adc3949ba59abbe56e057f20f883e', '卞医生', '男', '18676665544', '352229833391837463', 'bian@qq.com', '主任医师', '消化内科-主人医师', '消化内科', 1, 100.00, 0, 0.00, NULL);
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1006, 'e10adc3949ba59abbe56e057f20f883e', '廖医生', '女', '18766623523', '352229378782331', 'liao@qq.com', '副主任医师', '心血管内科医生', '心血管内科', 1, 10.00, 0, 0.00, NULL);
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1007, 'e10adc3949ba59abbe56e057f20f883e', '乌医生', '男', '18723626312', '382227392312132', 'wu@qq.com', '主任医师', '妇科-主任医师', '妇科', 1, 10.00, 0, 0.00, NULL);
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1008, 'e10adc3949ba59abbe56e057f20f883e', '田医生', '女', '19876763231', '348887233210237', 'tian@qq.com', '副主任医师', '手足外科-副主任', '手足外科', 1, 2.00, 0, 0.00, NULL);
INSERT INTO `doctor_user` (`d_id`, `d_password`, `d_name`, `d_gender`, `d_phone`, `d_card`, `d_email`, `d_post`, `d_introduction`, `d_section`, `d_state`, `d_price`, `d_people`, `d_star`, `d_avg_star`) VALUES (1009, 'e10adc3949ba59abbe56e057f20f883e', '苗医生', '女', '18723776462', '387772372313123', 'miao@163.com', '主治医生', '儿科-主治医生', '儿科', 1, 30.00, 0, 0.00, NULL);
COMMIT;

-- ----------------------------
-- Table structure for drug
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug` (
  `dr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '药物id',
  `dr_name` varchar(255) DEFAULT NULL COMMENT '药物名称',
  `dr_price` decimal(10,2) DEFAULT NULL COMMENT '药物价格',
  `dr_number` int(11) DEFAULT NULL COMMENT '药物数量',
  `dr_publisher` varchar(255) DEFAULT NULL COMMENT '出版商',
  `dr_unit` varchar(255) DEFAULT NULL COMMENT '单位',
  PRIMARY KEY (`dr_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of drug
-- ----------------------------
BEGIN;
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (1, '青霉素', 23.00, 10, '国家医药局', '袋');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (2, '苯唑西林', 11.00, 28, '国家医药局', '盒');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (3, '氨苄西林', 13.00, 51, '国家医药局', '盒');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (4, '哌拉西林', 2.00, 7, '国家医药局', '盒');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (5, '阿莫西林', 13.00, 20, '国家医药局', '盒');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (6, '头孢唑林', 3.00, 32, '国家医药局', '盒');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (7, '头孢氨苄', 4.00, 43, '国家医药局', '盒');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (8, '头孢呋辛', 8.00, 54, '国家医药局', '盒');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (9, '阿米卡星', 5.00, 54, '国家医药局', '袋');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (10, '庆大霉素', 7.00, 63, '国家医药局', '袋');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (11, '红霉素', 6.00, 75, '国家医药局', '袋');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (12, '阿奇霉素', 54.00, 52, '国家医药局', '袋');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (13, '克林霉素', 65.00, 21, '国家医药局', '袋');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (14, '复方磺胺甲噁唑', 76.00, 54, '国家医药局', '袋');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (15, '诺氟沙星', 65.00, 33, '国家医药局', '袋');
INSERT INTO `drug` (`dr_id`, `dr_name`, `dr_price`, `dr_number`, `dr_publisher`, `dr_unit`) VALUES (16, '左氧氟沙星', 76.00, 43, '国家医药局', '袋');
COMMIT;

-- ----------------------------
-- Table structure for healthDatas
-- ----------------------------
DROP TABLE IF EXISTS `healthDatas`;
CREATE TABLE `healthDatas` (
  `hd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '健康数据id',
  `hd_height` int(11) DEFAULT NULL COMMENT '健康数据身高',
  `hd_weight` float(11,1) DEFAULT NULL COMMENT '健康数据体重',
  `hd_temperature` float(11,1) DEFAULT NULL COMMENT '健康数据体温',
  `hd_advise` text COMMENT '健康数据建议',
  `hd_date` varchar(255) DEFAULT '' COMMENT '健康数据日期',
  `p_id` int(11) NOT NULL COMMENT '病患id',
  PRIMARY KEY (`hd_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of healthDatas
-- ----------------------------
BEGIN;
INSERT INTO `healthDatas` (`hd_id`, `hd_height`, `hd_weight`, `hd_temperature`, `hd_advise`, `hd_date`, `p_id`) VALUES (1, 175, 80.0, 38.0, '1. 您现在体重超重，建议您尝试高蛋白、低油脂、低碳水饮食，多吃蛋白质丰富的食物，搭配新鲜蔬菜，减少对米饭、面食等碳水化合物的摄入，控制油脂的摄入。\n2. 您现在处于高烧，建议您物理降温可用冷毛巾、冰袋、化学制冷袋等局部降温，还可以温水擦浴、酒精擦浴全身降温；也可以用药物降温，比如口服布洛芬或对乙酰氨基酚、静脉注射阿司匹林或肛门塞入退热栓，甚至应用糖皮质激素地塞米松等降温。\n', '2024-05-01', 2000);
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '挂号id',
  `p_id` int(11) DEFAULT NULL COMMENT '患者id (账号)',
  `d_id` int(11) DEFAULT NULL COMMENT '医生id (账号)',
  `o_record` varchar(255) DEFAULT NULL COMMENT '挂号时间段',
  `o_start` varchar(255) DEFAULT NULL COMMENT '开始时间',
  `o_end` varchar(255) DEFAULT NULL COMMENT '结束时间',
  `o_state` int(11) DEFAULT NULL COMMENT '挂号状态',
  `o_drug` varchar(255) DEFAULT NULL COMMENT '药物',
  `o_check` varchar(255) DEFAULT NULL COMMENT '检查项目',
  `o_total_price` decimal(10,2) DEFAULT NULL COMMENT '费用',
  `o_price_state` int(11) DEFAULT NULL COMMENT '缴费状态',
  `o_advice` varchar(255) DEFAULT NULL COMMENT '建议',
  PRIMARY KEY (`o_id`) USING BTREE,
  KEY `oTOp` (`p_id`) USING BTREE,
  KEY `0TOd` (`d_id`) USING BTREE,
  CONSTRAINT `0TOd` FOREIGN KEY (`d_id`) REFERENCES `doctor_user` (`d_id`),
  CONSTRAINT `oTOp` FOREIGN KEY (`p_id`) REFERENCES `patient_user` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7340 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` (`o_id`, `p_id`, `d_id`, `o_record`, `o_start`, `o_end`, `o_state`, `o_drug`, `o_check`, `o_total_price`, `o_price_state`, `o_advice`) VALUES (1218, 2000, 1000, NULL, '2024-05-11 14:30-15:30', NULL, 0, NULL, NULL, NULL, 0, NULL);
INSERT INTO `orders` (`o_id`, `p_id`, `d_id`, `o_record`, `o_start`, `o_end`, `o_state`, `o_drug`, `o_check`, `o_total_price`, `o_price_state`, `o_advice`) VALUES (6025, 2000, 1000, '', '2024-05-10 14:30-15:30', '2024-05-10 13:06:13', 1, '青霉素*23(元)*1  药物总价23元 ', 'B超*201(元)  项目总价201元 ', 0.00, 1, NULL);
INSERT INTO `orders` (`o_id`, `p_id`, `d_id`, `o_record`, `o_start`, `o_end`, `o_state`, `o_drug`, `o_check`, `o_total_price`, `o_price_state`, `o_advice`) VALUES (7339, 2000, 1000, NULL, '2024-05-12 10:30-11:30', NULL, 0, NULL, NULL, NULL, 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for patient_user
-- ----------------------------
DROP TABLE IF EXISTS `patient_user`;
CREATE TABLE `patient_user` (
  `p_id` int(11) NOT NULL COMMENT '病人id（账号）',
  `p_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `p_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `p_gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `p_phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `p_card` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  `p_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `p_state` int(11) DEFAULT NULL COMMENT '账号状态',
  `p_birthday` varchar(255) DEFAULT NULL COMMENT '生日',
  `p_age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of patient_user
-- ----------------------------
BEGIN;
INSERT INTO `patient_user` (`p_id`, `p_password`, `p_name`, `p_gender`, `p_phone`, `p_card`, `p_email`, `p_state`, `p_birthday`, `p_age`) VALUES (2000, 'e10adc3949ba59abbe56e057f20f883e', '徐先生', '男', '18733223345', '352227655454361762', 'xu@qq.com', 1, '1994-11-27', 29);
INSERT INTO `patient_user` (`p_id`, `p_password`, `p_name`, `p_gender`, `p_phone`, `p_card`, `p_email`, `p_state`, `p_birthday`, `p_age`) VALUES (2001, 'e10adc3949ba59abbe56e057f20f883e', '曾先生', '男', '18766552374', '356662733625364', 'zeng@qq.com', 1, '2000-11-03', 23);
INSERT INTO `patient_user` (`p_id`, `p_password`, `p_name`, `p_gender`, `p_phone`, `p_card`, `p_email`, `p_state`, `p_birthday`, `p_age`) VALUES (2002, 'e10adc3949ba59abbe56e057f20f883e', '张女士', '女', '18677662374', '387772633819283', 'zhang@163.com', 1, '1997-11-05', 26);
INSERT INTO `patient_user` (`p_id`, `p_password`, `p_name`, `p_gender`, `p_phone`, `p_card`, `p_email`, `p_state`, `p_birthday`, `p_age`) VALUES (2003, 'e10adc3949ba59abbe56e057f20f883e', '杨先生', '男', '18766256323', '353329877638231', 'yang@qq.com', 1, '2023-11-26', 0);
INSERT INTO `patient_user` (`p_id`, `p_password`, `p_name`, `p_gender`, `p_phone`, `p_card`, `p_email`, `p_state`, `p_birthday`, `p_age`) VALUES (2004, 'e10adc3949ba59abbe56e057f20f883e', '马女士', '女', '18766235473', '376662537482735', 'ma@qq.com', 1, '2017-11-06', 6);
INSERT INTO `patient_user` (`p_id`, `p_password`, `p_name`, `p_gender`, `p_phone`, `p_card`, `p_email`, `p_state`, `p_birthday`, `p_age`) VALUES (20000, 'e10adc3949ba59abbe56e057f20f883e', '哈维', '男', '13311011333', '111111111111111', '1233@163.com', 1, '2022-05-02', 2);
COMMIT;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '医疗产品id',
  `product_name` varchar(255) DEFAULT NULL COMMENT '医疗产品名称',
  `product_describe` text COMMENT '医疗产品说明',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of products
-- ----------------------------
BEGIN;
INSERT INTO `products` (`product_id`, `product_name`, `product_describe`) VALUES (1, '电子血压计', '电子血压计优点一般包括准确性高、易于读取、有记录功能、使用方便。  \n1、准确性高：电子血压计是一种使用电子技术来测量血压的仪器。电子血压计采用先进的传感器技术，能够提供准确的血压测量结果，并且具有较低的误差率。  \n2、易于读取：电子血压计通常配备了数字显示屏，直观地显示测量结果，使患者更容易读取血压数值。  \n3、有记录功能：电子血压计具有内置的存储功能，可以记录多次测量结果，并提供时间和日期，方便患者对血压变化跟踪和监测。  \n4、使用方便：在没有医护陪同的情况下，在家自行操作也是可以的，有高血压的患者可以随时检测血压值。  日常生活中，应该注意饮食以清淡为主，避免吃含脂肪量多的食物，如动物内脏、肥肉、油炸食品等。若出现不适症状，应及时前往医院检查明确具体病因，并选择合适的治疗方式，促进病情恢复。');
INSERT INTO `products` (`product_id`, `product_name`, `product_describe`) VALUES (2, '家用呼吸机', '家用呼吸机有改善血氧含量、维持呼吸、降低经济压力，坏处有产生依赖性、损伤呼吸道黏膜等好处。 \n1、改善血氧含量：家用呼吸机是通过正压通气手段，达到辅助通气效果的仪器，长期使用家用呼吸机，可以辅助维持人体的正常呼吸，改善气体交换，从而使血氧含量保持在相对稳定的水平。  \n2、维持呼吸：对于阻塞性睡眠呼吸暂停低通气综合征的患者，或呼吸肌无力而无法自主呼吸的患者，可以长期用家用呼吸机维持呼吸，避免因呼吸暂停而影响生命安全。  \n3、降低经济压力：家用呼吸机相对廉价，相对于前往医院使用专业的呼吸机而言，长期在家自行使用家用呼吸机，可以降低患者的经济压力，同时家用呼吸机使用较为方便，可以节省患者的时间和精力。');
INSERT INTO `products` (`product_id`, `product_name`, `product_describe`) VALUES (3, '电子体温计', '1. 使用方便：电子体温计操作简单，只需将探头插入口腔或肛门即可准确测量体温，非常适合自己家庭使用。 \n2. 准确度高：电子体温计使用数字显示屏，能够精确显示体温，相对于普通水银体温计更为准确。此外，现代电子体温计还带有温度记忆功能，能够保存之前的体温数据，方便医生或病人进行观察。 \n3. 卫生安全：由于电子体温计不使用水银，因此可以避免水银意外泄漏造成污染和伤害，具有更高的安全性和卫生性。');
COMMIT;

-- ----------------------------
-- Table structure for qas
-- ----------------------------
DROP TABLE IF EXISTS `qas`;
CREATE TABLE `qas` (
  `qa_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '在线咨询id',
  `qa_title` varchar(255) DEFAULT NULL COMMENT '在线咨询标题',
  `qa_history` text COMMENT '在线咨询记录',
  `p_id` int(11) DEFAULT NULL COMMENT '病患id',
  `p_name` varchar(255) DEFAULT NULL COMMENT '病患名称',
  `d_id` int(11) DEFAULT NULL COMMENT '医生id',
  `d_name` varchar(255) DEFAULT NULL COMMENT '医生名称',
  PRIMARY KEY (`qa_id`) USING BTREE,
  KEY `bTOp` (`p_id`) USING BTREE,
  KEY `bTOd` (`d_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of qas
-- ----------------------------
BEGIN;
INSERT INTO `qas` (`qa_id`, `qa_title`, `qa_history`, `p_id`, `p_name`, `d_id`, `d_name`) VALUES (1, '头疼，身体发冷', '【徐先生】2024-05-01 00:54:15\n  您好，医生，我头疼两天了，不知道该怎么办？\n\n【张医生】2024-05-01 00:54:34\n  你这两天有着凉吗？\n\n【徐先生】2024-05-01 00:55:05\n  有，前天下了很大的雨，回家的时候淋了一路，到家后还打了很多次喷嚏。\n\n', 2000, '徐先生', 1000, '张医生');
INSERT INTO `qas` (`qa_id`, `qa_title`, `qa_history`, `p_id`, `p_name`, `d_id`, `d_name`) VALUES (2, '发烧了', '【徐先生】2024-05-10 13:04:20\n  发烧了怎么办\n\n【张医生】2024-05-10 13:05:55\n  吃布洛芬\n\n', 2000, '徐先生', 1000, '张医生');
INSERT INTO `qas` (`qa_id`, `qa_title`, `qa_history`, `p_id`, `p_name`, `d_id`, `d_name`) VALUES (3, '感冒', '【徐先生】2024-05-11 15:04:52\n  感冒了，嗓子疼怎么办\n\n', 2000, '徐先生', -1, '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
