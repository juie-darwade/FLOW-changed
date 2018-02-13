package com.abhinendra.repositories;

import com.abhinendra.domain.Person;
import com.abhinendra.domain.QPerson;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>, QueryDslPredicateExecutor<Person>, QuerydslBinderCustomizer<QPerson> {
  
	@Override
    default public void customize(QuerydslBindings bindings, QPerson qPerson) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
	public Iterable<Person> findAll();
    public Person save(Person person);
    public Person findOne(String account);   
    public Person findByname(String Name);
    
    
    
}