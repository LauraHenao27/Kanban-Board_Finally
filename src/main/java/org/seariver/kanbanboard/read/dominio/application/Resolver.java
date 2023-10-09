package org.seariver.kanbanboard.read.dominio.application;

public interface Resolver<T extends Query> {

    void resolve(T query);
}
