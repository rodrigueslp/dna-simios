package com.meli.simios.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dna")
public class Dna {

    @Id
    private ObjectId id;

    private String[][] dna;

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
}
