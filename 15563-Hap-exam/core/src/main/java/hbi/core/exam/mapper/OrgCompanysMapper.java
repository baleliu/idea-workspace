package hbi.core.exam.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.exam.dto.OrgCompanys;

import java.util.List;

public interface OrgCompanysMapper extends Mapper<OrgCompanys>{

    List<OrgCompanys> selectCompanys(OrgCompanys orgCompanys);
}