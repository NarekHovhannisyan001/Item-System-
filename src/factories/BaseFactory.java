package factories;

import models.Item;

// Base Factory interface
public interface BaseFactory {
    Item createItem(String name);
}
