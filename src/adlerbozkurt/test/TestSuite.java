package adlerbozkurt.test;

import org.junit.runner.*;
import org.junit.runners.*;


/**
 * Diese Klasse vereinigt die beiden TestKlassen, welche MonoAlphabeticCipher und SubstitutionCipher testen
 * @author Philipp Adler
 * @version 2014-04-04
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({TestfallMonoAlphabeticCipher.class,TestfallSubstitutionCipher.class,TestTranspositionCipher.class,
	TestKeyWordCipher.class,TestShiftCipher.class})
public class TestSuite {
}
