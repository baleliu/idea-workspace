package hbi.core.exam.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.exam.dto.OmOrderHeaders;

import java.util.List;

/**
 * Created by Bale on 2017/8/5.
 */
public interface OmOrderHeadersMapper extends Mapper<OmOrderHeaders> {
        List<OmOrderHeaders> select(OmOrderHeaders omOrderHeaders);

        int updateByNumber (OmOrderHeaders omOrderHeaders);

        int updateSubmit(OmOrderHeaders omOrderHeaders);

        int deleteByNumber(OmOrderHeaders omOrderHeaders);
}
