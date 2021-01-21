INSERT INTO tb_user_system (us_name, us_birthday_date, us_gender, us_email, us_creation_date, us_alteration_date)
VALUES ('Hugo', '1989-04-20', 1, 'hugo@test.com', '2021-01-19 16:26:00', '2021-01-19 16:26:00');

INSERT INTO tb_profile (us_id, pro_name)
VALUES ((SELECT 1 FROM tb_user_system us WHERE us.us_email = 'hugo@test.com'), 1);


INSERT INTO tb_bank_account_type (bat_code, bat_name, bat_description, bat_creation_date, bat_alteration_date)
VALUES (1, 'Corrente', 'Conta corrente', '2021-01-19 16:26:00', '2021-01-19 16:26:00'),
        (2, 'Poupanca', 'Conta poupança', '2021-01-19 16:26:00', '2021-01-19 16:26:00');
