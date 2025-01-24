package strategies;

import models.Item;
import models.Rarity;

import java.util.List;

public class RareToEpicUpgrade implements UpgradeStrategy {
    @Override
    public boolean canUpgrade(Item item, List<Item> ingredients) {
        return item.getRarity() == Rarity.RARE && ingredients.size() >= 2;
    }

    @Override
    public Item upgrade(Item item, List<Item> ingredients) {
        item.setRarity(Rarity.EPIC);
        return item;
    }
}
