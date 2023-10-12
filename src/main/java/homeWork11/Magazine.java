package homeWork11;

class Magazine extends LibraryMaterial {
    private final String publisher;

    public Magazine(String title, int year, String publisher) {
        super(title, year);
        this.publisher = publisher;
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return getType() + ": \"" + getTitle() + "\" by " + getPublisher() + " (" + getYear() + ")";
    }
}
