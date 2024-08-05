package org.purbarun.java21.nonsealed;

public class LoanService {
	String displayMessageOld(Loan loan) {
		String message = "";
		if (loan instanceof SecuredLoanImpl) {
			message = "Got a Loan !!";
		}
		if (loan instanceof UnsecuredLoanImpl) {
			var usl = (UnsecuredLoanImpl) loan;
			message = "Got a Loan !! with interst" + usl.interest();
		}
		return message;
	}

	String displayMessagePatternMatching(Loan loan) {
		String message = "";
		if (loan instanceof SecuredLoanImpl) {
			message = "Got a Loan !!";
		}
		if (loan instanceof UnsecuredLoanImpl usl) {
			message = "Got a Loan !! with interst" + usl.interest();
		}
		return message;
	}

	String displayMessageRecordMatching(Loan loan) {
		String message = "";
		if (loan instanceof SecuredLoanImpl) {
			message = "Got a Loan !!";
		}
		if (loan instanceof UnsecuredLoanImpl(float interest)) {
			message = "Got a Loan !! with interst" + interest;
		}
		return message;
	}

	String displayMessageLatest(Loan loan) {
		return switch(loan) {
			case SecuredLoanImpl sl -> "Got a Loan !!";
			case UnsecuredLoanImpl(float interest) -> "Got a Loan !! with interst " + interest;
		default -> throw new IllegalArgumentException("Unexpected value: " + loan);
		};
	}
}
