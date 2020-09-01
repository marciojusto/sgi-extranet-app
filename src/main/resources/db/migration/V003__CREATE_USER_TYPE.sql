create table user_types
(
    user_id bigint not null
        constraint fk_user_id
        references "user",
    types_id int not null
        constraint fk_types_id
        references type
);