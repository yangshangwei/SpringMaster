----------DATABASE£ºORACLE----------


-- Create table
create table STUDENT
(
  id   NUMBER not null,
  name VARCHAR2(50),
  age  NUMBER,
  sex  VARCHAR2(20)
)
tablespace TAB_CC
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table STUDENT
  add constraint STUDENT_ID primary key (ID)
  using index 
  tablespace TAB_CC
  pctfree 10
  initrans 2
  maxtrans 255;

=========================================


-- Create table
create table TEACHER
(
  id        NUMBER not null,
  name      VARCHAR2(50),
  age       NUMBER,
  sex       VARCHAR2(20),
  studentid NUMBER
)
tablespace TAB_CC
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table TEACHER
  add constraint TEACHER_ID primary key (ID)
  using index 
  tablespace TAB_CC
  pctfree 10
  initrans 2
  maxtrans 255;
alter table TEACHER
  add constraint FK_STUDENT_ID foreign key (STUDENTID)
  references STUDENT (ID);
  
  
  

  
  
 ============================================
 
 
 -- Create sequence 
create sequence STUDENT_ID_SEQ
minvalue 0
maxvalue 999
start with 0
increment by 1
cache 20;


create sequence TEACHER_ID_SEQ
minvalue 0
maxvalue 999
start with 0
increment by 1
cache 20;
 
