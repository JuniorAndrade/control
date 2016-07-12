#### Descrição do Sistema Controle de Compra e Venda
Este sistema deve apresentar funcionalidades parecidas como os presentes em um controle de estoque de uma farmácia, supermercado, ou qualquer outro tipo de estabelecimento de vendas de produtos.

#### Tecnologias Back-End
* Spring Framework
* Spring Security
* Hibernate
* JSP
* Maven

#### Tecnologias Front-End
  * AdminLTE
  * HTML5
  * CSS3
  * JQuery
  * DataTables

#### Configuração
Na pasta resources modificar os parâmetros do arquivo application.properties

```
jdbc.url = jdbc:mysql://localhost/nome-da-tabela
jdbc.username = senha do mysql
jdbc.password = senha do mysql caso não tenha deixar em branco
```

#### Adicionando usuário

Executar as querys abaixo.

Usuário.: admin
Senha.: abc125

```sql
INSERT INTO app_user(sso_id, password, first_name, last_name, email)
VALUES ('admin','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Silvio','Santos','meu@email.com');
```

Inserido permissões
```sql
INSERT INTO user_profile(type)
VALUES ('USER');
  
INSERT INTO user_profile(type)
VALUES ('ADMIN');
```

Atribuindo permissão
```sql
INSERT INTO app_user_user_profile (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id = 'admin' and profile.type = 'ADMIN';
```