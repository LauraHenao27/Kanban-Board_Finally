package org.seariver.kanbanboard.write.dominio.cuerpo;

import java.util.Optional;
import java.util.UUID;

public interface WriteCardRepository {

    void create(Card card);

    Optional<Card> findByExternalId(UUID externalId);
}
