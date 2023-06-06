#  Wishlist

#### API de uma Wishlist feita em Java 17 com Spring Boot + MongoDB.

# Sumario <!-- omit in toc -->
- [Introducao](#introducao)
- [Instalação](#instalação)
- [Execucao](#execucao)
- [Documentacao](#documentacao)

---

# Introducao
Esta aplicacao foi desenvolvida baseada nos padroes de  **Clean Archtecture** interpretados a partir da seguinte imagem:

![as](https://github.com/Luizfelipe25/cardAPI/assets/69943563/9752d257-00a1-4573-a5a6-266d98496e4b)

Tambem foi utilizada a tecnica **BDD** para alinhar regras de negocio
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

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Então** o serviço deve verificar se o produto foi adicionado a lista de desejos

---

# Instalação
Clone o repositorio:

    git clone https://github.com/Luizfelipe25/wishlist.git
    
## A aplicação pode ser inicializada a partir de um compose
- [Docker](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04)

## Localmente para inicializa-la é necessario:
- [JDK17](https://openjdk.java.net/install/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MongoDB](https://www.mongodb.com/docs/manual/installation/) 
- [Postman](https://learning.postman.com/docs/getting-started/installation-and-updates/)

---

# Execucao

Para rodar via compose, no terminal, navegue até a pasta raiz do projeto e execute:

    docker compose up -d
   

Para rodar localmente:
* Apos instalada as ferramentas, navegue até `src/main/java/com.freedom.wishlist`, clique com o botão direito em `WishlistApplication` e selecione RUN.

* Estara exposta na porta 8082, mas fique a vontade para modificar se necessario, basta alterar o `application.yml` dentro de `resources`, o Mongo tambem esta na porta padrao `:27017`, altere se necessario.

* Para testar a aplicação basta utilizar as urls no Postman. Para rodar os testes unitarios e de integração, no IntelliJ basta clicar com o botao direito na pasta raiz e selecionar  `Run 'all tests'`.
---

# Documentacao
Apos a aplicacao inicializada, e possivel obter a documentacao no link:

```
http://localhost:8082/swagger-ui/index.html
```
