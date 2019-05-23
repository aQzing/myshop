package cn.itqzing.myshop.service.user.consumer.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.itqzing.myshop.commons.domain.TbUser;
import cn.itqzing.shop.service.user.api.TbUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class TbUserController {

    @Reference(version = "${services.versions.user.v1}")
    private TbUserService tbUserService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        System.out.println(tbUsers+"来了老弟!！");
        return "user/list";
    }
}