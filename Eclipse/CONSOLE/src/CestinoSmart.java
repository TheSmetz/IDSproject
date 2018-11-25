

public class CestinoSmart {
	private boolean integrita = false; // false se il sistema è malfunzionante
	private boolean bocchetta = false;// false se la bocchetta è chiusa

	public CestinoSmart() {
	} // costruttore

	public boolean isBocchetta() {
		return bocchetta;
	}

	public void setBocchetta(boolean bocchetta) {
		this.bocchetta = bocchetta;
	}

	public boolean isIntegrita() {
		return integrita;
	}

	public void setIntegrita(boolean integrita) {
		this.integrita = integrita;
	}

	public void chiamaAssistenza() {
	}

	public void scansionaTessera() {
	}
}
