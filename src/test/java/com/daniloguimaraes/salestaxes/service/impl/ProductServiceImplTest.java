package com.daniloguimaraes.salestaxes.service.impl;

import com.daniloguimaraes.salestaxes.model.Product;
import com.daniloguimaraes.salestaxes.model.ProductOrigin;
import com.daniloguimaraes.salestaxes.model.ProductType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link ProductServiceImpl}.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl sut;

    @Test
    public void testBookProductFromNaturalLanguage() {
        Product book = sut.fromNaturalLanguage("1 book at 12.49");

        assertThat(book.getAmount()).isEqualTo(1);
        assertThat(book.getDescription()).isEqualTo("book");
        assertThat(book.getShelfPrice()).isEqualTo(new BigDecimal("12.49"));
        assertThat(book.getType()).isEqualTo(ProductType.BOOK);
        assertThat(book.getOrigin()).isEqualTo(ProductOrigin.NATIONAL);
    }

    @Test
    public void testMusicCDProductFromNaturalLanguage() {
        Product musicCd = sut.fromNaturalLanguage("1 music CD at 14.99");

        assertThat(musicCd.getAmount()).isEqualTo(1);
        assertThat(musicCd.getDescription()).isEqualTo("music CD");
        assertThat(musicCd.getShelfPrice()).isEqualTo(new BigDecimal("14.99"));
        assertThat(musicCd.getType()).isEqualTo(ProductType.OTHER);
        assertThat(musicCd.getOrigin()).isEqualTo(ProductOrigin.NATIONAL);
    }

    @Test
    public void testChocolateBarProductFromNaturalLanguage() {
        Product chocolateBar = sut.fromNaturalLanguage("1 chocolate bar at 0.85");

        assertThat(chocolateBar.getAmount()).isEqualTo(1);
        assertThat(chocolateBar.getDescription()).isEqualTo("chocolate bar");
        assertThat(chocolateBar.getShelfPrice()).isEqualTo(new BigDecimal("0.85"));
        assertThat(chocolateBar.getType()).isEqualTo(ProductType.FOOD);
        assertThat(chocolateBar.getOrigin()).isEqualTo(ProductOrigin.NATIONAL);
    }

    @Test
    public void testImportedBoxOfChocolateProductFromNaturalLanguage() {
        Product boxOfChocolate = sut.fromNaturalLanguage("1 imported box of chocolates at 10.00");

        assertThat(boxOfChocolate.getAmount()).isEqualTo(1);
        assertThat(boxOfChocolate.getDescription()).isEqualTo("box of chocolates");
        assertThat(boxOfChocolate.getShelfPrice()).isEqualTo(new BigDecimal("10.00"));
        assertThat(boxOfChocolate.getType()).isEqualTo(ProductType.FOOD);
        assertThat(boxOfChocolate.getOrigin()).isEqualTo(ProductOrigin.IMPORTED);
    }

    @Test
    public void testImportedBottleOfPerfumeProductFromNaturalLanguage() {
        Product importedBottleOfPerfume = sut.fromNaturalLanguage("1 imported bottle of perfume at 47.50");

        assertThat(importedBottleOfPerfume.getAmount()).isEqualTo(1);
        assertThat(importedBottleOfPerfume.getDescription()).isEqualTo("bottle of perfume");
        assertThat(importedBottleOfPerfume.getShelfPrice()).isEqualTo(new BigDecimal("47.50"));
        assertThat(importedBottleOfPerfume.getType()).isEqualTo(ProductType.OTHER);
        assertThat(importedBottleOfPerfume.getOrigin()).isEqualTo(ProductOrigin.IMPORTED);
    }

    @Test
    public void testBottleOfPerfurmProductFromNaturalLanguage() {
        Product bottleOfPerfume = sut.fromNaturalLanguage("1 bottle of perfume at 27.99");

        assertThat(bottleOfPerfume.getAmount()).isEqualTo(1);
        assertThat(bottleOfPerfume.getDescription()).isEqualTo("bottle of perfume");
        assertThat(bottleOfPerfume.getShelfPrice()).isEqualTo(new BigDecimal("27.99"));
        assertThat(bottleOfPerfume.getType()).isEqualTo(ProductType.OTHER);
        assertThat(bottleOfPerfume.getOrigin()).isEqualTo(ProductOrigin.NATIONAL);
    }

    @Test
    public void testPacketOfHeadachePillsProductFromNaturalLanguage() {
        Product bottleOfPerfume = sut.fromNaturalLanguage("1 packet of headache pills at 9.75");

        assertThat(bottleOfPerfume.getAmount()).isEqualTo(1);
        assertThat(bottleOfPerfume.getDescription()).isEqualTo("packet of headache pills");
        assertThat(bottleOfPerfume.getShelfPrice()).isEqualTo(new BigDecimal("9.75"));
        assertThat(bottleOfPerfume.getType()).isEqualTo(ProductType.MEDICAL);
        assertThat(bottleOfPerfume.getOrigin()).isEqualTo(ProductOrigin.NATIONAL);
    }

}