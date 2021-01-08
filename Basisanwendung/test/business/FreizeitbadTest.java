//Praktikum 4: 4.4 Test mit JUnit 5
package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.Test;
import ownUtil.PlausiException;

class FreizeitbadTest {

	@Test
	void konstruktorTest() throws PlausiException {
		Freizeitbad fzb = new Freizeitbad("Stadtbad","7.00","17.00","25","24");
		
		//Benutzen Sie assertTrue und einen booleanSupplier, welcher überprüft, ob die Beckenlänge im Konstruktor auf 25 gesetzt wurde.
		BooleanSupplier bs = () -> fzb.getBeckenlaenge() == 25;
		
		assertTrue(bs);
				
		//fail("Not yet implemented");
	}

}
