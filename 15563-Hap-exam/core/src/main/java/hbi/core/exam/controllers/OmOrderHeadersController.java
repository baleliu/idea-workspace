package hbi.core.exam.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.exam.dto.OmOrderHeaders;
import hbi.core.exam.dto.OmOrderLines;
import hbi.core.exam.service.IOmOrderHeadersService;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Bale on 2017/8/5.
 */
@Controller
public class OmOrderHeadersController extends BaseController {


    @Autowired
    private IOmOrderHeadersService omOrderHeadersService;

    @RequestMapping(value = "/om/order/header/query")
    @ResponseBody
    public ResponseData query(OmOrderHeaders dto, @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int pageSize, HttpServletRequest request) {
        System.out.println("--------------------------------------omorderheader controller------------------------------------");
        System.out.println("------------------------------------param dto " + dto + "---------------------------------------");
        List<OmOrderHeaders> list = omOrderHeadersService.select(createRequestContext(request), dto, page, pageSize);
        return new ResponseData(list);

    }


    @RequestMapping(value = "/om/order/header/save")
    @ResponseBody
    public ResponseData update(@RequestBody OmOrderHeaders dto, BindingResult result, HttpServletRequest request) {


        System.out.println("___________________________________________" + dto);
        /*getValidator().validate(dto, result);
        if (result.hasErrors()) {
            ResponseData responseData = new ResponseData(false);
            responseData.setMessage(getErrorMessage(result, request));
            return responseData;
        }*/
        IRequest requestCtx = createRequestContext(request);
        //创建订单头
        if (StringUtil.isEmpty(dto.getOrderNumber())) {

            //时间戳 作为ordernumber
            dto.setOrderNumber("h" + new Date().getTime());
            OmOrderHeaders header = omOrderHeadersService.insert(requestCtx, dto);
            List<OmOrderHeaders> list = new ArrayList<OmOrderHeaders>();
            list.add(header);
            return new ResponseData(list);
        } else {
            //修改订单头信息
            return new ResponseData(omOrderHeadersService.updateByNumber(requestCtx, dto));
        }
    }
    @RequestMapping(value = "/om/order/header/submit")
    @ResponseBody
    public ResponseData submit(@RequestBody OmOrderHeaders dto, BindingResult result, HttpServletRequest request){

        if (StringUtil.isEmpty(dto.getOrderNumber())){
            return new ResponseData(false);
        }
        IRequest requestCtx = createRequestContext(request);
        boolean falg=omOrderHeadersService.updateSubmit(requestCtx,dto);
        return new ResponseData(falg);
    }


    @RequestMapping(value = "/om/order/header/removeall")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody OmOrderHeaders dto) {
        boolean flag=omOrderHeadersService.deleteAll(dto);
        return new ResponseData(flag);
    }

}
