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

 Date: 11/01/2021 16:35:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_discussion
-- ----------------------------
DROP TABLE IF EXISTS `tb_discussion`;
CREATE TABLE `tb_discussion`  (
  `discussionId` int NOT NULL AUTO_INCREMENT,
  `newsId` int NULL DEFAULT NULL,
  `userId` int NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `beDisedUserNicename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `discussionTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`discussionId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `newsId`(`newsId`) USING BTREE,
  CONSTRAINT `tb_discussion_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_discussion_ibfk_3` FOREIGN KEY (`newsId`) REFERENCES `tb_news` (`newsId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_discussion
-- ----------------------------
INSERT INTO `tb_discussion` VALUES (1, 1, 1, '彩虹很忙', '', '风雨如晦，鸡鸣不已。', '2020-12-15 20:45:11');
INSERT INTO `tb_discussion` VALUES (2, 1, 2, '等鱼', '彩虹很忙', '既见君子，云胡不喜。', '2020-12-28 11:21:03');
INSERT INTO `tb_discussion` VALUES (3, 2, 3, '兔子警官', NULL, '爱了爱了', '2020-12-28 11:21:48');
INSERT INTO `tb_discussion` VALUES (4, 5, 4, '六月', NULL, '《二十首情诗和一首绝望的歌》', '2021-01-08 17:55:03');
INSERT INTO `tb_discussion` VALUES (9, 1, 1, '彩虹很忙', '', '张悬《关于我爱你》', '2021-01-08 10:28:55');
INSERT INTO `tb_discussion` VALUES (10, 2, 1, '彩虹很忙', '兔子警官', '唯独互相喜欢全凭运气', '2021-01-08 10:28:51');
INSERT INTO `tb_discussion` VALUES (13, 9, 4, '六月', '', '加油搞学习！', '2021-01-08 10:28:51');
INSERT INTO `tb_discussion` VALUES (14, 8, 1, '彩虹很忙', '', '我就写个评论而已', '2021-01-08 10:28:51');
INSERT INTO `tb_discussion` VALUES (15, 5, 1, '彩虹很忙', '六月', '666', '2021-01-08 10:28:51');
INSERT INTO `tb_discussion` VALUES (17, 5, 1, '彩虹很忙', '六月', '你怎么什么都知道', '2021-01-11 10:01:18');

SET FOREIGN_KEY_CHECKS = 1;
