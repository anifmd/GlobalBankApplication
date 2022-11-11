package com.wellsfargo.training.globalbankadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.training.globalbankadmin.model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer>{

}
