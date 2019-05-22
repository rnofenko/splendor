package rn.splendor;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
public class ApplicationTests {

	@Test
	@Ignore
	public void contextLoads() {
		Long l1 = 1L;
		Long l2 = 2L;

		assertEquals(-1,Long.compare(l1, l2));

		l1 = 1L;
		l2 = null;

		assertEquals(-1,Long.compare(l1, l2));
	}

}