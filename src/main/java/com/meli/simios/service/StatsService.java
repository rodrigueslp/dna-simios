package com.meli.simios.service;

import com.meli.simios.DnaRepository;
import com.meli.simios.util.MatrixSequenceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private DnaRepository dnaRepository;

    @Autowired
    private MatrixSequenceUtil matrixSequenceUtil;

}
