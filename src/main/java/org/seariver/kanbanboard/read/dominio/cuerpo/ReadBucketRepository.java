package org.seariver.kanbanboard.read.dominio.cuerpo;

import java.util.List;

public interface ReadBucketRepository {

    List<BucketDto> findAll();
}
