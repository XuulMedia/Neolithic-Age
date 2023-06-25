package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.block.entity.WorkBenchBE;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;

import java.util.Optional;

import static github.xuulmedia.neolith.block.entity.ForgeBE.SLOT_COUNT;


public class WorkBenchMenu extends AbstractNeolithMenu {
    public final WorkBenchBE blockEntity;
    private final Level level;
    private final ContainerLevelAccess access;
    private final Player player;
////    private final CraftingContainer craftSlots = new TransientCraftingContainer(this, 3, 3);
////    private final ResultContainer resultSlots = new ResultContainer();
////    private  final SimpleContainer storageSlots =new SimpleContainer(9);
//    public static final int NUM_SLOTS = 19; // this must be a match with the number in the BE

    public WorkBenchMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public WorkBenchMenu(int id, Inventory inventory, BlockEntity entity) {
        super(ModMenuTypes.WORK_BENCH_MENU.get(), id);
        checkContainerSize(inventory, WorkBenchBE.SLOT_COUNT);
        blockEntity = (WorkBenchBE) entity;
        this.level = inventory.player.level();

        this.addSlot(new SlotItemHandler(blockEntity.getResultItems(), WorkBenchBE.SLOT_RESULT_COUNT, 116, 35));
        addSlotBox(blockEntity.getCraftingItems(), 3, 3, 48, 5, 18, 18);
        addSlotRange(blockEntity.getStorageItems(), 10, 8, 61, 18);

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);


        this.player = inventory.player;
        this.access = ContainerLevelAccess.NULL;




        RecipeManager recipeManager = inventory.player.level().getRecipeManager();

    }

    protected static void slotChangedCraftingGrid(AbstractContainerMenu pMenu, Level pLevel, Player pPlayer, CraftingContainer pContainer, ResultContainer pResult) {
        if (!pLevel.isClientSide) {
            ServerPlayer serverplayer = (ServerPlayer) pPlayer;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<CraftingRecipe> optional = pLevel.getServer().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, pContainer, pLevel);
            if (optional.isPresent()) {
                CraftingRecipe craftingrecipe = optional.get();
                if (pResult.setRecipeUsed(pLevel, serverplayer, craftingrecipe)) {
                    ItemStack itemstack1 = craftingrecipe.assemble(pContainer, pLevel.registryAccess());
                    if (itemstack1.isItemEnabled(pLevel.enabledFeatures())) {
                        itemstack = itemstack1;
                    }
                }
            }

            pResult.setItem(0, itemstack);
            pMenu.setRemoteSlot(0, itemstack);
            serverplayer.connection.send(new ClientboundContainerSetSlotPacket(pMenu.containerId, pMenu.incrementStateId(), 0, itemstack));
        }
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.WORK_BENCH.get());
    }


    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack resturnStack = ItemStack.EMPTY;
        Slot sourceSlot = this.slots.get(index);
        if (sourceSlot.hasItem()) {
            ItemStack sourceStack = sourceSlot.getItem();
            resturnStack = sourceStack.copy(); // need to copy

            //Check if we are clicking a mod slot or vanilla inventory
            if (index < SLOT_COUNT) {
                //This is a vanilla container so we move to the BE inventory
                if (!moveItemStackTo(sourceStack, SLOT_COUNT, Inventory.INVENTORY_SIZE + SLOT_COUNT, true)) {
                    return ItemStack.EMPTY;
                }
            }
            // This the BE Slot so we move to player inventory
            if (index < Inventory.INVENTORY_SIZE + SLOT_COUNT && !this.moveItemStackTo(sourceStack, SLOT_COUNT, 27 + SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }

            // If stack size == 0 (the entire stack was moved) set slot contents to null
            if (sourceStack.getCount() == 0) {
                sourceSlot.set(ItemStack.EMPTY);
            } else {
                sourceSlot.setChanged();
            }
            sourceSlot.onTake(playerIn, sourceStack);

        }
        return resturnStack;
    }


}
