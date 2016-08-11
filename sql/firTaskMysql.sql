create table member (id int primary key auto_increment,	#会员id 主键
	name varchar(20) unique,	#会员姓名 唯一
	address varchar(200),		#会员住址
	job varchar(20)				#会员工作
)auto_increment = 1;
	
create table card (id int primary key auto_increment,	#会员卡id 主键
	type varchar(20),			#会员卡种类
	startTime varchar(20),		#会员卡有效期的开始时间
	endTime varchar(20),		#会员卡有效期的结束时间
	times int 					#会员卡使用次数，年卡默认为0
)auto_increment = 1;


create table open (id int primary key auto_increment,	#办卡事务id 主键
	member_id int,				#办卡会员id, 外键
	card_id int , 				#所办会员卡id, 外键
	foreign key(member_id) references member(id),	
	foreign key(card_id) references card(id)		
)auto_increment = 1;