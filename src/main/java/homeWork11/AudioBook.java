package homeWork11;

class Audiobook extends LibraryMaterial {
    private final String author;
    private final Genre genre;

    public Audiobook(String title, int year, String author, Genre genre) {
        super(title, year);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String getType() {
        return "Audiobook";
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return getType() + ": \"" + getTitle() + "\" by " + getAuthor() + " (" + getYear() + "), " + getGenre();
    }
}
