create table if not exists entries
(
    id         bigint generated by default as identity,
    amount     numeric(38, 2),
    entry_type smallint check (entry_type between 0 and 3),
    month_id   bigint,
    primary key (id)
);

create table if not exists months
(
    id           bigint generated by default as identity,
    date         timestamp(6),
    savings_goal numeric(38, 2),
    primary key (id)
);

create table if not exists recurring_costs
(
    id   bigint generated by default as identity,
    cost numeric(38, 2),
    name varchar(255),
    primary key (id)
);
alter table if exists entries
    add constraint FK_MONTHS foreign key (month_id) references months;