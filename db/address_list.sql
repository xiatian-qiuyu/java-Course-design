/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : address_list

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 29/12/2021 18:42:49
*/

CREATE DATABASE Address_list_system;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for flist
-- ----------------------------
DROP TABLE IF EXISTS `flist`;
CREATE TABLE `flist`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `UserId` int NULL DEFAULT NULL,
  `GName` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `FSex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `FName` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `FBirthday` date NOT NULL,
  `FPhone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Fid` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of flist
-- ----------------------------
INSERT INTO `flist` VALUES (5, 5, '特别关心', '女', '刁丹萌', '2003-11-07', '13447754498', 5);
INSERT INTO `flist` VALUES (6, 5, '特别关心', '男', '谭青丞', '2003-11-07', '13853095516', 6);
INSERT INTO `flist` VALUES (8, 5, '特别关心', '男', '贾月', '2003-11-07', '18264862087', 8);
INSERT INTO `flist` VALUES (9, 5, '特别关心', '女', '郝佩迅', '2003-11-07', '15511989780', 9);
INSERT INTO `flist` VALUES (14, 5, '朋友', '男', '钟纯攀', '2003-11-07', '19922373593', 14);
INSERT INTO `flist` VALUES (16, 5, '朋友', '女', '包然俭', '2003-11-07', '13120408912', 16);
INSERT INTO `flist` VALUES (18, 5, '朋友', '男', '谢岑松', '2003-11-07', '18041579016', 18);
INSERT INTO `flist` VALUES (19, 5, '朋友', '女', '花纳畅', '2003-11-07', '15569047505', 19);
INSERT INTO `flist` VALUES (20, 5, '朋友', '女', '秋翊田', '2003-11-07', '18999508010', 20);
INSERT INTO `flist` VALUES (22, 5, '家人', '男', '凌苓桢', '2003-11-07', '18850259829', 22);
INSERT INTO `flist` VALUES (23, 5, '家人', '男', '松镇勋', '2003-11-07', '15960549742', 23);
INSERT INTO `flist` VALUES (24, 5, '家人', '女', '顾祺妲', '2003-11-07', '13641585104', 24);
INSERT INTO `flist` VALUES (25, 5, '家人', '女', '殷斯文', '2003-11-07', '15396063702', 25);
INSERT INTO `flist` VALUES (26, 5, '同学', '女', '韦焰俪', '2003-11-07', '15380978137', 26);
INSERT INTO `flist` VALUES (27, 5, '同学', '女', '韶锨勉', '2003-11-07', '17677485074', 27);
INSERT INTO `flist` VALUES (28, 5, '同学', '男', '姚童沫', '2003-11-07', '15122629144', 28);
INSERT INTO `flist` VALUES (29, 5, '同学', '男', '邢融兵', '2003-11-07', '15921869226', 29);
INSERT INTO `flist` VALUES (30, 5, '同学', '女', '邓潮珺', '2003-11-07', '17870962987', 30);
INSERT INTO `flist` VALUES (31, 5, '同学', '女', '石骏雍', '2003-11-07', '18232163033', 31);
INSERT INTO `flist` VALUES (32, 5, '同学', '女', '花芸舟', '2003-11-07', '17586381407', 32);
INSERT INTO `flist` VALUES (33, 5, '同学', '男', '冯奔轶', '2003-11-07', '13535869302', 33);
INSERT INTO `flist` VALUES (34, 5, '工作', '男', '贡春娴', '2003-11-07', '13438398255', 34);
INSERT INTO `flist` VALUES (35, 5, '工作', '女', '殷品飞', '2003-11-07', '18832023426', 35);
INSERT INTO `flist` VALUES (36, 5, '工作', '女', '乌崇宜', '2003-11-07', '13117517216', 36);
INSERT INTO `flist` VALUES (37, 5, '工作', '女', '滕曙烽', '2003-11-07', '17172819463', 37);
INSERT INTO `flist` VALUES (38, 5, '工作', '女', '郜会尚', '2003-11-07', '18708689790', 38);
INSERT INTO `flist` VALUES (39, 5, '工作', '男', '盛涌昱', '2003-11-07', '18544356248', 39);
INSERT INTO `flist` VALUES (40, 5, '工作', '男', '莫嵘嫚', '2003-11-07', '14576394625', 40);
INSERT INTO `flist` VALUES (41, 5, '工作', '女', '乌昕雯', '2003-11-07', '15911325352', 41);
INSERT INTO `flist` VALUES (42, 5, '工作', '女', '陶章齐', '2003-11-07', '16504455306', 42);
INSERT INTO `flist` VALUES (43, 5, '工作', '男', '鲍蔓嫒', '2003-11-07', '14587389494', 43);
INSERT INTO `flist` VALUES (44, 5, '工作', '男', '成妍柳', '2003-11-07', '13257343495', 44);
INSERT INTO `flist` VALUES (45, 5, '工作', '男', '苏颂玺', '2003-11-07', '13447187326', 45);
INSERT INTO `flist` VALUES (46, 5, '其他', '女', '钟茹畅', '2003-11-07', '15567798921', 46);
INSERT INTO `flist` VALUES (47, 5, '其他', '男', '祖帅贵', '2003-11-07', '19975269143', 47);
INSERT INTO `flist` VALUES (48, 5, '其他', '女', '雷昀德', '2003-11-07', '13351718226', 48);
INSERT INTO `flist` VALUES (49, 5, '其他', '女', '阮思彭', '2003-11-07', '13875684050', 49);
INSERT INTO `flist` VALUES (55, 5, '朋友', '女', '老王', '2020-01-01', '12345678900', 2);
INSERT INTO `flist` VALUES (56, 5, '朋友', '男', '老李', '2020-02-02', '12345678900', 45);
INSERT INTO `flist` VALUES (57, 0, '', '', '', '2000-12-12', '', 0);
INSERT INTO `flist` VALUES (58, 0, '', '', '', '2000-12-12', '', 0);

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `GroupId` int NOT NULL AUTO_INCREMENT,
  `Gname` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`GroupId`) USING BTREE,
  UNIQUE INDEX `group_GroupId_uindex`(`GroupId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES (1, '特别关心');
