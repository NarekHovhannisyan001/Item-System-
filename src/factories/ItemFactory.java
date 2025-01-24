package factories;

import models.Item;
import models.Rarity;

// Factory for general items
public class ItemFactory implements BaseFactory {
    private final Rarity rarity;

    public ItemFactory(Rarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public Item createItem(String name) {
        return new Item(name, rarity);
    }
}
