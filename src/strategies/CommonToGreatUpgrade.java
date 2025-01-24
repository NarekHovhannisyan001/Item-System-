package strategies;

import models.Item;
import models.Rarity;

import java.util.List;

// Concrete Strategies for Different Rarities
public class CommonToGreatUpgrade implements UpgradeStrategy {
    @Override
    public boolean canUpgrade(Item item, List<Item> ingredients) {
        return item.getRarity() == Rarity.COMMON && ingredients.size() >= 2;
    }

    @Override
    public Item upgrade(Item item, List<Item> ingredients) {
        item.setRarity(Rarity.GREAT);
        return item;
    }
}
