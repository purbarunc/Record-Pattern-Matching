package org.purbarun.java21.sealed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoanServiceTest {
	private static LoanService loans;
	
	@BeforeAll
	static void setup() {
		loans=new LoanService();
	}

	@Test
	@DisplayName("For SecuredLoanImpl Object")
	void test() {
		Loan loan=new SecuredLoanImpl();
		assertEquals("Got a Loan !!", loans.displayMessageLatest(loan));
	}
	
	@Test
	@DisplayName("For UnsecuredLoanImpl Object")
	void test1() {
		Loan loan=new UnsecuredLoanImpl(5);
		assertEquals("Got a Loan !! with interst 5.0", loans.displayMessageLatest(loan));
	}

}
