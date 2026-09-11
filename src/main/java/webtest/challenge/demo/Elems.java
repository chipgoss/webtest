package webtest.challenge.demo;

//Project Web Elements
public enum Elems {
	TEXT_AREA("q"),
	SEARCH_BTN("//button[@type='submit']");


	private final String elem;

	private Elems(String elemName){	
		elem = elemName;
	}

	public String getElem() {
		return elem;
	}
	
}