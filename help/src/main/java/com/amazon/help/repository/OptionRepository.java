package com.amazon.help.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.help.model.Option;

public interface OptionRepository extends JpaRepository<Option, Integer>{

}
