# Consumo de API da PNCP

Olá, bem-vindo(a) a API que consome os dados da PNCP. Desenvolvida em Java com Spring Boot, essa API gera dados de contratos realizado por órgãos e armazena em um banco de dados MySQL. Utilizei tecnologias como Docker, Spring MVC, OpenAPI (Swagger), OpenFeign, ModelMapper, MySql, Spring JPA e JDBC Railway para deploy, dentre outras.

# Visão Geral

1. Esse projeto é o back-end da aplicação, o front-end está localizado no repositório: [REPO-FRONT-END](https://github.com/pablitohaddad/nuti-seletivo-front-end)

2. Se você quer ver a documentação do projeto, ela está localizada nesse link: DOC-BACK-END

2. Não é necessário rodar localmente tanto o back-end, quando o front-end, estarei dispobibilizando tutoriais para fazer isso. Acesse o repositório do front-end para testar a aplicação online (O link estará lá). 

2. O motivo da criação dessa API é cumprir o desafio técnico para estágio na NUTI. 

## Criador

| E-mail              | Usuário GitHub |
|---------------------|----------------|
| pablohaddad73@gmail.com  | pablitohaddad    |

## Configuração

A API está com deploy pelo Railway, mas se você quiser roda-la localmente, siga esse tutorial:

1. Clone o repositório:
 
```bash
git clone https://github.com/pablitohaddad/nuti-seletivo-back-end.git
```
 
2. Configure o banco de dados no arquivo `application.properties`. Substitua as propriedades que estão atualmente por:

```bash
# Configurações mínimas no properties
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/api_pncp
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

3. Execute os comandos para ativar o docker compose:
```bash
docker-compose up -d  #Criará um container com o nome mysql-container, se já existir algum com esse nome, pule esse passo
```
4. Execute a aplicação:
 
```bash
mvn spring-boot:run
```

## Endpoint da API

### `GET /api/consulta/v1/contracts`
 
Recupera e salva no banco de dados os contratos feitos pelos órgãos. Existem 4 query params obrigatórios. São eles dataInicial, dataFinal, pagina=1 cnpjOrgao.

Um exemplo de requisição: /api/consulta/v1/contracts?dataInicial=20240823&dataFinal=20241230&pagina=1&cnpjOrgao=00396895000125
 
**Exemplo de resposta:**
```json
"data": [
    {
      "orgaoEntidade": {
        "id": null,
        "cnpj": "00396895000125",
        "esferaId": "F",
        "razaoSocial": "MINISTERIO DA AGRICULTURA, PECUARIA E ABASTECIMENTO",
        "poderId": "E"
      },
      "dataVigenciaInicio": "2024-08-26",
      "dataVigenciaFim": "2024-12-31",
      "objetoContrato": "PRAZO DE ENTREGA DE ACORDO COM O EDITAL DO PREGÃO 90003-2024, UASG 130103.",
      "valorInicial": "975.0000",
      "nomeRazaoSocialFornecedor": "VISAO E ARTE INDUSTRIA E COMERCIO DE EMBALAGENS LTDA"
    },
```

## Url no Railway

A api está na nuvem da plataforma Railway no caminho: [URL-BACK-END](https://nuti-seletivo-back-end-production.up.railway.app)

### Importante

```json
{  
"Certifique-se de que a data está no formato yyyyMMdd"
"Se você não estiver utilizando o frontend da aplicação, coloque o query param 'pagina=1'"
"Optei por não deixar público o id dos órgãos, por motivos de segurança."
"Por serem dados apenas de consulta, optei por utilizar ddl-auto=create_drop"
}
```
### Detalhes técnicos da API

1. Optei por não deixar público o id dos órgãos, por motivos de segurança.

2. Por serem dados apenas de consulta, optei por utilizar um padrão de "criar e destruir" o banco de dados. Economizando espaço de disco. Então os dados se perdem a cada parada que a aplicação faz.























