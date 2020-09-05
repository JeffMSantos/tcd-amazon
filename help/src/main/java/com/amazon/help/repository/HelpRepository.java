package com.amazon.help.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.help.model.Help;

public interface HelpRepository extends JpaRepository<Help, Integer> {

}
