package com.meli.simios.service;

import com.meli.simios.dto.StatsDto;
import com.meli.simios.enumerator.DnaTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private DnaService dnaService;

    public StatsDto getStatsMutantAndHuman() {

        int count_human_dna = (dnaService.findAllByDnaTypeEnum(DnaTypeEnum.HUMAN) != null) ? dnaService.findAllByDnaTypeEnum(DnaTypeEnum.HUMAN).size() : 0;
        int count_simian_dna = (dnaService.findAllByDnaTypeEnum(DnaTypeEnum.MUTANT) != null) ? dnaService.findAllByDnaTypeEnum(DnaTypeEnum.MUTANT).size() : 0;

        StatsDto statsDto = new StatsDto();
        statsDto.setCount_human_dna(count_human_dna);
        statsDto.setCount_mutant_dna(count_simian_dna);
        if (statsDto.getCount_human_dna() > 0) {
            float ratio = (float) statsDto.getCount_mutant_dna() / (float) statsDto.getCount_human_dna();
            statsDto.setRatio(ratio);
        } else {
            statsDto.setRatio(statsDto.getCount_mutant_dna());
        }

        return statsDto;

    }



}
