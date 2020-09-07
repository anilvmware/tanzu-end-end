package com.demo.bookorderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
 

@FeignClient(name="eventservice" , url="http://eventservice.appdev.svc.cluster.local:8065")
public interface EventProxy {
	@GetMapping("/getEvents")
	public void getEvents();
}

