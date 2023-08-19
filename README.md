# Tech-Challenge

Desafio desenvolvido com DDD e Arquitetura Hexagonal para a fase01 do curso de Software Architecture da FIAP Pós Tech.

## Versão
1.0.0

## Índice
<a href="#tecnologias">Tecnologias</a> •
<a href="#requisitos-minimos">Requisitos minimos</a> •
<a href="#como-rodar">Como rodar</a> •
<a href="criterios-de-aceite">Criterios de aceite</a> •
<a href="#autores">Autores</a>

## Tecnologias
<div style="display: inline_block"><br>
    <img align="center" alt="java" height="50" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg">    
    <img align="center" alt="jspring" height="40" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" />  
    <img align="center" alt="postgre" height="50" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original-wordmark.svg">       
</div>

## Requisitos minimos
- JDK 17
- maven 3.6.3 ou superior
- docker e docker-compose

## Como rodar
Clone este repositório
```bash
$ git clone https://github.com/PedroVCorsino/Tech-Challenge.git
```
- Abra o projeto na IDE de sua preferência

- Adicione um arquivo .env com as credenciais do banco de dados, use o arquivo env-example como base.

- Rode o arquivo build-and-deploy
```bash
$ ./build-and-deploy
```

## Crieterios de aceite
### Documentação do sistema (DDD) utilizando a linguagem ubíqua.

### Domínios
- Subdomínio Principal:
    - Comida
- Subdomínio Genérico:
    - Lógica de pagamento integrada ao mercado pago.
- Subdomínio Suporte:
    - Gestão de estoque,
    - funcionários, clientes,
    - estratégias de marketing


### Contextos delimitados

