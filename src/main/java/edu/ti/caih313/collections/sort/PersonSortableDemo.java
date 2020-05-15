package edu.ti.caih313.collections.sort;

import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.NameByLast;
import edu.ti.caih313.collections.dataobj.PersonSortable;
import edu.ti.caih313.collections.demo.PrintGeneric;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static edu.ti.caih313.collections.dataobj.Person.Gender.*;

public class PersonSortableDemo {
    public static void main(String... args) {
        PersonSortable personArray[] = {
                new PersonSortable(new Name("John", "Smith"), MALE, 34.0),
                new PersonSortable(new Name("Karl", "Ng"), MALE, 34.3),
                new PersonSortable(new Name("Jeff", "Smith"), MALE, 11.0),
                new PersonSortable(new Name("Tom", "Rich"), MALE, 11.0),
                new PersonSortable(new Name("Bob", "Smith"), MALE, 55.5),
                new PersonSortable(new Name("Jane", "Doe"), FEMALE, 34.0),
                new PersonSortable(new Name("Tony", "Stark"), MALE, 76.0),
                new PersonSortable(new Name("Bo", "Peep"), FEMALE, 34.0)
        };

        List<PersonSortable> personList = Arrays.asList(personArray);

        PrintGeneric<PersonSortable> personSortDemo = new PrintGeneric<>();
        personSortDemo.printCollection(personList);
        Collections.sort(personList);
        System.out.print("\n");
        System.out.println("Print sorted personList.");
        personSortDemo.printCollection(personList);
    }
}
