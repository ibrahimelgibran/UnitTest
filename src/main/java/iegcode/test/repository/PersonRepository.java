package iegcode.test.repository;

import iegcode.test.data.Person;

public interface PersonRepository {

    Person selectById(String id);

    void insert(Person person);
}
