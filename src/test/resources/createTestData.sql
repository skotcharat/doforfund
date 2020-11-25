insert into user values (1, 'Joe', 'Coyne', 'jcoyne', 'supersecret1', 'joe@mail.com');
insert into user values (2, 'Fred', 'Hensen', 'fhensen', 'supersecret2', 'fred@mail.com');
insert into user_roles values (1, 'admin', 'jcoyne', 1);
insert into user_roles values (2, 'user', 'fhensen', 2);
insert into user_roles values (3, 'sign_in', 'fhensen', 2);
insert into user_roles values (4, 'admin', 'jcoyne', 1);
insert into donation values (1, 40, 'box', 40, 1, '10-11-20');
insert into donation values (2, 20, 'box', 60, 2, '10-11-20');
insert into donation values (3, 50, 'box', 110, 1, '10-11-20');