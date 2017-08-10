package hbi.core.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.exam.dto.OmOrderHeaders;
import hbi.core.exam.mapper.OmOrderHeadersMapper;
import hbi.core.exam.mapper.OmOrderLinesMapper;
import hbi.core.exam.service.IOmOrderHeadersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Bale on 2017/8/5.
 */
@Service
@Transactional
public class OmOrderHeadersServiceImpl extends BaseServiceImpl<OmOrderHeaders> implements IOmOrderHeadersService {

    @Resource
    private OmOrderHeadersMapper omOrderHeadersMapper;

    @Resource
    private OmOrderLinesMapper omOrderLinesMapper;

    /**
     *  自定义select 覆盖base中的select
     * @param request
     * @param dto 查询参数
     * @param pageNum   页数
     * @param pageSize  分页大小
     * @return
     */
    @Override
    public List<OmOrderHeaders> select(IRequest request, OmOrderHeaders dto, int pageNum, int pageSize){


        System.out.println("--------------------------------------omorderheaders service-------------------------------------");
        PageHelper.startPage(pageNum,pageSize);
        if ("所有状态".equals(dto.getOrderStatus())){
            dto.setOrderStatus(null);
        }

        List<OmOrderHeaders> list=omOrderHeadersMapper.select(dto);

        for (OmOrderHeaders header :list){
            Long orderSum=omOrderLinesMapper.selectOrderSumByHeaderId(header.getHeaderId());
            header.setOrderSum(orderSum==null?0L:orderSum); //如果该订单头下没有订单列,则显示0;
            System.out.println("------------------------------------------------"+header+"------------------------------------------------");
        }

        return  list;

    }

    @Override
    public boolean updateSubmit(IRequest request,OmOrderHeaders omOrderHeaders){

        int n= omOrderHeadersMapper.updateSubmit(omOrderHeaders);
        return n>0;
    }

    @Override
    public boolean updateByNumber(IRequest request,OmOrderHeaders omOrderHeaders){


        int n= omOrderHeadersMapper.updateByNumber(omOrderHeaders);

        return n>0;
    }

    @Override
    public boolean deleteAll(OmOrderHeaders omOrderHeaders){

        int n1=omOrderHeadersMapper.deleteByNumber(omOrderHeaders);

        int n2=omOrderLinesMapper.deleteByHeaderNumber(omOrderHeaders);

        return n1>0&&n2>=0;
    }
}
