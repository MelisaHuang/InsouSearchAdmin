/*插数据*/


select table_name from information_schema.tables where table_schema='insouadmin' and table_type='base table';

desc insouuser;
desc adminuser;
desc keyword;


/*insouuser表*/  
/*注意单引号的格式！*/
desc insouuser;
insert into `insouuser` (`iu_id`, `iu_name`, `iu_password`, `iu_sex`, `iu_age`,`iu_job`) 
                  values(default,'汪伏丹','123',1,'16','学生');		
insert into `insouuser` (`iu_id`, `iu_name`, `iu_password`, `iu_sex`, `iu_age`,`iu_job`) 
                  values(default,'李致远','123',0,'20','学生');		
insert into `insouuser` (`iu_id`, `iu_name`, `iu_password`, `iu_sex`, `iu_age`,`iu_job`) 
                  values(default,'梁信军','123',0,'20','学生');
insert into `insouuser` (`iu_id`, `iu_name`, `iu_password`, `iu_sex`, `iu_age`,`iu_job`) 
                  values(default,'林洽全','123',0,'20','学生');		
insert into `insouuser` (`iu_id`, `iu_name`, `iu_password`, `iu_sex`, `iu_age`,`iu_job`) 
                  values(default,'黄芳','123',1,'16','学生');
insert into `insouuser` (`iu_id`, `iu_name`, `iu_password`, `iu_sex`, `iu_age`,`iu_job`) 
                  values(default,'邓爱珠','123',1,'16','学生');
insert into `insouuser` (`iu_id`, `iu_name`, `iu_password`, `iu_sex`, `iu_age`,`iu_job`) 
                  values(default,'sb','123',null,null,null);
			
update insouuser set iu_email = "111111111@qq.com" where iu_id =1;
update insouuser set iu_email = "111111111@qq.com" where iu_id =2;
update insouuser set iu_email = "111111111@qq.com" where iu_id =3;
update insouuser set iu_email = "111111111@qq.com" where iu_id =4;
update insouuser set iu_email = "111111111@qq.com" where iu_id =5;
update insouuser set iu_email = "111111111@qq.com" where iu_id =6;
update insouuser set iu_email = "111111111@qq.com" where iu_id =7;
							  			  
select * from insouuser;




desc competence;
insert into `competence` (`c_id`, `c_name`) 
                  values(default,'全部权限');
insert into `competence` (`c_id`, `c_name`) 
                  values(default,'insou用户管理');
insert into `competence` (`c_id`, `c_name`) 
                  values(default,'爬虫管理');
insert into `competence` (`c_id`, `c_name`) 
                  values(default,'搜索数据管理');
insert into `competence` (`c_id`, `c_name`) 
                  values(default,'索引管理');
insert into `competence` (`c_id`, `c_name`) 
                  values(default,'后台用户管理');	
select * from competence;


desc role;
insert into `role` (`r_id`, `c_id`,`r_name`) 
                  values(default,6,'管理人员');
insert into `role` (`r_id`, `c_id`,`r_name`) 
                  values(default,3,'开发人员');
select * from role;



/*admininsou表*/  
/*注意单引号的格式！*/
desc adminuser;
insert into `adminuser` (`au_id`,`r_id`, `au_name`,`au_password`) 
                  values(default,1,'sb','123');	
insert into `adminuser` (`au_id`,`r_id`, `au_name`,`au_password`) 
                  values(default,1,'lzy','123');	
select * from adminuser;


/*keywrod表*/  
/*注意单引号的格式！*/
desc keyword;
insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`) 
                  values(default,'时装',default,default,'C:\Users\thinkpad\ziliao\搜索引擎\搜索图片\百度图片_时装');	
update keyword set k_searchRange = default where k_id =1;
insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`) 
                  values(default,'男装',default,default,'C:\Users\thinkpad\ziliao\搜索引擎\搜索图片\百度图片_男装');	
insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`) 
                  values(default,'女装',default,default,'C:\Users\thinkpad\ziliao\搜索引擎\搜索图片\百度图片_女装');
insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`) 
                  values(default,'美女',default,default,default);
insert into `keyword` (`k_name`) 
                  values('帅哥');
insert into `keyword` (`k_name`) 
                  values('欧美街拍');
insert into `keyword` (`k_name`) 
                  values('日韩街拍');
insert into `keyword` (`k_name`) 
                  values('时尚街拍');
insert into `keyword` (`k_name`) 
                  values('服装设计师');
insert into `keyword` (`k_name`) 
                  values('牛仔裤');
insert into `keyword` (`k_name`) 
                  values('卫衣');
insert into `keyword` (`k_name`) 
                  values('短裙');
insert into `keyword` (`k_name`) 
                  values('长裙');
insert into `keyword` (`k_name`) 
                  values('欧美街拍男');
insert into `keyword` (`k_name`) 
                  values('欧美时装周');
insert into `keyword` (`k_name`) 
                  values('欧美性感美女');
insert into `keyword` (`k_name`) 
                  values('古驰');
insert into `keyword` (`k_name`) 
                  values('香奈儿');
insert into `keyword` (`k_name`) 
                  values('奢侈包包');
insert into `keyword` (`k_name`) 
                  values('奢侈logo');
insert into `keyword` (`k_name`) 
                  values('模特');
insert into `keyword` (`k_name`) 
                  values('维密');

insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`,`k_noPassReason`) 
                  values(default,'蛤蛤',0,default,default,'政治敏感');
insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`,`k_noPassReason`) 
                  values(default,'江泽民',0,default,default,'政治敏感');
insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`,`k_noPassReason`) 
                  values(default,'习近平',0,default,default,'政治敏感');
insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`,`k_noPassReason`) 
                  values(default,'李克强',0,default,default,'政治敏感');
insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`,`k_noPassReason`) 
                  values(default,'黄图',0,default,default,'暴力色情');
insert into `keyword` (`k_id`,`k_name`, `k_passOrNot`,`k_searchRange`,`k_localPath`,`k_noPassReason`) 
                  values(default,'啪啪啪',0,default,default,'暴力色情');

select * from keyword where k_name ='男装';		
		
select * from keyword;


	