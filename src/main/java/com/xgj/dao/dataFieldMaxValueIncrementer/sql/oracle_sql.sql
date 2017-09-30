--Oracle Sql



-- Create table
create table ARTISAN
(
  artisan_id    NUMBER,
  artisan_name  VARCHAR2(50)
)
tablespace TAB_CC
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16
    next 8
    minextents 1
    maxextents unlimited
  );
  
  
-- Create sequence 
create sequence artisan_id_seq
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;




