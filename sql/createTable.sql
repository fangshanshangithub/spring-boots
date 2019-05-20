drop database  if exists  spring_boots_db;
create database spring_boots_db CHARACTER SET utf8 COLLATE utf8_general_ci;;
use spring_boots_db;

drop table if exists user_info;
create table user_info(
  id bigint(10) not null auto_increment primary key comment '主键',
  name varchar(18) not null comment '用户姓名',
  age int(10) not null comment '用户年龄',
  email varchar(20) not null default '' comment '用户邮箱',
  phone varchar(20) not null default '' comment '用户手机号',
  time  TIMESTAMP  not null default CURRENT_TIMESTAMP comment '时间'

) CHARACTER SET utf8 COLLATE utf8_general_ci;

drop table if exists student_source;
create table student_source(
  id bigint(10) not null auto_increment primary key comment '主键',
  name varchar(18) not null comment '学生姓名',
  object varchar(10) not null comment '学科',
  source int(10) not null  comment '分数'
) CHARACTER SET utf8 COLLATE utf8_general_ci;

