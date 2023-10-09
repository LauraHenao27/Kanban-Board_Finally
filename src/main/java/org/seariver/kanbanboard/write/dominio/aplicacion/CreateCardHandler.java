package org.seariver.kanbanboard.write.dominio.aplicacion;

import org.seariver.kanbanboard.write.dominio.cuerpo.Bucket;
import org.seariver.kanbanboard.write.dominio.cuerpo.Card;
import org.seariver.kanbanboard.write.dominio.cuerpo.WriteBucketRepository;
import org.seariver.kanbanboard.write.dominio.cuerpo.WriteCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCardHandler implements Handler<CreateCardCommand> {

    private WriteBucketRepository bucketRepository;
    private WriteCardRepository cardRepository;

    public CreateCardHandler(WriteBucketRepository bucketRepository, WriteCardRepository cardRepository) {
        this.bucketRepository = bucketRepository;
        this.cardRepository = cardRepository;
    }

    public void handle(CreateCardCommand command) {

        Optional<Bucket> bucketOptional = bucketRepository.findByExteranlId(command.getBucketExternalId());
        var bucket = bucketOptional.get();

        var card = new Card()
                .setBucketId(bucket.getId())
                .setExternalId(command.getExternalId())
                .setPosition(command.getPosition())
                .setName(command.getName());

        cardRepository.create(card);
    }
}
