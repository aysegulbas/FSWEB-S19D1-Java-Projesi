package com.workintech.manytomany.dao;

import com.workintech.manytomany.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
