create table accounts
(
    id      varchar(36) primary key,
    number  varchar not null unique,
    balance numeric not null default 0
);

create table clients
(
    id         varchar(36) primary key,
    name       varchar     not null,
    username   varchar     not null unique,
    password   varchar     not null,
    account_id varchar(36) not null,
    constraint fk_account_id foreign key (account_id) references accounts (id)
);

create table cards
(
    id         varchar(36) primary key,
    number     varchar(16) not null,
    date       varchar(5)  not null,
    cvv        varchar(3)  not null,
    account_id varchar(36) not null,
    client_id  varchar(36) not null,
    constraint fk_account_id foreign key (account_id) references accounts (id),
    constraint fk_client_id foreign key (client_id) references clients (id)
);

create table transactions
(
    id      varchar(36) primary key,
    from_id varchar(36) not null,
    to_id   varchar(36) not null,
    amount  numeric     not null,
    constraint fk_from_card_id foreign key (from_id) references cards (id),
    constraint fk_to_card_id foreign key (to_id) references cards (id)
)
