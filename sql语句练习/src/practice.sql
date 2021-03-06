use practice;
drop table if exists employ;
create table employ (
    id int primary key auto_increment,
    name varchar(20),
    age  int  ,
    address varchar(90) not null ,
    salary decimal(5,2),
    sex char(3)
);
select  * from employ;
desc employ;

insert into employ values (null,'张三',26,'陕西西安',988.56,'男'),
                          (null,'蔡文姬',23,'陕西咸阳',876.99,'女'),
                          (null,'张飞',45,'山西郓城',678.88,'男'),
                          (null,'安琪拉',21,'火星',999.00,'女');
select * from employ;
select * from employ order by salary desc;
select sex,AVG(salary) from employ group by sex;
select * from employees order by hire_date desc limit 1 offset 2;
