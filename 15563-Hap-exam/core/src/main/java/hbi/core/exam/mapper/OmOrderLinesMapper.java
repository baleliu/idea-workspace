package hbi.core.exam.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.exam.dto.OmOrderHeaders;
import hbi.core.exam.dto.OmOrderLines;

import java.util.List;

/**
 * Created by Bale on 2017/8/5.
 */
public interface OmOrderLinesMapper extends Mapper<OmOrderLines>{

    /**
     * 通过headerId 查询订单总金额
     * @param headerid
     * @return
     */
    Long selectOrderSumByHeaderId(Long headerid);

    List<OmOrderLines> select(OmOrderLines omOrderLines);

    int deleteByHeaderNumber(OmOrderHeaders omOrderHeaders);
}
