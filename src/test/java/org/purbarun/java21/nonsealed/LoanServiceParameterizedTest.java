package org.purbarun.java21.nonsealed;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


@DisplayName("LoanService Parameterized Test for Sealed Loan Interface")
class LoanServiceParameterizedTest {

	@ParameterizedTest
	@MethodSource("getLoans")
	@DisplayName("MyLoan runs fine on all Loan implementations")
	void test(Loan loan) {
		LoanService myLoans = new LoanService();
		switch (loan) {
		case SecuredLoanImpl sl -> assertEquals("Got a Loan !!", myLoans.displayMessageLatest(loan));
		case UnsecuredLoanImpl usl ->
			assertEquals("Got a Loan !! with interst 5.0", myLoans.displayMessageLatest(loan));
		default -> assertThrows(IllegalArgumentException.class, () -> myLoans.displayMessageLatest(loan));
		}
	}

	static Stream<Arguments> getLoans() {
		Loan secLoan = new SecuredLoanImpl();
		Loan unSecLoan = new UnsecuredLoanImpl(5);
		Loan fastLoan = new FastLoan();

		return Stream.of(Arguments.of(Named.of("For SecuredLoanImpl Object", secLoan)),
				Arguments.of(Named.of("For UnsecuredLoanImpl Object", unSecLoan)),
				Arguments.of(Named.of("For any other Loan Object", fastLoan)));
	}

	static class FastLoan implements Loan {
	}

}
