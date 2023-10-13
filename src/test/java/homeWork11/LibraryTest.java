package homeWork11;

import org.testng.annotations.Test;

public class LibraryTest {

    @Test
    public static void libraryOperations() {
        Library library = new LibrarySystem();

        Book book1 = new Book("The Great Gatsby", 1925, "F. Scott Fitzgerald", Genre.FICTION);
        Book book2 = new Book("Dune", 1965, "Frank Herbert", Genre.NOVEL);
        Magazine magazine1 = new Magazine("National Geographic", 2023, "National Geographic Society");
        Audiobook audiobook1 = new Audiobook("The Hobbit", 1937, "J.R.R. Tolkien", Genre.FANTASY);

        System.out.println(book1);
        System.out.println(magazine1);
        System.out.println(audiobook1);

        // add to library
        library.checkIn(book1);
        library.checkIn(book2);
        library.checkIn(magazine1);
        library.checkIn(audiobook1);
        library.displayMaterials();

        // remove from library
        library.checkOut(book2);
        library.checkOut(magazine1);
        library.displayMaterials();

        // search in library
        String keyWord = "Dune";
        System.out.println("Materials found for keyword \"" + keyWord + "\" in the library:");
        for (LibraryMaterial material : library.searchByKeyword(keyWord)) {
            System.out.println(material);
        }
    }
}
