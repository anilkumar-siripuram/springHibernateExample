CREATE TABLE Employee(
   id   INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(20) NOT NULL,
   JOINING_DATE  VARCHAR(20) NOT NULL,
   Gender varchar(20),
   SALARY int NOT NULL,
   SSN VARCHAR(20) NOT NULL,
   isDeleteInd varchar(1),
   PRIMARY KEY (id)
);


insert into Employee values(1,'Anil',17-11-1993,'M',10000,'505451','y');

insert into Employee values(2,'Kishore',21-11-1990,'M',150000,'505452','y');