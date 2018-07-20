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
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `keyword` varchar(50) DEFAULT NULL COMMENT '关键词',
  `desc` varchar(500) DEFAULT NULL COMMENT '描述',
  `column_id` bigint(20) NOT NULL COMMENT '栏目id',
  `name` varchar(50) NOT NULL COMMENT '文章名称',
  `content` varchar(1000) NOT NULL COMMENT '文章内容',
  `content_url` varchar(255) DEFAULT NULL COMMENT '文章内容URL',
  `recommend` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否推荐,1推荐/0不推荐',
  `reading_num` int(11) NOT NULL DEFAULT '0' COMMENT '阅读数',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章状态,0下架/1上架',
  `tags` varchar(500) DEFAULT NULL COMMENT '文章标签',
  `relate_article_ids` varchar(500) DEFAULT NULL COMMENT '相关文章',
  `up_time` datetime(3) DEFAULT NULL COMMENT '上架时间',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `create_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '创建用户id',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `update_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '更新用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seo文章表';

-- 正在导出表  seo_information.t_seo_article 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `t_seo_article` DISABLE KEYS */;
INSERT INTO `t_seo_article` (`id`, `title`, `keyword`, `desc`, `column_id`, `name`, `content`, `content_url`, `recommend`, `reading_num`, `state`, `tags`, `relate_article_ids`, `up_time`, `create_time`, `create_uid`, `update_time`, `update_uid`) VALUES
	(1019422485704998913, 'AAAAA title', 'AAAAA keyword', 'AAAAA desc', 1019411003000885249, 'AAAAA', '', 'http://file.daicaihang.com/article/art001', 0, 0, 1, '金融,P2P,银行', NULL, '2018-07-19 17:53:36.450', '2018-07-18 11:23:55.234', 1019150048765665282, '2018-07-18 11:23:55.234', 1019150048765665282),
	(1019457130974924801, 'AAAAA title', 'AAAAA keyword', 'AAAAA desc', 1019411003000885249, 'BBBBB', '', 'http://file.daicaihang.com/article/art001', 0, 0, 1, '金融,P2P,银行', '1019422485704998913', NULL, '2018-07-18 13:41:35.489', 1019150048765665282, '2018-07-18 13:41:35.489', 1019150048765665282),
	(1019767793114906625, 'AAAAA title', 'AAAAA keyword', 'AAAAA desc', 1019411003000885249, 'DDDDD', '<p>内容abc<p>', 'http://file.daicaihang.com/article/art001', 0, 0, 0, '金融,P2P,银行', '1019422485704998913', NULL, '2018-07-19 10:16:02.946', 1019150048765665282, '2018-07-19 10:16:02.946', 1019150048765665282),
	(1020115467890581505, 'AAAAA title', 'AAAAA keyword', 'AAAAA desc', 1019411003000885249, 'BBBBB', 'asdasdad', 'http://file.daicaihang.com/article/art001', 0, 0, 0, '金融,P2P,银行', '1019422485704998913', NULL, '2018-07-20 09:17:35.063', -1, '2018-07-20 09:17:35.063', -1),
	(1020115610584997890, NULL, NULL, NULL, 1019411003000885200, 'A', '联通没？', NULL, 0, 0, 0, NULL, NULL, NULL, '2018-07-20 09:18:09.059', -1, '2018-07-20 09:18:09.059', -1),
	(1020118935736913921, NULL, NULL, NULL, 1019411003000885200, '123', 'aaaa', NULL, 0, 2, 0, NULL, '0', NULL, '2018-07-20 09:31:21.865', -1, '2018-07-20 09:31:21.865', -1),
	(1020119012492677122, NULL, NULL, NULL, 1019411003000885200, '123', 'aaaa', NULL, 0, 2, 0, NULL, '0', NULL, '2018-07-20 09:31:40.136', -1, '2018-07-20 09:31:40.136', -1),
	(1020119678770450434, NULL, NULL, NULL, 1019411003000885200, '123', 'aaaa', NULL, 0, 2, 0, NULL, '0', NULL, '2018-07-20 09:34:19.052', -1, '2018-07-20 09:34:19.052', -1),
	(1020119836404977665, NULL, NULL, NULL, 1019411003000885200, '123', 'aaaa', NULL, 0, 2, 0, NULL, '0', NULL, '2018-07-20 09:34:56.572', -1, '2018-07-20 09:34:56.572', -1),
	(1020119922895720450, NULL, NULL, NULL, 1019411003000885200, '123', 'aaaa', NULL, 0, 2, 0, NULL, '0', NULL, '2018-07-20 09:35:17.193', -1, '2018-07-20 09:35:17.193', -1),
	(1020119956253020162, NULL, NULL, NULL, 1019411003000885200, '123', 'aaaa', NULL, 0, 2, 0, NULL, '0', NULL, '2018-07-20 09:35:25.145', -1, '2018-07-20 09:35:25.145', -1),
	(1020120038197137409, NULL, NULL, NULL, 1019411003000885200, '123', 'aaaa', NULL, 0, 2, 0, NULL, '0', NULL, '2018-07-20 09:35:44.680', -1, '2018-07-20 09:35:44.680', -1),
	(1020120597289459714, NULL, NULL, NULL, 1019411003000885200, '123', 'aaaa', NULL, 0, 2, 0, NULL, '0', NULL, '2018-07-20 09:37:58.008', -1, '2018-07-20 09:37:58.008', -1),
	(1020120650217381890, NULL, NULL, NULL, 1019411003000885200, '123', 'aaaa', NULL, 0, 2, 0, NULL, '0', NULL, '2018-07-20 09:38:10.601', -1, '2018-07-20 09:38:10.601', -1),
	(1020134476648259585, NULL, NULL, NULL, 1019411003000885249, '123', '123', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:33:07.089', -1, '2018-07-20 10:33:07.089', -1),
	(1020134478640553986, NULL, NULL, NULL, 1019411003000885249, '123', '爱上大所多是的阿萨德啊', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:33:07.551', -1, '2018-07-20 10:33:07.551', -1),
	(1020136981952176130, NULL, NULL, NULL, 1019411003000885249, '1123', '1', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:43:04.385', -1, '2018-07-20 10:43:04.385', -1),
	(1020137018224517122, NULL, NULL, NULL, 1019411003000885249, '1123', '1123123123爱的', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:43:13.033', -1, '2018-07-20 10:43:13.033', -1),
	(1020137050268999682, NULL, NULL, NULL, 1019411003000885249, '1123', '111', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:43:20.673', -1, '2018-07-20 10:43:20.673', -1),
	(1020137052680724482, NULL, NULL, NULL, 1019411003000885249, '1123', '111', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:43:21.249', -1, '2018-07-20 10:43:21.249', -1),
	(1020137053452476417, NULL, NULL, NULL, 1019411003000885249, '1123', '111', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:43:21.432', -1, '2018-07-20 10:43:21.432', -1),
	(1020137054190673922, NULL, NULL, NULL, 1019411003000885249, '1123', '111', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:43:21.608', -1, '2018-07-20 10:43:21.608', -1),
	(1020137054719156225, NULL, NULL, NULL, 1019411003000885249, '1123', '111', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:43:21.734', -1, '2018-07-20 10:43:21.734', -1),
	(1020137055327330305, NULL, NULL, NULL, 1019411003000885249, '1123', '111', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 10:43:21.880', -1, '2018-07-20 10:43:21.880', -1),
	(1020143644943818753, NULL, NULL, NULL, 1019411003000885249, '爱上大所多', '<p>0啊</p><p>啊<u>爱的</u>&nbsp;阿萨德啊 阿萨德</p>', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 11:09:32.965', -1, '2018-07-20 11:09:32.965', -1),
	(1020143739072389122, NULL, NULL, NULL, 1019411003000885249, '爱上大所多', '<p>0啊</p><p>啊<u>爱的</u>&nbsp;阿萨德啊 阿萨德</p>', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 11:09:55.408', -1, '2018-07-20 11:09:55.408', -1),
	(1020146030517141506, NULL, NULL, NULL, 1019411003000885249, '啊三打死了啊', '<p>阿萨德</p><p>阿萨德啊的是的</p><p><img src="http://10.10.68.23:9000/seo/information/article/content/img/ldy-3.jpg" alt="ldy-3.jpg"></p>', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 11:19:01.732', -1, '2018-07-20 11:19:01.732', -1),
	(1020146238084857858, NULL, NULL, NULL, 1019411003000885249, '啊三打死了啊', '<p>阿萨德</p><p>阿萨德啊的是的</p><p><img src="http://10.10.68.23:9000/seo/information/article/content/img/ldy-3.jpg" alt="ldy-3.jpg"></p>', NULL, 0, 0, 0, '爱上,ad,sd', '0', NULL, '2018-07-20 11:19:51.220', -1, '2018-07-20 11:19:51.220', -1),
	(1020150963182211073, NULL, NULL, NULL, 1019411003000885249, '1233123', '阿萨德啊啊', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 11:38:37.787', -1, '2018-07-20 11:38:37.787', -1),
	(1020151166241050625, NULL, NULL, NULL, 1019411003000885249, '123', 'asd ad&nbsp;', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 11:39:26.184', -1, '2018-07-20 11:39:26.184', -1),
	(1020153367810248705, NULL, NULL, NULL, 1019411003000885249, '123', '阿萨德', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 11:48:11.079', -1, '2018-07-20 11:48:11.079', -1),
	(1020155217347334145, NULL, NULL, NULL, 1019411003000885249, '123', 'asd&nbsp;', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 11:55:32.058', -1, '2018-07-20 11:55:32.058', -1),
	(1020182603027640322, NULL, NULL, NULL, 1019411003000885249, '123', 'asd爱上', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 13:44:21.312', -1, '2018-07-20 13:44:21.312', -1),
	(1020182763740786690, NULL, NULL, NULL, 1019411003000885249, '是', '阿萨德是', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 13:44:59.615', -1, '2018-07-20 13:44:59.615', -1),
	(1020183202397876225, NULL, NULL, NULL, 1019411003000885249, '阿萨德', '撒旦', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 13:46:44.199', -1, '2018-07-20 13:46:44.199', -1),
	(1020183259566239746, NULL, NULL, NULL, 1019411003000885249, '阿萨德', '阿萨德', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 13:46:57.829', -1, '2018-07-20 13:46:57.829', -1),
	(1020186549427302402, NULL, NULL, NULL, 1019411003000885249, '阿萨德', '阿萨德', NULL, 0, 0, 0, NULL, '0', NULL, '2018-07-20 14:00:02.193', -1, '2018-07-20 14:00:02.193', -1);
/*!40000 ALTER TABLE `t_seo_article` ENABLE KEYS */;

-- 导出  表 seo_information.t_seo_article_relate 结构
CREATE TABLE IF NOT EXISTS `t_seo_article_relate` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键ID',
  `article_id` bigint(20) NOT NULL COMMENT '文章id',
  `relate_article_id` bigint(20) NOT NULL COMMENT '相关文章id',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `create_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '创建用户id',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `update_uid` bigint(20) NOT NULL DEFAULT '1' COMMENT '更新用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seo相关文章表';

-- 正在导出表  seo_information.t_seo_article_relate 的数据：~24 rows (大约)
/*!40000 ALTER TABLE `t_seo_article_relate` DISABLE KEYS */;
INSERT INTO `t_seo_article_relate` (`id`, `article_id`, `relate_article_id`, `create_time`, `create_uid`, `update_time`, `update_uid`) VALUES
	(1019457132199661570, 1019457130974924801, 1019422485704998913, '2018-07-18 13:41:35.573', 1, '2018-07-18 13:41:35.573', 1),
	(1019767793781800962, 1019767793114906625, 1019422485704998913, '2018-07-19 10:16:03.068', 1, '2018-07-19 10:16:03.068', 1),
	(1020115468389703681, 1020115467890581505, 1019422485704998913, '2018-07-20 09:17:35.153', 1, '2018-07-20 09:17:35.153', 1),
	(1020118936022126593, 1020118935736913921, 0, '2018-07-20 09:31:21.903', 1, '2018-07-20 09:31:21.903', 1),
	(1020119012576563202, 1020119012492677122, 0, '2018-07-20 09:31:40.176', 1, '2018-07-20 09:31:40.176', 1),
	(1020119678883696641, 1020119678770450434, 0, '2018-07-20 09:34:19.071', 1, '2018-07-20 09:34:19.071', 1),
	(1020119836484669441, 1020119836404977665, 0, '2018-07-20 09:34:56.589', 1, '2018-07-20 09:34:56.589', 1),
	(1020119922967023618, 1020119922895720450, 0, '2018-07-20 09:35:17.209', 1, '2018-07-20 09:35:17.209', 1),
	(1020119956332711938, 1020119956253020162, 0, '2018-07-20 09:35:25.164', 1, '2018-07-20 09:35:25.164', 1),
	(1020120038243274754, 1020120038197137409, 0, '2018-07-20 09:35:44.691', 1, '2018-07-20 09:35:44.691', 1),
	(1020120597566283778, 1020120597289459714, 0, '2018-07-20 09:37:58.044', 1, '2018-07-20 09:37:58.044', 1),
	(1020120650305462273, 1020120650217381890, 0, '2018-07-20 09:38:10.619', 1, '2018-07-20 09:38:10.619', 1),
	(1020134476799254530, 1020134476648259585, 0, '2018-07-20 10:33:07.109', 1, '2018-07-20 10:33:07.109', 1),
	(1020134478690885634, 1020134478640553986, 0, '2018-07-20 10:33:07.561', 1, '2018-07-20 10:33:07.561', 1),
	(1020136982002507778, 1020136981952176130, 0, '2018-07-20 10:43:04.398', 1, '2018-07-20 10:43:04.398', 1),
	(1020137018262265857, 1020137018224517122, 0, '2018-07-20 10:43:13.043', 1, '2018-07-20 10:43:13.043', 1),
	(1020137050306748418, 1020137050268999682, 0, '2018-07-20 10:43:20.683', 1, '2018-07-20 10:43:20.683', 1),
	(1020137052722667521, 1020137052680724482, 0, '2018-07-20 10:43:21.259', 1, '2018-07-20 10:43:21.259', 1),
	(1020137053486030849, 1020137053452476417, 0, '2018-07-20 10:43:21.440', 1, '2018-07-20 10:43:21.440', 1),
	(1020137054228422657, 1020137054190673922, 0, '2018-07-20 10:43:21.617', 1, '2018-07-20 10:43:21.617', 1),
	(1020137054756904962, 1020137054719156225, 0, '2018-07-20 10:43:21.743', 1, '2018-07-20 10:43:21.743', 1),
	(1020137055365079042, 1020137055327330305, 0, '2018-07-20 10:43:21.888', 1, '2018-07-20 10:43:21.888', 1),
	(1020143644964790273, 1020143644943818753, 0, '2018-07-20 11:09:32.969', 1, '2018-07-20 11:09:32.969', 1),
	(1020143739105943554, 1020143739072389122, 0, '2018-07-20 11:09:55.416', 1, '2018-07-20 11:09:55.416', 1),
	(1020146030705885186, 1020146030517141506, 0, '2018-07-20 11:19:01.776', 1, '2018-07-20 11:19:01.776', 1),
	(1020146238319738882, 1020146238084857858, 0, '2018-07-20 11:19:51.274', 1, '2018-07-20 11:19:51.274', 1),
	(1020150963341594626, 1020150963182211073, 0, '2018-07-20 11:38:37.807', 1, '2018-07-20 11:38:37.807', 1),
	(1020151166287187970, 1020151166241050625, 0, '2018-07-20 11:39:26.195', 1, '2018-07-20 11:39:26.195', 1),
	(1020153367852191746, 1020153367810248705, 0, '2018-07-20 11:48:11.088', 1, '2018-07-20 11:48:11.088', 1),
	(1020155217506717698, 1020155217347334145, 0, '2018-07-20 11:55:32.079', 1, '2018-07-20 11:55:32.079', 1),
	(1020182603182829570, 1020182603027640322, 0, '2018-07-20 13:44:21.333', 1, '2018-07-20 13:44:21.333', 1),
	(1020182763782729729, 1020182763740786690, 0, '2018-07-20 13:44:59.625', 1, '2018-07-20 13:44:59.625', 1),
	(1020183202439819265, 1020183202397876225, 0, '2018-07-20 13:46:44.209', 1, '2018-07-20 13:46:44.209', 1),
	(1020183259608182785, 1020183259566239746, 0, '2018-07-20 13:46:57.839', 1, '2018-07-20 13:46:57.839', 1),
	(1020186549465051137, 1020186549427302402, 0, '2018-07-20 14:00:02.202', 1, '2018-07-20 14:00:02.202', 1);
/*!40000 ALTER TABLE `t_seo_article_relate` ENABLE KEYS */;

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

-- 正在导出表  seo_information.t_seo_article_tag_mapping 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `t_seo_article_tag_mapping` DISABLE KEYS */;
INSERT INTO `t_seo_article_tag_mapping` (`id`, `article_id`, `tag_id`, `create_time`, `create_uid`, `update_time`, `update_uid`) VALUES
	(1019422486011183105, 1019422485704998913, 1019411385466884098, '2018-07-18 11:23:55.280', 1, '2018-07-18 11:23:55.280', 1),
	(1019422486103457793, 1019422485704998913, 1019422486057320449, '2018-07-18 11:23:55.300', 1, '2018-07-18 11:23:55.300', 1),
	(1019422486183149570, 1019422485704998913, 1019422486145400833, '2018-07-18 11:23:55.320', 1, '2018-07-18 11:23:55.320', 1),
	(1019457132027695105, 1019457130974924801, 1019411385466884098, '2018-07-18 13:41:35.534', 1, '2018-07-18 13:41:35.534', 1),
	(1019457132090609665, 1019457130974924801, 1019422486057320449, '2018-07-18 13:41:35.548', 1, '2018-07-18 13:41:35.548', 1),
	(1019457132153524226, 1019457130974924801, 1019422486145400833, '2018-07-18 13:41:35.563', 1, '2018-07-18 13:41:35.563', 1),
	(1019767793475616769, 1019767793114906625, 1019411385466884098, '2018-07-19 10:16:02.995', 1, '2018-07-19 10:16:02.995', 1),
	(1019767793593057281, 1019767793114906625, 1019422486057320449, '2018-07-19 10:16:03.021', 1, '2018-07-19 10:16:03.021', 1),
	(1019767793689526273, 1019767793114906625, 1019422486145400833, '2018-07-19 10:16:03.047', 1, '2018-07-19 10:16:03.047', 1),
	(1020115468200960001, 1020115467890581505, 1019411385466884098, '2018-07-20 09:17:35.108', 1, '2018-07-20 09:17:35.108', 1),
	(1020115468272263169, 1020115467890581505, 1019422486057320449, '2018-07-20 09:17:35.125', 1, '2018-07-20 09:17:35.125', 1),
	(1020115468339372034, 1020115467890581505, 1019422486145400833, '2018-07-20 09:17:35.141', 1, '2018-07-20 09:17:35.141', 1),
	(1020146238198104065, 1020146238084857858, 1020146238147772418, '2018-07-20 11:19:51.245', 1, '2018-07-20 11:19:51.245', 1),
	(1020146238244241409, 1020146238084857858, 1020146238223269890, '2018-07-20 11:19:51.257', 1, '2018-07-20 11:19:51.257', 1),
	(1020146238298767361, 1020146238084857858, 1020146238273601537, '2018-07-20 11:19:51.269', 1, '2018-07-20 11:19:51.269', 1);
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

-- 正在导出表  seo_information.t_seo_channel 的数据：~0 rows (大约)
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
INSERT INTO `t_seo_column` (`id`, `title`, `keyword`, `desc`, `channel_id`, `name`, `url`, `visible`, `order_num`, `picture_url`, `create_time`, `create_uid`, `update_time`, `update_uid`) VALUES
	(1019411003000885249, 'testtitle', 'testkeyword', 'testdesc', 1018757841579626497, '栏目6', 'www.daicaihang.com/news/p2p', 1, 6, 'http://file.daicaihang.com/seoInformation/pic004', '2018-07-18 10:38:17.518', 1019150048765665282, '2018-07-18 10:38:17.518', 1019150048765665282);
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

-- 正在导出表  seo_information.t_seo_tag 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_seo_tag` DISABLE KEYS */;
INSERT INTO `t_seo_tag` (`id`, `name`, `title`, `keyword`, `desc`, `create_time`, `create_uid`, `update_time`, `update_uid`) VALUES
	(1019411385466884098, '金融', NULL, NULL, NULL, '2018-07-18 10:39:48.861', 1, '2018-07-18 10:39:48.861', 1),
	(1019422486057320449, 'P2P', NULL, NULL, NULL, '2018-07-18 11:23:55.290', 1, '2018-07-18 11:23:55.290', 1),
	(1019422486145400833, '银行', NULL, NULL, NULL, '2018-07-18 11:23:55.310', 1, '2018-07-18 11:23:55.310', 1),
	(1020146238147772418, '爱上', NULL, NULL, NULL, '2018-07-20 11:19:51.235', 1, '2018-07-20 11:19:51.235', 1),
	(1020146238223269890, 'ad', NULL, NULL, NULL, '2018-07-20 11:19:51.251', 1, '2018-07-20 11:19:51.251', 1),
	(1020146238273601537, 'sd', NULL, NULL, NULL, '2018-07-20 11:19:51.264', 1, '2018-07-20 11:19:51.264', 1);
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
	(1019150048765665282, 1019150048467869698, 'admin', NULL, NULL, 'c01084da49dd453e129a757aca56438f099255401a7a3e724043284635c4c5cc4b7e3d7fa4ac302f500f41679834262fadccdf084c91c33943d19f7f43754f35', '6DML6CEe7szoyZTKO9Fr+Q==', 'dch', 'dch', NULL, '2018-07-17 17:21:21.169', '2018-07-19 15:51:58.469', 0, '2018-07-17 17:21:21.170', 1, '2018-07-19 15:51:58.469', 1019150048765665282);
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
