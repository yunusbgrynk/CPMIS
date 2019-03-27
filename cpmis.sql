DROP DATABASE  IF EXISTS `user_list_test`;

CREATE DATABASE  IF NOT EXISTS `user_list_test`;
USE `user_list_test`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` varchar(50) DEFAULT 'now()',
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact_number` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,

  
  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `user` (created_at,username,password,first_name,last_name,email,contact_number,country)
VALUES 
(now(),'yunusbgrynk','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Yunus','Bagriyanik','yunusbgrynk@gmail.com','02124567878','TR'),

(now(),'hasan','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Hasan','Bayram','hasan@yahoo.com','05302129025','TR'),

(now(),'gizem','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Gizem','Ay','gizemay@hotmail.com','05428907676','TR'),

(now(),'azra','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Azra','Yeni','azra_yeni@gmail.com','05322345656','TR'),

(now(),'mustafa','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Mustafa','Arda','mustafa@gmail.com','05315674343','TR'),

(now(),'turgut21','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Turgut','Turan','turgut@yahoo.com','05467878989','TR'),

(now(),'basak','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Basak','Icten','basak.sweety@gmail.com','05425676767','TR'),

(now(),'canan','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Canan','Kaymaz','canan@bgrynk.com','05408905454','TR'),

(now(),'duygu','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Duygu','Turk','duygu.turk@gmail.com','05559872121','TR'),

(now(),'iboli','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Ibrahim','Bagriyanik','ibrahim@yusuf.com','05542346767','TR'),

(now(),'kaan','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Kaan','Bulut','kaan@bulut.com','05592346767','TR'),

(now(),'fikret','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Fikret','Mavi','fikretmavi@yahoo.com','05542346767','TR'),

(now(),'bora','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Bora','Kemal','kemalbora@hotmail.com','05542346767','TR'),

(now(),'fikret','$2a$04$4IoAG2ggiiEdgRgl9XLqtujaBCLi3e3z2UEVQcScOayPp4Oj7.oju',
'Fikret','Mavi','fikretmavi@yahoo.com','05542346767','TR');

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` varchar(50) DEFAULT 'now()',
  `project_name` varchar(50) NOT NULL,
  `project_code` varchar(50) NOT NULL,
  `manager_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  
  KEY `FK_MANAGER_idx` (`manager_user_id`),
  CONSTRAINT `FK_MANAGER` FOREIGN KEY (`manager_user_id`) 
  REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `project`(created_at,project_name,project_code,manager_user_id)
VALUES
(now(),'OBS','88','5'),
(now(),'Company App','77','3'),
(now(),'Web App IOS','99','6');

DROP TABLE IF EXISTS `project_information`;

CREATE TABLE `project_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` varchar(50) DEFAULT 'now()',
  `description` varchar(50) NOT NULL,
  `details` char(80) NOT NULL,
  `project_status` varchar(50) NOT NULL,
  `assignee_user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  
  KEY `FK_ASSIGNEE_idx` (`assignee_user_id`),
  CONSTRAINT `FK_ASSIGNEE` FOREIGN KEY (`assignee_user_id`) 
  REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  
   KEY `FK_PROJECT_idx` (`project_id`),
   CONSTRAINT `FK_PROJECT` FOREIGN KEY (`project_id`) 
   REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `project_information`(created_at,description,details,project_status,assignee_user_id,project_id)
VALUES
(now(),'Create Database','Coming Soon','OPEN','9','1'),
(now(),'Create Domain','Coming Soon','OPEN','10','2'),
(now(),'Create Team','Coming Soon','OPEN','7','3');

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `role` (name)
VALUES 
('ROLE_EMPLOYEE'),('ROLE_MANAGER'),('ROLE_ADMIN');


DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 3),
(2, 2),
(3, 2),
(4, 1),
(5, 2),
(6, 2),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(1,1),
(2,1),
(3,1),
(5,1),
(6,1),
(11,1),
(12,1),
(13,1)


