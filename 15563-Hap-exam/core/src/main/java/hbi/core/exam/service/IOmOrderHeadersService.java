package hbi.core.exam.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.exam.dto.OmOrderHeaders;

import java.util.List;

/**
 * Created by Bale on 2017/8/5.
 */
public interface IOmOrderHeadersService extends IBaseService<OmOrderHeaders>, ProxySelf<IOmOrderHeadersService>{

    List<OmOrderHeaders> select(IRequest request, OmOrderHeaders dto, int pageNum, int pageSize);

    public boolean updateByNumber(IRequest request,OmOrderHeaders omOrderHeaders);

    public boolean updateSubmit(IRequest request,OmOrderHeaders omOrderHeaders);

    public boolean deleteAll(OmOrderHeaders omOrderHeaders);
}
