package br.com.iguana;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.servers.ServerVariable;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(title = "Iguana Bank API",
                description = "This API is a study case about Quarkus.",
                version = "1.0",
                contact = @Contact(name = "@hugo", url = "")),
        externalDocs = @ExternalDocumentation(url = "https://https://github.com/hugoiguana/iguanasbank", description = "Practising Quarkus code"),
        tags = {
                @Tag(name = "api", description = "Public API that can be used by anybody"),
                @Tag(name = "Users", description = "Users of the Bank Backoffice application.")
        },
        servers = @Server(
                description = "Bank Backoffice Application server",
                url = "http://{host}:{port}/{version}/bank/backoffice",
                variables = {
                        @ServerVariable(name = "host",
                                description = "Bank Backoffice main server",
                                defaultValue = "localhost"),
                        @ServerVariable(name = "port",
                                description = "Bank Backoffice listening port",
                                defaultValue = "80"),
                        @ServerVariable(name = "version",
                                description = "Bank Backoffice",
                                defaultValue = "v1"),
                }
        )
)

public class IguanaBankApplication extends Application {
}
