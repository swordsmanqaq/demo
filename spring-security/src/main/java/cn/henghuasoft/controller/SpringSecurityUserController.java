package cn.henghuasoft.controller;


import cn.henghuasoft.service.ISpringSecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/springSecurityUser")
public class SpringSecurityUserController {

    @Autowired
    public ISpringSecurityUserService springSecurityUserService;


}
