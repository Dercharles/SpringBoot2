/*
Navicat MySQL Data Transfer

Source Server         : 项目
Source Server Version : 50720
Source Host           : javadc.cn:3306
Source Database       : testDB

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-12-02 15:35:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_city
-- ----------------------------
DROP TABLE IF EXISTS `c_city`;
CREATE TABLE `c_city` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(30) NOT NULL COMMENT '城市名称',
  `telephone_area_code` varchar(6) DEFAULT NULL COMMENT '电话区号',
  `province_name` varchar(30) DEFAULT NULL COMMENT '省份',
  `province_id` int(10) NOT NULL,
  `first_letter` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_city_name` (`city_name`),
  KEY `province_id` (`province_id`),
  CONSTRAINT `fk_province` FOREIGN KEY (`province_id`) REFERENCES `c_province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=448 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_city
-- ----------------------------
INSERT INTO `c_city` VALUES ('1', '北京', '010', '北京市', '1', 'BJ');
INSERT INTO `c_city` VALUES ('2', '朝阳', '010', '北京市', '1', 'CY');
INSERT INTO `c_city` VALUES ('3', '顺义', '010', '北京市', '1', 'SY');
INSERT INTO `c_city` VALUES ('4', '怀柔', '010', '北京市', '1', 'HR');
INSERT INTO `c_city` VALUES ('5', '通州', '010', '北京市', '1', 'TZ');
INSERT INTO `c_city` VALUES ('6', '昌平', '010', '北京市', '1', 'CP');
INSERT INTO `c_city` VALUES ('7', '延庆', '010', '北京市', '1', 'YQ');
INSERT INTO `c_city` VALUES ('8', '丰台', '010', '北京市', '1', 'FT');
INSERT INTO `c_city` VALUES ('9', '石景山', '010', '北京市', '1', 'SJS');
INSERT INTO `c_city` VALUES ('10', '大兴', '010', '北京市', '1', 'DX');
INSERT INTO `c_city` VALUES ('11', '房山', '010', '北京市', '1', 'FS');
INSERT INTO `c_city` VALUES ('12', '密云', '010', '北京市', '1', 'MY');
INSERT INTO `c_city` VALUES ('13', '门头沟', '010', '北京市', '1', 'MTG');
INSERT INTO `c_city` VALUES ('14', '平谷', '010', '北京市', '1', 'PG');
INSERT INTO `c_city` VALUES ('15', '八达岭', '010', '北京市', '1', 'BDL');
INSERT INTO `c_city` VALUES ('16', '佛爷顶', '010', '北京市', '1', 'FYD');
INSERT INTO `c_city` VALUES ('17', '汤河口', '010', '北京市', '1', 'THK');
INSERT INTO `c_city` VALUES ('18', '密云上甸子', '010', '北京市', '1', 'MYSD');
INSERT INTO `c_city` VALUES ('19', '斋堂', '010', '北京市', '1', 'ZT');
INSERT INTO `c_city` VALUES ('20', '霞云岭', '010', '北京市', '1', 'XYL');
INSERT INTO `c_city` VALUES ('21', '北京城区', '010', '北京市', '1', 'BJCQ');
INSERT INTO `c_city` VALUES ('22', '海淀', '010', '北京市', '1', 'HD');
INSERT INTO `c_city` VALUES ('23', '天津', '022', '天津市', '2', 'TJ');
INSERT INTO `c_city` VALUES ('24', '宝坻', '022', '天津市', '2', 'BZ');
INSERT INTO `c_city` VALUES ('25', '东丽', '022', '天津市', '2', 'DL');
INSERT INTO `c_city` VALUES ('26', '西青', '022', '天津市', '2', 'XQ');
INSERT INTO `c_city` VALUES ('27', '北辰', '022', '天津市', '2', 'BC');
INSERT INTO `c_city` VALUES ('28', '蓟县', '022', '天津市', '2', 'JX');
INSERT INTO `c_city` VALUES ('29', '汉沽', '022', '天津市', '2', 'HG');
INSERT INTO `c_city` VALUES ('30', '静海', '022', '天津市', '2', 'JH');
INSERT INTO `c_city` VALUES ('31', '津南', '022', '天津市', '2', 'JN');
INSERT INTO `c_city` VALUES ('32', '塘沽', '022', '天津市', '2', 'TG');
INSERT INTO `c_city` VALUES ('33', '大港', '022', '天津市', '2', 'DG');
INSERT INTO `c_city` VALUES ('34', '武清', '022', '天津市', '2', 'WQ');
INSERT INTO `c_city` VALUES ('35', '宁河', '022', '天津市', '2', 'NH');
INSERT INTO `c_city` VALUES ('36', '上海', '021', '上海市', '3', 'SH');
INSERT INTO `c_city` VALUES ('37', '宝山', '021', '上海市', '3', 'BS');
INSERT INTO `c_city` VALUES ('38', '嘉定', '021', '上海市', '3', 'JD');
INSERT INTO `c_city` VALUES ('39', '南汇', '021', '上海市', '3', 'NH');
INSERT INTO `c_city` VALUES ('40', '浦东', '021', '上海市', '3', 'PD');
INSERT INTO `c_city` VALUES ('41', '青浦', '021', '上海市', '3', 'QP');
INSERT INTO `c_city` VALUES ('42', '松江', '021', '上海市', '3', 'SJ');
INSERT INTO `c_city` VALUES ('43', '奉贤', '021', '上海市', '3', 'FX');
INSERT INTO `c_city` VALUES ('44', '崇明', '021', '上海市', '3', 'CM');
INSERT INTO `c_city` VALUES ('45', '徐家汇', '021', '上海市', '3', 'XJH');
INSERT INTO `c_city` VALUES ('46', '闵行', '021', '上海市', '3', 'ZX');
INSERT INTO `c_city` VALUES ('47', '金山', '021', '上海市', '3', 'JS');
INSERT INTO `c_city` VALUES ('48', '石家庄', '0311', '河北省', '4', 'SJZ');
INSERT INTO `c_city` VALUES ('49', '张家口', '0313', '河北省', '4', 'ZJK');
INSERT INTO `c_city` VALUES ('50', '承德', '0314', '河北省', '4', 'CD');
INSERT INTO `c_city` VALUES ('51', '唐山', '0315', '河北省', '4', 'TS');
INSERT INTO `c_city` VALUES ('52', '秦皇岛', '0335', '河北省', '4', 'QHD');
INSERT INTO `c_city` VALUES ('53', '沧州', '0317', '河北省', '4', 'CZ');
INSERT INTO `c_city` VALUES ('54', '衡水', '0318', '河北省', '4', 'HS');
INSERT INTO `c_city` VALUES ('55', '邢台', '0319', '河北省', '4', 'XT');
INSERT INTO `c_city` VALUES ('56', '邯郸', '0310', '河北省', '4', 'HD');
INSERT INTO `c_city` VALUES ('57', '保定', '0312', '河北省', '4', 'BD');
INSERT INTO `c_city` VALUES ('58', '廊坊', '0316', '河北省', '4', 'LF');
INSERT INTO `c_city` VALUES ('59', '郑州', '0371', '河南省', '5', 'ZZ');
INSERT INTO `c_city` VALUES ('60', '新乡', '0373', '河南省', '5', 'XX');
INSERT INTO `c_city` VALUES ('61', '许昌', '0374', '河南省', '5', 'XC');
INSERT INTO `c_city` VALUES ('62', '平顶山', '0375', '河南省', '5', 'PDS');
INSERT INTO `c_city` VALUES ('63', '信阳', '0376', '河南省', '5', 'XY');
INSERT INTO `c_city` VALUES ('64', '南阳', '0377', '河南省', '5', 'NY');
INSERT INTO `c_city` VALUES ('65', '开封', '0378', '河南省', '5', 'KF');
INSERT INTO `c_city` VALUES ('66', '洛阳', '0379', '河南省', '5', 'LY');
INSERT INTO `c_city` VALUES ('67', '商丘', '0370', '河南省', '5', 'SQ');
INSERT INTO `c_city` VALUES ('68', '焦作', '0391', '河南省', '5', 'JZ');
INSERT INTO `c_city` VALUES ('69', '鹤壁', '0392', '河南省', '5', 'HB');
INSERT INTO `c_city` VALUES ('70', '濮阳', '0393', '河南省', '5', 'ZY');
INSERT INTO `c_city` VALUES ('71', '周口', '0394', '河南省', '5', 'ZK');
INSERT INTO `c_city` VALUES ('72', '漯河', '0395', '河南省', '5', 'ZH');
INSERT INTO `c_city` VALUES ('73', '驻马店', '0396', '河南省', '5', 'ZMD');
INSERT INTO `c_city` VALUES ('74', '三门峡', '0398', '河南省', '5', 'SMX');
INSERT INTO `c_city` VALUES ('75', '济源', '0391', '河南省', '5', 'JY');
INSERT INTO `c_city` VALUES ('76', '安阳', '0372', '河南省', '5', 'AY');
INSERT INTO `c_city` VALUES ('77', '合肥', '0551', '安徽省', '6', 'HF');
INSERT INTO `c_city` VALUES ('78', '芜湖', '0553', '安徽省', '6', 'WH');
INSERT INTO `c_city` VALUES ('79', '淮南', '0554', '安徽省', '6', 'HN');
INSERT INTO `c_city` VALUES ('80', '马鞍山', '0555', '安徽省', '6', 'MAS');
INSERT INTO `c_city` VALUES ('81', '安庆', '0556', '安徽省', '6', 'AQ');
INSERT INTO `c_city` VALUES ('82', '宿州', '0557', '安徽省', '6', 'SZ');
INSERT INTO `c_city` VALUES ('83', '阜阳', '0558', '安徽省', '6', 'FY');
INSERT INTO `c_city` VALUES ('84', '亳州', '0558', '安徽省', '6', 'ZZ');
INSERT INTO `c_city` VALUES ('85', '黄山', '0559', '安徽省', '6', 'HS');
INSERT INTO `c_city` VALUES ('86', '滁州', '0550', '安徽省', '6', 'CZ');
INSERT INTO `c_city` VALUES ('87', '淮北', '0561', '安徽省', '6', 'HB');
INSERT INTO `c_city` VALUES ('88', '铜陵', '0562', '安徽省', '6', 'TL');
INSERT INTO `c_city` VALUES ('89', '宣城', '0563', '安徽省', '6', 'XC');
INSERT INTO `c_city` VALUES ('90', '六安', '0564', '安徽省', '6', 'LA');
INSERT INTO `c_city` VALUES ('91', '巢湖', '0565', '安徽省', '6', 'CH');
INSERT INTO `c_city` VALUES ('92', '池州', '0566', '安徽省', '6', 'CZ');
INSERT INTO `c_city` VALUES ('93', '蚌埠', '0552', '安徽省', '6', 'BB');
INSERT INTO `c_city` VALUES ('94', '杭州', '0571', '浙江省', '7', 'HZ');
INSERT INTO `c_city` VALUES ('95', '舟山', '0580', '浙江省', '7', 'ZS');
INSERT INTO `c_city` VALUES ('96', '湖州', '0572', '浙江省', '7', 'HZ');
INSERT INTO `c_city` VALUES ('97', '嘉兴', '0573', '浙江省', '7', 'JX');
INSERT INTO `c_city` VALUES ('98', '金华', '0579', '浙江省', '7', 'JH');
INSERT INTO `c_city` VALUES ('99', '绍兴', '0575', '浙江省', '7', 'SX');
INSERT INTO `c_city` VALUES ('100', '台州', '0576', '浙江省', '7', 'TZ');
INSERT INTO `c_city` VALUES ('101', '温州', '0577', '浙江省', '7', 'WZ');
INSERT INTO `c_city` VALUES ('102', '丽水', '0578', '浙江省', '7', 'LS');
INSERT INTO `c_city` VALUES ('103', '衢州', '0570', '浙江省', '7', 'ZZ');
INSERT INTO `c_city` VALUES ('104', '宁波', '0574', '浙江省', '7', 'NB');
INSERT INTO `c_city` VALUES ('105', '重庆', '023', '重庆市', '8', 'CQ');
INSERT INTO `c_city` VALUES ('106', '合川', '023', '重庆市', '8', 'HC');
INSERT INTO `c_city` VALUES ('107', '南川', '023', '重庆市', '8', 'NC');
INSERT INTO `c_city` VALUES ('108', '江津', '023', '重庆市', '8', 'JJ');
INSERT INTO `c_city` VALUES ('109', '万盛', '023', '重庆市', '8', 'WS');
INSERT INTO `c_city` VALUES ('110', '渝北', '023', '重庆市', '8', 'YB');
INSERT INTO `c_city` VALUES ('111', '北碚', '023', '重庆市', '8', 'BZ');
INSERT INTO `c_city` VALUES ('112', '巴南', '023', '重庆市', '8', 'BN');
INSERT INTO `c_city` VALUES ('113', '长寿', '023', '重庆市', '8', 'CS');
INSERT INTO `c_city` VALUES ('114', '黔江', '023', '重庆市', '8', 'QJ');
INSERT INTO `c_city` VALUES ('115', '万州天城', '023', '重庆市', '8', 'WZTC');
INSERT INTO `c_city` VALUES ('116', '万州龙宝', '023', '重庆市', '8', 'WZLB');
INSERT INTO `c_city` VALUES ('117', '涪陵', '023', '重庆市', '8', 'FL');
INSERT INTO `c_city` VALUES ('118', '开县', '023', '重庆市', '8', 'KX');
INSERT INTO `c_city` VALUES ('119', '城口', '023', '重庆市', '8', 'CK');
INSERT INTO `c_city` VALUES ('120', '云阳', '023', '重庆市', '8', 'YY');
INSERT INTO `c_city` VALUES ('121', '巫溪', '023', '重庆市', '8', 'WX');
INSERT INTO `c_city` VALUES ('122', '奉节', '023', '重庆市', '8', 'FJ');
INSERT INTO `c_city` VALUES ('123', '巫山', '023', '重庆市', '8', 'WS');
INSERT INTO `c_city` VALUES ('124', '潼南', '023', '重庆市', '8', 'ZN');
INSERT INTO `c_city` VALUES ('125', '垫江', '023', '重庆市', '8', 'DJ');
INSERT INTO `c_city` VALUES ('126', '梁平', '023', '重庆市', '8', 'LP');
INSERT INTO `c_city` VALUES ('127', '忠县', '023', '重庆市', '8', 'ZX');
INSERT INTO `c_city` VALUES ('128', '石柱', '023', '重庆市', '8', 'SZ');
INSERT INTO `c_city` VALUES ('129', '大足', '023', '重庆市', '8', 'DZ');
INSERT INTO `c_city` VALUES ('130', '荣昌', '023', '重庆市', '8', 'RC');
INSERT INTO `c_city` VALUES ('131', '铜梁', '023', '重庆市', '8', 'TL');
INSERT INTO `c_city` VALUES ('132', '璧山', '023', '重庆市', '8', 'ZS');
INSERT INTO `c_city` VALUES ('133', '丰都', '023', '重庆市', '8', 'FD');
INSERT INTO `c_city` VALUES ('134', '武隆', '023', '重庆市', '8', 'WL');
INSERT INTO `c_city` VALUES ('135', '彭水', '023', '重庆市', '8', 'PS');
INSERT INTO `c_city` VALUES ('136', '綦江', '023', '重庆市', '8', 'ZJ');
INSERT INTO `c_city` VALUES ('137', '酉阳', '023', '重庆市', '8', 'YY');
INSERT INTO `c_city` VALUES ('138', '秀山', '023', '重庆市', '8', 'XS');
INSERT INTO `c_city` VALUES ('139', '沙坪坝', '023', '重庆市', '8', 'SPB');
INSERT INTO `c_city` VALUES ('140', '永川', '023', '重庆市', '8', 'YC');
INSERT INTO `c_city` VALUES ('141', '福州', '0591', '福建省', '9', 'FZ');
INSERT INTO `c_city` VALUES ('142', '泉州', '0595', '福建省', '9', 'QZ');
INSERT INTO `c_city` VALUES ('143', '漳州', '0596', '福建省', '9', 'ZZ');
INSERT INTO `c_city` VALUES ('144', '龙岩', '0597', '福建省', '9', 'LY');
INSERT INTO `c_city` VALUES ('145', '晋江', '0595', '福建省', '9', 'JJ');
INSERT INTO `c_city` VALUES ('146', '南平', '0599', '福建省', '9', 'NP');
INSERT INTO `c_city` VALUES ('147', '厦门', '0592', '福建省', '9', 'XM');
INSERT INTO `c_city` VALUES ('148', '宁德', '0593', '福建省', '9', 'ND');
INSERT INTO `c_city` VALUES ('149', '莆田', '0594', '福建省', '9', 'PT');
INSERT INTO `c_city` VALUES ('150', '三明', '0598', '福建省', '9', 'SM');
INSERT INTO `c_city` VALUES ('151', '兰州', '0931', '甘肃省', '10', 'LZ');
INSERT INTO `c_city` VALUES ('152', '平凉', '0933', '甘肃省', '10', 'PL');
INSERT INTO `c_city` VALUES ('153', '庆阳', '0934', '甘肃省', '10', 'QY');
INSERT INTO `c_city` VALUES ('154', '武威', '0935', '甘肃省', '10', 'WW');
INSERT INTO `c_city` VALUES ('155', '金昌', '0935', '甘肃省', '10', 'JC');
INSERT INTO `c_city` VALUES ('156', '嘉峪关', '0937', '甘肃省', '10', 'JYG');
INSERT INTO `c_city` VALUES ('157', '酒泉', '0937', '甘肃省', '10', 'JQ');
INSERT INTO `c_city` VALUES ('158', '天水', '0938', '甘肃省', '10', 'TS');
INSERT INTO `c_city` VALUES ('159', '武都', '0939', '甘肃省', '10', 'WD');
INSERT INTO `c_city` VALUES ('160', '临夏', '0930', '甘肃省', '10', 'LX');
INSERT INTO `c_city` VALUES ('161', '合作', '0941', '甘肃省', '10', 'HZ');
INSERT INTO `c_city` VALUES ('162', '白银', '0943', '甘肃省', '10', 'BY');
INSERT INTO `c_city` VALUES ('163', '定西', '0932', '甘肃省', '10', 'DX');
INSERT INTO `c_city` VALUES ('164', '张掖', '0936', '甘肃省', '10', 'ZY');
INSERT INTO `c_city` VALUES ('165', '广州', '020', '广东省', '11', 'GZ');
INSERT INTO `c_city` VALUES ('166', '惠州', '0752', '广东省', '11', 'HZ');
INSERT INTO `c_city` VALUES ('167', '梅州', '0753', '广东省', '11', 'MZ');
INSERT INTO `c_city` VALUES ('168', '汕头', '0754', '广东省', '11', 'ST');
INSERT INTO `c_city` VALUES ('169', '深圳', '0755', '广东省', '11', 'SZ');
INSERT INTO `c_city` VALUES ('170', '珠海', '0756', '广东省', '11', 'ZH');
INSERT INTO `c_city` VALUES ('171', '佛山', '0757', '广东省', '11', 'FS');
INSERT INTO `c_city` VALUES ('172', '肇庆', '0758', '广东省', '11', 'ZQ');
INSERT INTO `c_city` VALUES ('173', '湛江', '0759', '广东省', '11', 'ZJ');
INSERT INTO `c_city` VALUES ('174', '江门', '0750', '广东省', '11', 'JM');
INSERT INTO `c_city` VALUES ('175', '河源', '0762', '广东省', '11', 'HY');
INSERT INTO `c_city` VALUES ('176', '清远', '0763', '广东省', '11', 'QY');
INSERT INTO `c_city` VALUES ('177', '云浮', '0766', '广东省', '11', 'YF');
INSERT INTO `c_city` VALUES ('178', '潮州', '0768', '广东省', '11', 'CZ');
INSERT INTO `c_city` VALUES ('179', '东莞', '0769', '广东省', '11', 'DZ');
INSERT INTO `c_city` VALUES ('180', '中山', '0760', '广东省', '11', 'ZS');
INSERT INTO `c_city` VALUES ('181', '阳江', '0662', '广东省', '11', 'YJ');
INSERT INTO `c_city` VALUES ('182', '揭阳', '0663', '广东省', '11', 'JY');
INSERT INTO `c_city` VALUES ('183', '茂名', '0668', '广东省', '11', 'MM');
INSERT INTO `c_city` VALUES ('184', '汕尾', '0660', '广东省', '11', 'SW');
INSERT INTO `c_city` VALUES ('185', '韶关', '0751', '广东省', '11', 'SG');
INSERT INTO `c_city` VALUES ('186', '南宁', '0771', '广西壮族自治区', '12', 'NN');
INSERT INTO `c_city` VALUES ('187', '柳州', '0772', '广西壮族自治区', '12', 'LZ');
INSERT INTO `c_city` VALUES ('188', '来宾', '0772', '广西壮族自治区', '12', 'LB');
INSERT INTO `c_city` VALUES ('189', '桂林', '0773', '广西壮族自治区', '12', 'GL');
INSERT INTO `c_city` VALUES ('190', '梧州', '0774', '广西壮族自治区', '12', 'WZ');
INSERT INTO `c_city` VALUES ('191', '防城港', '0770', '广西壮族自治区', '12', 'FCG');
INSERT INTO `c_city` VALUES ('192', '贵港', '0775', '广西壮族自治区', '12', 'GG');
INSERT INTO `c_city` VALUES ('193', '玉林', '0775', '广西壮族自治区', '12', 'YL');
INSERT INTO `c_city` VALUES ('194', '百色', '0776', '广西壮族自治区', '12', 'BS');
INSERT INTO `c_city` VALUES ('195', '钦州', '0777', '广西壮族自治区', '12', 'QZ');
INSERT INTO `c_city` VALUES ('196', '河池', '0778', '广西壮族自治区', '12', 'HC');
INSERT INTO `c_city` VALUES ('197', '北海', '0779', '广西壮族自治区', '12', 'BH');
INSERT INTO `c_city` VALUES ('198', '崇左', '0771', '广西壮族自治区', '12', 'CZ');
INSERT INTO `c_city` VALUES ('199', '贺州', '0774', '广西壮族自治区', '12', 'HZ');
INSERT INTO `c_city` VALUES ('200', '贵阳', '0851', '贵州省', '13', 'GY');
INSERT INTO `c_city` VALUES ('201', '安顺', '0853', '贵州省', '13', 'AS');
INSERT INTO `c_city` VALUES ('202', '都匀', '0854', '贵州省', '13', 'DY');
INSERT INTO `c_city` VALUES ('203', '兴义', '0859', '贵州省', '13', 'XY');
INSERT INTO `c_city` VALUES ('204', '铜仁', '0856', '贵州省', '13', 'TR');
INSERT INTO `c_city` VALUES ('205', '毕节', '0857', '贵州省', '13', 'BJ');
INSERT INTO `c_city` VALUES ('206', '六盘水', '0858', '贵州省', '13', 'LPS');
INSERT INTO `c_city` VALUES ('207', '遵义', '0852', '贵州省', '13', 'ZY');
INSERT INTO `c_city` VALUES ('208', '凯里', '0855', '贵州省', '13', 'KL');
INSERT INTO `c_city` VALUES ('209', '昆明', '0871', '云南省', '14', 'KM');
INSERT INTO `c_city` VALUES ('210', '红河', '0873', '云南省', '14', 'HH');
INSERT INTO `c_city` VALUES ('211', '文山', '0876', '云南省', '14', 'WS');
INSERT INTO `c_city` VALUES ('212', '玉溪', '0877', '云南省', '14', 'YX');
INSERT INTO `c_city` VALUES ('213', '楚雄', '0878', '云南省', '14', 'CX');
INSERT INTO `c_city` VALUES ('214', '普洱', '0879', '云南省', '14', 'PE');
INSERT INTO `c_city` VALUES ('215', '昭通', '0870', '云南省', '14', 'ZT');
INSERT INTO `c_city` VALUES ('216', '临沧', '0883', '云南省', '14', 'LC');
INSERT INTO `c_city` VALUES ('217', '怒江', '0886', '云南省', '14', 'NJ');
INSERT INTO `c_city` VALUES ('218', '香格里拉', '0887', '云南省', '14', 'XGLL');
INSERT INTO `c_city` VALUES ('219', '丽江', '0888', '云南省', '14', 'LJ');
INSERT INTO `c_city` VALUES ('220', '德宏', '0692', '云南省', '14', 'DH');
INSERT INTO `c_city` VALUES ('221', '景洪', '0691', '云南省', '14', 'JH');
INSERT INTO `c_city` VALUES ('222', '大理', '0872', '云南省', '14', 'DL');
INSERT INTO `c_city` VALUES ('223', '曲靖', '0874', '云南省', '14', 'QJ');
INSERT INTO `c_city` VALUES ('224', '保山', '0875', '云南省', '14', 'BS');
INSERT INTO `c_city` VALUES ('225', '呼和浩特', '0471', '内蒙古自治区', '15', 'HHHT');
INSERT INTO `c_city` VALUES ('226', '乌海', '0473', '内蒙古自治区', '15', 'WH');
INSERT INTO `c_city` VALUES ('227', '集宁', '0474', '内蒙古自治区', '15', 'JN');
INSERT INTO `c_city` VALUES ('228', '通辽', '0475', '内蒙古自治区', '15', 'TL');
INSERT INTO `c_city` VALUES ('229', '阿拉善左旗', '0483', '内蒙古自治区', '15', 'ALSZQ');
INSERT INTO `c_city` VALUES ('230', '鄂尔多斯', '0477', '内蒙古自治区', '15', 'EEDS');
INSERT INTO `c_city` VALUES ('231', '临河', '0478', '内蒙古自治区', '15', 'LH');
INSERT INTO `c_city` VALUES ('232', '锡林浩特', '0479', '内蒙古自治区', '15', 'XLHT');
INSERT INTO `c_city` VALUES ('233', '呼伦贝尔', '0470', '内蒙古自治区', '15', 'HLBE');
INSERT INTO `c_city` VALUES ('234', '乌兰浩特', '0482', '内蒙古自治区', '15', 'WLHT');
INSERT INTO `c_city` VALUES ('235', '包头', '0472', '内蒙古自治区', '15', 'BT');
INSERT INTO `c_city` VALUES ('236', '赤峰', '0476', '内蒙古自治区', '15', 'CF');
INSERT INTO `c_city` VALUES ('237', '南昌', '0791', '江西省', '16', 'NC');
INSERT INTO `c_city` VALUES ('238', '上饶', '0793', '江西省', '16', 'SR');
INSERT INTO `c_city` VALUES ('239', '抚州', '0794', '江西省', '16', 'FZ');
INSERT INTO `c_city` VALUES ('240', '宜春', '0795', '江西省', '16', 'YC');
INSERT INTO `c_city` VALUES ('241', '鹰潭', '0701', '江西省', '16', 'YT');
INSERT INTO `c_city` VALUES ('242', '赣州', '0797', '江西省', '16', 'GZ');
INSERT INTO `c_city` VALUES ('243', '景德镇', '0798', '江西省', '16', 'JDZ');
INSERT INTO `c_city` VALUES ('244', '萍乡', '0799', '江西省', '16', 'PX');
INSERT INTO `c_city` VALUES ('245', '新余', '0790', '江西省', '16', 'XY');
INSERT INTO `c_city` VALUES ('246', '九江', '0792', '江西省', '16', 'JJ');
INSERT INTO `c_city` VALUES ('247', '吉安', '0796', '江西省', '16', 'JA');
INSERT INTO `c_city` VALUES ('248', '武汉', '027', '湖北省', '17', 'WH');
INSERT INTO `c_city` VALUES ('249', '黄冈', '0713', '湖北省', '17', 'HG');
INSERT INTO `c_city` VALUES ('250', '荆州', '0716', '湖北省', '17', 'JZ');
INSERT INTO `c_city` VALUES ('251', '宜昌', '0717', '湖北省', '17', 'YC');
INSERT INTO `c_city` VALUES ('252', '恩施', '0718', '湖北省', '17', 'ES');
INSERT INTO `c_city` VALUES ('253', '十堰', '0719', '湖北省', '17', 'SY');
INSERT INTO `c_city` VALUES ('254', '神农架', '0719', '湖北省', '17', 'SNJ');
INSERT INTO `c_city` VALUES ('255', '随州', '0722', '湖北省', '17', 'SZ');
INSERT INTO `c_city` VALUES ('256', '荆门', '0724', '湖北省', '17', 'JM');
INSERT INTO `c_city` VALUES ('257', '天门', '0728', '湖北省', '17', 'TM');
INSERT INTO `c_city` VALUES ('258', '仙桃', '0728', '湖北省', '17', 'XT');
INSERT INTO `c_city` VALUES ('259', '潜江', '0728', '湖北省', '17', 'QJ');
INSERT INTO `c_city` VALUES ('260', '襄樊', '0710', '湖北省', '17', 'XF');
INSERT INTO `c_city` VALUES ('261', '鄂州', '0711', '湖北省', '17', 'EZ');
INSERT INTO `c_city` VALUES ('262', '孝感', '0712', '湖北省', '17', 'XG');
INSERT INTO `c_city` VALUES ('263', '黄石', '0714', '湖北省', '17', 'HS');
INSERT INTO `c_city` VALUES ('264', '咸宁', '0715', '湖北省', '17', 'XN');
INSERT INTO `c_city` VALUES ('265', '成都', '028', '四川省', '18', 'CD');
INSERT INTO `c_city` VALUES ('266', '自贡', '0813', '四川省', '18', 'ZG');
INSERT INTO `c_city` VALUES ('267', '绵阳', '0816', '四川省', '18', 'MY');
INSERT INTO `c_city` VALUES ('268', '南充', '0817', '四川省', '18', 'NC');
INSERT INTO `c_city` VALUES ('269', '达州', '0818', '四川省', '18', 'DZ');
INSERT INTO `c_city` VALUES ('270', '遂宁', '0825', '四川省', '18', 'SN');
INSERT INTO `c_city` VALUES ('271', '广安', '0826', '四川省', '18', 'GA');
INSERT INTO `c_city` VALUES ('272', '巴中', '0827', '四川省', '18', 'BZ');
INSERT INTO `c_city` VALUES ('273', '泸州', '0830', '四川省', '18', 'ZZ');
INSERT INTO `c_city` VALUES ('274', '宜宾', '0831', '四川省', '18', 'YB');
INSERT INTO `c_city` VALUES ('275', '内江', '0832', '四川省', '18', 'NJ');
INSERT INTO `c_city` VALUES ('276', '资阳', '028', '四川省', '18', 'ZY');
INSERT INTO `c_city` VALUES ('277', '乐山', '0833', '四川省', '18', 'LS');
INSERT INTO `c_city` VALUES ('278', '眉山', '028', '四川省', '18', 'MS');
INSERT INTO `c_city` VALUES ('279', '凉山', '0834', '四川省', '18', 'LS');
INSERT INTO `c_city` VALUES ('280', '雅安', '0835', '四川省', '18', 'YA');
INSERT INTO `c_city` VALUES ('281', '甘孜', '0836', '四川省', '18', 'GZ');
INSERT INTO `c_city` VALUES ('282', '阿坝', '0837', '四川省', '18', 'AB');
INSERT INTO `c_city` VALUES ('283', '德阳', '0838', '四川省', '18', 'DY');
INSERT INTO `c_city` VALUES ('284', '广元', '0839', '四川省', '18', 'GY');
INSERT INTO `c_city` VALUES ('285', '攀枝花', '0812', '四川省', '18', 'PZH');
INSERT INTO `c_city` VALUES ('286', '银川', '0951', '宁夏回族自治区', '19', 'YC');
INSERT INTO `c_city` VALUES ('287', '中卫', '0955', '宁夏回族自治区', '19', 'ZW');
INSERT INTO `c_city` VALUES ('288', '固原', '0954', '宁夏回族自治区', '19', 'GY');
INSERT INTO `c_city` VALUES ('289', '石嘴山', '0952', '宁夏回族自治区', '19', 'SZS');
INSERT INTO `c_city` VALUES ('290', '吴忠', '0953', '宁夏回族自治区', '19', 'WZ');
INSERT INTO `c_city` VALUES ('291', '西宁', '0971', '青海省', '20', 'XN');
INSERT INTO `c_city` VALUES ('292', '黄南', '0973', '青海省', '20', 'HN');
INSERT INTO `c_city` VALUES ('293', '海北', '0970', '青海省', '20', 'HB');
INSERT INTO `c_city` VALUES ('294', '果洛', '0975', '青海省', '20', 'GL');
INSERT INTO `c_city` VALUES ('295', '玉树', '0976', '青海省', '20', 'YS');
INSERT INTO `c_city` VALUES ('296', '海西', '0979', '青海省', '20', 'HX');
INSERT INTO `c_city` VALUES ('297', '海东', '0972', '青海省', '20', 'HD');
INSERT INTO `c_city` VALUES ('298', '海南', '0974', '青海省', '20', 'HN');
INSERT INTO `c_city` VALUES ('299', '济南', '0531', '山东省', '21', 'JN');
INSERT INTO `c_city` VALUES ('300', '潍坊', '0536', '山东省', '21', 'WF');
INSERT INTO `c_city` VALUES ('301', '临沂', '0539', '山东省', '21', 'LY');
INSERT INTO `c_city` VALUES ('302', '菏泽', '0530', '山东省', '21', 'HZ');
INSERT INTO `c_city` VALUES ('303', '滨州', '0543', '山东省', '21', 'BZ');
INSERT INTO `c_city` VALUES ('304', '东营', '0546', '山东省', '21', 'DY');
INSERT INTO `c_city` VALUES ('305', '威海', '0631', '山东省', '21', 'WH');
INSERT INTO `c_city` VALUES ('306', '枣庄', '0632', '山东省', '21', 'ZZ');
INSERT INTO `c_city` VALUES ('307', '日照', '0633', '山东省', '21', 'RZ');
INSERT INTO `c_city` VALUES ('308', '莱芜', '0634', '山东省', '21', 'LW');
INSERT INTO `c_city` VALUES ('309', '聊城', '0635', '山东省', '21', 'LC');
INSERT INTO `c_city` VALUES ('310', '青岛', '0532', '山东省', '21', 'QD');
INSERT INTO `c_city` VALUES ('311', '淄博', '0533', '山东省', '21', 'ZB');
INSERT INTO `c_city` VALUES ('312', '德州', '0534', '山东省', '21', 'DZ');
INSERT INTO `c_city` VALUES ('313', '烟台', '0535', '山东省', '21', 'YT');
INSERT INTO `c_city` VALUES ('314', '济宁', '0537', '山东省', '21', 'JN');
INSERT INTO `c_city` VALUES ('315', '泰安', '0538', '山东省', '21', 'TA');
INSERT INTO `c_city` VALUES ('316', '西安', '029', '陕西省', '22', 'XA');
INSERT INTO `c_city` VALUES ('317', '延安', '0911', '陕西省', '22', 'YA');
INSERT INTO `c_city` VALUES ('318', '榆林', '0912', '陕西省', '22', 'YL');
INSERT INTO `c_city` VALUES ('319', '铜川', '0919', '陕西省', '22', 'TC');
INSERT INTO `c_city` VALUES ('320', '商洛', '0914', '陕西省', '22', 'SL');
INSERT INTO `c_city` VALUES ('321', '安康', '0915', '陕西省', '22', 'AK');
INSERT INTO `c_city` VALUES ('322', '汉中', '0916', '陕西省', '22', 'HZ');
INSERT INTO `c_city` VALUES ('323', '宝鸡', '0917', '陕西省', '22', 'BJ');
INSERT INTO `c_city` VALUES ('324', '咸阳', '029', '陕西省', '22', 'XY');
INSERT INTO `c_city` VALUES ('325', '渭南', '0913', '陕西省', '22', 'WN');
INSERT INTO `c_city` VALUES ('326', '太原', '0351', '山西省', '23', 'TY');
INSERT INTO `c_city` VALUES ('327', '临汾', '0357', '山西省', '23', 'LF');
INSERT INTO `c_city` VALUES ('328', '运城', '0359', '山西省', '23', 'YC');
INSERT INTO `c_city` VALUES ('329', '朔州', '0349', '山西省', '23', 'SZ');
INSERT INTO `c_city` VALUES ('330', '忻州', '0350', '山西省', '23', 'XZ');
INSERT INTO `c_city` VALUES ('331', '长治', '0355', '山西省', '23', 'CZ');
INSERT INTO `c_city` VALUES ('332', '大同', '0352', '山西省', '23', 'DT');
INSERT INTO `c_city` VALUES ('333', '阳泉', '0353', '山西省', '23', 'YQ');
INSERT INTO `c_city` VALUES ('334', '晋中', '0354', '山西省', '23', 'JZ');
INSERT INTO `c_city` VALUES ('335', '晋城', '0356', '山西省', '23', 'JC');
INSERT INTO `c_city` VALUES ('336', '吕梁', '0358', '山西省', '23', 'LL');
INSERT INTO `c_city` VALUES ('337', '乌鲁木齐', '0991', '新疆维吾尔族自治区', '24', 'WLMQ');
INSERT INTO `c_city` VALUES ('338', '石河子', '0993', '新疆维吾尔族自治区', '24', 'SHZ');
INSERT INTO `c_city` VALUES ('339', '昌吉', '0994', '新疆维吾尔族自治区', '24', 'CJ');
INSERT INTO `c_city` VALUES ('340', '吐鲁番', '0995', '新疆维吾尔族自治区', '24', 'TLF');
INSERT INTO `c_city` VALUES ('341', '库尔勒', '0996', '新疆维吾尔族自治区', '24', 'KEL');
INSERT INTO `c_city` VALUES ('342', '阿拉尔', '0997', '新疆维吾尔族自治区', '24', 'ALE');
INSERT INTO `c_city` VALUES ('343', '阿克苏', '0997', '新疆维吾尔族自治区', '24', 'AKS');
INSERT INTO `c_city` VALUES ('344', '喀什', '0998', '新疆维吾尔族自治区', '24', 'KS');
INSERT INTO `c_city` VALUES ('345', '伊宁', '0999', '新疆维吾尔族自治区', '24', 'YN');
INSERT INTO `c_city` VALUES ('346', '塔城', '0901', '新疆维吾尔族自治区', '24', 'TC');
INSERT INTO `c_city` VALUES ('347', '哈密', '0902', '新疆维吾尔族自治区', '24', 'HM');
INSERT INTO `c_city` VALUES ('348', '和田', '0903', '新疆维吾尔族自治区', '24', 'HT');
INSERT INTO `c_city` VALUES ('349', '阿勒泰', '0906', '新疆维吾尔族自治区', '24', 'ALT');
INSERT INTO `c_city` VALUES ('350', '阿图什', '0908', '新疆维吾尔族自治区', '24', 'ATS');
INSERT INTO `c_city` VALUES ('351', '博乐', '0909', '新疆维吾尔族自治区', '24', 'BL');
INSERT INTO `c_city` VALUES ('352', '克拉玛依', '0990', '新疆维吾尔族自治区', '24', 'KLMY');
INSERT INTO `c_city` VALUES ('353', '拉萨', '0891', '西藏自治区', '25', 'LS');
INSERT INTO `c_city` VALUES ('354', '山南', '0893', '西藏自治区', '25', 'SN');
INSERT INTO `c_city` VALUES ('355', '阿里', '0897', '西藏自治区', '25', 'AL');
INSERT INTO `c_city` VALUES ('356', '昌都', '0895', '西藏自治区', '25', 'CD');
INSERT INTO `c_city` VALUES ('357', '那曲', '0896', '西藏自治区', '25', 'NQ');
INSERT INTO `c_city` VALUES ('358', '日喀则', '0892', '西藏自治区', '25', 'RKZ');
INSERT INTO `c_city` VALUES ('359', '林芝', '0894', '西藏自治区', '25', 'LZ');
INSERT INTO `c_city` VALUES ('360', '台北县', '008862', '台湾', '26', 'TBX');
INSERT INTO `c_city` VALUES ('361', '高雄', '008867', '台湾', '26', 'GX');
INSERT INTO `c_city` VALUES ('362', '台中', '008864', '台湾', '26', 'TZ');
INSERT INTO `c_city` VALUES ('363', '海口', '0898', '海南省', '27', 'HK');
INSERT INTO `c_city` VALUES ('364', '三亚', '0898', '海南省', '27', 'SY');
INSERT INTO `c_city` VALUES ('365', '东方', '0898', '海南省', '27', 'DF');
INSERT INTO `c_city` VALUES ('366', '临高', '0898', '海南省', '27', 'LG');
INSERT INTO `c_city` VALUES ('367', '澄迈', '0898', '海南省', '27', 'CM');
INSERT INTO `c_city` VALUES ('368', '儋州', '0898', '海南省', '27', 'ZZ');
INSERT INTO `c_city` VALUES ('369', '昌江', '0798', '海南省', '27', 'CJ');
INSERT INTO `c_city` VALUES ('370', '白沙', '0898', '海南省', '27', 'BS');
INSERT INTO `c_city` VALUES ('371', '琼中', '0898', '海南省', '27', 'QZ');
INSERT INTO `c_city` VALUES ('372', '定安', '0898', '海南省', '27', 'DA');
INSERT INTO `c_city` VALUES ('373', '屯昌', '0898', '海南省', '27', 'TC');
INSERT INTO `c_city` VALUES ('374', '琼海', '0898', '海南省', '27', 'QH');
INSERT INTO `c_city` VALUES ('375', '文昌', '0898', '海南省', '27', 'WC');
INSERT INTO `c_city` VALUES ('376', '保亭', '0898', '海南省', '27', 'BT');
INSERT INTO `c_city` VALUES ('377', '万宁', '0898', '海南省', '27', 'WN');
INSERT INTO `c_city` VALUES ('378', '陵水', '0898', '海南省', '27', 'LS');
INSERT INTO `c_city` VALUES ('379', '西沙', '0898', '海南省', '27', 'XS');
INSERT INTO `c_city` VALUES ('380', '南沙群岛', '0898', '海南省', '27', 'NSQD');
INSERT INTO `c_city` VALUES ('381', '乐东', '0898', '海南省', '27', 'LD');
INSERT INTO `c_city` VALUES ('382', '五指山', '0898', '海南省', '27', 'WZS');
INSERT INTO `c_city` VALUES ('383', '琼山', '0898', '海南省', '27', 'QS');
INSERT INTO `c_city` VALUES ('384', '长沙', '0731', '湖南省', '28', 'CS');
INSERT INTO `c_city` VALUES ('385', '株洲', '0731', '湖南省', '28', 'ZZ');
INSERT INTO `c_city` VALUES ('386', '衡阳', '0734', '湖南省', '28', 'HY');
INSERT INTO `c_city` VALUES ('387', '郴州', '0735', '湖南省', '28', 'CZ');
INSERT INTO `c_city` VALUES ('388', '常德', '0736', '湖南省', '28', 'CD');
INSERT INTO `c_city` VALUES ('389', '益阳', '0737', '湖南省', '28', 'YY');
INSERT INTO `c_city` VALUES ('390', '娄底', '0738', '湖南省', '28', 'LD');
INSERT INTO `c_city` VALUES ('391', '邵阳', '0739', '湖南省', '28', 'SY');
INSERT INTO `c_city` VALUES ('392', '岳阳', '0730', '湖南省', '28', 'YY');
INSERT INTO `c_city` VALUES ('393', '张家界', '0744', '江苏省', '29', 'ZJJ');
INSERT INTO `c_city` VALUES ('394', '怀化', '0745', '湖南省', '28', 'HH');
INSERT INTO `c_city` VALUES ('395', '黔阳', '0745', '湖南省', '28', 'QY');
INSERT INTO `c_city` VALUES ('396', '永州', '0746', '湖南省', '28', 'YZ');
INSERT INTO `c_city` VALUES ('397', '吉首', '0743', '湖南省', '28', 'JS');
INSERT INTO `c_city` VALUES ('398', '湘潭', '0731', '湖南省', '28', 'XT');
INSERT INTO `c_city` VALUES ('399', '南京', '025', '江苏省', '29', 'NJ');
INSERT INTO `c_city` VALUES ('400', '镇江', '0511', '江苏省', '29', 'ZJ');
INSERT INTO `c_city` VALUES ('401', '苏州', '0512', '江苏省', '29', 'SZ');
INSERT INTO `c_city` VALUES ('402', '南通', '0513', '江苏省', '29', 'NT');
INSERT INTO `c_city` VALUES ('403', '扬州', '0514', '江苏省', '29', 'YZ');
INSERT INTO `c_city` VALUES ('404', '宿迁', '0527', '江苏省', '29', 'SQ');
INSERT INTO `c_city` VALUES ('405', '徐州', '0516', '江苏省', '29', 'XZ');
INSERT INTO `c_city` VALUES ('406', '淮安', '0517', '江苏省', '29', 'HA');
INSERT INTO `c_city` VALUES ('407', '连云港', '0518', '江苏省', '29', 'LYG');
INSERT INTO `c_city` VALUES ('408', '常州', '0519', '江苏省', '29', 'CZ');
INSERT INTO `c_city` VALUES ('409', '泰州', '0523', '江苏省', '29', 'TZ');
INSERT INTO `c_city` VALUES ('410', '无锡', '0510', '江苏省', '29', 'WX');
INSERT INTO `c_city` VALUES ('411', '盐城', '0515', '江苏省', '29', 'YC');
INSERT INTO `c_city` VALUES ('412', '哈尔滨', '0451', '黑龙江省', '30', 'HEB');
INSERT INTO `c_city` VALUES ('413', '牡丹江', '0453', '黑龙江省', '30', 'MDJ');
INSERT INTO `c_city` VALUES ('414', '佳木斯', '0454', '黑龙江省', '30', 'JMS');
INSERT INTO `c_city` VALUES ('415', '绥化', '0455', '黑龙江省', '30', 'SH');
INSERT INTO `c_city` VALUES ('416', '黑河', '0456', '黑龙江省', '30', 'HH');
INSERT INTO `c_city` VALUES ('417', '双鸭山', '0469', '黑龙江省', '30', 'SYS');
INSERT INTO `c_city` VALUES ('418', '伊春', '0458', '黑龙江省', '30', 'YC');
INSERT INTO `c_city` VALUES ('419', '大庆', '0459', '黑龙江省', '30', 'DQ');
INSERT INTO `c_city` VALUES ('420', '七台河', '0464', '黑龙江省', '30', 'QTH');
INSERT INTO `c_city` VALUES ('421', '鸡西', '0467', '黑龙江省', '30', 'JX');
INSERT INTO `c_city` VALUES ('422', '鹤岗', '0468', '黑龙江省', '30', 'HG');
INSERT INTO `c_city` VALUES ('423', '齐齐哈尔', '0452', '黑龙江省', '30', 'QQHE');
INSERT INTO `c_city` VALUES ('424', '大兴安岭', '0457', '黑龙江省', '30', 'DXAL');
INSERT INTO `c_city` VALUES ('425', '长春', '0431', '吉林省', '31', 'CC');
INSERT INTO `c_city` VALUES ('426', '延吉', '0433', '吉林省', '31', 'YJ');
INSERT INTO `c_city` VALUES ('427', '四平', '0434', '吉林省', '31', 'SP');
INSERT INTO `c_city` VALUES ('428', '白山', '0439', '吉林省', '31', 'BS');
INSERT INTO `c_city` VALUES ('429', '白城', '0436', '吉林省', '31', 'BC');
INSERT INTO `c_city` VALUES ('430', '辽源', '0437', '吉林省', '31', 'LY');
INSERT INTO `c_city` VALUES ('431', '松原', '0438', '吉林省', '31', 'SY');
INSERT INTO `c_city` VALUES ('432', '吉林', '0432', '吉林省', '31', 'JL');
INSERT INTO `c_city` VALUES ('433', '通化', '0435', '吉林省', '31', 'TH');
INSERT INTO `c_city` VALUES ('434', '沈阳', '024', '辽宁省', '32', 'SY');
INSERT INTO `c_city` VALUES ('435', '鞍山', '0412', '辽宁省', '32', 'AS');
INSERT INTO `c_city` VALUES ('436', '抚顺', '024', '辽宁省', '32', 'FS');
INSERT INTO `c_city` VALUES ('437', '本溪', '0414', '辽宁省', '32', 'BX');
INSERT INTO `c_city` VALUES ('438', '丹东', '0415', '辽宁省', '32', 'DD');
INSERT INTO `c_city` VALUES ('439', '葫芦岛', '0429', '辽宁省', '32', 'HLD');
INSERT INTO `c_city` VALUES ('440', '营口', '0417', '辽宁省', '32', 'YK');
INSERT INTO `c_city` VALUES ('441', '阜新', '0418', '辽宁省', '32', 'FX');
INSERT INTO `c_city` VALUES ('442', '辽阳', '0419', '辽宁省', '32', 'LY');
INSERT INTO `c_city` VALUES ('443', '铁岭', '024', '辽宁省', '32', 'TL');
INSERT INTO `c_city` VALUES ('444', '朝阳市', '0421', '辽宁省', '32', 'CY');
INSERT INTO `c_city` VALUES ('445', '盘锦', '0427', '辽宁省', '32', 'PJ');
INSERT INTO `c_city` VALUES ('446', '大连', '0411', '辽宁省', '32', 'DL');
INSERT INTO `c_city` VALUES ('447', '锦州', '0416', '辽宁省', '32', 'JZ');

-- ----------------------------
-- Table structure for c_province
-- ----------------------------
DROP TABLE IF EXISTS `c_province`;
CREATE TABLE `c_province` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(30) NOT NULL COMMENT '省份名称',
  `municipality` smallint(1) NOT NULL DEFAULT '0',
  `first_letter` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_province
-- ----------------------------
INSERT INTO `c_province` VALUES ('1', '北京市', '1', 'BJ');
INSERT INTO `c_province` VALUES ('2', '天津市', '1', 'TJ');
INSERT INTO `c_province` VALUES ('3', '上海市', '1', 'SH');
INSERT INTO `c_province` VALUES ('4', '河北省', '0', 'HB');
INSERT INTO `c_province` VALUES ('5', '河南省', '0', 'HN');
INSERT INTO `c_province` VALUES ('6', '安徽省', '0', 'AH');
INSERT INTO `c_province` VALUES ('7', '浙江省', '0', 'ZJ');
INSERT INTO `c_province` VALUES ('8', '重庆市', '1', 'CQ');
INSERT INTO `c_province` VALUES ('9', '福建省', '0', 'FJ');
INSERT INTO `c_province` VALUES ('10', '甘肃省', '0', 'GS');
INSERT INTO `c_province` VALUES ('11', '广东省', '0', 'GD');
INSERT INTO `c_province` VALUES ('12', '广西壮族自治区', '0', 'GX');
INSERT INTO `c_province` VALUES ('13', '贵州省', '0', 'GZ');
INSERT INTO `c_province` VALUES ('14', '云南省', '0', 'YN');
INSERT INTO `c_province` VALUES ('15', '内蒙古自治区', '0', 'NM');
INSERT INTO `c_province` VALUES ('16', '江西省', '0', 'JX');
INSERT INTO `c_province` VALUES ('17', '湖北省', '0', 'HB');
INSERT INTO `c_province` VALUES ('18', '四川省', '0', 'SC');
INSERT INTO `c_province` VALUES ('19', '宁夏回族自治区', '0', 'NX');
INSERT INTO `c_province` VALUES ('20', '青海省', '0', 'QH');
INSERT INTO `c_province` VALUES ('21', '山东省', '0', 'SD');
INSERT INTO `c_province` VALUES ('22', '陕西省', '0', 'SX');
INSERT INTO `c_province` VALUES ('23', '山西省', '0', 'SX');
INSERT INTO `c_province` VALUES ('24', '新疆维吾尔族自治区', '0', 'XJ');
INSERT INTO `c_province` VALUES ('25', '西藏自治区', '0', 'XZ');
INSERT INTO `c_province` VALUES ('26', '台湾', '0', 'TW');
INSERT INTO `c_province` VALUES ('27', '海南省', '0', 'HN');
INSERT INTO `c_province` VALUES ('28', '湖南省', '0', 'HN');
INSERT INTO `c_province` VALUES ('29', '江苏省', '0', 'JS');
INSERT INTO `c_province` VALUES ('30', '黑龙江省', '0', 'HLJ');
INSERT INTO `c_province` VALUES ('31', '吉林省', '0', 'JL');
INSERT INTO `c_province` VALUES ('32', '辽宁省', '0', 'LN');

-- ----------------------------
-- Table structure for c_role
-- ----------------------------
DROP TABLE IF EXISTS `c_role`;
CREATE TABLE `c_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role_desc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `permissions` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `default_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of c_role
-- ----------------------------
INSERT INTO `c_role` VALUES ('1', 'admin', '系统管理员', 'A', 'sub-admin', 'www.javadc.com');
INSERT INTO `c_role` VALUES ('2', 'subadmin', '管理员', 'B', 'sub-admin', 'www.javadc.com');
INSERT INTO `c_role` VALUES ('3', 'Testadmin', '系统测试管理员', 'T', 'Test-admin', 'www.javadc.com');

-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `login_name` varchar(255) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO `c_user` VALUES ('7', '杨鹏', 'yangpeng', '123456');
INSERT INTO `c_user` VALUES ('8', '杨晓鹏', 'yangxiaopeng', '123456');

-- ----------------------------
-- Table structure for c_user_role
-- ----------------------------
DROP TABLE IF EXISTS `c_user_role`;
CREATE TABLE `c_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of c_user_role
-- ----------------------------
INSERT INTO `c_user_role` VALUES ('1', '7', '2');
INSERT INTO `c_user_role` VALUES ('2', '7', '1');
INSERT INTO `c_user_role` VALUES ('3', '7', '3');
