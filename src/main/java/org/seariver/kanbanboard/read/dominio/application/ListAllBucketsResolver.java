package org.seariver.kanbanboard.read.dominio.application;

import org.seariver.kanbanboard.read.dominio.cuerpo.BucketDto;
import org.seariver.kanbanboard.read.dominio.cuerpo.ReadBucketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllBucketsResolver implements Resolver<ListAllBucketsQuery> {

    private ReadBucketRepository repository;

    public ListAllBucketsResolver(ReadBucketRepository repository) {
        this.repository = repository;
    }

    public void resolve(ListAllBucketsQuery query) {

        List<BucketDto> result = repository.findAll();
        query.setResult(result);
    }
    //voy a Recuperar la información necesaria y la establezco como resultado del query
}
