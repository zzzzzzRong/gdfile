/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : insurance

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2020-04-09 09:36:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `admin` int(10) DEFAULT NULL COMMENT '用户标识：1管理员2委员会3定损员',
  `reserve` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '王宝强', '123456', '3', '');
INSERT INTO `admin` VALUES ('2', '张总', '123456', '2', null);
INSERT INTO `admin` VALUES ('3', 'admin', 'admin', '1', null);
INSERT INTO `admin` VALUES ('4', 'wangquan', '123456', '2', null);

-- ----------------------------
-- Table structure for cases
-- ----------------------------
DROP TABLE IF EXISTS `cases`;
CREATE TABLE `cases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `ins_id` int(11) DEFAULT NULL COMMENT '保单id',
  `mark_id` int(11) DEFAULT NULL COMMENT '标id',
  `accident_time` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '出险日期',
  `accident_areaid` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '出险地点',
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '报案人',
  `user_phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '报案人电话',
  `car_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '车型',
  `details` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详情',
  `type` int(255) DEFAULT NULL COMMENT '审核状态：1等待审核2定损中3审核通过4委员会填报信息5理赔成功6审核不通过',
  `cause` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '不通过原因',
  `review_id` int(11) DEFAULT NULL COMMENT '定损员id',
  `review_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '定损员姓名',
  `committee` int(11) DEFAULT NULL COMMENT '委员会id',
  `occur_time` datetime DEFAULT NULL COMMENT '报案时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cases
-- ----------------------------
INSERT INTO `cases` VALUES ('11', '4', '7', '6', '2020-02-24', '130102', '卢本伟', '123456', '轿车', '111111111111<img src=\"http://39.107.240.42:8080/img/s41582549329032.jpg\" alt=\"undefined\" style=\"display:inline-block;max-width:50%;height:auto\">', '10', null, '1', '王宝强', '2', '2020-02-24 21:05:50');
INSERT INTO `cases` VALUES ('14', '3', '6', '5', '2020-02-24', '110101', '李四', '123456', '轿车', '吊袜带<u>挖到无</u>', '5', '22222222', '1', '王宝强', null, '2020-02-24 21:18:36');
INSERT INTO `cases` VALUES ('15', '3', '6', '5', '2020-03-07', '110101', '李四', '12314896189', '轿车', '', '6', null, '1', '王宝强', '2', '2020-03-07 16:58:01');
INSERT INTO `cases` VALUES ('31', '5', '8', '7', '2020-03-07', '110101', '张三', '1984892989', '货车', '吊袜带挖到哇', '10', null, '1', '王宝强', '2', '2020-03-07 20:16:12');
INSERT INTO `cases` VALUES ('33', '6', '9', '8', '2020-03-07', '110101', '湖南', '15648615668', '货车', '<p style=\"text-align: center;\"><img src=\"http://182.92.209.239:8080/img/s41583585880161.jpg\" alt=\"undefined\" style=\"max-width: 50%; height: auto;\">后台和后台和</p>', '5', '不in是noise', '1', '王宝强', null, '2020-03-07 20:58:10');
INSERT INTO `cases` VALUES ('34', '6', '9', '8', '2020-03-27', '110101', '湖南', '156489298', '货车', '吊袜带挖到无', '10', null, '1', '王宝强', '2', '2020-03-07 21:00:43');
INSERT INTO `cases` VALUES ('35', '7', '10', '9', '2020-03-24', '430102', '王五', '11250709821', '货车', '请尽快处理', '10', null, '1', '王宝强', '2', '2020-03-24 13:42:17');
INSERT INTO `cases` VALUES ('36', '9', '17', '16', '2020-04-09', '430102', '陈八', '15115008403', '货车', '请尽快处理', '3', null, '1', '王宝强', null, '2020-04-06 23:23:43');

-- ----------------------------
-- Table structure for insurancepolicy
-- ----------------------------
DROP TABLE IF EXISTS `insurancepolicy`;
CREATE TABLE `insurancepolicy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '投保人编号',
  `insured_time` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '投保日期',
  `begin_time` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '起保日期',
  `end_time` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '终止日期',
  `channel` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '销售渠道',
  `Sales_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '业务员编号',
  `dispute` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '争议处理',
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '保险种类',
  `premium` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '保费',
  `reserve` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '预留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of insurancepolicy
