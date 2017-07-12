/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.40-community : Database - ospm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ospm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ospm`;

/*Table structure for table `login_info` */

DROP TABLE IF EXISTS `login_info`;

CREATE TABLE `login_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_no` varchar(50) DEFAULT NULL COMMENT '特殊编号',
  `login_code` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：0禁用，1可用，2删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`login_code`),
  UNIQUE KEY `unique` (`code_no`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `login_info` */

insert  into `login_info`(`id`,`code_no`,`login_code`,`password`,`status`) values (1,'LOGIN-0001','admin','50565y5q2b92b9b2265q2b5s2b550ye6',1),(41,NULL,'kaka','9920e2l9b56e6ql562b9sybs6655s556',0),(42,NULL,'iteye','2eseby9ls2s52b252s692526526elsle',0);

/*Table structure for table `login_x_org` */

DROP TABLE IF EXISTS `login_x_org`;

CREATE TABLE `login_x_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_no` varchar(50) DEFAULT NULL,
  `login_id` int(11) NOT NULL,
  `org_id` int(11) NOT NULL,
  `status` int(11) DEFAULT '1' COMMENT '状态：0禁用，1可用，2删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code_no`),
  KEY `FK63094247A45A7DA0` (`id`),
  KEY `FK63094247CD9086C0` (`id`),
  KEY `FK63094247683B18DB` (`org_id`),
  KEY `FK6309424746215756` (`login_id`),
  CONSTRAINT `FK6309424746215756` FOREIGN KEY (`login_id`) REFERENCES `login_info` (`id`),
  CONSTRAINT `FK63094247683B18DB` FOREIGN KEY (`org_id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK63094247A45A7DA0` FOREIGN KEY (`id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK63094247CD9086C0` FOREIGN KEY (`id`) REFERENCES `login_info` (`id`),
  CONSTRAINT `FK_login_x_org_loginId` FOREIGN KEY (`login_id`) REFERENCES `login_info` (`id`),
  CONSTRAINT `FK_login_x_org_orgId` FOREIGN KEY (`org_id`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `login_x_org` */

insert  into `login_x_org`(`id`,`code_no`,`login_id`,`org_id`,`status`) values (1,'LXO-0001',1,1,1);

/*Table structure for table `login_x_priv` */

DROP TABLE IF EXISTS `login_x_priv`;

CREATE TABLE `login_x_priv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_no` varchar(50) DEFAULT NULL,
  `login_id` int(11) NOT NULL,
  `priv_id` int(11) NOT NULL,
  `status` int(11) DEFAULT '1' COMMENT '状态：0禁用，1可用，2删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code_no`),
  KEY `FK_login_x_priv_loginI` (`login_id`),
  KEY `FK_login_x_priv_privId` (`priv_id`),
  KEY `FKFE1F7BACD60A91BA` (`id`),
  KEY `FKFE1F7BACCD9086C0` (`id`),
  KEY `FKFE1F7BACC34BA14A` (`priv_id`),
  KEY `FKFE1F7BAC46215756` (`login_id`),
  CONSTRAINT `FKFE1F7BAC46215756` FOREIGN KEY (`login_id`) REFERENCES `login_info` (`id`),
  CONSTRAINT `FKFE1F7BACC34BA14A` FOREIGN KEY (`priv_id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `FKFE1F7BACCD9086C0` FOREIGN KEY (`id`) REFERENCES `login_info` (`id`),
  CONSTRAINT `FKFE1F7BACD60A91BA` FOREIGN KEY (`id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `FK_login_x_priv_loginId` FOREIGN KEY (`login_id`) REFERENCES `login_info` (`id`),
  CONSTRAINT `FK_login_x_priv_privId` FOREIGN KEY (`priv_id`) REFERENCES `privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `login_x_priv` */

insert  into `login_x_priv`(`id`,`code_no`,`login_id`,`priv_id`,`status`) values (1,'LXP',1,1,1);

/*Table structure for table `login_x_role` */

DROP TABLE IF EXISTS `login_x_role`;

CREATE TABLE `login_x_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_no` varchar(50) DEFAULT NULL,
  `login_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态：0禁用，1可用，2删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code_no`),
  KEY `FK_login_x_role_loginId` (`login_id`),
  KEY `FK_login_x_role_roleId` (`role_id`),
  KEY `FKFE205973302482E3` (`id`),
  KEY `FKFE205973CD9086C0` (`id`),
  KEY `FKFE20597382360B4C` (`role_id`),
  KEY `FKFE20597346215756` (`login_id`),
  CONSTRAINT `FKFE205973302482E3` FOREIGN KEY (`id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKFE20597346215756` FOREIGN KEY (`login_id`) REFERENCES `login_info` (`id`),
  CONSTRAINT `FKFE20597382360B4C` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKFE205973CD9086C0` FOREIGN KEY (`id`) REFERENCES `login_info` (`id`),
  CONSTRAINT `FK_login_x_role_loginId` FOREIGN KEY (`login_id`) REFERENCES `login_info` (`id`),
  CONSTRAINT `FK_login_x_role_roleId` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `login_x_role` */

insert  into `login_x_role`(`id`,`code_no`,`login_id`,`role_id`,`status`) values (1,'LXR',1,1,NULL);

/*Table structure for table `organization` */

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_no` varchar(50) DEFAULT NULL,
  `org_name` varchar(50) DEFAULT NULL COMMENT '组织名',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点',
  `org_type` int(11) DEFAULT '0' COMMENT '组织类型：0公司，1部门，2职位',
  `description` varchar(1000) DEFAULT NULL COMMENT '简介',
  `status` int(11) DEFAULT '1' COMMENT '状态：0禁用，1启用，2删除',
  `is_leaf` int(11) DEFAULT '1' COMMENT '叶子节点：0为非，1为是',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code_no`),
  KEY `FK4644ED33A45A7DA0` (`id`),
  KEY `FK4644ED331FC12155` (`parent_id`),
  CONSTRAINT `FK4644ED331FC12155` FOREIGN KEY (`parent_id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK4644ED33A45A7DA0` FOREIGN KEY (`id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK_organization_parentId` FOREIGN KEY (`parent_id`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `organization` */

insert  into `organization`(`id`,`code_no`,`org_name`,`parent_id`,`org_type`,`description`,`status`,`is_leaf`) values (1,'ORG-0001','总组织架构',NULL,0,'总的组织架构',1,1);

/*Table structure for table `priv_x_org` */

DROP TABLE IF EXISTS `priv_x_org`;

CREATE TABLE `priv_x_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_no` varchar(50) DEFAULT NULL,
  `org_id` int(11) NOT NULL,
  `priv_id` int(11) NOT NULL,
  `extra_data` int(11) DEFAULT '1' COMMENT '反权限：0为反，1为正',
  `status` int(11) DEFAULT '1' COMMENT '状态：0禁用，1可用，2删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code_no`),
  KEY `FK8CF9E90DD60A91BA` (`id`),
  KEY `FK8CF9E90DA45A7DA0` (`id`),
  KEY `FK8CF9E90DC34BA14A` (`priv_id`),
  KEY `FK8CF9E90D683B18DB` (`org_id`),
  CONSTRAINT `FK8CF9E90D683B18DB` FOREIGN KEY (`org_id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK8CF9E90DA45A7DA0` FOREIGN KEY (`id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK8CF9E90DC34BA14A` FOREIGN KEY (`priv_id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `FK8CF9E90DD60A91BA` FOREIGN KEY (`id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `FK_priv_x_org_orgId` FOREIGN KEY (`org_id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK_priv_x_org_privId` FOREIGN KEY (`priv_id`) REFERENCES `privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `priv_x_org` */

insert  into `priv_x_org`(`id`,`code_no`,`org_id`,`priv_id`,`extra_data`,`status`) values (1,'PXO',1,1,1,1);

/*Table structure for table `privilege` */

DROP TABLE IF EXISTS `privilege`;

CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `priv_name` varchar(50) NOT NULL COMMENT '权限名',
  `tag_name` varchar(50) DEFAULT NULL COMMENT '页面对应标签名',
  `tag_attrname` varchar(50) DEFAULT NULL COMMENT '控制权限的属性',
  `tag_attrvalue` varchar(50) DEFAULT NULL COMMENT '属性值',
  `action_url` varchar(500) DEFAULT NULL COMMENT '访问路径',
  `description` varchar(1000) DEFAULT NULL COMMENT '简介',
  `status` int(11) DEFAULT '1' COMMENT '状态：0禁用，1可用，2删除',
  `code_no` varchar(50) DEFAULT NULL COMMENT '特殊标识',
  `is_leaf` int(11) DEFAULT '1' COMMENT '叶子节点：0为非，1为是',
  `parent_id` int(11) NOT NULL COMMENT '父节点',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `privilege` */

insert  into `privilege`(`id`,`priv_name`,`tag_name`,`tag_attrname`,`tag_attrvalue`,`action_url`,`description`,`status`,`code_no`,`is_leaf`,`parent_id`) values (1,'总权限',NULL,NULL,NULL,NULL,'拥有所有的权限',1,'PRIV-0001',1,0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_no` varchar(50) DEFAULT NULL COMMENT '特殊编号',
  `role_name` varchar(50) NOT NULL COMMENT '角色名',
  `parent_id` int(11) DEFAULT NULL COMMENT '父ID，根ID为0',
  `description` varchar(1000) DEFAULT NULL COMMENT '简介',
  `status` int(11) DEFAULT '1' COMMENT '角色状态：0为禁用，1为可用，2为删除',
  `is_leaf` int(11) DEFAULT '1' COMMENT '叶子节点：0为非，1为是',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code_no`),
  KEY `FK_role_parentId` (`parent_id`),
  KEY `FK358076302482E3` (`id`),
  KEY `FK358076AB8B2698` (`parent_id`),
  CONSTRAINT `FK358076302482E3` FOREIGN KEY (`id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK358076AB8B2698` FOREIGN KEY (`parent_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_role_parentId` FOREIGN KEY (`parent_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `role` */

insert  into `role`(`id`,`code_no`,`role_name`,`parent_id`,`description`,`status`,`is_leaf`) values (1,'ROLE-0001','总角色',NULL,'是所有的角色',1,1);

/*Table structure for table `role_x_priv` */

DROP TABLE IF EXISTS `role_x_priv`;

CREATE TABLE `role_x_priv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_no` varchar(50) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `priv_id` int(11) NOT NULL,
  `extra_data` int(11) NOT NULL DEFAULT '1' COMMENT '反权限标识：0为反，1为正',
  `status` int(11) DEFAULT '1' COMMENT '状态：0禁用，1可用，2删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code_no`),
  KEY `FK_role_x_priv_roleId` (`role_id`),
  KEY `FK_role_x_priv_privId` (`priv_id`),
  KEY `FK360A11FF302482E3` (`id`),
  KEY `FK360A11FFD60A91BA` (`id`),
  KEY `FK360A11FFC34BA14A` (`priv_id`),
  KEY `FK360A11FF82360B4C` (`role_id`),
  CONSTRAINT `FK360A11FF302482E3` FOREIGN KEY (`id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK360A11FF82360B4C` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK360A11FFC34BA14A` FOREIGN KEY (`priv_id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `FK360A11FFD60A91BA` FOREIGN KEY (`id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `FK_role_x_priv_privId` FOREIGN KEY (`priv_id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `FK_role_x_priv_roleId` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `role_x_priv` */

insert  into `role_x_priv`(`id`,`code_no`,`role_id`,`priv_id`,`extra_data`,`status`) values (1,'RXP',1,1,1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
