-- 创建数据库
create DATABASE renthouse;

-- 使用数据库
use renthouse;

-- 创建房屋信息表：主键自增设置为从1开始，字符格式设置为UTF8
CREATE TABLE house(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋id',
  user_id int(11) NOT NULL COMMENT '房主id',
  community varchar(20) NOT NULL COMMENT '小区',
  province VARCHAR(20) NOT NULL COMMENT '省份',
  city VARCHAR(20) NOT NULL COMMENT '城市',
  district VARCHAR(20) NOT NULL  COMMENT '所在区',
  street VARCHAR(20) NOT NULL COMMENT '街道/号',
  room int(5) NOT NULL COMMENT '室',
  hall int(5) NOT NULL COMMENT '厅',
  toilet int(5) NOT NULL COMMENT '卫',
  square int(10) NOT NULL COMMENT '房屋平方',
  decoration VARCHAR(20) NOT NULL COMMENT '装修',
  location VARCHAR(20) NOT NULL COMMENT '朝向',
  floor int(5) NOT NULL COMMENT '楼层',
  top_floor int(5) NOT NULL COMMENT '顶层',
  house_number VARCHAR(20) NOT NULL COMMENT '楼号',
  house_type VARCHAR(20) NOT NULL COMMENT '房屋类型',
  is_elevator int(4) NOT NULL COMMENT '是否有电梯 -1无 1有',
  subway_number VARCHAR(50) NOT NULL COMMENT '靠近地铁的号数',
  property_costs VARCHAR(50) NOT NULL COMMENT '物业费用（1.60元/平方/月）',
  configuration VARCHAR(100) NOT NULL COMMENT '配置',
  description text COMMENT '描述',
  `main_image` varchar(500) DEFAULT NULL COMMENT '产品主图,url相对地址',
  `sub_images` text COMMENT '图片地址,json格式,扩展用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (id),
    -- 索引
  KEY user_id_index(user_id) USING BTREE,
  KEY community_index(community) USING BTREE,
  KEY `district_index` (district) USING BTREE,
  KEY `room_index` (room) USING BTREE,
  KEY `house_type_index` (house_type) USING BTREE,
  KEY `location_index` (location) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='房屋信息表';
-- 初始化数据
insert into house(id,user_id,community,province,city,district,street,room,hall,toilet,square,decoration,location,floor,top_floor,house_number,house_type,is_elevator,subway_number,property_costs,configuration,description,main_image,sub_images,
                  create_time,update_time)
values
  (1,1,'富力银禧花园','广东','广州','海珠','滨江东',3,2,2,125,'精装修','朝南',13,28,'5栋','别墅',1,'8号线',3.3,'冰箱-空调','详细描述xxxxxxxxxxxx',null,null,'2017-04-13 21:27:06','2017-04-13 21:27:06'),
  (2,1,'富力银禧花园','广东','广州','海珠','滨江东',3,2,2,125,'精装修','朝南',13,28,'5栋','别墅',1,'8号线',3.3,'冰箱-空调','详细描述xxxxxxxxxxxx',null,null,'2017-04-13 21:27:06','2017-04-13 21:27:06');


-- 创建发布房屋表：使用InnoDB引擎，其支持事务。主键自增设置为从1开始，字符格式设置为UTF8
CREATE TABLE publish(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '发布id',
  house_id int(11) NOT NULL  COMMENT '房屋id',
  user_id int(11) NOT NULL  COMMENT '房主id',
  title varchar(50) NOT NULL COMMENT '发布名称',
  pay_number INT(4) NOT NULL COMMENT '付（付x押x） ',
  deposit_number INT(4) NOT NULL COMMENT '押',
  rent decimal NOT NULL COMMENT '租金',
  cash_pledge decimal NOT NULL COMMENT '押金（计算存入数据库）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  publish_time datetime  DEFAULT NULL COMMENT '发布时间',
  rent_way VARCHAR(10) NOT NULL COMMENT '方式:单间，合租',
  rent_time INT(4) NOT NULL COMMENT '出租时间(月单位)',
  status INT(4) NOT NULL COMMENT '状态标示：-1指未发布，0指已发布，1指已出租',
  visit INT(10) DEFAULT 0 COMMENT '参观人数',
  PRIMARY KEY (id),
  -- 索引
  KEY rent_index(rent) USING BTREE,
  KEY rent_way_index(rent_way) USING BTREE,
  KEY publish_time_index(publish_time) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='发布表';
-- 初始化数据
insert into publish(id,house_id,user_id,title,pay_number,deposit_number,rent,cash_pledge,create_time,update_time,publish_time,rent_way,rent_time,status,visit)
values
  (1,1,1,'富力银禧花园：豪华装修 东南向三房 家私家电齐全',1,2,8500,17000,'2017-04-13 21:27:06','2017-04-13 21:27:06','2017-04-13 21:27:10',1,12,1,100),  (2,2,1,'富力银禧花园：豪华装修 东南向三房 家私家电齐全',1,2,8500,17000,'2017-04-13 21:27:06','2017-04-13 21:27:06','2017-04-13 21:27:10',1,12,1,100);


-- 创建发布评论表：使用InnoDB引擎，其支持事务。主键自增设置为从1开始，字符格式设置为UTF8
CREATE TABLE comment(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  publish_id int(11) NOT NULL COMMENT '发布id',
  to_user_id INT(11) not NULL COMMENT '租客id',
  content VARCHAR(200) NOT NULL COMMENT '评论内容',
  authenticity INT(5) DEFAULT 0 COMMENT '真实性指数（五星样式显示）',
  environment INT(5) DEFAULT 0 COMMENT '环境指数',
  service INT(5) DEFAULT 0 COMMENT '服务指数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (id),
  -- 索引
  KEY idx_create_time(create_time) USING BTREE,
  KEY idx_update_time(update_time) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- 线下约谈表
CREATE TABLE off_line(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  publish_id INT(11) NOT NULL COMMENT '发布ID',
  user_id int(11) NOT NULL  COMMENT '房主id',
  to_user_id int(11) NOT NULL  COMMENT '租客id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `appoint_time` datetime DEFAULT NULL COMMENT '约谈时间',
  time VARCHAR(10) not null  COMMENT '上午或下午',
  person_number INT(10) NOT NULL COMMENT '看房人数',
  to_user_phone VARCHAR(15) NOT NULL  COMMENT '租客本人电话',
  status INT(4) NOT NULL COMMENT '状态标示：-1指时间不方便，另选时间 1指 此时间可以看房',
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='线下约谈表';


-- 出租订单表
CREATE TABLE house_order(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  house_id INT(11) NOT NULL COMMENT '房屋id',
  publish_id int(11) NOT NULL COMMENT '发布id',
  user_id int(11) NOT NULL  COMMENT '房主id',
  to_user_id int(11) NOT NULL  COMMENT '租客id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `end_time` datetime DEFAULT NULL COMMENT '（总）租房到期的时间',
  month_limit INT(3) NOT NULL COMMENT '月数限制',
  status INT(4) NOT NULL COMMENT '状态标示： -1中途退租失效 0指到期 1指有效（正在租用）',
  PRIMARY KEY (id),
  -- 索引
  KEY idx_create_time(create_time) USING BTREE,
  KEY idx_update_time(update_time) USING BTREE,
  KEY idx_end_time(end_time) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='出租订单表';

-- 交易明细表
CREATE TABLE order_detail(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  order_id INT(11) NOT NULL COMMENT '订单id',
  publish_id int(11) NOT NULL COMMENT '发布id',
  user_id int(11) NOT NULL  COMMENT '房主id',
  to_user_id int(11) NOT NULL  COMMENT '租客id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `end_time` datetime DEFAULT NULL COMMENT '（交易某次）租房到期的时间',
  money DECIMAL NOT NULL COMMENT '支付金额',
  pay_month INT(3) NOT NULL COMMENT '选择付房租的月数',
  leave_month INT(3) NOT NULL COMMENT '剩下月份=总-已付月份',
  pay_type INT(4) not NULL COMMENT '支付方式 1 在线支付',
  PRIMARY KEY (id),
  -- 索引
  KEY idx_create_time(create_time) USING BTREE,
  KEY idx_update_time(update_time) USING BTREE,
  KEY idx_end_time(end_time) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='交易明细表';


--  用户信息表
CREATE TABLE user(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  username VARCHAR(30) UNIQUE NOT NULL COMMENT '用户名，MD5加密',
  password VARCHAR(100) NOT NULL COMMENT '密码',
  pay_pwd VARCHAR(100) NOT NULL COMMENT '支付密码',
  `email` varchar(50) DEFAULT NULL  COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  name VARCHAR(50) NOT NULL COMMENT '姓名',
  credit int(4) NOT NULL COMMENT '信用等级：默认:0 (1 2 3 4 5)',
  money DECIMAL NOT NULL COMMENT '金钱总数',
  `question` varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  `answer` varchar(100) DEFAULT NULL COMMENT '找回密码答案',
  `role` int(4) NOT NULL COMMENT '用户标识：0管理员 1房主 2租客 ',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  history VARCHAR(50) NOT NULL COMMENT '浏览的发布id记录，保存格式为-5-4-3-2-1-',
  PRIMARY KEY (id),
  UNIQUE KEY (email),
  UNIQUE KEY (phone),
  UNIQUE KEY `username_unique` (`username`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

