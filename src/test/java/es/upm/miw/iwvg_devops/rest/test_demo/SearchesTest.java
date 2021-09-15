package es.upm.miw.iwvg_devops.rest.test_demo;

import es.upm.miw.iwvg_devops.demo_prueba.Fraction;
import es.upm.miw.iwvg_devops.demo_prueba.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {
    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(List.of("Torres"), new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertEquals(List.of(2, 4, 0, 1, 1), new Searches().findFractionNumeratorByUserFamilyName("Torres")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(List.of("López", "Torres"), new Searches().findUserFamilyNameByFractionDenominator(2)
                .collect(Collectors.toList()));
    }


    @Test
    void testFindUserFamilyNameInitialByAnyProperFraction() {
        assertEquals(List.of("F.", "B.", "L.", "B."), new Searches().findUserFamilyNameInitialByAnyProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdByAnyProperFraction() {
        assertEquals(List.of("1", "2", "3", "5 "), new Searches().findUserIdByAnyProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFractionMultiplicationByUserFamilyName(){
        assertEquals(new Fraction(0, 1),
                new Searches().findFractionMultiplicationByUserFamilyName("Fernandez"));
    }
    @Test
    void testFindFirstFractionDivisionByUserId(){
        assertEquals(new Fraction(0, 1),
                new Searches().findFirstFractionDivisionByUserId("1"));
    }
    @Test
    void testFindFirstDecimalFractionByUserName(){
        assertEquals(new Double(0),
                new Searches().findFirstDecimalFractionByUserName("Oscar"));
    }
}
