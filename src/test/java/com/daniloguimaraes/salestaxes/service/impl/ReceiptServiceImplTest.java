package com.daniloguimaraes.salestaxes.service.impl;

import com.daniloguimaraes.salestaxes.ReceiptTestResources;
import com.daniloguimaraes.salestaxes.model.Product;
import com.daniloguimaraes.salestaxes.model.ProductOrigin;
import com.daniloguimaraes.salestaxes.model.ProductType;
import com.daniloguimaraes.salestaxes.model.Receipt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link ReceiptServiceImpl}
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptServiceImplTest extends ReceiptTestResources {

    @Autowired
    private ReceiptServiceImpl sut;
    private Receipt translatedReceipt;
    private Receipt translatedReceipt3;
    private Receipt calculatedReceipt;
    private Receipt calculatedReceipt3;

    @Before
    public void setUp() throws Exception {
        translatedReceipt = sut.translateReceiptFromNaturalLanguage(naturalLanguageReceipt1);
        translatedReceipt3 = sut.translateReceiptFromNaturalLanguage(naturalLanguageReceipt3);
        calculatedReceipt = sut.calculateTaxes(translatedReceipt);
        calculatedReceipt3 = sut.calculateTaxes(translatedReceipt3);
    }

    @Test
    public void testTranslatedReceiptMustBeNotNull() {
        assertThat(translatedReceipt).isNotNull();
    }

    @Test
    public void testTranslatedReceiptMustHasThreeProducts() {
        assertThat(translatedReceipt.getProducts()).hasSize(3);
    }

    @Test
    public void testFirstProductMustBeABook() {
        Product book = translatedReceipt.getProducts().get(0);

        assertThat(book.getAmount()).isEqualTo(1);
        assertThat(book.getDescription()).isEqualTo("book");
        assertThat(book.getShelfPrice()).isEqualTo(new BigDecimal("12.49"));
        assertThat(book.getType()).isEqualTo(ProductType.BOOK);
        assertThat(book.getOrigin()).isEqualTo(ProductOrigin.NATIONAL);
    }

    @Test
    public void testSecondProductMustBeAMusicCD() {
        Product musicCd = translatedReceipt.getProducts().get(1);

        assertThat(musicCd.getAmount()).isEqualTo(1);
        assertThat(musicCd.getDescription()).isEqualTo("music CD");
        assertThat(musicCd.getShelfPrice()).isEqualTo(new BigDecimal("14.99"));
        assertThat(musicCd.getType()).isEqualTo(ProductType.OTHER);
        assertThat(musicCd.getOrigin()).isEqualTo(ProductOrigin.NATIONAL);
    }

    @Test
    public void testThirdProductMustBeAChocolateBar() {
        Product chocolateBar = translatedReceipt.getProducts().get(2);

        assertThat(chocolateBar.getAmount()).isEqualTo(1);
        assertThat(chocolateBar.getDescription()).isEqualTo("chocolate bar");
        assertThat(chocolateBar.getShelfPrice()).isEqualTo(new BigDecimal("0.85"));
        assertThat(chocolateBar.getType()).isEqualTo(ProductType.FOOD);
        assertThat(chocolateBar.getOrigin()).isEqualTo(ProductOrigin.NATIONAL);
    }

    @Test
    public void testCalculatedReceipt() {
        assertThat(calculatedReceipt.getSalesTaxes()).isEqualTo(new BigDecimal("1.499"));
        assertThat(calculatedReceipt.getTotal()).isEqualTo(new BigDecimal("29.83"));
    }

    @Test
    public void testCalculatedReceipt3() {
        assertThat(calculatedReceipt.getSalesTaxes()).isEqualTo(new BigDecimal("1.499"));
        assertThat(calculatedReceipt.getTotal()).isEqualTo(new BigDecimal("29.83"));
    }
}
