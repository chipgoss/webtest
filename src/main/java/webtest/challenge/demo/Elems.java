package webtest.challenge.demo;

//Project Web Elements
public enum Elems {
	TEXT_AREA("searchbox_input"),
	SEARCH_BTN("//*[@id=\"searchbox_homepage\"]/div/div[3]/button/span[2]");

	private final String elem;

	private Elems(String elemName){	
		elem = elemName;
	}

	public String getElem() {
		return elem;
	}
	
}