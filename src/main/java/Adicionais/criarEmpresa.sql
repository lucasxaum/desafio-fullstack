/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  User
 * Created: 23 de mar. de 2023
 */


CREATE TABLE `desafio_fullstack_acc`.`empresa` (
  `idEmpresa` INT NOT NULL,
  `cnpj` VARCHAR(45) NULL,
  `nomeFant` VARCHAR(45) NULL,
  `cep` VARCHAR(45) NULL,
  `uf` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `logradouro` VARCHAR(100) NULL,
  PRIMARY KEY (`idEmpresa`),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC) VISIBLE);