create table type
(
    id serial primary key,
    description varchar not null
);

insert into type (description) VALUES ('SIMPATIZANTE');
insert into type (description) VALUES ('MEMBRO');
insert into type (description) VALUES ('LIDER DE GRUPO');
insert into type (description) VALUES ('VICE LIDER DE GRUPO');
insert into type (description) VALUES ('LIDER DE DISTRITO');
insert into type (description) VALUES ('VICE LIDER DE DISTRITO');
insert into type (description) VALUES ('LIDER DE CAPITULO');
insert into type (description) VALUES ('VICE LIDER DE CAPITULO');