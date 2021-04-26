/*
 Navicat Premium Data Transfer

 Source Server         : 本地主机
 Source Server Type    : MySQL
 Source Server Version : 50651
 Source Host           : localhost:3306
 Source Schema         : bro_dog_mall

 Target Server Type    : MySQL
 Target Server Version : 50651
 File Encoding         : 65001

 Date: 23/04/2021 15:43:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` bigint(20) NOT NULL COMMENT '商品id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `subtitle` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '副标题',
  `cate_id` bigint(20) NOT NULL COMMENT '分类id',
  `brand_id` bigint(20) NOT NULL COMMENT '品牌id',
  `sales` int(11) NOT NULL DEFAULT 0 COMMENT '销量',
  `inventory` int(11) NOT NULL COMMENT '库存量',
  `sell_price` decimal(10, 2) NOT NULL COMMENT '售价',
  `market_price` decimal(10, 2) NOT NULL COMMENT '市场价',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `weight` double NOT NULL COMMENT '重量',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `verify_status` int(1) NOT NULL COMMENT '审核状态，0未通过，1 通过',
  `is_hot` int(1) NOT NULL DEFAULT 0 COMMENT '是否推荐， 0 否，1 是',
  `is_pre_sale` int(1) NULL DEFAULT 0 COMMENT '是否预售商品，0 否，1 是',
  `is_sale` int(1) NOT NULL DEFAULT 0 COMMENT '是否上架，0 否，1 是',
  `is_del` int(1) NOT NULL COMMENT '是否删除， 0 否，1 是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for goods_attr
-- ----------------------------
DROP TABLE IF EXISTS `goods_attr`;
CREATE TABLE `goods_attr`  (
  `id` bigint(20) NOT NULL COMMENT '商品-属性id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `attr_count` int(11) NOT NULL DEFAULT 0 COMMENT '属性个数',
  `spec_count` int(11) NOT NULL DEFAULT 0 COMMENT '规格个数',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0 否，1 是',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品-属性' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_attr
-- ----------------------------
INSERT INTO `goods_attr` VALUES (1, '手机', 1, 1, 0, '2021-04-22 11:59:14', '2021-04-23 15:35:44');
INSERT INTO `goods_attr` VALUES (2, '电脑', 0, 0, 0, '2021-04-22 11:59:14', '2021-04-23 15:35:44');
INSERT INTO `goods_attr` VALUES (1385080729443393537, 'test', 0, 0, 0, '2021-04-22 11:59:14', '2021-04-23 15:35:44');
INSERT INTO `goods_attr` VALUES (1385153668335464449, 'test', 1000, 100, 1, '2021-04-22 16:49:04', '2021-04-22 16:49:04');

-- ----------------------------
-- Table structure for goods_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `goods_attr_value`;
CREATE TABLE `goods_attr_value`  (
  `id` bigint(20) NOT NULL COMMENT '商品-属性-属性值-id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性值名称',
  `goods_attr_id` bigint(20) NOT NULL COMMENT '商品-属性 id',
  `value_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '可选值列表，逗号拼接',
  `input_type` int(1) NOT NULL DEFAULT 1 COMMENT '属性值录入方式，0 手动，1 列表选择',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0 否，1 是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性-属性值表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_attr_value
-- ----------------------------
INSERT INTO `goods_attr_value` VALUES (1, '电池', 1, '', 0, NULL, 0, '2021-04-19 21:48:32', '2021-04-19 21:48:36');
INSERT INTO `goods_attr_value` VALUES (2, '系统', 1, '', 1, NULL, 0, '2021-04-20 22:51:50', '2021-04-20 22:51:53');

-- ----------------------------
-- Table structure for goods_brand
-- ----------------------------
DROP TABLE IF EXISTS `goods_brand`;
CREATE TABLE `goods_brand`  (
  `id` bigint(20) NOT NULL COMMENT '品牌编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '品牌名称',
  `first_letter` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '品牌首字母',
  `sort` int(11) NOT NULL COMMENT '排序',
  `is_show` int(1) NOT NULL DEFAULT 1 COMMENT '是否显示，0 否，1 是',
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'logo',
  `big_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '品牌专区 图片',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品品牌' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_brand
-- ----------------------------
INSERT INTO `goods_brand` VALUES (1, '华为', 'H', 100, 1, 'https://inews.gtimg.com/newsapp_bt/0/11493349118/1000', 'https://article-fd.zol-img.com.cn/t_s640x2000/g6/M00/09/06/ChMkKWBYIwuIZSNYAABNP3j3Dg8AAL3uQPGS18AAE1X131.jpg', 0, '2021-04-19 21:20:38', '2021-04-19 21:20:43');

-- ----------------------------
-- Table structure for goods_cate
-- ----------------------------
DROP TABLE IF EXISTS `goods_cate`;
CREATE TABLE `goods_cate`  (
  `id` bigint(20) NOT NULL COMMENT '商品分类id',
  `pid` bigint(20) NOT NULL DEFAULT 0 COMMENT '上级分类',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `count` int(11) NOT NULL DEFAULT 0 COMMENT '商品个数',
  `level` int(1) NOT NULL DEFAULT 1 COMMENT '分类等级，1 一级，2 二级',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '数量单位',
  `icon` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图标',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '关键词',
  `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `is_show` int(1) NOT NULL DEFAULT 1 COMMENT '是否显示，0 否，1 是',
  `is_menu` int(1) NOT NULL DEFAULT 0 COMMENT '是否导航栏显示，0 否，1 是',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0 否，1 是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品分类' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_cate
-- ----------------------------
INSERT INTO `goods_cate` VALUES (1, 0, '手机数码', 1, 1, '件', 'http://pics6.baidu.com/feed/cf1b9d16fdfaaf5119a774b887b04fe8f11f7a58.jpeg?token=817cbee708e15d929be6fe89fc18f614', 100, '手机,智能手机', '手机,OPPO,Huawei,Apple', 1, 1, 0, '2021-04-19 21:28:31', '2021-04-19 21:28:34');
INSERT INTO `goods_cate` VALUES (2, 0, '电脑', 1, 1, '件', 'https://img.alicdn.com/bao/uploaded/i1/897609396/O1CN01HTBaiN2JHQ2XoankI_!!0-item_pic.jpg_310x310.jpghttps://img.alicdn.com/bao/uploaded/i1/897609396/O1CN01HTBaiN2JHQ2XoankI_!!0-item_pic.jpg_310x310.jpg', 90, '笔记本电脑，台式电脑', '电脑', 1, 0, 0, '2021-04-19 21:33:39', '2021-04-19 21:33:43');

-- ----------------------------
-- Table structure for goods_comment
-- ----------------------------
DROP TABLE IF EXISTS `goods_comment`;
CREATE TABLE `goods_comment`  (
  `id` bigint(20) NOT NULL DEFAULT 5 COMMENT '评论id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `goods_cate_id` bigint(20) NOT NULL COMMENT '商品分类id',
  `goods_attr_id` bigint(20) NOT NULL COMMENT '商品属性id',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ip地址',
  `start` int(3) NOT NULL COMMENT '五星点赞',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '评论内容',
  `is_del` int(1) NOT NULL COMMENT '是否删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评论' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_comment
-- ----------------------------

-- ----------------------------
-- Table structure for goods_comment_replay
-- ----------------------------
DROP TABLE IF EXISTS `goods_comment_replay`;
CREATE TABLE `goods_comment_replay`  (
  `id` bigint(20) NOT NULL COMMENT '回复id',
  `comment_id` bigint(20) NOT NULL COMMENT '评论id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ip 地址',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '回复内容',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0 否，1 是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论回复表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_comment_replay
-- ----------------------------

-- ----------------------------
-- Table structure for goods_desc
-- ----------------------------
DROP TABLE IF EXISTS `goods_desc`;
CREATE TABLE `goods_desc`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `subtitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '副标题',
  `integral` double(11, 2) NULL DEFAULT 0.00 COMMENT '积分',
  `growth_value` double(11, 2) NULL DEFAULT 0.00 COMMENT '成长值',
  `desc_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '详细页标题',
  `desc` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详情',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '关键字',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品详情表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_desc
-- ----------------------------

-- ----------------------------
-- Table structure for goods_pics
-- ----------------------------
DROP TABLE IF EXISTS `goods_pics`;
CREATE TABLE `goods_pics`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片url地址',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0 否，1 是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_pics
-- ----------------------------

-- ----------------------------
-- Table structure for goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE `goods_sku`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `sku_number` int(11) NOT NULL COMMENT 'sku 编号',
  `price` decimal(10, 2) NOT NULL COMMENT '商品 单价',
  `promotion_price` decimal(10, 2) NOT NULL COMMENT '促销 价格',
  `stock` int(11) NOT NULL COMMENT '库存',
  `low_stock` int(11) NOT NULL COMMENT '最低库存，报警量',
  `pic` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品图片',
  `lock_stock` int(11) NOT NULL COMMENT '锁定库存',
  `data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'sku json数据',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品SKU表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_sku
-- ----------------------------

-- ----------------------------
-- Table structure for goods_spec
-- ----------------------------
DROP TABLE IF EXISTS `goods_spec`;
CREATE TABLE `goods_spec`  (
  `id` bigint(20) NOT NULL COMMENT '商品-规格-id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品规格名称',
  `goods_attr_id` bigint(20) NOT NULL COMMENT '商品-属性 id',
  `value_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '可选值列表',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0 否，1 是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品-规格' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_spec
-- ----------------------------
INSERT INTO `goods_spec` VALUES (1, '颜色', 1, '', 100, 0, '2021-04-19 21:42:32', '2021-04-19 21:42:37');
INSERT INTO `goods_spec` VALUES (2, '容量', 1, '64G,128G,256G,512G', 99, 0, '2021-04-19 21:45:26', '2021-04-19 21:45:30');

SET FOREIGN_KEY_CHECKS = 1;
