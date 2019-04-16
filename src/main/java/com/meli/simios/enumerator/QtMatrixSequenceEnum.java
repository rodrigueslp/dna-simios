package com.meli.simios.enumerator;

public enum QtMatrixSequenceEnum {

    QT_MAX_SEQUENCE_SIMIAN(4);

    private final int qtMaxSequence;

    QtMatrixSequenceEnum(int qtMaxSequence) {
        this.qtMaxSequence = qtMaxSequence;
    }

    public int getQtMaxSequence() {
        return qtMaxSequence;
    }
}
