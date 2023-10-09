package org.seariver.kanbanboard.write.dominio.aplicacion;

import org.seariver.kanbanboard.write.dominio.cuerpo.WriteBucketRepository;
import org.seariver.kanbanboard.write.dominio.excepciones.BucketNotExistentException;
import org.springframework.stereotype.Service;

import static org.seariver.kanbanboard.write.dominio.excepciones.DomainException.Error.BUCKET_NOT_EXIST;

@Service
public class MoveBucketHandler implements Handler<MoveBucketCommand> {

    private final WriteBucketRepository repository;

    public MoveBucketHandler(WriteBucketRepository repository) {
        this.repository = repository;
    }

    public void handle(MoveBucketCommand command) {

        var optionalBucket = repository.findByExteranlId(command.getExteranlId());

        if (optionalBucket.isEmpty()) {
            throw new BucketNotExistentException(BUCKET_NOT_EXIST);
        }

        var bucket = optionalBucket.get();

        bucket.setPosition(command.getPosition());

        repository.update(bucket);
    }
}
