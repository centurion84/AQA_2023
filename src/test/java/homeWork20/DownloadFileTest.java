package homeWork20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static homeWork20.FileHelper.*;
import static org.testng.Assert.assertTrue;

public class DownloadFileTest extends BaseUITest {

    private final List<String> expectedHeaders = Arrays.asList(
            "Manufacturer Id",
            "Period",
            "Glass - Mixed",
            "Aluminium",
            "PET - Clear",
            "PET - Colour",
            "HDPE",
            "Liquid Paper Board",
            "Steel",
            "Other Materials");
    final String expectedRow1 = "1,2023-01,100,200,300,400,500,600,700,800";
    final String expectedRow2 = "2,2023-02,150,250,350,450,550,650,750,850";

    @Test
    public void csvDownloadTest() {

        new DownloadPage(driver).downloadFile();

        String absoluteFilePath = new File(downloadFolderPath).getAbsolutePath();

        // wait until file is downloaded
        String fileName = "/csv_file.csv";
        assertTrue(waitUntilFileIsDownloaded(absoluteFilePath, fileName, 3),
                "File was not downloaded!");

        // Check file extension
        assertTrue(isExtensionCorrect(absoluteFilePath, fileName, ".csv"),
                "File extension is wrong!");

        // Check if file is not empty
        List<String> rows = readFileRows(absoluteFilePath, fileName);
        Assert.assertFalse(rows.isEmpty(), "File is empty");

        // Checking headers
        Assert.assertEquals(getFileHeaders(rows), expectedHeaders,
                "CSV headers are not equal!");

        // checking file content
        Assert.assertTrue(rows.contains(expectedRow1),
                "Row 1 is not equal fo file content");
        Assert.assertTrue(rows.contains(expectedRow2),
                "Row 2 is not equal fo file content");
    }
}