package com.example.iasftest.controller;

import com.example.iasftest.service.MembersService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MembersController {

    @Autowired
    private MembersService membersService;




}
