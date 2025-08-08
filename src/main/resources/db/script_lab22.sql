create database if not exists student_management;
use student_management;
create table student(
Id int primary key auto_increment,
name varchar(50),
phone varchar(20),
address varchar(70),
email varchar(20)
); 
INSERT INTO student (name, phone, address, email) VALUES('Alice Nguyen', '0901234567', '123 Le Loi, Da Nang', 'alice@example.com'),
  ('Bao Tran', '0912345678', '456 Nguyen Trai, Hanoi', 'bao.tran@example.com'),
  ('Chi Pham', '0933456789', '789 Le Duan, Ho Chi Minh City', 'chi.pham@example.com'),
  ('Duy Vo', '0944567890', '12 Tran Hung Dao, Hue', 'duy.vo@example.com'),
  ('Emma Le', '0955678901', '99 Phan Chu Trinh, Can Tho', 'emma.le@example.com');
                                                   
 
