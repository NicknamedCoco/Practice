/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.22 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `tb_user` (
	`id` int (11),
	`username` varchar (60),
	`password` varchar (765),
	`email` varchar (150),
	`create_time` date 
); 
insert into `tb_user` (`id`, `username`, `password`, `email`, `create_time`) values('1','万一','$2a$10$MABiGr8j46xMub7P76MLeekCT90eGv0G4eYXoiLJUN/1iVbYcc8S2','506579631@qq.com','2021-05-02');
insert into `tb_user` (`id`, `username`, `password`, `email`, `create_time`) values('2','一万','$2a$10$rhVG.IGAbo8/xIWqM071W../deQoCS2SeaUuzbhYPldHBBL138/dW','one.dayinaug@gmail.com','2021-05-03');
insert into `tb_user` (`id`, `username`, `password`, `email`, `create_time`) values('3','婉儿','$2a$10$MABiGr8j46xMub7P76MLeekCT90eGv0G4eYXoiLJUN/1iVbYcc8S2','800820@qq.com','2021-05-04');
insert into `tb_user` (`id`, `username`, `password`, `email`, `create_time`) values('4','佐助','$2a$10$MABiGr8j46xMub7P76MLeekCT90eGv0G4eYXoiLJUN/1iVbYcc8S2','360430@qq.com','2021-03-01');
insert into `tb_user` (`id`, `username`, `password`, `email`, `create_time`) values('5','拿鲁多','$2a$10$MABiGr8j46xMub7P76MLeekCT90eGv0G4eYXoiLJUN/1iVbYcc8S2','778899@qq.com','2021-01-01');
insert into `tb_user` (`id`, `username`, `password`, `email`, `create_time`) values('6','撒库拉','$2a$10$MABiGr8j46xMub7P76MLeekCT90eGv0G4eYXoiLJUN/1iVbYcc8S2','33445566@qq.com','2019-01-09');
insert into `tb_user` (`id`, `username`, `password`, `email`, `create_time`) values('7','索罗','$2a$10$MABiGr8j46xMub7P76MLeekCT90eGv0G4eYXoiLJUN/1iVbYcc8S2','112233@qq.com','2021-05-21');
