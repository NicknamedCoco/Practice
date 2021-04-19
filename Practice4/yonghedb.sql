`tb_order`/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : yonghedb

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-02-07 11:06:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_door
-- ----------------------------
DROP TABLE IF EXISTS `tb_door`;
CREATE TABLE `tb_door` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  `tel` VARCHAR(100) DEFAULT NULL,
  `addr` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_door
-- ----------------------------
INSERT INTO `tb_door` VALUES ('1', '永和大王(北三环西路店)', '010-6211231', '北三环西路甲18号院-1号大钟寺中坤广场d座');
INSERT INTO `tb_door` VALUES ('2', '永和大王(知春路店)', '010-82356537', '知春路29号大运金都');
INSERT INTO `tb_door` VALUES ('3', '永和大王(东直门)', '010-84477746', '东直门外大街48号东方银座b2-08');
INSERT INTO `tb_door` VALUES ('4', '永和大王(北京站)', '010-65286602', '毛家湾胡同甲13号北京站候车大厅2层');
INSERT INTO `tb_door` VALUES ('5', '永和大王(学院路店)', '010-62152539', '学院南路37号超市发四道口店四道口西北角');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `door_id` INT(11) DEFAULT NULL,
  `order_no` VARCHAR(50) DEFAULT NULL,
  `order_type` VARCHAR(50) DEFAULT NULL,
  `pnum` INT(11) DEFAULT NULL,
  `cashier` VARCHAR(50) DEFAULT NULL,
  `order_time` TIMESTAMP NOT NULL ,
  `pay_time` TIMESTAMP NOT NULL  ,
  `pay_type` VARCHAR(50) DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `door_id` (`door_id`),
  CONSTRAINT `tb_order_ibfk_1` FOREIGN KEY (`door_id`) REFERENCES `tb_door` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1', '1', 'P001', '堂食', '1', '张三', '2021-02-07 14:49:07', '2021-02-07 14:50:38', '微信支付', '16');
INSERT INTO `tb_order` VALUES ('2', '1', 'P003', '外卖', '3', '张三', '2021-02-06 13:34:07', '2021-02-06 13:34:38', '微信支付', '20');
INSERT INTO `tb_order` VALUES ('3', '1', 'P005', '打包', '1', '张三', '2021-02-06 11:59:22', '2021-02-06 11:59:22', '微信支付', '28');
INSERT INTO `tb_order` VALUES ('4', '1', 'P007', '堂食', '1', '李四', '2021-02-06 13:01:26', '2021-02-06 13:01:26', '微信支付', '49');
INSERT INTO `tb_order` VALUES ('6', '1', 'hbnu001', '堂食', '2', '陈迪凯', '2021-02-07 02:49:03', '2021-02-07 02:49:03', '微信支付', '50');

