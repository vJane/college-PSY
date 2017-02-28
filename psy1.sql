/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : psy1

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2016-04-20 16:48:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '管理员权限',
  `user` varchar(20) NOT NULL COMMENT '登录账号',
  `pwd` varchar(20) NOT NULL COMMENT '登录密码',
  `name` char(8) NOT NULL COMMENT '真实姓名',
  `dept` char(40) DEFAULT '无' COMMENT '所在院系',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `del` int(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `indexType` (`type`) USING BTREE,
  KEY `indexDept` (`dept`) USING BTREE,
  KEY `indexName` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('2', '0', 'admin', 'admin', '开发者', '数信', '', '1');
INSERT INTO `admins` VALUES ('3', '0', 'adminLiNong', 'adminLiNong', '开发者', '数信', '18713566770', '1');
INSERT INTO `admins` VALUES ('4', '0', 'Vivian', 'ost', 'Vivian', '数信', '18713575980', '1');
INSERT INTO `admins` VALUES ('5', '1', 'c1', '123', '研究生秘书', '', '1232', '0');
INSERT INTO `admins` VALUES ('7', '2', 'AA', '123', '崔莉', '数信', '1232', '0');
INSERT INTO `admins` VALUES ('13', '2', '张三', '123', '张三', '无', null, '1');
INSERT INTO `admins` VALUES ('14', '2', '李四', '123', '李四', '无', null, '1');
INSERT INTO `admins` VALUES ('16', '2', '王五', '123', '王五', '', '', '0');
INSERT INTO `admins` VALUES ('17', '2', 'abcd', '123', 'aaa', 'aaa', 'aaa', '1');

-- ----------------------------
-- Table structure for `admintype`
-- ----------------------------
DROP TABLE IF EXISTS `admintype`;
CREATE TABLE `admintype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '管理员类型的编号',
  `memo` varchar(40) NOT NULL COMMENT '管理员类型的说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `adminType` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admintype
-- ----------------------------
INSERT INTO `admintype` VALUES ('1', '1', '研究生处老师&心理指导老师');
INSERT INTO `admintype` VALUES ('2', '2', '导师');
INSERT INTO `admintype` VALUES ('3', '0', '超级管理员');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept` char(40) NOT NULL COMMENT '院系名字',
  `memo` varchar(256) DEFAULT NULL COMMENT '对于院系的说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dept` (`dept`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '数学与信息科技学院', '秦皇岛校区');
INSERT INTO `department` VALUES ('2', '外国语学院', null);
INSERT INTO `department` VALUES ('3', '城市建设学院', null);
INSERT INTO `department` VALUES ('4', '动物科技学院', null);
INSERT INTO `department` VALUES ('5', '艺术学院', null);
INSERT INTO `department` VALUES ('6', '文法学院', null);
INSERT INTO `department` VALUES ('7', '化学工程学院', null);
INSERT INTO `department` VALUES ('8', '工商管理学院', null);
INSERT INTO `department` VALUES ('9', '食品科技学院', null);
INSERT INTO `department` VALUES ('10', '教育学院', null);
INSERT INTO `department` VALUES ('11', '生命科技学院', null);
INSERT INTO `department` VALUES ('12', '园艺科技学院', null);
INSERT INTO `department` VALUES ('13', '欧美学院', null);
INSERT INTO `department` VALUES ('14', '体育系', null);
INSERT INTO `department` VALUES ('15', '机电工程学院', null);
INSERT INTO `department` VALUES ('16', '无', null);

-- ----------------------------
-- Table structure for `exam`
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tableName` char(10) NOT NULL COMMENT '英文表名',
  `type` int(11) NOT NULL COMMENT '试题类型',
  `QuestionTitle` varchar(1024) NOT NULL COMMENT '题干',
  `a` varchar(1024) DEFAULT NULL,
  `b` varchar(1024) DEFAULT NULL,
  `c` varchar(1024) DEFAULT NULL,
  `d` varchar(1024) DEFAULT NULL,
  `e` varchar(1024) DEFAULT NULL,
  `f` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `examType` (`type`),
  KEY `examTableName` (`tableName`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('1', 'IQtest', '1', '选出不同类的一项：', 'A、蛇', 'B、大树', 'C、老虎', null, null, null);
INSERT INTO `exam` VALUES ('2', 'IQtest', '1', '在下列分数中，选出不同类的一项', 'A、3/5 ', 'B、3/7 ', 'C、3/9', null, null, null);
INSERT INTO `exam` VALUES ('3', 'IQtest', '1', '男孩对男子，正如女孩对', 'A、夫人  ', 'B、姑娘', 'C、妇女', null, null, null);
INSERT INTO `exam` VALUES ('4', 'IQtest', '1', '如果笔相对于写字，那么书相对于', 'A、娱乐   ', 'B、阅读', 'C、学文化', null, null, null);
INSERT INTO `exam` VALUES ('5', 'IQtest', '1', '马之于马厩，正如人之于', 'A、房屋  ', 'B、农场', 'C、楼房', null, null, null);
INSERT INTO `exam` VALUES ('6', 'IQtest', '2', '2 8 14 20（ ）请写出“（ ）”处的数字', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('7', 'IQtest', '1', '下列四个词是否可以组成一个正确的句子: 生活 水里 鱼 在', 'A、是 ', 'B、否', 'C、不确定', null, null, null);
INSERT INTO `exam` VALUES ('8', 'IQtest', '1', '下列六个词是否可以组成一个正确的句子:球棒 的 用来 是 棒球 打', 'A、是 ', 'B、否', 'C、不确定', null, null, null);
INSERT INTO `exam` VALUES ('9', 'IQtest', '1', '动物学家与社会学家相对应，正如动物与（ ）相对', 'A、人类  ', 'B、社会', 'C、社会学', null, null, null);
INSERT INTO `exam` VALUES ('10', 'IQtest', '1', '如果所有的妇女都有大衣，那么漂亮的妇女会有', 'A、更多的大衣  ', 'B、时髦的大衣', 'C、大衣', null, null, null);
INSERT INTO `exam` VALUES ('11', 'IQtest', '2', '1 3 2 4 6 5 7（ ），请写出“（）”处的数字', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('12', 'IQtest', '1', '南之于西北，正如西之于：', 'A、西北  ', 'B、东北 ', 'C、西南', null, null, null);
INSERT INTO `exam` VALUES ('13', 'IQtest', '1', '找出不同类的一项', 'A、铁锅 ', 'B、小勺', 'C、米饭 ', null, null, null);
INSERT INTO `exam` VALUES ('14', 'IQtest', '2', '9 7 8 6 7 5（），请写出“（）”处的数字', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('15', 'IQtest', '1', '找出不同类的一项', 'A、写字台 ', 'B、沙发 ', 'C、桌布', null, null, null);
INSERT INTO `exam` VALUES ('16', 'IQtest', '2', '961（25）432 932（ ）731，请写出（）内的数字', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('17', 'IQtest', '1', '选项ABC中，哪一个应该填在“XOOOOXXOOOXXX”后面', 'A、XOO  ', 'B、OO ', 'C、OOX', null, null, null);
INSERT INTO `exam` VALUES ('18', 'IQtest', '1', '望子成龙的家长往往（）苗助长', 'A、揠  ', 'B、堰', 'C、偃', null, null, null);
INSERT INTO `exam` VALUES ('19', 'IQtest', '2', '填上空缺的词：金黄的头发（黄山）刀山火海                            ---->赞美人生（ ）卫国战争', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('20', 'IQtest', '1', '选出不同类的一项', 'A、地板  ', 'B、壁橱', 'C、窗帘', null, null, null);
INSERT INTO `exam` VALUES ('21', 'IQtest', '2', ' 1 8 27 （），请写出（）内的数字', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('22', 'IQtest', '2', '填上空缺的词：罄竹难书（书法）无法无天                            ---->作奸犯科（ ）教学相长', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('23', 'IQtest', '2', '在括号内填上一个字，使其与括号前的字组成一个词，同时又与括号后面的字也能组成一个词：款（ ）样', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('24', 'IQtest', '2', '填入空缺的数字：16（96）12 10（ ）7.5', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('25', 'IQtest', '1', '找出不同类的一项', 'A、斑马  ', 'B、军马', 'C、驸马', null, null, null);
INSERT INTO `exam` VALUES ('26', 'IQtest', '2', '在括号上填上一个字，使其与括号前的字组成一个词，同时又与括号后面的字组成一个词：祭（ ）定', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('27', 'IQtest', '2', '在括号上填上一个字，使之既有前一个词的意思，又可以与后一个词组成词组：头部（ ）震荡', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('28', 'IQtest', '2', '填入空缺的数字：65 37 17 （ ）', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('29', 'IQtest', '2', '填入空缺的数字：41 （28）27 83 （ ）65', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('30', 'IQtest', '2', '填入空缺的字母：C F I D H L E J（ ）', '', '', '', null, null, null);
INSERT INTO `exam` VALUES ('188', 'K16pf', '1', '我很明了本测验的说明', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('189', 'K16pf', '1', '我对本测验的每一个问题都会按自己的真实情况作答', 'A、是的', 'B、不一定', 'C、不同意', null, null, null);
INSERT INTO `exam` VALUES ('190', 'K16pf', '1', '如果有机会的话，我愿意：', 'A、到一个繁华的城市去旅行', 'B、介于A和C之间', 'C、浏览清净的山区', null, null, null);
INSERT INTO `exam` VALUES ('191', 'K16pf', '1', '我有足够的能力应付各种困难', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('192', 'K16pf', '1', '即使是关在铁笼里的猛兽，我见了也会感到揣揣不安：', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('193', 'K16pf', '1', '我总是避免批评别人的言行', 'A、是的', 'B、有时如此', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('194', 'K16pf', '1', '我的思想似乎：', 'A、走到了时代的前面', 'B、不太一定', 'C、正符合时代', null, null, null);
INSERT INTO `exam` VALUES ('195', 'K16pf', '1', '我不擅长讲笑话、说趣事', 'A、是的', 'B、介于A和C之间', 'C、不同意', null, null, null);
INSERT INTO `exam` VALUES ('196', 'K16pf', '1', '当我见到亲友或邻居争吵时，我总是', 'A、任其自己解决', 'B、置之不理', 'C、予以劝解', null, null, null);
INSERT INTO `exam` VALUES ('197', 'K16pf', '1', '在社交场合，我：', 'A、谈吐自如', 'B、介于A和C之间', 'C、保持沉默', null, null, null);
INSERT INTO `exam` VALUES ('198', 'K16pf', '1', '我愿做一名：', 'A、建筑工程师', 'B、不确定', 'C、社会科学研究者', null, null, null);
INSERT INTO `exam` VALUES ('199', 'K16pf', '1', '阅读时，我喜欢阅读：', 'A、自然科学书籍', 'B、不确定', 'C、政治理论书籍', null, null, null);
INSERT INTO `exam` VALUES ('200', 'K16pf', '1', '我认为许多人都有些心里不正常，只是他们不愿意承认：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('201', 'K16pf', '1', '我希望我的爱人擅长交际而无须有文艺才能', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('202', 'K16pf', '1', '对于性情急躁、爱发脾气的人，我仍能以礼相待', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('203', 'K16pf', '1', '受人侍奉的我常局促不安', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('204', 'K16pf', '1', '在从事体力或脑力劳动后，我需要较多的休息时间，才能恢复工作效率', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('205', 'K16pf', '1', '半夜醒来，我常常为种种忧虑而不能再入睡', 'A、常常如此', 'B、有时如此', 'C、极少如此', null, null, null);
INSERT INTO `exam` VALUES ('206', 'K16pf', '1', '事情进行得不顺利时，我常会急得掉眼泪', 'A、从不如此', 'B、有时如此', 'C、常常如此', null, null, null);
INSERT INTO `exam` VALUES ('207', 'K16pf', '1', '我认为只要双方同意就可以离婚，可以不受传统礼教的束缚', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('208', 'K16pf', '1', '我对人或物的兴趣都很容易改变', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('209', 'K16pf', '1', '在工作中，我更愿意：', 'A、和别人合作', 'B、不确定', 'C、自己单独进行', null, null, null);
INSERT INTO `exam` VALUES ('210', 'K16pf', '1', '我常常会无缘无故地自言自语', 'A、常常如此', 'B、偶尔如此', 'C、从不如此', null, null, null);
INSERT INTO `exam` VALUES ('211', 'K16pf', '1', '无论是工作、饮食或外出游览，我总是：', 'A、匆匆忙忙，不能尽兴', 'B、介于A和C之间', 'C、从容不迫', null, null, null);
INSERT INTO `exam` VALUES ('212', 'K16pf', '1', '有时我会怀疑别人对我的言谈真正有兴趣：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('213', 'K16pf', '1', '在工厂里，我宁愿负责', 'A、技术科', 'B、介于A和C之间', 'C、人事科', null, null, null);
INSERT INTO `exam` VALUES ('214', 'K16pf', '1', '在阅读时，我愿阅读', 'A、有关太空旅行的书籍', 'B、不太确定', 'C、有关家庭教育的书籍', null, null, null);
INSERT INTO `exam` VALUES ('215', 'K16pf', '1', '下列三个字中，哪个与其它两个属于不同类型', 'A、狗', 'B、石头', 'C、牛', null, null, null);
INSERT INTO `exam` VALUES ('216', 'K16pf', '1', '如果我能到一个新的环境，我要：', 'A、把生活安排的和从前不一样', 'B、不确定', 'C、和从前相仿', null, null, null);
INSERT INTO `exam` VALUES ('217', 'K16pf', '1', '在我的生活中，我总是能达到我所预期的目标', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('218', 'K16pf', '1', '当我说谎时，总觉得内心羞愧，不敢正视对方', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('219', 'K16pf', '1', '假使我手里拿着一颗装有子弹的手枪，我必须把子弹取出来才能心安', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('220', 'K16pf', '1', '朋友们大都认为我是一个说话很风趣的人：', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('221', 'K16pf', '1', '如果人们知道我的内心世界，他们定会感到很惊讶', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('222', 'K16pf', '1', '在公共场合，如果我突然成为大家注意的中心，就会感到局促不安', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('223', 'K16pf', '1', '我总喜欢参加规模庞大的晚会或集会', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('224', 'K16pf', '1', '我更喜欢：', 'A、听音乐', 'B、不一定', 'C、做手工', null, null, null);
INSERT INTO `exam` VALUES ('225', 'K16pf', '1', '我常常怀疑那些对我过于友善的人动机是否如此', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('226', 'K16pf', '1', '我愿意把我的生活安排得像一个', 'A、艺术家', 'B、不确定', 'C、会计师', null, null, null);
INSERT INTO `exam` VALUES ('227', 'K16pf', '1', '我认为目前社会所需要的是', 'A、多出现一些富有改善计划的思想家', 'B、不确定', 'C、脚踏实地的实干家', null, null, null);
INSERT INTO `exam` VALUES ('228', 'K16pf', '1', '有时候我觉得我需要做剧烈的体力活动：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('229', 'K16pf', '1', '我更愿意跟有礼貌有教养的人来往，而不愿意同粗鲁的人交往', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('230', 'K16pf', '1', '在处理一些必须凭借智慧的事务中，我父母', 'A、较一般人差', 'B、普通', 'C、超人一等', null, null, null);
INSERT INTO `exam` VALUES ('231', 'K16pf', '1', '当领导召见我时，我：', 'A、总觉得可以趁机提出建议', 'B、介于A和C之间', 'C、总觉得自己做错了什么事', null, null, null);
INSERT INTO `exam` VALUES ('232', 'K16pf', '1', '如果待遇优厚，我愿意做护理精神病人的工作', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('233', 'K16pf', '1', '看报时，我喜欢读：', 'A、当今世界上的热点问题', 'B、介于A和C之间', 'C、地方风俗', null, null, null);
INSERT INTO `exam` VALUES ('234', 'K16pf', '1', '在接受困难任务时，我总是', 'A、希望自己独立完成', 'B、不确定', 'C、希望有人的帮助和指导', null, null, null);
INSERT INTO `exam` VALUES ('235', 'K16pf', '1', '在游览时，我宁愿观看一个画家的写生，而不愿听人家的辩论', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('236', 'K16pf', '1', '我的神经脆弱，稍有点刺激就会使我胆战心惊', 'A、时常如此', 'B、有时如此', 'C、从不如此', null, null, null);
INSERT INTO `exam` VALUES ('237', 'K16pf', '1', '早晨起来，我常常感到疲乏不堪', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('238', 'K16pf', '1', '如果待遇相同，我愿选做：', 'A、森林管理员', 'B、不一定', 'C、中小学教师', null, null, null);
INSERT INTO `exam` VALUES ('239', 'K16pf', '1', '每逢过年过节或亲友生日时，我：', 'A、喜欢互相赠送礼物', 'B、不太确定', 'C、觉得交换礼物是繁琐多事', null, null, null);
INSERT INTO `exam` VALUES ('240', 'K16pf', '1', '在下列数字中，哪个数字和其他两个数字属于不同类型', 'A、5', 'B、2', 'C、7', null, null, null);
INSERT INTO `exam` VALUES ('241', 'K16pf', '1', '“猫”和“鱼”就如同“牛”和：', 'A、牛奶', 'B、牧草', 'C、盐', null, null, null);
INSERT INTO `exam` VALUES ('242', 'K16pf', '1', '在做人处事的各个方面，我的父母很值得敬佩', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('243', 'K16pf', '1', '我觉得我有一些别人所不及的优良品质：', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('244', 'K16pf', '1', '只要有利于大家，尽管别人认为卑贱的工作，我也会乐而为之，不以为耻：', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('245', 'K16pf', '1', '我喜欢看电影或参加其他娱乐活动的次数：', 'A、比一般人多', 'B、比一般人相同', 'C、比一般人少', null, null, null);
INSERT INTO `exam` VALUES ('246', 'K16pf', '1', '我喜欢从事需要精密技术的工作：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('247', 'K16pf', '1', '在有威望，有地位的长者面前，我总是较为缄默、谨慎', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('248', 'K16pf', '1', '对于我来说在大众面前演讲或表演，是一件不容易的事', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('249', 'K16pf', '1', '我更愿意：', 'A、指挥几个人工作', 'B、不确定', 'C、和同志们一起工作', null, null, null);
INSERT INTO `exam` VALUES ('250', 'K16pf', '1', '即使我做了一件让人笑话的事，我也能坦然处之：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('251', 'K16pf', '1', '我认为没有人会幸灾乐祸地希望我遇上困难：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('252', 'K16pf', '1', '一个人应该：', 'A、考虑人生的真正意义', 'B、不确定', 'C、谋求家庭的温饱', null, null, null);
INSERT INTO `exam` VALUES ('253', 'K16pf', '1', '我喜欢去处理被别人弄得一塌糊涂的问题：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('254', 'K16pf', '1', '当我非常高兴时，总有一种“好景不长”的感觉', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('255', 'K16pf', '1', '在各种困难情境中，我总能保持乐观：', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('256', 'K16pf', '1', '迁居是一件极不愉快的事：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('257', 'K16pf', '1', '在我年轻的时候，当我和父母意见不同时，我经常：', 'A、坚持自己的意见', 'B、介于A和C之间', 'C、接受父母的意见', null, null, null);
INSERT INTO `exam` VALUES ('258', 'K16pf', '1', '我希望我的家庭', 'A、仅是适合自身活动和娱乐的地方', 'B、介于A和C之间', 'C、成为邻里社交活动的一部分', null, null, null);
INSERT INTO `exam` VALUES ('259', 'K16pf', '1', '我解决问题时，多借助于：', 'A、个人独立思考', 'B、介于A和C之间', 'C、与人互相讨论', null, null, null);
INSERT INTO `exam` VALUES ('260', 'K16pf', '1', '在需要当机立断时，我总是', 'A、镇静、理智', 'B、介于A和C之间', 'C、兴奋、激动', null, null, null);
INSERT INTO `exam` VALUES ('261', 'K16pf', '1', '最近在一两件事情上，我觉得自己是无辜受累', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('262', 'K16pf', '1', '我善于控制自己的表情', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('263', 'K16pf', '1', '如果待遇相同，我愿做一个：', 'A、化学研究工作者', 'B、不确定', 'C、旅行社经理', null, null, null);
INSERT INTO `exam` VALUES ('264', 'K16pf', '1', '“惊讶”与“新奇”犹如“惧怕”与：', 'A、勇敢', 'B、焦虑', 'C、恐怖', null, null, null);
INSERT INTO `exam` VALUES ('265', 'K16pf', '1', '下列三个分数中，哪一个与其它两个属不同类别', 'A、3/7', 'B、3/9', 'C、3/11', null, null, null);
INSERT INTO `exam` VALUES ('266', 'K16pf', '1', '不知为什么，有些人总是回避或冷淡我', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('267', 'K16pf', '1', '我虽善意待人，但常常得不到好报：', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('268', 'K16pf', '1', '我不喜欢那些争强好胜的人', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('269', 'K16pf', '1', '和一般人相比，我的朋友的确太少', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('270', 'K16pf', '1', '出于万不得已时，我才参加社交集会，否则我总是设法回避参加应酬应的活动：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('271', 'K16pf', '1', '我认为对领导逢迎得当比工作表现更重要', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('272', 'K16pf', '1', '参加竞赛时，我看中的是竞赛活动，而不计较其成败', 'A、总是如此', 'B、一般如此', 'C、偶尔如此', null, null, null);
INSERT INTO `exam` VALUES ('273', 'K16pf', '1', '我宁愿我的职业是', 'A、有固定可靠的收入', 'B、介于A和C之间', 'C、收入应随我的工作表现而随时调整', null, null, null);
INSERT INTO `exam` VALUES ('274', 'K16pf', '1', '我愿意阅读：', 'A、军事与政治的事实记载', 'B、不一定', 'C、富有情感和幻想的作品', null, null, null);
INSERT INTO `exam` VALUES ('275', 'K16pf', '1', '有许多人之所以不敢犯罪，主要原因是怕受到惩罚', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('276', 'K16pf', '1', '我的父母（或监护人）从来不严格要求我事事顺从', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('277', 'K16pf', '1', '“百折不挠”、“再接再厉”的精神似乎被人们忽略', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('278', 'K16pf', '1', '当有人对我发怒时，我总是', 'A、设法使他镇静下来', 'B、不太确定', 'C、自己也会恼怒起来', null, null, null);
INSERT INTO `exam` VALUES ('279', 'K16pf', '1', '我希望：', 'A、人们要友好相处', 'B、不一定', 'C、开展斗争', null, null, null);
INSERT INTO `exam` VALUES ('280', 'K16pf', '1', '不论是在极高的屋顶上，还是在极深的隧道中，我很少感到胆怯不安', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('281', 'K16pf', '1', '只要没有过错，不管别人怎么说，我总能心安理得', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('282', 'K16pf', '1', '凡是无法用理智来解决的问题，有时就不得不靠权力来处理', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('283', 'K16pf', '1', '我在十六、七岁的时候，和异性朋友交往：', 'A、极多', 'B、介于A和C之间', 'C、较别人少', null, null, null);
INSERT INTO `exam` VALUES ('284', 'K16pf', '1', '我在社交场合或所参加的组织中是一个活跃分子：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('285', 'K16pf', '1', '在人声嘈杂中，我仍能不受干扰，专心工作', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('286', 'K16pf', '1', '在某些心境下，我常常因为困惑陷入幻想而将工作搁置下来', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('287', 'K16pf', '1', '我很少用难堪的语言去刺伤别人的感情', 'A、是的', 'B、不太确定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('288', 'K16pf', '1', '如果让我选择、我宁愿选做：', 'A、列车员', 'B、不确定', 'C、描图员', null, null, null);
INSERT INTO `exam` VALUES ('289', 'K16pf', '1', '“理不胜词”的意思是：', 'A、理不如词', 'B、理多而词少', 'C、辞藻华丽而理不足', null, null, null);
INSERT INTO `exam` VALUES ('290', 'K16pf', '1', '“铁锹”与“挖掘”犹如“刀子”与：', 'A、琢磨', 'B、切割', 'C、铲除', null, null, null);
INSERT INTO `exam` VALUES ('291', 'K16pf', '1', '我常常避开我所不愿意打招呼的人', 'A、极少如此', 'B、偶尔如此', 'C、有时如此', null, null, null);
INSERT INTO `exam` VALUES ('292', 'K16pf', '1', '当我倾听音乐时，如果有人在旁边高谈论阔：', 'A、我仍能专心听音乐，不受影响', 'B、介于A和C之间', 'C、不能专心欣赏而感到恼怒', null, null, null);
INSERT INTO `exam` VALUES ('293', 'K16pf', '1', '在课堂上，如果我的意见与老师不同，我常常', 'A、保持沉默', 'B、不一定', 'C、当场表明自己的看法', null, null, null);
INSERT INTO `exam` VALUES ('294', 'K16pf', '1', '我单独跟异性谈话时，总显得不自然', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('295', 'K16pf', '1', '我在待人接物方面，的确不太成功', 'A、是的', 'B、不完全是这样', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('296', 'K16pf', '1', '每当做一件困难工作时，我总是：', 'A、预先做好准备', 'B、介于A和C之间', 'C、相信到时候总会有办法解决的', null, null, null);
INSERT INTO `exam` VALUES ('297', 'K16pf', '1', '在我结交的朋友中，男女各占一半', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('298', 'K16pf', '1', '我在结交朋友方面，我宁可', 'A、结交很多的人', 'B、不一定', 'C、维持几个深交的朋友', null, null, null);
INSERT INTO `exam` VALUES ('299', 'K16pf', '1', '我愿意做一个社会科学家，而不愿做一个机械工程师', 'A、是的', 'B、不确定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('300', 'K16pf', '1', '一旦发现别人的缺点，我会立即给予指正：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('301', 'K16pf', '1', '我喜欢设法影响和我一起工作的同事，使他们能协助我实现我所计划的目标', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('302', 'K16pf', '1', '如果可能，我乐于从事戏剧、音乐、舞蹈之类的工作', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('303', 'K16pf', '1', '当人们表扬我的时候，我总是觉得不好意思', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('304', 'K16pf', '1', '我认为现代社会最需要解决的问题是：', 'A、政治问题', 'B、不太确定', 'C、道德问题', null, null, null);
INSERT INTO `exam` VALUES ('305', 'K16pf', '1', '有时我会无故地产生一种面临大祸的恐惧：', 'A、是的', 'B、有时如此', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('306', 'K16pf', '1', '我常常担心家人的健康', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('307', 'K16pf', '1', '在闲暇的时候，我喜欢', 'A、看一部历史性的探险电影', 'B、不一定', 'C、看一本科学幻想小说', null, null, null);
INSERT INTO `exam` VALUES ('308', 'K16pf', '1', '当人们批评我古怪不正常时，我：', 'A、非常气恼', 'B、有些气恼', 'C、无所谓', null, null, null);
INSERT INTO `exam` VALUES ('309', 'K16pf', '1', '到一个陌生城市里找地址时，我经常：', 'A、找人问路', 'B、介于A和C之间', 'C、参考市区地图', null, null, null);
INSERT INTO `exam` VALUES ('310', 'K16pf', '1', '当朋友声明要在家休息时，我总是设法怂恿他外出：', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('311', 'K16pf', '1', '在就寝时，我常常：', 'A、不易入睡', 'B、介于A和C之间', 'C、极易入睡', null, null, null);
INSERT INTO `exam` VALUES ('312', 'K16pf', '1', '有人烦扰我时，我：', 'A、通常不予理会', 'B、介于A和C之间', 'C、总要表示我的不满', null, null, null);
INSERT INTO `exam` VALUES ('313', 'K16pf', '1', '如果待遇相同，我愿做一个：', 'A、律师', 'B、不确定', 'C、航海员', null, null, null);
INSERT INTO `exam` VALUES ('314', 'K16pf', '1', '“时间永恒”是比喻', 'A、时间过得真慢', 'B、忘了时间', 'C、光阴一去不复返', null, null, null);
INSERT INTO `exam` VALUES ('315', 'K16pf', '1', '下列三项符号中哪一项应紧接：“#0000##000###”', 'A、#0#', 'B、00#', 'C、0##', null, null, null);
INSERT INTO `exam` VALUES ('316', 'K16pf', '1', '我不论到什么地方，都能清楚地辨别方向：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('317', 'K16pf', '1', '我热爱我所学的专业和从事的工作', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('318', 'K16pf', '1', '如果我急于想借朋友的东西，而朋友不在家时，我认为不告而取也没有关系', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('319', 'K16pf', '1', '我喜欢向朋友讲述一些我个人有趣的经历：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('320', 'K16pf', '1', '我宁愿做一个：', 'A、演员', 'B、不确定', 'C、建筑师', null, null, null);
INSERT INTO `exam` VALUES ('321', 'K16pf', '1', '业余时间，我总是做好安排，不使时间浪费', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('322', 'K16pf', '1', '在和别人交往中，我常常会无缘无故地产生一种自卑感', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('323', 'K16pf', '1', '和不熟识的人交谈：', 'A、是件难事', 'B、介于A和C之间', 'C、毫不困难', null, null, null);
INSERT INTO `exam` VALUES ('324', 'K16pf', '1', '我所喜欢的音乐，多数是：', 'A、轻松活泼的', 'B、介于A和C之间', 'C、富于感情的', null, null, null);
INSERT INTO `exam` VALUES ('325', 'K16pf', '1', '我常觉得别人在议论我：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('326', 'K16pf', '1', '我认为未来二十年的世界局势，定将好转', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('327', 'K16pf', '1', '我一直比较喜欢阅读：', 'A、战争故事', 'B、不确定', 'C、神话幻想故事', null, null, null);
INSERT INTO `exam` VALUES ('328', 'K16pf', '1', '我向来对机械、汽车等有兴趣', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('329', 'K16pf', '1', '即使让我做一个缓刑释放罪犯的管理人，我也会把工作搞得较好：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('330', 'K16pf', '1', '我仅仅被认为是一个能够苦干而稍有成就的人而已', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('331', 'K16pf', '1', '就是在不顺利的情况下，我仍能保持精神振奋：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('332', 'K16pf', '1', '我认为节制生育是解决经济与和平问题的重要条件', 'A、是的', 'B、不太确定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('333', 'K16pf', '1', '在工作中，我喜欢独自筹划，不愿别人干涉', 'A、是的', 'B、不太确定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('334', 'K16pf', '1', '尽管有的同事和我的意见不和，但仍能和他搞好团结：', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('335', 'K16pf', '1', '我在工作和学习上，总是使自己不粗心大意、忽略细节', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('336', 'K16pf', '1', '在和人争辩或险遭事故后，我常常表现出震颤、筋疲力尽、不能安心工作', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('337', 'K16pf', '1', '未经医生处方，我从不乱吃药：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('338', 'K16pf', '1', '根据我个人的兴趣，我愿参加：', 'A、摄影组活动', 'B、不确定', 'C、辩论会', null, null, null);
INSERT INTO `exam` VALUES ('339', 'K16pf', '1', '“星火燎原”对等于“姑息__”：', 'A、同情', 'B、养奸', 'C、纵容', null, null, null);
INSERT INTO `exam` VALUES ('340', 'K16pf', '1', '“钟表”与“时间”犹如“裁缝”与：', 'A、服装', 'B、剪刀', 'C、布料', null, null, null);
INSERT INTO `exam` VALUES ('341', 'K16pf', '1', '生动的梦境常常干扰我的睡眠：', 'A、经常如此', 'B、偶尔如此', 'C、从不如此', null, null, null);
INSERT INTO `exam` VALUES ('342', 'K16pf', '1', '我爱打抱不平', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('343', 'K16pf', '1', '如果我要到一个新的城市，我将要：', 'A、到处闲逛', 'B、不确定', 'C、避免去不安全的地方', null, null, null);
INSERT INTO `exam` VALUES ('344', 'K16pf', '1', '我宁愿服饰素洁大方，而不愿争奇斗艳惹人注目', 'A、是的', 'B、不太确定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('345', 'K16pf', '1', '我认为安静的娱乐远远胜过热闹的宴会', 'A、是的', 'B、不太确定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('346', 'K16pf', '1', '我明知自己有缺点，但不愿接受别人的批评：', 'A、偶然如此', 'B、极少如此', 'C、从不如此', null, null, null);
INSERT INTO `exam` VALUES ('347', 'K16pf', '1', '我总是把“是非”、“善恶”作为处理问题的原则', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('348', 'K16pf', '1', '我工作时不喜欢有很多人在旁参观', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('349', 'K16pf', '1', '我认为，侮辱那些即使有错误的有文化教养的人，如医生、教师等，也是不应该的', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('350', 'K16pf', '1', '在各种课程中，我较喜欢', 'A、语文', 'B、不太确定', 'C、数学', null, null, null);
INSERT INTO `exam` VALUES ('351', 'K16pf', '1', '那些自以为是、道貌岸然的人最使我生气：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('352', 'K16pf', '1', '和循规蹈矩的人交谈：', 'A、很有兴趣，并有所得', 'B、介于A和C之间', 'C、他们的思想肤浅，使我厌烦', null, null, null);
INSERT INTO `exam` VALUES ('353', 'K16pf', '1', '我喜欢：', 'A、有几个有时对我很苛求但富有感情的朋友', 'B、介于A和C之间', 'C、不受别人的干涉', null, null, null);
INSERT INTO `exam` VALUES ('354', 'K16pf', '1', '如果征求我的意见，我赞同：', 'A、切实制止精神病患者和智力低下的人生育', 'B、介于A和C之间', 'C、杀人犯必须判处死刑', null, null, null);
INSERT INTO `exam` VALUES ('355', 'K16pf', '1', '有时我会无缘无故地感到沮丧、痛苦', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('356', 'K16pf', '1', '当和我立场相反的人争论时，我主张：', 'A、尽量找出基本观点的差异', 'B、不一定', 'C、彼此让步', null, null, null);
INSERT INTO `exam` VALUES ('357', 'K16pf', '1', '我一向重感情而不重理智，因而我的观点常常动摇不定', 'A、是的', 'B、不致如此', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('358', 'K16pf', '1', '我的学习效率多依赖于：', 'A、阅读好书', 'B、介于A和C之间', 'C、参加集体讨论', null, null, null);
INSERT INTO `exam` VALUES ('359', 'K16pf', '1', '我宁愿选择一个工资较高的工作，不在乎是否有保障，而不愿做工资低的固定工作', 'A、是的', 'B、不太确定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('360', 'K16pf', '1', '在参加讨论时，我总是能把握住自己的立场', 'A、经常如此', 'B、一般如此', 'C、必要时才能如此', null, null, null);
INSERT INTO `exam` VALUES ('361', 'K16pf', '1', '我常常被一些无所谓的琐事所烦扰', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('362', 'K16pf', '1', '我宁愿住在嘈杂的闹市区，而不愿住在僻静的郊区', 'A、是的', 'B、不太确定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('363', 'K16pf', '1', '下列工作如果任我挑选的话，我愿做：', 'A、少先队辅导员', 'B、不太确定', 'C、修表工作', null, null, null);
INSERT INTO `exam` VALUES ('364', 'K16pf', '1', '一人__事，众人受累：', 'A、偾', 'B、愤', 'C、喷', null, null, null);
INSERT INTO `exam` VALUES ('365', 'K16pf', '1', '望子成龙的家长往往__苗助长', 'A、揠', 'B、堰', 'C、偃', null, null, null);
INSERT INTO `exam` VALUES ('366', 'K16pf', '1', '气候的变化并不影响我的情绪', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('367', 'K16pf', '1', '因为我对一切问题都有一些见解，所以大家都认为我富有思想：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('368', 'K16pf', '1', '我讲话的声音:', 'A、宏亮', 'B、介于A和C之间', 'C、低沉', null, null, null);
INSERT INTO `exam` VALUES ('369', 'K16pf', '1', '一般人都认为我是一个活跃热情的人：', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('370', 'K16pf', '1', '我喜欢做出差机会较多的工作', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('371', 'K16pf', '1', '我做事严格，力求把事情办得尽善尽美', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('372', 'K16pf', '1', '在取回或归还借的东西时，我总是仔细检查，看是否保持原样', 'A、是的', 'B、介于A和C之间', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('373', 'K16pf', '1', '我通常总是精力充沛，忙碌多事', 'A、是的', 'B、不一定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('374', 'K16pf', '1', '我确信我没有遗漏或漫不经心回答上面的任何问题：', 'A、是的', 'B、不确定', 'C、不是的', null, null, null);
INSERT INTO `exam` VALUES ('375', 'UPI', '1', '食欲不振。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('376', 'UPI', '1', '恶心、胃口难受、肚子痛。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('377', 'UPI', '1', '容易拉肚子或便秘。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('378', 'UPI', '1', '关注心悸和脉搏。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('379', 'UPI', '1', '身体健康状况良好。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('380', 'UPI', '1', '牢骚和不满多。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('381', 'UPI', '1', '父母期望过高。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('382', 'UPI', '1', '自已的过去和家庭是不幸的。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('383', 'UPI', '1', '过于担心将来的事情。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('384', 'UPI', '1', '不想见人。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('385', 'UPI', '1', '觉得自已不是自己。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('386', 'UPI', '1', '缺乏热情和积极性。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('387', 'UPI', '1', '悲观。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('388', 'UPI', '1', '思想不集中。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('389', 'UPI', '1', '情绪起伏过大。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('390', 'UPI', '1', '常常失眠。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('391', 'UPI', '1', '头痛。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('392', 'UPI', '1', '脖子、肩膀酸痛。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('393', 'UPI', '1', '胸痛憋闷。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('394', 'UPI', '1', '总是朝气蓬勃。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('395', 'UPI', '1', '气量小。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('396', 'UPI', '1', '爱操心。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('397', 'UPI', '1', '焦燥不安。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('398', 'UPI', '1', '容易动怒。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('399', 'UPI', '1', '想轻生。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('400', 'UPI', '1', '对任何事都没兴趣。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('401', 'UPI', '1', '记忆力减退。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('402', 'UPI', '1', '缺乏耐性。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('403', 'UPI', '1', '缺乏决断能力。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('404', 'UPI', '1', '过于依赖别人。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('405', 'UPI', '1', '为脸红而苦恼。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('406', 'UPI', '1', '口吃、声音发颤。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('407', 'UPI', '1', '身体忽冷忽热。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('408', 'UPI', '1', '常常注意排尿和性器官。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('409', 'UPI', '1', '心情开朗。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('410', 'UPI', '1', '莫明其妙地不安。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('411', 'UPI', '1', '一个人独处时感到不安。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('412', 'UPI', '1', '缺乏自信心。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('413', 'UPI', '1', '办事畏首畏尾。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('414', 'UPI', '1', '容易被人误解。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('415', 'UPI', '1', '不相信别人。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('416', 'UPI', '1', '过于猜疑。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('417', 'UPI', '1', '厌恶交往。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('418', 'UPI', '1', '感到自卑。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('419', 'UPI', '1', '杞人忧天。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('420', 'UPI', '1', '身体倦乏。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('421', 'UPI', '1', '一着急就出冷汗。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('422', 'UPI', '1', '站起来就头晕。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('423', 'UPI', '1', '有过昏迷或抽疯。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('424', 'UPI', '1', '人缘好受欢迎。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('425', 'UPI', '1', '过于拘泥。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('426', 'UPI', '1', '对任何事情不反复确认就不放心。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('427', 'UPI', '1', '对脏很在乎。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('428', 'UPI', '1', '摆脱不了毫无意义的想法。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('429', 'UPI', '1', '觉得自己有怪气味。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('430', 'UPI', '1', '别人在自己背后说坏话。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('431', 'UPI', '1', '总注意周围的人。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('432', 'UPI', '1', '在乎别人的视线。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('433', 'UPI', '1', '觉得别人轻视自己。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('434', 'UPI', '1', '情绪易被破坏。', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('435', 'UPI', '1', '至今,你感到自身健康方面有问题吗?', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('436', 'UPI', '1', '至今,你曾觉得心理卫生方面有问题吗?', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('437', 'UPI', '1', '至今,你曾接受过心理咨询与治疗吗?', 'A、是的', 'B、不是的', null, null, null, null);
INSERT INTO `exam` VALUES ('438', 'UPI', '3', '你有健康或心理方面想咨询的问题吗?如果有请写下来。', '', '', null, null, null, null);

-- ----------------------------
-- Table structure for `examinfo`
-- ----------------------------
DROP TABLE IF EXISTS `examinfo`;
CREATE TABLE `examinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tableName` char(10) NOT NULL COMMENT '英文表名。作为外键使用',
  `examName` char(100) NOT NULL COMMENT '中文表名',
  `nation` varchar(1024) DEFAULT NULL COMMENT '考试须知',
  `type` int(11) DEFAULT '1' COMMENT '试卷的类型。如混合，单项',
  `count` int(11) NOT NULL DEFAULT '0' COMMENT '该套试卷的题数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tableName` (`tableName`),
  UNIQUE KEY `examName` (`examName`),
  KEY `examInfoType` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examinfo
-- ----------------------------
INSERT INTO `examinfo` VALUES ('1', 'UPI', '大学生人格问卷UPI', '指导语：以下问题是为了解你的健康状况并为了增进您的身心健康而设计的调查。请你按题号的顺序阅读，在最近一年中你常常感觉到或体验到的项目上做是选择。为了使你顺利完成学业，身心健康地去迎接新生活，请你真实选择。', '2', '1');
INSERT INTO `examinfo` VALUES ('2', 'K16pf', '卡特尔16种人格测试', '卡特尔16种人格因素包括一些个人兴趣和态度的问题。每个人都有自己的看法，对问题的回答自然也就不同。无所谓正确与错误，请尽量表达自己的意见。本测验共有187道题，每个题目有三个选项，回答时，请注意以下三点：\r\n    1.请不要费时斟酌。应当顺其自然地依你个人的反应回答。一般来说，问题都比较简短而没有包括所有有关的影响因素和条件。完成整个测评大概需要45-60分钟。\r\n2.除非在迫不得已的情况下，尽量避免选择如介于“A”与“C”之间、“不确定”之类的答案。\r\n3.请不要遗漏，务必对每一个问题作答。', '1', '187');
INSERT INTO `examinfo` VALUES ('3', 'IQtest', '智商测试', '每个人都希望自己是高智商的人，同时也希望知道自己的智商到底有多高。其实并不难，下面就是一例国际通用的智商测试题，它是对人的智力（指数字、空间、逻辑、词汇、创造、记忆）等能力综合测试，请你在30分钟内完成30个题，之后你就知道你自己的智商有多高了。', '2', '30');

-- ----------------------------
-- Table structure for `examtype`
-- ----------------------------
DROP TABLE IF EXISTS `examtype`;
CREATE TABLE `examtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '试卷类型编号',
  `memo` varchar(256) DEFAULT NULL COMMENT '试卷类型说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examtype
-- ----------------------------
INSERT INTO `examtype` VALUES ('1', '1', '普通表');

-- ----------------------------
-- Table structure for `iqteststandard`
-- ----------------------------
DROP TABLE IF EXISTS `iqteststandard`;
CREATE TABLE `iqteststandard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `standard` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iqteststandard
-- ----------------------------
INSERT INTO `iqteststandard` VALUES ('1', 'B ');
INSERT INTO `iqteststandard` VALUES ('2', 'C ');
INSERT INTO `iqteststandard` VALUES ('3', 'C');
INSERT INTO `iqteststandard` VALUES ('4', 'B');
INSERT INTO `iqteststandard` VALUES ('5', 'A');
INSERT INTO `iqteststandard` VALUES ('6', '26');
INSERT INTO `iqteststandard` VALUES ('7', 'A');
INSERT INTO `iqteststandard` VALUES ('8', 'A');
INSERT INTO `iqteststandard` VALUES ('9', 'A');
INSERT INTO `iqteststandard` VALUES ('10', 'C');
INSERT INTO `iqteststandard` VALUES ('11', '9');
INSERT INTO `iqteststandard` VALUES ('12', 'B');
INSERT INTO `iqteststandard` VALUES ('13', 'C');
INSERT INTO `iqteststandard` VALUES ('14', '6');
INSERT INTO `iqteststandard` VALUES ('15', 'C');
INSERT INTO `iqteststandard` VALUES ('16', '38');
INSERT INTO `iqteststandard` VALUES ('17', 'B');
INSERT INTO `iqteststandard` VALUES ('18', 'A');
INSERT INTO `iqteststandard` VALUES ('19', '美国');
INSERT INTO `iqteststandard` VALUES ('20', 'C');
INSERT INTO `iqteststandard` VALUES ('21', '64');
INSERT INTO `iqteststandard` VALUES ('22', '科学 ');
INSERT INTO `iqteststandard` VALUES ('23', '式');
INSERT INTO `iqteststandard` VALUES ('24', '60');
INSERT INTO `iqteststandard` VALUES ('25', 'C');
INSERT INTO `iqteststandard` VALUES ('26', '奠 ');
INSERT INTO `iqteststandard` VALUES ('27', '脑');
INSERT INTO `iqteststandard` VALUES ('28', '5');
INSERT INTO `iqteststandard` VALUES ('29', '36');
INSERT INTO `iqteststandard` VALUES ('30', 'O');

-- ----------------------------
-- Table structure for `k16pfstandard`
-- ----------------------------
DROP TABLE IF EXISTS `k16pfstandard`;
CREATE TABLE `k16pfstandard` (
  `id` int(11) NOT NULL,
  `a` int(11) NOT NULL,
  `b` int(11) NOT NULL,
  `c` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of k16pfstandard
-- ----------------------------
INSERT INTO `k16pfstandard` VALUES ('1', '0', '0', '0');
INSERT INTO `k16pfstandard` VALUES ('2', '0', '0', '0');
INSERT INTO `k16pfstandard` VALUES ('3', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('4', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('5', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('6', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('7', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('8', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('9', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('10', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('11', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('12', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('13', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('14', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('15', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('16', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('17', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('18', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('19', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('20', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('21', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('22', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('23', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('24', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('25', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('26', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('27', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('28', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('29', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('30', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('31', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('32', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('33', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('34', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('35', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('36', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('37', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('38', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('39', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('40', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('41', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('42', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('43', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('44', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('45', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('46', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('47', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('48', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('49', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('50', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('51', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('52', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('53', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('54', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('55', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('56', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('57', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('58', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('59', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('60', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('61', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('62', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('63', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('64', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('65', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('66', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('67', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('68', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('69', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('70', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('71', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('72', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('73', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('74', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('75', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('76', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('77', '0', '0', '1');
INSERT INTO `k16pfstandard` VALUES ('78', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('79', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('80', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('81', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('82', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('83', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('84', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('85', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('86', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('87', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('88', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('89', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('90', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('91', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('92', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('93', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('94', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('95', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('96', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('97', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('98', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('99', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('100', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('101', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('102', '2', '1', '1');
INSERT INTO `k16pfstandard` VALUES ('103', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('104', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('105', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('106', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('107', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('108', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('109', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('110', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('111', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('112', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('113', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('114', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('115', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('116', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('117', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('118', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('119', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('120', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('121', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('122', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('123', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('124', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('125', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('126', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('127', '0', '0', '1');
INSERT INTO `k16pfstandard` VALUES ('128', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('129', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('130', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('131', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('132', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('133', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('134', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('135', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('136', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('137', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('138', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('139', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('140', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('141', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('142', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('143', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('144', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('145', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('146', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('147', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('148', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('149', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('150', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('151', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('152', '0', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('153', '0', '0', '1');
INSERT INTO `k16pfstandard` VALUES ('154', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('155', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('156', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('157', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('158', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('159', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('160', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('161', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('162', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('163', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('164', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('165', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('166', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('167', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('168', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('169', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('170', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('171', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('172', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('173', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('174', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('175', '0', '1', '2');
INSERT INTO `k16pfstandard` VALUES ('176', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('177', '1', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('178', '1', '0', '0');
INSERT INTO `k16pfstandard` VALUES ('179', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('180', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('181', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('182', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('183', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('184', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('185', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('186', '2', '1', '0');
INSERT INTO `k16pfstandard` VALUES ('187', '0', '0', '0');

-- ----------------------------
-- Table structure for `liuyan`
-- ----------------------------
DROP TABLE IF EXISTS `liuyan`;
CREATE TABLE `liuyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(10) DEFAULT NULL COMMENT '留言人',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `tel` char(11) DEFAULT NULL COMMENT '电话',
  `note` varchar(255) NOT NULL DEFAULT '' COMMENT '留言内容',
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of liuyan
-- ----------------------------
INSERT INTO `liuyan` VALUES ('1', 'ccc', 'ccc', 'ccc', 'ccccc', '2016-01-17 16:48:15');
INSERT INTO `liuyan` VALUES ('2', 'ccc', 'ccc', 'ccc', 'ccc', '2016-01-17 16:49:04');
INSERT INTO `liuyan` VALUES ('3', 'ddd', '', 'ddd', 'ddd', '2016-01-17 16:51:21');

-- ----------------------------
-- Table structure for `questiontype`
-- ----------------------------
DROP TABLE IF EXISTS `questiontype`;
CREATE TABLE `questiontype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '试题的编号',
  `memo` varchar(256) NOT NULL COMMENT '试题类型的说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questiontype
-- ----------------------------

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` char(10) NOT NULL COMMENT '学生学号',
  `tableName` char(10) NOT NULL COMMENT '试卷名',
  `resultInfo` longtext NOT NULL COMMENT '测试结果',
  `resultABCD` text COMMENT '考试答案',
  `del` int(1) NOT NULL DEFAULT '1' COMMENT '是否可见',
  `resultDate` date NOT NULL COMMENT ' 交卷时间',
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `studentID` (`studentID`),
  KEY `tableName` (`tableName`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('1', '0961130402', 'IQtest', '您的IQ（智商）测试结果为：弱智', null, '1', '2016-01-02', '2016-01-02 11:23:03', '2016-01-02 11:23:11');
INSERT INTO `result` VALUES ('2', '0961130403', 'IQtest', '您的IQ（智商）测试结果为：弱智', null, '1', '2016-01-02', '2016-01-02 14:18:01', '2016-01-02 14:20:59');
INSERT INTO `result` VALUES ('3', '0961130404', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:1', null, '1', '2016-01-02', '2016-01-02 14:27:41', '2016-01-02 14:27:57');
INSERT INTO `result` VALUES ('4', '0961130405', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:1', '{1=B, 2=B, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=1}', '1', '2016-01-02', '2016-01-02 14:30:50', '2016-01-02 14:31:04');
INSERT INTO `result` VALUES ('5', '0961130406', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:1', '{1=B, 2=B, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=1}', '1', '2016-01-02', '2016-01-02 14:34:02', '2016-01-02 14:34:16');
INSERT INTO `result` VALUES ('6', '0961130407', 'UPI', '该生属于C类，没有特别问题。', '{1=B, 2=B, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=1}', '1', '2016-01-02', '2016-01-02 14:38:04', '2016-01-02 14:38:20');
INSERT INTO `result` VALUES ('7', '0961130423', 'IQtest', '您的IQ（智商）测试结果为：弱智', '{1=C, 2=B, 3=B, 4=B, 5=B, 6=, 7=C, 8=C, 9=C, 10=C, 11=, 12=A, 13=A, 14=, 15=B, 17=C, 16=, 19=, 18=C, 21=, 20=B, 23=, 22=, 25=B, 24=, 27=, 26=, 29=, 28=, 30=}', '1', '2016-01-08', '2016-01-08 12:43:20', '2016-01-08 12:43:43');
INSERT INTO `result` VALUES ('8', '0961130422', 'UPI', '该生属于C类，没有特别问题。该生问卷答案矛盾，建议重新测试！', '{1=B, 2=B, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=}', '1', '2016-01-08', '2016-01-08 12:45:37', '2016-01-08 12:45:54');
INSERT INTO `result` VALUES ('9', '0961130421', 'K16pf', '您的（乐群性）是低分特征：缄默，孤独，冷漠。您的（聪慧性）是低分特征：知识面比较窄，抽象思考能力比较弱。您的（稳定性）是低分特征：情绪激动，易生烦恼，心神动摇不定，易受环境支配。您的（恃强性）是低分特征：谦逊，顺从，通融，恭顺。您的（兴奋性）是低分特征：严肃，审慎，冷静，寡言。您的（有恒性）是低分特征：苟且敷衍，缺乏奉公守法的精神。您的（敢为性）是低分特征：畏怯退缩缺乏自信心。您的（敏感性）是低分特征：理智，着重现实，自食其力。您的（怀疑性）是低分特征：理智，着重现实，自食其力。您的（幻想性）是低分特征：现实，合乎成规，力求妥善合理。您的（世故性）是低分特征：坦白，直率，天真。您的（忧虑性）是低分特征：安详，沉着，有自信心。您的（实验性）是低分特征：保守的，尊重传统观念与行为标准。您的（独立性）是低分特征：依赖，随群附众。您的（自律性）是低分特征：矛盾冲突，不顾大体。您的（紧张性）是低分特征：心气平和，闲散宁静。适应于焦虑型低分特征：生活适应顺利，通常感到心满意足，能做到所期望的及自认为重要的事情。如分数极低，则可能对困难的工作缺乏毅力，有事事知难而退，不肯奋斗努力的倾向。高分特征：不一定有神经症，因为它可能是情境性的，但也可能有一些调节不良的情况，即对生活上所要求的和自己意欲达成的事情常感到不满意。高度的焦虑可能会使工作受到破坏和影响身体健康。您是中间状态。内向型与外向型：您是低分特征：内倾，趋于胆小，自足，在与别人接触中采取克制态度，有利于从事精细工作。这种类型无所谓利弊，主要取决于在哪种情况下采取这种态度。感情用事与安详机警型：情感丰富而感到困扰不安，它可能是缺乏信心、颓丧的类型，对生活中的细节较为含蓄敏感，性格温和，讲究生活艺术，采取行动前再三思考，顾虑太多。高分特征：富有事业心，果断，刚毅，有进取精神，精力充沛，行动迅速，但常忽视生活上的细节，只对明显的事物注意，有时会考虑不周，不计后果，冒然行事。您是中间状态。怯懦与果断型：您是低分特征：赖别人，纯洁，个性被动，受人驱使而不能独立，对支持他的人在行动上常适应其需求，为获取别人的欢心会事事迁就。您的心理健康因素为22分，心理健康状况几乎是一切职业及事业成功的基础。心理不健康者，其学习和工作效率都会因之减低。心理健康标准可介于4-40之间，均值为22分。低于12分者仅占人数分配的10%，情绪不稳定的程度颇为显著。您的专业有成就者的人格因素为10分，本次级因素意指人格中的某些因素可能对将来的专业成就所具有的影响，它并不代表将来专业成就所达到的水平。其总分可介于10-100之间，平均分为55，67以上者其成功的机会更大。您的创造力强者的人格因素为60分，高于70者属于创造力强者的范围，应有其成就。您的在新环境中有成长能力的人格因素为13分，本次级因素总分可介于4-40之间，平均值为22分，不足17分者仅占人数的10%左右，从事专业或训练成功的可能性较小。25分以上者，则有成功的希望。', '{1=C, 2=B, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 68=B, 69=B, 70=B, 71=B, 64=B, 65=B, 66=B, 67=B, 76=B, 77=B, 78=B, 79=B, 72=B, 73=B, 74=B, 75=B, 85=B, 84=B, 87=B, 86=B, 81=B, 80=B, 83=B, 82=B, 93=B, 92=B, 95=B, 94=B, 89=B, 88=B, 91=B, 90=B, 102=B, 103=B, 100=B, 101=B, 98=B, 99=B, 96=B, 97=B, 110=B, 111=B, 108=B, 109=B, 106=B, 107=B, 104=B, 105=B, 119=B, 118=B, 117=B, 116=B, 115=B, 114=B, 113=B, 112=B, 127=B, 126=B, 125=B, 124=B, 123=B, 122=B, 121=B, 120=B, 137=B, 136=B, 139=B, 138=B, 141=B, 140=B, 143=B, 142=B, 129=B, 128=B, 131=B, 130=B, 133=B, 132=B, 135=B, 134=B, 152=B, 153=B, 154=B, 155=B, 156=B, 157=B, 158=B, 159=B, 144=B, 145=B, 146=B, 147=B, 148=B, 149=B, 150=B, 151=B, 171=B, 170=B, 169=B, 168=B, 175=B, 174=B, 173=B, 172=B, 163=B, 162=B, 161=B, 160=B, 167=B, 166=B, 165=B, 164=B, 186=B, 187=B, 184=B, 185=B, 178=B, 179=B, 176=B, 177=B, 182=B, 183=B, 180=B, 181=B}', '1', '2016-01-08', '2016-01-08 12:52:28', '2016-01-08 12:54:38');
INSERT INTO `result` VALUES ('10', '0961130428', 'UPI', '该生属于C类，没有特别问题。', '{1=B, 2=A, 3=B, 4=A, 5=B, 6=A, 7=A, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=A, 16=B, 19=A, 18=A, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=}', '1', '2016-01-17', '2016-01-17 22:54:27', '2016-01-17 22:54:51');
INSERT INTO `result` VALUES ('11', '0961130428', 'IQtest', '您的IQ（智商）测试结果为：弱智', '{1=B, 2=C, 3=A, 4=B, 5=C, 6=, 7=B, 8=C, 9=B, 10=B, 11=, 12=A, 13=B, 14=, 15=C, 17=A, 16=, 19=, 18=C, 21=, 20=C, 23=, 22=, 25=C, 24=, 27=, 26=, 29=, 28=, 30=}', '1', '2016-04-17', '2016-04-17 09:43:37', '2016-04-17 10:29:22');
INSERT INTO `result` VALUES ('12', '0961130428', 'IQtest', '您的IQ（智商）测试结果为：弱智', '{1=B, 2=C, 3=A, 4=B, 5=C, 6=, 7=B, 8=C, 9=B, 10=B, 11=, 12=A, 13=B, 14=, 15=C, 17=A, 16=, 19=, 18=C, 21=, 20=C, 23=, 22=, 25=C, 24=, 27=, 26=, 29=, 28=, 30=}', '1', '2016-04-17', '2016-04-17 09:43:37', '2016-04-17 10:30:16');
INSERT INTO `result` VALUES ('13', '0961130428', 'IQtest', '您的IQ（智商）测试结果为：弱智', '{1=A, 2=B, 3=C, 4=B, 5=B, 6=, 7=A, 8=C, 9=C, 10=C, 11=, 12=A, 13=A, 14=, 15=A, 17=A, 16=, 19=, 18=A, 21=, 20=C, 23=, 22=, 25=C, 24=, 27=, 26=, 29=, 28=, 30=}', '1', '2016-04-17', '2016-04-17 20:18:13', '2016-04-17 20:21:27');
INSERT INTO `result` VALUES ('14', '0961130428', 'IQtest', '您的IQ（智商）测试结果为：弱智', '{1=B, 2=C, 3=C, 4=B, 5=B, 6=23, 7=A, 8=C, 9=C, 10=A, 11=6, 12=C, 13=C, 14=3, 15=A, 17=B, 16=23, 19=说的, 18=B, 21=24, 20=A, 23=为, 22=w, 25=B, 24=345, 27=g, 26=2, 29=1, 28=3, 30=3}', '1', '2016-04-20', '2016-04-20 11:26:27', '2016-04-20 11:28:18');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `studentID` char(10) NOT NULL COMMENT '学生学号',
  `sex` char(4) NOT NULL DEFAULT '' COMMENT '性别',
  `dept` char(40) NOT NULL COMMENT '院系',
  `major` varchar(40) NOT NULL COMMENT '专业',
  `tutor` char(8) NOT NULL COMMENT '导师',
  `year` int(11) NOT NULL COMMENT '入学年份',
  `grade` int(4) NOT NULL,
  `phone` char(11) DEFAULT NULL COMMENT '电话',
  `del` int(1) NOT NULL DEFAULT '1' COMMENT '是否删除，0为删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `studentID` (`studentID`) USING BTREE,
  KEY `dept` (`dept`) USING BTREE,
  KEY `studentTutor` (`tutor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张雅娟', '0961130428', '女', '数学与信息科技学院', '计算机科学与技术', '张三', '2013', '3', 'null', '1');
INSERT INTO `student` VALUES ('2', '赵芳卉', '0961130429', '女', '数学与信息科技学院', '计算机科学与技术', '张三', '2013', '3', 'null', '1');
INSERT INTO `student` VALUES ('3', '赵启森', '0961130430', '男', '数学与信息科技学院', '计算机科学与技术', '张三', '2013', '3', 'null', '1');

-- ----------------------------
-- Table structure for `temporaryresult`
-- ----------------------------
DROP TABLE IF EXISTS `temporaryresult`;
CREATE TABLE `temporaryresult` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) NOT NULL,
  `cardID` char(18) NOT NULL COMMENT '身份证号',
  `tableName` char(10) NOT NULL COMMENT '试卷名',
  `resultInfo` varchar(8000) NOT NULL COMMENT '测试结果',
  `resultABCD` varchar(1024) DEFAULT NULL COMMENT '考生答案',
  `dept` char(40) DEFAULT NULL COMMENT '院系',
  `del` int(11) NOT NULL DEFAULT '1' COMMENT '是否可查',
  `resultDate` date NOT NULL COMMENT '交卷时间',
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `temporaryTableName` (`tableName`),
  KEY `temporaryDept` (`dept`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temporaryresult
-- ----------------------------
INSERT INTO `temporaryresult` VALUES ('4', 'vv', '130623199307080925', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:aa', null, '数学与信息科技学院', '1', '2016-01-01', '2016-01-02 14:11:09', '2016-01-02 14:14:42');
INSERT INTO `temporaryresult` VALUES ('6', 'vv', '130623199307080925', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:1', '{1=B, 2=B, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=1}', '数学与信息科技学院', '1', '2016-01-02', '2016-01-02 14:31:53', '2016-01-02 14:33:01');
INSERT INTO `temporaryresult` VALUES ('8', '李侬', '130731199510270039', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:1该生问卷答案矛盾，建议重新测试！', '{1=B, 2=B, 3=B, 4=B, 5=A, 6=A, 7=A, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=A, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=1}', '数学与信息科技学院', '1', '2016-01-05', '2016-01-05 13:55:43', '2016-01-05 13:57:41');
INSERT INTO `temporaryresult` VALUES ('9', 'aa', '123456789012311111', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:1该生问卷答案矛盾，建议重新测试！', '{1=B, 2=B, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=1}', '', '1', '2016-01-07', '2016-01-07 09:39:13', '2016-01-07 09:40:42');
INSERT INTO `temporaryresult` VALUES ('10', 'aa', '123456789012311111', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:1该生问卷答案矛盾，建议重新测试！', '{1=B, 2=B, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=1}', '', '1', '2016-01-07', '2016-01-07 09:39:13', '2016-01-07 09:40:42');
INSERT INTO `temporaryresult` VALUES ('11', 'rrr', '130623199307080925', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:1该生问卷答案矛盾，建议重新测试！', '{1=B, 2=B, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=B, 10=B, 11=B, 12=B, 13=B, 14=B, 15=B, 17=B, 16=B, 19=B, 18=B, 21=B, 20=B, 23=B, 22=B, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=1}', '', '1', '2016-01-07', '2016-01-07 10:46:18', '2016-01-07 10:46:31');
INSERT INTO `temporaryresult` VALUES ('12', 'zhang', '130623199307080925', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。该生咨询问题为:1', '{1=B, 2=A, 3=B, 4=B, 5=B, 6=B, 7=B, 8=B, 9=A, 10=A, 11=A, 12=A, 13=A, 14=A, 15=B, 17=B, 16=B, 19=A, 18=A, 21=A, 20=A, 23=A, 22=A, 25=A, 24=A, 27=A, 26=A, 29=B, 28=A, 31=B, 30=B, 34=B, 35=B, 32=B, 33=A, 38=B, 39=B, 36=B, 37=B, 42=B, 43=B, 40=B, 41=B, 46=B, 47=B, 44=B, 45=B, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=1}', '', '1', '2016-01-08', '2016-01-08 12:37:37', '2016-01-08 12:38:55');
INSERT INTO `temporaryresult` VALUES ('13', '张三', '130623199307080925', 'UPI', '该生属于A类，需要继续进行心理咨询或心理治疗。', '{1=B, 2=B, 3=B, 4=A, 5=A, 6=A, 7=A, 8=A, 9=A, 10=A, 11=A, 12=A, 13=A, 14=A, 15=A, 17=A, 16=A, 19=A, 18=A, 21=A, 20=A, 23=A, 22=A, 25=B, 24=B, 27=B, 26=B, 29=B, 28=B, 31=B, 30=B, 34=B, 35=B, 32=B, 33=B, 38=A, 39=A, 36=B, 37=B, 42=A, 43=A, 40=A, 41=A, 46=B, 47=B, 44=A, 45=A, 51=B, 50=B, 49=B, 48=B, 55=B, 54=B, 53=B, 52=B, 59=B, 58=B, 57=B, 56=B, 63=B, 62=B, 61=B, 60=B, 64=}', '', '1', '2016-01-08', '2016-01-08 12:40:55', '2016-01-08 12:41:51');
