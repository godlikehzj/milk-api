package com.godlikehzj.milk.controller;

import com.godlikehzj.milk.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by godlikehzj on 15/9/9.
 */
@Controller
@RequestMapping(value = "/milkapi/product")
public class ProductController extends BaseController{
    @RequestMapping(value = "/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
        System.out.println("get list");
    }
}
