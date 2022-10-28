/*
 Navicat Premium Data Transfer

 Source Server         : JavaTribeSoftContest
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 175.178.7.180:3307
 Source Schema         : mark

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 24/10/2022 21:33:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for judge
-- ----------------------------
DROP TABLE IF EXISTS `judge`;
CREATE TABLE `judge`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `judgeName` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评委账号',
  `judgePassword` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'zwbl' COMMENT '登录密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of judge
-- ----------------------------
INSERT INTO `judge` VALUES (31, '黄嗣海', 'zwbl');
INSERT INTO `judge` VALUES (32, '陈洁琳', 'zwbl');
INSERT INTO `judge` VALUES (33, '汪代豪', 'zwbl');
INSERT INTO `judge` VALUES (34, '杨超旭', 'zwbl');
INSERT INTO `judge` VALUES (35, '冯远安', 'zwbl');
INSERT INTO `judge` VALUES (36, '陈雅楠', 'zwbl');
INSERT INTO `judge` VALUES (37, '李淑仪', 'zwbl');
INSERT INTO `judge` VALUES (38, '王维', 'zwbl');
INSERT INTO `judge` VALUES (39, '王腾坤', 'zwbl');
INSERT INTO `judge` VALUES (40, '吴彦臻', 'zwbl');
INSERT INTO `judge` VALUES (41, 'test1', 'zwbl');
INSERT INTO `judge` VALUES (42, 'test2', 'zwbl');
INSERT INTO `judge` VALUES (43, 'test3', 'zwbl');
INSERT INTO `judge` VALUES (44, 'test4', 'zwbl');
INSERT INTO `judge` VALUES (45, 'test5', 'zwbl');
INSERT INTO `judge` VALUES (46, 'test6', 'zwbl');
INSERT INTO `judge` VALUES (47, 'test7', 'zwbl');
INSERT INTO `judge` VALUES (48, 'test8', 'zwbl');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `judgeId` int NOT NULL COMMENT '评委id',
  `teamId` int NOT NULL COMMENT '队伍id',
  `marks` double(11, 0) NOT NULL COMMENT '打的分数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 326 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (124, 34, 1, 56);
INSERT INTO `score` VALUES (125, 40, 1, 40);
INSERT INTO `score` VALUES (126, 38, 1, 74);
INSERT INTO `score` VALUES (127, 37, 1, 52);
INSERT INTO `score` VALUES (128, 38, 2, 65);
INSERT INTO `score` VALUES (129, 34, 2, 64);
INSERT INTO `score` VALUES (130, 40, 2, 45);
INSERT INTO `score` VALUES (131, 33, 1, 65);
INSERT INTO `score` VALUES (132, 33, 3, 58);
INSERT INTO `score` VALUES (133, 39, 1, 44);
INSERT INTO `score` VALUES (134, 39, 2, 58);
INSERT INTO `score` VALUES (135, 33, 2, 72);
INSERT INTO `score` VALUES (136, 40, 3, 40);
INSERT INTO `score` VALUES (137, 34, 3, 45);
INSERT INTO `score` VALUES (138, 39, 3, 42);
INSERT INTO `score` VALUES (139, 38, 3, 63);
INSERT INTO `score` VALUES (140, 37, 2, 48);
INSERT INTO `score` VALUES (141, 37, 3, 47);
INSERT INTO `score` VALUES (142, 38, 4, 75);
INSERT INTO `score` VALUES (143, 37, 4, 79);
INSERT INTO `score` VALUES (144, 40, 4, 70);
INSERT INTO `score` VALUES (145, 33, 4, 73);
INSERT INTO `score` VALUES (146, 34, 4, 67);
INSERT INTO `score` VALUES (147, 33, 5, 57);
INSERT INTO `score` VALUES (148, 40, 5, 35);
INSERT INTO `score` VALUES (149, 38, 5, 50);
INSERT INTO `score` VALUES (150, 37, 5, 38);
INSERT INTO `score` VALUES (151, 39, 4, 52);
INSERT INTO `score` VALUES (152, 39, 5, 37);
INSERT INTO `score` VALUES (153, 34, 5, 47);
INSERT INTO `score` VALUES (154, 38, 6, 75);
INSERT INTO `score` VALUES (155, 33, 6, 77);
INSERT INTO `score` VALUES (156, 39, 6, 67);
INSERT INTO `score` VALUES (157, 37, 6, 70);
INSERT INTO `score` VALUES (158, 34, 6, 72);
INSERT INTO `score` VALUES (162, 39, 7, 41);
INSERT INTO `score` VALUES (163, 38, 7, 55);
INSERT INTO `score` VALUES (164, 37, 7, 67);
INSERT INTO `score` VALUES (165, 33, 7, 61);
INSERT INTO `score` VALUES (166, 40, 6, 60);
INSERT INTO `score` VALUES (167, 40, 7, 50);
INSERT INTO `score` VALUES (168, 34, 7, 60);
INSERT INTO `score` VALUES (169, 40, 8, 30);
INSERT INTO `score` VALUES (170, 33, 8, 52);
INSERT INTO `score` VALUES (171, 38, 8, 55);
INSERT INTO `score` VALUES (172, 37, 8, 46);
INSERT INTO `score` VALUES (173, 34, 8, 41);
INSERT INTO `score` VALUES (174, 39, 8, 45);
INSERT INTO `score` VALUES (175, 35, 1, 52);
INSERT INTO `score` VALUES (176, 35, 2, 52);
INSERT INTO `score` VALUES (177, 35, 3, 45);
INSERT INTO `score` VALUES (178, 35, 4, 50);
INSERT INTO `score` VALUES (179, 35, 5, 47);
INSERT INTO `score` VALUES (180, 35, 6, 74);
INSERT INTO `score` VALUES (181, 35, 7, 53);
INSERT INTO `score` VALUES (182, 35, 8, 53);
INSERT INTO `score` VALUES (183, 32, 1, 66);
INSERT INTO `score` VALUES (184, 32, 2, 72);
INSERT INTO `score` VALUES (185, 32, 3, 53);
INSERT INTO `score` VALUES (186, 32, 4, 74);
INSERT INTO `score` VALUES (187, 32, 5, 53);
INSERT INTO `score` VALUES (188, 32, 6, 80);
INSERT INTO `score` VALUES (189, 32, 7, 69);
INSERT INTO `score` VALUES (190, 32, 8, 62);
INSERT INTO `score` VALUES (191, 40, 9, 75);
INSERT INTO `score` VALUES (192, 38, 9, 90);
INSERT INTO `score` VALUES (193, 34, 9, 74);
INSERT INTO `score` VALUES (194, 39, 9, 67);
INSERT INTO `score` VALUES (195, 37, 9, 84);
INSERT INTO `score` VALUES (196, 33, 9, 82);
INSERT INTO `score` VALUES (197, 40, 10, 35);
INSERT INTO `score` VALUES (198, 39, 10, 38);
INSERT INTO `score` VALUES (199, 34, 10, 54);
INSERT INTO `score` VALUES (200, 37, 10, 58);
INSERT INTO `score` VALUES (201, 38, 10, 63);
INSERT INTO `score` VALUES (202, 33, 10, 65);
INSERT INTO `score` VALUES (203, 37, 11, 82);
INSERT INTO `score` VALUES (204, 33, 11, 82);
INSERT INTO `score` VALUES (205, 38, 11, 83);
INSERT INTO `score` VALUES (206, 39, 11, 79);
INSERT INTO `score` VALUES (207, 34, 11, 84);
INSERT INTO `score` VALUES (208, 40, 11, 55);
INSERT INTO `score` VALUES (209, 38, 12, 95);
INSERT INTO `score` VALUES (210, 39, 12, 95);
INSERT INTO `score` VALUES (211, 40, 12, 85);
INSERT INTO `score` VALUES (212, 33, 12, 82);
INSERT INTO `score` VALUES (213, 34, 12, 85);
INSERT INTO `score` VALUES (214, 37, 12, 88);
INSERT INTO `score` VALUES (215, 38, 13, 48);
INSERT INTO `score` VALUES (216, 33, 13, 60);
INSERT INTO `score` VALUES (217, 40, 13, 35);
INSERT INTO `score` VALUES (218, 34, 13, 41);
INSERT INTO `score` VALUES (219, 35, 9, 76);
INSERT INTO `score` VALUES (220, 35, 10, 53);
INSERT INTO `score` VALUES (221, 35, 11, 73);
INSERT INTO `score` VALUES (222, 35, 12, 86);
INSERT INTO `score` VALUES (223, 35, 13, 46);
INSERT INTO `score` VALUES (224, 37, 13, 36);
INSERT INTO `score` VALUES (225, 39, 13, 33);
INSERT INTO `score` VALUES (226, 40, 16, 45);
INSERT INTO `score` VALUES (227, 33, 16, 66);
INSERT INTO `score` VALUES (228, 38, 16, 46);
INSERT INTO `score` VALUES (229, 39, 16, 58);
INSERT INTO `score` VALUES (230, 34, 16, 62);
INSERT INTO `score` VALUES (231, 37, 16, 58);
INSERT INTO `score` VALUES (232, 38, 14, 95);
INSERT INTO `score` VALUES (233, 40, 14, 55);
INSERT INTO `score` VALUES (234, 33, 14, 75);
INSERT INTO `score` VALUES (235, 39, 14, 68);
INSERT INTO `score` VALUES (236, 34, 14, 69);
INSERT INTO `score` VALUES (237, 37, 14, 76);
INSERT INTO `score` VALUES (238, 34, 17, 52);
INSERT INTO `score` VALUES (239, 35, 14, 77);
INSERT INTO `score` VALUES (240, 39, 17, 41);
INSERT INTO `score` VALUES (241, 40, 17, 45);
INSERT INTO `score` VALUES (242, 35, 16, 60);
INSERT INTO `score` VALUES (243, 35, 17, 58);
INSERT INTO `score` VALUES (244, 38, 17, 60);
INSERT INTO `score` VALUES (245, 33, 17, 62);
INSERT INTO `score` VALUES (246, 40, 18, 65);
INSERT INTO `score` VALUES (247, 37, 17, 68);
INSERT INTO `score` VALUES (248, 34, 18, 70);
INSERT INTO `score` VALUES (249, 38, 18, 91);
INSERT INTO `score` VALUES (250, 39, 18, 75);
INSERT INTO `score` VALUES (251, 33, 18, 74);
INSERT INTO `score` VALUES (252, 35, 18, 74);
INSERT INTO `score` VALUES (253, 40, 19, 45);
INSERT INTO `score` VALUES (254, 37, 18, 77);
INSERT INTO `score` VALUES (255, 33, 19, 56);
INSERT INTO `score` VALUES (256, 39, 19, 36);
INSERT INTO `score` VALUES (257, 38, 19, 48);
INSERT INTO `score` VALUES (258, 34, 19, 41);
INSERT INTO `score` VALUES (259, 37, 19, 54);
INSERT INTO `score` VALUES (260, 35, 19, 50);
INSERT INTO `score` VALUES (261, 40, 20, 60);
INSERT INTO `score` VALUES (262, 37, 20, 81);
INSERT INTO `score` VALUES (263, 34, 20, 60);
INSERT INTO `score` VALUES (264, 35, 20, 56);
INSERT INTO `score` VALUES (265, 38, 20, 69);
INSERT INTO `score` VALUES (266, 33, 20, 73);
INSERT INTO `score` VALUES (267, 39, 20, 44);
INSERT INTO `score` VALUES (268, 32, 9, 79);
INSERT INTO `score` VALUES (269, 32, 10, 63);
INSERT INTO `score` VALUES (270, 32, 11, 81);
INSERT INTO `score` VALUES (271, 32, 12, 84);
INSERT INTO `score` VALUES (272, 32, 13, 45);
INSERT INTO `score` VALUES (273, 32, 14, 83);
INSERT INTO `score` VALUES (274, 32, 16, 68);
INSERT INTO `score` VALUES (275, 32, 17, 65);
INSERT INTO `score` VALUES (276, 32, 18, 80);
INSERT INTO `score` VALUES (277, 32, 19, 59);
INSERT INTO `score` VALUES (278, 32, 20, 73);
INSERT INTO `score` VALUES (279, 34, 21, 52);
INSERT INTO `score` VALUES (280, 33, 21, 66);
INSERT INTO `score` VALUES (281, 39, 21, 38);
INSERT INTO `score` VALUES (282, 37, 21, 58);
INSERT INTO `score` VALUES (283, 34, 22, 76);
INSERT INTO `score` VALUES (284, 39, 22, 53);
INSERT INTO `score` VALUES (285, 37, 22, 74);
INSERT INTO `score` VALUES (286, 33, 22, 66);
INSERT INTO `score` VALUES (287, 38, 21, 55);
INSERT INTO `score` VALUES (288, 38, 22, 62);
INSERT INTO `score` VALUES (289, 38, 23, 81);
INSERT INTO `score` VALUES (290, 37, 23, 76);
INSERT INTO `score` VALUES (291, 39, 23, 64);
INSERT INTO `score` VALUES (292, 34, 23, 67);
INSERT INTO `score` VALUES (293, 33, 23, 70);
INSERT INTO `score` VALUES (294, 38, 24, 73);
INSERT INTO `score` VALUES (295, 33, 24, 65);
INSERT INTO `score` VALUES (296, 37, 24, 59);
INSERT INTO `score` VALUES (297, 34, 24, 65);
INSERT INTO `score` VALUES (298, 39, 24, 61);
INSERT INTO `score` VALUES (299, 33, 25, 60);
INSERT INTO `score` VALUES (300, 38, 25, 59);
INSERT INTO `score` VALUES (301, 34, 25, 47);
INSERT INTO `score` VALUES (302, 37, 25, 52);
INSERT INTO `score` VALUES (303, 35, 25, 47);
INSERT INTO `score` VALUES (304, 35, 23, 75);
INSERT INTO `score` VALUES (305, 35, 22, 66);
INSERT INTO `score` VALUES (306, 38, 26, 61);
INSERT INTO `score` VALUES (307, 39, 25, 30);
INSERT INTO `score` VALUES (308, 33, 26, 68);
INSERT INTO `score` VALUES (309, 34, 26, 68);
INSERT INTO `score` VALUES (310, 35, 26, 57);
INSERT INTO `score` VALUES (311, 37, 26, 63);
INSERT INTO `score` VALUES (312, 35, 21, 57);
INSERT INTO `score` VALUES (313, 39, 26, 48);
INSERT INTO `score` VALUES (314, 32, 21, 74);
INSERT INTO `score` VALUES (315, 32, 22, 77);
INSERT INTO `score` VALUES (316, 32, 23, 78);
INSERT INTO `score` VALUES (317, 32, 24, 73);
INSERT INTO `score` VALUES (318, 32, 25, 59);
INSERT INTO `score` VALUES (319, 32, 26, 68);
INSERT INTO `score` VALUES (320, 40, 21, 50);
INSERT INTO `score` VALUES (321, 40, 22, 60);
INSERT INTO `score` VALUES (322, 40, 23, 70);
INSERT INTO `score` VALUES (323, 40, 24, 65);
INSERT INTO `score` VALUES (324, 40, 25, 40);
INSERT INTO `score` VALUES (325, 40, 26, 60);

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `teamName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '队伍名称',
  `teamStatus` int NULL DEFAULT 1 COMMENT '队伍状态，用于判断队伍是否已经上场',
  `canMark` tinyint NULL DEFAULT 1,
  `projectName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1120 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (1, '旺旺大队', 1, 0, '美淘');
INSERT INTO `team` VALUES (2, '领航队', 1, 0, '领航充电微信小程序');
INSERT INTO `team` VALUES (3, '浅设一下', 1, 0, '晓算法');
INSERT INTO `team` VALUES (4, '预备程序员', 1, 0, '音乐鸭网站');
INSERT INTO `team` VALUES (5, '乌漆嘛黑队', 1, 0, '快递跑跑');
INSERT INTO `team` VALUES (6, '从容应队', 1, 0, '遥集');
INSERT INTO `team` VALUES (7, '新手，我也不会', 1, 0, '易书');
INSERT INTO `team` VALUES (8, 'Sound of the silecing', 1, 0, '拾遗');
INSERT INTO `team` VALUES (9, 'Ferris', 1, 0, 'Vapp');
INSERT INTO `team` VALUES (10, '咱四一队', 1, 0, '广金失物招领');
INSERT INTO `team` VALUES (11, '发际线与我作队', 1, 0, '倒背如流');
INSERT INTO `team` VALUES (12, '带着bug去冒险', 1, 0, 'City Of Stars');
INSERT INTO `team` VALUES (13, '牛掌柜', 1, 0, '校园易');
INSERT INTO `team` VALUES (14, '易研为定', 1, 0, '易研为定');
INSERT INTO `team` VALUES (15, '动物朋友们', 1, 1, '动物朋友们');
INSERT INTO `team` VALUES (16, '软件设计小组', 1, 0, '友you小程序');
INSERT INTO `team` VALUES (17, '专业团队', 1, 0, '断舍狸');
INSERT INTO `team` VALUES (18, '脑子空空往前冲', 1, 0, '身心小窝');
INSERT INTO `team` VALUES (19, 'FlyOnMoon', 1, 0, '易万物');
INSERT INTO `team` VALUES (20, '冲冲冲单车变摩托', 1, 0, '学了个习');
INSERT INTO `team` VALUES (21, '畅通无阻', 1, 0, '校园互助');
INSERT INTO `team` VALUES (22, '旺仔牛奶', 1, 0, 'Plan&Random');
INSERT INTO `team` VALUES (23, '冒险家协会', 1, 0, '拾遗星球');
INSERT INTO `team` VALUES (24, '芝士软设', 1, 0, '综测平台');
INSERT INTO `team` VALUES (25, '磨叽先锋队', 1, 0, '留言吧');
INSERT INTO `team` VALUES (26, '一起做肝帝吗', 1, 0, '汇分');
INSERT INTO `team` VALUES (27, '起名困难队', 1, 1, '梨合');

SET FOREIGN_KEY_CHECKS = 1;
