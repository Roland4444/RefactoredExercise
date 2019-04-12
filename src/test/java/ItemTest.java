import Abstractions.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testtoString() {
        Item item = new Item("test", 22, 22);
        item.sellIn--;
        item.quality++;
        assertEquals(21, item.sellIn);
        assertEquals(23, item.quality);

    }
}