package com.demo.reactive.demo.adapter.repository.model;

import com.demo.reactive.demo.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class PersonEntity {
    @Id
    String id;
    String firstName;
    String lastName;
    String address;
    String celPhone;
    List<BookEntity> bookEntities;

    public static Person entityToDto(PersonEntity personEntity){
        Person product = Person.builder().build();
        BeanUtils.copyProperties(personEntity, product);
        return product;
    }

    public static PersonEntity dtoToEntity(Person person){
        PersonEntity personEntity = new PersonEntity();
        BeanUtils.copyProperties(person, personEntity);
        return personEntity;
    }
}
