package strategies;

import models.EpicItem;
import models.Item;
import models.Rarity;

import java.util.List;

public class EpicToLegendaryUpgrade implements UpgradeStrategy {
    @Override
    public boolean canUpgrade(Item item, List<Item> ingredients) {
        if (!(item instanceof EpicItem)) return false;
        EpicItem epicItem = (EpicItem) item;
        return epicItem.getRarity() == Rarity.EPIC && epicItem.getUpgradeCount() == 2 && ingredients.size() >= 2;
    }

    @Override
    public Item upgrade(Item item, List<Item> ingredients) {
        item.setRarity(Rarity.LEGENDARY);
        return item;
    }
}
