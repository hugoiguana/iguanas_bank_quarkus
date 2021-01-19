INSERT INTO tb_user_system (us_str_name, us_dr_birthday_date, us_tp_gender, us_str_email, us_dth_creation_date, us_dth_alteration_date)
VALUES ('Hugo', '1989-04-20', 1, 'hugo@test.com', '2021-01-19 16:26:00', '2021-01-19 16:26:00');

INSERT INTO tb_profile (us_id, pro_name)
VALUES ((SELECT 1 FROM tb_user_system us WHERE us.us_str_email = 'hugo@test.com'), 1);
