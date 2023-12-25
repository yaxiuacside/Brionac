
CREATE DATABASE IF NOT EXISTS `brionac` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `brionac`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics`  (
      `logistic_id` int(6) NOT NULL AUTO_INCREMENT COMMENT '物流id',
      `logistic_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL comment '物流编号',
      `order_id` int(5) NULL DEFAULT NULL COMMENT '订单id',
      `order_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
      `sender` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发货人',
      `sender_tel` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发货人联系方式',
      `sender_add` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发货人联系地址',
      `receiver` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
      `receiver_tel` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
      `receiver_add` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人联系地址',
      `parcel_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流公司',
      PRIMARY KEY (`logistic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for brionacOrder
-- ----------------------------
DROP TABLE IF EXISTS `brionac_order`;
CREATE TABLE `brionac_order`  (
          `order_id` int(7) NOT NULL AUTO_INCREMENT COMMENT '订单id',
          `order_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
          `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
          `product_id` int(10) NULL DEFAULT NULL COMMENT '商品ID',
          `product_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编号',
          `product_specs` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格',
          `user_id` int(10) NULL DEFAULT NULL COMMENT '用户ID',
          `user_account` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
          `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
          `contact_way` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
          `pay_price` decimal(10, 2) NULL DEFAULT 0 COMMENT '商品金额',
          `pay_amount` int(6) NULL DEFAULT 0 COMMENT '购买数量',
          `pay_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
          `order_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 0 COMMENT '订单状态',
          `accept_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
          `return_state` tinyint(1) NULL DEFAULT 0 COMMENT '退货状态',
          PRIMARY KEY (`order_id`) USING BTREE,
          UNIQUE INDEX `UNIQUE`(`order_no`) USING BTREE,
          INDEX `product_no`(`product_no`) USING BTREE,
          INDEX `order_ibfk_2`(`user_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
    `product_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `store_id` int(5) NOT NULL COMMENT '店铺ID',
    `product_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT null COMMENT '商品编号',
    `product_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT null COMMENT '商品名称',
    `product_type_id` int(5) NULL DEFAULT NULL COMMENT '商品类别id',
    `product_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT null COMMENT '商品类别',
    `thumbnail` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品缩略图',
    `intro_diagram` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品介绍图',
    `traffic` bigint NULL default 0 comment '流量热度',
    `sale_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
    `is_new` tinyint(1) NULL DEFAULT 1 COMMENT '是否新品',
    `is_sale` tinyint(1) NULL DEFAULT 1 COMMENT '是否上架',
    PRIMARY KEY (`product_id`) USING BTREE,
    UNIQUE INDEX `UNIQUE`(`product_no`) USING BTREE,
    INDEX `product_type`(`product_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for specs
-- ----------------------------
DROP TABLE IF EXISTS `specs`;
CREATE TABLE `specs`  (
      `specs_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '规格id',
      `product_id` int(10) NULL DEFAULT NULL COMMENT '所属商品Id',
      `specs_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT null COMMENT '规格名字',
      `specs_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT null COMMENT '规格描述',
      `specs_in_price` decimal(10, 2) NULL DEFAULT 0 COMMENT '进价',
      `specs_price` decimal(10, 2) NULL DEFAULT 0 COMMENT '规格出售价格',
      `specs_stock` int(5) NULL DEFAULT 0 COMMENT '规格库存',
      `is_stockout` tinyint(1) NULL DEFAULT 0 COMMENT '是否缺货',
      `specs_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格图片',
      `specs_status` int(1) NULL default 1 COMMENT '规格状态',
      `sale_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
      PRIMARY KEY (`specs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品规格表' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for product_review
-- ----------------------------
DROP TABLE IF EXISTS `product_review`;
CREATE TABLE `product_review`  (
   `review_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户评论id',
   `user_id` int(10) NULL DEFAULT NULL COMMENT '用户',
   `account_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户帐号',
   `product_id` int(10) NULL DEFAULT NULL COMMENT '商品ID',
   `product_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编号',
   `product_specs` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格',
   `order_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
   `review_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
   `star_level` double NOT NULL COMMENT '商品评星',
   `product_review` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品评价',
   PRIMARY KEY (`review_id`) USING BTREE,
   INDEX `account_number`(`account_number`) USING BTREE,
   INDEX `product_no`(`product_no`) USING BTREE,
   INDEX `order_no`(`order_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品评价' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type`  (
     `type_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '类别id',
     `type_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别名称',
     `type_describe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别描述',
     `type_url_left` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '左侧宣传图',
     `type_url_top` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '横幅宣传图',
     PRIMARY KEY (`type_id`) USING BTREE,
     UNIQUE INDEX `UNIQUE`(`type_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品类别表' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`  (
     `purchase_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '采购id',
     `purchase_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '采购编号',
     `purchase_number` int(6) NOT NULL COMMENT '进货数量',
     `purchase_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '进货时间',
     `receipt_time` timestamp NULL DEFAULT NULL COMMENT '收货时间',
     `product_id` int(10) NULL DEFAULT NULL COMMENT '商品ID',
     `product_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编号',
     `product_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
     `supplier_id` int(10) NULL DEFAULT NULL COMMENT '供应商ID',
     `supplier_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商编号',
     `supplier_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
     `account_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作员编号',
     `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作员名称',
     `receipt_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '收货状态',
     PRIMARY KEY (`purchase_id`) USING BTREE,
     UNIQUE INDEX `UNIQUE`(`purchase_no`) USING BTREE,
     INDEX `product_no`(`product_no`) USING BTREE,
     INDEX `supplier_no`(`supplier_no`) USING BTREE,
     INDEX `account_number`(`account_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '采购表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for return_goods
-- ----------------------------
DROP TABLE IF EXISTS `return_goods`;
CREATE TABLE `return_goods`  (
     `return_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '退货id',
     `apply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
     `order_id` int(10) NULL DEFAULT NULL COMMENT '订单ID',
     `order_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
     `user_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
     `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
     `return_price` double NULL DEFAULT NULL COMMENT '退款金额',
     `operator_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员账号',
     `operator_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员名称',
     `deal_time` timestamp NULL DEFAULT NULL COMMENT '处理时间',
     `reason_id` int(10) NULL DEFAULT NULL COMMENT '退货原因ID',
     `return_reason` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
     `return_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货状态',
     PRIMARY KEY (`return_id`) USING BTREE,
     INDEX `user_name`(`user_name`) USING BTREE,
     INDEX `return_goods_ibfk_3`(`operator_number`) USING BTREE,
     INDEX `return_goods_ibfk_1`(`order_no`) USING BTREE,
     INDEX `return_goods_ibfk_2`(`user_number`) USING BTREE,
     INDEX `return_goods_ibfk_4`(`return_reason`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品退货表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for return_reason
-- ----------------------------
DROP TABLE IF EXISTS `return_reason`;
CREATE TABLE `return_reason`  (
      `reason_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '退货id',
      `reason_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货理由',
      `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否启用',
      PRIMARY KEY (`reason_id`) USING BTREE,
      UNIQUE INDEX `UNIQUE`(`reason_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退货原因表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
     `role_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '角色id',
     `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
     `role_describe` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色描述',
     `role_state` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否启用',
     PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = COMPRESSED;

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
      `cart_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
      `user_id` int(5) NOT NULL COMMENT '用户id',
      `account_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户帐号',
      `product_id` int(5) NOT NULL COMMENT '商品id',
      `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
      `pay_amount` int(5) NOT NULL COMMENT '购买数量',
      `specs_id` int(10) NULL DEFAULT NULL COMMENT '商品规格ID',
      `specs_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格图片',
      `product_specs` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格',
      `specs_price` decimal(10, 2) NULL DEFAULT 0 COMMENT '该商品应付价钱',
      `state` tinyint(1) NOT NULL DEFAULT 0 COMMENT '支付状态',
      PRIMARY KEY (`cart_id`) USING BTREE,
      INDEX `account_number`(`account_number`) USING BTREE,
      INDEX `product_id`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车表' ROW_FORMAT = DYNAMIC;



-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
     `supplier_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '供应商id',
     `supplier_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商编号',
     `supplier_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
     `type_id` int(10) NULL DEFAULT NULL COMMENT '商品类型ID',
     `product_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品类别',
     `principal` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人',
     `contact_way` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
     `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否可用',
     PRIMARY KEY (`supplier_id`) USING BTREE,
     UNIQUE INDEX `UNIQUE`(`supplier_no`) USING BTREE,
     INDEX `product_type`(`product_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
         `user_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '用户id',
         `account_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
         `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
         `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
         `user_sex` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
         `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
         `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
         `user_state` tinyint(1) NOT NULL DEFAULT 1 COMMENT '用户状态',
         `summary` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人简介',
         `user_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址',
         `avatar_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
         PRIMARY KEY (`user_id`) USING BTREE,
         UNIQUE INDEX `UNIQUE`(`account_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
          `user_id` int(5) NOT NULL COMMENT '用户id',
          `role_id` int(5) NOT NULL default 4 COMMENT '角色id',
          INDEX `user_id`(`user_id`) USING BTREE,
          INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for li_store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
         `store_id` int(5) AUTO_INCREMENT NOT NULL COMMENT 'ID',
         `user_id` int(10) NULL DEFAULT NULL COMMENT '用户ID',
         `self_operated` bit(1) NOT NULL COMMENT '是否自营',
         `store_disable` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺状态',
         `store_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺logo',
         `store_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺名称',
         `store_address_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
         `store_address_id_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址id',
         `store_address_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址名称',
         `store_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺简介',
         `delivery_score` decimal(10, 2) NULL DEFAULT NULL COMMENT '物流评分',
         `description_score` decimal(10, 2) NULL DEFAULT NULL COMMENT '描述评分',
         `service_score` decimal(10, 2) NULL DEFAULT NULL COMMENT '服务评分',
         `goods_num` int NULL DEFAULT NULL COMMENT '商品数量',
         `collection_num` int NULL DEFAULT NULL COMMENT '收藏数量',
         PRIMARY KEY (`store_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '店铺表' ROW_FORMAT = DYNAMIC;

/*-- ----------------------------
-- Event structure for product_event
-- ----------------------------
#该事件的作用是在每天的指定时间执行一系列操作
#事件的调度规则是每隔一天执行一次，从指定的开始时间
#更新product表中sale_time早于当前时间15天的记录，即将15天前的新品数据修改为非新品数据。
#删除order表中满足以下条件的记录：订单时间早于当前日期减去1天，并且订单状态为"待付款"。即清除24小时内未付款的订单信息
DROP EVENT IF EXISTS `product_event`;
delimiter ;;
CREATE EVENT `product_event`
ON SCHEDULE
EVERY '1' DAY STARTS '2023-12-20 02:00:00'
ON COMPLETION PRESERVE
DO BEGIN

UPDATE product SET is_new = 0 WHERE sale_time<(CURRENT_TIMESTAMP() + INTERVAL -15 DAY);#修改15天前的新品数据

DELETE FROM `brionacOrder` WHERE order_time < DATE_SUB(CURDATE(),INTERVAL 1 DAY) AND order_state='待付款';	#清除24小时内未付款的订单信息

END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table brionacOrder
-- ----------------------------
# 订单删除触发器
DROP TRIGGER IF EXISTS `order_delete`;
delimiter ;;
CREATE TRIGGER `order_delete` BEFORE DELETE ON `brionacOrder` FOR EACH ROW BEGIN
    UPDATE specs SET specs_stock = specs_stock + old.pay_amount WHERE product_no = old.product_no;
END
;;
delimiter ;
*/
-- ----------------------------
-- Triggers structure for table user
-- ----------------------------
# 用户添加触发器
DROP TRIGGER IF EXISTS `user_insert`;
delimiter ;;
CREATE TRIGGER `user_insert` AFTER INSERT ON `user` FOR EACH ROW BEGIN

    DECLARE roleId INT;

	SET roleId = (SELECT role_id FROM role WHERE role_name ='顾客');

		INSERT user_role VALUES(new.user_id,roleId);

END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
