/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.22 : Database - dandp2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dandp2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `dandp2`;

/*Table structure for table `t_case` */

DROP TABLE IF EXISTS `t_case`;

CREATE TABLE `t_case` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `patients_id` int DEFAULT NULL COMMENT '患者id',
  `doctor_id` int DEFAULT NULL COMMENT '医生id',
  `remake` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '病例详情',
  `recipe` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '处方信息',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='病例表';

/*Data for the table `t_case` */

insert  into `t_case`(`id`,`patients_id`,`doctor_id`,`remake`,`recipe`,`create_time`,`modify_time`) values 
(36,96,86,'小孩肾不好呀','没得治没得治','2021-07-08 22:04:44','2021-07-08 22:15:53'),
(37,96,86,'小孩肾有问题','有的治有的治，快住院吧','2021-07-08 22:04:44','2021-07-08 22:17:38'),
(38,96,86,'胃痛','吃多了撑的','2021-07-08 22:22:12','2021-07-08 22:22:51');

/*Table structure for table `t_department` */

DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `dep_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '科室名',
  `letter` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '医院编号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='医院科室表';

/*Data for the table `t_department` */

insert  into `t_department`(`id`,`dep_name`,`letter`,`create_time`,`modify_time`) values 
(1,'内科','A','2021-06-29 11:44:40','2021-06-29 11:44:40'),
(2,'外科','B','2021-07-03 11:22:25','2021-07-03 11:22:25'),
(3,'妇科','C','2021-07-08 20:04:57','2021-07-08 20:06:08'),
(5,'儿科','D','2021-07-06 20:06:33','2021-07-06 20:06:43');

/*Table structure for table `t_questions` */

DROP TABLE IF EXISTS `t_questions`;

CREATE TABLE `t_questions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '问题/回复',
  `parent_id` int DEFAULT NULL COMMENT '问题id',
  `doctor_id` int DEFAULT NULL COMMENT '医生Id',
  `patient_id` int DEFAULT NULL COMMENT '问题所属患者id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='问答表';

/*Data for the table `t_questions` */

insert  into `t_questions`(`id`,`title`,`parent_id`,`doctor_id`,`patient_id`,`create_time`,`modify_time`) values 
(3,'睡不着咋办？？',NULL,NULL,90,'2020-05-07 22:47:59','2020-05-07 22:47:59'),
(4,'回答测试',3,86,90,'2020-05-07 23:03:49','2020-05-07 23:03:49'),
(5,'此事件发生',3,86,90,'2020-05-07 23:06:15','2020-05-07 23:06:15'),
(6,'测试',3,86,90,'2020-05-07 23:31:36','2020-05-07 23:31:36'),
(11,'我肚子痛',NULL,NULL,96,'2021-07-07 09:01:35','2021-07-07 09:01:35'),
(12,'让你痛，女孩子就是用来痛的',11,95,96,'2021-07-07 09:08:00','2021-07-07 09:08:00'),
(13,'痛死去吧，西内',11,86,96,'2021-07-07 09:15:10','2021-07-07 09:15:10'),
(14,'嗑药',3,86,90,'2021-07-07 12:24:05','2021-07-07 12:24:05'),
(22,'一支穿云箭',3,89,90,'2021-07-07 15:53:01','2021-07-07 15:53:01'),
(23,'千军万马来相见',3,88,90,'2021-07-07 16:19:31','2021-07-07 16:19:31'),
(25,'怎么才能找到女朋友',NULL,NULL,96,'2021-07-07 20:46:01','2021-07-07 20:46:01'),
(26,'月入百万',25,89,96,'2021-07-07 20:46:47','2021-07-07 20:46:47'),
(27,'早点睡，梦里都有的',25,86,96,'2021-07-08 22:24:28','2021-07-08 22:24:28');

/*Table structure for table `t_registration` */

DROP TABLE IF EXISTS `t_registration`;

CREATE TABLE `t_registration` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '唯一编号',
  `time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '预约时间，默认为当前时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '挂号时间',
  `doctor_id` int DEFAULT NULL COMMENT '挂号医生',
  `patients_id` int DEFAULT NULL COMMENT '挂号患者Id',
  `status` int NOT NULL DEFAULT '0' COMMENT '0:未处理，1已处理',
  `evaluate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '满意，一般，不满意',
  `accept` int DEFAULT '0' COMMENT '状态，1为采纳，2为不采纳',
  `is_cases` tinyint(1) DEFAULT NULL COMMENT '是否需要病历本',
  `amount_payable` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '扫码支付' COMMENT '结算类型',
  `level` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '挂号级别',
  `is_invoice` tinyint(1) DEFAULT '0' COMMENT '是否开票',
  `invoice_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '发票代码',
  `invoice_number` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '发票号',
  `invoice_date` date DEFAULT NULL COMMENT '开票日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `t_registration_number_uindex` (`number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='挂号表';

