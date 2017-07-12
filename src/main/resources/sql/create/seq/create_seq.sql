--1、base_portal的LOGIN表，sequence--
create sequence RM.SEQ_LOGIN_INFO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

--2、base_portal的DIM表，sequence--
create sequence RM.SEQ_BP_DIM
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;