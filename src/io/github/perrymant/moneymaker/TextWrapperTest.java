package io.github.perrymant.moneymaker;

import org.junit.Test;

public class TextWrapperTest {

    @Test
    public void canWrapWithLineLength_20() {
        String description = "800Kg of diamonds from Sierra Leone";
        System.out.println(TextWrapper.wrap(description));
    }

    @Test
    public void canWrapColumn_followingColumnToOriginalRow() {
        String description = "800Kg of diamonds from Sierra Leone";
        String balance = "125";
        System.out.println(TextWrapper.wrap(description) + balance);
    }
}