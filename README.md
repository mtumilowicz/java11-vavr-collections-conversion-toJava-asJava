# java11-vavr-collections-conversion-toJava-asJava
We show how to convert vavr collections to java collections.

_Reference_: https://static.javadoc.io/io.vavr/vavr/0.9.0/io/vavr/collection/List.html  
_Reference_: https://static.javadoc.io/io.vavr/vavr/0.9.0/io/vavr/Value.html

# preface
In vavr, we have two approaches to converting vavr collections
to java collections:
* `toJava*()`, where `*` could be: List, Array, Set...
* `asJava()`
    * List<T>	asJava()
    * List<T>	asJava(Consumer<? super List<T>> action)
    * List<T>	asJavaMutable()
    * List<T>	asJavaMutable(Consumer<? super List<T>> action)
    
# toJava*
* Object[] toJavaArray(), 
* T[] toJavaArray(Class<T> componentType), 
* <C extends Collection<T>> C toJavaCollection(Function<Integer,C> factory), 
* List<T> toJavaList(), 
* <LIST extends List<T>> LIST toJavaList(Function<Integer,LIST> factory), 
* Map<K,V> toJavaMap(Function<? super T,? extends Tuple2<? extends K,? extends V>> f), 
* <K,V,MAP extends Map<K,V>> MAP toJavaMap(Supplier<MAP> factory,
                                                   Function<? super T,? extends K> keyMapper,
                                                   Function<? super T,? extends V> valueMapper), 
* <K,V,MAP extends Map<K,V>> MAP toJavaMap(Supplier<MAP> factory,
                                                   Function<? super T,? extends Tuple2<? extends K,? extends V>> f), 
* Optional<T> toJavaOptional(), 
* Stream<T> toJavaStream()
* Stream<T> toJavaParallelStream(), 
* Set<T> toJavaSet(), 
* <SET extends Set<T>> SET toJavaSet(Function<Integer,SET> factory), 