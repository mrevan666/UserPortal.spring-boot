package com.admin.Admin.Repository;

import com.admin.Admin.Entity.Occupation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRepository extends CrudRepository<Occupation,Integer> {
}
