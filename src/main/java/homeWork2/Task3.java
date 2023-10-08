package homeWork2;

public class Task3 {
    public static void main(String[] args) {
        // Define the base side length and height of the pyramid
        double L = 10.5;
        double H = 15.0;

        // Calculate the area of the base
        double S_base = L * L;

        // Calculate the volume of the pyramid
        double V_pyramid = (S_base * H) / 3.0;

        // Display the result
        System.out.println("The volume of the pyramid is: " + V_pyramid);
    }
}
