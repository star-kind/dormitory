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

##
CREATE TABLE `visitor` (
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

-- ----------------------------
-- 加字段
-- ----------------------------
ALTER TABLE houseparent ADD phone CHAR(40) NOT NULL COMMENT '电话号码';

ALTER TABLE houseparent ADD id_cart CHAR(50) NOT NULL COMMENT '身份证号';

ALTER TABLE houseparent ADD reg_time DATETIME COMMENT '注册时间';

ALTER TABLE houseparent ADD salt VARCHAR(42) NOT NULL COMMENT '盐值';
-- ----------------------------

-- 设不自动增长
ALTER TABLE houseparent MODIFY hpid INT(26);

# 添加hpname注释:宿管员之名
ALTER TABLE houseparent CHANGE hpname hpname VARCHAR(32) NOT NULL COMMENT '宿管员名字';

# 删除主键
ALTER TABLE houseparent DROP PRIMARY KEY;

# 删除字段
ALTER TABLE houseparent DROP COLUMN id_cart;

ALTER TABLE houseparent ADD id_cart CHAR(50) UNIQUE NULL COMMENT '身份证号';

# 给身份证添加唯一约束
# ALTER TABLE houseparent ADD CONSTRAINT UNIQUE (id_cart);

# 添加主键
ALTER TABLE houseparent ADD PRIMARY KEY(hpid);

-- 设置ID自增
ALTER TABLE houseparent MODIFY hpid INT(26) AUTO_INCREMENT COMMENT '宿管员之表的ID';

-- 头像
ALTER TABLE houseparent ADD portrait CHAR(75) NULL COMMENT '头像';

-- 权限
ALTER TABLE houseparent ADD competence int(1) NOT NULL DEFAULT '0' COMMENT '权限:0-普通,1-高级,2-超级';

-- 是否在职
ALTER TABLE houseparent ADD is_incumbency int(1) NOT NULL DEFAULT '1' COMMENT '是否在职:0-离职,1-在职';

DELETE FROM houseparent WHERE hpid IN (1,6,7,8);

update houseparent set hpname='wdf',phone='1997464',portrait='fasfad.png' where hpid=10;

select count(competence) as result from houseparent where competence=1;

-- 根据权限和ID更新是否在职
UPDATE houseparent SET is_incumbency=1 WHERE competence=0 AND hpid=7;

select hpid,hpname,competence,is_incumbency from houseparent;

# 新加一行
insert into houseparent(hpname,password,phone,salt,reg_time,id_card,portrait)  
VALUES("admin-olo","ano","364527945","kghomlpuy7685","2019-09-09","1534527489966t","45rfg.gif");

update houseparent set password="36412" where hpid=7;

# rename
ALTER TABLE houseparent CHANGE id_cart id_card CHAR(50) NULL COMMENT '身份证号';

select competence from houseparent where hpid in (15,16,17,18);

select hpid,id_card,competence from houseparent;

-- 431233198811230333
update houseparent set competence=2 where hpid=22;
