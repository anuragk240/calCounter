package util;

import java.text.DecimalFormat;

/**
 * Created by Suhail on 16-06-2016.
 */
public class Utils {

    public static String formatNumber( int value) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String formatted = formatter.format(value);

        return formatted;
    }
}
