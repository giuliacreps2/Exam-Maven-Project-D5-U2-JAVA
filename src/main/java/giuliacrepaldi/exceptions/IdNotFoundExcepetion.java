package giuliacrepaldi.exceptions;

public class IdNotFoundExcepetion extends Exception {

    public IdNotFoundExcepetion(long id) {
        super("Gioco con id:" + id + ", non trovato");
    }
}
