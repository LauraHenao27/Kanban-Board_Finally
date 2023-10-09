package org.seariver.kanbanboard.write.dominio.aplicacion;

import org.seariver.kanbanboard.write.dominio.cuerpo.Bucket;
import org.seariver.kanbanboard.write.dominio.cuerpo.WriteBucketRepository;
import org.seariver.kanbanboard.write.dominio.excepciones.BucketNotExistentException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.seariver.kanbanboard.write.dominio.excepciones.DomainException.Error.BUCKET_NOT_EXIST;

@Service
public class UpdateBucketHandler implements Handler<UpdateBucketCommand> {

    private WriteBucketRepository repository;

    public UpdateBucketHandler(WriteBucketRepository repository) {
        this.repository = repository;
    }

    public void handle(UpdateBucketCommand command) {

        Optional<Bucket> bucketOptional = repository.findByExteranlId(command.getExternalId());

        if (!bucketOptional.isPresent()) {
            throw new BucketNotExistentException(BUCKET_NOT_EXIST);
        }

        var bucket = bucketOptional.get();

        bucket.setName(command.getName());

        repository.update(bucket);
    }
}

