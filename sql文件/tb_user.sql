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

 Date: 11/01/2021 16:35:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT '用户id-唯一标识',
  `userName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名-账号 用于登陆',
  `nickName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `isVip` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否是vip用户',
  `projectNum` int NULL DEFAULT NULL COMMENT '已有项目数',
  `reg_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `phoneNum` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `wrId` int NULL DEFAULT NULL COMMENT '工作室id',
  `headSculpture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像路径或者图片名',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `hobby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '爱好',
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `wrId`(`wrId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25842 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'wenhao', '彩虹很忙', '123456', 'true', 10, '2020-12-01 09:51:55', '15680765555', '2538063444@qq.com', 1, 'xgh1.jpg', NULL, NULL);
INSERT INTO `tb_user` VALUES (2, 'zhaojiale', '等鱼', '123456', 'false', 2, '2020-12-02 09:51:08', '18484522222', NULL, NULL, 'mjj1.jpg', NULL, NULL);
INSERT INTO `tb_user` VALUES (3, 'wangyuan', '兔子警官', '123456', 'true', 4, '2020-12-12 20:32:05', NULL, 'wangyuan@163.com', 1, 'mjj1.jpg', NULL, NULL);
INSERT INTO `tb_user` VALUES (4, 'chenyiyan', '六月', '123456', 'true', 13, '2021-01-08 15:51:04', NULL, NULL, 1, 'hyx1.jpg', NULL, NULL);
INSERT INTO `tb_user` VALUES (5, 'zenghelin', '眼神迷离', '123456', NULL, NULL, '2021-01-11 11:43:20', NULL, NULL, NULL, '司凤1.jpg', '男', NULL);

SET FOREIGN_KEY_CHECKS = 1;
