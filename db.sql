-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.22-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 seo_information 的数据库结构
CREATE DATABASE IF NOT EXISTS `seo_information` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `seo_information`;

-- 导出  表 seo_information.t_oauth 结构
CREATE TABLE IF NOT EXISTS `t_oauth` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `user_info_id` bigint(20) DEFAULT NULL COMMENT '用户基础信息id',
  `oauth_type` varchar(20) DEFAULT NULL COMMENT 'OAuth认证类型',
  `oauth_id` varchar(64) DEFAULT NULL COMMENT 'OAuth认证id',
  `oauth_access_token` varchar(20) DEFAULT NULL COMMENT 'OAuth认证token',
  `oauth_expires` bigint(20) DEFAULT NULL COMMENT 'OAuth认证过期时间，单位毫秒',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_uid` bigint(20) DEFAULT NULL COMMENT '创建用户Id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_uid` bigint(20) DEFAULT NULL COMMENT '更新用户id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_oauth_access_token` (`oauth_access_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='OAuth2.0认证表，包括微信、qq，新浪微博等';

-- 正在导出表  seo_information.t_oauth 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_oauth` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_oauth` ENABLE KEYS */;

-- 导出  表 seo_information.t_seo_article 结构
CREATE TABLE IF NOT EXISTS `t_seo_article` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `keyword` varchar(50) NOT NULL COMMENT '关键词',
  `desc` varchar(500) NOT NULL COMMENT '描述',
  `column_id` bigint(20) NOT NULL COMMENT '栏目id',
  `name` varchar(50) NOT NULL COMMENT '文章名称',
  `content_url` varchar(255) NOT NULL COMMENT '文章内容URL',
  `recommend` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否推荐,1推荐/0不推荐',
  `reading_num` int(11) NOT NULL COMMENT '阅读数',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章状态,0下架/1上架',
  `tags` varchar(500) NOT NULL COMMENT '文章标签',
  `relate_article_ids` varchar(500) DEFAULT NULL COMMENT '相关文章',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `create_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '创建用户id',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `update_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '更新用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seo文章表';

-- 正在导出表  seo_information.t_seo_article 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_seo_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_seo_article` ENABLE KEYS */;

-- 导出  表 seo_information.t_seo_article_tag_mapping 结构
CREATE TABLE IF NOT EXISTS `t_seo_article_tag_mapping` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `article_id` bigint(20) NOT NULL COMMENT '文章id',
  `tag_id` bigint(20) NOT NULL COMMENT '标签id',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `create_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '创建用户id',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `update_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '更新用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seo文章标签关联表';

-- 正在导出表  seo_information.t_seo_article_tag_mapping 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_seo_article_tag_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_seo_article_tag_mapping` ENABLE KEYS */;

-- 导出  表 seo_information.t_seo_banner 结构
CREATE TABLE IF NOT EXISTS `t_seo_banner` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `channel_id` bigint(20) NOT NULL COMMENT '频道id',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `visible` tinyint(1) NOT NULL DEFAULT '1' COMMENT '显示状态,1显示/0不显示',
  `url` varchar(255) NOT NULL COMMENT '跳转地址',
  `summary` varchar(500) NOT NULL COMMENT '摘要',
  `click_num` int(11) NOT NULL DEFAULT '0' COMMENT '点击数',
  `order_num` int(11) NOT NULL COMMENT '顺序',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `create_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '创建用户id',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `update_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '更新用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seo banner表';

-- 正在导出表  seo_information.t_seo_banner 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_seo_banner` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_seo_banner` ENABLE KEYS */;

-- 导出  表 seo_information.t_seo_channel 结构
CREATE TABLE IF NOT EXISTS `t_seo_channel` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `keyword` varchar(50) NOT NULL COMMENT '关键词',
  `desc` varchar(500) NOT NULL COMMENT '描述',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `create_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '创建用户id',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `update_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '更新用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seo频道表';

