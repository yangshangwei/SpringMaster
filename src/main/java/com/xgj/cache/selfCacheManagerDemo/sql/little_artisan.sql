--Oracle
-- Create table
create table LITTLE_ARTISAN
(
  artisan_id   VARCHAR2(64),
  artisan_name VARCHAR2(20),
  artisan_desc VARCHAR2(256)
)
tablespace TAB_CC
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );

---initData 
insert into little_artisan (ARTISAN_ID, ARTISAN_NAME, ARTISAN_DESC)
values ('AAAYbEAAZAAAK9fAAA', 'artisan', 'Spring Cache');
commit;