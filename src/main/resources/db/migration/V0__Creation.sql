drop table if exists entries;
drop table if exists months;
drop table if exists recurring_costs;


create table if not exists months
(
    id           bigint generated by default as identity primary key,
    date         date,
    income       numeric(38, 2),
    savings_goal numeric(38, 2)
);

create table if not exists entries
(
    id bigint generated by default as identity primary key,
    amount     numeric(38, 2),
    entry_type smallint check (entry_type between 0 and 3),
    month_id   bigint,
    foreign key (month_id) references months (id)
);


create table if not exists recurring_costs
(
    id   bigint generated by default as identity primary key,
    cost numeric(38, 2),
    name varchar(255)
);