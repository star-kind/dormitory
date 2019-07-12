
CREATE DATABASE dormitory;

# 学生
CREATE TABLE student (
  sid int(25) NOT NULL AUTO_INCREMENT,
  student_no int(35) NOT NULL COMMENT '学号',
  student_name varchar(10) NOT NULL,
  building_no int(2) NOT NULL COMMENT '大楼编号',
  chamber_no int(6) NOT NULL COMMENT '房间编号',
  enter_time date NOT NULL COMMENT '入住时间',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `student_no` (`student_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# 宿管
CREATE TABLE houseparent (
  hpid int(25) NOT NULL AUTO_INCREMENT,
  hpname varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`hpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 访客
CREATE TABLE visitor (
  vid int(30) NOT NULL AUTO_INCREMENT,
  visitor_name varchar(10) NOT NULL,
  visitor_cardno varchar(40) NOT NULL COMMENT '身份证号',
  visited_student_name varchar(10) NOT NULL COMMENT '被访问的学生名字',
  visited_student_building int(2) NOT NULL COMMENT '被访问的学生大楼编号',
  visited_student_chamber int(6) NOT NULL COMMENT '被访问的学生房间编号',
  `relation` int(3) NOT NULL COMMENT '关系,0-家人,1-朋友,2-同学,3-老师,4-外卖快递,5-其他',
  visitor_time date NOT NULL COMMENT '到访时间',
  leave_time date NOT NULL COMMENT '离去时间',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


##
INSRET INTO houseparent (hpname,password) VALUES ('admin01','0123456');

INSRET INTO houseparent (hpname,password) VALUES ('admin','0123456');

###
| CREATE TABLE `visitor` (
  `vid` int(30) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8  


SELECT vid,visitor_name AS visitorName,visitor_cardno AS visitorCardno,visited_student_name AS visitedStudentName,visited_student_building AS visitedStudentBuilding,visited_student_chamber AS visitedStudentChamber,relation,visitor_time AS visitorTime,leave_time AS leaveTime
FROM visitor; 

alter table visitor change vid vid int(30) not null auto_increment;