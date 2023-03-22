```text
public class ArrayList<E>
  extends
    AbstractList<E>
  implements
    List<E>,
    RandomAccess,
    Cloneable,
    java.io.Serializable { ... }
```

---

## [Methods](./ArrListEx2Methods.java)

```java
list1.add("Four");    // ********** add(value)
list1.add(0, "Four"); // ********** add(index, value)
list1.get(1);         // ********** get(index)
list1.set(1, "New");  // ********** set(index, value)
list1.remove(0);      // ********** remove(index)
list1.remove("item"); // ********** remove(by_value!) it is possible if method equals was overridden
list2.size()          // ********** size()

list2.addAll(list1);    // ********** addAll(any_list)
list2.addAll(1, list1); // ********** addAll(index, any_list)

list2.removeAll(list1); // remove all list1 elements from list2
list2.retainAll(list1); // retain only list1 elements in list2
list2.clear();          // ********** clear() empty list []

list2.subList(1, 4);        // Returns a view!!! of the portion of this list. Be careful with concurrent modification

list2.indexOf("item"));     // ********** indexOf(value) equals!
list2.lastIndexOf("item")); // ********** lastIndexOf(value) equals!

list2.isEmpty()           // ********** isEmpty() true/false
list2.contains("John");   // ********** contains(value) true/false equals!
list2.containsAll(list1); // ********** containsAll(list1) true/false equals!

Object[] objectsArr = list2.toArray();
String[] stringsArr = list2.toArray(new String[0]); // [0] and java will create correct size by itself
List.of(1, 2, 3, 4, 5); // immutable list!
List.copyOf(list); // immutable list!
```

---

## [Iterator](./IteratorExample.java)

---
