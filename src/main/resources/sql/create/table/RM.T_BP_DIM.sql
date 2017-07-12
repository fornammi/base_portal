-- Create table
create table RM.T_BP_DIM
(
  DIM_ID              NUMBER not null,
  DIMGROUP_ID         NUMBER,
  NAME                VARCHAR2(256),
  PARENTHESES         VARCHAR2(3),
  DIM_ITEM_ID         NUMBER,
  CALCULATEID         VARCHAR2(1),
  CALCULATEVALUE      VARCHAR2(20),
  OPERATOR_COMPARE    VARCHAR2(15),
  DIM_ITEM_VALUE      VARCHAR2(384),
  DIM_ITEM_COMPARE_ID NUMBER,
  OPERATOR_LOGIC      VARCHAR2(9),
  STATUS              CHAR(1),
  CREATE_USER         VARCHAR2(32),
  CREATE_DATE         DATE,
  UPDATE_DATE         DATE
  
)
tablespace RM;
-- Add comments to the table 
comment on table RM.T_BP_DIM
  is '规则配置DIM表';
-- Add comments to the columns 
comment on column RM.T_BP_DIM.DIM_ID
  is 'ID';
comment on column RM.T_BP_DIM.DIMGROUP_ID
  is 'DIMGROUP_ID';
comment on column RM.T_BP_DIM.NAME
  is 'Dim判断名称';
comment on column RM.T_BP_DIM.PARENTHESES
  is '括号';
comment on column RM.T_BP_DIM.DIM_ITEM_ID
  is 'Dim项';
comment on column RM.T_BP_DIM.CALCULATEID
  is '表达式右边阀值比较前的计算符号';
comment on column RM.T_BP_DIM.CALCULATEVALUE
  is '表达式右边阀值比较前的计算值';
comment on column RM.T_BP_DIM.OPERATOR_COMPARE
  is '操作符';
comment on column RM.T_BP_DIM.DIM_ITEM_VALUE
  is '比对值';
comment on column RM.T_BP_DIM.DIM_ITEM_COMPARE_ID
  is '比对DIM项';
comment on column RM.T_BP_DIM.OPERATOR_LOGIC
  is '判断关系符';
comment on column RM.T_BP_DIM.STATUS
  is '状态';
comment on column RM.T_BP_DIM.CREATE_USER
  is '创建人';
comment on column RM.T_BP_DIM.CREATE_DATE
  is '创建日期';
comment on column RM.T_BP_DIM.UPDATE_DATE
  is '最后更新时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table RM.T_BP_DIM
  add constraint PK_T_BP_DIM primary key (DIM_ID)
  using index 
  tablespace RM;