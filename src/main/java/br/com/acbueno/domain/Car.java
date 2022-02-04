package br.com.acbueno.domain;

import java.time.LocalDate;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.acbueno.domain.enums.Brand;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;

@Data
@MongoEntity(collection = "Car")
public class Car {

  @BsonProperty("model-name")
  private String modelName;

  @BsonProperty("year-factory")
  private LocalDate yearFactory;

  @JsonProperty("year-model")
  private LocalDate yearModel;

  @JsonProperty("brandName")
  private Brand brandName = Brand.NISSAN;

  @JsonProperty("acessories")
  private List<String> accessories;

}
