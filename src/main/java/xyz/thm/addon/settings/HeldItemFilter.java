/*
 * This file is part of THM Addons — https://github.com/Leonn170709/THM-Addons
 * Copyright (c) THM Addons contributors. Credit the devs, keep the link.
 * By using this code you agree to the license terms and to keep your repo public.
 */

package xyz.thm.addon.settings;

public enum HeldItemFilter implements DescribedOption {
    Off("Off", "Allows swaps with any main-hand item."),
    OnlyWhenHolding("Only when holding", "Allows swaps only while holding a listed item."),
    OnlyWhenNotHolding("Only when not holding", "Blocks swaps while holding a listed item.");

    private final String label;
    private final String description;

    HeldItemFilter(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public boolean allows(boolean listed) {
        return switch (this) {
            case Off -> true;
            case OnlyWhenHolding -> listed;
            case OnlyWhenNotHolding -> !listed;
        };
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public String description() {
        return description;
    }
}
