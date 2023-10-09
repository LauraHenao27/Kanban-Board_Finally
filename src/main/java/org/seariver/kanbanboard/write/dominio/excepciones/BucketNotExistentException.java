package org.seariver.kanbanboard.write.dominio.excepciones;

public class BucketNotExistentException extends DomainException {

    public BucketNotExistentException(Error error) {
        super(error);
    }
}
