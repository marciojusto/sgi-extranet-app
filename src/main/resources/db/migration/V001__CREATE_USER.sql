create table "user"
(
    id bigserial primary key,
    name varchar not null,
    lastname varchar not null,
    age int,
    phone varchar null,
    mobile_phone varchar not null,
    email varchar not null,
    nif bigint not null
);

