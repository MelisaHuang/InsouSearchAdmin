/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/11/30 20:39:58                          */
/*==============================================================*/


DROP TABLE IF EXISTS InsouUser;

DROP TABLE IF EXISTS adminKeyword;

DROP TABLE IF EXISTS adminSearchFouncton;

DROP TABLE IF EXISTS adminSortFunction;

DROP TABLE IF EXISTS adminUser;

DROP TABLE IF EXISTS adminwd;

DROP TABLE IF EXISTS competence;

DROP TABLE IF EXISTS keyword;

DROP TABLE IF EXISTS roel;

DROP TABLE IF EXISTS searchFunction;

DROP TABLE IF EXISTS sortFunction;

DROP TABLE IF EXISTS tag;

DROP TABLE IF EXISTS wasteUrl;

/*==============================================================*/
/* Table: InsouUser                                             */
/*==============================================================*/
CREATE TABLE InsouUser
(
   iu_id                INT NOT NULL AUTO_INCREMENT,
   iu_name              VARCHAR(15),
   iu_password          VARCHAR(30),
   iu_sex               BOOL,
   iu_age               INT,
   iu_job               VARCHAR(20),
   PRIMARY KEY (iu_id)
);
  


/*==============================================================*/
/* Table: adminKeyword                                          */
/*==============================================================*/
CREATE TABLE adminKeyword
(
   k_id                 INT NOT NULL ,
   au_id                INT NOT NULL ,
   PRIMARY KEY (k_id, au_id)
);

/*==============================================================*/
/* Table: adminSearchFouncton                                   */
/*==============================================================*/
CREATE TABLE adminSearchFouncton
(
   sef_id              INT NOT NULL ,
   au_id               INT NOT NULL ,
   PRIMARY KEY (sef_id, au_id)
);

/*==============================================================*/
/* Table: adminSortFunction                                     */
/*==============================================================*/
CREATE TABLE adminSortFunction
(
   sortf_id             INT NOT NULL ,
   au_id                INT NOT NULL ,
   PRIMARY KEY (sortf_id, au_id)
);

/*==============================================================*/
/* Table: adminUser                                             */
/*==============================================================*/
CREATE TABLE adminUser
(
   au_id                INT NOT NULL AUTO_INCREMENT,
   r_id                 INT,
   au_name              VARCHAR(15),
   au_password          VARCHAR(30),
   PRIMARY KEY (au_id)
);

/*==============================================================*/
/* Table: adminwd                                               */
/*==============================================================*/
CREATE TABLE adminwd
(
   au_id                INT NOT NULL ,
   wu_id                INT NOT NULL ,
   PRIMARY KEY (au_id, wu_id)
);

/*==============================================================*/
/* Table: competence                                            */
/*==============================================================*/
CREATE TABLE competence
(
   c_id                 INT NOT NULL AUTO_INCREMENT ,
   c_name               VARCHAR(20),
   PRIMARY KEY (c_id)
);

/*==============================================================*/
/* Table: keyword                                               */
/*==============================================================*/
CREATE TABLE keyword
(
   k_id                INT NOT NULL AUTO_INCREMENT,
   k_name               VARCHAR(50),
   k_passOrNot          BOOL,
   k_searchRange        INT,
   K_localPath          VARCHAR(80),
   PRIMARY KEY (k_id)
);


/*==============================================================*/
/* Table: role                                                 */
/*==============================================================*/
CREATE TABLE role
(
   r_id                 INT NOT NULL AUTO_INCREMENT,
   c_id                 INT,
   r_name               VARCHAR(15),
   PRIMARY KEY (r_id)
);

/*==============================================================*/
/* Table: searchFunction                                        */
/*==============================================================*/
CREATE TABLE searchFunction
(
   sef_id               INT NOT NULL AUTO_INCREMENT,
   sef_name             VARCHAR(15),
   sef_type             VARCHAR(15),
   PRIMARY KEY (sef_id)
);

/*==============================================================*/
/* Table: sortFunction                                          */
/*==============================================================*/
CREATE TABLE sortFunction
(
   sortf_id             INT NOT NULL AUTO_INCREMENT,
   sortf_name           VARCHAR(15),
   sortf_type           VARCHAR(15),
   PRIMARY KEY (sortf_id)
);

/*==============================================================*/
/* Table: tag                                                   */
/*==============================================================*/
CREATE TABLE tag
(
   t_id                 INT NOT NULL AUTO_INCREMENT,
   au_id                VARCHAR(6),
   iu_id                VARCHAR(6),
   t_name               VARCHAR(20),
   t_type               VARCHAR(20),
   PRIMARY KEY (t_id)
);

/*==============================================================*/
/* Table: wasteUrl                                              */
/*==============================================================*/
CREATE TABLE wasteUrl
(
   wu_id                INT NOT NULL AUTO_INCREMENT,
   wu_type              VARCHAR(15),
   wu_url               VARCHAR(100),
   PRIMARY KEY (wu_id)
);



ALTER TABLE adminKeyword ADD CONSTRAINT FK_adminKeyword FOREIGN KEY (k_id)
      REFERENCES keyword (k_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE adminKeyword ADD CONSTRAINT FK_adminKeyword2 FOREIGN KEY (au_id)
      REFERENCES adminUser (au_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE adminSearchFouncton ADD CONSTRAINT FK_adminSearchFouncton FOREIGN KEY (sef_id)
      REFERENCES searchFunction (sef_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE adminSearchFouncton ADD CONSTRAINT FK_adminSearchFouncton2 FOREIGN KEY (au_id)
      REFERENCES adminUser (au_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE adminSortFunction ADD CONSTRAINT FK_adminSortFunction FOREIGN KEY (sortf_id)
      REFERENCES sortFunction (sortf_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE adminSortFunction ADD CONSTRAINT FK_adminSortFunction2 FOREIGN KEY (au_id)
      REFERENCES adminUser (au_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE adminUser ADD CONSTRAINT FK_adminRole_User FOREIGN KEY (r_id)
      REFERENCES role (r_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE adminwd ADD CONSTRAINT FK_adminwd FOREIGN KEY (au_id)
      REFERENCES adminUser (au_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE adminwd ADD CONSTRAINT FK_adminwd2 FOREIGN KEY (wu_id)
      REFERENCES wasteUrl (wu_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE role ADD CONSTRAINT FK_adminRole_Competence FOREIGN KEY (c_id)
      REFERENCES competence (c_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

/*有问题！*/
ALTER TABLE tag ADD CONSTRAINT FK_selectTag FOREIGN KEY (iu_id)
      REFERENCES InsouUser (iu_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
/*有问题！*/
ALTER TABLE tag ADD CONSTRAINT FK_setTag FOREIGN KEY (au_id)
      REFERENCES adminUser (au_id) ON DELETE RESTRICT ON UPDATE RESTRICT;


SELECT table_name FROM information_schema.tables WHERE table_schema='insouadmin' AND table_type='base table';

DESC insouuser;
DESC tag;
