package br.com.iguana;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
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
                @Tag(name = "api", description = "Public API that can be used by anybody")
        }
)

public class IguanaBankApplication extends Application {
}
