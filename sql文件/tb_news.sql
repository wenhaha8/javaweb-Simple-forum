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

 Date: 11/01/2021 16:35:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news`  (
  `newsId` int NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `theme` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主题',
  `content` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主要内容',
  `photoUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片路径',
  `newsTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发帖时间',
  `userId` int NULL DEFAULT NULL COMMENT '用户id',
  `priseNum` int NULL DEFAULT NULL COMMENT '获赞数',
  `excellent` int NULL DEFAULT 0 COMMENT '精华帖标志',
  `top` int NOT NULL DEFAULT 0 COMMENT '置顶标志',
  PRIMARY KEY (`newsId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `tb_news_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news` VALUES (1, '人生和青春', '我拥有的都是侥幸，我失去的都是人生。', 'xgh1.jpg', '2020-01-06 15:10:37', 1, 1, 1, 1);
INSERT INTO `tb_news` VALUES (2, '情话微甜', '世间的一切都可以靠努力，唯独', 'sf1.jpg', '2020-01-06 15:10:37', 2, NULL, 0, 1);
INSERT INTO `tb_news` VALUES (3, '情话微甜', '你像风来了又走，我的心满了又空。', 'sf1.jpg', '2020-01-06 15:10:37', 1, 2, 0, 0);
INSERT INTO `tb_news` VALUES (4, '情话微甜', '我不看月亮，也不说想你，这样月亮和你都蒙在鼓里。', 'mjj1.jpg', '2020-01-06 15:10:37', 4, NULL, 1, 0);
INSERT INTO `tb_news` VALUES (5, '情话微甜', '你不像任何人，因为', 'hyx1.jpg', '2020-01-06 15:10:37', 3, 100, 0, 0);
INSERT INTO `tb_news` VALUES (6, '代码意义', '\r\nclass DownServlet extends HttpServlet {\r\n    public void doGet(HttpServletRequest request, HttpServletResponse response)\r\n        throws ServletException, IOException {\r\n        response.setHeader(\"Content-Disposition\",\"attachment;filename=1.jpg\");\r\n        \r\n        FileInputStream in = new FileInputStream(this.getServletContext().getRealPath(\"1.jpg\"));\r\n        OutputStream out = response.getOutputStream();\r\n\r\n        byte[]bs = new byte[1024];\r\n        int i=0;\r\n        while ((i=in.read(bs))!=-1){\r\n                 out.write(bs,0,i);\r\n        }\r\n        in.close();\r\n    }\r\n以下代码怎么理解？？？？\r\nbyte[]bs = new byte[1024];\r\n        int i=0;\r\n        while ((i=in.read(bs))!=-1){\r\n                 out.write(bs,0,i);', 'sfxj.jpg', '2020-01-06 15:10:37', 3, NULL, 0, 0);
INSERT INTO `tb_news` VALUES (8, '情话微甜', '既见君子，云胡不喜。', '司凤璇玑.jpg', '2020-01-06 15:10:37', 1, 0, 1, 0);
INSERT INTO `tb_news` VALUES (9, '情话微甜', '一起淋过这场雪，此生已算共白头', '小雪人.png', '2020-01-06 15:10:37', 1, 0, 0, 0);
INSERT INTO `tb_news` VALUES (11, '情话微甜', '自尊告诉我“这不可能”，经验告诉我“这有风险”，情理告诉我“这毫无意义”，但内心却轻轻对自己说“试试看吧”和“我愿意”。这就是折磨人的爱吧。', 'fengmian.jpg', '2021-01-10 18:58:44', 1, 0, 1, 0);
INSERT INTO `tb_news` VALUES (25, '人生和青春', '七岁到十七岁之间有十年，十七岁到二十七岁之间有一生。', '李子维1.jpg', '2021-01-10 23:37:08', 1, 0, 0, 0);
INSERT INTO `tb_news` VALUES (26, '情话微甜', '我们所有的节日都不是为了礼物，而是为了提醒大家别忘了爱与被爱。而相处起来轻松的关系，才是最大的一份礼物。', 'fengmian.jpg', '2021-01-11 15:06:16', 1, 0, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
