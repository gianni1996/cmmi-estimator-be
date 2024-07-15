package com.nttdata.cmmiestimator.application.config;

/**
 * 
 * @author BuonocoreGi
 *
 */

public class BusinesLogicResponse {

	private String esito;
	private String desc;

	public BusinesLogicResponse() {
	}

	public BusinesLogicResponse(String esito, String desc) {

		this.esito = esito;
		this.desc = desc;

	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "BusinesLogicResponse [esito=" + esito + ", desc=" + desc + "]";
	}

}
