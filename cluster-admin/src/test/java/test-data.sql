SELECT * FROM tb_admin_user;
SELECT * FROM tb_user_role;
SELECT * FROM tb_role;
SELECT * FROM tb_role_authority;
SELECT * FROM tb_authority;
SELECT * FROM tb_authority_resource;
SELECT * FROM tb_resource;

INSERT INTO tb_admin_user(id, username, PASSWORD, company_name, linkman, phone, COMMENT, is_valid, create_time, modify_time)
VALUES(1,'admin','e10adc3949ba59abbe56e057f20f883e','珠海顶峰互动科技有限公司', NULL, '13800138000','超级管理员',1, NOW(),NOW());
INSERT INTO tb_admin_user(id, username, PASSWORD, company_name, linkman, phone, COMMENT, is_valid, create_time, modify_time)
VALUES(2,'feng-test','e10adc3949ba59abbe56e057f20f883e','珠海顶峰互动科技有限公司', NULL, '13800138000','普通管理员',1, NOW(),NOW());

INSERT INTO tb_role VALUES(1,'超级管理员', NOW(), NOW());
INSERT INTO tb_role VALUES(2,'普通管理员', NOW(), NOW());

INSERT INTO tb_user_role VALUES(1, 1, 1,NOW(),NOW());
INSERT INTO tb_user_role VALUES(2, 1, 2,NOW(),NOW());
INSERT INTO tb_user_role VALUES(3, 2, 2,NOW(),NOW());


INSERT INTO tb_authority VALUES(1, 'A_USER', '用户管理', NOW(),NOW());
INSERT INTO tb_role_authority VALUES(1, 1, 1, NOW(), NOW());

INSERT INTO tb_resource VALUES(1, 'url', '/admin/user/**', NOW(),NOW());
INSERT INTO tb_authority_resource VALUES(1,1,1, NOW(),NOW());
