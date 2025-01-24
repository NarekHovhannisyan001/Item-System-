package strategies;

import models.Item;

import java.util.List;

// Strategy Interface for Upgrading
public interface UpgradeStrategy {
    boolean canUpgrade(Item item, List<Item> ingredients);

    Item upgrade(Item item, List<Item> ingredients);
}
