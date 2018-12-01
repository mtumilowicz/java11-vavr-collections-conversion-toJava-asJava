import io.vavr.collection.List;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mtumilowicz on 2018-12-01.
 */
public class CollectionsConversionTest {
    
    @Test
    public void vavrList_toJavaList() {
        java.util.List<Integer> integers = List.of(1).toJavaList();
        
        integers.add(2);
        
        assertThat(integers, hasSize(2));
        assertThat(integers.get(0), is(1));
        assertThat(integers.get(1), is(2));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void vavrList_asJava_immutable() {
        java.util.List<Integer> integers = List.of(1).asJava();

        integers.add(2);
    }

    @Test
    public void vavrList_asJava() {
        java.util.List<Integer> integers = List.of(1).asJava();

        assertThat(integers, hasSize(1));
        assertThat(integers.get(0), is(1));
    }
}
