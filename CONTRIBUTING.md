# Contributing Guidelines

So, you've decided to contribute to Dent Client. Here's how.

## Code Style
Use the typical Java style like this:
```Java
public static void Main(String[] args) {
    private int x = 1;
    private int y = 2;
    add(x, y);
}
//Single line comment
/*
    Multi-Line comment
*/
public int add(num1, num2) {
    return x + y;
}
```

## Imports
Don't do this: `import net.minecraft.*;` 
Do this: `import net.minecraft.client.Mouse`
Because we're trying to keep this kinda lightweight.

## Adding Modules
Template for module:
```Java
public class Hack extends Module {

    public Setting setting = new Setting(this, "Setting", false);

    public Hack() {
        //name, key, category, isGhost
        super("Hack", GLFW.GLFW_KEY_H, Category.PLAYER, true);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        //Every Tick
    }

    @Override
    public void onEnable() {
        //Once, when enabled
    }

    @Override
    public void onDisable() {
        //Once, when disabled
    }
}
```
Make sure to call in `net.dent.client.module.ModuleManager`'s `loadMods()` method.

If you make multiple `Modules` at once, put them in seperate commits.

## Misc.
SPELLCHECK YOUR STRINGS AND COMMENTS.
