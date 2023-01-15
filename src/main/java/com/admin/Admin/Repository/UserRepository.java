package com.admin.Admin.Repository;

import com.admin.Admin.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByName(String name);
}
