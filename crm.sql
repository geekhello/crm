/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-10-16 19:04:44
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `base_dict`
-- ----------------------------
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE `base_dict` (
  `dict_id` varchar(32) NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目(可为空)',
  `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_dict
-- ----------------------------
INSERT INTO base_dict VALUES ('1', '001', '客户行业', '教育培训 ', null, '1', '1', null);
INSERT INTO base_dict VALUES ('10', '003', '公司性质', '民企', null, '3', '1', null);
INSERT INTO base_dict VALUES ('12', '004', '年营业额', '1-10万', null, '1', '1', null);
INSERT INTO base_dict VALUES ('13', '004', '年营业额', '10-20万', null, '2', '1', null);
INSERT INTO base_dict VALUES ('14', '004', '年营业额', '20-50万', null, '3', '1', null);
INSERT INTO base_dict VALUES ('15', '004', '年营业额', '50-100万', null, '4', '1', null);
INSERT INTO base_dict VALUES ('16', '004', '年营业额', '100-500万', null, '5', '1', null);
INSERT INTO base_dict VALUES ('17', '004', '年营业额', '500-1000万', null, '6', '1', null);
INSERT INTO base_dict VALUES ('18', '005', '客户状态', '基础客户', null, '1', '1', null);
INSERT INTO base_dict VALUES ('19', '005', '客户状态', '潜在客户', null, '2', '1', null);
INSERT INTO base_dict VALUES ('2', '001', '客户行业', '电子商务', null, '2', '1', null);
INSERT INTO base_dict VALUES ('20', '005', '客户状态', '成功客户', null, '3', '1', null);
INSERT INTO base_dict VALUES ('21', '005', '客户状态', '无效客户', null, '4', '1', null);
INSERT INTO base_dict VALUES ('22', '006', '客户级别', '普通客户', null, '1', '1', null);
INSERT INTO base_dict VALUES ('23', '006', '客户级别', 'VIP客户', null, '2', '1', null);
INSERT INTO base_dict VALUES ('24', '007', '商机状态', '意向客户', null, '1', '1', null);
INSERT INTO base_dict VALUES ('25', '007', '商机状态', '初步沟通', null, '2', '1', null);
INSERT INTO base_dict VALUES ('26', '007', '商机状态', '深度沟通', null, '3', '1', null);
INSERT INTO base_dict VALUES ('27', '007', '商机状态', '签订合同', null, '4', '1', null);
INSERT INTO base_dict VALUES ('3', '001', '客户行业', '对外贸易', null, '3', '1', null);
INSERT INTO base_dict VALUES ('30', '008', '商机类型', '新业务', null, '1', '1', null);
INSERT INTO base_dict VALUES ('31', '008', '商机类型', '现有业务', null, '2', '1', null);
INSERT INTO base_dict VALUES ('32', '009', '商机来源', '电话营销', null, '1', '1', null);
INSERT INTO base_dict VALUES ('33', '009', '商机来源', '网络营销', null, '2', '1', null);
INSERT INTO base_dict VALUES ('34', '009', '商机来源', '推广活动', null, '3', '1', null);
INSERT INTO base_dict VALUES ('4', '001', '客户行业', '酒店旅游', null, '4', '1', null);
INSERT INTO base_dict VALUES ('5', '001', '客户行业', '房地产', null, '5', '1', null);
INSERT INTO base_dict VALUES ('6', '002', '客户信息来源', '电话营销', null, '1', '1', null);
INSERT INTO base_dict VALUES ('7', '002', '客户信息来源', '网络营销', null, '2', '1', null);
INSERT INTO base_dict VALUES ('8', '003', '公司性质', '合资', null, '1', '1', null);
INSERT INTO base_dict VALUES ('9', '003', '公司性质', '国企', null, '2', '1', null);

-- ----------------------------
-- Table structure for `cst_customer`
-- ----------------------------
DROP TABLE IF EXISTS `cst_customer`;
CREATE TABLE `cst_customer` (
  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
  `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源(有字典表维护)',
  `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
  `cust_address` varchar(128) DEFAULT NULL COMMENT '客户联系地址',
  `cust_zip` varchar(16) DEFAULT NULL COMMENT '客户邮政编码',
  `cust_phone` varchar(64) DEFAULT NULL COMMENT '客户联系电话',
  `cust_fax` varchar(64) DEFAULT NULL COMMENT '客户传真',
  `cust_website` varchar(128) DEFAULT NULL COMMENT '客户网址',
  `cust_corporation` varchar(64) DEFAULT NULL COMMENT '企业法人',
  `cust_memo` longtext COMMENT '客户简介',
  `cust_user_id` bigint(32) DEFAULT NULL,
  `cust_create_id` bigint(32) DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  KEY `FKeh5g36duab8g1h051pdjfwcgd` (`cust_source`),
  KEY `FK30wnp6t5c4pn7039kt72mcej1` (`cust_user_id`),
  KEY `FKtg4lqnc7e57uypxp0nhweothg` (`cust_create_id`),
  CONSTRAINT `FK30wnp6t5c4pn7039kt72mcej1` FOREIGN KEY (`cust_user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FKeh5g36duab8g1h051pdjfwcgd` FOREIGN KEY (`cust_source`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `FKtg4lqnc7e57uypxp0nhweothg` FOREIGN KEY (`cust_create_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FK_cst_customer_create_id` FOREIGN KEY (`cust_create_id`) REFERENCES `sys_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cst_customer_user_id` FOREIGN KEY (`cust_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cst_customer
-- ----------------------------
INSERT INTO cst_customer VALUES ('121', '威化通驰', '6', '制造业', '22', '北京市朝阳区', '100100', '010-1234567', '010-321948923', 'http://www.whtc.comm', '通驰', '									', null, null);
INSERT INTO cst_customer VALUES ('122', '方程科技公司', '7', '互联网', '23', '北京市昌平区', '100100', '010-1234567', '010-1234567', 'http://www.fckj.com', '方程', '																			\r\n									', null, null);
INSERT INTO cst_customer VALUES ('123', '中影集团', '7', '互联网', '22', '蚌埠市禹会区', '233033', '18755085778', '0552-4837704', 'http://www.zy.com', '中影', '									', null, null);
INSERT INTO cst_customer VALUES ('124', '修正药业', '6', '医药制作', '23', '北京市昌平区', '100100', '010-1234567', '010-1234567', 'http://www.xiuzheng.com', '', '																			\r\n									', null, null);
INSERT INTO cst_customer VALUES ('125', '华为高科', '7', 'IT', '23', '北京市海淀区', '100100', '010-1234567', '010-321948923', 'http://www.hwgk.com', '', '																			\r\n									', null, null);
INSERT INTO cst_customer VALUES ('126', '大米科技', '7', '互联网', '22', '蚌埠市', '233031', '13865506839', '0552-4837704', 'http;//www.dami.com', '', '																			\r\n									', null, null);
INSERT INTO cst_customer VALUES ('127', '利华人寿', '6', '保险', '22', '蚌埠市禹会区', '233033', '0552-2345674', '0552-4837704', 'http;//www.lihua.com', '', '									', null, null);
INSERT INTO cst_customer VALUES ('129', '家乐氏', '6', '食品制作', '23', '蚌埠市禹会区', '233033', '0552-2345674', '0552-4837704', '', '', '																			\r\n									', null, null);

-- ----------------------------
-- Table structure for `cst_linkman`
-- ----------------------------
DROP TABLE IF EXISTS `cst_linkman`;
CREATE TABLE `cst_linkman` (
  `lkm_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
  `lkm_name` varchar(16) DEFAULT NULL COMMENT '联系人姓名',
  `lkm_gender` char(1) DEFAULT NULL COMMENT '联系人性别',
  `lkm_phone` varchar(16) DEFAULT NULL COMMENT '联系人办公电话',
  `lkm_mobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
  `lkm_email` varchar(64) DEFAULT NULL COMMENT '联系人邮箱',
  `lkm_position` varchar(16) DEFAULT NULL COMMENT '联系人职位',
  `lkm_memo` varchar(512) DEFAULT NULL COMMENT '联系人备注',
  `lkm_cust_id` bigint(32) NOT NULL COMMENT '客户id(外键)',
  PRIMARY KEY (`lkm_id`),
  KEY `FK_cst_linkman_lkm_cust_id` (`lkm_cust_id`),
  CONSTRAINT `FKh9yp1nql5227xxcopuxqx2e7q` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cst_linkman
-- ----------------------------
INSERT INTO cst_linkman VALUES ('28', 'Tom', '1', '0552-4684969', '13004091521', 'tom@whtc.com', '宣传', '', '121');
INSERT INTO cst_linkman VALUES ('29', '雷布斯', '1', '010-3333333', '13333333333', 'lbs@dami.com', '董事', 'NB', '126');
INSERT INTO cst_linkman VALUES ('30', 'Jack', '1', '0552-4684969', '13004091521', 'jack@fckj.com', '人事', '', '122');
INSERT INTO cst_linkman VALUES ('31', '上虞', '2', '010-3333333', '18316920318', 'shagnyu@163.com', '策划', 'good', '124');
INSERT INTO cst_linkman VALUES ('32', '晓明', '1', '0552-4684969', '13004091521', '', '', 'good', '129');

-- ----------------------------
-- Table structure for `sale_visit`
-- ----------------------------
DROP TABLE IF EXISTS `sale_visit`;
CREATE TABLE `sale_visit` (
  `visit_id` varchar(32) NOT NULL,
  `visit_cust_id` bigint(32) DEFAULT NULL COMMENT '客户id',
  `visit_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
  `visit_time` date DEFAULT NULL COMMENT '拜访时间',
  `visit_interviewee` varchar(32) DEFAULT NULL COMMENT '被拜访人',
  `visit_addr` varchar(128) DEFAULT NULL COMMENT '拜访地点',
  `visit_detail` varchar(256) DEFAULT NULL COMMENT '拜访详情',
  `visit_nexttime` date DEFAULT NULL COMMENT '下次拜访时间',
  PRIMARY KEY (`visit_id`),
  KEY `FK_sale_visit_cust_id` (`visit_cust_id`),
  KEY `FK_sale_visit_user_id` (`visit_user_id`),
  CONSTRAINT `FKc92iepd26mixxfiris92hccjx` FOREIGN KEY (`visit_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE SET NULL,
  CONSTRAINT `FKgr4aivocixwcvkwxcmc0b4css` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`),
  CONSTRAINT `FK_sale_visit_cust_id` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale_visit
-- ----------------------------
INSERT INTO sale_visit VALUES ('40287e8154e39a940154e3b1b36f0001', '121', '8', '2016-05-02', '杨科长', '上海市', '协同发展', '2016-05-09');
INSERT INTO sale_visit VALUES ('40287e8154e39a940154e3b3e6330002', '123', '5', '2016-05-06', '刘秘书', '上海市', '谈合作', '2016-05-10');
INSERT INTO sale_visit VALUES ('40287e8154e39a940154e3b488750003', '124', '6', '2016-05-10', '李总', '合肥市', '谈合作', '2016-05-12');
INSERT INTO sale_visit VALUES ('40287e8155149a090155149bb4c80000', '127', '6', '1916-05-18', '刘总', '蚌埠市', '谈设计', '1916-05-25');
INSERT INTO sale_visit VALUES ('40287e815514c3cd015514d63bb50000', '125', '8', '1916-06-07', '杨科长', '上海市', '协同发展', '1916-06-24');
INSERT INTO sale_visit VALUES ('40287e815516e47e015516e6abdd0000', '126', '6', '1916-06-08', '雷总', '上海市', '协同发展', '1916-06-15');
INSERT INTO sale_visit VALUES ('40287e8155172e2601551732ecb80000', '129', '6', '2016-06-06', '刘总', '上海市', '谈合作', '2016-06-16');
INSERT INTO sale_visit VALUES ('40287e81551950d70155195870fe0000', '123', '5', '2016-06-15', '李总', '上海市', '谈合作', '2016-06-23');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `role_memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO sys_role VALUES ('1', '员工', '查询、添加');
INSERT INTO sys_role VALUES ('2', '部门经理', '不能进行角色修改');
INSERT INTO sys_role VALUES ('3', '管理员', '全部功能');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_code` varchar(32) NOT NULL COMMENT '用户账号',
  `user_name` varchar(64) NOT NULL COMMENT '用户名称',
  `user_password` varchar(32) NOT NULL COMMENT '用户密码',
  `user_state` char(1) NOT NULL COMMENT '1:正常,0:暂停',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user VALUES ('5', 'm0003', '小军', '123', '1');
INSERT INTO sys_user VALUES ('6', 'm0002', '小红', '123', '1');
INSERT INTO sys_user VALUES ('8', 'm0001', '小李', '123', '1');
INSERT INTO sys_user VALUES ('9', 'm0004', '拉拉', '123', '0');
INSERT INTO sys_user VALUES ('10', 'm0005', '小侯', '123', '0');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` bigint(32) NOT NULL COMMENT '角色id',
  `user_id` bigint(32) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FK_user_role_user_id` (`user_id`),
  CONSTRAINT `FKb40xxfch70f5qnyfw8yme1n1s` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FKhh52n8vd4ny9ff4x9fb8v65qx` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FK_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO sys_user_role VALUES ('1', '5');
INSERT INTO sys_user_role VALUES ('2', '5');
INSERT INTO sys_user_role VALUES ('1', '6');
INSERT INTO sys_user_role VALUES ('3', '8');
INSERT INTO sys_user_role VALUES ('1', '9');
INSERT INTO sys_user_role VALUES ('2', '10');
