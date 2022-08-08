
# Parking - REST API

O projeto consiste em um sistema de estacionamento, temos as entradas de carro e no checkout fazemos o cálculo da tarifa.
Utilizamos DTO para cada RESPONSE nos endpoints do controller, e inversão de controle utilizando construtor ao invés do autowired.
Documentação entregue em http://localhost:8081/swagger-ui/ - a aplicação está atualmente online no Heroku.
## Requisitos

- Spring Web
- PostgreSQL -> Driver
- Spring Data JPA
- Hibernate Validator

Retorno dos dados por DTO:
- Model Mapper

Documentação:
- Swagger UI - Swagger 2 - SpringFox starter



## Documentação da API

#### Retorna todos os Alunos

```http
  GET -> /parking/all
```
#### Retorna todos os veículos

```http
  GET -> /parking/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `String` | **Obrigatório** Id |

#### Deleta um veículo

```http
  DELETE /aluno/excluir/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `String` | **Obrigatório** Id |

#### Novo veículo

```http
  POST /parking/new
```
Os dados serão recebidos via @RequestBody onde o objeto ParkingDTO fará a validação e salvará com o repository (na camada de serviço), o retorno se dá através do método que trata nossos dados da classe mãe para DTO.

#### Editar veículo

```http
  PUT /parking/update/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `String` | **Obrigatório** Id |

Aqui iremos receber o id instanciar seu objeto substituindo os parâmetros recebidos via @RequestBody, utilizaremos ParkingDTO para esse fim e salvaremos depois com o repository na camada de serviço (utilizando no controller a DTO).

#### Checkout

```http
  POST /parking/checkout/{id}
```

Aqui nós passamos o id do veículo e na camada de serviço à parte "ParkingCheckout" nós recebemos as datas de início e do checkout feito ao acessar a URI para calcular pelo tempo a taxa paga, a diária custa 20, o fixo é 5, e o adicional por hora é 2.

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `String` | **Obrigatório** Id |

Orientações para documentação:

Na versão presente do Swagger, para documentar utilizamos as seguintes dependências:

        <dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-boot-starter</artifactId>
			<version>3.0.0</version>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2 </artifactId>
			<version>3.0.0</version>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>3.0.0</version>
		</dependency>

Após declaração das dependências, nós criamos a classe de configuração do Swagger em um package "config"

#### SwaggerConfig:

    @Configuration
    @EnableSwagger2 
    public class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("one.digitalinovation.cloudparking"))
                    .build()
                    .apiInfo(metadata());
        }
        private ApiInfo metadata(){
            return new ApiInfoBuilder()
                    .title("Parking REST Api")
                    .description("Api Rest em conformidade com os Design Patterns, " +
                            "utilizando ModelMapper para aplicação das DTOs, utilizamos aqui" +
                            " Spring Data JPA com Hibernate Validator, PostgreSQL, Spring Web e " +
                            "Spring Security")
                    .version("1.0.0")
                    .build();
        }
    }

Atenção essa linha indica quais endpoints devem ser expostos na API de documentação -> Todos a partir do pacote indicado:
#### .apis(RequestHandlerSelectors.basePackage("one.digitalinovation.cloudparking"))

Por fim para personalização dos metadados na API utilizamos:
#### .apiInfo(metadata());
Que é a função chamada logo após.
## Melhorias

Configurar o Spring Security com JWT ao invés da autenticação básica
## Dio - Digital Inovation One #Campus Expert - Turma4

- [linkedin @carlossfb](https://www.linkedin.com/in/carlossfb/)

