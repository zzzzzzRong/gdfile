/*
SQLyog Trial v12.3.3 (64 bit)
MySQL - 5.5.40 : Database - mygd
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mygd` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mygd`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `admin` int(10) DEFAULT NULL COMMENT '用户标识：1管理员2委员会3定损员',
  `reserve` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `admin` */

/*Table structure for table `carloss` */

DROP TABLE IF EXISTS `carloss`;

CREATE TABLE `carloss` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车损编号',
  `loss_id` int(11) DEFAULT NULL COMMENT '定损编号',
  `insurance_id` int(11) DEFAULT NULL COMMENT '险别编号',
  `car_num` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `loss_unit` decimal(10,2) DEFAULT NULL COMMENT '定损单价',
  `loss_word` decimal(10,2) DEFAULT NULL COMMENT '定损工时',
  `loss_place` varchar(255) DEFAULT NULL COMMENT '定损地点',
  `loss_total` decimal(10,2) DEFAULT NULL COMMENT '定损小计',
  `loss_time` datetime DEFAULT NULL COMMENT '定损时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `carloss` */

/*Table structure for table `case` */

DROP TABLE IF EXISTS `case`;

CREATE TABLE `case` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '案件编号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `ins_id` int(11) DEFAULT NULL COMMENT '保单编号',
  `car_num` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `accident_time` datetime DEFAULT NULL COMMENT '出险时间',
  `accident_areaid` varchar(255) DEFAULT NULL COMMENT '出险地点',
  `cause` varchar(255) DEFAULT NULL COMMENT '不通过原因',
  `status_result` varchar(1) DEFAULT NULL COMMENT '案件状态：1立案，2撤案，3注销，4结案',
  `status_deal` varchar(1) DEFAULT NULL COMMENT '案件处理：1受理，2待定，3注销',
  `type` varchar(1) DEFAULT NULL COMMENT '案件进度：1审核中，2已受理，3定损中，4已提交到委员会，5理赔中，6审核不通过',
  `occur_time` datetime DEFAULT NULL COMMENT '报案时间',
  `review_id` int(11) DEFAULT NULL COMMENT '定损员编号',
  `review_name` varchar(255) DEFAULT NULL COMMENT '定损员名称',
  `committee_id` int(11) DEFAULT NULL COMMENT '委员会成员编号',
  `committee_name` varchar(255) DEFAULT NULL COMMENT '委员会成员姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `case` */

/*Table structure for table `claims` */

DROP TABLE IF EXISTS `claims`;

CREATE TABLE `claims` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '理赔编号',
  `survey_id` int(11) DEFAULT NULL COMMENT '查勘编号',
  `bank_account` varchar(255) DEFAULT NULL COMMENT '银行卡号',
  `benefi_man` varchar(255) DEFAULT NULL COMMENT '领取人',
  `claims_way` varchar(255) DEFAULT NULL COMMENT '理赔方式：1转账，2现金',
  `factcost_total` varchar(255) DEFAULT NULL COMMENT '实际赔付总金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `claims` */

/*Table structure for table `claims_options` */

DROP TABLE IF EXISTS `claims_options`;

CREATE TABLE `claims_options` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '理算编号',
  `iid` int(11) DEFAULT NULL COMMENT '险种编号',
  `claims_id` int(11) DEFAULT NULL COMMENT '理赔编号',
  `compen_amount` decimal(10,2) DEFAULT NULL COMMENT '赔偿金额',
  `insur_propo` double(2,1) DEFAULT NULL COMMENT '投保比例',
  `fee_price` decimal(10,2) DEFAULT NULL COMMENT '损失金额',
  `franchise` varchar(255) DEFAULT NULL COMMENT '事故责任免赔率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `claims_options` */

/*Table structure for table `document_type` */

DROP TABLE IF EXISTS `document_type`;

