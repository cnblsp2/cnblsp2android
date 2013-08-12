package com.cnblsp2.studyt.aidlservice;

import com.cnblsp2.studyt.aidlservice.Person;

interface IPerson{
	Person getPerson(String name);
	List<Person> getPersonList();
}

