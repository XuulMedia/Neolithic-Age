       /*
         * This class is distributed as part of the Botania Mod.
         * Get the Source Code in github:
         * https://github.com/Vazkii/Botania
         *
         * Botania is Open Source and distributed under the
         * Botania License: http://botaniamod.net/license.php
         */


package xuul.flint.common.util;

       import net.minecraft.nbt.CompoundTag;
       import net.minecraft.nbt.ListTag;
       import net.minecraft.world.SimpleContainer;
       import net.minecraft.world.entity.player.Player;
       import net.minecraft.world.item.ItemStack;

       public class ItemBackedInventory extends SimpleContainer {
           private static final String TAG_ITEMS = "Items";
           private final ItemStack stack;

           public ItemBackedInventory(ItemStack stack, int expectedSize) {
               super(expectedSize);
               this.stack = stack;

               ListTag lst = getList(stack, TAG_ITEMS, 10, false);
               int i = 0;
               for (; i < expectedSize && i < lst.size(); i++) {
                   setItem(i, ItemStack.of(lst.getCompound(i)));
               }
           }

           @Override
           public boolean stillValid(Player player) {
               return !stack.isEmpty();
           }

           @Override
           public void setChanged() {
               super.setChanged();
               ListTag list = new ListTag();
               for (int i = 0; i < getContainerSize(); i++) {
                   list.add(getItem(i).save(new CompoundTag()));
               }
               setList(stack, TAG_ITEMS, list);
           }

           /*FROM Botainia ItemNBTHelper.Java*/

           public static ListTag getList(ItemStack stack, String tag, int objtype, boolean nullifyOnFail) {
               return verifyExistance(stack, tag) ? stack.getOrCreateTag().getList(tag, objtype) : nullifyOnFail ? null : new ListTag();
           }

           public static void setList(ItemStack stack, String tag, ListTag list) {
               stack.getOrCreateTag().put(tag, list);
           }

           public static boolean verifyExistance(ItemStack stack, String tag) {
               return !stack.isEmpty() && stack.hasTag() && stack.getOrCreateTag().contains(tag);
           }
       }