/*Data for the table `t_registration` */

insert  into `t_registration`(`id`,`number`,`time`,`create_time`,`doctor_id`,`patients_id`,`status`,`evaluate`,`accept`,`is_cases`,`amount_payable`,`type`,`level`,`is_invoice`,`invoice_code`,`invoice_number`,`invoice_date`) values 
(32,'20210708A1','2021-07-08 22:04:27','2021-07-08 22:04:44',86,96,1,'好人',2,1,46.16,'扫码支付','高级',0,NULL,NULL,NULL),
(33,'20210708A2','2021-07-08 22:22:01','2021-07-08 22:22:12',86,96,1,'好的',1,1,76.26,'扫码支付','中级',0,NULL,NULL,NULL);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称/真实姓名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上次登录Ip',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近访问时间',
  `ssex` int DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '描述',
  `avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '/image/avatar/imDefaultAvatar.png' COMMENT '用户头像',
  `school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '医生毕业院校',
  `dep_id` int DEFAULT NULL COMMENT '医生科室Id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态 0锁定 1有效,默认为1',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `role_id` int NOT NULL COMMENT '角色，0微超级管理员，1为医生，2为患者',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `t_user_username_uindex` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户';

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`username`,`nick_name`,`password`,`email`,`mobile`,`last_login_ip`,`last_login_time`,`ssex`,`description`,`avatar`,`school`,`dep_id`,`create_time`,`modify_time`,`status`,`birthday`,`role_id`) values 
(44,'admin','admin','e10adc3949ba59abbe56e057f20f883e','one.dayinaug@gmail.com','13252082376','125.75.21.103','2020-05-08 00:12:23',0,'www.penint.vip','/image/avatar/2021/07/07/ab652cc1-42d3-4858-b9d2-a7fb6e2945da.jpg',NULL,NULL,'2020-05-06 11:29:00','2019-12-30 09:10:39',1,NULL,0),
(86,'d-keyi','医生科一','e10adc3949ba59abbe56e057f20f883e','123456@qq.com','13090909090','127.0.0.1','2020-05-07 23:19:29',0,'安徽医科大学硕士','/image/avatar/2021/07/08/77ffbfb5-e159-4ba4-a98d-7b69d1f7c948.jpg','安徽医科大学',1,'2020-05-05 11:36:18',NULL,1,'2020-05-24',1),
(88,'d-keer','医生科二','e10adc3949ba59abbe56e057f20f883e','123456@qq.com','13090901211',NULL,NULL,1,'无','/image/avatar/2021/07/08/098e6ca9-5494-46de-8e28-e8b1c7954c66.jpg','湖北师范大学',3,'2020-05-06 16:30:45',NULL,1,'2020-05-25',1),
(89,'d_kesan','医生科三','e10adc3949ba59abbe56e057f20f883e','123456@qq.com','18523456789','125.75.21.103','2020-05-08 00:11:45',0,'帅','/image/avatar/2021/07/08/1fb701c6-9ed3-4809-9753-843011b54d61.jpg','湖北师范大学',2,'2020-05-06 18:05:07',NULL,1,'2010-05-10',1),
(90,'p-kewu','病人科五','e10adc3949ba59abbe56e057f20f883e','123456@qq.com','13978564790','127.0.0.1','2020-05-07 23:50:55',0,NULL,'/image/avatar/2021/07/08/318d3271-2ad5-4c5a-893d-02a7d63dfac5.jpg',NULL,NULL,'2020-05-06 18:07:40',NULL,1,'2020-05-19',2),
(95,'d_kesi','医生科四','e10adc3949ba59abbe56e057f20f883e','123456@qq.com','13252082376',NULL,NULL,0,'平平无奇','/image/avatar/2021/07/08/0a73cb83-831f-4309-9e5b-e02b69f855c8.jpg','湖北师范大学',5,'2020-05-25 17:53:57',NULL,1,'2020-04-30',1),
(96,'p-keliu','病人科六','e10adc3949ba59abbe56e057f20f883e','123456@qq.com','13090901212',NULL,NULL,0,NULL,'/image/avatar/2021/07/08/26c45cde-1016-448a-939a-071293a797fa.jpg',NULL,NULL,'2020-07-02 10:40:53',NULL,1,'2010-08-12',2),
(97,'万一','管理员万一','e10adc3949ba59abbe56e057f20f883e','506579631@qq.com','13037277783',NULL,NULL,1,'我叫万一','/image/avatar/imDefaultAvatar.png',NULL,NULL,'2021-07-07 08:16:46',NULL,1,NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
