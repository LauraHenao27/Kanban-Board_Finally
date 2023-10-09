package org.seariver.kanbanboard.write.dominio.excepciones;

public class DuplicatedDataException extends DomainException {

    public DuplicatedDataException(Error error, Throwable throwable) {
        super(error, throwable);
    }
}
