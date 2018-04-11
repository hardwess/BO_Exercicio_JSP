CREATE DATABASE delegacia;
USE delegacia;
CREATE TABLE bo (
	id int PRIMARY KEY AUTO_INCREMENT, 
	numero char(10), 
	rg char(15), 
	nome char(50), 
	tipo char(30), 
	data_ocorrencia date, 
	local char(100), 
	descricao varchar(255)
);