//package github.xuulmedia.neolith.block.entity;
//
//import github.xuulmedia.neolith.gui.KilnMenu;
//import github.xuulmedia.neolith.init.ModBlockEntities;
//import github.xuulmedia.neolith.recipe.KilnRecipe;
//import github.xuulmedia.neolith.util.HeatingFuelContainer;
//import net.minecraft.core.BlockPos;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.items.ItemStackHandler;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.List;
//import java.util.function.IntFunction;
//
//public class KilnBlockEntity extends AbstractHeatingBlockEntity implements MenuProvider {
//
//    public static final int SLOT_FUEL = 0;
//    public static final int SLOT_INPUT0 = 1;
//    public static final int SLOT_INPUT1 = 2;
//    public static final int SLOT_INPUT2 = 3;
//    public static final int SLOT_OUTPUT0 = 4;
//    public static final int SLOT_OUTPUT1 = 5;
//
//    public KilnBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
//        super(ModBlockEntities.KILN.get(), pWorldPosition, pBlockState);
//        this.itemHandler = new ItemStackHandler(6) {
//            @Override
//            protected void onContentsChanged(int slot) {
//                setChanged();
//            }
//        };
//    }
//
//    @Override
//    protected int getFuelSlotIdx() {
//        return SLOT_FUEL;
//    }
//
//    @Nullable
//    @Override
//    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
//        return new KilnMenu(pContainerId, pInventory, this, this.data);
//    }
//
//    @Override
//    public Component getDisplayName() {
//        return Component.literal("Kiln!");
//    }
//
//    public static void tick(Level world, BlockPos pos, BlockState state, KilnBlockEntity tile) {
//        var ersatzInv = new HeatingFuelContainer(tile.itemHandler.getSlots()) {
//            @Override
//            public int getFuelSlot() {
//                return SLOT_FUEL;
//            }
//        };
//        for (int i = 0; i < tile.itemHandler.getSlots(); i++) {
//            ersatzInv.setItem(i, tile.itemHandler.getStackInSlot(i));
//        }
//
//        AbstractHeatingBlockEntity.tickHeat(world, pos, state, tile, ersatzInv);
//
//        var recman = world.getRecipeManager();
//
//        var recipeMatch = recman.getRecipeFor(KilnRecipe.Type.INSTANCE, ersatzInv, world);
//        var recipeOk = false;
//
//        if (recipeMatch.isPresent()) {
//            var recipe = recipeMatch.get();
//
//            if (recipeMatches(recipe, idx -> tile.itemHandler.getStackInSlot(KilnBlockEntity.SLOT_INPUT0 + idx))
//                && recipe.heat <= tile.heat) {
//
//                boolean outMatches = true;
////                System.out.println(recipe.outputs.size());
//                for (int i = 0; i < KilnRecipe.MAX_OUTPUTS; i++) {
//                    var stackHere = tile.itemHandler.getStackInSlot(KilnBlockEntity.SLOT_OUTPUT0 + i);
//                    ItemStack outAttempt;
//                    if (i < recipe.outputs.size()) {
//                        outAttempt = recipe.outputs.get(i);
//                    } else {
//                        outAttempt = ItemStack.EMPTY;
//                    }
//
//                    if (!stackHere.isEmpty()
//                        && (!ItemStack.isSameItemSameTags(outAttempt, stackHere)
//                        || outAttempt.getCount() + stackHere.getCount() > outAttempt.getMaxStackSize())) {
//                        outMatches = false;
//                        break;
//                    }
//                }
//                if (outMatches) {
//                    recipeOk = true;
//                }
//
//            }
//
//            if (recipeOk) {
//                tile.progress += 1;
//                if (tile.progress > tile.maxProgress) {
//                    tile.progress = 0;
//
//                    for (int i = 0; i < KilnRecipe.MAX_INPUTS; i++) {
//                        tile.itemHandler.getStackInSlot(KilnBlockEntity.SLOT_INPUT0 + i).shrink(1);
//                    }
//                    for (int i = 0; i < recipe.outputs.size(); i++) {
//                        var stackHere = tile.itemHandler.getStackInSlot(KilnBlockEntity.SLOT_OUTPUT0 + i);
//                        var outAttempt = recipe.outputs.get(i);
//                        if (stackHere.isEmpty()) {
//                            tile.itemHandler.setStackInSlot(KilnBlockEntity.SLOT_OUTPUT0 + i, outAttempt.copy());
//                        } else {
//                            stackHere.grow(outAttempt.getCount());
//                        }
//                    }
//
//                }
//            }
//        }
//
//        if (!recipeOk) {
//            tile.progress = 0;
//        }
//    }
//
//    /**
//     * Scan the input slots and get the recipe it looks like the player is trying to do.
//     * <p>
//     * The index to {@code getItem} is 0-based, 0 is the first input slot.
//     */
//    @Nullable
//    public static KilnRecipe getAttemptedRecipe(List<KilnRecipe> recipes, IntFunction<ItemStack> getItem) {
//        for (var recipe : recipes) {
//            if (recipeMatches(recipe, getItem)) {
//                return recipe;
//            }
//        }
//        return null;
//    }
//
//    public static boolean recipeMatches(KilnRecipe recipe, IntFunction<ItemStack> getItem) {
//        // Make sure each ingredient is satisfied exactly once
//        int usedBitmask = 0;
//        int satisfiedCount = 0;
//        for (var ingr : recipe.inputs) {
//            for (int i = 0; i < KilnRecipe.MAX_INPUTS; i++) {
//                if ((usedBitmask & (1 << i)) != 0) {
//                    continue;
//                }
//                var stack = getItem.apply(i);
//                if (ingr.test(stack)) {
//                    usedBitmask |= (1 << i);
//                    satisfiedCount += 1;
//                }
//            }
//        }
//        return satisfiedCount == recipe.inputs.size();
//    }
//}
