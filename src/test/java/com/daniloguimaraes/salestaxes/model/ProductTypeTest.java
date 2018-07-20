package com.daniloguimaraes.salestaxes.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link ProductType}.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public class ProductTypeTest {

    @Test
    public void testProductTypeMustBeBookWhenDescriptionContainsBook() {
        final ProductType actual = ProductType.infer("book");
        final ProductType expected = ProductType.BOOK;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testProductTypeMustBeFoodWhenDescriptionContainsChocolate() {
        final ProductType actual = ProductType.infer("chocolate");
        final ProductType expected = ProductType.FOOD;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testProductTypeMustBeMedicalWhenDescriptionContainsPills() {
        final ProductType actual = ProductType.infer("pills");
        final ProductType expected = ProductType.MEDICAL;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testProductTypeMustBeOtherWhenDescriptionContainsCD() {
        final ProductType actual = ProductType.infer("music CD");
        final ProductType expected = ProductType.OTHER;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testProductTypeMustReturnNullWhenDescriptionIsEmpty() {
        final ProductType actual = ProductType.infer("");

        assertThat(actual).isNull();
    }

    @Test
    public void testProductTypeMustReturnNullWhenDescriptionIsNull() {
        final ProductType actual = ProductType.infer(null);

        assertThat(actual).isNull();
    }

}