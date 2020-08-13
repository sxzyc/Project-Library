/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 13/08/2020 16:22:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('a', 'a', 1);
INSERT INTO `admin` VALUES ('admin', '4QrcOUm6Wau+VuBX8g+IPg==', 2);
INSERT INTO `admin` VALUES ('赵越超', '4QrcOUm6Wau+VuBX8g+IPg==', 3);

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bookName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bookTypeid` int(20) NULL DEFAULT NULL,
  `price` float NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  `publishDate` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduction` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bookPhoto` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKCB4C8FF4C78C387B`(`bookTypeid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 'TS001', '安卓Android程序设计', 1, 35.5, 12, '2013-07-03', '人民教育出版社', '这是一个介绍android系统的手机程序设计的书籍！', 'bbb4cd2ecc684ce9af1294d13ffcc5d0.jpg');
INSERT INTO `t_book` VALUES (2, 'TS002', 'html5网站设计', 1, 42.5, 18, '2013-10-23', '四川师范大学出版社', '介绍新的网站设计技术！', '597a7f0c35ba4fb39f9b6f706bdc980d.jpg');
INSERT INTO `t_book` VALUES (3, 'TS003', '中国近代史', 2, 19.5, 52, '2014-07-01', '成都理工大学出版社', '介绍中国近代史', '50b96640a5d442c8ad0038f9fcce2697.jpg');
INSERT INTO `t_book` VALUES (34, 'TS007', '其乐无穷的战斗', 3, 20, 30, '2020-04-02', '***********', '无', '8e9e4739451c48079282eeab043968ac.jpg');
INSERT INTO `t_book` VALUES (33, 'TS006', '做最好的自己', 3, 60, 50, '2020-04-06', '***********', '', '464a59da8b784fdb9345d0745990cd67.jpg');
INSERT INTO `t_book` VALUES (24, 'TS004', '淡定的力量', 3, 333, 33, '2020-04-04', '*****', '没有', '757eeba57da64b978714fb19ca8bd8d2.jpg');
INSERT INTO `t_book` VALUES (32, 'TS005', '曾国藩', 3, 30, 12, '2020-04-03', '*****', '无', '9cefe7682f3449cab2ad906aca765773.jpg');
INSERT INTO `t_book` VALUES (25, 'sdsdsddsdsdsdsdsd', '挂号费的后', 78888, 333, 999, '2020-04-05', '333', '44', 'ae8654ff1d814ee39376e29249f23366.jpg');
INSERT INTO `t_book` VALUES (27, 'hhhhhh', '挂号费的后uu', 333, 6666, 33, '2020-04-01', '666', '', '0d98dd6269014ccf955e77d529fef7a2.jpg');
INSERT INTO `t_book` VALUES (28, 'Tsssssssss', '666', 5, 88, 60, '2020-04-02', 't6666', '', '1ba43018f1854b5cb673da10650aedc5.jpg');
INSERT INTO `t_book` VALUES (29, '4444', '挂号费的后', 6666, 66.5, 555, '2020-04-05', 'ggg', '55', 'e02655664e7048979760e8bf9873a9c1.jpg');

-- ----------------------------
-- Table structure for t_booktype
-- ----------------------------
DROP TABLE IF EXISTS `t_booktype`;
CREATE TABLE `t_booktype`  (
  `bookTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `days` int(11) NOT NULL,
  PRIMARY KEY (`bookTypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_booktype
-- ----------------------------
INSERT INTO `t_booktype` VALUES (1, '计算机类', 35);
INSERT INTO `t_booktype` VALUES (2, '历史类', 25);
INSERT INTO `t_booktype` VALUES (3, '文学类', 20);

-- ----------------------------
-- Table structure for t_loaninfo
-- ----------------------------
DROP TABLE IF EXISTS `t_loaninfo`;
CREATE TABLE `t_loaninfo`  (
  `loadId` int(11) NOT NULL AUTO_INCREMENT,
  `book` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `borrowDate` date NULL DEFAULT NULL,
  `returnDate` date NULL DEFAULT NULL,
  `status` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`loadId`) USING BTREE,
  INDEX `FK29107D4923D05BDB`(`reader`) USING BTREE,
  INDEX `FK29107D49F442B167`(`book`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_loaninfo
-- ----------------------------
INSERT INTO `t_loaninfo` VALUES (1, 'TS001', 'DZ001', '2014-07-01', '2014-07-10', '借阅中', '赵老师');
INSERT INTO `t_loaninfo` VALUES (2, 'TS002', 'DZ002', '2014-07-01', '2014-07-15', '已归还', '赵越超2');
INSERT INTO `t_loaninfo` VALUES (6, '5555', '6666', '2019-12-05', '2019-12-08', '借阅中', '赵越超2');
INSERT INTO `t_loaninfo` VALUES (8, '5555', '6666', '2019-12-07', '2019-12-12', '已归还', '赵越超2');
INSERT INTO `t_loaninfo` VALUES (7, '5555', '曾国藩', '2019-12-13', '2019-12-11', '借阅中', '赵老师');
INSERT INTO `t_loaninfo` VALUES (9, '5555', '6666', '2019-12-05', '0000-00-00', '借阅中', '赵越超');
INSERT INTO `t_loaninfo` VALUES (10, '8999', '11111', '2020-04-04', '0000-00-00', '借阅中', '赵越超1');
INSERT INTO `t_loaninfo` VALUES (11, '98888', '9999', '2020-04-02', '0000-00-00', '已归还', '赵越超');

-- ----------------------------
-- Table structure for t_reader
-- ----------------------------
DROP TABLE IF EXISTS `t_reader`;
CREATE TABLE `t_reader`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `readerNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `readerType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `readerName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `readerPaw` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK4522970ECA9788EF`(`readerType`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_reader
-- ----------------------------
INSERT INTO `t_reader` VALUES (1, 'DZ001', '1', '赵老师', '4QrcOUm6Wau+VuBX8g+IPg==', '男', '123456', '123456@163.com', '123456', '*******', 'upload/c6c86f8b-d7a5-47b0-806b-d6ff536e6022.jpg');
INSERT INTO `t_reader` VALUES (2, 'DZ002', '3', '赵越超2', '4QrcOUm6Wau+VuBX8g+IPg==', '男', '123456789', '123456@163.com', '12345678', '**********', 'upload/fe62edd5-4bc0-4abd-b9a8-2c23ce1a8243.jpg');
INSERT INTO `t_reader` VALUES (5, 'DZ008', '3', '赵越超', '4QrcOUm6Wau+VuBX8g+IPg==', '女', '123456789', '123456789@qq.com', '123456789', '985', 'cccc');
INSERT INTO `t_reader` VALUES (6, 'DZ009', '3', '赵越超1', '4QrcOUm6Wau+VuBX8g+IPg==', '男', '18335067798', '14245651@qq.com', '123456', 'ssdsf', '');

-- ----------------------------
-- Table structure for t_readertype
-- ----------------------------
DROP TABLE IF EXISTS `t_readertype`;
CREATE TABLE `t_readertype`  (
  `readerTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `readerTypeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`readerTypeId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_readertype
-- ----------------------------
INSERT INTO `t_readertype` VALUES (1, '教师类', 5);
INSERT INTO `t_readertype` VALUES (2, '学生类', 3);

-- ----------------------------
-- Table structure for t_usertype
-- ----------------------------
DROP TABLE IF EXISTS `t_usertype`;
CREATE TABLE `t_usertype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userTypeName` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `power` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_usertype
-- ----------------------------
INSERT INTO `t_usertype` VALUES (1, '学生类', '2级');
INSERT INTO `t_usertype` VALUES (3, '老师类', '1级');

SET FOREIGN_KEY_CHECKS = 1;
