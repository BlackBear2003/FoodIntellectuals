#
# Create
# Database
# ------------------------------------------------------------
CREATE
DATABASE IF NOT EXISTS FoodIntellectualsDB DEFAULT CHARACTER SET = utf8mb4;

Use
FoodIntellectualsDB;

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User`
(
    `Id`        int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `UnionId`   varchar(32)  NOT NULL DEFAULT 'default' COMMENT '微信唯一ID',
    `Username`  varchar(32)  NOT NULL DEFAULT 'default' COMMENT '用户名',
    `AvatarUrl` varchar(256) NOT NULL DEFAULT 'default' COMMENT '头像URL',
    `Gender`    varchar(32)  NOT NULL DEFAULT 'default' COMMENT '性别',
    PRIMARY KEY (`Id`),
    UNIQUE KEY `UK_UnionId` (`UnionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


DROP TABLE IF EXISTS `UserFoodCollect`;

CREATE TABLE `UserFoodCollect`
(
    `Id`     int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `UserId` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '用户ID',
    `FoodId` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '被收藏菜品ID',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户收藏菜品表';


DROP TABLE IF EXISTS `Canteen`;

CREATE TABLE `Canteen`
(
    `Id`          int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `CanteenName` varchar(32)  NOT NULL DEFAULT 'default' COMMENT '食堂名称',
    `Intro`       varchar(128) NOT NULL DEFAULT 'default' COMMENT '食堂介绍',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='食堂表';


DROP TABLE IF EXISTS `Store`;

CREATE TABLE `Store`
(
    `Id`        int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `CanteenId` int(10) unsigned NOT NULL COMMENT '食堂ID',
    `StoreName` varchar(32)  NOT NULL DEFAULT 'default' COMMENT '店铺名称',
    `Intro`     varchar(128) NOT NULL DEFAULT 'default' COMMENT '店铺介绍、位置',
    `Location`  varchar(128) NOT NULL DEFAULT 'default' COMMENT '店铺介绍、位置',
    `Tag`       varchar(32)  NOT NULL DEFAULT '' COMMENT '店铺Tag名称',
    `ImgUrl`    varchar(256) NOT NULL DEFAULT 'default' COMMENT '图片URL',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='店铺表';


DROP TABLE IF EXISTS `Food`;

CREATE TABLE `Food`
(
    `Id`       int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `StoreId`  int(10) unsigned NOT NULL DEFAULT 0 COMMENT '店铺ID',
    `FoodName` varchar(32)    NOT NULL DEFAULT 'default' COMMENT '菜品名称',
    `Price`    DECIMAL(10, 2) NOT NULL DEFAULT 0.0 COMMENT '菜品介绍、位置',
    `Intro`    varchar(128)   NOT NULL DEFAULT 'default' COMMENT '菜品介绍、位置',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜品表';


DROP TABLE IF EXISTS `FoodTag`;
CREATE TABLE `FoodTag`
(
    `Id`      int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `FoodId`  int(10) unsigned NOT NULL DEFAULT 0 COMMENT '食品ID',
    `TagId`   int(10) unsigned NOT NULL DEFAULT 0 COMMENT 'tag ID',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜品Tag关联表';


DROP TABLE IF EXISTS `Tag`;
CREATE TABLE `Tag`
(
    `Id`      int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `TagType` tinyint unsigned NOT NULL DEFAULT 0 COMMENT 'Tag类型，0代表种类tag 1代表口味tag',
    `TagName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Tag名称',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tag表';


DROP TABLE IF EXISTS `Review`;

CREATE TABLE `Review`
(
    `Id`            int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `StoreId`       int(10) unsigned NOT NULL DEFAULT 0 COMMENT '店铺ID',
    `FoodId`        int(10) unsigned NOT NULL DEFAULT 0 COMMENT '食品ID',
    `UserId`        int(10) unsigned NOT NULL DEFAULT 0 COMMENT '用户ID',
    `Content`       varchar(256) NOT NULL DEFAULT 'default' COMMENT '点评内容',
    `StoreScore`    tinyint unsigned NOT NULL DEFAULT 5 COMMENT '对店铺评分（总评）',
    `AttitudeScore` tinyint unsigned NOT NULL DEFAULT 5 COMMENT '店铺态度评分',
    `FoodScore`     tinyint unsigned NOT NULL DEFAULT 5 COMMENT '对菜品评分（总评）',
    `WaitTimeScore` tinyint unsigned NOT NULL DEFAULT 5 COMMENT '菜品等待时间评分',
    `FlavorScore`   tinyint unsigned NOT NULL DEFAULT 5 COMMENT '菜品口味评分',
    `ReviewTime`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评分时间',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='点评表';


DROP TABLE IF EXISTS `ReviewLike`;

CREATE TABLE `ReviewLike`
(
    `Id`       int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `ReviewId` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '点评ID',
    `UserId`   int(10) unsigned NOT NULL DEFAULT 0 COMMENT '用户ID',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='点评点赞表';


DROP TABLE IF EXISTS `StoreLike`;

CREATE TABLE `StoreLike`
(
    `Id`      int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `StoreId` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '店铺ID',
    `UserId`  int(10) unsigned NOT NULL DEFAULT 0 COMMENT '用户ID',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='店铺点赞表';


DROP TABLE IF EXISTS `FoodLike`;

CREATE TABLE `FoodLike`
(
    `Id`      int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `FoodId`  int(10) unsigned NOT NULL DEFAULT 0 COMMENT '菜品ID',
    `UserId`  int(10) unsigned NOT NULL DEFAULT 0 COMMENT '用户ID',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜品点赞表';


DROP TABLE IF EXISTS `ReviewDislike`;

CREATE TABLE `ReviewDislike`
(
    `Id`       int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `ReviewId` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '点评ID',
    `UserId`   int(10) unsigned NOT NULL DEFAULT 0 COMMENT '用户ID',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='点评点踩表';


DROP TABLE IF EXISTS `StoreDislike`;

CREATE TABLE `StoreDislike`
(
    `Id`      int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `StoreId` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '店铺ID',
    `UserId`  int(10) unsigned NOT NULL DEFAULT 0 COMMENT '用户ID',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='店铺点踩表';


DROP TABLE IF EXISTS `Image`;

CREATE TABLE `Image`
(
    `Id`         int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `Url`        varchar(256) NOT NULL DEFAULT 'default' COMMENT 'URL',
    `BelongType` varchar(256) NOT NULL DEFAULT 'default' COMMENT '表示图片属于哪个实体类，在Java中使用Enum规范{Canteen, Store, Food, Review}',
    `BelongId`   int(10) unsigned NOT NULL DEFAULT 0 COMMENT '表示图片属于哪个实体对象',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='点评点赞表';


