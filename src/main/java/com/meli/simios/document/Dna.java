package com.meli.simios.document;

import com.meli.simios.enumerator.DnaTypeEnum;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dna")
public class Dna {

    @Id
    private ObjectId id;

    private String[][] dna;

    private DnaTypeEnum dnaTypeEnum;

    public Dna() {
    }

    public Dna(ObjectId id, String[][] dna, DnaTypeEnum dnaTypeEnum) {
        this.id = id;
        this.dna = dna;
        this.dnaTypeEnum = dnaTypeEnum;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String[][] getDna() {
        return dna;
    }

    public void setDna(String[][] dna) {
        this.dna = dna;
    }

    public DnaTypeEnum getDnaTypeEnum() {
        return dnaTypeEnum;
    }

    public void setDnaTypeEnum(DnaTypeEnum dnaTypeEnum) {
        this.dnaTypeEnum = dnaTypeEnum;
    }
}
