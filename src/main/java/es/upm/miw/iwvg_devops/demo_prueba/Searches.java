package es.upm.miw.iwvg_devops.demo_prueba;

import org.apache.logging.log4j.LogManager;

import java.awt.geom.QuadCurve2D;
import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
        return new UsersDatabase().findAll()
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::getNumerator);
    }

    public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

    public Stream<String> findUserFamilyNameInitialByAnyProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::properFraction))
                .map(User::initialsFamilyName);
    }

    public Stream<String> findUserIdByAnyProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::properFraction))
                .map(User::getId);
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return new UsersDatabase().findAll()
                .filter(user -> familyName.equals(user.getFamilyName()))
                .flatMap(fractions -> fractions.getFractions().stream())
                .reduce(Fraction::multiplication)
                .orElse(new Fraction());
    }

    public Fraction findFirstFractionDivisionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(fractions -> fractions.getFractions().stream())
                .limit(2)
                .reduce(Fraction::division)
                .orElse(new Fraction());
    }

    public Double findFirstDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(fractions -> fractions.getFractions().stream())
                .findFirst()
                .map(Fraction::decimal)
                .orElse(Double.NaN);
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .allMatch(Fraction::properFraction))
                .map(User::getId);
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(fractions -> fractions.getFractions().stream())
                .filter(Fraction::improperFraction)
                .map(Fraction::decimal);

    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(fractions -> fractions.getFractions().stream())
                .filter(Fraction::properFraction)
                .findFirst()
                .orElse(new Fraction());

    }

    public Stream<String> findUserFamilyNameByImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(fractions -> fractions.getFractions().stream()
                        .anyMatch(Fraction::improperFraction))
                .map(User::getFamilyName);
    }

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .flatMap(fractions -> fractions.getFractions().stream())
                .filter(Fraction::improperFraction)
                .reduce(Fraction::highestFraction)
                .orElse(new Fraction());
    }

    public Stream<String> findUserNameByAnyImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(fractions -> fractions.getFractions().stream()
                        .anyMatch(Fraction::improperFraction))
                .map(User::getName);
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return Stream.empty();
    }

    public Stream<Double> findDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(fractions -> fractions.getFractions().stream())
                .map(Fraction::decimal);
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return Stream.empty();
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return null;
    }

    public Fraction findFirstFractionSubtractionByUserName(String name) {
        return null;
    }
}
