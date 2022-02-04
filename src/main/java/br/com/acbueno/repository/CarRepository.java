package br.com.acbueno.repository;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;

import br.com.acbueno.domain.Car;
import br.com.acbueno.domain.enums.Brand;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class CarRepository implements PanacheMongoRepository<Car> {

  public Car findByModelName(String modelName) {
    return find("modelName", modelName).firstResult();
  }

  public Car findByBrand(Brand brand) {
    return find("modelName", brand).firstResult();
  }

  public Car findByYearFactory(LocalDate yearFactory) {
    return find("modelName", yearFactory).firstResult();
  }

  public Car findByYearModel(LocalDate yearModel) {
    return find("yearModel", yearModel).firstResult();
  }

  public void deleteByModelName(String modelName) {
     delete("modelName", modelName);
  }

  public void deleteByBrandName(Brand brandName) {
    delete("brandName", brandName);
  }

}
