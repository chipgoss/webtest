package webtest.challenge.demo;

//Project Web Elements
public enum Elems {
	LOGIN_USERNAME("form-username"),
	LOGIN_PASSWORD("form-password"),
	LOGIN_BUTTON("btnLogin"),
	ADD_EMPLOYEE_BTN("btnAddEmployee"),
	ADD_EMPLOYEE_FIRST("//*[@id=\"employees-form\"]/div[1]/div/input"),
	ADD_EMPLOYEE_LAST("//*[@id=\"employees-form\"]/div[2]/div/input"),
	ADD_EMPLOYEE_DEPENDENTS("//*[@id=\"employees-form\"]/div[3]/div/input"),
	SUBMIT_BTN("//*[@id=\"employees-form\"]/div[4]/div/button[1]"),
	FIRST_NAME("//*[@id=\"demo-table\"]/tbody/tr[2]/td[2]"),
	LAST_NAME("//*[@id=\"demo-table\"]/tbody/tr[2]/td[3]"),
	BENEFIT_COST("//*[@id=\"demo-table\"]/tbody/tr[2]/td[7]"),
	NET_PAY("//*[@id=\"demo-table\"]/tbody/tr[2]/td[8]");

	private final String elem;

	private Elems(String elemName){	
		elem = elemName;
	}

	public String getElem() {
		return elem;
	}
	
}