-- ----------------------------
INSERT INTO `insurancepolicy` VALUES ('6', '3', '2020-02-24', '2020-02-24', '2020-02-24', '1', '1', '1111', '1', '1', null);
INSERT INTO `insurancepolicy` VALUES ('7', '4', '2020-02-24', '2020-02-24', '2020-02-24', '2', '2', '2', '2', '2', null);
INSERT INTO `insurancepolicy` VALUES ('8', '5', '2020-03-07', '2020-03-07', '2020-03-07', '2', '2', '2', '2', '2', null);
INSERT INTO `insurancepolicy` VALUES ('9', '6', '2020-03-07', '2020-03-07', '2020-03-07', '5', '5', '5', '5', '5', null);
INSERT INTO `insurancepolicy` VALUES ('10', '7', '2020-03-24', '2020-03-24', '2020-03-25', '1', '2', '11', '32', '22', null);
INSERT INTO `insurancepolicy` VALUES ('11', '7', '2020-03-24', '2020-03-24', '2020-03-25', '1', '2', '11', '32', '22', null);
INSERT INTO `insurancepolicy` VALUES ('12', '7', '2020-03-24', '2020-03-24', '2020-03-25', '1', '2', '11', '32', '22', null);
INSERT INTO `insurancepolicy` VALUES ('13', '7', '2020-03-24', '2020-03-24', '2020-03-25', '1', '2', '11', '32', '22', null);
INSERT INTO `insurancepolicy` VALUES ('14', '7', '2020-03-24', '2020-03-24', '2020-03-25', '1', '2', '11', '32', '22', null);
INSERT INTO `insurancepolicy` VALUES ('15', '7', '2020-03-24', '2020-03-24', '2020-03-25', '1', '2', '11', '32', '22', null);
INSERT INTO `insurancepolicy` VALUES ('16', '7', '2020-03-24', '2020-03-24', '2020-03-25', '1', '2', '11', '32', '22', null);
INSERT INTO `insurancepolicy` VALUES ('17', '9', '2020-04-07 00:00:00', '2020-04-08 00:00:00', '2020-04-10 00:00:00', '123', '123', '啊', '啊', '123', null);
INSERT INTO `insurancepolicy` VALUES ('18', '9', '2020-04-07 00:00:00', '2020-04-08 00:00:00', '2020-04-10 00:00:00', '123', '123', '啊', '啊', '123', null);
INSERT INTO `insurancepolicy` VALUES ('19', '9', '2020-04-07 00:00:00', '2020-04-08 00:00:00', '2020-04-10 00:00:00', '123', '123', '啊', '啊', '123', null);
INSERT INTO `insurancepolicy` VALUES ('20', '9', '2020-04-07 00:00:00', '2020-04-08 00:00:00', '2020-04-10 00:00:00', '123', '123', '啊', '啊', '123', null);
INSERT INTO `insurancepolicy` VALUES ('21', '9', '2020-04-07 00:00:00', '2020-04-08 00:00:00', '2020-04-10 00:00:00', '123', '123', '啊', '啊', '123', null);
INSERT INTO `insurancepolicy` VALUES ('22', '9', '2020-04-07 00:00:00', '2020-04-08 00:00:00', '2020-04-10 00:00:00', '123', '123', '啊', '啊', '123', null);
INSERT INTO `insurancepolicy` VALUES ('23', '9', '2020-04-07 00:00:00', '2020-04-08 00:00:00', '2020-04-10 00:00:00', '123', '123', '啊', '啊', '123', null);
INSERT INTO `insurancepolicy` VALUES ('24', '10', '2020-04-09 00:00:00', '2020-04-18 00:00:00', '2020-04-25 00:00:00', '4', '5', '1', '3', '2', null);
INSERT INTO `insurancepolicy` VALUES ('25', '10', '2020-04-09 00:00:00', '2020-04-18 00:00:00', '2020-04-25 00:00:00', '4', '5', '1', '3', '2', null);

-- ----------------------------
-- Table structure for loss
-- ----------------------------
DROP TABLE IF EXISTS `loss`;
CREATE TABLE `loss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cases_id` int(11) DEFAULT NULL COMMENT '报案单号',
  `user_id` int(11) DEFAULT NULL COMMENT '投保人编号',
  `accident_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '事故类型',
  `accident_liability` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '事故责任',
  `accident_liability_proportion` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '事故责任比例',
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '驾驶员姓名',
  `survey_time` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '查勘时间',
  `survey_location` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '查勘地点',
  `medical_price` decimal(10,2) DEFAULT NULL COMMENT '医疗费用',
  `repair_price` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '修车费用',
  `rescue_price` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '施救费用',
  `property_insurance` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '财产险应赔付费用',
  `liability_insurance` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '责任险应赔付费用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of loss
-- ----------------------------
INSERT INTO `loss` VALUES ('3', '11', '4', '意外', '无责任', '1/9', '卢本伟', '2020年', '湖南', '46552.00', '2000', '100', '5000', '10000');
INSERT INTO `loss` VALUES ('5', '31', '5', '意外', '16859', '165', '165', '165', '165', '165.00', '165', '1655', '165', '165');
INSERT INTO `loss` VALUES ('6', '34', '6', '车祸', '全责', '5', '5', '5', '5', '5.00', '5', '5', '5', '55827287');
INSERT INTO `loss` VALUES ('7', null, null, null, null, null, '王五', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insurance_id` int(11) NOT NULL COMMENT '保单编号',
  `user_id` int(11) NOT NULL COMMENT '投保人编号',
  `car_host` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '车主',
  `relationship` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '投保人与车辆关系',
  `car_number` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '车牌号',
  `car_engine` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发动机号',
  `car_frame` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '车架号',
  `car_model` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '厂牌车型',
  `car_seat` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '核定座位',
  `car_displacement` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '排量',
  `car_power` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '功率',
  `car_Fleet` int(11) DEFAULT NULL COMMENT '是否车队车辆',
  `nature` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '使用性质',
  `car_price` decimal(10,2) DEFAULT NULL COMMENT '购置价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES ('5', '6', '3', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1.00');
