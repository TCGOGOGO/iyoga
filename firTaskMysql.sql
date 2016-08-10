create table member (id int primary key auto_increment,
	name varchar(20) unique,
	address varchar(200),
	job varchar(20)
)auto_increment = 1;

create table card (id int primary key auto_increment,
	type varchar(20),
	startTime varchar(20),
	endTime varchar(20),
	times int
)auto_increment = 1;


create table open (id int primary key auto_increment,
	member_id int,
	card_id int , 
	foreign key(member_id) references member(id),
	foreign key(card_id) references card(id)
)auto_increment = 1;