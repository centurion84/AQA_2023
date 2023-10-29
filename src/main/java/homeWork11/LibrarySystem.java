package homeWork11;

import java.util.ArrayList;
import java.util.List;

class LibrarySystem implements Library {
    private final List<LibraryMaterial> materials = new ArrayList<>();

    @Override
    public void checkOut(LibraryMaterial material) {
        materials.remove(material);
        System.out.println("Following was removed from library: " + material);
    }

    @Override
    public void checkIn(LibraryMaterial material) {
        materials.add(material);
        System.out.println("Following was added to library: " + material);
    }

    public void displayMaterials() {
        System.out.println("Materials in the library:");
        for (LibraryMaterial material : materials) {
            System.out.println(material);
        }
    }

    @Override
    public List<LibraryMaterial> searchByKeyword(String keyword) {
        List<LibraryMaterial> results = new ArrayList<>();
        for (LibraryMaterial material : materials) {
            if (material.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    (String.valueOf(material.getYear()).contains(keyword))) {
                results.add(material);
            }
        }
        if (results.isEmpty()) {
            System.out.println("Nothing found!");
        }
        return results;
    }
}
