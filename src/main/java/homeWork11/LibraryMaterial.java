package homeWork11;

abstract class LibraryMaterial {
    private final String title;
    private final int year;

    public LibraryMaterial(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": " + title + " (" + year + ")";
    }
}
