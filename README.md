# Sistema de Gerenciamento de Livraria

Projeto desenvolvido em **Java** para consolidar conceitos de **Programação Orientada a Objetos (POO)**. O sistema permite gerenciar o acervo de uma livraria, realizar empréstimos e controlar a disponibilidade de livros.

## Funcionalidades
- Empréstimo de livros disponíveis
- Controle de disponibilidade dos livros
- Registro de empréstimos por cliente
- Listagem de livros emprestados por usuário
- Devolução de livros
- Menu interativo via console

## Tecnologias Utilizadas
* Java
* IntelliJ IDEA
* Git/Github

## Como o sistema funciona

O sistema inicia com dados pré-cadastrados (livros e autores) e apresenta um menu para o usuário:
1. O usuário escolhe uma opção no menu:
    - Emprestar livro
    - Devolver livro
    - Sair

2. Para empréstimo:
    - Lista livros disponíveis
    - Usuário escolhe o ID do livro
    - Informa seu nome
    - Sistema registra o empréstimo

3. Para devolução:
    - Usuário informa seu nome
    - Sistema lista seus livros emprestados
    - Usuário escolhe o livro
    - Sistema realiza a devolução

## Estrutura do projeto

O projeto está organizado em pacotes:

- `app` → Classe principal (Main e menu do sistema)
- `models` → Entidades do sistema:
    - Livro
    - Autor
    - Cliente
    - Emprestimo
- `services` → Regras de negócio e gerenciamento da biblioteca

## Como executar
1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/sistema-livraria-java.git](https://github.com/seu-usuario/sistema-livraria-java.git)
    ```
2. Abra o projeto no IntelliJ IDEA.
3. Execute a classe Main.java



---
_Desenvolvido por [Tathyana Serbêto](https://github.com/tathyanaserbeto)._