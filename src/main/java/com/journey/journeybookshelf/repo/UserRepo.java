package com.journey.journeybookshelf.repo;

import com.journey.journeybookshelf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

//repositories are an abstraction of interacting with a database.
// Just by defining an interface that extends JpaRepository,
// we can start using it in our other classes.
public interface UserRepo extends JpaRepository<User, Long> {
}
