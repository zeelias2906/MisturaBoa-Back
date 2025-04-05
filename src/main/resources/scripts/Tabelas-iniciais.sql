create database mistura_boa_db;

-- drop table usuario;
-- drop table pessoa;
-- drop table categoria;
-- drop table produto;

create table pessoa (
	id_pessoa int8 primary key auto_increment,
	nm_pessoa varchar(255),
	cpf varchar(11) unique,
	telefone varchar(11),
	dt_exclusao timestamp,
	dt_nascimento date	
);


create table usuario (
	id_usuario int8 primary key auto_increment,
	email varchar(255) unique,
	senha varchar(255),
	role_usuario varchar(50),
	dt_exclusao timestamp,
	id_pessoa int8,
	constraint fk_pessoa_usuario foreign key (id_pessoa) references pessoa(id_pessoa)
);

create table categoria(
	id_categoria int8 primary key auto_increment,
	nm_categoria varchar(50) not null,
	ds_categoria varchar(255),
	icone_categoria text,
	numero varchar(10) not null,
	dt_exclusao timestamp
);

create table produto(
	id_produto int8 primary key auto_increment,
	nm_produto varchar(50) not null,
	ds_produto varchar(255) not null,
	img_produto longtext not null,
	valor varchar(25),
	numero_produto int not null,
	dt_exclusao timestamp,
	id_categoria int8 not null,
	constraint fk_categoria_produto foreign key (id_categoria) references categoria(id_categoria)
);