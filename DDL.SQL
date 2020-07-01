
# DDL - Script para criação do data base

#Sequences
create sequence sq_log_id start 1 increment 1;

#Tabelas
create table tb_log (id int8 not null, nome varchar(20) not null, motivo varchar(200) not null, hora varchar(20) not null, ip varchar(20) not null, data date not null, primary key (id));

#Constraint
alter table if exists tb_log add constraint UK_1a693h2eq7woc4bkaunds3bx8 unique (id);






