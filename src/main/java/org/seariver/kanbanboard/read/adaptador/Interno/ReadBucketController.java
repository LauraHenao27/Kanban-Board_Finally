package org.seariver.kanbanboard.read.adaptador.Interno;

import org.seariver.kanbanboard.common.ServiceBus;
import org.seariver.kanbanboard.read.dominio.application.ListAllBucketsQuery;
import org.seariver.kanbanboard.read.dominio.cuerpo.BucketDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/buckets")
public class ReadBucketController {

    private ServiceBus serviceBus;

    public ReadBucketController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @GetMapping
    public ResponseEntity<List<BucketDto>> listAll() {

        var query = new ListAllBucketsQuery();

        serviceBus.execute(query);

        return ResponseEntity.ok(query.getResult());
    }
}
