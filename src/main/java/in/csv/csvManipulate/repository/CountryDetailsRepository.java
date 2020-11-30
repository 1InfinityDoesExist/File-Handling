package in.csv.csvManipulate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.csv.csvManipulate.entity.CountryDetails;

@Repository
public interface CountryDetailsRepository extends MongoRepository<CountryDetails, String> {

}
