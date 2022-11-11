package com.wellsfargo.training.globalbankadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.training.globalbankadmin.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,String> {

	Login findByUsernameAndPassword(String username, String password);
}
