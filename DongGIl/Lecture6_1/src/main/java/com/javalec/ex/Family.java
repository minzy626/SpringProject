package com.javalec.ex;

public class Family {
	
	String paName;
	String maName;
	String sisName;
	String BroName;
	
	public Family(String paName, String maName) {
		this.paName = paName;
		this.maName = maName;
	}

	public String getPaName() {
		return paName;
	}

	public void setPaName(String paName) {
		this.paName = paName;
	}

	public String getMaName() {
		return maName;
	}

	public void setMaName(String maName) {
		this.maName = maName;
	}

	public String getSisName() {
		return sisName;
	}

	public void setSisName(String sisrName) {
		this.sisName = sisrName;
	}

	public String getBroName() {
		return BroName;
	}

	public void setBroName(String broName) {
		BroName = broName;
	}
}

