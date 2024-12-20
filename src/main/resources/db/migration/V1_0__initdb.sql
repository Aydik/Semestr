create sequence users_seq;
create table users
(
    id           bigint primary key default nextval('users_seq'),
    phone_number character varying(20),
    user_name    character varying(50),
    password     character varying(100)
);


create sequence pizza_seq;
create table pizza
(
    id          bigint primary key default nextval('pizza_seq'),
    name        character varying(50),
    composition character varying(200),
    weight      integer,
    price       integer,
    photo       character varying(100)
);
insert into pizza (name, composition, weight, price, photo)
values ('Прима Пепперони большая',
        'Колбаса Пепперони, сыр Моцарелла, соус Маргарита',
        500, 595, 'PrimaPepperoniBig');
insert into pizza (name, composition, weight, price, photo)
values ('Суперколбасная большая',
        'Колбаса п/к, сервелат, колбаса Пепперони, баварские колбаски, томаты, сыр Гауда, томатный соус',
        560, 615, 'SuperSausageBig');
insert into pizza (name, composition, weight, price, photo)
values ('Русская',
        'Колбаса п/к, колбаса варёная, марин.огурцы, болг.перец, сыр Гауда и Моцарелла, горчичный соус',
        540, 495, 'Russian');
insert into pizza (name, composition, weight, price, photo)
values ('Азиатская',
        'Ветчина, цыпленок копченый, свежие томаты, перец болгарский, сыр Моцарелла, соусы терияки и орехово-кунжутный',
        510, 595, 'Asian');






