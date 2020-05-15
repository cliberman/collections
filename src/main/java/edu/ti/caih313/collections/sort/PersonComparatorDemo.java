package edu.ti.caih313.collections.sort;

import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.Person;
import edu.ti.caih313.collections.dataobj.PersonSortable;
import edu.ti.caih313.collections.demo.PrintGeneric;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static edu.ti.caih313.collections.dataobj.Person.Gender.FEMALE;
import static edu.ti.caih313.collections.dataobj.Person.Gender.MALE;

public class PersonComparatorDemo {
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
        PrintGeneric<PersonSortable> personSortableDemo = new PrintGeneric<>();
        personSortableDemo.printCollection(personList);

//        Comparator<PersonSortable> ageComparator = new Comparator<PersonSortable>() {
//            @Override
//            public int compare(PersonSortable n1, PersonSortable n2) {
//                int ageOrder;
//                if (n1.getAge() == n2.getAge()) {
//                    ageOrder = 0;
//                } else if (n1.getAge() > n2.getAge()) {
//                    ageOrder = -1;
//                } else {
//                    ageOrder = 1;
//                }
//                return ageOrder;
//            }
//            };
//
//            Comparator<PersonSortable> genderComparator = new Comparator<PersonSortable>() {
//                @Override
//                public int compare(PersonSortable n1, PersonSortable n2) {
//                    int genderOrder;
//                    if (n1.getGender() == n2.getGender()) {
//                        genderOrder = 0;
//                    } else if (n1.getGender().toString().equalsIgnoreCase("male")) {
//                        genderOrder = 1;
//                    } else {
//                        genderOrder = -1;
//                    }
//                    return genderOrder;
//                }
//                };
//
//
//            Comparator<PersonSortable> nameByLastListComparator = new Comparator<PersonSortable>() {
//            @Override
//            public int compare(PersonSortable n1, PersonSortable n2) {
//                int nameOrder = n1.getName().getLastName().compareTo(n2.getName().getLastName());
//                if (nameOrder == 0) {
//                    nameOrder = n1.getName().getFirstName().compareTo(n2.getName().getFirstName());
//                }
//                return nameOrder;
//            }
//        };
//
//        Collections.sort(personList, nameByLastListComparator);
//        System.out.print("\n");
//        System.out.println("Print sorted by last name nameList.");
//        personSortableDemo.printCollection(personList);
//
//        Comparator<PersonSortable> nameByFirstListComparator = new Comparator<PersonSortable>() {
//            @Override
//            public int compare(PersonSortable n1, PersonSortable n2) {
//                int nameOrder = n1.getName().getFirstName().compareTo(n2.getName().getFirstName());
//                if (nameOrder == 0) {
//                    nameOrder = n1.getName().getLastName().compareTo(n2.getName().getLastName());
//                }
//                return nameOrder;
//            }
//        };

        Comparator<PersonSortable> compareAgeGenderName = new Comparator<PersonSortable>() {
            @Override
            public int compare(PersonSortable n1, PersonSortable n2) {
                int compare;
                if (n1.getAge() == n2.getAge()) {
                    compare = 0;
                } else if (n1.getAge() > n2.getAge()) {
                    compare = -1;
                } else {
                    compare = 1;
                }
                if (compare == 0) {
                    if (n1.getGender() == n2.getGender()) {
                        compare = 0;
                    } else if (n1.getGender().toString().equalsIgnoreCase("male")) {
                        compare = 1;
                    } else {
                        compare = -1;
                    }
                    return compare;
                }
                if (compare == 0) {
                    compare = n1.getName().toString().compareTo(n2.getName().toString());
                }
                return compare;
            }
        };


//        Collections.sort(personList, nameByFirstListComparator);
//        System.out.print("\n");
//        System.out.println("Print sorted by first name personList.");
//        personSortableDemo.printCollection(personList);
//        Collections.sort(personList, ageComparator);
//        System.out.print("\n");
//        System.out.println("Print sorted by age personList.");
//        personSortableDemo.printCollection(personList);
//        Collections.sort(personList, genderComparator);
//        System.out.print("\n");
//        System.out.println("Print sorted by gender personList.");
//        personSortableDemo.printCollection(personList);

        Collections.sort(personList,compareAgeGenderName);
        System.out.print("\n");
        System.out.println("Print sorted by age, gender, and name personList.");
        personSortableDemo.printCollection(personList);
    }
}