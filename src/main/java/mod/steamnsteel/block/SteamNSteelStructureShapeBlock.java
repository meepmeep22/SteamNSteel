/*
 * Copyright (c) 2014 Rosie Alexander and Scott Killen.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses>.
 */
package mod.steamnsteel.block;

import com.foudroyantfactotum.tool.structure.block.StructureShapeBlock;
import mod.steamnsteel.TheMod;
import mod.steamnsteel.tileentity.structure.SteamNSteelStructureShapeTE;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import static mod.steamnsteel.block.SteamNSteelStructureBlock.MIRROR;
import static net.minecraft.block.BlockDirectional.FACING;

public class SteamNSteelStructureShapeBlock extends StructureShapeBlock implements ITileEntityProvider
{
    public static final String NAME = "structureShape";

    public SteamNSteelStructureShapeBlock()
    {
        super(true);
        _DEBUG = false;
        setUnlocalizedName(NAME);
        setDefaultState(this.blockState
                .getBaseState()
                .withProperty(FACING, EnumFacing.NORTH)
                .withProperty(MIRROR, false)
        );
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, FACING, MIRROR);
    }

    protected static String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf('.') + 1);
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new SteamNSteelStructureShapeTE();
    }

    @Override
    public String getUnlocalizedName()
    {
        //noinspection StringConcatenationMissingWhitespace
        return "tile." + TheMod.RESOURCE_PREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName());
    }
}
