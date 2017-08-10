package hbi.core.exam.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Bale on 2017/8/10.
 */
public interface PageMapper {

    public List<String> getRoleCode(@Param("userId") Long userId);

}