CREATE TABLE `document_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `document_type` */

insert  into `document_type`(`id`,`name`) values 
(1,'居民身份证'),
(2,'士官证'),
(3,'学生证'),
(4,'驾驶证'),
(5,'护照'),
(6,'港澳通行证');

/*Table structure for table `humanloss` */

DROP TABLE IF EXISTS `humanloss`;

CREATE TABLE `humanloss` (
  `id` int(11) DEFAULT NULL COMMENT '人损编号',
  `loss_id` int(11) DEFAULT NULL COMMENT '定损编号',
  `insurance_id` int(11) DEFAULT NULL COMMENT '险别编号',
  `name` varchar(11) DEFAULT NULL COMMENT '姓名',
  `injury_degree` varchar(255) DEFAULT NULL COMMENT '伤残程度',
  `loss_price` decimal(10,2) DEFAULT NULL COMMENT '定损金额',
  `cost_cate` varchar(255) DEFAULT NULL COMMENT '费用类别',
  `loss_place` decimal(10,2) DEFAULT NULL COMMENT '定损地点',
  `loss_time` datetime DEFAULT NULL COMMENT '定损时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `humanloss` */

/*Table structure for table `insurance` */

DROP TABLE IF EXISTS `insurance`;

CREATE TABLE `insurance` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '保险代码',
  `name` varchar(255) DEFAULT NULL COMMENT '险种名称',
  `parents_id` int(11) DEFAULT NULL COMMENT '父类险种',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `insurance` */

insert  into `insurance`(`id`,`name`,`parents_id`) values 
(1,'交强险',0),
(2,'商业险',0),
(3,'基本险',2),
(4,'附加险',2),
(5,'机动车损失险',3),
(6,'第三者责任保险',3),
(7,'车上人员责任险(司机)',3),
(8,'车上人员附加险(所有)',3),
(9,'机动车损失险',3),
(10,'玻璃单独险',4),
(11,'车身划痕损失险',4),
(12,'自然损失险',4),
(13,'不计免赔特约险',4);

/*Table structure for table `insurancepolicy` */

DROP TABLE IF EXISTS `insurancepolicy`;

CREATE TABLE `insurancepolicy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '保单编号',
  `pholder_id` int(11) DEFAULT NULL COMMENT '投保人编号',
  `insured_id` int(11) DEFAULT NULL COMMENT '被保人编号',
  `mark_id` int(11) DEFAULT NULL COMMENT '标的编号',
  `iid` int(11) DEFAULT NULL COMMENT '险种编号',
  `insured_time` varchar(255) DEFAULT NULL COMMENT '投保时间',
  `begin_time` varchar(255) DEFAULT NULL COMMENT '起保日期',
  `end_time` varchar(255) DEFAULT NULL COMMENT '终止日期',
  `type` varchar(1) DEFAULT NULL COMMENT '保单类型：1新保，2续保',
  `status` varchar(1) DEFAULT NULL COMMENT '保单状态：1保期内，2退保，3注销',
  `losstime` varchar(2) DEFAULT NULL COMMENT '理赔次数,决定保费费用',
  `itype_name` varchar(255) DEFAULT NULL COMMENT '险种名称',
  `ll_price` decimal(10,2) DEFAULT NULL COMMENT '投保金额/责任限额',
  `insured_price` decimal(10,2) DEFAULT NULL COMMENT '保费金额',
  `pay_time` datetime DEFAULT NULL COMMENT '缴费时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `insurancepolicy` */

/*Table structure for table `insured` */

DROP TABLE IF EXISTS `insured`;

CREATE TABLE `insured` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '被保人编号',
  `pholder_id` int(11) DEFAULT NULL COMMENT '投保人编号',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `document_type_id` int(11) DEFAULT NULL COMMENT '证件类型',
  `document_num` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `bank_account` varchar(255) DEFAULT NULL COMMENT '银行账号',
  `phone_num` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `dlicense_num` varchar(255) DEFAULT NULL COMMENT '驾驶证号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `insured` */

/*Table structure for table `loss` */

DROP TABLE IF EXISTS `loss`;

CREATE TABLE `loss` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '定损编号',
  `cases_id` int(11) DEFAULT NULL COMMENT '报案编号',
  `inspolicy_id` int(11) DEFAULT NULL COMMENT '保单编号',
  `review_id` int(11) DEFAULT NULL COMMENT '委员会成员编号',
  `survey_id` int(11) DEFAULT NULL COMMENT '查勘编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `loss` */

/*Table structure for table `mark` */

DROP TABLE IF EXISTS `mark`;

CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标的编号',
  `car_type_id` int(11) DEFAULT NULL COMMENT '机动车类型编号',
  `car_used_time` varchar(255) DEFAULT NULL COMMENT '车辆使用年限',
  `car_num` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `car_color` varchar(255) DEFAULT NULL COMMENT '车辆颜色',
  `car_drive_dist` varchar(255) DEFAULT NULL COMMENT '已行驶路程',
  `car_engine_num` varchar(255) DEFAULT NULL COMMENT '发动机型号',
  `car_brand_models` varchar(255) DEFAULT NULL COMMENT '厂牌型号',
  `car_mfac_date` datetime DEFAULT NULL COMMENT '出厂日期',
  `car_emissions` varchar(255) DEFAULT NULL COMMENT '排量',
  `car_power` varchar(255) DEFAULT NULL COMMENT '功率',
  `car_vlicense` varchar(255) DEFAULT NULL COMMENT '车辆行驶证',
  `car_newbuy` varchar(255) DEFAULT NULL COMMENT '新车购置价',
  `car_seat` varchar(2) DEFAULT NULL COMMENT '核定载客数',
  `car_ownname` varchar(255) DEFAULT NULL COMMENT '车主姓名',
  `car_vin` varchar(255) DEFAULT NULL COMMENT '车架号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mark` */

