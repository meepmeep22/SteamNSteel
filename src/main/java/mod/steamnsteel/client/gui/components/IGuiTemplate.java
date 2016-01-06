package mod.steamnsteel.client.gui.components;

/**
 * Created by codew on 7/01/2016.
 */
public interface IGuiTemplate<TGuiComponent extends GuiComponent>
{
    TGuiComponent construct();

}
