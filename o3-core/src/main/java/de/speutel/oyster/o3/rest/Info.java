package de.speutel.oyster.o3.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.sitebricks.At;
import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.Get;

import de.speutel.oyster.o3.O3Info;

@At("/info")
@Service
@Named
public class Info {

	private O3Info o3Info;

	@Inject
	public Info(O3Info o3Info) {
		this.o3Info = o3Info;
	}

	@Get
	public Reply<O3Info> version() {
		return Reply.with(o3Info).as(Json.class);
	}

}
