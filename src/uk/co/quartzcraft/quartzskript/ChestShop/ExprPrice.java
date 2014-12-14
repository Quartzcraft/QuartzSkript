/*
 * ExprQuantity.java - Part of QuartzSkript 
 * QuartzCraft (C) QuartzCraft 2014
 * Code by nfell2009
 * 
*/

package uk.co.quartzcraft.quartzskript.ChestShop;

import javax.annotation.Nullable;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import com.Acrobot.ChestShop.Events.TransactionEvent;

public class ExprPrice extends SimpleExpression<Number> {
	 
    @Override
    public Class<? extends Number> getReturnType() {
            return Number.class;
    }

    @Override
    public boolean isSingle() {
            return true;
    }

    @Override
    public boolean init(Expression<?>[] e, int i, Kleenean kl, ParseResult pr) {
            if (!ScriptLoader.isCurrentEvent(TransactionEvent.class)) {
                    Skript.error(
                                    "Cannot use client in other events other than the transaction event",
                                    ErrorQuality.SEMANTIC_ERROR);
                    return false;
            }
            return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
            return "Returns price";
    }

    @Override
    @Nullable
    protected Number[] get(Event e) {
            return new Number[] { ((TransactionEvent) e).getPrice() };
    }

}