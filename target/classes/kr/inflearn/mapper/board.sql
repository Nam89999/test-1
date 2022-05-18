create table tb_board(

	idx int not null auto_increment, 
	title varchar(100) not null, 
	contents varchar(4000) not null, 
	count int,
	writer varchar(30) not null, 
	indate datetime default now() not null,
	primary key(idx)
	
 );
 
 create table member(
 	
		 num int not null auto_increment,
		 id varchar(20) not null,
		 password varchar(20) not null,
		 name varchar(20) not null,
		 age int not null,
		 email varchar(30) not null,
		 phone varchar(25) not null,
		 primary key (num)
 );
 
 
 select *from member;
 
 insert into member(id,password,name,age,email,phone)
 values('admin','1234','관리자',19,'admin@google.com0','010-1111-1111');

 
 insert into tb_board(title, contents, count, writer)
 values('게시판 만들기','게시판 만들기',0,'관리자');
 
 
 
 select *from tb_board;
 
 drop table member;

 drop table tb_board;
