 
 create table tb_board2(

	board_id int not null auto_increment, 
	num int not null, 
	title varchar(50) not null, 
	contents varchar(4000) not null, 
	count int,
	regdate datetime not null default current_timestamp,
	updatedate DATETIME ON UPDATE CURRENT_TIMESTAMP,
	primary key(board_id)
	
 );
 
 drop table tb_board2;
 
 		SELECT *
		FROM comment c, tb_board2 b
		WHERE c.board_id = b.board_id
		
 SELECT *
 FROM tb_board2;
 
 insert into tb_board2(num, title, contents, count)
 values('1','게시판 만들기','게시판 만들기',0);
 
  insert into tb_board2(num, title, contents, count)
 values('2','이거되는거 맞아?','이거 되는거 맞아',0);
 


SELECT *
FROM tb_board2 b,member m
WHERE  b.num=m.num;

SELECT m.id as id, m.name as name
FROM tb_board2 b, member m
WHERE tb.board_id = 1 AND b.num=m.num;


)
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

 
 drop table member;


 
 insert into member(id,password,name,age,email,phone)
 values('admin','1234','관리자',19,'admin@google.com0','010-1111-1111');

 
  
 create table comment(
    comment_id int not null auto_increment,
    board_id int not null,
    num int not null,
    content varchar(150) not null,
    regdate datetime not null default current_timestamp,
	primary key(comment_id)
 );
 
SELECT* FROM comment;


SELECT  comment_id AS commentId 
	   , board_id AS boardnum
       , content
	   , writer as commentWriter
	   , regdate
FROM comment
WHERE comment_id = 2
	
 
 
 drop table comment;
 
 
SELECT *
FROM comment c, tb_board2 b
WHERE c.board_id = b.board_id AND c.num = b.num AND b.board_id = 1
 
 
create table re_comment(
 	
		 re_comment_id int not null auto_increment,
		 comment_id int not null,
		 board_id int not null,
		 num int not null,
         content varchar(150) not null,
         regdate datetime not null default current_timestamp,
	     primary key(re_comment_id)

 );

SELECT re_comment_id AS reCommentId
	   ,comment_id AS commentId
 	   ,board_id AS boardnum
	   ,m.num as num
	   ,m.id AS commentWriter
	   ,content
	   ,regdate
FROM re_comment r, member m
where r.num = m.num AND comment_id = 1;  
		
INSERT INTO re_comment(comment_id,board_id, num,content)
VALUES('1','1','2','테스트 대댓글');