package es.upm.miw.iwvg_devops.rest.test_demo;

import es.upm.miw.iwvg_devops.demo_prueba.Fraction;
import es.upm.miw.iwvg_devops.demo_prueba.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {
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
        assertEquals(List.of("1", "2", "3", "5"), new Searches().findUserIdByAnyProperFraction()
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

    @Test
    void testFindDecimalImproperFractionByUserName(){
        assertEquals(List.of(2.0, 1.3333333333333333),
                new Searches().findDecimalImproperFractionByUserName("Ana")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFirstProperFractionByUserId(){
        assertEquals(new Fraction(-1, 5),
                new Searches().findFirstProperFractionByUserId("2"));
    }

    @Test
    void testFindUserFamilyNameByImproperFraction() {
        assertEquals(List.of("Fernandez", "Blanco", "López", "Blanco", "Torres"),
                new Searches().findUserFamilyNameByImproperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindHighestFraction() {
        assertEquals(new Fraction(1, 0),
                new Searches().findHighestFraction());
    }

    @Test
    void testFindUserNameByAnyImproperFraction() {
        assertEquals(List.of("Oscar", "Ana", "Oscar", "Antonio", "Paula"),
                new Searches().findUserNameByAnyImproperFraction()
                        .collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalFractionByUserName(){
        assertEquals(List.of(2.0, -0.2, 0.5, 1.3333333333333333),
                new Searches().findDecimalFractionByUserName("Ana")
                .collect(Collectors.toList()));
    }

}
