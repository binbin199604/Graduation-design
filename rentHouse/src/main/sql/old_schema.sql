-- 创建数据库
create DATABASE renthouse;

-- 使用数据库
use renthouse;

-- 创建房屋信息表：主键自增设置为从1开始，字符格式设置为UTF8
CREATE TABLE house(
  house_id int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋id',
  owner_id int(11) NOT NULL COMMENT '房主id',
  name varchar(50) NOT NULL COMMENT '房屋小区名称',
  address varchar(120) NOT NULL COMMENT '详细地址',
  province VARCHAR(20) NOT NULL COMMENT '所在省份',
  city VARCHAR(20) NOT NULL COMMENT '房屋所在城市',
  district VARCHAR(20) NOT NULL  COMMENT '区/县',
  type VARCHAR(50) NOT NULL COMMENT '房屋户型',
  square DECIMAL NOT NULL COMMENT '房屋平方',
  `main_image` varchar(500) DEFAULT NULL COMMENT '产品主图,url相对地址',
  `sub_images` text COMMENT '图片地址,json格式,扩展用',
  `detail` text COMMENT '房屋详情',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (house_id),
    -- 索引
  KEY idx_name(name) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='房屋信息表';
-- 初始化数据
insert into house(house_id,owner_id,name,address,city,province,type,square,main_image,sub_images,detail,create_time,update_time)
values
  (1,1,'嘉福花园','嘉福花园10栋之二502','江门','广东','3室1厅2卫','100',null,null,'xxxxx','2017-04-13 21:27:06', '2017-04-13 21:27:06'),
  (2,1,'怡兴苑','怡兴苑35栋502','江门','广东','3室1厅2卫','120',null,null,'xxxxx','2017-04-13 21:27:06', '2017-04-13 21:27:06');


-- 创建发布房屋表：使用InnoDB引擎，其支持事务。主键自增设置为从1开始，字符格式设置为UTF8
CREATE TABLE publish_house(
  publish_id int(11) NOT NULL AUTO_INCREMENT COMMENT '发布id',
  house_id int(11) NOT NULL  COMMENT '房屋id',
  owner_id int(11) NOT NULL  COMMENT '房主id',
  title varchar(50) NOT NULL COMMENT '发布名称',
  rent_money decimal NOT NULL COMMENT '租金',
  cash_pledge DECIMAL NOT NULL COMMENT '押金',
  description VARCHAR(120) NOT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  publish_time datetime  DEFAULT NULL COMMENT '发布时间',
  way VARCHAR(10) NOT NULL COMMENT '方式:单间，合租',
  rent_time datetime DEFAULT NULL COMMENT '出租至多久时间',
  state INT(4) NOT NULL COMMENT '状态标示：-2锁定,-1指未发布，0指已发布，1指已出租',
  PRIMARY KEY (publish_id),
  -- 索引
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='发布房屋表';
-- 初始化数据
insert into publish_house(publish_id,house_id,owner_id,
                  title,rent_money,cash_pledge,description,create_time,
                          update_time,publish_time,way,rent_time,state)
values
  (1,1,1,'宜居的楼盘-嘉福花园',3000,1000,'周围环境优美，配置齐全xxxx....','2017-04-13 21:27:06', '2017-04-13 21:27:06',null,'整租',null,-1),
  (2,2,1,'高尚住宅-怡兴苑',2000,2000,'周围环境优美，配置齐全xxxx....','2017-04-13 21:27:06', '2017-04-13 21:27:06',null,'单间',null,-1);

-- 成功出租明细表（生成订单）
CREATE TABLE success_house(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  publish_id int(11) NOT NULL COMMENT '发布id',
  owner_id int(11) NOT NULL  COMMENT '房主id',
  renter_id int(11) NOT NULL  COMMENT '租客id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  state INT(4) NOT NULL COMMENT '状态标示：-1指退租或失效，0指有效（正在租用）',
  PRIMARY KEY (id),
  -- 索引
  KEY idx_create_time(create_time),
  KEY idx_update_time(update_time)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='出租成功明细表';

-- 线下约谈表
CREATE TABLE off_line_appoint(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  owner_id int(11) NOT NULL  COMMENT '房主id',
  renter_id int(11) NOT NULL  COMMENT '租客id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `appoint_time` datetime DEFAULT NULL COMMENT '约谈时间',
  time VARCHAR(10) not null  COMMENT '上午或下午',
  person_number INT(10) NOT NULL COMMENT '看房人数',
  phone VARCHAR(15) NOT NULL  COMMENT '租客电话',
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='线下约谈表';


-- 房主信息表
CREATE TABLE owner(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  owner_id int(11) NOT NULL COMMENT '房主id',
  name VARCHAR(50) NOT NULL COMMENT '姓名',
  credit int(4) NOT NULL COMMENT '信用标示：0未评价 1一级信用 2 3 4 5',
  money DECIMAL NOT NULL COMMENT '金钱总数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY `owner_id_unique` (`owner_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='房主信息表';

-- 租客信息表
CREATE TABLE renter(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  renter_id int(11) NOT NULL COMMENT '租客id',
  name VARCHAR(50) NOT NULL COMMENT '姓名',
  credit int(4) NOT NULL COMMENT '信用标示：0未评价 1一级信用 2 3 4 5',
  money DECIMAL NOT NULL COMMENT '金钱总数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY `renter_id_unique` (`renter_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='租客信息表';

--  用户登陆注册信息表
CREATE TABLE user(
  user_id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  username VARCHAR(30) UNIQUE NOT NULL COMMENT '用户名，MD5加密',
  password VARCHAR(30) NOT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL  COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `question` varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  `answer` varchar(100) DEFAULT NULL COMMENT '找回密码答案',
  `role` int(4) NOT NULL COMMENT '用户标识：0房主 1租客 2管理员',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (user_id),
  UNIQUE KEY `username_unique` (`username`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

