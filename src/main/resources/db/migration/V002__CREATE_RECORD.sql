create table record
(
    id bigserial not null
        constraint record_pk
        primary key,
    user_id bigint not null
        constraint fk_user_id
            references "user",
    initial_date date not null,
    final_date date,
    type varchar not null
);