#
Create
Database
# ------------------------------------------------------------
CREATE
DATABASE IF NOT EXISTS FoodIntellectualsDB DEFAULT CHARACTER SET = utf8mb4;

Use
FoodIntellectualsDB;

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User`
(
    `Id`                        int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `UnionId`                   varchar(32)  NOT NULL DEFAULT 'default' COMMENT '微信唯一ID',
    `Username`                  varchar(32)  NOT NULL DEFAULT 'default' COMMENT '用户名',
    `AvatarUrl`                 varchar(256) NOT NULL DEFAULT 'default' COMMENT '头像URL',
    PRIMARY KEY (`Id`),
    UNIQUE KEY `UK_UnionId` (`UnionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';