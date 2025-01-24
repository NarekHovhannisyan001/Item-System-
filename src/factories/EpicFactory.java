package factories;

import models.EpicItem;
import models.Item;

// Factory for Epic items
public class EpicFactory implements BaseFactory {
    @Override
    public Item createItem(String name) {
        return new EpicItem(name);
    }
}
