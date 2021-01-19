package br.com.iguana.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import br.com.iguana.dtos.UserSystemDto;
import br.com.iguana.entities.UserSystem;
import br.com.iguana.services.UserSystemService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class UserSystemController implements IUserSystemController {

    private static final Logger LOGGER = Logger.getLogger(UserSystemController.class);

    @Inject
    private UserSystemService service;

    @Override
    public Response all() {
        LOGGER.debug("Receiving request to get all Bank Users.");
        List<UserSystemDto> usersDto = UserSystemDto.build(service.findAll());
        return Response.ok(usersDto).build();
    }

    @Override
    public Response getBook(@Parameter(description = "Bank Users identifier", required = true) @PathParam("id") Long id) {
        Optional<UserSystem> user = service.findById(id);
        if (user.isPresent()) {
            LOGGER.debug("Found Bank User " + user.toString());
            UserSystemDto dto = UserSystemDto.build(user.get());
            return Response.ok(dto).build();
        } else {
            LOGGER.debug("No Bank User found with id " + id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response create(
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = UserSystemDto.class))) @Valid UserSystemDto dto
            , @Context UriInfo uriInfo) {

        LOGGER.debug("Receiving request to create a new Bank User.");

        UserSystem userSystem = dto.buildEntity();

        service.insert(userSystem);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(userSystem.id));
        LOGGER.debug("New bank User created with URI " + builder.build().toString());

        return Response.created(builder.build()).build();
    }

    @Override
    public Response update(@RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = UserSystemDto.class))) @Valid UserSystemDto dto) {
        UserSystem userSystem = dto.buildEntity();
        userSystem = service.update(userSystem);
        LOGGER.debug("Bank User updated with new valued " + userSystem.toString());
        return Response.ok().build();
    }

    @Override
    public Response delete(@Parameter(description = "Bank User identifier", required = true) @PathParam("id") Long id) {
        service.delete(id);
        LOGGER.debug("Bank User deleted with id = " + id);
        return Response.noContent().build();
    }

}
