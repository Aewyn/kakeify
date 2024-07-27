insert into months (date, savings_goal)
values ('2024-01-01 08:00:00-00', 250),
       ('2024-02-01 08:00:00-00', 250),
       ('2024-03-01 08:00:00-00', 250),
       ('2024-04-01 08:00:00-00', 250);

insert into entries (amount, entry_type, month_id)
VALUES (20, 0, (select m.id from months m where m.date::date = '2024-01-01'));