package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ResumeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * InnoDB free: 9216 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@Mapper
public interface ResumeDao extends BaseMapper<ResumeEntity> {
	void insertResume(ResumeEntity resumeEntity);
	List<ResumeEntity> getByresHrId(@Param("id") long id);
}
