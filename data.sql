INSERT INTO `t_user` (`id`, `user_info_id`, `account`, `email`, `phone`, `pwd`, `salt`, `encrypt_type`, `subsidiary_code`, `subsidiary_user_id`, `reg_time`, `last_login_time`, `del_flag`) VALUES
	(1, 1, 'admin', NULL, NULL, 'c01084da49dd453e129a757aca56438f099255401a7a3e724043284635c4c5cc4b7e3d7fa4ac302f500f41679834262fadccdf084c91c33943d19f7f43754f35', '6DML6CEe7szoyZTKO9Fr+Q==', 'dch', 'dch', NULL, '2018-07-17 17:21:21.169', '2018-08-01 18:14:45.298', 0);

INSERT INTO `t_user_info` (`id`, `nick_name`, `sex`, `image`, `true_name`, `id_number`, `id_number_state`) VALUES
	(1, NULL, 0, NULL, NULL, NULL, 0);

INSERT INTO `t_subsidiary_info` (`id`, `subsidiary_name`, `subsidiary_code`, `api_key`, `api_secret`, `state`, `del_flag`) VALUES
	(1, '贷财行', 'dch', 'e1a2c53d16666ece99cd63f669350e5e', '2a370730be48489b9633c362ba5ea756', 1, 0);

INSERT INTO `t_seo_channel` (`id`, `title`, `keyword`, `desc`, `href`) VALUES
	(1, '贷财行', '贷财行', '贷财行', NULL);