package com.meli.simios.repository;

import com.meli.simios.document.Dna;
import com.meli.simios.enumerator.DnaTypeEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DnaRepository extends MongoRepository<Dna, Long> {

    Dna findByDna(String[][] dna);

    List<Dna> findAllByDnaTypeEnum(DnaTypeEnum dnaTypeEnum);

}
