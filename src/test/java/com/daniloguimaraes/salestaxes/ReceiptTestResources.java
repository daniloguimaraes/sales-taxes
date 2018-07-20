package com.daniloguimaraes.salestaxes;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;

import java.io.File;

/**
 *
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public class ReceiptTestResources {

    private static final String UTF_8 = "UTF-8";

    protected static String naturalLanguageReceipt1;
    protected static String jsonReceipt1;

    @BeforeClass
    public static void loadReceiptFiles() throws Exception {
        naturalLanguageReceipt1 = FileUtils.readFileToString(
                new File("src/test/resources/receipt/txt/receipt1.txt"), UTF_8);

        jsonReceipt1 = FileUtils.readFileToString(
                new File("src/test/resources/receipt/json/receipt1.json"), UTF_8);
    }
}
