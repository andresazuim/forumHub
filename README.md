# Fórum Hub - Desafio de Back-end 📋

## Descrição
Este projeto é parte do Desafio do Fórum Hub, um projeto desenvolvido como parte do programa Oracle Next Education na Alura. Ele implementa um sistema de fórum onde usuários autenticados podem criar, listar, atualizar e deletar tópicos.

## Funcionalidades Implementadas 🛠️
- Autenticação JWT para controle de acesso.
- CRUD de tópicos (criar, listar, atualizar, deletar).
- Associação de tópicos a cursos.

## Tecnologias Utilizadas 🚀
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Banco de Dados (Postgresql)
- Postman (para testes de API)

## Como Executar ▶️
1. Clone o repositório: `git clone https://github.com/andresazuim/forumHub.git`
2. Configure o ambiente (configuração do banco de dados, se necessário).
3. Execute a aplicação usando Maven ou sua IDE preferida.
4. Utilize o Insomnia para testar os endpoints conforme descrito abaixo.

## Endpoints 📡
- **POST /login** - Autenticação do usuário para obter token JWT.
- **GET /topicos** - Listar todos os tópicos.
- **POST /topicos** - Criar um novo tópico.
- **PUT /topicos/{id}** - Atualizar um tópico existente.
- **DELETE /topicos/{id}** - Deletar um tópico existente.

## Autor 📝

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/105896691?v=4" width=115><br><sub>Andresa Zuim</sub>](https://github.com/andresazuim) |
| :---: |
