package org.seariver.kanbanboard.write.adaptador.salida;

import helper.DataSourceHelper;
import helper.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.seariver.kanbanboard.write.dominio.cuerpo.Card;
import org.seariver.kanbanboard.write.dominio.cuerpo.WriteCardRepository;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("unit")
class WriteCardRepositoryImplTest extends TestHelper {

    private WriteCardRepositoryImpl repository;

    @BeforeEach
    void setup() {
        repository = new WriteCardRepositoryImpl(new DataSourceHelper());
    }

    @Test
    void MUST_ImplementInterface() {
        assertThat(repository).isInstanceOf(WriteCardRepository.class);
    }

    @Test
    void WHEN_CreatingCard_GIVEN_ValidData_MUST_PersistOnDatabase() {

        // given
        var bucketId = 1L;
        var externalId = UUID.randomUUID();
        var position = faker.number().randomDouble(3, 1, 10);
        var name = faker.pokemon().name();
        var expected = new Card()
                .setBucketId(bucketId)
                .setExternalId(externalId)
                .setPosition(position)
                .setName(name);

        // when
        repository.create(expected);

        // then
        var actualOptional = repository.findByExternalId(externalId);
        Card actual = actualOptional.get();
        assertThat(actual.getBucketId()).isEqualTo(bucketId);
        assertThat(actual.getExternalId()).isEqualTo(expected.getExternalId());
        assertThat(actual.getPosition()).isEqualTo(expected.getPosition());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getCreatedAt()).isBeforeOrEqualTo(LocalDateTime.now());
        assertThat(actual.getUpdatedAt()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}