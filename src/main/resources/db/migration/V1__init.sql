drop table if exists admins CASCADE;
drop table if exists bookings CASCADE;
drop table if exists clients CASCADE;
drop table if exists employees CASCADE;
drop table if exists provided_service CASCADE;
drop table if exists users CASCADE;
create table admins (
                        user_id varchar(255) not null,
                        salary integer not null,
                        primary key (user_id)
);
create table bookings (
                          id varchar(255) generated by default as identity,
                          beginning_time timestamp,
                          booking_status varchar(255),
                          finishing_time timestamp,
                          client_id varchar(255),
                          employee_id varchar(255),
                          provided_service_id varchar(255),
                          primary key (id)
);
create table clients (
                         user_id varchar(255) not null,
                         date_of_birth date,
                         primary key (user_id)
);
create table employees (
                           user_id varchar(255) not null,
                           primary key (user_id)
);
create table provided_service (
                                  id varchar(255) generated by default as identity,
                                  description varchar(255),
                                  name varchar(255),
                                  price double not null,
                                  employee_id varchar(255),
                                  primary key (id)
);
create table users (
                       id varchar(255) generated by default as identity,
                       email varchar(255),
                       login varchar(255),
                       name varchar(255),
                       password varchar(255),
                       primary key (id)
);
alter table admins
    add constraint FKgc8dtql9mkq268detxiox7fpm
        foreign key (user_id)
            references users;
alter table bookings
    add constraint FKqb0hw90djslecy59mnes8lbtq
        foreign key (client_id)
            references clients;
alter table bookings
    add constraint FKeskil2o07k6m8psw18xu2xnco
        foreign key (employee_id)
            references employees;
alter table bookings
    add constraint FK5yqbapg75qr9wtmb0nwqelyal
        foreign key (provided_service_id)
            references provided_service;
alter table clients
    add constraint FKtiuqdledq2lybrds2k3rfqrv4
        foreign key (user_id)
            references users;
alter table employees
    add constraint FK69x3vjuy1t5p18a5llb8h2fjx
        foreign key (user_id)
            references users;
alter table provided_service
    add constraint FKd0bpxp2rb9mkxx0vgbsrad6tp
        foreign key (employee_id)
            references employees;
