package org.seariver.kanbanboard.read.dominio.application;

import org.seariver.kanbanboard.read.dominio.cuerpo.BucketDto;

import java.util.List;

public class ListAllBucketsQuery implements Query {
//lista pentientes
    private List<BucketDto> result;

    public List<BucketDto> getResult() {
        return result;
    }

    public void setResult(List<BucketDto> result) {
        this.result = result;
    }
}
