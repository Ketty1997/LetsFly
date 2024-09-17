package com.letsfly.ctr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PageCtr {

  @GetMapping(path = { "/", "/home" })
  public String goHome(Model model) {
    return "homeUtente";

  }

}
