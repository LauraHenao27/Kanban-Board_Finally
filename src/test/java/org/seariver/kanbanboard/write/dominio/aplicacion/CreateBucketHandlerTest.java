package org.seariver.kanbanboard.write.dominio.aplicacion;

import helper.TestHelper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.seariver.kanbanboard.write.dominio.cuerpo.Bucket;
import org.seariver.kanbanboard.write.dominio.cuerpo.WriteBucketRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@Tag("unit")
public class CreateBucketHandlerTest extends TestHelper {

    private ArgumentCaptor<Bucket> captor = ArgumentCaptor.forClass(Bucket.class);

    @Test
    void GIVEN_ValidCommand_MUST_CreateBucketInDatabase() {

        // given
        var externalId = UUID.randomUUID();
        var position = faker.number().randomDouble(3, 1, 10);
        var name = faker.pokemon().name();
        var command = new CreateBucketCommand(externalId.toString(), position, name);
        var repository = mock(WriteBucketRepository.class);

        // when
        var handler = new CreateBucketHandler(repository);
        handler.handle(command);

        // then
        verify(repository).create(captor.capture());
        var bucket = captor.getValue();
        assertThat(bucket.getExternalId()).isEqualTo(externalId);
        assertThat(bucket.getPosition()).isEqualTo(position);
        assertThat(bucket.getName()).isEqualTo(name);
    }
}
