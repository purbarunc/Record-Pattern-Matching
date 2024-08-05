package org.purbarun.java21.sealed;

public sealed interface Loan permits SecuredLoanImpl,UnsecuredLoanImpl{

}
