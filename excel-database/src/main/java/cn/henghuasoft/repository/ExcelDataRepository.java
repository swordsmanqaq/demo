package cn.henghuasoft.repository;

import cn.henghuasoft.entity.ExcelData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shkstart
 * @create 2023-08-01 17:05
 */
@Repository
public interface ExcelDataRepository extends JpaRepository<ExcelData,Long> {

}
