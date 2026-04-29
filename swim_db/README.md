# 수영장 관리 프로그램

## MySQL DB 쿼리
```
CREATE DATABASE swim_db DEFAULT CHARACTER SET utf8mb4;
CREATE USER 'swim_user'@'%' IDENTIFIED BY 'qwer1234!';
GRANT ALL PRIVILEGES ON swim_db.* TO 'swim_user'@'%';
FLUSH PRIVILEGES
```

### 물리 테이블 설계서
```
swim_pool(마스터 테이블)
이름			데이터형 길이	null		제약조건					comment
id			bigint		not null	auto_increment	pkey	분류 기본키
name		varchar	15	not null					        분류 이름
tel         varchar 20  not null    unique
addr1       varchar 255 not null     
addr2       varchar 255
lanes       varchar 100 not null
size        varchar 50  not null


teacher (수영 강사 테이블)
이름			    데이터형 길이	null		제약조건					comment
id			    bigint		not null	auto_increment	pkey	재료 기본키
name		    varchar	255	not null					        재료 이름
main            varchar 100 not null
birth_year      bigint  
swim_pool_id    bigint      not null    foreign key(swim_pool.id)
category_id	bigint		not null	foreign key (category.id)	분류 외래키


```