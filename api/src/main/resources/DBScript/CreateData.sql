DELETE FROM `todogroup4`.`task` WHERE task_name IN ('Patatas');
DELETE FROM `todogroup4`.`column_todo` WHERE column_name IN ('Comprar');
DELETE FROM `todogroup4`.`project` WHERE project_name IN ('Shop');
DELETE FROM `todogroup4`.`user` WHERE user_name IN (('Mike234'), ('Bob'), ('Walter'));

INSERT INTO user(user_name, user_password)
VALUES ('Mike234', 'asdu38uf'),
('Bob', 'duv83dcu'),
('Walter', 'wh1t3cr4k');
INSERT INTO project(project_name, user_ID) VALUES ('Shop', last_insert_id());
INSERT INTO column_todo(column_id, column_name, project_id) VALUES (1, 'Comprar', last_insert_id());
INSERT INTO task(task_id, task_name, column_id) VALUES (5, 'Patatas', 1);

SELECT * FROM user;
SELECT * FROM project;
SELECT * FROM column_todo;
SELECT * FROM task;