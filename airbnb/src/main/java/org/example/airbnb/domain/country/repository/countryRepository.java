package org.example.airbnb.domain.country.repository;

import org.example.airbnb.domain.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface countryRepository extends JpaRepository<Country, Long> {

}
