--회원정보 테이블
CREATE TABLE member(
mem_id VARCHAR(50) PRIMARY KEY,
mem_pass VARCHAR(50),
mem_name VARCHAR(50),
mem_point NUMERIC(10,0)
);

insert into member
(mem_id,mem_pass,mem_name,mem_point) 
values
('a001','1234','고길동',100);

insert into member
(mem_id,mem_pass,mem_name,mem_point) 
values
('a002','4567','마이콜',200);

commit;

SELECT mem_id,mem_pass,mem_name,mem_point
FROM member;


CREATE TABLE bbs
(bbs_no INT PRIMARY KEY AUTO_INCREMENT,
 bbs_title VARCHAR(100),
 bbs_content TEXT,
 bbs_writer VARCHAR(50),
 bbs_reg_date DATETIME DEFAULT CURRENT_TIMESTAMP
 ,bbs_count NUMERIC(10,0) DEFAULT 0
 ,FOREIGN KEY (bbs_writer) REFERENCES member (mem_id)
);

SELECT *  FROM bbs;

DROP table bbs;
