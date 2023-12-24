-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '开发人员', '开发人员', 1);
INSERT INTO `role` VALUES (2, '运营商', '运营商', 1);
INSERT INTO `role` VALUES (3, '店铺', '店铺', 1);
INSERT INTO `role` VALUES (4, '顾客', '顾客', 1);
INSERT INTO `role` VALUES (5, '一般浏览者', '一般浏览者', 1);

INSERT INTO user (account_number, user_name, password, user_sex, telephone, summary, user_address, avatar_url) VALUES
('202110244109', '张三', '79af2d2e12a27a74815b65a46267ca00', '男', '1234567890', '你好，我是张三。', '北京市朝阳区', 'http://example.com/avatar1.jpg'),
('202110244110', '李四', '79af2d2e12a27a74815b65a46267ca00', '女', '1234567890', '很高兴认识大家！', '上海市黄浦区', 'http://example.com/avatar2.jpg'),
('202110244111', '王五', '79af2d2e12a27a74815b65a46267ca00', '男', '1234567890', '我热爱编程。', '广州市天河区', 'http://example.com/avatar3.jpg'),
('202110244112', '小红店铺', '79af2d2e12a27a74815b65a46267ca00', '男', '1234567890', '我热爱编程。', '广州市天河区', 'http://example.com/avatar3.jpg'),
('202110244113', '小明商店', '79af2d2e12a27a74815b65a46267ca00', '男', '1234567890', '我热爱编程。', '广州市天河区', 'http://example.com/avatar3.jpg'),
('202110244114', '绿野百货', '79af2d2e12a27a74815b65a46267ca00', '男', '1234567890', '我热爱编程。', '广州市天河区', 'http://example.com/avatar3.jpg');

update `user_role` set role_id = 3 where user_id = 4;
update `user_role` set role_id = 3 where user_id = 5;
update `user_role` set role_id = 3 where user_id = 6;

INSERT INTO store (user_id, self_operated, store_disable, store_logo, store_name, store_address_detail, store_address_id_path, store_address_path, store_desc, delivery_score, description_score, service_score, goods_num, collection_num) VALUES
(4, b'1', '正常营业', 'http://example.com/store1_logo.jpg', '小红店铺', '北京市朝阳区xxx街道xxx号', '1/2/3', '北京市/朝阳区/xxx街道', '这是小红店铺，提供优质商品和服务。', 4.5, 4.8, 4.7, 100, 500),
(5, b'0', '暂停营业', 'http://example.com/store2_logo.jpg', '小明商店', '上海市黄浦区yyy街道yyy号', '4/5/6', '上海市/黄浦区/yyy街道', '欢迎光临小明商店，我们提供多种商品选择。', 4.2, 4.6, 4.4, 200, 300),
(6, b'1', '正常营业', 'http://example.com/store3_logo.jpg', '绿野百货', '广州市天河区zzz街道zzz号', '7/8/9', '广州市/天河区/zzz街道', '绿野百货，让您购物无忧。', 4.6, 4.7, 4.9, 150, 800);