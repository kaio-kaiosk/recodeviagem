create database krturismo;
use krturismo;

create table cliente(
	cpf varcharacter (11)primary key,
    nomeCliente varchar(60),
    telefone int,
    cep int,
    rua text,
    numero int,
    cidade text,
    estado text,
    email text,
    senha varcharacter(8),
    nf int,
    numeroCartao int,
    fk_Vendas_NFS Int);
    
create table pacote (
    Cod_Pacote Int primary key,
    Origem Text,
    Destino Text,
    fk_Vendas_NFS Int);

CREATE TABLE Vendas (
    NFS Int PRIMARY KEY,
    Data_Compra date,
    fk_CPF_Cliente varcharacter(11),
    fk_Cod_Pacote Int);
    
ALTER TABLE cliente ADD CONSTRAINT FK_Cliente_2
    FOREIGN KEY (fk_Vendas_NFS)
    REFERENCES vendas (NFS)
    ON DELETE RESTRICT;
 
ALTER TABLE pacote ADD CONSTRAINT FK_Pacote_2
    FOREIGN KEY (fk_Vendas_NFS)
    REFERENCES Vendas (NFS)
    ON DELETE RESTRICT;
 
ALTER TABLE Vendas ADD CONSTRAINT FK_Vendas_2
    FOREIGN KEY (fk_CPF_Cliente)
    REFERENCES  cliente (CPF);
    
ALTER TABLE Vendas ADD CONSTRAINT FK_Vendas_1
    FOREIGN KEY (fk_Cod_Pacote)
    REFERENCES  pacote (Cod_Pacote);
