package org.betterx.betterend.complexmaterials;

import org.betterx.bclib.api.v2.tag.*;
import org.betterx.bclib.blocks.*;
import org.betterx.bclib.recipes.GridRecipe;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.blocks.EndPedestal;
import org.betterx.betterend.blocks.FlowerPotBlock;
import org.betterx.betterend.blocks.basis.StoneLanternBlock;
import org.betterx.betterend.config.Configs;
import org.betterx.betterend.recipe.CraftingRecipes;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndItems;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

public class StoneMaterial {
    public final Block stone;

    public final Block polished;
    public final Block tiles;
    public final Block pillar;
    public final Block stairs;
    public final Block slab;
    public final Block wall;
    public final Block button;
    public final Block pressurePlate;
    public final Block pedestal;
    public final Block lantern;

    public final Block bricks;
    public final Block brickStairs;
    public final Block brickSlab;
    public final Block brickWall;
    public final Block furnace;
    public final Block flowerPot;

    public static FabricBlockSettings createMaterial(MaterialColor color) {
        return FabricBlockSettings.copyOf(Blocks.END_STONE).mapColor(color);
    }

    public StoneMaterial(String name, MaterialColor color) {
        FabricBlockSettings material = createMaterial(color);

        stone = EndBlocks.registerBlock(name, new BaseBlock(material));
        polished = EndBlocks.registerBlock(name + "_polished", new BaseBlock(material));
        tiles = EndBlocks.registerBlock(name + "_tiles", new BaseBlock(material));
        pillar = EndBlocks.registerBlock(name + "_pillar", new BaseRotatedPillarBlock(material));
        stairs = EndBlocks.registerBlock(name + "_stairs", new BaseStairsBlock(stone));
        slab = EndBlocks.registerBlock(name + "_slab", new BaseSlabBlock(stone));
        wall = EndBlocks.registerBlock(name + "_wall", new BaseWallBlock(stone));
        button = EndBlocks.registerBlock(name + "_button", new BaseStoneButtonBlock(stone));
        pressurePlate = EndBlocks.registerBlock(name + "_plate", new StonePressurePlateBlock(stone));
        pedestal = EndBlocks.registerBlock(name + "_pedestal", new EndPedestal(stone));
        lantern = EndBlocks.registerBlock(name + "_lantern", new StoneLanternBlock(stone));

        bricks = EndBlocks.registerBlock(name + "_bricks", new BaseBlock(material));
        brickStairs = EndBlocks.registerBlock(name + "_bricks_stairs", new BaseStairsBlock(bricks));
        brickSlab = EndBlocks.registerBlock(name + "_bricks_slab", new BaseSlabBlock(bricks));
        brickWall = EndBlocks.registerBlock(name + "_bricks_wall", new BaseWallBlock(bricks));
        furnace = EndBlocks.registerBlock(name + "_furnace", new BaseFurnaceBlock(bricks));
        flowerPot = EndBlocks.registerBlock(name + "_flower_pot", new FlowerPotBlock(bricks));

        // Recipes //
        GridRecipe.make(BetterEnd.MOD_ID, name + "_bricks", bricks)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(4)
                  .setShape("##", "##")
                  .addMaterial('#', stone)
                  .setGroup("end_bricks")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_polished", polished)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(4)
                  .setShape("##", "##")
                  .addMaterial('#', bricks)
                  .setGroup("end_tile")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_tiles", tiles)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(4)
                  .setShape("##", "##")
                  .addMaterial('#', polished)
                  .setGroup("end_small_tile")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_pillar", pillar)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setShape("#", "#")
                  .addMaterial('#', slab)
                  .setGroup("end_pillar")
                  .build();

        GridRecipe.make(BetterEnd.MOD_ID, name + "_stairs", stairs)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(4)
                  .setShape("#  ", "## ", "###")
                  .addMaterial('#', stone)
                  .setGroup("end_stone_stairs")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_slab", slab)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(6)
                  .setShape("###")
                  .addMaterial('#', stone)
                  .setGroup("end_stone_slabs")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_bricks_stairs", brickStairs)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(4)
                  .setShape("#  ", "## ", "###")
                  .addMaterial('#', bricks)
                  .setGroup("end_stone_stairs")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_bricks_slab", brickSlab)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(6)
                  .setShape("###")
                  .addMaterial('#', bricks)
                  .setGroup("end_stone_slabs")
                  .build();

        GridRecipe.make(BetterEnd.MOD_ID, name + "_wall", wall)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(6)
                  .setShape("###", "###")
                  .addMaterial('#', stone)
                  .setGroup("end_wall")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_bricks_wall", brickWall)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(6)
                  .setShape("###", "###")
                  .addMaterial('#', bricks)
                  .setGroup("end_wall")
                  .build();

        GridRecipe.make(BetterEnd.MOD_ID, name + "_button", button)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setList("#")
                  .addMaterial('#', stone)
                  .setGroup("end_stone_buttons")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_pressure_plate", pressurePlate)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setShape("##")
                  .addMaterial('#', stone)
                  .setGroup("end_stone_plates")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_lantern", lantern)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setShape("S", "#", "S")
                  .addMaterial('#', EndItems.CRYSTAL_SHARDS)
                  .addMaterial('S', slab, brickSlab)
                  .setGroup("end_stone_lanterns")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_furnace", furnace)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setShape("###", "# #", "###")
                  .addMaterial('#', stone)
                  .setGroup("end_stone_ITEM_FURNACES")
                  .build();
        GridRecipe.make(BetterEnd.MOD_ID, name + "_flower_pot", flowerPot)
                  .checkConfig(Configs.RECIPE_CONFIG)
                  .setOutputCount(3)
                  .setShape("# #", " # ")
                  .addMaterial('#', bricks)
                  .setGroup("end_pots")
                  .build();

        CraftingRecipes.registerPedestal(name + "_pedestal", pedestal, slab, pillar);

        // Item Tags //
        TagAPI.addItemTag(NamedItemTags.SLABS, slab, brickSlab);
        TagAPI.addItemTag(NamedItemTags.STONE_BRICKS, bricks);
        TagAPI.addItemTag(NamedItemTags.STONE_CRAFTING_MATERIALS, stone);
        TagAPI.addItemTag(NamedItemTags.STONE_TOOL_MATERIALS, stone);
        TagAPI.addItemTag(CommonItemTags.FURNACES, furnace);

        // Block Tags //
        TagAPI.addBlockTag(NamedBlockTags.STONE_BRICKS, bricks);
        TagAPI.addBlockTag(NamedBlockTags.WALLS, wall, brickWall);
        TagAPI.addBlockTag(NamedBlockTags.SLABS, slab, brickSlab);
        TagAPI.addBlockTags(pressurePlate, NamedBlockTags.PRESSURE_PLATES, NamedBlockTags.STONE_PRESSURE_PLATES);
        TagAPI.addBlockTag(CommonBlockTags.END_STONES, stone);

        TagAPI.addBlockTag(CommonBlockTags.DRAGON_IMMUNE, stone, stairs, slab, wall);

        TagAPI.addBlockTag(CommonBlockTags.END_STONES, stone);
        TagAPI.addBlockTag(CommonBlockTags.END_STONES, stone);
    }
}