create table "user"
(
    id bigserial not null,
    name varchar not null,
    lastname varchar not null,
    age int
);

create unique index user_id_uindex
    on "user" (id);

alter table "user"
    add constraint user_pk
        primary key (id);

