package com.meli.simios;

import com.meli.simios.document.Dna;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends MongoRepository<Dna, Long> {

    Dna findByDna(String[][] dna);

}
