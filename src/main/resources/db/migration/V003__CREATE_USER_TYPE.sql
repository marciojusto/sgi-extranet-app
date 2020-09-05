create table user_type
(
    user_id bigint not null
        constraint fk_user_id
        references "user",
    type_id int not null
        constraint fk_type_id
        references type
);