-- 正在导出表  seo_information.t_seo_channel 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_seo_channel` DISABLE KEYS */;
INSERT INTO `t_seo_channel` (`id`, `title`, `keyword`, `desc`, `create_time`, `create_uid`, `update_time`, `update_uid`) VALUES
	(1018757841579626497, '贷财行SEO资讯', '贷财行SEO资讯', '贷财行SEO资讯描述', '2018-07-16 15:22:51.740', 1018718616616402946, '2018-07-16 15:49:22.730', 1018718616616402946);
/*!40000 ALTER TABLE `t_seo_channel` ENABLE KEYS */;

-- 导出  表 seo_information.t_seo_column 结构
CREATE TABLE IF NOT EXISTS `t_seo_column` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `keyword` varchar(50) NOT NULL COMMENT '关键词',
  `desc` varchar(500) NOT NULL COMMENT '描述',
  `channel_id` bigint(20) NOT NULL COMMENT '频道id',
  `name` varchar(50) NOT NULL COMMENT '栏目名称',
  `url` varchar(255) NOT NULL COMMENT '栏目路径',
  `visible` tinyint(1) NOT NULL DEFAULT '1' COMMENT '导航显示,1显示/0隐藏',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `picture_url` varchar(255) NOT NULL COMMENT '图片URL',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `create_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '创建用户id',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `update_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '更新用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seo栏目表';

-- 正在导出表  seo_information.t_seo_column 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_seo_column` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_seo_column` ENABLE KEYS */;

-- 导出  表 seo_information.t_seo_tag 结构
CREATE TABLE IF NOT EXISTS `t_seo_tag` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `name` varchar(50) NOT NULL COMMENT '标签名称',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `keyword` varchar(50) DEFAULT NULL COMMENT '关键词',
  `desc` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `create_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '创建用户id',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `update_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '修改用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seo标签表';

-- 正在导出表  seo_information.t_seo_tag 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_seo_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_seo_tag` ENABLE KEYS */;

