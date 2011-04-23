package de.speutel.oyster.o3;

import javax.inject.Named;

@Named
public class O3Info {

	public final static String VERSION = "0.1";

	public String getVersion() {
		return VERSION;
	}

}
