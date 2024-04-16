/*
 Navicat Premium Data Transfer

 Source Server         : one
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : itc

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 16/04/2024 11:25:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collectionp
-- ----------------------------
DROP TABLE IF EXISTS `collectionp`;
CREATE TABLE `collectionp`  (
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `postsid` int(11) NOT NULL COMMENT '帖子ID',
  PRIMARY KEY (`userid`, `postsid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collectionp
-- ----------------------------

-- ----------------------------
-- Table structure for collectionv
-- ----------------------------
DROP TABLE IF EXISTS `collectionv`;
CREATE TABLE `collectionv`  (
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `videoid` int(11) NOT NULL COMMENT '视频ID',
  PRIMARY KEY (`userid`, `videoid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collectionv
-- ----------------------------
INSERT INTO `collectionv` VALUES (1, 23);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '时间',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '类型',
  `itid` int(11) NOT NULL COMMENT '视频或帖子的ID',
  `userid` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`itid`, `userid`, `type`, `time`, `content`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for goodp
-- ----------------------------
DROP TABLE IF EXISTS `goodp`;
CREATE TABLE `goodp`  (
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `postsid` int(11) NOT NULL COMMENT '帖子ID',
  PRIMARY KEY (`userid`, `postsid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goodp
-- ----------------------------

-- ----------------------------
-- Table structure for goodv
-- ----------------------------
DROP TABLE IF EXISTS `goodv`;
CREATE TABLE `goodv`  (
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `videoid` int(11) NOT NULL COMMENT '视频ID',
  PRIMARY KEY (`userid`, `videoid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goodv
-- ----------------------------
INSERT INTO `goodv` VALUES (1, 23);
INSERT INTO `goodv` VALUES (2, 23);

-- ----------------------------
-- Table structure for headpicture
-- ----------------------------
DROP TABLE IF EXISTS `headpicture`;
CREATE TABLE `headpicture`  (
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `padress` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '头像地址',
  PRIMARY KEY (`userid`, `padress`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of headpicture
-- ----------------------------
INSERT INTO `headpicture` VALUES (1, '/static/headpicture/1.jpg');
INSERT INTO `headpicture` VALUES (2, '/static/headpicture/2.jpg');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '时间',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`time`, `title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('2022-12-13', '我们要注意这些垃圾的分类', '尤其是化妆品和药品的盒子');

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '时间',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `numgood` int(11) NULL DEFAULT NULL COMMENT '点赞数',
  `numcollection` int(11) NULL DEFAULT NULL COMMENT '收藏数',
  `userid` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`, `userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of posts
-- ----------------------------
INSERT INTO `posts` VALUES (10, '2024-04-07 21:56:02.719', '为什么要进行垃圾分类', '减少环境污染：垃圾分类可以减少有害垃圾对环境的污染。例如，废弃的电池等含有有毒物质，会对人类和环境造成严重危害，而垃圾分类可以将这些有害垃圾分离出来，进行特殊处理，避免对环境和人体造成危害。', 0, 0, 2);
INSERT INTO `posts` VALUES (11, '2024-04-07 21:57:37.802', '如何学习垃圾分类知识？', '1.请您主动关注垃圾分类宣传片、宣传手册等媒介，学习“生活垃圾分类”相关知识，做“生活垃圾分类”宣传员。\r\n2.认识各种颜色的垃圾桶的标志含义和所投放的不同类别的垃圾。\r\n3.请您在日常生活中做好垃圾分类投放，按照标识能对易腐垃圾、可回收物、有害垃圾以及其他垃圾进行正确投放。', 0, 0, 1);

-- ----------------------------
-- Table structure for trash
-- ----------------------------
DROP TABLE IF EXISTS `trash`;
CREATE TABLE `trash`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '垃圾名字',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '类型',
  `frequency` int(20) NOT NULL,
  PRIMARY KEY (`name`, `type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of trash
-- ----------------------------
INSERT INTO `trash` VALUES ('口罩', '其他垃圾', 3);
INSERT INTO `trash` VALUES ('塑料', '可回收垃圾', 33);
INSERT INTO `trash` VALUES ('烟头', '其他垃圾', 30);
INSERT INTO `trash` VALUES ('瓶子', '可回收垃圾', 10);
INSERT INTO `trash` VALUES ('电池', '有害垃圾', 27);
INSERT INTO `trash` VALUES ('纸箱', '可回收垃圾', 26);
INSERT INTO `trash` VALUES ('透明玻璃', '可回收垃圾', 3);
INSERT INTO `trash` VALUES ('金属', '可回收垃圾', 1);
INSERT INTO `trash` VALUES ('鞋子', '可回收垃圾', 1);
INSERT INTO `trash` VALUES ('食物', '厨余垃圾', 13);

-- ----------------------------
-- Table structure for trashcan
-- ----------------------------
DROP TABLE IF EXISTS `trashcan`;
CREATE TABLE `trashcan`  (
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `x` int(11) NOT NULL COMMENT 'x坐标',
  `y` int(11) NOT NULL COMMENT 'y坐标',
  PRIMARY KEY (`userid`, `x`, `y`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of trashcan
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `type` int(1) NOT NULL COMMENT '是否管理员1是0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '111', '男', 21, '1060837adad3@qq.com', 1);
INSERT INTO `user` VALUES (2, 'jxy', '123', '男', 21, '1060837933@qq.com', 1);
INSERT INTO `user` VALUES (3, 'wht', '123', '男', 21, NULL, 1);
INSERT INTO `user` VALUES (4, 'zsr', '123', '女', 21, '132131@qq.com', 1);
INSERT INTO `user` VALUES (5, 'lal', '123', '男', 21, 'admin@qq.com', 1);
INSERT INTO `user` VALUES (6, 'test', '111', '男', 22, '101101@qq.com', 1);
INSERT INTO `user` VALUES (7, 'Zhu', '123', '男', 20, '1060837933@qq.com', 1);
INSERT INTO `user` VALUES (8, 'test', '123', '', 22, '101@qq.com', 0);
INSERT INTO `user` VALUES (10, 'test2', '123', '女', 22, '123123eq@qq.com', 0);
INSERT INTO `user` VALUES (11, 'ggg', '123456', '男', 22, '1594913661@qq.com', 0);
INSERT INTO `user` VALUES (12, 'test111', '111', NULL, NULL, '10333@qq.com', 0);

-- ----------------------------
-- Table structure for user_trash
-- ----------------------------
DROP TABLE IF EXISTS `user_trash`;
CREATE TABLE `user_trash`  (
  `userid` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `trashname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `trashtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `frequency` int(20) NOT NULL,
  PRIMARY KEY (`userid`, `username`, `trashname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_trash
-- ----------------------------
INSERT INTO `user_trash` VALUES (1, 'admin', '塑料', '可回收垃圾', 8);
INSERT INTO `user_trash` VALUES (1, 'admin', '烟头', '其他垃圾', 2);
INSERT INTO `user_trash` VALUES (1, 'admin', '瓶子', '可回收垃圾', 10);
INSERT INTO `user_trash` VALUES (1, 'admin', '电池', '有害垃圾', 5);
INSERT INTO `user_trash` VALUES (1, 'admin', '纸箱', '可回收垃圾', 7);
INSERT INTO `user_trash` VALUES (1, 'admin', '食物', '厨余垃圾', 4);
INSERT INTO `user_trash` VALUES (2, 'jxy', '口罩', '其他垃圾', 1);
INSERT INTO `user_trash` VALUES (2, 'jxy', '电池', '有害垃圾', 2);
INSERT INTO `user_trash` VALUES (2, 'jxy', '纸箱', '可回收垃圾', 1);
INSERT INTO `user_trash` VALUES (2, 'jxy', '金属', '可回收垃圾', 1);
INSERT INTO `user_trash` VALUES (2, 'jxy', '鞋子', '可回收垃圾', 1);
INSERT INTO `user_trash` VALUES (2, 'jxy', '食物', '厨余垃圾', 1);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `titleOrig` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `titleAlter` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `numgood` int(11) NULL DEFAULT NULL,
  `numcollection` int(11) NULL DEFAULT NULL,
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `uploadtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`fileId`, `userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (23, '/static/video/cover/72641712497879338.jpg', 'League of Legends 2024.04.04 - 17.45.53.01 00_01_02-00_01_34', '72641712497879338', '洛的科目二测试', 2, 1, '27.87MB', '.mp4', 'video/2/72641712497879338.mp4', '2024-04-07 21:51:19', 2);

SET FOREIGN_KEY_CHECKS = 1;
