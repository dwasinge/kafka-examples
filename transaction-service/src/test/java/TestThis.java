import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class TestThis {

	private Random random = new Random();

	@Test
	public void testThis() {

		for (int i = 0; i < 10000; i++) {
			int num = 1 + random.nextInt(144);

			if (num == 1 || num == 144 || num == 0 || num > 144)
				System.out.println("next: " + num);
		}

	}

	@Test
	public void ThisThisToo() {

		

		BigDecimal dollars = new BigDecimal(
				random.nextInt(15)
				);
		BigDecimal cents = new BigDecimal(
                random.nextGaussian() 
            )
            .setScale(2, RoundingMode.HALF_UP);


		System.out.println("price: " + dollars.add(cents));

	}

}
