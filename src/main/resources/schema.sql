create table PERSONS
(
    name varchar,
    surname varchar,
    age int,
    phone_number varchar,
    city_of_living varchar,
    constraint persons_pk
        primary key (name, surname, age)
);


insert into persons (name, surname, age, phone_number, city_of_living) values ('Иванов', 'Иван', 20, '123', 'MOSCOW');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Сидоров', 'Иван', 21, '234', 'SPB');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Иванов', 'Сидор', 28, '345', 'MOSCOW');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Буланцев', 'Иван', 34, '456', 'ROSTOV');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Иванов', 'Булат', 29, '567', 'MOSCOW');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Иванов', 'Иван', 30, '678', 'SAMARA');

