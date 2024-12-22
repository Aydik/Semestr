create sequence users_seq;
create table users
(
    id           bigint primary key default nextval('users_seq'),
    phone_number character varying(20) not null,
    user_name    character varying(50) not null,
    password     character varying(100) not null
);


create sequence pizza_seq;
create table pizza
(
    id          bigint primary key default nextval('pizza_seq'),
    name        character varying(50) not null,
    composition character varying(200) not null,
    weight      int not null,
    price       int not null,
    photo       character varying(100) not null
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
insert into pizza (name, composition, weight, price, photo)
values ('С карпаччо и томатами',
        'Карпаччо из свинины, ветчина, свежие томаты, сыр Моцарелла, соус Цезарь',
        545, 555, 'Carpaccio');
insert into pizza (name, composition, weight, price, photo)
values ('Маргарита',
        'Свежие томаты, маслины и сыр Моцарелла на томатном соусе с итальянскими травами',
        500, 495, 'Margarita');
insert into pizza (name, composition, weight, price, photo)
values ('Мясная BBQ',
        'Колбаса Пепперони, карпаччо из свинины, ветчина, цыпленок копченый, сыр Моцарелла, соусы томатный и барбекю',
        540, 635, 'MeatBBQ');
insert into pizza (name, composition, weight, price, photo)
values ('Пан Картофан',
        'Грудинка, бекон, шампиньоны, марин.огурцы, картофель Айдахо, сыры Моцарелла и Гоюс, чесночный соус',
        710, 565, 'MrPotato');
insert into pizza (name, composition, weight, price, photo)
values ('Дракон',
        'Ветчина, колбаса Пепперони, томаты, марин.огурцы, острый перец халапеньо, сыр Моцарелла, соус из печеных перцев Чипотл',
        615, 565, 'Dragon');

create sequence cart_seq;
create table cart
(
    id       bigint primary key default nextval('cart_seq'),
    user_id  int not null references users (id),
    pizza_id int not null references pizza (id),
    quantity int
);





