package github.xuulmedia.neolith.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ItemBackedContainer extends SimpleContainer {

    private static final String INVENTORY_TAG = "Items";
    private final ItemStack stackContainer;

    public ItemBackedContainer(ItemStack stack, int expectedSize) {
        super(expectedSize);
        stackContainer = stack;
        deserialize(); //restore inventory from the compound tag of the ItemStack
    }

    @Override
    public boolean stillValid(Player player) {
        return !stackContainer.isEmpty();
    }

    @Override
    public void setChanged() {
        super.setChanged();
        serialize(); //save the inventory to the compound tag of the ItemStack
    }

    public void deserialize() {
        fromTag(stackContainer.getOrCreateTag().getList(INVENTORY_TAG, Tag.TAG_COMPOUND));
    }

    public void serialize() {
        stackContainer.getOrCreateTag().put(INVENTORY_TAG, createTag());
    }

    @Override
    public void fromTag(ListTag list) {
        for (int i = 0; i < list.size(); i++) {
            CompoundTag tag = list.getCompound(i);
            int slot = tag.getInt("Slot");
            if (slot >= 0 && slot < getContainerSize()) {
                setItem(slot, ItemStack.of(tag));
            }
        }
    }

    @Override
    public ListTag createTag() {
        ListTag list = new ListTag();
        for (int i = 0; i < getContainerSize(); i++) {
            ItemStack stack = getItem(i);
            if (!stack.isEmpty()) {
                CompoundTag tag = new CompoundTag();
                tag.putInt("Slot", i);
                stack.save(tag);
                list.add(tag);
            }
        }
        return list;
    }

}