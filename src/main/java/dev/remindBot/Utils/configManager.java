package dev.remindBot.Utils;


import com.moandjiezana.toml.Toml;

import java.io.File;

public class configManager {
    private Toml toml;

    public configManager(File file) {
        this.toml = new Toml().read(file);
    }

    public Toml getToml() {
        return toml;
    }

    public void setToml(Toml toml) {
        this.toml = toml;
    }
}
