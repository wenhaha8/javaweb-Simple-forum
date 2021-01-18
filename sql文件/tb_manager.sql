/*
 Navicat Premium Data Transfer

 Source Server         : javaWeb-2020秋
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/01/2021 16:35:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager`  (
  `managerId` int NOT NULL AUTO_INCREMENT,
  `managerName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `lastLoginTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `thisLoginTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`managerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES (1, 'wenhao', '123456', '2021-01-11 15:35:54', NULL);
INSERT INTO `tb_manager` VALUES (2, '2', '2', '2020-12-27 18:00:32', NULL);

SET FOREIGN_KEY_CHECKS = 1;
