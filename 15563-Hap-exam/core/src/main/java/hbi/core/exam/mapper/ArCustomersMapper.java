package hbi.core.exam.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.exam.dto.ArCustomers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArCustomersMapper extends Mapper<ArCustomers>{

    List<ArCustomers> selectCustomers(ArCustomers arCustomers);
}