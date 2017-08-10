package hbi.core.exam.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.exam.dto.InvInventoryItems;

import java.util.List;

public interface InvInventoryItemsMapper extends Mapper<InvInventoryItems>{

    public List<InvInventoryItems> selectInventoryItems(InvInventoryItems invInventoryItems);

}