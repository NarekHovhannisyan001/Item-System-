package strategies;

import models.Item;
import models.Rarity;

import java.util.List;

public class GreatToRareUpgrade implements UpgradeStrategy {
    @Override
    public boolean canUpgrade(Item item, List<Item> ingredients) {
        return item.getRarity() == Rarity.GREAT && ingredients.size() >= 2;
    }

    @Override
    public Item upgrade(Item item, List<Item> ingredients) {
        item.setRarity(Rarity.RARE);
        return item;
    }
}
