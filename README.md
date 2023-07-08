# Tech-Challenge

Desafio desenvolvido para a fase 1 do curso de Architecture Software da FIAP Pós Tech.

## Versão
1.0.0

## Índice
<a href="#tecnologias">Tecnologias</a> •
<a href="#como-rodar">Como rodar</a> •
<a href="#funcionalidades">Funcionalidades</a> •
<a href="#autores">Autores</a>

## Tecnologias
<div style="display: inline_block"><br>
    <img align="center" alt="java" height="50" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg">    
    <img align="center" alt="jspring" height="40" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" />  
    <img align="center" alt="postgre" height="50" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original-wordmark.svg">       
</div>

## Como rodar

```bash
# Clone este repositório
$ git clone https://github.com/PedroVCorsino/Tech-Challenge.git

# Abra o projeto na IDE de sua preferência

# Adicione um arquivo .env com as credenciais do banco de dados

# Rode o arquivo build-and-deploy
$ . ./env && mvn clean package install && docker-compose up -d --build
```

## Funcionalidades
- [x] Criar, editar e remover usuário
- [x] Cadastro de Pedidos por tipo
- [x] Criar, editar e remover produto
- [x] Pedidos com status

## Autores
- Diego Amorim
- Gabriela Ribeiro
- Luzivan Gois
- Pedro Vinicius