package jos.learning.cloud.domain.user.dao;

import jos.learning.cloud.domain.user.dto.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jos on 2018/6/14.
 */
public interface UserDao extends CrudRepository<User,Long>{
}
