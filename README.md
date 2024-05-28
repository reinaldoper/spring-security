# java spring-boot user-management
## Este é um projeto backend em Java Spring Boot para gerenciamento de usuários, contendo os campos name, password e email.
- Aplicação com security instalada e tela de login, com usarname:user, e com password:123456
- Pré-requisitos
```jshelllanguage
    JDK 11 ou superior
    Maven
    Docker Compose
```
### Estrutura do Projeto
- src/main/java: Código-fonte da aplicação.
- src/main/resources: Arquivos de configuração.
- docker-compose.yml: Configuração do Docker Compose para a aplicação e banco de dados PostgreSQL.

### Configuração do Banco de Dados
- A aplicação está configurada para usar um banco de dados PostgreSQL. As configurações de conexão estão no arquivo application.properties.

### Como rodar a aplicação
1. Clonar o repositório

2. Construir o projeto com Maven
```jshelllanguage
   mvn clean install
```
3. Rodar o Docker Compose:
```jshelllanguage
   docker-compose up
```
4. A aplicação estará disponível em http://localhost:8080.
5. Endpoints da API
- Criar Usuário
- POST /users

```jshelllanguage
   {
      "name": "John Doe",
      "email": "john.doe@example.com",
      "password": "password123"
   }
```

6. Obter Usuário
- GET /users/{id}

7. Atualizar Usuário
- PUT /users/{id}

```jshelllanguage
   {
      "name": "John Doe",
      "email": "john.doe@example.com",
      "password": "newpassword123"
   }
```

8. Deletar Usuário
- DELETE /users/{id}