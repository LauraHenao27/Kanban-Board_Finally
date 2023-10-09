package org.seariver.kanbanboard.write.dominio.aplicacion;

import org.seariver.kanbanboard.write.dominio.cuerpo.Bucket;
import org.seariver.kanbanboard.write.dominio.cuerpo.WriteBucketRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateBucketHandler implements Handler<CreateBucketCommand> {

    private final WriteBucketRepository repository;

    public CreateBucketHandler(WriteBucketRepository repository) {
        this.repository = repository;
    }

    public void handle(CreateBucketCommand command) {

        var bucket = new Bucket()
            .setExternalId(command.getExternalId())
            .setPosition(command.getPosition())
            .setName(command.getName());

        repository.create(bucket);
    }
}
