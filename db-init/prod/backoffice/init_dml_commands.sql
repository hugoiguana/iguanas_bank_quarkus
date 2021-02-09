
    INSERT INTO tb_user_system (us_name, us_birthday_date, us_gender, us_email, us_creation_date, us_alteration_date) VALUES ('Hugo', '1989-04-20', 1, 'hugo@test.com', '2021-01-19 16:26:00', '2021-01-19 16:26:00');

    INSERT INTO tb_user_system (us_name, us_birthday_date, us_gender, us_email, us_creation_date, us_alteration_date) VALUES ('Aline', '1990-01-11', 2, 'aline@test.com', '2021-01-19 16:26:00', '2021-01-19 16:26:00');

    INSERT INTO tb_user_system (us_name, us_birthday_date, us_gender, us_email, us_creation_date, us_alteration_date) VALUES ('Gabriel', '2020-07-02', 1, 'gabriel@test.com', '2021-01-19 16:26:00', '2021-01-19 16:26:00');

    INSERT INTO tb_profile (us_id, pro_name) VALUES ((SELECT 1 FROM tb_user_system us WHERE us.us_email = 'hugo@test.com'), 1)        ,((SELECT 1 FROM tb_user_system us WHERE us.us_email = 'aline@test.com'), 2)        ,((SELECT 1 FROM tb_user_system us WHERE us.us_email = 'gabriel@test.com'), 3);

    INSERT INTO tb_bank_account_type (bat_code, bat_name, bat_description, bat_creation_date, bat_alteration_date) VALUES (1, 'Corrente', 'Conta corrente', '2021-01-19 16:26:00', '2021-01-19 16:26:00')        ,(2, 'Poupanca', 'Conta poupança', '2021-01-19 16:26:00', '2021-01-19 16:26:00');

    INSERT INTO tb_bank_account (ba_alteration_date     , ba_creation_date     , ba_account_code     , ba_account_code_vd     , ba_active     , ba_agency_code     , ba_agency_code_vd     , us_id_customer     , us_id_manager     , bat_id) VALUES(   '2021-01-25 11:45:00' , '2021-01-25 11:45:00' , '123456' , '1' , true , '1234' , '9' , (SELECT 1 FROM tb_user_system us WHERE us.us_email = 'gabriel@test.com') , (SELECT 1 FROM tb_user_system us WHERE us.us_email = 'aline@test.com') , 1 );


