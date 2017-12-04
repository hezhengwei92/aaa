package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbDictionary;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wei on 2017/9/26.
 */
public interface TbDictionaryDao {
    @Select("select * from tbdictionary where keyMap=#{0} limit 1")
    TbDictionary query(String iccidSub);

}
