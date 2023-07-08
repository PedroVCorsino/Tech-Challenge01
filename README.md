# Tech-Challenge

Desafio desenvolvido para o curso de Architecture Software da FIAP Pós Tech.

## Versão
1.0.0

## Índice

- [Tecnologias utilizadas](#-tecnologias-utilizadas)
- [Como rodar este projeto](#-como-rodar-este-projeto)
- [Funcionalidades do projeto](#-funcionalidades-do-projeto)
- [Pessoas autoras](#-pessoas-autoras)

## Tecnologias utilizadas
<div style="display: inline_block"><br>
    <img align="center" alt="java" height="50" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg">    
    <img align="center" alt="jspring" height="40" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" />  
    <img align="center" alt="postgre" height="50" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original-wordmark.svg">       
</div>

## Como rodar este projeto

```bash
# Clone este repositório
$ git clone https://github.com/PedroVCorsino/Tech-Challenge.git

# Abra o projeto na IDE de sua preferência

# Adicione um arquivo .env com as credenciais do banco de dados

# Rode o arquivo build-and-deploy
$ . ./env && mvn clean package install && docker-compose up -d --build
```

## Funcionalidades do projeto
- [x] Criar, editar e remover usuário
- [x] Cadastro de Pedidos por tipo
- [x] Criar, editar e remover produto
- [x] Pedidos com status

## Pessoas autoras
- Diego Amorim
- Gabriela Ribeiro
- Luzivan Gois
- Pedro Vinicius