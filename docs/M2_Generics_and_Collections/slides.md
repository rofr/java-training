---
# Configurations
progress: true
controls: true
slideNumber: true
hideAddressBar: true
transition: 'slide' 
backgroundTransition: 'zoom'
---

# M2
## Generics and Collections

Notes:
[Open in browser](https://mark.show/?source=https://github.com/rofr/java-training/raw/master/docs/M2_Generics_and_Collections/slides.md)

---

# Contents
- Lists
- Sets
- Maps
- Iterating and for each loops
- LAB: Geometry

Notes: Data structures and algorithms.
---

# Collections in general
- no fixed size, grow as needed
- size() tells how many items

---

# Lists
- List<E>
- Operations: add(), remove(), get(i), etc
- ArrayList<E>
- LinkedList<E>
Notes: A list is an ordered sequence of items. Odered does not mean in any specific order. Choosing an implementation

---

# Sets
- Set<E>
- An element is either a member or not a member
- No duplicates possible
- HashSet<E>
- SortedSet<E>

---

# Using a HashSet
```java
  HashSet<String> words = new HashSet<String>();
  words.add("cat");
  words.add("dog");
  if (words.contains("horse")) say("impossible");
```

---
# Maps
- A map is a key/value store
- Map<K,V>
- HashMap<K,V>
- TreeMap<K,V>
---

# Using a HashMap
```java
  HashMap<String, Integer> wordCounts
    = new HashMap<String,Integer>();
  wordCounts.put("cat", 1);
  wordConts.put("dog", 4);
  if (wordCounts.containsKey("dog")) {
      int number = wordCounts.get("dog");
  }
```

---

# Iteration old style
```java
   Iterator<String> iterator
     = wordCounts.keySet().iterator();
   while(iterator.hasNext()) {
       String word = iterator.next();
       System.out.println(word);
   }
``` 

---

# Iteration syntactic sugar

```java
   for(String word: wordCounts.keySet())
       System.out.println(word);
   }
```

---
# Comparable and Comparator
- `Comparable<T>` int compareTo(T other)
- `Comparator<T>`- int compare(T a, t b)
- `Collections.sort(numbers)`
- `Collections.sort(cars)`
Notes: In order to sort and search items need to be compared. Integers are Comparable but what about cars?
---

# Comparison and sorting
- Integer implements Comparable
```java
List<Integer> numbers = Arrays.of(4,5,7,3,2);
Collections.sort(numbers);
```
Notes:  
---
# Comparator

```java
public class DescendingByArea implements Comparator<Shape> {
	
	@Override
	public int compare(Shape a, Shape b) {
		return (int) Math.signum(b.area() - a.area());
	}
}
```
---
# Using comparator
```java
Collections.sort(shapes, new DescendingByArea());
```
---
# LAB!
Time: 1 hour
