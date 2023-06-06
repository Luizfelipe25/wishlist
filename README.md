#  Wishlist

#### API de uma Wishlist feita em Java 17 com Spring Boot + MongoDB.

# Sumário <!-- omit in toc -->
- [Introdução](#introdução)
- [Instalação](#instalação)
- [Execução](#execução)
- [Documentação](#documentação)
- [Próximos passos](#próximos-passos)

---

# Introdução
Esta aplicação foi desenvolvida baseada nos padrões de  **Clean Archtecture** interpretados a partir da seguinte imagem:

![as](https://github.com/Luizfelipe25/cardAPI/assets/69943563/9752d257-00a1-4573-a5a6-266d98496e4b)

Também foi utilizada a técnica **BDD** para alinhar regras englobando **TDD** no desenvolvimento
> **Contexto**: 

> &nbsp;&nbsp;  **Dado** que o usuário esteja logado no sistema

> &nbsp;&nbsp;&nbsp;&nbsp;**Cenário**: Adicionar produto na Lista de Desejos

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Quando** o Client enviar um produto para para ser adicionado á lista de desejos

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**E** a lista de desejos possuir menos que 20 produtos

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**E** o produto ainda nao estiver na lista

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Então** o serviço deve salvar no banco o produto em questão.

> &nbsp;&nbsp;&nbsp;&nbsp;**Cenário**: Remover produto da Lista de Desejos

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Quando** o Client enviar um produto para ser removido da lista de desejos 

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Então** o serviço deve deletar no banco o produto em questão.

> &nbsp;&nbsp;&nbsp;&nbsp;**Cenário**: Consultar produtos da Lista de Desejos

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Quando** o Client consultar os produtos da lista de desejos pelo usuário

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Então** o serviço deve retornar os produtos adicionados a lista de desejos do usuario em questão

> &nbsp;&nbsp;&nbsp;&nbsp;**Cenário**: Consultar se a lista de desejos possui um produto

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Quando** o Client enviar um produto para consulta na lista de desejos 

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Então** o serviço deve retornar True se o produto foi adicionado a lista de desejos previamente, False caso não.

---

# Instalação
Clone o repositório:

    git clone https://github.com/Luizfelipe25/wishlist.git
    
## A aplicação pode ser inicializada a partir de um compose:
- [Docker](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04)

## Ou localmente:
- [JDK17](https://openjdk.java.net/install/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MongoDB](https://www.mongodb.com/docs/manual/installation/) 
- [Postman](https://learning.postman.com/docs/getting-started/installation-and-updates/)

---

# Execução

Para rodar via compose, no terminal, navegue até a pasta raiz do projeto e execute:

    docker compose up -d

* A api estará exposta na porta `8080` e o Mongo na porta padrão `:27017` (certifique-se de parar qualquer outra execução nessas portas ou alterá-las no compose).

* Após executado, pode enviar um `GET` para a url `http://localhost:8080/actuator/health` para observar a saúde da aplicação e do banco. Deverá retornar o status `UP` se estiver tudo OK.

Para rodar localmente:
* Após instalada as ferramentas navegue até a pasta `resources` abra o arquivo `application.yml` e altere o path do MongoDB (Basta comentar a `Linha 7` e descomentar a `Linha 6`).

* A api estará exposta na porta `8080`, mas fique a vontade para modificar se necessário, também no `application.yml`. O Mongo tambem estrá na porta padrão `:27017`, altere se necessário.

* Após realizar a configuração necessária, navegue até `src/main/java/com.freedom.wishlist`, clique com o botão direito em `WishlistApplication` e selecione RUN.

* Para testar a aplicação basta utilizar as urls no Postman. Para rodar os **testes unitários e de integração**, no IntelliJ basta clicar com o botão direito na pasta raiz e selecionar  `Run 'all tests'`.
---

# Documentação
Com a aplicacão inicializada, é possivel obter a documentação no link:

```
http://localhost:8080/swagger-ui/index.html
```

# Próximos passos
* Adição de logs na aplicação.
* improvements na observabilidade.
* improvements para melhora de performance.

