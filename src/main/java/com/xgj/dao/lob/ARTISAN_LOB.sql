-- ORACLE ½Å±¾
-- Create table
create table ARTISAN_LOB
(
  artisan_id varchar2(50),
  artisan_detail CLOB,
  artisan_attach BLOB
)
tablespace TAB_CC
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );