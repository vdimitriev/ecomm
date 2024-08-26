create table if not exists product
(
    id                              bigserial    not null primary key,
    product_id                      text,
    name                            text,
    price                           numeric(15,2),
    status                          text
);

create table if not exists image
(
    id                              bigserial    not null primary key,
    image_id                        text,
    product_id                      bigint,
    url                             text,
    priority                        smallint,
    constraint fk_product_image foreign key (product_id) references product(id)
);