/*Table structure for table `policyholder` */

DROP TABLE IF EXISTS `policyholder`;

CREATE TABLE `policyholder` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投保人编号',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `document_type_id` int(11) DEFAULT NULL COMMENT '证件类型',
  `document_num` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `phone_num` varchar(255) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `policyholder` */

/*Table structure for table `survey` */

DROP TABLE IF EXISTS `survey`;

CREATE TABLE `survey` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '查勘编号',
  `survey_time` datetime DEFAULT NULL COMMENT '查勘时间',
  `survey_location` varchar(255) DEFAULT NULL COMMENT '查勘地点',
  `accident_type` varchar(255) DEFAULT NULL COMMENT '事故类型：1单方事故，2双方事故，3多方事故',
  `accident_liability` varchar(255) DEFAULT NULL COMMENT '责任判断：1全部责任，2主要责任，3同等责任，4次要责任，5无责任',
  `accident_liability_proportion` varchar(255) DEFAULT NULL COMMENT '责任比例',
  `accident_time` datetime DEFAULT NULL COMMENT '出险时间',
  `occur_time` datetime DEFAULT NULL COMMENT '报案时间',
  `phone_num` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `province` varchar(255) DEFAULT NULL COMMENT '出险所在省/直辖市',
  `city` varchar(255) DEFAULT NULL COMMENT '出险所在市',
  `county` varchar(255) DEFAULT NULL COMMENT '出险所在县/区',
  `road` varchar(255) DEFAULT NULL COMMENT '出险所在路段',
  `addident_road_type` varchar(255) DEFAULT NULL COMMENT '出险区域类型',
  `survey_options` varchar(255) DEFAULT NULL COMMENT '查勘意见',
  `accident_after` varchar(255) DEFAULT NULL COMMENT '出险经过',
  `damage` varchar(255) DEFAULT NULL COMMENT '损失情况',
  `accident_surface` varchar(255) DEFAULT NULL COMMENT '汽车事故面',
  `drive_license` varchar(255) DEFAULT NULL COMMENT '驾驶证',
  `vehicle_license` varchar(255) DEFAULT NULL COMMENT '行驶证',
  `car_vin` varchar(255) DEFAULT NULL COMMENT '车架号',
  `car_engine_num` varchar(255) DEFAULT NULL COMMENT '发动机号',
  `site_location` varchar(255) DEFAULT NULL COMMENT '现场方位',
  `loss_whole` varchar(255) DEFAULT NULL COMMENT '损失全貌',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `survey` */

/*Table structure for table `thingsloss` */

DROP TABLE IF EXISTS `thingsloss`;

CREATE TABLE `thingsloss` (
  `id` int(11) DEFAULT NULL COMMENT '物损编号',
  `loss_id` int(11) DEFAULT NULL COMMENT '定损编号',
  `insurance_id` int(11) DEFAULT NULL COMMENT '险别编号',
  `name` varchar(255) DEFAULT NULL COMMENT '物品名称',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `loss_unit` decimal(10,2) DEFAULT NULL COMMENT '定损单价',
  `loss_place` varchar(255) DEFAULT NULL COMMENT '定损地点',
  `loss_total` decimal(10,2) DEFAULT NULL COMMENT '定损小计',
  `loss_time` datetime DEFAULT NULL COMMENT '定损时间',
  `loss_rate` varchar(255) DEFAULT NULL COMMENT '损失程度'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `thingsloss` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `account` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `hometown` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '籍贯',
  `birthday` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '生日',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭住址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

/*Table structure for table `vehicle` */

DROP TABLE IF EXISTS `vehicle`;

CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机动车编号',
  `name` varchar(255) DEFAULT NULL COMMENT '机动车名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `vehicle` */

insert  into `vehicle`(`id`,`name`) values 
(1,'大型汽车'),
(2,'小型汽车'),
(3,'专用汽车'),
(4,'特种车'),
(5,'有轨电车'),
(6,'无轨电车'),
(7,'电瓶车'),
(8,'三轮摩托车'),
(9,'二轮摩托车'),
(10,'轻便摩托车'),
(11,'四轮农用运输车'),
(12,'三轮农用运输车'),
(13,'大型方向盘式拖拉机'),
(14,'小型方向盘式拖拉机'),
(15,'手扶拖拉机'),
(16,'轮式自行专用机械'),
(17,'全挂车'),
(18,'半挂车');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
