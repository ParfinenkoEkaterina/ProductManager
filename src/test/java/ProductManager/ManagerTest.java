package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1,"Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2,"Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3,"Ronny", 600, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testSearch() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1,"Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2,"Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3,"Ronny", 600, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Ronny");

        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    public void testNotAvailable() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1,"Dog Sonya", 600, "Usachev");
        Book book2 = new Book(2,"Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3,"Ronny", 600, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Harry Potter");

        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    public void testReturnThePartOfTheGoods() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 600, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 450, "Lingren");
        Book book4 = new Book(4,"Ronny", 1200, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book3, book4};
        Product[] actual = manager.searchBy("Ronny");

        Assertions.assertArrayEquals(expected, actual);
    }

}
