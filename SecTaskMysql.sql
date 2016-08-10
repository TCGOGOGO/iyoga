create table member (id int primary key auto_increment,
	name varchar(20) unique,
	address varchar(200),
	job varchar(20)
)auto_increment = 1;

create table course (id int primary key auto_increment,
	name varchar(20) unique
)auto_increment = 1;

create table coach (id int primary key auto_increment,
	name varchar(20) unique,
	family varchar(30),
	age varchar(12),
	forte varchar(40)
)auto_increment = 1;

create table memberCourseCoach (id int primary key auto_increment,
	member_id int,
	course_id int,
	coach_id int,
	learn_time datetime,
	foreign key(member_id) references member(id) on delete cascade,
	foreign key(course_id) references course(id) on delete cascade,
	foreign key(coach_id) references coach(id) on delete cascade
)auto_increment = 1;