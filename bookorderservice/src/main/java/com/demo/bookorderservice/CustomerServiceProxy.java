package com.demo.bookorderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customerservice" , url="http://customerservice.appdev.svc.cluster.local:8030")
public interface CustomerServiceProxy {
  @GetMapping("/getCustomer/{id}")
  public CustomerBean getCustomer
    ( @PathVariable("id") Long id );
}
