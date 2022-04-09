package br.com.api.test.services.api.controllers;

import br.com.api.test.application.auth.dtos.UserDto;
import br.com.api.test.application.auth.services.IUserService;
import br.com.api.test.application.base.dtos.ResultJson;
import br.com.api.test.application.base.dtos.enums.StatusCodeEnum;
import br.com.api.test.services.base.controllers.BaseController;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/api")
public class AuthController extends BaseController {
  @Inject IUserService service;

  @GET
  @Path("auth/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResultJson get(@PathParam String id) {
    var dto = service.getById(id);
    var result = new ResultJson();
    result.setCode(StatusCodeEnum.OK_200);
    result.setSuccess(true);
    result.setMessage("Success!");
    result.setResponseObject(dto);
    return result;
  }

  @GET
  @Path("auth")
  @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
  public ResultJson getAll() {

    try {
      var data = service.getAll();
      return response(StatusCodeEnum.OK_200, data);
    } catch (Exception e) {
      return response(e);
    }
  }

  @POST
  @Path("auth")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResultJson post(UserDto dto) {

    try {
      service.create(dto);
      return response(StatusCodeEnum.CREATED_201, dto);
    } catch (Exception e) {
      return response(e);
    }
  }

  @PUT
  @Path("auth")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResultJson put(UserDto dto) {

    try {
      service.update(dto);
      return response(StatusCodeEnum.OK_200, dto, "Updated!");
    } catch (Exception e) {
      return response(e);
    }
  }

  @DELETE
  @Path("auth/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ResultJson delete(@PathParam String id) {

    try {
      service.delete(id);
      return response(StatusCodeEnum.NO_CONTENT_204, null, "Deleted!");
    } catch (Exception e) {
      return response(e);
    }
  }
}
