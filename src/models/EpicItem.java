package models;

// Specialized EpicItem class
public class EpicItem extends Item {
    private int upgradeCount;

    public EpicItem(String name) {
        super(name, Rarity.EPIC);
        this.upgradeCount = 0;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void incrementUpgradeCount() {
        this.upgradeCount++;
    }

    @Override
    public String toString() {
        return getName() + " (" + getRarity() + " " + upgradeCount + ")";
    }
}
