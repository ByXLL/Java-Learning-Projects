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

 Date: 24/05/2021 23:17:47
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
  `verify_status` int(1) NOT NULL DEFAULT 0 COMMENT '审核状态，0未通过，1 通过',
  `is_hot` int(1) NULL DEFAULT 0 COMMENT '是否推荐， 0 否，1 是',
  `is_pre_sale` int(1) NULL DEFAULT 0 COMMENT '是否预售商品，0 否，1 是',
  `is_sale` int(1) NOT NULL DEFAULT 0 COMMENT '是否上架，0 否，1 是',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除， 0 否，1 是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '华为 Mate 40 Pro4', '华为手机', 1, 1, 0, 100, 1000.00, 100.00, '件', 150, 100, 0, 1, 0, 0, 0, '2021-05-05 19:54:20', '2021-05-05 19:54:27');
INSERT INTO `goods` VALUES (1391736401354440705, '商品名称', '商品副标题', 1, 1, 0, 100, 110.00, 110.00, '件', 1.5, 100, 1, 1, 1, 1, 0, '2021-05-10 20:46:30', '2021-05-11 22:55:01');

-- ----------------------------
-- Table structure for goods_attr
-- ----------------------------
DROP TABLE IF EXISTS `goods_attr`;
CREATE TABLE `goods_attr`  (
  `id` bigint(20) NOT NULL COMMENT '商品-属性-id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `goods_attr_cate_id` bigint(20) NOT NULL COMMENT '商品-属性-分类 id',
  `value_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '可选值列表，逗号拼接',
  `input_type` int(1) NOT NULL DEFAULT 1 COMMENT '可选值录入方式，0 手动，1 列表选择',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0 否，1 是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_attr
-- ----------------------------
INSERT INTO `goods_attr` VALUES (1388026477273358222, '电池', 1, '', 1, NULL, 0, '2021-04-19 21:48:32', '2021-05-20 09:43:06');
INSERT INTO `goods_attr` VALUES (1388026477273358333, '系统', 1, '', 0, NULL, 0, '2021-04-20 22:51:50', '2021-04-20 22:51:53');
INSERT INTO `goods_attr` VALUES (1388026477273358338, '上市时间', 1, '', 0, 100, 0, '2021-04-30 15:04:35', '2021-04-30 15:04:35');
INSERT INTO `goods_attr` VALUES (1388026654935687169, 'CPU', 1, '', 0, 100, 0, '2021-04-30 15:05:17', '2021-04-30 15:05:17');
INSERT INTO `goods_attr` VALUES (1388026726947692546, '屏幕尺寸', 1, '', 0, 100, 0, '2021-04-30 15:05:35', '2021-04-30 15:05:35');
INSERT INTO `goods_attr` VALUES (1388026776029437953, '机身厚度', 1, '', 0, 100, 0, '2021-04-30 15:05:46', '2021-04-30 15:34:38');
INSERT INTO `goods_attr` VALUES (1395197805499744258, '屏幕尺寸', 2, '13.9,14,15.6,17', 1, NULL, 0, '2021-05-20 10:00:53', '2021-05-20 10:01:00');
INSERT INTO `goods_attr` VALUES (1395198342232199169, '分辨率', 2, '', 0, NULL, 0, '2021-05-20 10:03:01', '2021-05-20 10:03:01');
INSERT INTO `goods_attr` VALUES (1395199157286129666, '类型', 2, '', 0, NULL, 0, '2021-05-20 10:06:15', '2021-05-20 10:06:15');
INSERT INTO `goods_attr` VALUES (1395199214106365953, '系统', 2, '', 0, NULL, 0, '2021-05-20 10:06:29', '2021-05-20 10:06:29');
INSERT INTO `goods_attr` VALUES (1395304591967834113, '厚度', 2, '', 0, NULL, 0, '2021-05-20 17:05:13', '2021-05-20 17:05:13');
INSERT INTO `goods_attr` VALUES (1395304857697964033, '机身材质', 2, '', 0, NULL, 0, '2021-05-20 17:06:16', '2021-05-20 17:06:16');

-- ----------------------------
-- Table structure for goods_attr_cate
-- ----------------------------
DROP TABLE IF EXISTS `goods_attr_cate`;
CREATE TABLE `goods_attr_cate`  (
  `id` bigint(20) NOT NULL COMMENT '商品-属性分类id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性分类名称',
  `attr_count` int(11) NOT NULL DEFAULT 0 COMMENT '属性个数',
  `spec_count` int(11) NOT NULL DEFAULT 0 COMMENT '规格个数',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0 否，1 是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品-属性分类表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_attr_cate
-- ----------------------------
INSERT INTO `goods_attr_cate` VALUES (1, '手机', 6, 2, 0, '2021-04-22 11:59:14', '2021-05-19 14:51:36');
INSERT INTO `goods_attr_cate` VALUES (2, '电脑', 6, 2, 0, '2021-04-22 11:59:14', '2021-05-21 09:28:03');
INSERT INTO `goods_attr_cate` VALUES (3, '衣服', 0, 2, 0, '2021-04-29 14:36:22', '2021-04-29 14:36:25');
INSERT INTO `goods_attr_cate` VALUES (1394913973064105985, '鞋帽', 0, 0, 0, '2021-05-19 15:13:02', '2021-05-19 15:13:02');

-- ----------------------------
-- Table structure for goods_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `goods_attr_value`;
CREATE TABLE `goods_attr_value`  (
  `id` bigint(20) NOT NULL COMMENT '商品属性值 id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `goods_attr_id` bigint(20) NOT NULL COMMENT '商品属性 id',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性值',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性-属性值表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_attr_value
-- ----------------------------

-- ----------------------------
-- Table structure for goods_brand
-- ----------------------------
DROP TABLE IF EXISTS `goods_brand`;
CREATE TABLE `goods_brand`  (
  `id` bigint(20) NOT NULL COMMENT '品牌编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '品牌名称',
  `first_letter` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '品牌首字母',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
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
INSERT INTO `goods_brand` VALUES (1, '华为', 'H', 100, 1, 'https://inews.gtimg.com/newsapp_bt/0/11493349118/1000', 'https://article-fd.zol-img.com.cn/t_s640x2000/g6/M00/09/06/ChMkKWBYIwuIZSNYAABNP3j3Dg8AAL3uQPGS18AAE1X131.jpg', 0, '2021-04-19 21:20:38', '2021-05-19 11:47:11');
INSERT INTO `goods_brand` VALUES (2, 'OPPO', 'O', 200, 1, 'http://img.yao51.com/jiankangtuku/rtecceqhtx.jpeg', 'http://img.yao51.com/jiankangtuku/fgdjjdoihz.jpeg', 0, '2021-04-25 14:24:41', '2021-04-25 14:24:46');
INSERT INTO `goods_brand` VALUES (1386953722012540929, '华为1', 'H', 100, 1, 'https://inews.gtimg.com/newsapp_bt/0/11493349118/1000', 'https://article-fd.zol-img.com.cn/t_s640x2000/g6/M00/09/06/ChMkKWBYIwuIZSNYAABNP3j3Dg8AAL3uQPGS18AAE1X131.jpg', 1, '2021-04-27 16:01:50', '2021-04-27 16:01:50');
INSERT INTO `goods_brand` VALUES (1394858648415911938, '一加', 'O', NULL, 1, 'https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F8AScpv919pNO9tJ1Xj6v6iQbKmt1Ozu2I8JqVe%3DFr1KYt1534724647397compressflag.jpg&thumbnail=650x2147483647&quality=80&type=jpg', 'https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2020%2F0318%2Fc065cfefp00q7cjfu000cd200rs00dwg00kk00aa.png&thumbnail=650x2147483647&quality=80&type=jpg', 0, '2021-05-19 11:33:12', '2021-05-19 11:39:32');

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
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '描述',
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
INSERT INTO `goods_cate` VALUES (1, 0, '手机数码', 1, 1, '件', 'https://m.360buyimg.com/babel/jfs/t1/166462/35/9443/6711/6041f18cEf47cdc48/b52c59817cc4c440.png', 100, '手机,智能手机', '手机,OPPO,Huawei,Apple', 1, 1, 0, '2021-04-19 21:28:31', '2021-04-19 21:28:34');
INSERT INTO `goods_cate` VALUES (2, 0, '电脑', 1, 1, '件', 'https://m.360buyimg.com/babel/jfs/t1/157240/26/10309/6209/6041f1c7Ee50480cd/cb257189c5b35722.png', 90, '笔记本电脑，台式电脑', '电脑', 1, 0, 0, '2021-04-19 21:33:39', '2021-04-19 21:33:43');
INSERT INTO `goods_cate` VALUES (1387229105295380482, 0, '衣服', 200, 1, '件', 'https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/140012/8/1804/3641/5efbf318E38bd5dad/0db99d859ab16ce9.png', NULL, '衣服', '衣服分类', 1, 1, 0, '2021-04-28 10:16:07', '2021-04-28 10:36:15');
INSERT INTO `goods_cate` VALUES (1390855326046515202, 1387229105295380482, '鞋帽', 100, 1, '件', 'https://m.360buyimg.com/babel/jfs/t1/160051/34/17189/11875/606e614dE9f8618dd/e47e958eaebde71d.jpg!q70.jpg.webp', NULL, '衣服', '衣服分类', 1, 1, 0, '2021-05-08 10:25:25', '2021-05-14 16:05:58');
INSERT INTO `goods_cate` VALUES (1393115687227412482, 2, '笔记本电脑', 100, 2, '台', 'https://m.360buyimg.com/babel/jfs/t1/160051/34/17189/11875/606e614dE9f8618dd/e47e958eaebde71d.jpg!q70.jpg.webp', 1000, '笔记本,电脑,笔记本电脑,轻薄本', '笔记本,电脑,笔记本电脑,轻薄本', 1, 1, 1, '2021-05-14 16:07:17', '2021-05-14 16:15:40');

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
INSERT INTO `goods_desc` VALUES (1, 1, '华为手机', 10.00, 100.00, '华为 Mate 40 Pro', '华为5G手机', '华为', '备注', '2021-05-08 08:56:08', '2021-05-08 08:56:11');
INSERT INTO `goods_desc` VALUES (1391736414537138177, 1391736401354440705, '商品副标题', 10.00, 10.00, '详细页标题', '正文信息', '关键词', '备注', '2021-05-10 20:46:33', '2021-05-11 22:55:01');

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
INSERT INTO `goods_pics` VALUES (1, 1, 'www.baidu.com', 0);
INSERT INTO `goods_pics` VALUES (2, 1, 'www.baidu.com1', 0);
INSERT INTO `goods_pics` VALUES (1391736428357369857, 1391736401354440705, 'www.baidu.com', 1);
INSERT INTO `goods_pics` VALUES (1392125568139886594, 1391736401354440705, 'www.baidu.com', 1);
INSERT INTO `goods_pics` VALUES (1392125716765048834, 1391736401354440705, 'www.baidu.com', 1);
INSERT INTO `goods_pics` VALUES (1392131131108118530, 1391736401354440705, 'www.baidu.com', 0);

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
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0 否，1 是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品SKU表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_sku
-- ----------------------------
INSERT INTO `goods_sku` VALUES (1, 1, 1111, 100.00, 110.00, 100, 10, 'www.baidu.com', 10, '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"容量\",\"value\":\"32G\"}]', 0, '2021-05-08 09:26:49', '2021-05-08 09:26:54');
INSERT INTO `goods_sku` VALUES (2, 1, 22222, 100.00, 110.00, 10, 10, 'www.baidu.com11', 10, '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"容量\",\"value\":\"32G\"}]', 0, '2021-05-08 09:26:52', '2021-05-08 09:26:56');
INSERT INTO `goods_sku` VALUES (1391736442789969921, 1391736401354440705, 1111, 0.15, 15.00, 10, 10, 'www.baidu.com', 1, '{}', 0, '2021-05-10 20:46:40', '2021-05-11 22:55:01');
INSERT INTO `goods_sku` VALUES (1392125568206995458, 1391736401354440705, 1111, 0.15, 15.00, 10, 10, 'www.baidu.com', 1, '{}', 0, '2021-05-11 22:32:55', '2021-05-11 22:32:55');
INSERT INTO `goods_sku` VALUES (1392125716765048835, 1391736401354440705, 1111, 0.15, 15.00, 10, 10, 'www.baidu.com', 1, '{}', 0, '2021-05-11 22:33:30', '2021-05-11 22:55:01');

-- ----------------------------
-- Table structure for goods_spec
-- ----------------------------
DROP TABLE IF EXISTS `goods_spec`;
CREATE TABLE `goods_spec`  (
  `id` bigint(20) NOT NULL COMMENT '商品-规格-id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品规格名称',
  `goods_attr_cate_id` bigint(20) NOT NULL COMMENT '商品-属性分类 id',
  `value_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '可选值列表',
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
INSERT INTO `goods_spec` VALUES (3, '颜色', 3, '', 100, 0, '2021-04-29 14:36:54', '2021-04-29 14:36:58');
INSERT INTO `goods_spec` VALUES (1387658852206776321, '尺码', 3, 'S,M,L,XL,XXL,XXXL,XXXXL', 1, 0, '2021-04-29 14:43:46', '2021-04-29 14:50:07');
INSERT INTO `goods_spec` VALUES (1395319659543592962, '内存', 2, '8GB,16GB,32GB,64GB', 100, 0, '2021-05-20 18:05:05', '2021-05-20 18:05:05');
INSERT INTO `goods_spec` VALUES (1395320051979452417, '硬盘', 2, '256G,512G,1T,512G固态+1T机械,1T机械,512G机械', 99, 0, '2021-05-20 18:06:39', '2021-05-20 18:06:48');

SET FOREIGN_KEY_CHECKS = 1;
