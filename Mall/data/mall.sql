/*
 Navicat Premium Data Transfer

 Source Server         : 本地主机
 Source Server Type    : MySQL
 Source Server Version : 50651
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50651
 File Encoding         : 65001

 Date: 08/04/2021 23:10:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `goods_price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `goods_status` int(1) NOT NULL COMMENT '商品状态',
  `store_cate_id` int(11) NOT NULL COMMENT '商品分类id',
  `goods_count` int(11) NOT NULL COMMENT '商品个数',
  `is_del` int(1) NOT NULL COMMENT '是否删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '早秋新款韩版V领蕾丝白色长袖衬衫上衣女装chic连帽卫衣女秋季新款原宿慵懒风学生时尚宽松显瘦字母薄绒长袖外套ins超火上衣松套头衬衣', 69.00, 1, 23, 100, 0, '2021-03-30 21:57:27');
INSERT INTO `goods` VALUES (2, '新款韩版V领蕾丝白色长袖衬衫上衣女装chic宽松套头衬衣', 59.00, 1, 26, 100, 0, '2021-03-30 21:57:41');
INSERT INTO `goods` VALUES (3, '卫衣女秋季新款漏肚脐短款卫衣女连帽韩范长袖小清新学生宽松ins超火上衣女', 59.50, 1, 23, 100, 0, '2021-03-30 22:00:07');
INSERT INTO `goods` VALUES (4, '毛呢半身裙女2018早秋冬季防走光韩版高腰呢子蓬蓬裙a字百褶短裙', 59.00, 1, 28, 100, 0, '2021-03-30 22:07:03');
INSERT INTO `goods` VALUES (5, '秋冬韩版复古高腰格子半身裙小清新毛呢显瘦A字短裙百搭新款裙子', 49.00, 1, 28, 100, 0, '2021-03-30 22:09:22');
INSERT INTO `goods` VALUES (6, '秋冬松紧腰防走光安全裤加厚毛呢半身裙学院风短裙百褶裙裤裙女装', 39.20, 1, 28, 100, 0, '2021-03-30 22:11:53');
INSERT INTO `goods` VALUES (7, '中长款连衣裙秋季长袖新款气质a字裙千鸟格收腰裙子', 98.00, 1, 27, 100, 0, '2021-03-30 22:17:18');
INSERT INTO `goods` VALUES (8, '早秋2018新款韩版V领蕾丝白色长袖衬衫上衣女装chic宽松套头衬衣', 59.00, 1, 26, 100, 0, '2021-04-01 15:54:20');

-- ----------------------------
-- Table structure for goods_cate
-- ----------------------------
DROP TABLE IF EXISTS `goods_cate`;
CREATE TABLE `goods_cate`  (
  `cate_id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `is_del` int(1) NOT NULL,
  `cate_pid` int(11) NOT NULL,
  PRIMARY KEY (`cate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_cate
-- ----------------------------
INSERT INTO `goods_cate` VALUES (1, '数码产品', 0, 0);
INSERT INTO `goods_cate` VALUES (2, '生活用品', 0, 0);
INSERT INTO `goods_cate` VALUES (3, '家具产品', 0, 0);
INSERT INTO `goods_cate` VALUES (4, '男装', 0, 0);
INSERT INTO `goods_cate` VALUES (5, '女装', 0, 0);
INSERT INTO `goods_cate` VALUES (6, '手机', 0, 1);
INSERT INTO `goods_cate` VALUES (7, '电脑', 0, 1);
INSERT INTO `goods_cate` VALUES (8, '键盘/鼠标', 0, 1);
INSERT INTO `goods_cate` VALUES (9, '华为手机', 0, 6);
INSERT INTO `goods_cate` VALUES (10, '苹果手机', 0, 6);
INSERT INTO `goods_cate` VALUES (11, 'OPPO', 0, 6);
INSERT INTO `goods_cate` VALUES (12, 'Mete 40', 0, 9);
INSERT INTO `goods_cate` VALUES (13, 'Mete 40 Pro', 0, 9);
INSERT INTO `goods_cate` VALUES (14, 'IPhone 11', 0, 10);
INSERT INTO `goods_cate` VALUES (15, 'IPhone 12', 0, 10);
INSERT INTO `goods_cate` VALUES (16, 'Find X3', 0, 11);
INSERT INTO `goods_cate` VALUES (17, '上衣', 0, 4);
INSERT INTO `goods_cate` VALUES (18, '衬衫', 0, 17);
INSERT INTO `goods_cate` VALUES (19, '短袖', 0, 17);
INSERT INTO `goods_cate` VALUES (20, '上衣', 0, 5);
INSERT INTO `goods_cate` VALUES (21, '裤子', 0, 5);
INSERT INTO `goods_cate` VALUES (22, '裙子', 0, 5);
INSERT INTO `goods_cate` VALUES (23, '卫衣', 0, 20);
INSERT INTO `goods_cate` VALUES (24, '短袖', 0, 20);
INSERT INTO `goods_cate` VALUES (25, 'T恤', 0, 20);
INSERT INTO `goods_cate` VALUES (26, '衬衫', 0, 20);
INSERT INTO `goods_cate` VALUES (27, '长裙', 0, 22);
INSERT INTO `goods_cate` VALUES (28, '短裙', 0, 22);
INSERT INTO `goods_cate` VALUES (29, '百褶裙', 0, 22);

-- ----------------------------
-- Table structure for goods_desc
-- ----------------------------
DROP TABLE IF EXISTS `goods_desc`;
CREATE TABLE `goods_desc`  (
  `desc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '详情id',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详情信息',
  PRIMARY KEY (`desc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品详情' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_desc
-- ----------------------------
INSERT INTO `goods_desc` VALUES (1, 1, '<div data-v-1bfd5400=\"\" data-v-117d0e76=\"\" class=\"goods-info\" id=\"detail-goods-info\"><div data-v-1bfd5400=\"\" class=\"info-desc clear-fix\"><div data-v-1bfd5400=\"\" class=\"start\"></div><div data-v-1bfd5400=\"\" class=\"desc\">【拍下自动赠送运费保险，7天无理由退换，品质保障.】</div><div data-v-1bfd5400=\"\" class=\"end\"></div></div><div data-v-1bfd5400=\"\" class=\"info-key\">穿着效果</div><div data-v-1bfd5400=\"\" class=\"info-list\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180920_2a82k934efh3f17b24ad1i8i7d47j_960x1350.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_0903akhihi9a85gaag660f52ikf0l_960x1051.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_3kdhhbcff70bl4dffa9ac45922e29_960x1635.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_8e0ifabi32i852ecf7kbedah63edk_960x1051.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_73087ghe5j6g22hg5e955kk9fd06d_960x1434.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_5dlgli5c9gg3fgi5g76517ki41g3j_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_2cj23hga0j63ah4f95h0c9gk7hal3_960x1105.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_19fj7gbd5iec7ij1i95343ajbd70c_960x1458.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180923_2bhggdg1l1djeic5b1lcc9f7ejccd_750x433.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180923_1k38lcj998i215j31gi1fa26ic896_750x1397.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180923_59925h38g21a4jh7i13f6fkgfe728_750x903.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180923_5f1f1j3i13ci732gablf1gfi0ha26_750x1186.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180923_1bjk4dihg9120jle5a93bghd9lc57_750x832.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180923_7f75e250bb59ha693i12ifihdl074_750x777.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180920_788428h0h50h3i6gb21ggbgbf6bjj_960x1190.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_2lf423ckjae49b6kkl6fdi4jce21j_960x1458.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_3lh04j7d622hig6a7cgle6c4akbc3_960x1462.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180920_3bf1fa47hj0khlga3ie2k0k5a1f56_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_6g5b4f1ijhkjc19acc5ajij68jj81_960x1370.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180920_0dcgh053bjbb556a368f328f27308_960x1434.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180920_4607fe707f2286jl57a5h64a7kle7_960x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_4j31517832bbd56l04hdk9ka2h8j0_960x1330.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_123be8ee042g45f6bj435iil1ibb0_960x983.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_1kf7410b6fj95bca5bd8ie062abdl_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180920_3laeigdb9f1j0g0ijhehk9ae4bfcj_960x1396.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_73037hcj5g0l370klgcd3k78g9g6k_960x908.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_1k7a0jcb39l39399e20cg0lklefl6_960x902.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_4jef84kg204l9ac3255e67kel27k3_960x1124.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_82f3bfe97kb608ea73dll791l6f62_960x1509.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_4hlc398i4e0i14bcj749f4liejkb1_960x1065.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_22bc6e44j660gb7ifbi8ifil5h4e4_960x1414.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_8h25id9679c51fcd11j6ek5egfb99_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_1if99506956kc2j29e8d24i79hdjg_960x1370.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180920_77g982k5jfabj411354cgfe6h3j28_960x1198.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_2jkk7g6hcb4d9l43akil2gbd31gbh_960x908.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_4fc4dbhlhi1ajkb3de4fa5d09f8l7_960x1233.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_7f1i8e2j7jhfghe87h10fllf7l9kd_960x1006.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_0431eef4j1ihj9j2ca9f0khg3icde_960x1009.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180920_5ffala99d5bcd707i4h312jcc4198_960x1198.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180920_07jle0420lba5jd2e45l17a8b5l8c_960x837.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/p2/170317/77101615_86e9f0elcl86499l16jf26aallg14_1125x380.jpg\" alt=\"\"></div></div>');
INSERT INTO `goods_desc` VALUES (2, 2, '<div data-v-1bfd5400=\"\" data-v-117d0e76=\"\" class=\"goods-info\" id=\"detail-goods-info\"><div data-v-1bfd5400=\"\" class=\"info-desc clear-fix\"><div data-v-1bfd5400=\"\" class=\"start\"></div><div data-v-1bfd5400=\"\" class=\"desc\">早秋2018新款韩版V领蕾丝白色长袖衬衫上衣女装chic宽松套头衬衣</div><div data-v-1bfd5400=\"\" class=\"end\"></div></div><div data-v-1bfd5400=\"\" class=\"info-key\">穿着效果</div><div data-v-1bfd5400=\"\" class=\"info-list\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_87d5eg4aaf41247kgel0i79i29dkf_750x813.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180824_76ieka4d26iad369la379a53a7g72_750x452.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_263il7gdb9g9beed3k9gi91j8b8d5_750x367.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_6332db1fa1l67c0ci2ahdll1fjcj5_750x786.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_2b6c420cebbj7g8dfha2ada0k44bk_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_6d23ehge617c342eb43g81c0gb1l9_750x879.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_5k9i8d8bb0kg09i8blj9eifh73a71_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_4jc7ihk055fcl0lbfhi35102edgjl_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_8c7j2a13ccbj97f5k751jjfgg7kf8_750x819.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_7789044k8456d9f1f7i3fh0947a7i_750x717.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_009f5l88k4bfkbbfb13cd8akaj839_750x815.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180824_3lchd3gj1bd85fae82d1660217d57_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_3g2eb6j20jek55g16edaaeik48jek_750x836.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_2e9f6db34d86ah5l0cd26916fblk9_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180824_2hi0bada2j7k4e072ia33kfh333fb_750x879.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180824_70c8414b7gj5aalg6j28dj4b28k7l_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_7l8886ji17b6a0b1d13ig0jj31eg9_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180824_17dbig337858l4b9i86ki4li996lf_750x819.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180824_76d306hh5ef6e6khlfk7ef45kbj5a_750x717.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_596cb1kl0l4hi6flg46jc66650369_750x815.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_573c8gj5gdg815jkl69aclj7f62h5_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_1a4k1f5ec7j0k4klhed00ik7e49i0_1157x1156.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/p2/170317/77101615_86e9f0elcl86499l16jf26aallg14_1125x380.jpg\" alt=\"\"></div></div>');
INSERT INTO `goods_desc` VALUES (3, 3, '<div data-v-1bfd5400=\"\" data-v-117d0e76=\"\" class=\"goods-info\" id=\"detail-goods-info\"><div data-v-1bfd5400=\"\" class=\"info-desc clear-fix\"><div data-v-1bfd5400=\"\" class=\"start\"></div><div data-v-1bfd5400=\"\" class=\"desc\">宽松显瘦，百搭时尚</div><div data-v-1bfd5400=\"\" class=\"end\"></div></div><div data-v-1bfd5400=\"\" class=\"info-key\">穿着效果</div><div data-v-1bfd5400=\"\" class=\"info-list\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180829_6ef4g942dheca3kj55235h3chk34c_750x912.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180829_5bbd2203al9f33223d7d724fib14d_750x934.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_341h1563ghcgkaddbk0hdck3911e5_750x898.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_32fcljj294k4c3ae94dfga7hh03ch_750x811.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_0k6d385je1cdf67gh7563946139dk_750x766.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_1ag21e3edlejf0c2b46i1l2iebg45_750x883.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180829_8f2i8jd14ddi907gl8ecib3ekj65g_750x823.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_0081je1f688e6b14fhbck6085jg39_750x778.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_58ebh7jhlhbh6920439k34ca10545_750x778.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_02lid611ig6ifikd0i2aeg3f90963_750x907.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180829_2k5l59k7h515207f5dad8i6fg8j63_750x838.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_611lcl6f9l1ca456leijljigea678_750x808.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_4abe10klai2dae4e92dbfk5kdl81l_750x900.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_6gg07lid5b34c0claac0901kl0gh3_750x775.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_6hi5gagk4i1855kg60c45d402cgjd_750x895.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180829_202dg85hiakab6c0a5gdh579hce8d_750x841.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180829_37dh1l1f554cglla93151cea7hj5h_750x793.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180829_7lgbbha5jge80bg565c1idela73bl_750x772.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_07cji0edjgli38686ijce19g94hd5_750x781.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180829_0d8685ijg1afle9ld1fh8kh12b392_750x831.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_242ki58041dldkeckj6iecb9438ii_750x925.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_81d6l1bff8a3l20gh6l8bkld4a2ce_750x901.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_2e6ddgdf2j04g886043lc9alh4lg2_750x802.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180829_21lk3gh50l146h8c8l32f2139781c_750x760.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_4jg84ilj2195f4f2lh76a0fd80ed5_750x894.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_346hjh4bgccj65d01b03f18ahij0h_750x892.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_747258aibj0dek43jgb5jfa04fiab_750x832.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_83ibk10fi74b0h1h582bh0l2g583a_750x886.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180829_6d6kgk4kcg656512h6c919efi450k_750x772.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/p2/170317/77101615_86e9f0elcl86499l16jf26aallg14_1125x380.jpg\" alt=\"\"></div></div>');
INSERT INTO `goods_desc` VALUES (4, 4, '<div data-v-1bfd5400=\"\" data-v-117d0e76=\"\" class=\"goods-info\" id=\"detail-goods-info\"><div data-v-1bfd5400=\"\" class=\"info-desc clear-fix\"><div data-v-1bfd5400=\"\" class=\"start\"></div><div data-v-1bfd5400=\"\" class=\"desc\">毛呢半身裙女2018早秋冬季防走光韩版高腰呢子蓬蓬裙a字百褶短裙</div><div data-v-1bfd5400=\"\" class=\"end\"></div></div><div data-v-1bfd5400=\"\" class=\"info-key\">穿着效果</div><div data-v-1bfd5400=\"\" class=\"info-list\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_7hlk4a7fd53gj0d4448fc91k78bec_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_69g4ila20k44chh8d099g5907839j_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180730_8g907i1bk5c2a80j22bihh3jhcbac_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180730_194f54k3f4ha468208h28306263hb_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_349b5a076925d072a2530hjk52dj3_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_6gj7g189850jhe5k8cf3e64i7g668_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_3149al1e8l716bgh8i9ichh5kgk83_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_1579a58c31i8dbc0c47f65ak84eia_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180730_3j9eci7ei533icf2326b5827l7bhg_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180730_6gkidggb5cdb6j03ib0d3ehl0e334_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_3ljj4699cd71be0l5e669i01ggfji_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_3dfck046acdk46bl06a44ll7a9017_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_1eb0a9cafi8a8cj4hkh4ee95d82ia_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_7646f5ae0bjejfh6gc0b115h42d42_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/p2/170317/77101615_86e9f0elcl86499l16jf26aallg14_1125x380.jpg\" alt=\"\"></div></div>');
INSERT INTO `goods_desc` VALUES (5, 5, '<div data-v-1bfd5400=\"\" data-v-117d0e76=\"\" class=\"goods-info\" id=\"detail-goods-info\"><div data-v-1bfd5400=\"\" class=\"info-desc clear-fix\"><div data-v-1bfd5400=\"\" class=\"start\"></div><div data-v-1bfd5400=\"\" class=\"desc\">毛呢半身裙女2018早秋冬季防走光韩版高腰呢子蓬蓬裙a字百褶短裙</div><div data-v-1bfd5400=\"\" class=\"end\"></div></div><div data-v-1bfd5400=\"\" class=\"info-key\">穿着效果</div><div data-v-1bfd5400=\"\" class=\"info-list\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_7hlk4a7fd53gj0d4448fc91k78bec_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_69g4ila20k44chh8d099g5907839j_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180730_8g907i1bk5c2a80j22bihh3jhcbac_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180730_194f54k3f4ha468208h28306263hb_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_349b5a076925d072a2530hjk52dj3_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_6gj7g189850jhe5k8cf3e64i7g668_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_3149al1e8l716bgh8i9ichh5kgk83_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_1579a58c31i8dbc0c47f65ak84eia_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180730_3j9eci7ei533icf2326b5827l7bhg_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180730_6gkidggb5cdb6j03ib0d3ehl0e334_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_3ljj4699cd71be0l5e669i01ggfji_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_3dfck046acdk46bl06a44ll7a9017_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_1eb0a9cafi8a8cj4hkh4ee95d82ia_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180730_7646f5ae0bjejfh6gc0b115h42d42_750x750.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/p2/170317/77101615_86e9f0elcl86499l16jf26aallg14_1125x380.jpg\" alt=\"\"></div></div>');
INSERT INTO `goods_desc` VALUES (6, 6, '<div data-v-1bfd5400=\"\" data-v-117d0e76=\"\" class=\"goods-info\" id=\"detail-goods-info\"><div data-v-1bfd5400=\"\" class=\"info-desc clear-fix\"><div data-v-1bfd5400=\"\" class=\"start\"></div><div data-v-1bfd5400=\"\" class=\"desc\">很学院风的 一款百褶裙，松紧腰设计。毛呢料子哦，秋冬季节搭配毛衣或者外套特别减齡少女范！</div><div data-v-1bfd5400=\"\" class=\"end\"></div></div><div data-v-1bfd5400=\"\" class=\"info-key\">穿着效果</div><div data-v-1bfd5400=\"\" class=\"info-list\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_3b85708ld8dg17j0eaj4b312cgl60_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_54657f7jj0c767ilbei428i66gd4i_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_28ihkkif52i14c47ka61dg9l2k7be_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_4e188fddl6e0j05bf75jkdifghii9_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/171203_4dd78gb4h7430ebh9f1af4ih2d8bg_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_7jb7db395jb48ah2jkbaeg59j6be7_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_40a53fjca0d9h925427ehed3kldkl_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_10eb5l1l5l943gf0d6ehj8gka6gk2_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_420ka0e121aje2bk2kla950d13c2j_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/171203_0g0idhhi601kja382c4ee142dk5hl_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_8fd0f2gk5g475i2f5fbi235365fei_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/171203_27299c08keeg138jjdk7hbh014345_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_3higac3bd1431baci9a2g0cf033b9_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/171203_2a63i6ck3kjfa1i50dg3gg5add40a_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/171203_84bjdi21037aakfeb82j5d5c7c4k3_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/171203_7ci56e34h17g4hhc7e4bilkdfback_640x960.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/p2/170317/77101615_86e9f0elcl86499l16jf26aallg14_1125x380.jpg\" alt=\"\"></div></div>');
INSERT INTO `goods_desc` VALUES (7, 7, '<div data-v-1bfd5400=\"\" data-v-117d0e76=\"\" class=\"goods-info\" id=\"detail-goods-info\"><div data-v-1bfd5400=\"\" class=\"info-desc clear-fix\"><div data-v-1bfd5400=\"\" class=\"start\"></div><div data-v-1bfd5400=\"\" class=\"desc\">中长款连衣裙秋季长袖2018新款气质a字裙千鸟格收腰裙子</div><div data-v-1bfd5400=\"\" class=\"end\"></div></div><div data-v-1bfd5400=\"\" class=\"info-key\">穿着效果</div><div data-v-1bfd5400=\"\" class=\"info-list\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180916_6j65c728396gkklb7ed3gba1lhlae_790x893.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_2dj3fa5dhalgb71k49812ih16l167_790x776.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180916_2ablgji0b26j295l1511fege9aai5_790x528.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180916_23320i9hcg6852b3db3g05g8j3f16_790x1030.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_786cclee4bke9k9g7k73gfkb53ik2_790x738.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_8c2hj9a95442423hh8lflf8d6b78l_790x701.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_1c52a67ga9ddj3f3i0g9c035hba02_790x890.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_62cib7jedea3e8b43c09kh86b3jha_790x1235.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_8ddl9l89he5490j247a0i6a0beae9_790x904.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180916_32ecjj250gj40265ifdaek9i7g2l9_790x980.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_39jbc85i3bd1f93glgb30jgh18k0i_790x955.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_147cg9gh13d6cd0g0j6ggl9gb7kk0_790x953.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180916_2k17k86i8cke7i9gha9jb3i2h0h28_790x868.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180916_10h7a113elefhc1i560ki0bcehj3i_790x452.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_1i87ka1jggkgl2b21afha8kijckb7_790x885.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_5h2i6lb7gc8j9f93kagg5ad5g2dl8_790x995.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180916_5fj96l4eg604fb2ah5e6bh132fggd_790x984.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/p2/170317/77101615_86e9f0elcl86499l16jf26aallg14_1125x380.jpg\" alt=\"\"></div></div>');
INSERT INTO `goods_desc` VALUES (8, 8, '<div data-v-1bfd5400=\"\" data-v-117d0e76=\"\" class=\"goods-info\" id=\"detail-goods-info\"><div data-v-1bfd5400=\"\" class=\"info-desc clear-fix\"><div data-v-1bfd5400=\"\" class=\"start\"></div><div data-v-1bfd5400=\"\" class=\"desc\">早秋2018新款韩版V领蕾丝白色长袖衬衫上衣女装chic宽松套头衬衣</div><div data-v-1bfd5400=\"\" class=\"end\"></div></div><div data-v-1bfd5400=\"\" class=\"info-key\">穿着效果</div><div data-v-1bfd5400=\"\" class=\"info-list\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_87d5eg4aaf41247kgel0i79i29dkf_750x813.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180824_76ieka4d26iad369la379a53a7g72_750x452.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_263il7gdb9g9beed3k9gi91j8b8d5_750x367.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_6332db1fa1l67c0ci2ahdll1fjcj5_750x786.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_2b6c420cebbj7g8dfha2ada0k44bk_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_6d23ehge617c342eb43g81c0gb1l9_750x879.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_5k9i8d8bb0kg09i8blj9eifh73a71_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_4jc7ihk055fcl0lbfhi35102edgjl_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_8c7j2a13ccbj97f5k751jjfgg7kf8_750x819.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_7789044k8456d9f1f7i3fh0947a7i_750x717.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_009f5l88k4bfkbbfb13cd8akaj839_750x815.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180824_3lchd3gj1bd85fae82d1660217d57_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_3g2eb6j20jek55g16edaaeik48jek_750x836.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_2e9f6db34d86ah5l0cd26916fblk9_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180824_2hi0bada2j7k4e072ia33kfh333fb_750x879.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s3.mogucdn.com/mlcdn/c45406/180824_70c8414b7gj5aalg6j28dj4b28k7l_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_7l8886ji17b6a0b1d13ig0jj31eg9_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180824_17dbig337858l4b9i86ki4li996lf_750x819.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s5.mogucdn.com/mlcdn/c45406/180824_76d306hh5ef6e6khlfk7ef45kbj5a_750x717.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_596cb1kl0l4hi6flg46jc66650369_750x815.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_573c8gj5gdg815jkl69aclj7f62h5_750x817.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/mlcdn/c45406/180824_1a4k1f5ec7j0k4klhed00ik7e49i0_1157x1156.jpg\" alt=\"\"><img data-v-1bfd5400=\"\" src=\"//s11.mogucdn.com/p2/170317/77101615_86e9f0elcl86499l16jf26aallg14_1125x380.jpg\" alt=\"\"></div></div>');

-- ----------------------------
-- Table structure for goods_main_pics
-- ----------------------------
DROP TABLE IF EXISTS `goods_main_pics`;
CREATE TABLE `goods_main_pics`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主图id',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品大图' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_main_pics
-- ----------------------------
INSERT INTO `goods_main_pics` VALUES (1, 1, '//s5.mogucdn.com/mlcdn/c45406/180923_54kbejlb75770eieadjei9b9i14ja_640x960.jpg,//s11.mogucdn.com/mlcdn/c45406/180923_4lf8i062leak962c6l829dj78e9d2_640x960.jpg,//s5.mogucdn.com/mlcdn/c45406/180923_54kbejlb75770eieadjei9b9i14ja_640x960.jpg,//s5.mogucdn.com/mlcdn/c45406/180923_2e47d6efa0hi90bl8h3afb00kel3f_640x960.jpg,//s11.mogucdn.com/mlcdn/c45406/180923_7eib81ji4hh2kl43afg68bicd29h6_640x960.jpg,//s3.mogucdn.com/mlcdn/c45406/180923_0fj05ai9cl2a12k47gjlde87k3b2e_640x960.jpg');
INSERT INTO `goods_main_pics` VALUES (2, 2, '//s3.mogucdn.com/mlcdn/c45406/180824_460d7i6a17ei8287cdhae2igikj55_640x960.jpg');
INSERT INTO `goods_main_pics` VALUES (3, 3, '//s5.mogucdn.com/mlcdn/c45406/180829_73bg4d77bbdg0e8250eg9478fgbce_640x960.jpg');
INSERT INTO `goods_main_pics` VALUES (4, 4, '//s11.mogucdn.com/mlcdn/c45406/180730_6jbflgbh356bg2bc0ac216l63jcec_750x1200.jpg,//s5.mogucdn.com/mlcdn/c45406/180730_7kdbfeii3l2kifalck6jbgb5hlg77_800x1200.jpg,//s3.mogucdn.com/mlcdn/c45406/180730_2f744ia80ikflc3h1k8j73eb0b350_750x1200.jpg,//s11.mogucdn.com/mlcdn/c45406/180730_6jbflgbh356bg2bc0ac216l63jcec_750x1200.jpg');
INSERT INTO `goods_main_pics` VALUES (5, 5, '//s3.mogucdn.com/mlcdn/c45406/171011_1la396932ccc3f35kakk3leed7c5g_640x960.jpg');
INSERT INTO `goods_main_pics` VALUES (6, 6, '//s5.mogucdn.com/mlcdn/c45406/171203_8dbk164ek6k48j8b03l074bdellaa_640x960.jpg,//s11.mogucdn.com/mlcdn/c45406/171203_0ga0lb6lf2heldkdd9b0ghl3c4hge_640x960.jpg,//s11.mogucdn.com/mlcdn/c45406/171203_24g217g35h56je918bc13l610f324_640x960.jpg,//s11.mogucdn.com/mlcdn/c45406/171203_5ka85e3aich0if2j05246728gk2e8_640x960.jpg');
INSERT INTO `goods_main_pics` VALUES (7, 7, '//s5.mogucdn.com/mlcdn/c45406/180916_5hfeb3c7l2ef38g98kk9f6ji3flab_640x960.jpg,//s11.mogucdn.com/mlcdn/c45406/180916_8fbfkdc742dg15k6e077cia13kfii_640x960.jpg,//s11.mogucdn.com/mlcdn/c45406/180916_21hjcbeeeaf6h89icfflb6hkb01jk_640x960.jpg,//s5.mogucdn.com/mlcdn/c45406/180916_5hfeb3c7l2ef38g98kk9f6ji3flab_640x960.jpg');
INSERT INTO `goods_main_pics` VALUES (8, 8, '//s3.mogucdn.com/mlcdn/c45406/180824_460d7i6a17ei8287cdhae2igikj55_640x960.jpg');

-- ----------------------------
-- Table structure for goods_sub_pics
-- ----------------------------
DROP TABLE IF EXISTS `goods_sub_pics`;
CREATE TABLE `goods_sub_pics`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '小图id',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品图片url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品小图' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_sub_pics
-- ----------------------------
INSERT INTO `goods_sub_pics` VALUES (1, 1, '//s3.mogucdn.com/mlcdn/c45406/180920_788428h0h50h3i6gb21ggbgbf6bjj_960x1190.jpg,//s5.mogucdn.com/mlcdn/c45406/180920_3lh04j7d622hig6a7cgle6c4akbc3_960x1462.jpg,//s5.mogucdn.com/mlcdn/c45406/180920_4j31517832bbd56l04hdk9ka2h8j0_960x1330.jpg,//s5.mogucdn.com/mlcdn/c45406/180920_0431eef4j1ihj9j2ca9f0khg3icde_960x1009.jpg');
INSERT INTO `goods_sub_pics` VALUES (2, 2, '//s11.mogucdn.com/mlcdn/c45406/180824_2b6c420cebbj7g8dfha2ada0k44bk_750x817.jpg,//s11.mogucdn.com/mlcdn/c45406/180824_5k9i8d8bb0kg09i8blj9eifh73a71_750x817.jpg,//s11.mogucdn.com/mlcdn/c45406/180824_009f5l88k4bfkbbfb13cd8akaj839_750x815.jpg');
INSERT INTO `goods_sub_pics` VALUES (3, 3, '//s11.mogucdn.com/mlcdn/c45406/180829_611lcl6f9l1ca456leijljigea678_750x808.jpg,//s11.mogucdn.com/mlcdn/c45406/180829_747258aibj0dek43jgb5jfa04fiab_750x832.jpg,//s11.mogucdn.com/mlcdn/c45406/180829_6d6kgk4kcg656512h6c919efi450k_750x772.jpg,//s11.mogucdn.com/mlcdn/c45406/180829_58ebh7jhlhbh6920439k34ca10545_750x778.jpg');
INSERT INTO `goods_sub_pics` VALUES (4, 4, '//s11.mogucdn.com/mlcdn/c45406/180730_69g4ila20k44chh8d099g5907839j_750x750.jpg,//s3.mogucdn.com/mlcdn/c45406/180730_194f54k3f4ha468208h28306263hb_750x750.jpg,//s11.mogucdn.com/mlcdn/c45406/180730_1579a58c31i8dbc0c47f65ak84eia_750x750.jpg,//s11.mogucdn.com/mlcdn/c45406/180730_3dfck046acdk46bl06a44ll7a9017_750x750.jpg');
INSERT INTO `goods_sub_pics` VALUES (5, 5, '//s3.mogucdn.com/mlcdn/c45406/171014_571filfk8358ac989kcf4b47cbkh3_700x933.jpg,//s5.mogucdn.com/mlcdn/c45406/171014_6l87jbj85ell97c02328b9kk97l56_700x950.jpg,//s11.mogucdn.com/mlcdn/c45406/171014_5k6g7c61e64a974791g67295j41ch_700x931.jpg,//s11.mogucdn.com/mlcdn/c45406/171014_0f21ajj7g1h487chbjad5kc9daei3_700x984.jpg,//s11.mogucdn.com/mlcdn/c45406/171014_892j5029634f6h7f0i61k2d2j4764_700x912.jpg,//s3.mogucdn.com/mlcdn/c45406/171014_01fi89d8fl59i2j20bi12kj92cklc_700x701.jpg,//s11.mogucdn.com/mlcdn/c45406/171014_8e71c43b9g8a3318b0ih67j5k1caf_700x958.jpg');
INSERT INTO `goods_sub_pics` VALUES (6, 6, '//s11.mogucdn.com/mlcdn/c45406/171203_10eb5l1l5l943gf0d6ehj8gka6gk2_640x960.jpg,//s5.mogucdn.com/mlcdn/c45406/171203_0g0idhhi601kja382c4ee142dk5hl_640x960.jpg,//s11.mogucdn.com/mlcdn/c45406/171203_3higac3bd1431baci9a2g0cf033b9_640x960.jpg,//s3.mogucdn.com/mlcdn/c45406/171203_84bjdi21037aakfeb82j5d5c7c4k3_640x960.jpg,//s11.mogucdn.com/mlcdn/c45406/171203_7ci56e34h17g4hhc7e4bilkdfback_640x960.jpg');
INSERT INTO `goods_sub_pics` VALUES (7, 7, '//s11.mogucdn.com/mlcdn/c45406/180916_786cclee4bke9k9g7k73gfkb53ik2_790x738.jpg,//s11.mogucdn.com/mlcdn/c45406/180916_39jbc85i3bd1f93glgb30jgh18k0i_790x955.jpg,//s5.mogucdn.com/mlcdn/c45406/180916_10h7a113elefhc1i560ki0bcehj3i_790x452.jpg');
INSERT INTO `goods_sub_pics` VALUES (8, 8, '//s11.mogucdn.com/mlcdn/c45406/180824_2b6c420cebbj7g8dfha2ada0k44bk_750x817.jpg,//s11.mogucdn.com/mlcdn/c45406/180824_5k9i8d8bb0kg09i8blj9eifh73a71_750x817.jpg,//s11.mogucdn.com/mlcdn/c45406/180824_009f5l88k4bfkbbfb13cd8akaj839_750x815.jpg');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `order_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `consignee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人姓名',
  `user_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户手机号码',
  `user_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户收货地址',
  `total_price` decimal(10, 2) NOT NULL COMMENT '订单总价格',
  `status` int(2) NOT NULL DEFAULT 1 COMMENT '订单状态：0 已取消，1 待支付，2 待发货， 3 已收货，4 售后中，5 已完成',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `create_time` datetime(0) NOT NULL COMMENT '订单创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, '8f5df92a96ac11eba5a80a80ff2603de', 1, '张三', '13977777777', '广西壮族自治区南宁市兴宁区朝阳广场', 100.00, 1, NULL, '2021-04-06 15:50:42');

-- ----------------------------
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `order_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号',
  `goods_cate_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '分类名称',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品id',
  `goods_count` int(11) NOT NULL COMMENT '商品个数',
  `goods_price` decimal(10, 2) NOT NULL COMMENT '商品单价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单商品' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_goods
-- ----------------------------
INSERT INTO `order_goods` VALUES (1, 1, '8f5df92a96ac11eba5a80a80ff2603de', '裙子', '早秋新款韩版V领蕾丝白色长袖衬衫上衣女装chic宽松套头衬衣', 2, 100.00);
INSERT INTO `order_goods` VALUES (2, 2, '8f5df92a96ac11eba5a80a80ff2603de', '裙子', '111', 1, 55.00);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像url地址',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `balance` decimal(20, 2) NOT NULL COMMENT '余额',
  `status` int(1) NOT NULL COMMENT '用户状态, 0禁用，1正常',
  `regist_time` datetime(0) NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', 'afdd0b4ad2ec172c586e2150770fbf9e', 'http://cdn.byxll.cn/avatar.jpg', '13911111111', 0.00, 1, '2021-03-24 22:59:23');
INSERT INTO `user` VALUES (2, 'wangwu', 'afdd0b4ad2ec172c586e2150770fbf9e', 'http://cdn.byxll.cn/avatar-editor.jpg', '13933333333', 0.00, 1, '2021-03-24 23:10:21');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '详细地址',
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '市',
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '区/县',
  `consignee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '收货人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `zip_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮政编码',
  `is_default` int(1) NOT NULL COMMENT '是否默认地址',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户地址表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_address
-- ----------------------------

-- ----------------------------
-- Table structure for user_cart
-- ----------------------------
DROP TABLE IF EXISTS `user_cart`;
CREATE TABLE `user_cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `goods_count` int(11) NOT NULL COMMENT '商品个数',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_cart
-- ----------------------------
INSERT INTO `user_cart` VALUES (1, 1, 5, 1);
INSERT INTO `user_cart` VALUES (3, 3, 10, 1);

SET FOREIGN_KEY_CHECKS = 1;
