# DESAFIO FULLSTACK 1.0

## 1) **PARTICULARIDADES**

Este projeto foi todo desenvolvido em Java e em MySQL. Seu front-end usa pacotes de Java, tal como Swing. Quanto ao back-end, também em Java, faz a interação com o banco de dados em MySQL.

### 1.1) **Estrutura**

O desenvolvimento consta de alguns padrões de projeto: __DAO__, __POJO__ e __MVC__. O padrão DAO é responsável pela interação entre o software e o banco de dados. Isso garante maior segurança durante o desenvolvimento. O POJO seria a estrutura da classe no seu modo mais simples. Ou seja, não consta de elementos externos tal como frameworks. 

O MVC, abreviatura para _Model_, _View_ e _Controller_, é um _design pattern_ que possibilita a divisão do projeto em camadas bem definidas ([Devmedia](https://www.devmedia.com.br/introducao-ao-padrao-mvc/29308)). 

### 1.2) **Banco de Dados**
O esquema do banco do dados (__desafio_fullstack_acc__) consta de 3 tabelas: __empresa__, __fornecedor__ e __oferece__. Sendo que uma empresa possa ter 0 ou mais fornecedores, e o fornecedor, 0 ou mais empresas, isto se caracteriza como uma relação _Many-to-Many_. Logo, a tabela __oferece__ representa a relação entre as duas partes. A tabela abaixo apresenta a descrição no banco de dados.

| empresa    | fornecedor   | oferece       |
|------------|--------------|---------------|
| _idEmpresa_  | _idFornecedor_ | _idoferece_     |
| nomeFant   | nome         | **empresa_id**    |
| cnpj       | cnpj         | **fornecedor_id** |
| cep        | cpf          |               |
| uf         | rg           |               |
| cidade     | data_nasc    |               |
| bairro     | email        |               |
| logradouro | cep          |               |
|            | uf           |               |
|            | cidade       |               |
|            | bairro       |               |
|            | logradouro   |               |

### 1.3) **Interação back-end / BD**
Para a interação entre as tais partes, foi adotado, o Hibernate como persistence. Esse realiza o mapeamento objeto-relacional.