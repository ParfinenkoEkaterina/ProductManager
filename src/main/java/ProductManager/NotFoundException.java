package ProductManager;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super(" Товар с id " + id + " не найден ");
    }
    public  AlreadyExistsException(int id) {
        super(" Товар с id " + id + " уже существует ");
    }

}
