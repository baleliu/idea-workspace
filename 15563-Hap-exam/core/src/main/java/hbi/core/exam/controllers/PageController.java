package hbi.core.exam.controllers;

import com.hand.hap.system.controllers.BaseController;
import hbi.core.exam.mapper.PageMapper;
import org.apache.http.protocol.ResponseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Bale on 2017/8/10.
 */

@Controller
@RequestMapping(value = "/page")
public class PageController extends BaseController{



    @Autowired
    PageMapper pageMapper;

    @RequestMapping(value = "/getrolecode")
    @ResponseBody
    public List<String> getRoleCode(HttpServletRequest request, Long userId){

        System.out.println("---------------------------------- userid"+userId);

        List<String> list  =pageMapper.getRoleCode(userId);


        System.out.println("------------------------------rolecode  "+list);

        return list;
    }
}
