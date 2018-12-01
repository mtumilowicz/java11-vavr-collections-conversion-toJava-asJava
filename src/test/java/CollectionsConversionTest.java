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
        java.util.List<Integer> integers = List.of(1).asJava();
        
        integers.add(1);
        
        assertThat(integers, hasSize(1));
        assertThat(integers.get(0), is(1));
    }
}
