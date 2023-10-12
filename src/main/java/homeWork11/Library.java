package homeWork11;

import java.util.List;

interface Library {
    void checkOut(LibraryMaterial material);

    void checkIn(LibraryMaterial material);

    List<LibraryMaterial> searchByKeyword(String keyword);

    void displayMaterials();
}
