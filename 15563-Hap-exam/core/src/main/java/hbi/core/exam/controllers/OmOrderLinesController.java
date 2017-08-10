package hbi.core.exam.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.mybatis.util.StringUtil;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.exam.dto.OmOrderLines;
import hbi.core.exam.service.IOmOrderLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class OmOrderLinesController extends BaseController {

    @Autowired
    private IOmOrderLinesService service;


    @RequestMapping(value = "/om/order/lines/query")
    @ResponseBody
    public ResponseData query(OmOrderLines dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        System.out.println("------------------------line query param :" + dto);
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/om/order/lines/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<OmOrderLines> list, BindingResult result, HttpServletRequest request) {
        Long headerId=null;
        System.out.println("-----------------submit-----------------------------------------------------------");
        if (!StringUtil.isEmpty(request.getParameter("headerId"))){
            headerId = Long.parseLong(request.getParameter("headerId"));
        }
        Long companyId=null;
        if (!StringUtil.isEmpty(request.getParameter("companyId"))){
            companyId = Long.parseLong(request.getParameter("companyId"));
        }
        for (OmOrderLines line : list) {

            //获取页面headerId参数
            line.setHeaderId(headerId);
            line.setCompanyId(companyId);
            //时间戳作为linenumber
            line.setLineNumber(new Date().getTime());
        }

        System.out.println(list);
        /*getValidator().validate(dto, result);
        if (result.hasErrors()) {
            ResponseData responseData = new ResponseData(false);
            responseData.setMessage(getErrorMessage(result, request));
            return responseData;
        }*/
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, list));
    }

    @RequestMapping(value = "/om/order/lines/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<OmOrderLines> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}