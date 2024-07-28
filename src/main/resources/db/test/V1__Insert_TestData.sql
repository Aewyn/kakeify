insert into months (date, income, savings_goal)
values ('2024-01-01 08:00:00-00', 3000, 250),
       ('2024-02-01 08:00:00-00', 3000, 250),
       ('2024-03-01 08:00:00-00', 3000, 250),
       ('2024-04-01 08:00:00-00', 3000, 250);

insert into entries (amount, entry_type, month_id)
VALUES (20, 0, (select m.id from months m where m.date::date = '2024-01-01')),
       (20, 1, (select m.id from months m where m.date = '2024-01-01')),
       (20, 2, (select m.id from months m where m.date = '2024-02-01')),
       (20, 3, (select m.id from months m where m.date = '2024-03-01')),
       (20, 2, (select m.id from months m where m.date = '2024-04-01')),
       (20, 1, (select m.id from months m where m.date = '2024-04-01'));