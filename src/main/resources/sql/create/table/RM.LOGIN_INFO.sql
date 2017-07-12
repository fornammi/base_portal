-- Create table
create table LOGIN_INFO
(
  ID         NUMBER not null,
  CODE_NO    VARCHAR2(50) not null,
  LOGIN_CODE VARCHAR2(50) not null,
  PASSWORD   VARCHAR2(50),
  STATUS     NUMBER default 1 not null
)
tablespace RM
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column LOGIN_INFO.ID
  is '主键';
comment on column LOGIN_INFO.CODE_NO
  is '特殊编号';
comment on column LOGIN_INFO.LOGIN_CODE
  is '用户名';
comment on column LOGIN_INFO.PASSWORD
  is '密码';
comment on column LOGIN_INFO.STATUS
  is '状态：0禁用，1可用，2删除';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LOGIN_INFO
  add constraint PK_LOGIN_INFO primary key (ID)
  using index 
  tablespace RM
  pctfree 10
  initrans 2
  maxtrans 255;
alter table LOGIN_INFO
  add constraint UK_CODE_NO unique (CODE_NO)
  using index 
  tablespace RM
  pctfree 10
  initrans 2
  maxtrans 255;
alter table LOGIN_INFO
  add constraint UK_LOGIN_CODE unique (LOGIN_CODE)
  using index 
  tablespace RM
  pctfree 10
  initrans 2
  maxtrans 255;