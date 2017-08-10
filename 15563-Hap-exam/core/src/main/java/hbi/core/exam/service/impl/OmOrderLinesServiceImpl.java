package hbi.core.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.exam.mapper.OmOrderLinesMapper;
import org.springframework.stereotype.Service;
import hbi.core.exam.dto.OmOrderLines;
import hbi.core.exam.service.IOmOrderLinesService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderLinesServiceImpl extends BaseServiceImpl<OmOrderLines> implements IOmOrderLinesService{

    @Resource
    private OmOrderLinesMapper omOrderLinesMapper;

    @Override
    public List<OmOrderLines> select(IRequest request, OmOrderLines dto, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<OmOrderLines> list= omOrderLinesMapper.select(dto);

        for (OmOrderLines lines:list){
            System.out.println(lines);
        }

        return list;
    }

    public boolean batchCreate(List<OmOrderLines> list){

        for (OmOrderLines line:list){

            int n=omOrderLinesMapper.insert(line);

            if (n<0){
                return false;
            }
        }
        return  true;
    }
}