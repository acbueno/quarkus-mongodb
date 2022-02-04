package br.com.acbueno.services;

import java.time.LocalDate;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.jboss.logging.Logger;
import br.com.acbueno.domain.Car;
import br.com.acbueno.domain.enums.Brand;
import br.com.acbueno.repository.CarRepository;

@ApplicationScoped
public class CarService {

  @Inject
  CarRepository carRepository;

  @Inject
  Logger logger;

  public Car save(Car car) {
    try {
      carRepository.persist(car);
    } catch (Exception e) {
      logger.errorf("Error persist %s", e.getMessage());
    }
    return car;
  }

  public Car findCarByModelName(String modelName) {
    return carRepository.findByModelName(modelName);
  }

  public Car findByCarYearFactory(LocalDate yearFactory) {
    return carRepository.findByYearFactory(yearFactory);
  }

  public Car findByCarYearModel(LocalDate yearModel) {
    return carRepository.findByYearModel(yearModel);
  }

  public Car findByCarBrand(Brand brandName) {
    return carRepository.findByBrand(brandName);
  }

  public void deleteByModelName(String modelName) {
    carRepository.deleteByModelName(modelName);
  }

  public void deleteByBrandName(Brand brandName) {
    carRepository.deleteByBrandName(brandName);
  }

}
