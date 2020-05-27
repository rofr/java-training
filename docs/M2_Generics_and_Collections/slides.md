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

# Using a HashMap
```java
  HashMap<String, Integer> wordCounts
    = new HashMap<String,Integer>();
  words.put("cat", 1);
  words.put("dog", 4);
  if (words.containsKey("dog")) {
      int number = words.get("dog");
  }
```

---

# Iteration old style
```java
   Iterator<String> iterator
     = wordCounts.keySet().iterator();
   while(e.hasNext()) {
       String word = e.next();
       System.out.println(word);
   }
``` 

---

# Iteration syntactic suger

```java
   for(String word: wordCounts.keySet())
       System.out.println(word);
   }
``` 

---
# LAB!
Time: 1 hour
