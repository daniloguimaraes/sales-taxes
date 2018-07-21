package com.daniloguimaraes.salestaxes.model;

/**
 * Product Country of Origin, which can be National or Imported.
 *
 * @author Danilo Guimarães
 * @since 20/07/2018
 */
public enum ProductOrigin {

    NATIONAL,
    IMPORTED;

    public boolean isNational() {
        return this == NATIONAL;
    }

    public boolean isImported() {
        return this == IMPORTED;
    }

}