- Pedido (Realização do pedido e pagamento) 
  ![image](https://github.com/PedroVCorsino/Tech-Challenge/assets/61948860/0c627219-8fb8-4bdc-b88a-3d0db6087973)

- Cozinha (Preparação e entrega do pedido)
  ![image](https://github.com/PedroVCorsino/Tech-Challenge/assets/61948860/823b0576-5524-4397-9411-6805505dfb85)

### Dicionário de linguagem ubíqua
- Identificação: Pode se identificar usando CPF, nome, e-mail ou não se identificar.
- Produto: Quaisquer itens vendidos pela lanchonete, divididos nas categorias Lanche, Acompanhamento, Bebida e Sobremesa.
- Combo: É uma oferta especial que combina um lanche, um acompanhamento, uma bebida e uma sobremesa por um preço promocional.
- Lanche: Refere-se ao item principal do cardápio, geralmente um sanduíche ou hambúrguer, ou uma opção de refeição vegana.
 - Acompanhamento: É uma opção adicional que pode ser escolhida juntamente com o lanche. Pode incluir batatas fritas, nuggets, onion rings, salada, ou outras opções de acompanhamentos.
- Bebida: São as opções líquidas disponíveis para serem consumidas junto com o lanche. Isso pode incluir refrigerantes, sucos, água, chás gelados, milkshakes, entre outros.
- Sobremesa: Refere-se a um item do cardápio que é servido após a refeição principal. Pode incluir opções como sorvetes, tortas, bolos, milkshakes especiais ou outras delícias doces.
- Categoria: Ou tipo, se refere a qual tipo de produto entre as opções lanche, acompanhamento, bebida e sobremesa.
---

 ### Api 
 - Após subir a aplicação recomendo usar o Swagger para testar os endpoints
     - http://localhost:8080/swagger-ui/index.html
       
### Cliente `/api/cliente`
- Cadastro de cliente
    - http://localhost:8080/swagger-ui/index.html#/cliente-controller/createCliente
    - Ou um `POST` para `/api/cliente` com o json:
  ```
    {
      "cpf": "86342853088",
      "nome": "José",
      "email": "joao@example.com"
    }

- Identificação do Cliente via CPF
    - http://localhost:8080/swagger-ui/index.html#/cliente-controller/getClienteByCpf
    - Ou `GET` para `/api/cliente/cpf/{cpf}`

### Produto `/api/produtos/`
- Cada categoria de produto possui seu proprio endpoint

- ex: com lanche
    - http://localhost:8080/swagger-ui/index.html#/lanche-controller/createLanche
    - ou `POST` para `/api/produtos/lanche` com o json:
      ```
      {
        "nome": "Hambúrguer de siri",
        "descricao": "Receita secreta",
        "preco": 10.99
      }
- Para editar o produto, digamos que queremos aumentar o preço.
    - http://localhost:8080/swagger-ui/index.html#/lanche-controller/updateLanche
    - ou `PUT` `api/produtos/lanche/{id}' com json:
    ```
      {
        "nome": "Hambúrguer de siri",
        "descricao": "Receita secreta",
        "preco": 15.99
      }
- Para remover
    -  http://localhost:8080/swagger-ui/index.html#/lanche-controller/deleteLanche
    -  ou `delete` para `/api/produtos/lanche/id`
  - Lembrando que não é possivel deletar produtos que ja estão vinculados a algum pedido.

  - Buscar por categoria
      - http://localhost:8080/swagger-ui/index.html#/produtos-controller/getProdutosByTipo
      - Ou `GET` para `/api/produtos/tipo/{tipo}`
   
### Pedido `/api/pedido`
- Para cadastrar um novo pedido
    - http://localhost:8080/swagger-ui/index.html#/pedido-controller/createPedido
    - Ou um `POST` para `/api/pedido` com o seguinte json:
      ```
        {
            "id": 0,
            "idCliente": 1,
            "combos": [
                {
                    "id": 0,
                    "lanche": {
                        "id": 1,
                        "nome": "Hambúrguer",
                        "descricao": "Delicioso hambúrguer artesanal",
                        "preco": 10.99
                    },
                    "acompanhamento": {
                        "id": 1,
                        "nome": "Batata Frita",
                        "descricao": "Porção de batatas fritas crocantes",
                        "preco": 5.99
                    },
                    "bebida": {
                        "id": 1,
                        "nome": "Refrigerante",
                        "descricao": "Bebida gaseificada sabor cola",
                        "preco": 4.99
                    },
                    "sobremesa": {
                        "id": 5,
                        "nome": "Torta de Limão",
                        "descricao": "Torta doce com recheio de limão",
                        "preco": 6.99
                    },
                    "quantidade": 1,
                    "valorUnitario": 28.96,
                    "valorTotal": 28.96
                }
            ],
            "valorTotal": 28.96,
            "status": "PENDENTE",
            "pago": false
      }
#### Para verificar o pagamento dos pedidos
- Recomendo começar verificando quais pedidos estao com status-pagamento = false
    - http://localhost:8080/swagger-ui/index.html#/pedido-controller/getPedidosByStatusPagamento
    - ou `GET` para `/api/pedido/status-pagamento?pago=false`
- Selecionar o id de algum pedido e enviar para
    - http://localhost:8080/swagger-ui/index.html#/pedido-controller/verificaPagamento
    - ou `GET` para `/api/pedido/verifica-pagamento/{id}`
- Aqui a aplicação ira verificar se o pedido realmente consta como não pago no banco, e se for o caso ira fazer uma consulta para uma api de paramentos externa. O retorno sera true caso o pedido esteja pago, e o mesmo tera seu status-pagamento atualizado.

- Listar pedidos
    - http://localhost:8080/swagger-ui/index.html#/pedido-controller/getAllPedidos
    - ou `GET` para `/api/pedido/all`

- Se preferir pode listar pelo status de andamento do pedido
    -  http://localhost:8080/swagger-ui/index.html#/pedido-controller/getPedidosByStatus
    -  ou `GET` para `/api/pedido/status/{status}`
  
  

## Autores
- [Diego Amorim](https://github.com/dieg0amorim)
- [Gabriela Ribeiro](https://github.com/gabsribeiro)
- [Luzivan Gois](https://github.com/luzivanmgois)
- [Pedro Vinicius](https://github.com/PedroVCorsino)
