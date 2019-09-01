mysql -u root -proot

use dormitory;

desc houseparent;

show create table houseparent;

#诸表之结构
#............................................

# 宿管员
CREATE TABLE `houseparent` (
  `hpid` int(26) NOT NULL AUTO_INCREMENT COMMENT '宿管员之表的ID',
  `hpname` varchar(32) NOT NULL COMMENT '宿管员名字',
  `password` varchar(50) NOT NULL,
  `phone` char(40) NOT NULL COMMENT '电话号码',
  `salt` varchar(42) NOT NULL COMMENT '盐值',
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `id_card` char(50) DEFAULT NULL COMMENT '身份证号',
  `portrait` char(75) DEFAULT NULL COMMENT '头像',
  `competence` int(1) NOT NULL DEFAULT '0' COMMENT '权限:0-普通,1-高级,2-超级',
  `is_incumbency` int(1) NOT NULL DEFAULT '1' COMMENT '是否在职:0-离职,1-在职',
  PRIMARY KEY (`hpid`),
  UNIQUE KEY `id_cart` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;  

# 住宿生
CREATE TABLE `student` (
  `sid` int(25) NOT NULL AUTO_INCREMENT,
  `student_no` int(35) NOT NULL COMMENT '学号',
  `student_name` varchar(10) NOT NULL,
  `building_no` int(2) NOT NULL COMMENT '大楼编号',
  `chamber_no` int(6) NOT NULL COMMENT '房间编号',
  `enter_time` date NOT NULL COMMENT '入住时间',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `student_no` (`student_no`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

# 访客
CREATE TABLE `visitor` (
  `vid` int(30) NOT NULL AUTO_INCREMENT,
  `visitor_name` varchar(10) NOT NULL,
  `visitor_cardno` varchar(40) NOT NULL COMMENT '身份证号',
  `visited_student_name` varchar(10) NOT NULL COMMENT '被访问的学生名字',
  `visited_student_building` int(2) NOT NULL COMMENT '被访问的学生大楼编号',
  `visited_student_chamber` int(6) NOT NULL COMMENT '被访问的学生房间编号',
  `relation` int(3) NOT NULL COMMENT '关系,0-家人,1-朋友,2-同学,3-老师,4-外卖快递,5-其他',
  `visitor_time` date NOT NULL COMMENT '到访时间',
  `leave_time` date NOT NULL COMMENT '离去时间',
  PRIMARY KEY (`vid`),
  UNIQUE KEY `visitor_cardno` (`visitor_cardno`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;