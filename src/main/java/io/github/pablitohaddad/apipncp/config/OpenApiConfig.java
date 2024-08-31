package io.github.pablitohaddad.apipncp.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("REST API - Consulta de Contratos da PNCP")
                                .description("API para consulta de contratos vigentes de acordo com o CNPJ de um órgão público. " +
                                        "Esta API permite filtrar contratos por datas e visualizar detalhes dos contratos, incluindo o valor total." +
                                        " Essa API foi criada a partir do desafio técnico de estágio na NUTI")
                                .version("1.0.0")
                                .contact(new Contact()
                                        .name("Pablo Haddad")
                                        .email("pablohaddad73@gmail.com")
                                        .url("https://www.linkedin.com/in/pablohaddad")) // Adicionando uma extensão personalizada
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Documentação completa da PNCP")
                                .url("https://pncp.gov.br/api/consulta/swagger-ui/index.html") // URL para a documentação externa ou mais informações sobre a API
                );
    }

}
