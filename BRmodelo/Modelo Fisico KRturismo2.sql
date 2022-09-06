/* Modelo Logico KRturismo2: */

CREATE TABLE Cliente (
    CPF CARACTERE(11) PRIMARY KEY,
    Nome_Cliente Texto,
    Telefone Inteiro,
    CEP Inteiro,
    Rua Texto,
    Numero Inteiro,
    Cidade Texto,
    Estado Texto,
    E_mail Caractere,
    Senha Caractere(8),
    fk_Vendas_NFS Inteiro,
    Numero_Cartao Inteiro,
    Numero_Seguranca Inteiro
);

CREATE TABLE Pacote (
    Cod_Pacote Inteiro PRIMARY KEY,
    Origem Texto,
    Destino Texto,
    fk_Vendas_NFS Inteiro
);

CREATE TABLE Vendas (
    NFS Inteiro PRIMARY KEY,
    Data_Compra Data/Hora,
    CPF_Cliente CARACTERE(11),
    Cod_Pacote Inteiro
);
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_2
    FOREIGN KEY (fk_Vendas_NFS)
    REFERENCES Vendas (NFS)
    ON DELETE RESTRICT;
 
ALTER TABLE Pacote ADD CONSTRAINT FK_Pacote_2
    FOREIGN KEY (fk_Vendas_NFS)
    REFERENCES Vendas (NFS)
    ON DELETE RESTRICT;
 
ALTER TABLE Vendas ADD CONSTRAINT FK_Vendas_2
    FOREIGN KEY (CPF_Cliente???, Cod_Pacote???)
    REFERENCES ??? (???);