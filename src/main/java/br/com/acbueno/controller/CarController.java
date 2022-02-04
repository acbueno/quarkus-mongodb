package br.com.acbueno.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.acbueno.domain.Car;
import br.com.acbueno.services.CarService;

@Path("/api/car")
public class CarController {

  @Inject
  private CarService carService;

  @POST
  @Path("/insert")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response save(Car car) {
    carService.save(car);
    return Response.accepted().build();
  }

  @GET
  @Path("/find/by/model/{modelName}")
  @Produces(MediaType.APPLICATION_JSON)
  public Car findByModelName(@PathParam("modelName") String modelName) {
     return carService.findCarByModelName(modelName);
  }

}
