# java11-vavr-collections-conversion-toJava-asJava
We show how to convert vavr collections to java collections.

_Reference_: https://static.javadoc.io/io.vavr/vavr/0.9.0/io/vavr/collection/List.html  
# preface
In vavr, we have two approaches to converting vavr collections
to java collections:
* `toJava*()`, where `*` could be: `List`, `Array`, `Set`...
* `asJava()`

The main difference between `asJava()` and `toJava*()` is that
a view from `asJava()` is created in `O(1)` (constant time) 
whereas conversion (`toJava*()`) takes `O(n)` (linear time), 
with n = collection size.

The operations on a view have the same performance 
characteristics than the underlying persistent Vavr 
collection whereas the performance characteristics of a 
converted collection are those of the Java standard collections.

**Motivation: we often have to use java collections (in 
frameworks...).**
# toJava*
_Reference_: https://static.javadoc.io/io.vavr/vavr/0.9.0/io/vavr/Value.html

Converts vavr collections to java collections by coping
content, for example:
```
java.util.List<T> toJavaList() {
        return ValueModule.toJavaCollection(this, ArrayList::new, 10);
    }
```
where:
```
static <T, R extends java.util.Collection<T>> R toJavaCollection(
        Value<T> value, Function<Integer, R> containerSupplier, int defaultInitialCapacity) {
    final int size;
    if (value instanceof Traversable && ((Traversable) value).isTraversableAgain() && !value.isLazy()) {
        size = ((Traversable) value).size();
    } else {
        size = defaultInitialCapacity;
    }
    final R container = containerSupplier.apply(size);
    value.forEach(container::add);
    return container;
}
```

* `Object[] toJavaArray()`,
* `T[] toJavaArray(Class<T> componentType)`,
* `<C extends Collection<T>> C toJavaCollection(Function<Integer,C> factory)`,
* `List<T> toJavaList()`,
* `<LIST extends List<T>> LIST toJavaList(Function<Integer,LIST> factory)`,
* `Map<K,V> toJavaMap(Function<? super T,? extends Tuple2<? extends K,? extends V>> f)`,
* `<K,V,MAP extends Map<K,V>> MAP toJavaMap(Supplier<MAP> factory,
                                                   Function<? super T,? extends K> keyMapper,
                                                   Function<? super T,? extends V> valueMapper)`,
* `<K,V,MAP extends Map<K,V>> MAP toJavaMap(Supplier<MAP> factory,
                                                   Function<? super T,? extends Tuple2<? extends K,? extends V>> f)`,
* `Optional<T> toJavaOptional()`,
* `Stream<T> toJavaStream()`,
* `Stream<T> toJavaParallelStream()`,
* `Set<T> toJavaSet()`,
* `<SET extends Set<T>> SET toJavaSet(Function<Integer,SET> factory)`

# asJava()
_Reference_: https://static.javadoc.io/io.vavr/vavr/0.9.2/io/vavr/collection/Seq.html

Creates an **immutable `List`** view on top of this `Seq`, 
i.e. calling mutators will result in 
`UnsupportedOperationException` at runtime.

Please note that our immutable `java.util.List` view 
throws `UnsupportedOperationException` before checking 
method arguments. Java does handle this case inconsistently.

* `List<T>	asJava()`
* `List<T>	asJava(Consumer<? super List<T>> action)`
* `List<T>	asJavaMutable()`
* `List<T>	asJavaMutable(Consumer<? super List<T>> action)`