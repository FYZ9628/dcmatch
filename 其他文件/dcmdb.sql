/*
Navicat MySQL Data Transfer

Source Server         : MySQL5.5
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : dcmdb

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2020-05-28 20:00:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account` (`account`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `src` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('1', 'banner', 'http://localhost:8999/api/file/banner.jpg');
INSERT INTO `banner` VALUES ('2', 'banner_11', 'http://localhost:8999/api/file/banner_11.jpg');
INSERT INTO `banner` VALUES ('3', 'banner_hr', 'http://localhost:8999/api/file/banner_hr.jpg');
INSERT INTO `banner` VALUES ('4', 'banner-lvyue', 'http://localhost:8999/api/file/banner-lvyue.jpg');

-- ----------------------------
-- Table structure for contest
-- ----------------------------
DROP TABLE IF EXISTS `contest`;
CREATE TABLE `contest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contest_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `state` varchar(20) NOT NULL,
  `ticket_number` varchar(20) NOT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `contest_id` (`contest_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `contest_ibfk_1` FOREIGN KEY (`contest_id`) REFERENCES `contest_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contest_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contest
-- ----------------------------
INSERT INTO `contest` VALUES ('1', '7', '6', '查看成绩', '914980867382', '89');
INSERT INTO `contest` VALUES ('2', '9', '6', '已报名', '232926972225', '0');
INSERT INTO `contest` VALUES ('3', '14', '6', '已报名', '709130006678', '0');
INSERT INTO `contest` VALUES ('4', '17', '6', '已报名', '425215483018', '0');
INSERT INTO `contest` VALUES ('5', '7', '18', '查看成绩', '821789283866', '90');
INSERT INTO `contest` VALUES ('6', '9', '18', '已报名', '833239001090', '0');
INSERT INTO `contest` VALUES ('7', '12', '18', '已报名', '226163477307', '0');
INSERT INTO `contest` VALUES ('8', '14', '18', '已报名', '432332726912', '0');
INSERT INTO `contest` VALUES ('9', '17', '18', '已报名', '059718735534', '0');
INSERT INTO `contest` VALUES ('10', '7', '10', '查看成绩', '923706720192', '87');
INSERT INTO `contest` VALUES ('11', '9', '10', '已报名', '853900583152', '0');
INSERT INTO `contest` VALUES ('12', '14', '10', '已报名', '496798587575', '0');
INSERT INTO `contest` VALUES ('13', '17', '10', '已报名', '861518950261', '0');
INSERT INTO `contest` VALUES ('14', '15', '10', '已报名', '463401478800', '0');
INSERT INTO `contest` VALUES ('15', '7', '7', '查看成绩', '548511602695', '73');
INSERT INTO `contest` VALUES ('16', '9', '7', '已报名', '371772765324', '0');
INSERT INTO `contest` VALUES ('17', '12', '7', '已报名', '808101129364', '0');
INSERT INTO `contest` VALUES ('18', '17', '7', '已报名', '952940058539', '0');
INSERT INTO `contest` VALUES ('19', '7', '9', '查看成绩', '067363345295', '93');
INSERT INTO `contest` VALUES ('20', '9', '9', '已报名', '355032715249', '0');
INSERT INTO `contest` VALUES ('21', '12', '9', '已报名', '573983946324', '0');
INSERT INTO `contest` VALUES ('22', '14', '9', '已报名', '917556165128', '0');
INSERT INTO `contest` VALUES ('23', '17', '9', '已报名', '435860603977', '0');
INSERT INTO `contest` VALUES ('24', '7', '11', '查看成绩', '405921763952', '45');
INSERT INTO `contest` VALUES ('25', '9', '11', '已报名', '199486561973', '0');
INSERT INTO `contest` VALUES ('26', '14', '11', '已报名', '186069206099', '0');
INSERT INTO `contest` VALUES ('27', '17', '11', '已报名', '924749151596', '0');
INSERT INTO `contest` VALUES ('28', '7', '12', '查看成绩', '624600570753', '65');
INSERT INTO `contest` VALUES ('29', '9', '12', '已报名', '333857352312', '0');
INSERT INTO `contest` VALUES ('30', '12', '12', '已报名', '796294699118', '0');
INSERT INTO `contest` VALUES ('31', '17', '12', '已报名', '916114802355', '0');
INSERT INTO `contest` VALUES ('32', '7', '14', '查看成绩', '262029308982', '78');
INSERT INTO `contest` VALUES ('33', '9', '14', '已报名', '977700041901', '0');
INSERT INTO `contest` VALUES ('34', '14', '14', '已报名', '194000464033', '0');
INSERT INTO `contest` VALUES ('35', '17', '14', '已报名', '075689231120', '0');
INSERT INTO `contest` VALUES ('36', '7', '15', '查看成绩', '239585345340', '99');
INSERT INTO `contest` VALUES ('37', '9', '15', '已报名', '195609769336', '0');
INSERT INTO `contest` VALUES ('38', '7', '16', '查看成绩', '339140773364', '97');
INSERT INTO `contest` VALUES ('39', '9', '16', '已报名', '703071229071', '0');
INSERT INTO `contest` VALUES ('40', '7', '17', '查看成绩', '455949618836', '94');
INSERT INTO `contest` VALUES ('41', '9', '17', '已报名', '128781421657', '0');
INSERT INTO `contest` VALUES ('42', '7', '19', '查看成绩', '268092228838', '68');
INSERT INTO `contest` VALUES ('43', '9', '19', '已报名', '103288543154', '0');
INSERT INTO `contest` VALUES ('44', '7', '20', '查看成绩', '439489386127', '85');
INSERT INTO `contest` VALUES ('45', '9', '20', '已报名', '971541422070', '0');
INSERT INTO `contest` VALUES ('46', '7', '21', '查看成绩', '638931911058', '84');
INSERT INTO `contest` VALUES ('47', '9', '21', '已报名', '878718007624', '0');

-- ----------------------------
-- Table structure for contest_detail
-- ----------------------------
DROP TABLE IF EXISTS `contest_detail`;
CREATE TABLE `contest_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contest_title` varchar(255) NOT NULL,
  `organizer_id` int(11) NOT NULL,
  `contest_content` longtext NOT NULL,
  `sign_up_start_time` datetime NOT NULL,
  `sign_up_end_time` datetime NOT NULL,
  `publish_time` datetime NOT NULL,
  `place` varchar(255) DEFAULT NULL,
  `hold_date` varchar(255) DEFAULT NULL,
  `hold_start_time` varchar(255) DEFAULT NULL,
  `hold_end_time` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `upper_limit` int(11) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `organizer_id` (`organizer_id`),
  CONSTRAINT `contest_detail_ibfk_1` FOREIGN KEY (`organizer_id`) REFERENCES `organizer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contest_detail
-- ----------------------------
INSERT INTO `contest_detail` VALUES ('7', '2016年数学竞赛【个人赛】', '7', '2016年数学竞赛内容\n竞赛数学是一门学科的延伸。数学竞赛是一项活动的举行。 竞赛数学是奥数的标准书面用语，奥数是奥林匹克数学的简称，泛指数学难题，奥林匹克数学是个奥林匹克运动得名，科学标准的说法应该叫竞赛数学。\n由于竞赛数学是伴随着数学竞赛而产生的，因此，谈到竞赛数学的产生我们先要探究一下数学竞赛。\n1，数学竞赛的简史\n数学竞赛与体育竞赛相类似，它是青少年的一种智力竞赛，所以苏联人首创了\"数学奥林匹克\"这个名词。在类似的以基础科学为竞赛内容的智力竞赛中，数学竞赛历史悠久，参赛国多，影响也最大。\n比较正规的数学竞赛是1894年在匈牙利开始的，除因两次世界大战及1956年事件而停止了7届外，迄今已举行过90多届。苏联的数学竞赛开始于1934年，美国的数学竞赛则是1938年开始的。这两个国家除第二次世界大战期间各停止了3年外，均己举行过50多届，其他有长久数学竞赛历史的国家是罗马尼亚（始于1902年）、保加利亚（始于1949年）和中国（始于1956年）。', '2016-04-07 17:18:45', '2016-04-22 00:00:00', '2016-04-07 17:18:45', '广西民族大学东校区多媒体101', '2016-04-23', '09:30', '11:30', '个人赛', '1', '查看成绩阶段');
INSERT INTO `contest_detail` VALUES ('8', '2017年数学竞赛【团队赛】', '7', '2017年数学竞赛内容\n竞赛数学是一门学科的延伸。数学竞赛是一项活动的举行。 竞赛数学是奥数的标准书面用语，奥数是奥林匹克数学的简称，泛指数学难题，奥林匹克数学是个奥林匹克运动得名，科学标准的说法应该叫竞赛数学。\n由于竞赛数学是伴随着数学竞赛而产生的，因此，谈到竞赛数学的产生我们先要探究一下数学竞赛。\n1，数学竞赛的简史\n数学竞赛与体育竞赛相类似，它是青少年的一种智力竞赛，所以苏联人首创了\"数学奥林匹克\"这个名词。在类似的以基础科学为竞赛内容的智力竞赛中，数学竞赛历史悠久，参赛国多，影响也最大。\n比较正规的数学竞赛是1894年在匈牙利开始的，除因两次世界大战及1956年事件而停止了7届外，迄今已举行过90多届。苏联的数学竞赛开始于1934年，美国的数学竞赛则是1938年开始的。这两个国家除第二次世界大战期间各停止了3年外，均己举行过50多届，其他有长久数学竞赛历史的国家是罗马尼亚（始于1902年）、保加利亚（始于1949年）和中国（始于1956年）。', '2017-04-19 00:00:00', '2017-04-27 00:00:00', '2017-02-19 00:00:00', '广西民族大学东校区多媒体202', '2017-04-29', '14:30', '16:30', '团队赛', '5', '查看成绩阶段');
INSERT INTO `contest_detail` VALUES ('9', '2018年数学竞赛【个人赛】', '7', '2018年数学竞赛内容\n竞赛数学是一门学科的延伸。数学竞赛是一项活动的举行。 竞赛数学是奥数的标准书面用语，奥数是奥林匹克数学的简称，泛指数学难题，奥林匹克数学是个奥林匹克运动得名，科学标准的说法应该叫竞赛数学。\n由于竞赛数学是伴随着数学竞赛而产生的，因此，谈到竞赛数学的产生我们先要探究一下数学竞赛。\n1，数学竞赛的简史\n数学竞赛与体育竞赛相类似，它是青少年的一种智力竞赛，所以苏联人首创了\"数学奥林匹克\"这个名词。在类似的以基础科学为竞赛内容的智力竞赛中，数学竞赛历史悠久，参赛国多，影响也最大。\n比较正规的数学竞赛是1894年在匈牙利开始的，除因两次世界大战及1956年事件而停止了7届外，迄今已举行过90多届。苏联的数学竞赛开始于1934年，美国的数学竞赛则是1938年开始的。这两个国家除第二次世界大战期间各停止了3年外，均己举行过50多届，其他有长久数学竞赛历史的国家是罗马尼亚（始于1902年）、保加利亚（始于1949年）和中国（始于1956年）。', '2018-04-12 17:18:45', '2018-04-15 17:18:45', '2018-04-12 17:18:45', '广西民族大学东校区多媒体101', '2018-04-23', '09:30', '11:30', '个人赛', '1', '报名阶段');
INSERT INTO `contest_detail` VALUES ('10', '2019年数学竞赛【团队赛】', '7', '2019年数学竞赛内容\n竞赛数学是一门学科的延伸。数学竞赛是一项活动的举行。 竞赛数学是奥数的标准书面用语，奥数是奥林匹克数学的简称，泛指数学难题，奥林匹克数学是个奥林匹克运动得名，科学标准的说法应该叫竞赛数学。\n由于竞赛数学是伴随着数学竞赛而产生的，因此，谈到竞赛数学的产生我们先要探究一下数学竞赛。\n1，数学竞赛的简史\n数学竞赛与体育竞赛相类似，它是青少年的一种智力竞赛，所以苏联人首创了\"数学奥林匹克\"这个名词。在类似的以基础科学为竞赛内容的智力竞赛中，数学竞赛历史悠久，参赛国多，影响也最大。\n比较正规的数学竞赛是1894年在匈牙利开始的，除因两次世界大战及1956年事件而停止了7届外，迄今已举行过90多届。苏联的数学竞赛开始于1934年，美国的数学竞赛则是1938年开始的。这两个国家除第二次世界大战期间各停止了3年外，均己举行过50多届，其他有长久数学竞赛历史的国家是罗马尼亚（始于1902年）、保加利亚（始于1949年）和中国（始于1956年）。', '2019-05-16 00:00:00', '2019-05-25 00:00:00', '2019-04-16 00:00:00', '广西民族大学东校区多媒体202', '2019-04-29', '14:30', '16:30', '团队赛', '5', '录入成绩阶段');
INSERT INTO `contest_detail` VALUES ('11', '2015年诗词大赛【团队赛】', '8', '2015年诗词大赛\n四届“诗词中国”传统诗词创作大赛获奖名单经过为期5天面向全社会的公示，现正式揭晓。\n\n第四届“诗词中国”传统诗词创作大赛成人组总计产生获奖作品279首，其中绝句94首，律诗75首，词94首，古风16首；279个奖项中一等奖21首，二等奖32首，三等奖77首，优秀奖149首。\n\n青少组总计产生获奖作品152首，其中绝句44首，律诗24首，词31首，古风53首；152个年度奖项中一等奖7首，二等奖13首，三等奖50首，优秀奖82首。\n\n本届大赛还收到来自海外12个国家及地区的253首投稿作品。海外投稿作品共产生获奖作品25首，获奖作品不分体裁，其中一等奖5首，二等奖9首，三等奖11首。', '2015-04-14 00:00:00', '2015-04-24 00:00:00', '2015-04-14 00:00:00', '广西民族大学东校区多媒体301', '2015-04-25', '09:00', '12:00', '团队赛', '4', '报名阶段');
INSERT INTO `contest_detail` VALUES ('12', '2016年诗词大赛【个人赛】', '8', '2016年诗词大赛内容\n四届“诗词中国”传统诗词创作大赛获奖名单经过为期5天面向全社会的公示，现正式揭晓。\n\n第四届“诗词中国”传统诗词创作大赛成人组总计产生获奖作品279首，其中绝句94首，律诗75首，词94首，古风16首；279个奖项中一等奖21首，二等奖32首，三等奖77首，优秀奖149首。\n\n青少组总计产生获奖作品152首，其中绝句44首，律诗24首，词31首，古风53首；152个年度奖项中一等奖7首，二等奖13首，三等奖50首，优秀奖82首。\n\n本届大赛还收到来自海外12个国家及地区的253首投稿作品。海外投稿作品共产生获奖作品25首，获奖作品不分体裁，其中一等奖5首，二等奖9首，三等奖11首。', '2016-04-20 00:00:00', '2016-04-22 00:00:00', '2016-03-20 00:00:00', '广西民族大学东校区多媒体401', '2016-04-24', '09:30', '12:30', '个人赛', '1', '报名阶段');
INSERT INTO `contest_detail` VALUES ('13', '2017年诗词大赛【团队赛】', '8', '2017年诗词大赛\n四届“诗词中国”传统诗词创作大赛获奖名单经过为期5天面向全社会的公示，现正式揭晓。\n\n第四届“诗词中国”传统诗词创作大赛成人组总计产生获奖作品279首，其中绝句94首，律诗75首，词94首，古风16首；279个奖项中一等奖21首，二等奖32首，三等奖77首，优秀奖149首。\n\n青少组总计产生获奖作品152首，其中绝句44首，律诗24首，词31首，古风53首；152个年度奖项中一等奖7首，二等奖13首，三等奖50首，优秀奖82首。\n\n本届大赛还收到来自海外12个国家及地区的253首投稿作品。海外投稿作品共产生获奖作品25首，获奖作品不分体裁，其中一等奖5首，二等奖9首，三等奖11首。', '2017-04-19 00:00:00', '2017-04-27 00:00:00', '2017-04-19 00:00:00', '广西民族大学东校区多媒体301', '2017-04-25', '09:00', '12:00', '团队赛', '4', '报名阶段');
INSERT INTO `contest_detail` VALUES ('14', '2018年诗词大赛【个人赛】', '8', '2018年诗词大赛内容\n四届“诗词中国”传统诗词创作大赛获奖名单经过为期5天面向全社会的公示，现正式揭晓。\n\n第四届“诗词中国”传统诗词创作大赛成人组总计产生获奖作品279首，其中绝句94首，律诗75首，词94首，古风16首；279个奖项中一等奖21首，二等奖32首，三等奖77首，优秀奖149首。\n\n青少组总计产生获奖作品152首，其中绝句44首，律诗24首，词31首，古风53首；152个年度奖项中一等奖7首，二等奖13首，三等奖50首，优秀奖82首。\n\n本届大赛还收到来自海外12个国家及地区的253首投稿作品。海外投稿作品共产生获奖作品25首，获奖作品不分体裁，其中一等奖5首，二等奖9首，三等奖11首。', '2018-04-12 17:18:45', '2018-04-15 17:18:45', '2018-03-12 17:18:45', '广西民族大学东校区多媒体401', '2018-04-24', '09:30', '12:30', '个人赛', '1', '报名阶段');
INSERT INTO `contest_detail` VALUES ('15', '2016年英语竞赛【个人赛】', '9', '2016年英语竞赛内容\n竞赛数学是一门学科的延伸。数学竞赛是一项活动的举行。 竞赛数学是奥数的标准书面用语，奥数是奥林匹克数学的简称，泛指数学难题，奥林匹克数学是个奥林匹克运动得名，科学标准的说法应该叫竞赛数学。\n由于竞赛数学是伴随着数学竞赛而产生的，因此，谈到竞赛数学的产生我们先要探究一下数学竞赛。\n1，数学竞赛的简史\n数学竞赛与体育竞赛相类似，它是青少年的一种智力竞赛，所以苏联人首创了\"数学奥林匹克\"这个名词。在类似的以基础科学为竞赛内容的智力竞赛中，数学竞赛历史悠久，参赛国多，影响也最大。\n比较正规的数学竞赛是1894年在匈牙利开始的，除因两次世界大战及1956年事件而停止了7届外，迄今已举行过90多届。苏联的数学竞赛开始于1934年，美国的数学竞赛则是1938年开始的。这两个国家除第二次世界大战期间各停止了3年外，均己举行过50多届，其他有长久数学竞赛历史的国家是罗马尼亚（始于1902年）、保加利亚（始于1949年）和中国（始于1956年）。', '2016-04-07 17:18:45', '2016-04-22 00:00:00', '2016-02-07 17:18:45', '广西民族大学东校区多媒体101', '2016-04-23', '09:30', '11:30', '个人赛', '1', '报名阶段');
INSERT INTO `contest_detail` VALUES ('16', '2017年英语竞赛【团队赛】', '10', '2017年英语竞赛内容\n竞赛数学是一门学科的延伸。数学竞赛是一项活动的举行。 竞赛数学是奥数的标准书面用语，奥数是奥林匹克数学的简称，泛指数学难题，奥林匹克数学是个奥林匹克运动得名，科学标准的说法应该叫竞赛数学。\n由于竞赛数学是伴随着数学竞赛而产生的，因此，谈到竞赛数学的产生我们先要探究一下数学竞赛。\n1，数学竞赛的简史\n数学竞赛与体育竞赛相类似，它是青少年的一种智力竞赛，所以苏联人首创了\"数学奥林匹克\"这个名词。在类似的以基础科学为竞赛内容的智力竞赛中，数学竞赛历史悠久，参赛国多，影响也最大。\n比较正规的数学竞赛是1894年在匈牙利开始的，除因两次世界大战及1956年事件而停止了7届外，迄今已举行过90多届。苏联的数学竞赛开始于1934年，美国的数学竞赛则是1938年开始的。这两个国家除第二次世界大战期间各停止了3年外，均己举行过50多届，其他有长久数学竞赛历史的国家是罗马尼亚（始于1902年）、保加利亚（始于1949年）和中国（始于1956年）。', '2017-04-19 00:00:00', '2017-04-27 00:00:00', '2017-04-19 00:00:00', '广西民族大学东校区多媒体202', '2017-04-29', '14:30', '16:30', '团队赛', '5', '报名阶段');
INSERT INTO `contest_detail` VALUES ('17', '2018年英语竞赛【个人赛】', '11', '2018年英语竞赛内容\n竞赛数学是一门学科的延伸。数学竞赛是一项活动的举行。 竞赛数学是奥数的标准书面用语，奥数是奥林匹克数学的简称，泛指数学难题，奥林匹克数学是个奥林匹克运动得名，科学标准的说法应该叫竞赛数学。\n由于竞赛数学是伴随着数学竞赛而产生的，因此，谈到竞赛数学的产生我们先要探究一下数学竞赛。\n1，数学竞赛的简史\n数学竞赛与体育竞赛相类似，它是青少年的一种智力竞赛，所以苏联人首创了\"数学奥林匹克\"这个名词。在类似的以基础科学为竞赛内容的智力竞赛中，数学竞赛历史悠久，参赛国多，影响也最大。\n比较正规的数学竞赛是1894年在匈牙利开始的，除因两次世界大战及1956年事件而停止了7届外，迄今已举行过90多届。苏联的数学竞赛开始于1934年，美国的数学竞赛则是1938年开始的。这两个国家除第二次世界大战期间各停止了3年外，均己举行过50多届，其他有长久数学竞赛历史的国家是罗马尼亚（始于1902年）、保加利亚（始于1949年）和中国（始于1956年）。', '2018-04-12 17:18:45', '2018-04-15 17:18:45', '2018-03-12 17:18:45', '广西民族大学东校区多媒体101', '2018-04-23', '09:30', '11:30', '个人赛', '1', '报名阶段');
INSERT INTO `contest_detail` VALUES ('18', '2019年英语竞赛【团队赛】', '12', '2019年英语竞赛内容\n竞赛数学是一门学科的延伸。数学竞赛是一项活动的举行。 竞赛数学是奥数的标准书面用语，奥数是奥林匹克数学的简称，泛指数学难题，奥林匹克数学是个奥林匹克运动得名，科学标准的说法应该叫竞赛数学。\n由于竞赛数学是伴随着数学竞赛而产生的，因此，谈到竞赛数学的产生我们先要探究一下数学竞赛。\n1，数学竞赛的简史\n数学竞赛与体育竞赛相类似，它是青少年的一种智力竞赛，所以苏联人首创了\"数学奥林匹克\"这个名词。在类似的以基础科学为竞赛内容的智力竞赛中，数学竞赛历史悠久，参赛国多，影响也最大。\n比较正规的数学竞赛是1894年在匈牙利开始的，除因两次世界大战及1956年事件而停止了7届外，迄今已举行过90多届。苏联的数学竞赛开始于1934年，美国的数学竞赛则是1938年开始的。这两个国家除第二次世界大战期间各停止了3年外，均己举行过50多届，其他有长久数学竞赛历史的国家是罗马尼亚（始于1902年）、保加利亚（始于1949年）和中国（始于1956年）。', '2019-05-16 00:00:00', '2019-05-25 00:00:00', '2019-05-16 00:00:00', '广西民族大学东校区多媒体202', '2019-04-29', '14:30', '16:30', '团队赛', '5', '报名阶段');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `time` datetime DEFAULT NULL,
  `organizer_id` int(11) NOT NULL,
  `content` longtext,
  PRIMARY KEY (`id`),
  KEY `organizer_id` (`organizer_id`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`organizer_id`) REFERENCES `organizer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('12', '关于举办2016年数学竞赛的通知', '2020-04-14 17:25:09', '7', '关于举办2016年数学竞赛的通知的内容\n国际数学奥林匹克开始举办后，参赛各国的备赛工作往往主要是对选手进行一次强化培训，以拓广他们的知识，提高他们的解题能力。这种培训课程是很难的，比中学数学深了很多。这时就需要少数数学家专门从事这项活动。\n“竞赛数学”是随着数学教育课程的发展而产生的一门新课程。课程涉及数学竞赛的内容、思想和方法；也涉及到数学竞赛教育和数学课外教育的本质、方法、规律和途径的问题；课外学习与课堂学习的关系问题；辅导教师的进修和提高的问题。课程以数学竞赛所涉及的主要内容：数论、代数、几何及组合数学为载体，尤其注重数学思想和方法的探究，以提高学生的数学素养为目标。\n竞赛数学又不同于上述这些数学领域。通常数学往往追求证明一些概括广泛的定理，而竞赛数学恰恰寻求一些特殊的问题，通常数学追求建立一般的理论和方法，而竞赛数学则追求用特殊方法来解决特殊问题；而且一旦某个问题面世，即成为陈题，又需继续创造新的问题。竞赛数学属于\"硬\"数学范畴，它通常也与纯粹数学一样，以其内在美，包括问题的简练和解法的巧妙，作为衡量其价值的重要标准。');
INSERT INTO `notice` VALUES ('13', '关于举办2017年数学竞赛的通知', '2020-04-14 17:25:09', '7', '关于举办2017年数学竞赛的通知的内容\n国际数学奥林匹克开始举办后，参赛各国的备赛工作往往主要是对选手进行一次强化培训，以拓广他们的知识，提高他们的解题能力。这种培训课程是很难的，比中学数学深了很多。这时就需要少数数学家专门从事这项活动。\n“竞赛数学”是随着数学教育课程的发展而产生的一门新课程。课程涉及数学竞赛的内容、思想和方法；也涉及到数学竞赛教育和数学课外教育的本质、方法、规律和途径的问题；课外学习与课堂学习的关系问题；辅导教师的进修和提高的问题。课程以数学竞赛所涉及的主要内容：数论、代数、几何及组合数学为载体，尤其注重数学思想和方法的探究，以提高学生的数学素养为目标。\n竞赛数学又不同于上述这些数学领域。通常数学往往追求证明一些概括广泛的定理，而竞赛数学恰恰寻求一些特殊的问题，通常数学追求建立一般的理论和方法，而竞赛数学则追求用特殊方法来解决特殊问题；而且一旦某个问题面世，即成为陈题，又需继续创造新的问题。竞赛数学属于\"硬\"数学范畴，它通常也与纯粹数学一样，以其内在美，包括问题的简练和解法的巧妙，作为衡量其价值的重要标准。');
INSERT INTO `notice` VALUES ('14', '关于举办2018年数学竞赛的通知', '2020-04-14 17:25:09', '7', '关于举办2018年数学竞赛的通知的内容\n国际数学奥林匹克开始举办后，参赛各国的备赛工作往往主要是对选手进行一次强化培训，以拓广他们的知识，提高他们的解题能力。这种培训课程是很难的，比中学数学深了很多。这时就需要少数数学家专门从事这项活动。\n“竞赛数学”是随着数学教育课程的发展而产生的一门新课程。课程涉及数学竞赛的内容、思想和方法；也涉及到数学竞赛教育和数学课外教育的本质、方法、规律和途径的问题；课外学习与课堂学习的关系问题；辅导教师的进修和提高的问题。课程以数学竞赛所涉及的主要内容：数论、代数、几何及组合数学为载体，尤其注重数学思想和方法的探究，以提高学生的数学素养为目标。\n竞赛数学又不同于上述这些数学领域。通常数学往往追求证明一些概括广泛的定理，而竞赛数学恰恰寻求一些特殊的问题，通常数学追求建立一般的理论和方法，而竞赛数学则追求用特殊方法来解决特殊问题；而且一旦某个问题面世，即成为陈题，又需继续创造新的问题。竞赛数学属于\"硬\"数学范畴，它通常也与纯粹数学一样，以其内在美，包括问题的简练和解法的巧妙，作为衡量其价值的重要标准。');
INSERT INTO `notice` VALUES ('15', '关于举办2019年数学竞赛的通知', '2020-04-14 17:25:09', '7', '关于举办2019年数学竞赛的通知的内容\n国际数学奥林匹克开始举办后，参赛各国的备赛工作往往主要是对选手进行一次强化培训，以拓广他们的知识，提高他们的解题能力。这种培训课程是很难的，比中学数学深了很多。这时就需要少数数学家专门从事这项活动。\n“竞赛数学”是随着数学教育课程的发展而产生的一门新课程。课程涉及数学竞赛的内容、思想和方法；也涉及到数学竞赛教育和数学课外教育的本质、方法、规律和途径的问题；课外学习与课堂学习的关系问题；辅导教师的进修和提高的问题。课程以数学竞赛所涉及的主要内容：数论、代数、几何及组合数学为载体，尤其注重数学思想和方法的探究，以提高学生的数学素养为目标。\n竞赛数学又不同于上述这些数学领域。通常数学往往追求证明一些概括广泛的定理，而竞赛数学恰恰寻求一些特殊的问题，通常数学追求建立一般的理论和方法，而竞赛数学则追求用特殊方法来解决特殊问题；而且一旦某个问题面世，即成为陈题，又需继续创造新的问题。竞赛数学属于\"硬\"数学范畴，它通常也与纯粹数学一样，以其内在美，包括问题的简练和解法的巧妙，作为衡量其价值的重要标准。');
INSERT INTO `notice` VALUES ('16', '关于举办2016年英语竞赛的通知', '2020-04-14 17:25:09', '11', '关于举办2016年英语竞赛的通知的内容\n国际数学奥林匹克开始举办后，参赛各国的备赛工作往往主要是对选手进行一次强化培训，以拓广他们的知识，提高他们的解题能力。这种培训课程是很难的，比中学数学深了很多。这时就需要少数数学家专门从事这项活动。\n“竞赛数学”是随着数学教育课程的发展而产生的一门新课程。课程涉及数学竞赛的内容、思想和方法；也涉及到数学竞赛教育和数学课外教育的本质、方法、规律和途径的问题；课外学习与课堂学习的关系问题；辅导教师的进修和提高的问题。课程以数学竞赛所涉及的主要内容：数论、代数、几何及组合数学为载体，尤其注重数学思想和方法的探究，以提高学生的数学素养为目标。\n竞赛数学又不同于上述这些数学领域。通常数学往往追求证明一些概括广泛的定理，而竞赛数学恰恰寻求一些特殊的问题，通常数学追求建立一般的理论和方法，而竞赛数学则追求用特殊方法来解决特殊问题；而且一旦某个问题面世，即成为陈题，又需继续创造新的问题。竞赛数学属于\"硬\"数学范畴，它通常也与纯粹数学一样，以其内在美，包括问题的简练和解法的巧妙，作为衡量其价值的重要标准。');
INSERT INTO `notice` VALUES ('17', '关于举办2017年英语竞赛的通知', '2020-04-14 17:25:09', '12', '关于举办2017年英语竞赛的通知的内容\n国际数学奥林匹克开始举办后，参赛各国的备赛工作往往主要是对选手进行一次强化培训，以拓广他们的知识，提高他们的解题能力。这种培训课程是很难的，比中学数学深了很多。这时就需要少数数学家专门从事这项活动。\n“竞赛数学”是随着数学教育课程的发展而产生的一门新课程。课程涉及数学竞赛的内容、思想和方法；也涉及到数学竞赛教育和数学课外教育的本质、方法、规律和途径的问题；课外学习与课堂学习的关系问题；辅导教师的进修和提高的问题。课程以数学竞赛所涉及的主要内容：数论、代数、几何及组合数学为载体，尤其注重数学思想和方法的探究，以提高学生的数学素养为目标。\n竞赛数学又不同于上述这些数学领域。通常数学往往追求证明一些概括广泛的定理，而竞赛数学恰恰寻求一些特殊的问题，通常数学追求建立一般的理论和方法，而竞赛数学则追求用特殊方法来解决特殊问题；而且一旦某个问题面世，即成为陈题，又需继续创造新的问题。竞赛数学属于\"硬\"数学范畴，它通常也与纯粹数学一样，以其内在美，包括问题的简练和解法的巧妙，作为衡量其价值的重要标准。');
INSERT INTO `notice` VALUES ('18', '关于举办2018年英语竞赛的通知', '2020-04-14 17:25:09', '13', '关于举办2018年英语竞赛的通知的内容\n国际数学奥林匹克开始举办后，参赛各国的备赛工作往往主要是对选手进行一次强化培训，以拓广他们的知识，提高他们的解题能力。这种培训课程是很难的，比中学数学深了很多。这时就需要少数数学家专门从事这项活动。\n“竞赛数学”是随着数学教育课程的发展而产生的一门新课程。课程涉及数学竞赛的内容、思想和方法；也涉及到数学竞赛教育和数学课外教育的本质、方法、规律和途径的问题；课外学习与课堂学习的关系问题；辅导教师的进修和提高的问题。课程以数学竞赛所涉及的主要内容：数论、代数、几何及组合数学为载体，尤其注重数学思想和方法的探究，以提高学生的数学素养为目标。\n竞赛数学又不同于上述这些数学领域。通常数学往往追求证明一些概括广泛的定理，而竞赛数学恰恰寻求一些特殊的问题，通常数学追求建立一般的理论和方法，而竞赛数学则追求用特殊方法来解决特殊问题；而且一旦某个问题面世，即成为陈题，又需继续创造新的问题。竞赛数学属于\"硬\"数学范畴，它通常也与纯粹数学一样，以其内在美，包括问题的简练和解法的巧妙，作为衡量其价值的重要标准。');
INSERT INTO `notice` VALUES ('19', '关于举办2019年英语竞赛的通知', '2020-04-14 17:25:09', '14', '关于举办2019年英语竞赛的通知的内容\n国际数学奥林匹克开始举办后，参赛各国的备赛工作往往主要是对选手进行一次强化培训，以拓广他们的知识，提高他们的解题能力。这种培训课程是很难的，比中学数学深了很多。这时就需要少数数学家专门从事这项活动。\n“竞赛数学”是随着数学教育课程的发展而产生的一门新课程。课程涉及数学竞赛的内容、思想和方法；也涉及到数学竞赛教育和数学课外教育的本质、方法、规律和途径的问题；课外学习与课堂学习的关系问题；辅导教师的进修和提高的问题。课程以数学竞赛所涉及的主要内容：数论、代数、几何及组合数学为载体，尤其注重数学思想和方法的探究，以提高学生的数学素养为目标。\n竞赛数学又不同于上述这些数学领域。通常数学往往追求证明一些概括广泛的定理，而竞赛数学恰恰寻求一些特殊的问题，通常数学追求建立一般的理论和方法，而竞赛数学则追求用特殊方法来解决特殊问题；而且一旦某个问题面世，即成为陈题，又需继续创造新的问题。竞赛数学属于\"硬\"数学范畴，它通常也与纯粹数学一样，以其内在美，包括问题的简练和解法的巧妙，作为衡量其价值的重要标准。');

-- ----------------------------
-- Table structure for organizer
-- ----------------------------
DROP TABLE IF EXISTS `organizer`;
CREATE TABLE `organizer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `establish_date` varchar(255) NOT NULL,
  `school_type` varchar(255) NOT NULL,
  `school_running_type` varchar(255) NOT NULL,
  `id_img` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `organizer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organizer
-- ----------------------------
INSERT INTO `organizer` VALUES ('7', '34', '12345678901@qq.com', '广西民族大学', '1952/2/19', '民族类', '普通本科', 'http://localhost:8999/api/file/qm73du.png');
INSERT INTO `organizer` VALUES ('8', '35', '12345678901@qq.com', '广西民族大学', '1952/2/19', '民族类', '普通本科', 'http://localhost:8999/api/file/qm73du.png');
INSERT INTO `organizer` VALUES ('9', '36', '12345678901@qq.com', '广西民族大学', '1952/2/19', '民族类', '普通本科', 'http://localhost:8999/api/file/qm73du.png');
INSERT INTO `organizer` VALUES ('10', '37', '12345678901@qq.com', '广西民族大学', '1952/2/19', '民族类', '普通本科', 'http://localhost:8999/api/file/qm73du.png');
INSERT INTO `organizer` VALUES ('11', '38', '12345678901@qq.com', '广西民族大学', '1952/2/19', '民族类', '普通本科', 'http://localhost:8999/api/file/qm73du.png');
INSERT INTO `organizer` VALUES ('12', '39', '12345678901@qq.com', '广西民族大学', '1952/2/19', '民族类', '普通本科', 'http://localhost:8999/api/file/qm73du.png');
INSERT INTO `organizer` VALUES ('13', '40', '12345678901@qq.com', '广西民族大学', '1952/2/19', '民族类', '普通本科', 'http://localhost:8999/api/file/qm73du.png');
INSERT INTO `organizer` VALUES ('14', '41', '12345678901@qq.com', '广西民族大学', '1952/2/19', '民族类', '普通本科', 'http://localhost:8999/api/file/qm73du.png');

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('4', '18278539572', '123456');
INSERT INTO `register` VALUES ('5', '18278539573', '123456');
INSERT INTO `register` VALUES ('10', '18278539578', '123456');
INSERT INTO `register` VALUES ('11', '18278539579', '123456');
INSERT INTO `register` VALUES ('15', '18278539583', '123456');
INSERT INTO `register` VALUES ('24', '18278539592', '123456');
INSERT INTO `register` VALUES ('25', '18278539593', '123456');
INSERT INTO `register` VALUES ('26', '18278539594', '123456');
INSERT INTO `register` VALUES ('27', '18278539595', '123456');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '广西民族大学');
INSERT INTO `school` VALUES ('2', '广西大学');
INSERT INTO `school` VALUES ('3', '广西师范大学');
INSERT INTO `school` VALUES ('4', '广西艺术学院');
INSERT INTO `school` VALUES ('5', '广西民族大学相思湖学院');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `admission_date` varchar(20) NOT NULL,
  `graduation_date` varchar(20) NOT NULL,
  `academy` varchar(255) NOT NULL,
  `major` varchar(255) NOT NULL,
  `education` varchar(255) NOT NULL,
  `id_img` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `id` (`id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('6', '22', '男', '12345678901@qq.com', '广西民族大学', '2016/9/10', '2020/7/1', '软信学院', '软件工程', '本科', 'http://localhost:8999/api/file/2yoicy.jpg');
INSERT INTO `student` VALUES ('7', '23', '男', '12345678901@qq.com', '广西民族大学', '2013/9/10', '2017/7/1', '软信学院', '软件工程', '本科', 'http://localhost:8999/api/file/jo2swb.jpg');
INSERT INTO `student` VALUES ('8', '24', '男', '12345678901@qq.com', '广西大学', '2017/9/11', '2021/7/4', '信工学院', '网络工程', '本科', 'http://localhost:8999/api/file/d3qa8u.png');
INSERT INTO `student` VALUES ('9', '25', '女', '12345678901@qq.com', '广西师范大学', '2018/9/17', '2022/7/13', '法学院', '法律学', '本科', 'http://localhost:8999/api/file/2xkc07.jpg');
INSERT INTO `student` VALUES ('10', '26', '女', '12345678901@qq.com', '广西民族大学', '2016/9/10', '2020/7/1', '软信学院', '软件工程', '本科', 'http://localhost:8999/api/file/2yoicy.jpg');
INSERT INTO `student` VALUES ('11', '27', '男', '12345678901@qq.com', '广西民族大学', '2013/9/10', '2017/7/1', '软信学院', '软件工程', '本科', 'http://localhost:8999/api/file/jo2swb.jpg');
INSERT INTO `student` VALUES ('12', '28', '女', '12345678901@qq.com', '广西大学', '2017/9/11', '2021/7/4', '信工学院', '网络工程', '本科', 'http://localhost:8999/api/file/d3qa8u.png');
INSERT INTO `student` VALUES ('13', '29', '男', '12345678901@qq.com', '广西师范大学', '2018/9/17', '2022/7/13', '法学院', '法律学', '本科', 'http://localhost:8999/api/file/2xkc07.jpg');
INSERT INTO `student` VALUES ('14', '42', '男', '12345678901@qq.com', '广西民族大学', '2016/9/10', '2020/7/1', '软信学院', '软件工程', '本科', 'http://localhost:8999/api/file/2yoicy.jpg');
INSERT INTO `student` VALUES ('15', '43', '男', '12345678901@qq.com', '广西民族大学', '2013/9/10', '2017/7/1', '软信学院', '软件工程', '本科', 'http://localhost:8999/api/file/jo2swb.jpg');
INSERT INTO `student` VALUES ('16', '44', '男', '12345678901@qq.com', '广西大学', '2017/9/11', '2021/7/4', '信工学院', '网络工程', '本科', 'http://localhost:8999/api/file/d3qa8u.png');
INSERT INTO `student` VALUES ('17', '45', '女', '12345678901@qq.com', '广西师范大学', '2018/9/17', '2022/7/13', '法学院', '法律学', '本科', 'http://localhost:8999/api/file/2xkc07.jpg');
INSERT INTO `student` VALUES ('18', '46', '女', '12345678901@qq.com', '广西民族大学', '2016/9/10', '2020/7/1', '软信学院', '软件工程', '本科', 'http://localhost:8999/api/file/2yoicy.jpg');
INSERT INTO `student` VALUES ('19', '47', '男', '12345678901@qq.com', '广西民族大学', '2013/9/10', '2017/7/1', '软信学院', '软件工程', '本科', 'http://localhost:8999/api/file/jo2swb.jpg');
INSERT INTO `student` VALUES ('20', '48', '女', '12345678901@qq.com', '广西大学', '2017/9/11', '2021/7/4', '信工学院', '网络工程', '本科', 'http://localhost:8999/api/file/d3qa8u.png');
INSERT INTO `student` VALUES ('21', '49', '男', '12345678901@qq.com', '广西师范大学', '2018/9/17', '2022/7/13', '法学院', '法律学', '本科', 'http://localhost:8999/api/file/2xkc07.jpg');
INSERT INTO `student` VALUES ('22', '50', '女', '斤斤计较的来来来', '广西艺术学院', '2020/5/19', '2020/5/29', '斤斤计较的来来来', '斤斤计较的来来来', '专科', 'http://localhost:8999/api/file/8x5n1f.jpg');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `entry_date` varchar(255) DEFAULT NULL,
  `academy` varchar(255) NOT NULL,
  `professional_title` varchar(255) NOT NULL,
  `education` varchar(255) NOT NULL,
  `id_img` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('4', '30', '男', '12345678901@qq.com', '广西民族大学', '2011/4/19', '软信学院', '教授', '博士研究生', 'http://localhost:8999/api/file/zsah70.jpg');
INSERT INTO `teacher` VALUES ('5', '31', '女', '12345678901@qq.com', '广西民族大学', '2011/4/19', '软信学院', '教授', '硕士研究生', 'http://localhost:8999/api/file/zsah70.jpg');
INSERT INTO `teacher` VALUES ('6', '32', '男', '12345678901@qq.com', '广西民族大学', '2011/4/19', '软信学院', '教授', '硕士研究生', 'http://localhost:8999/api/file/zsah70.jpg');
INSERT INTO `teacher` VALUES ('7', '33', '男', '12345678901@qq.com', '广西民族大学', '2011/4/19', '软信学院', '教授', '博士研究生', 'http://localhost:8999/api/file/zsah70.jpg');

-- ----------------------------
-- Table structure for team_contest
-- ----------------------------
DROP TABLE IF EXISTS `team_contest`;
CREATE TABLE `team_contest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contest_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `teacher_account` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `state` varchar(20) NOT NULL,
  `ticket_number` varchar(20) NOT NULL,
  `score` int(11) DEFAULT NULL,
  `team_name` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `contest_id` (`contest_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `team_contest_ibfk_1` FOREIGN KEY (`contest_id`) REFERENCES `contest_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `team_contest_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team_contest
-- ----------------------------
INSERT INTO `team_contest` VALUES ('1', '8', '6', 'T116263000101', '陈赫', '查看成绩', '364963017928', '85', '肖王杨吴团队', '');
INSERT INTO `team_contest` VALUES ('2', '8', '7', 'T116263000101', '陈赫', '查看成绩', '364963017928', '85', '肖王杨吴团队', '队长');
INSERT INTO `team_contest` VALUES ('3', '8', '9', 'T116263000101', '陈赫', '查看成绩', '364963017928', '85', '肖王杨吴团队', '');
INSERT INTO `team_contest` VALUES ('4', '8', '10', 'T116263000101', '陈赫', '查看成绩', '364963017928', '85', '肖王杨吴团队', '');
INSERT INTO `team_contest` VALUES ('6', '8', '12', 'T116263000102', '关晓彤', '查看成绩', '891528137307', '58', '迪王团队', '队长');
INSERT INTO `team_contest` VALUES ('7', '8', '11', 'T116263000102', '关晓彤', '查看成绩', '891528137307', '58', '迪王团队', '');
INSERT INTO `team_contest` VALUES ('8', '13', '6', '', '', '已下载准考证', '250621734007', '0', '肖陈张团队', '队长');
INSERT INTO `team_contest` VALUES ('9', '13', '14', '', '', '已报名', '250621734007', '0', '肖陈张团队', '');
INSERT INTO `team_contest` VALUES ('10', '13', '15', '', '', '已报名', '250621734007', '0', '肖陈张团队', '');
INSERT INTO `team_contest` VALUES ('11', '8', '18', 'T116263000103', '鹿晗', '已报名', '759753410607', '65', '张刘团队', '队长');
INSERT INTO `team_contest` VALUES ('12', '8', '19', 'T116263000103', '鹿晗', '已报名', '759753410607', '65', '张刘团队', '');
INSERT INTO `team_contest` VALUES ('13', '10', '18', 'T116263000101', '陈赫', '查看成绩', '441578269482', '88', '张周团队', '队长');
INSERT INTO `team_contest` VALUES ('14', '10', '20', 'T116263000101', '陈赫', '查看成绩', '441578269482', '88', '张周团队', '');
INSERT INTO `team_contest` VALUES ('15', '13', '18', '', '', '已报名', '771650612086', '0', '张雅周团队', '队长');
INSERT INTO `team_contest` VALUES ('16', '13', '20', '', '', '已报名', '771650612086', '0', '张雅周团队', '');
INSERT INTO `team_contest` VALUES ('17', '10', '10', 'T116263000104', '何炅', '已报名', '481218464054', '0', '吴梅团队', '队长');
INSERT INTO `team_contest` VALUES ('18', '10', '17', 'T116263000104', '何炅', '已报名', '481218464054', '0', '吴梅团队', '');
INSERT INTO `team_contest` VALUES ('19', '16', '10', 'T116263000104', '何炅', '已报名', '188069376225', '0', '吴张团队', '队长');
INSERT INTO `team_contest` VALUES ('20', '16', '15', 'T116263000104', '何炅', '已报名', '188069376225', '0', '吴张团队', '');
INSERT INTO `team_contest` VALUES ('21', '16', '6', 'T116263000103', '鹿晗', '已报名', '569233716626', '0', '张刘团队', '队长');
INSERT INTO `team_contest` VALUES ('22', '18', '18', 'T116263000101', '陈赫', '已下载准考证', '929524028971', '0', '张周团队', '队长');
INSERT INTO `team_contest` VALUES ('23', '18', '20', 'T116263000101', '陈赫', '已下载准考证', '929524028971', '0', '张周团队', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`,`account`),
  UNIQUE KEY `account` (`account`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1001', '12345678901', '123456', '管理员1', '1');
INSERT INTO `user` VALUES ('2', '1002', '12345678902', '123456', '管理员2', '1');
INSERT INTO `user` VALUES ('22', '116263000101', '18278539570', '123456', '肖战', '3');
INSERT INTO `user` VALUES ('23', '116263000102', '18278539571', '123456', '王俊凯', '3');
INSERT INTO `user` VALUES ('24', '116263000103', '18278539572', '123456', '王一博', '30');
INSERT INTO `user` VALUES ('25', '116263000104', '18278539574', '123456', '杨紫', '3');
INSERT INTO `user` VALUES ('26', '116263000105', '18278539575', '123456', '吴宣仪', '3');
INSERT INTO `user` VALUES ('27', '116263000106', '18278539576', '123456', '王源', '3');
INSERT INTO `user` VALUES ('28', '116263000107', '18278539577', '123456', '迪丽热巴', '3');
INSERT INTO `user` VALUES ('29', '116263000108', '18278539578', '123456', '华晨宇', '30');
INSERT INTO `user` VALUES ('30', 'T116263000101', '18278539580', '123456', '陈赫', '2');
INSERT INTO `user` VALUES ('31', 'T116263000102', '18278539581', '123456', '关晓彤', '2');
INSERT INTO `user` VALUES ('32', 'T116263000103', '18278539582', '123456', '鹿晗', '2');
INSERT INTO `user` VALUES ('33', 'T116263000104', '18278539584', '123456', '何炅', '2');
INSERT INTO `user` VALUES ('34', 'gxun_ruanxin', '18278539585', '123456', '软信学院', '6');
INSERT INTO `user` VALUES ('35', 'gxun_wenxue', '18278539586', '123456', '文学院', '6');
INSERT INTO `user` VALUES ('36', 'gxun_xingong', '18278539587', '123456', '信工学院', '6');
INSERT INTO `user` VALUES ('37', 'gxun_falv', '18278539588', '123456', '法律学院', '6');
INSERT INTO `user` VALUES ('38', 'gxun_guanli', '18278539589', '123456', '管理学院', '6');
INSERT INTO `user` VALUES ('39', 'gxun_huagong', '18278539590', '123456', '化工学院', '6');
INSERT INTO `user` VALUES ('40', 'gxun_yishu', '18278539591', '123456', '艺术学院', '6');
INSERT INTO `user` VALUES ('41', 'gxun_chuanmei', '18278539592', '123456', '传媒学院', '60');
INSERT INTO `user` VALUES ('42', '116263000201', '18278539560', '123456', '陈伟霆', '3');
INSERT INTO `user` VALUES ('43', '116263000202', '18278539561', '123456', '张国荣', '3');
INSERT INTO `user` VALUES ('44', '116263000203', '18278539562', '123456', '刘德华', '3');
INSERT INTO `user` VALUES ('45', '116263000204', '18278539564', '123456', '梅艳芳', '3');
INSERT INTO `user` VALUES ('46', '116263000205', '18278539565', '123456', '张雅芝', '3');
INSERT INTO `user` VALUES ('47', '116263000206', '18278539566', '123456', '刘恺威', '3');
INSERT INTO `user` VALUES ('48', '116263000207', '18278539567', '123456', '周敏慧', '3');
INSERT INTO `user` VALUES ('49', '116263000208', '18278539568', '123456', '周润发', '3');
INSERT INTO `user` VALUES ('50', '11231232314', '18278539573', '123456', '斤斤计较的来来来', '30');
