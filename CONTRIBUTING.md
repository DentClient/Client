# Contributing Guidelines

So, you've decided to contribute to Dent Client. Here's how.

## Code Style
Use the typical Java style, please. If you're not sure, use your IDE's `format document` function.

## Imports
Don't do this: `import net.minecraft.*;` 
Do this: `import net.minecraft.client.player;`
Because we're trying to keep this kinda lightweight.

## Adding Modules
Template for module:
```Java
public class Hack extends Module {

    public Setting setting = new Setting(this, "Setting", false);

    public Hack() {
        //name, key, category, isGhost
        super("Hack", GLFW.GLFW_KEY_H, Category.PLAYER, true);
        addSetting(setting);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        //Every Tick
    }

    @Override
    public void onEnable() {
        //Once, when enabled
        super.onEnable(); //THIS IS ESSENTIAL
    }

    @Override
    public void onDisable() {
        //Once, when disabled
        super.onDisable(); //THIS IS ESSENTIAL
    }
}
```
Make sure to call each new `Module` in `net.dent.client.module.ModuleManager`'s `loadMods()` method.

If you make multiple `Module`s at once, put them in seperate commits.

## Misc.
Please use correct grammar.
