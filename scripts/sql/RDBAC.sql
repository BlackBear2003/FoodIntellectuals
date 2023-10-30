CREATE
DATABASE IF NOT EXISTS RDBAC DEFAULT CHARACTER SET = utf8mb4;

Use
RDBAC;

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User`
(
    `Id`       int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `Username` varchar(32) NOT NULL DEFAULT 'default' COMMENT '用户名',
    `Password` varchar(32) NOT NULL DEFAULT 'default' COMMENT '密码',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


DROP TABLE IF EXISTS `Role`;

CREATE TABLE `Role`
(
    `Id`              int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `RoleName`        varchar(32)  NOT NULL DEFAULT 'default' COMMENT '角色名称',
    `RoleDescription` varchar(256) NOT NULL DEFAULT 'default' COMMENT '角色说明',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';


DROP TABLE IF EXISTS `UserRole`;

CREATE TABLE `UserRole`
(
    `UserId` int(10) unsigned NOT NULL COMMENT '用户ID',
    `RoleId` int(10) unsigned NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';


DROP TABLE IF EXISTS `Permission`;

CREATE TABLE `Permission`
(
    `Id`                    int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `PermissionName`        varchar(32)  NOT NULL DEFAULT 'default' COMMENT '权限名称',
    `PermissionDescription` varchar(256) NOT NULL DEFAULT 'default' COMMENT '权限说明',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';


DROP TABLE IF EXISTS `RolePermission`;

CREATE TABLE `RolePermission`
(
    `RoleId`       int(10) unsigned NOT NULL COMMENT '角色ID',
    `PermissionId` int(10) unsigned NOT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限表';