-- 导出  表 seo_information.t_subsidiary_info 结构
CREATE TABLE IF NOT EXISTS `t_subsidiary_info` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `subsidiary_name` varchar(255) DEFAULT NULL COMMENT '子公司名称',
  `subsidiary_code` varchar(20) DEFAULT NULL COMMENT '子公司标识，可以为公司名的简写',
  `api_key` varchar(64) DEFAULT NULL COMMENT 'apiKey',
  `api_secret` varchar(64) DEFAULT NULL COMMENT 'apiSecret',
  `state` tinyint(2) DEFAULT '0' COMMENT '子公司状态',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除状态，0 未删除 1 已删除 默认 0',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_uid` bigint(20) DEFAULT NULL COMMENT '创建用户Id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_uid` bigint(20) DEFAULT NULL COMMENT '更新用户id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_api_key` (`api_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='子公司信息管理';

-- 正在导出表  seo_information.t_subsidiary_info 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_subsidiary_info` DISABLE KEYS */;
INSERT INTO `t_subsidiary_info` (`id`, `subsidiary_name`, `subsidiary_code`, `api_key`, `api_secret`, `state`, `del_flag`, `create_time`, `create_uid`, `update_time`, `update_uid`) VALUES
	(969468898627825888, '贷财行', 'dch', 'e1a2c53d16666ece99cd63f669350e5e', '2a370730be48489b9633c362ba5ea756', 1, 0, '2018-07-16 00:55:26', 968051929257107458, '2018-07-16 00:55:26', 968051929257107458);
/*!40000 ALTER TABLE `t_subsidiary_info` ENABLE KEYS */;

-- 导出  表 seo_information.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `user_info_id` bigint(20) DEFAULT NULL COMMENT '用户基础信息id',
  `account` varchar(50) DEFAULT NULL COMMENT '用户名/账号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `pwd` varchar(128) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '加密盐，只对新账号有效',
  `encrypt_type` varchar(50) DEFAULT NULL COMMENT '加密类型',
  `subsidiary_code` varchar(50) DEFAULT NULL COMMENT '子公司标识，注册来源',
  `subsidiary_user_id` varchar(50) DEFAULT NULL COMMENT '子公司用户id，新注册的和主键保持一致',
  `reg_time` datetime(3) DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime(3) DEFAULT NULL COMMENT '最近登录时间',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除状态，0 未删除 1 已删除 默认 0',
  `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
  `create_uid` bigint(20) DEFAULT NULL COMMENT '创建用户Id',
  `update_time` datetime(3) DEFAULT NULL COMMENT '更新时间',
  `update_uid` bigint(20) DEFAULT NULL COMMENT '更新用户id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_info_id` (`user_info_id`),
  KEY `idx_account` (`account`),
  KEY `idx_email` (`email`),
  KEY `idx_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户认证表';

-- 正在导出表  seo_information.t_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `user_info_id`, `account`, `email`, `phone`, `pwd`, `salt`, `encrypt_type`, `subsidiary_code`, `subsidiary_user_id`, `reg_time`, `last_login_time`, `del_flag`, `create_time`, `create_uid`, `update_time`, `update_uid`) VALUES
	(1019150048765665282, 1019150048467869698, 'admin', NULL, NULL, 'c01084da49dd453e129a757aca56438f099255401a7a3e724043284635c4c5cc4b7e3d7fa4ac302f500f41679834262fadccdf084c91c33943d19f7f43754f35', '6DML6CEe7szoyZTKO9Fr+Q==', 'dch', 'dch', NULL, '2018-07-17 17:21:21.169', '2018-07-17 17:21:41.945', 0, '2018-07-17 17:21:21.170', 1, '2018-07-17 17:21:41.945', 1019150048765665282);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

-- 导出  表 seo_information.t_user_bind_relation 结构
CREATE TABLE IF NOT EXISTS `t_user_bind_relation` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '当前用户id',
  `bind_user_ids` varchar(200) NOT NULL COMMENT '绑定的用户id集合',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除状态，0 未删除 1 已删除 默认 0',
  `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
  `create_uid` bigint(20) DEFAULT NULL COMMENT '创建用户Id',
  `update_time` datetime(3) DEFAULT NULL COMMENT '更新时间',
  `update_uid` bigint(20) DEFAULT NULL COMMENT '更新用户id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户账号绑定关系表';

-- 正在导出表  seo_information.t_user_bind_relation 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_user_bind_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_bind_relation` ENABLE KEYS */;

-- 导出  表 seo_information.t_user_history_import_control 结构
CREATE TABLE IF NOT EXISTS `t_user_history_import_control` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID，由于是底层，可以作为业务条件传入',
  `import_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '导入时间',
  `import_num` bigint(20) DEFAULT NULL COMMENT '导入记录条数',
  `state` tinyint(2) DEFAULT '1' COMMENT '导入状态，0失败 1成功',
  `consume_time` bigint(20) DEFAULT NULL COMMENT '导入耗时，单位毫秒',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户历史数据导入控制表';

-- 正在导出表  seo_information.t_user_history_import_control 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_user_history_import_control` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_history_import_control` ENABLE KEYS */;

-- 导出  表 seo_information.t_user_info 结构
CREATE TABLE IF NOT EXISTS `t_user_info` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户昵称',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别,0 保密1 男 2 女 默认为0',
  `image` varchar(255) DEFAULT NULL COMMENT '头像url地址',
  `true_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `id_number` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `id_number_state` tinyint(1) DEFAULT '0' COMMENT '身份证号验证状态,0 未验证 1已验证 默认 0',
  `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
  `create_uid` bigint(20) DEFAULT NULL COMMENT '创建用户Id',
  `update_time` datetime(3) DEFAULT NULL COMMENT '更新时间',
  `update_uid` bigint(20) DEFAULT NULL COMMENT '更新用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户扩展信息表';

-- 正在导出表  seo_information.t_user_info 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_user_info` DISABLE KEYS */;
INSERT INTO `t_user_info` (`id`, `nick_name`, `sex`, `image`, `true_name`, `id_number`, `id_number_state`, `create_time`, `create_uid`, `update_time`, `update_uid`) VALUES
	(1019150048467869698, NULL, 0, NULL, NULL, NULL, 0, '2018-07-17 17:21:21.055', 1, '2018-07-17 17:21:21.055', 1);
/*!40000 ALTER TABLE `t_user_info` ENABLE KEYS */;

-- 导出  表 seo_information.t_user_modify_record 结构
CREATE TABLE IF NOT EXISTS `t_user_modify_record` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `resource_content` varchar(1000) DEFAULT NULL COMMENT '原对象内容',
  `modify_content` varchar(1000) DEFAULT NULL COMMENT '修改后的内容',
  `subsidiary_code` varchar(20) DEFAULT NULL COMMENT '子公司标识',
  `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
  `create_uid` bigint(20) DEFAULT NULL COMMENT '创建用户Id',
  `update_time` datetime(3) DEFAULT NULL COMMENT '更新时间',
  `update_uid` bigint(20) DEFAULT NULL COMMENT '更新用户id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户信息修改记录表';

-- 正在导出表  seo_information.t_user_modify_record 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_user_modify_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_modify_record` ENABLE KEYS */;

-- 导出  表 seo_information.t_user_temp 结构
CREATE TABLE IF NOT EXISTS `t_user_temp` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `account` varchar(200) DEFAULT NULL COMMENT '用户名/账号',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `pwd` varchar(128) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '加密盐，只对新账号有效',
  `subsidiary_code` varchar(50) DEFAULT NULL COMMENT '子公司标识',
  `subsidiary_user_id` varchar(50) DEFAULT NULL COMMENT '子公司用户id，新注册的和主键保持一致',
  `reg_time` datetime(3) DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime(3) DEFAULT NULL COMMENT '最近登录时间',
  `nick_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户昵称',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别,0 保密1 男 2 女 默认为0',
  `image` varchar(255) DEFAULT NULL COMMENT '头像url地址',
  `true_name` varchar(200) DEFAULT NULL COMMENT '真实姓名',
  `id_number` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `id_number_state` tinyint(1) DEFAULT '0' COMMENT '身份证验证状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户信息临时表，为了接收历史数据';

-- 正在导出表  seo_information.t_user_temp 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_user_temp` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_temp` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
