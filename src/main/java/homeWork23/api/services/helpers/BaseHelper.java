package homeWork23.api.services.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BaseHelper {

    public static String currentDate() {
        return new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(new Date());
    }
}
