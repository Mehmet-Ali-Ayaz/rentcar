package com.javaegitimleri.rentcar.web;

import com.javaegitimleri.rentcar.service.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentCarController {

    @Autowired
    private RentCarService rentCarService;

         @RequestMapping("/renters")
    public ModelAndView getRenters(){
        ModelAndView mav= new ModelAndView();
        mav.addObject("renters", rentCarService.findRenters());
        mav.setViewName("renters");
        return mav;
    }

    @RequestMapping("/pcs")
    @ResponseBody
  public String welcome()  {
      return "Welcome to RentCar World!";
  }
}