INSERT INTO `group` VALUES (2, '同学');
INSERT INTO `group` VALUES (3, '朋友');
INSERT INTO `group` VALUES (4, '家人');
INSERT INTO `group` VALUES (5, '工作');
INSERT INTO `group` VALUES (6, '其他');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `UserId` int NOT NULL,
  `FId` int NOT NULL,
  `MTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MContent` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `FName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `Message_ID_uindex`(`ID`) USING BTREE,
  INDEX `Message_user_UserId_fk`(`UserId`) USING BTREE,
  CONSTRAINT `Message_user_UserId_fk` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 5, 1, '2021-12-27 21:38:14', '出来玩', '连娴');
INSERT INTO `message` VALUES (2, 5, 2, '2021-12-27 21:48:55', '在吃饭', '衣枝');
INSERT INTO `message` VALUES (3, 5, 3, '2021-12-27 21:48:55', '上号', '万兴琳');
INSERT INTO `message` VALUES (4, 5, 4, '2021-12-27 21:48:55', '兄弟，上号', '巫青彩');
INSERT INTO `message` VALUES (5, 5, 5, '2021-12-27 21:48:55', '学习', '魏榕融');
INSERT INTO `message` VALUES (6, 5, 6, '2021-12-27 21:48:55', '学习', '晏瑶胜');
INSERT INTO `message` VALUES (7, 5, 7, '2021-12-27 21:48:55', '老爸，哈哈哈', '纪明容琳');
INSERT INTO `message` VALUES (8, 5, 8, '2021-12-27 21:48:55', '老妈，哈哈哈', '边娜');
INSERT INTO `message` VALUES (9, 5, 9, '2021-12-27 21:48:55', '老姐，哈哈哈', '周娥阳振');
INSERT INTO `message` VALUES (10, 5, 10, '2021-12-27 21:48:55', '老板叫你', '段丹');
INSERT INTO `message` VALUES (11, 5, 11, '2021-12-27 21:48:55', '老板叫你', '张三');
INSERT INTO `message` VALUES (12, 5, 1, '2021-12-27 21:48:55', '南昌', '连娴');
INSERT INTO `message` VALUES (13, 5, 1, '2021-12-27 21:48:55', '下午', '连娴');
INSERT INTO `message` VALUES (14, 5, 2, '2021-12-27 21:48:55', '吃豆腐', '衣枝');
INSERT INTO `message` VALUES (15, 5, 2, '2021-12-27 21:48:55', '睡觉', '衣枝');
INSERT INTO `message` VALUES (16, 5, 4, '2021-12-27 21:48:55', '来了', '巫青彩');
INSERT INTO `message` VALUES (17, 5, 10, '2021-12-27 21:48:55', '行吧', '段丹');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`UserId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '丁聪华', 'ewnh7cc4c');
INSERT INTO `user` VALUES (2, '岑珍申', 'a9g3l7r0v');
INSERT INTO `user` VALUES (3, '束舒凯', 'dtzsqrtnka');
INSERT INTO `user` VALUES (4, '郁音嫚', 'yyx5epd');
INSERT INTO `user` VALUES (5, 'root', '123456');

SET FOREIGN_KEY_CHECKS = 1;
