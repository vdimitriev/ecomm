create database ecomm;
create user ecomm with encrypted password 'ecomm';
grant all privileges on database ecomm to ecomm;
alter database ecomm owner to ecomm;