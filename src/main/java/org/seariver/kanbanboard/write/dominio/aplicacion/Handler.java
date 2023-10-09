package org.seariver.kanbanboard.write.dominio.aplicacion;

public interface Handler<T extends Command> {

    void handle(T command);
}
