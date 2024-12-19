create sequence users_seq;

create table users (
    id bigint primary key default nextval('users_seq'),
    phone_number character varying(20),
    user_name character varying(50),
    password character varying(100)
);

