insert into users (id, email, login, name)
values ('1', 'admin1@mail', 'admin1', 'Admin1 name'),
       ('2', 'admin2@mail', 'admin2', 'Admin2 name'),
       ('3', 'client1@mail', 'client1', 'Client1 Name'),
       ('4', 'client2@mail', 'client2', 'Client2 Name'),
       ('5', 'employee1@mail', 'employee1', 'Employee1 Name'),
       ('6', 'employee2@mail', 'employee2', 'Employee2 Name');

insert into clients (date_of_birth, user_id)
values (now(), '3'),
       (now(), '4');

insert into admins (salary, user_id)
values (150, '1'),
        (200, '2');

insert into employees (user_id)
values ('5'),
       ('6');

insert into provided_service (id, description, employee_id, name, price)
values ('1', 'Lorem ipsum dolor sit amet, consectetur adipiscing', '5', 'hairdressing', 150),
       ('2', 'Lorem ipsum dolor sit amet, consectetur adipiscing', '6', 'nails', 1150);