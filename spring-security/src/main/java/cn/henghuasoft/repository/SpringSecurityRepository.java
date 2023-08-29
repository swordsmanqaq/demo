package cn.henghuasoft.repository;

import cn.henghuasoft.entity.SpringSecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shkstart
 * @create 2023-08-29 21:16
 */
@Repository
public interface SpringSecurityRepository extends JpaRepository<SpringSecurityUser, Long> {

}
