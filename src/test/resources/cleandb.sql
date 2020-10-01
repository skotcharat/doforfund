delete from user;
delete from user_roles;
 insert into user values (1, 'Joe', 'Coyne', 'jcoyne', 'supersecret1', 'joe@mail.com');
 insert into user values (2, 'Fred', 'Hensen', 'fhensen', 'supersecret2', 'fred@mail.com');
insert into user_roles values (1, 'create_event', 'jcoyne', 1);
insert into user_roles values (2, 'donation', 'fhensen', 2);
insert into user_roles values (3, 'sign_in', 'fhensen', 2);
insert into user_roles values (4, 'answer_question', 'jcoyne', 1);