INSERT INTO `mark` VALUES ('6', '7', '4', '2', '2', '2', '2', '2', '2', '22', '2', '2', '2', '2', '2.00');
INSERT INTO `mark` VALUES ('7', '8', '5', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2.00');
INSERT INTO `mark` VALUES ('8', '9', '6', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5.00');
INSERT INTO `mark` VALUES ('9', '10', '7', '424', '456', '5456', '56', '54645', '54654', '564546', '54656', '654564', '45546', '54546', '5645.00');
INSERT INTO `mark` VALUES ('10', '11', '7', '424', '456', '5456', '56', '54645', '54654', '564546', '54656', '654564', '45546', '54546', '5645.00');
INSERT INTO `mark` VALUES ('11', '12', '7', '424', '456', '5456', '56', '54645', '54654', '564546', '54656', '654564', '45546', '54546', '5645.00');
INSERT INTO `mark` VALUES ('12', '13', '7', '424', '456', '5456', '56', '54645', '54654', '564546', '54656', '654564', '45546', '54546', '5645.00');
INSERT INTO `mark` VALUES ('13', '14', '7', '424', '456', '5456', '56', '54645', '54654', '564546', '54656', '654564', '45546', '54546', '5645.00');
INSERT INTO `mark` VALUES ('14', '15', '7', '424', '456', '5456', '56', '54645', '54654', '564546', '54656', '654564', '45546', '54546', '5645.00');
INSERT INTO `mark` VALUES ('15', '16', '7', '424', '456', '5456', '56', '54645', '54654', '564546', '54656', '654564', '45546', '54546', '5645.00');
INSERT INTO `mark` VALUES ('16', '17', '9', '1', '11', '3', '4', '5', '6', '7', '8', '9', '10', '2', '12.00');
INSERT INTO `mark` VALUES ('17', '18', '9', '1', '11', '3', '4', '5', '6', '7', '8', '9', '10', '2', '12.00');
INSERT INTO `mark` VALUES ('18', '19', '9', '1', '11', '3', '4', '5', '6', '7', '8', '9', '10', '2', '12.00');
INSERT INTO `mark` VALUES ('19', '20', '9', '1', '11', '3', '4', '5', '6', '7', '8', '9', '10', '2', '12.00');
INSERT INTO `mark` VALUES ('20', '21', '9', '1', '11', '3', '4', '5', '6', '7', '8', '9', '10', '2', '12.00');
INSERT INTO `mark` VALUES ('21', '22', '9', '1', '11', '3', '4', '5', '6', '7', '8', '9', '10', '2', '12.00');
INSERT INTO `mark` VALUES ('22', '23', '9', '1', '11', '3', '4', '5', '6', '7', '8', '9', '10', '2', '12.00');
INSERT INTO `mark` VALUES ('23', '24', '10', '1', '11', '3', '45', '5', '6', '7', '8', '9', '10', '2', '12.00');
INSERT INTO `mark` VALUES ('24', '25', '10', '1', '11', '3', '45', '5', '6', '7', '8', '9', '10', '2', '12.00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `hometown` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '籍贯',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭住址',
  `reserve` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '预留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '李四', '123456', '男', '湖南长沙', '2020-02-24 00:00:00', '湖南省长沙市雨花区', '可报案');
INSERT INTO `user` VALUES ('5', '张三', '123456', '女', '湖南郴州', '2020-03-07 00:00:00', '北京四合院', '可报案');
INSERT INTO `user` VALUES ('6', '湖南', '123456', '女', '湖南郴州', '2020-02-22 00:00:00', '湖南', '可报案');
INSERT INTO `user` VALUES ('7', '王五', '123456', '男', '湖南长沙', '2020-03-12 00:00:00', '湖南省长沙市', '可报案');
INSERT INTO `user` VALUES ('9', 'chenba', '123456', '男', '湖南岳阳', '1996-04-07 00:00:00', '湖南岳阳', '可报案');
INSERT INTO `user` VALUES ('10', 'wangjiu', '123456', '男', '湖南长沙', '1997-04-06 00:00:00', '湖南省岳阳市', '可报案');
