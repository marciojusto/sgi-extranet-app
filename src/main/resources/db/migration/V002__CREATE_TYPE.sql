create table type
(
    id serial not null,
    description varchar not null
);

create unique index type_id_uindex
    on type (id);

alter table type
    add constraint type_pk
        primary key (id);

insert into type (description) VALUES ('SIMPATIZANTE');
insert into type (description) VALUES ('MEMBRO');