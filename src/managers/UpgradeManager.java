package managers;
import models.Item;
import models.Rarity;
import strategies.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

// Upgrade Manager
public class UpgradeManager {
    private final Map<Rarity, UpgradeStrategy> upgradeStrategies;

    public UpgradeManager() {
        upgradeStrategies = new EnumMap<>(Rarity.class);
        upgradeStrategies.put(Rarity.COMMON, new CommonToGreatUpgrade());
        upgradeStrategies.put(Rarity.GREAT, new GreatToRareUpgrade());
        upgradeStrategies.put(Rarity.RARE, new RareToEpicUpgrade());
        upgradeStrategies.put(Rarity.EPIC, new EpicToLegendaryUpgrade());
    }

    public boolean upgradeItem(Item item, List<Item> ingredients, InventoryManager inventory) {
        UpgradeStrategy strategy = upgradeStrategies.get(item.getRarity());
        if (strategy != null && strategy.canUpgrade(item, ingredients)) {
            Item upgradedItem = strategy.upgrade(item, ingredients);
            inventory.removeItem(item);
            ingredients.forEach(inventory::removeItem);
            inventory.addItem(upgradedItem);
            return true;
        }
        return false;
    }
}
