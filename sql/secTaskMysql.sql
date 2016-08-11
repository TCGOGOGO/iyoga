create table member (id int primary key auto_increment,	#会员id 主键
	name varchar(20) unique,	#会员姓名 唯一
	address varchar(200),		#会员住址
	job varchar(20)				#会员工作
)auto_increment = 1;

create table course (id int primary key auto_increment,	#课程id 主键
	name varchar(20) unique		#课程名 唯一
)auto_increment = 1;

create table coach (id int primary key auto_increment,	#教练id 主键
	name varchar(20) unique,	#教练名 唯一
	family varchar(30),			#教练家族
	age varchar(12),			#教练年龄
	forte varchar(40)			#教练专长
)auto_increment = 1;

create table memberCourseCoach (id int primary key auto_increment,	#会员课程教练关系id 主键 
	member_id int,				#选课会员id 外键
	course_id int,				#所选课程id 外键
	coach_id int,				#课程教练id 外键
	learn_time datetime,		#课程开始时间
	foreign key(member_id) references member(id) on delete cascade,	
	foreign key(course_id) references course(id) on delete cascade,
	foreign key(coach_id) references coach(id) on delete cascade
)auto_increment = 1;