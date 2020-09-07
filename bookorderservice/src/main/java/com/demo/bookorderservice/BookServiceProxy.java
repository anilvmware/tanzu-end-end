package com.demo.bookorderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="bookservice" , url="http://bookservice.appdev.svc.cluster.local:8020")
public interface BookServiceProxy {
  @GetMapping("/getBook/{id}")
  public BookBean getBook
    ( @PathVariable("id") Long id );
}
